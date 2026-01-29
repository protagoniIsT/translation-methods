// Generated from /home/vboxuser/mt/antlr-cpp-2025-protagoniIsT/resources/Grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, IF=19, THEN=20, ELSE=21, TRUE=22, FALSE=23, OTHERWISE=24, NAME=25, 
		TYPE=26, INT=27, WS=28;
	public static final int
		RULE_program = 0, RULE_funDecl = 1, RULE_guardClause = 2, RULE_guard = 3, 
		RULE_typeList = 4, RULE_argList = 5, RULE_varDecl = 6, RULE_expr = 7, 
		RULE_boolExpr = 8, RULE_additiveExpr = 9, RULE_mulExpr = 10, RULE_exprList = 11, 
		RULE_atom = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funDecl", "guardClause", "guard", "typeList", "argList", 
			"varDecl", "expr", "boolExpr", "additiveExpr", "mulExpr", "exprList", 
			"atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'::'", "'='", "'|'", "'->'", "'=='", "'!='", "'<'", "'>'", "'<='", 
			"'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "','", "'('", "')'", "'if'", 
			"'then'", "'else'", "'true'", "'false'", "'otherwise'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IF", "THEN", "ELSE", "TRUE", 
			"FALSE", "OTHERWISE", "NAME", "TYPE", "INT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<FunDeclContext> funDecl() {
			return getRuleContexts(FunDeclContext.class);
		}
		public FunDeclContext funDecl(int i) {
			return getRuleContext(FunDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				setState(28);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(26);
					funDecl();
					}
					break;
				case 2:
					{
					setState(27);
					varDecl();
					}
					break;
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunDeclContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(GrammarParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(GrammarParser.NAME, i);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public List<GuardClauseContext> guardClause() {
			return getRuleContexts(GuardClauseContext.class);
		}
		public GuardClauseContext guardClause(int i) {
			return getRuleContext(GuardClauseContext.class,i);
		}
		public FunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDecl; }
	}

	public final FunDeclContext funDecl() throws RecognitionException {
		FunDeclContext _localctx = new FunDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(NAME);
			setState(36);
			match(T__0);
			setState(37);
			typeList();
			setState(38);
			match(NAME);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(39);
				argList();
				}
			}

			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(42);
					guardClause();
					}
					}
					setState(45); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				}
				break;
			case T__1:
				{
				setState(47);
				match(T__1);
				setState(48);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardClauseContext extends ParserRuleContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GuardClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardClause; }
	}

	public final GuardClauseContext guardClause() throws RecognitionException {
		GuardClauseContext _localctx = new GuardClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_guardClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__2);
			setState(52);
			guard();
			setState(53);
			match(T__1);
			setState(54);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardContext extends ParserRuleContext {
		public TerminalNode OTHERWISE() { return getToken(GrammarParser.OTHERWISE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_guard);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OTHERWISE:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(OTHERWISE);
				}
				break;
			case T__11:
			case T__16:
			case IF:
			case TRUE:
			case FALSE:
			case NAME:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(GrammarParser.TYPE, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(TYPE);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(61);
				match(T__3);
				setState(62);
				typeList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(GrammarParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(GrammarParser.NAME, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				match(NAME);
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GrammarParser.NAME, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(NAME);
			setState(71);
			match(T__0);
			setState(72);
			typeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			boolExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ParserRuleContext {
		public List<AdditiveExprContext> additiveExpr() {
			return getRuleContexts(AdditiveExprContext.class);
		}
		public AdditiveExprContext additiveExpr(int i) {
			return getRuleContext(AdditiveExprContext.class,i);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boolExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			additiveExpr();
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2016L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(78);
					additiveExpr();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_additiveExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			mulExpr();
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(85);
					_la = _input.LA(1);
					if ( !(_la==T__10 || _la==T__11) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(86);
					mulExpr();
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mulExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			atom();
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(93);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(94);
					atom();
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			expr();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(101);
				match(T__15);
				setState(102);
				expr();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode TRUE() { return getToken(GrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GrammarParser.FALSE, 0); }
		public TerminalNode NAME() { return getToken(GrammarParser.NAME, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode THEN() { return getToken(GrammarParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(GrammarParser.ELSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(T__11);
				setState(109);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(NAME);
				setState(114);
				match(T__16);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 181014528L) != 0)) {
					{
					setState(115);
					exprList();
					}
				}

				setState(118);
				match(T__17);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(NAME);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				match(T__16);
				setState(121);
				expr();
				setState(122);
				match(T__17);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(124);
				match(IF);
				setState(125);
				expr();
				setState(126);
				match(THEN);
				setState(127);
				expr();
				setState(128);
				match(ELSE);
				setState(129);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u0086\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0005\u0000\u001d\b\u0000\n\u0000"+
		"\f\u0000 \t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0001\u0004"+
		"\u0001,\b\u0001\u000b\u0001\f\u0001-\u0001\u0001\u0001\u0001\u0003\u0001"+
		"2\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004@\b\u0004\u0001\u0005\u0004\u0005C\b\u0005\u000b"+
		"\u0005\f\u0005D\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bP\b\b\n\b\f\bS\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0005\tX\b\t\n\t\f\t[\t\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\n`\b\n\n\n\f\nc\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bh"+
		"\b\u000b\n\u000b\f\u000bk\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\fu\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0084\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0003\u0001\u0000\u0005\n"+
		"\u0001\u0000\u000b\f\u0001\u0000\r\u000f\u008c\u0000\u001e\u0001\u0000"+
		"\u0000\u0000\u0002#\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000\nB\u0001\u0000"+
		"\u0000\u0000\fF\u0001\u0000\u0000\u0000\u000eJ\u0001\u0000\u0000\u0000"+
		"\u0010L\u0001\u0000\u0000\u0000\u0012T\u0001\u0000\u0000\u0000\u0014\\"+
		"\u0001\u0000\u0000\u0000\u0016d\u0001\u0000\u0000\u0000\u0018\u0083\u0001"+
		"\u0000\u0000\u0000\u001a\u001d\u0003\u0002\u0001\u0000\u001b\u001d\u0003"+
		"\f\u0006\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001b\u0001\u0000"+
		"\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001"+
		"\u0000\u0000\u0000#$\u0005\u0019\u0000\u0000$%\u0005\u0001\u0000\u0000"+
		"%&\u0003\b\u0004\u0000&(\u0005\u0019\u0000\u0000\')\u0003\n\u0005\u0000"+
		"(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)1\u0001\u0000\u0000"+
		"\u0000*,\u0003\u0004\u0002\u0000+*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.2\u0001"+
		"\u0000\u0000\u0000/0\u0005\u0002\u0000\u000002\u0003\u000e\u0007\u0000"+
		"1+\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u00002\u0003\u0001\u0000"+
		"\u0000\u000034\u0005\u0003\u0000\u000045\u0003\u0006\u0003\u000056\u0005"+
		"\u0002\u0000\u000067\u0003\u000e\u0007\u00007\u0005\u0001\u0000\u0000"+
		"\u00008;\u0005\u0018\u0000\u00009;\u0003\u000e\u0007\u0000:8\u0001\u0000"+
		"\u0000\u0000:9\u0001\u0000\u0000\u0000;\u0007\u0001\u0000\u0000\u0000"+
		"<?\u0005\u001a\u0000\u0000=>\u0005\u0004\u0000\u0000>@\u0003\b\u0004\u0000"+
		"?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\t\u0001\u0000\u0000"+
		"\u0000AC\u0005\u0019\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u000b"+
		"\u0001\u0000\u0000\u0000FG\u0005\u0019\u0000\u0000GH\u0005\u0001\u0000"+
		"\u0000HI\u0003\b\u0004\u0000I\r\u0001\u0000\u0000\u0000JK\u0003\u0010"+
		"\b\u0000K\u000f\u0001\u0000\u0000\u0000LQ\u0003\u0012\t\u0000MN\u0007"+
		"\u0000\u0000\u0000NP\u0003\u0012\t\u0000OM\u0001\u0000\u0000\u0000PS\u0001"+
		"\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"R\u0011\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TY\u0003\u0014"+
		"\n\u0000UV\u0007\u0001\u0000\u0000VX\u0003\u0014\n\u0000WU\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\u0013\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\a\u0003\u0018\f\u0000]^\u0007\u0002\u0000\u0000^`\u0003\u0018"+
		"\f\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0015\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000di\u0003\u000e\u0007\u0000ef\u0005\u0010\u0000"+
		"\u0000fh\u0003\u000e\u0007\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000"+
		"\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0017"+
		"\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005\f\u0000\u0000"+
		"m\u0084\u0003\u000e\u0007\u0000n\u0084\u0005\u001b\u0000\u0000o\u0084"+
		"\u0005\u0016\u0000\u0000p\u0084\u0005\u0017\u0000\u0000qr\u0005\u0019"+
		"\u0000\u0000rt\u0005\u0011\u0000\u0000su\u0003\u0016\u000b\u0000ts\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u0084\u0005\u0012\u0000\u0000w\u0084\u0005\u0019\u0000\u0000xy\u0005"+
		"\u0011\u0000\u0000yz\u0003\u000e\u0007\u0000z{\u0005\u0012\u0000\u0000"+
		"{\u0084\u0001\u0000\u0000\u0000|}\u0005\u0013\u0000\u0000}~\u0003\u000e"+
		"\u0007\u0000~\u007f\u0005\u0014\u0000\u0000\u007f\u0080\u0003\u000e\u0007"+
		"\u0000\u0080\u0081\u0005\u0015\u0000\u0000\u0081\u0082\u0003\u000e\u0007"+
		"\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083l\u0001\u0000\u0000\u0000"+
		"\u0083n\u0001\u0000\u0000\u0000\u0083o\u0001\u0000\u0000\u0000\u0083p"+
		"\u0001\u0000\u0000\u0000\u0083q\u0001\u0000\u0000\u0000\u0083w\u0001\u0000"+
		"\u0000\u0000\u0083x\u0001\u0000\u0000\u0000\u0083|\u0001\u0000\u0000\u0000"+
		"\u0084\u0019\u0001\u0000\u0000\u0000\u000e\u001c\u001e(-1:?DQYait\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}