grammar Grammar;

// Haskell-like grammar

// Parser rules
program: (funDecl | varDecl)* EOF;

funDecl: NAME '::' typeList
         NAME argList? ((guardClause)+ | '=' expr);

guardClause: '|' guard '=' expr;

guard
    : OTHERWISE
    | expr
    ;

typeList: TYPE ('->' typeList)?;

argList: NAME+;

varDecl: NAME '::' typeList;

expr: boolExpr;

boolExpr: additiveExpr (('==' | '!=' | '<' | '>' | '<=' | '>=') additiveExpr)*;

additiveExpr: mulExpr (('+' | '-') mulExpr)*;

mulExpr: atom (('*' | '/' | '%') atom)*;

exprList: expr (',' expr)*;

atom:
    '-' expr
    | INT
    | TRUE
    | FALSE
    | NAME '(' exprList? ')'
    | NAME
    | '(' expr ')'
    | IF expr THEN expr ELSE expr;


// Lexer rules
IF: 'if';
THEN: 'then';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';
OTHERWISE: 'otherwise';
NAME: [a-z_][a-zA-Z0-9_]*;
TYPE: [A-Z][a-zA-Z0-9_]*;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;
