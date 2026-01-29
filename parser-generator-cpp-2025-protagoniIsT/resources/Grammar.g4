grammar Grammar;

grammarSpec
    : header? (pRule | lRule)+ EOF
    ;

header
    : '@header' BLOCK
    ;

pRule
    : NONTERM params? rets? ':' alternative ('|' alternative)* ';'
    ;

params
    : '(' param (',' param)* ')'
    ;

param
    : TYPE NONTERM
    ;

rets
    : 'returns' BLOCK
    ;

alternative
    : element* action?
    ;

action
    : BLOCK
    ;

element
    : labeledElement
    ;

labeledElement
    : NONTERM '=' symbolRef
    | symbolRef
    ;

symbolRef
    : NONTERM callArgs? 
    | TERM                      
    | STRING                    
    | LITERAL
    ;

callArgs
    : '(' exprList? ')'
    ;

exprList
    : expression (',' expression)*
    ;

expression
    : additive
    ;

additive
    : multiplicative (('+'|'-') multiplicative)*
    ;

multiplicative
    : postfix (('*'|'/') postfix)*
    ;

postfix
    : primary (callArgs)*       
    ;

primary
    : NONTERM                  
    | INT
    | '(' expression ')'
    ;

lRule
    : TERM ':' regex ';'
    ;

regex
    : regexAlt ('|' regexAlt)*
    ;

regexAlt
    : regexElem+
    ;

regexElem
    : regexAtom suffix?
    ;

regexAtom
    : STRING
    | CHAR_CLASS
    | '.'
    | '(' regex ')'
    ;

suffix
    : '*'
    | '+'
    | '?'
    ;

TYPE
    : 'int'
    | 'bool'
    | 'double'
    | 'std::string'
    ;

NONTERM  : [a-z][a-zA-Z0-9_]* ;
TERM     : [A-Z][A-Z0-9_]* ;
INT      : [0-9]+ ;
STRING   : '\'' (~['\r\n])* '\'' ;
LITERAL  : '\'' .*? '\'' ;
CHAR_CLASS : '[' ~[\]]+ ']' ;

BLOCK : '{' ( BLOCK | ~[{}] )* '}' ;

WS : [ \t\r\n]+ -> skip ;
