// Generated from /home/vboxuser/mt/antlr-cpp-2025-protagoniIsT/resources/Grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(GrammarParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(GrammarParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#guardClause}.
	 * @param ctx the parse tree
	 */
	void enterGuardClause(GrammarParser.GuardClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#guardClause}.
	 * @param ctx the parse tree
	 */
	void exitGuardClause(GrammarParser.GuardClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(GrammarParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(GrammarParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(GrammarParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(GrammarParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(GrammarParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(GrammarParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(GrammarParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(GrammarParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(GrammarParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(GrammarParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(GrammarParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(GrammarParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(GrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(GrammarParser.AtomContext ctx);
}