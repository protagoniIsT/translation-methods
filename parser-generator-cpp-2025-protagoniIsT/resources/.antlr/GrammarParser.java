// Generated from /home/vboxuser/mt/parser-generator-cpp-2025-protagoniIsT/resources/Grammar.g4 by ANTLR 4.13.1
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, TYPE=16, NONTERM=17, 
		TERM=18, INT=19, STRING=20, LITERAL=21, CHAR_CLASS=22, BLOCK=23, WS=24;
	public static final int
		RULE_grammarSpec = 0, RULE_header = 1, RULE_pRule = 2, RULE_params = 3, 
		RULE_param = 4, RULE_rets = 5, RULE_alternative = 6, RULE_action = 7, 
		RULE_element = 8, RULE_labeledElement = 9, RULE_symbolRef = 10, RULE_callArgs = 11, 
		RULE_exprList = 12, RULE_expression = 13, RULE_additive = 14, RULE_multiplicative = 15, 
		RULE_postfix = 16, RULE_primary = 17, RULE_lRule = 18, RULE_regex = 19, 
		RULE_regexAlt = 20, RULE_regexElem = 21, RULE_regexAtom = 22, RULE_suffix = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"grammarSpec", "header", "pRule", "params", "param", "rets", "alternative", 
			"action", "element", "labeledElement", "symbolRef", "callArgs", "exprList", 
			"expression", "additive", "multiplicative", "postfix", "primary", "lRule", 
			"regex", "regexAlt", "regexElem", "regexAtom", "suffix"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@header'", "':'", "'|'", "';'", "'('", "','", "')'", "'returns'", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'.'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TYPE", "NONTERM", "TERM", "INT", "STRING", "LITERAL", 
			"CHAR_CLASS", "BLOCK", "WS"
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
	public static class GrammarSpecContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<PRuleContext> pRule() {
			return getRuleContexts(PRuleContext.class);
		}
		public PRuleContext pRule(int i) {
			return getRuleContext(PRuleContext.class,i);
		}
		public List<LRuleContext> lRule() {
			return getRuleContexts(LRuleContext.class);
		}
		public LRuleContext lRule(int i) {
			return getRuleContext(LRuleContext.class,i);
		}
		public GrammarSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarSpec; }
	}

	public final GrammarSpecContext grammarSpec() throws RecognitionException {
		GrammarSpecContext _localctx = new GrammarSpecContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammarSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(48);
				header();
				}
			}

			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(53);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NONTERM:
					{
					setState(51);
					pRule();
					}
					break;
				case TERM:
					{
					setState(52);
					lRule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NONTERM || _la==TERM );
			setState(57);
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
	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode BLOCK() { return getToken(GrammarParser.BLOCK, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(60);
			match(BLOCK);
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
	public static class PRuleContext extends ParserRuleContext {
		public TerminalNode NONTERM() { return getToken(GrammarParser.NONTERM, 0); }
		public List<AlternativeContext> alternative() {
			return getRuleContexts(AlternativeContext.class);
		}
		public AlternativeContext alternative(int i) {
			return getRuleContext(AlternativeContext.class,i);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public RetsContext rets() {
			return getRuleContext(RetsContext.class,0);
		}
		public PRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pRule; }
	}

	public final PRuleContext pRule() throws RecognitionException {
		PRuleContext _localctx = new PRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(NONTERM);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(63);
				params();
				}
			}

			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(66);
				rets();
				}
			}

			setState(69);
			match(T__1);
			setState(70);
			alternative();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(71);
				match(T__2);
				setState(72);
				alternative();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__3);
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
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(81);
			param();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(82);
				match(T__5);
				setState(83);
				param();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__6);
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
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(GrammarParser.TYPE, 0); }
		public TerminalNode NONTERM() { return getToken(GrammarParser.NONTERM, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TYPE);
			setState(92);
			match(NONTERM);
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
	public static class RetsContext extends ParserRuleContext {
		public TerminalNode BLOCK() { return getToken(GrammarParser.BLOCK, 0); }
		public RetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rets; }
	}

	public final RetsContext rets() throws RecognitionException {
		RetsContext _localctx = new RetsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rets);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__7);
			setState(95);
			match(BLOCK);
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
	public static class AlternativeContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public AlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternative; }
	}

	public final AlternativeContext alternative() throws RecognitionException {
		AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_alternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3538944L) != 0)) {
				{
				{
				setState(97);
				element();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BLOCK) {
				{
				setState(103);
				action();
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
	public static class ActionContext extends ParserRuleContext {
		public TerminalNode BLOCK() { return getToken(GrammarParser.BLOCK, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(BLOCK);
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
	public static class ElementContext extends ParserRuleContext {
		public LabeledElementContext labeledElement() {
			return getRuleContext(LabeledElementContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			labeledElement();
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
	public static class LabeledElementContext extends ParserRuleContext {
		public TerminalNode NONTERM() { return getToken(GrammarParser.NONTERM, 0); }
		public SymbolRefContext symbolRef() {
			return getRuleContext(SymbolRefContext.class,0);
		}
		public LabeledElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledElement; }
	}

	public final LabeledElementContext labeledElement() throws RecognitionException {
		LabeledElementContext _localctx = new LabeledElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_labeledElement);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(NONTERM);
				setState(111);
				match(T__8);
				setState(112);
				symbolRef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				symbolRef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolRefContext extends ParserRuleContext {
		public TerminalNode NONTERM() { return getToken(GrammarParser.NONTERM, 0); }
		public CallArgsContext callArgs() {
			return getRuleContext(CallArgsContext.class,0);
		}
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TerminalNode LITERAL() { return getToken(GrammarParser.LITERAL, 0); }
		public SymbolRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolRef; }
	}

	public final SymbolRefContext symbolRef() throws RecognitionException {
		SymbolRefContext _localctx = new SymbolRefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_symbolRef);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(NONTERM);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(117);
					callArgs();
					}
				}

				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(TERM);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(STRING);
				}
				break;
			case LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(LITERAL);
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
	public static class CallArgsContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public CallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgs; }
	}

	public final CallArgsContext callArgs() throws RecognitionException {
		CallArgsContext _localctx = new CallArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_callArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__4);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 655392L) != 0)) {
				{
				setState(126);
				exprList();
				}
			}

			setState(129);
			match(T__6);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			expression();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(132);
				match(T__5);
				setState(133);
				expression();
				}
				}
				setState(138);
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
	public static class ExpressionContext extends ParserRuleContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			additive();
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
	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_additive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			multiplicative();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(142);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				multiplicative();
				}
				}
				setState(148);
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
	public static class MultiplicativeContext extends ParserRuleContext {
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			postfix();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__12) {
				{
				{
				setState(150);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				postfix();
				}
				}
				setState(156);
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
	public static class PostfixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<CallArgsContext> callArgs() {
			return getRuleContexts(CallArgsContext.class);
		}
		public CallArgsContext callArgs(int i) {
			return getRuleContext(CallArgsContext.class,i);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			primary();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(158);
				callArgs();
				}
				}
				setState(163);
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
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode NONTERM() { return getToken(GrammarParser.NONTERM, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(NONTERM);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(INT);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(T__4);
				setState(167);
				expression();
				setState(168);
				match(T__6);
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
	public static class LRuleContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public LRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lRule; }
	}

	public final LRuleContext lRule() throws RecognitionException {
		LRuleContext _localctx = new LRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_lRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(TERM);
			setState(173);
			match(T__1);
			setState(174);
			regex();
			setState(175);
			match(T__3);
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
	public static class RegexContext extends ParserRuleContext {
		public List<RegexAltContext> regexAlt() {
			return getRuleContexts(RegexAltContext.class);
		}
		public RegexAltContext regexAlt(int i) {
			return getRuleContext(RegexAltContext.class,i);
		}
		public RegexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex; }
	}

	public final RegexContext regex() throws RecognitionException {
		RegexContext _localctx = new RegexContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_regex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			regexAlt();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(178);
				match(T__2);
				setState(179);
				regexAlt();
				}
				}
				setState(184);
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
	public static class RegexAltContext extends ParserRuleContext {
		public List<RegexElemContext> regexElem() {
			return getRuleContexts(RegexElemContext.class);
		}
		public RegexElemContext regexElem(int i) {
			return getRuleContext(RegexElemContext.class,i);
		}
		public RegexAltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexAlt; }
	}

	public final RegexAltContext regexAlt() throws RecognitionException {
		RegexAltContext _localctx = new RegexAltContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_regexAlt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185);
				regexElem();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 5259296L) != 0) );
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
	public static class RegexElemContext extends ParserRuleContext {
		public RegexAtomContext regexAtom() {
			return getRuleContext(RegexAtomContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public RegexElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexElem; }
	}

	public final RegexElemContext regexElem() throws RecognitionException {
		RegexElemContext _localctx = new RegexElemContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_regexElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			regexAtom();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 37888L) != 0)) {
				{
				setState(191);
				suffix();
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
	public static class RegexAtomContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TerminalNode CHAR_CLASS() { return getToken(GrammarParser.CHAR_CLASS, 0); }
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public RegexAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexAtom; }
	}

	public final RegexAtomContext regexAtom() throws RecognitionException {
		RegexAtomContext _localctx = new RegexAtomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_regexAtom);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(STRING);
				}
				break;
			case CHAR_CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(CHAR_CLASS);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(T__13);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(T__4);
				setState(198);
				regex();
				setState(199);
				match(T__6);
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
	public static class SuffixContext extends ParserRuleContext {
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_suffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 37888L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u00ce\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0003"+
		"\u00002\b\u0000\u0001\u0000\u0001\u0000\u0004\u00006\b\u0000\u000b\u0000"+
		"\f\u00007\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0002\u0003\u0002"+
		"D\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"J\b\u0002\n\u0002\f\u0002M\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003U\b\u0003\n\u0003\f\u0003"+
		"X\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0005\u0006c\b\u0006"+
		"\n\u0006\f\u0006f\t\u0006\u0001\u0006\u0003\u0006i\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\ts"+
		"\b\t\u0001\n\u0001\n\u0003\nw\b\n\u0001\n\u0001\n\u0001\n\u0003\n|\b\n"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u0080\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0087\b\f\n\f\f\f\u008a\t\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0091\b\u000e\n\u000e"+
		"\f\u000e\u0094\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0099\b\u000f\n\u000f\f\u000f\u009c\t\u000f\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u00a0\b\u0010\n\u0010\f\u0010\u00a3\t\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ab\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00b5\b\u0013\n\u0013\f\u0013\u00b8"+
		"\t\u0013\u0001\u0014\u0004\u0014\u00bb\b\u0014\u000b\u0014\f\u0014\u00bc"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u00c1\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u00ca\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.\u0000\u0003\u0001\u0000\n\u000b\u0001\u0000\f\r\u0003"+
		"\u0000\n\n\f\f\u000f\u000f\u00d0\u00001\u0001\u0000\u0000\u0000\u0002"+
		";\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006P\u0001"+
		"\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000"+
		"\fd\u0001\u0000\u0000\u0000\u000ej\u0001\u0000\u0000\u0000\u0010l\u0001"+
		"\u0000\u0000\u0000\u0012r\u0001\u0000\u0000\u0000\u0014{\u0001\u0000\u0000"+
		"\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u0083\u0001\u0000\u0000\u0000"+
		"\u001a\u008b\u0001\u0000\u0000\u0000\u001c\u008d\u0001\u0000\u0000\u0000"+
		"\u001e\u0095\u0001\u0000\u0000\u0000 \u009d\u0001\u0000\u0000\u0000\""+
		"\u00aa\u0001\u0000\u0000\u0000$\u00ac\u0001\u0000\u0000\u0000&\u00b1\u0001"+
		"\u0000\u0000\u0000(\u00ba\u0001\u0000\u0000\u0000*\u00be\u0001\u0000\u0000"+
		"\u0000,\u00c9\u0001\u0000\u0000\u0000.\u00cb\u0001\u0000\u0000\u00000"+
		"2\u0003\u0002\u0001\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000"+
		"\u000025\u0001\u0000\u0000\u000036\u0003\u0004\u0002\u000046\u0003$\u0012"+
		"\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009:\u0005\u0000\u0000\u0001:\u0001\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0001\u0000\u0000<=\u0005\u0017\u0000\u0000=\u0003\u0001"+
		"\u0000\u0000\u0000>@\u0005\u0011\u0000\u0000?A\u0003\u0006\u0003\u0000"+
		"@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000"+
		"\u0000BD\u0003\n\u0005\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EF\u0005\u0002\u0000\u0000FK\u0003\f\u0006"+
		"\u0000GH\u0005\u0003\u0000\u0000HJ\u0003\f\u0006\u0000IG\u0001\u0000\u0000"+
		"\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000"+
		"\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u0005"+
		"\u0004\u0000\u0000O\u0005\u0001\u0000\u0000\u0000PQ\u0005\u0005\u0000"+
		"\u0000QV\u0003\b\u0004\u0000RS\u0005\u0006\u0000\u0000SU\u0003\b\u0004"+
		"\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000YZ\u0005\u0007\u0000\u0000Z\u0007\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0010\u0000\u0000\\]\u0005\u0011\u0000\u0000]\t\u0001"+
		"\u0000\u0000\u0000^_\u0005\b\u0000\u0000_`\u0005\u0017\u0000\u0000`\u000b"+
		"\u0001\u0000\u0000\u0000ac\u0003\u0010\b\u0000ba\u0001\u0000\u0000\u0000"+
		"cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gi\u0003\u000e"+
		"\u0007\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\r\u0001"+
		"\u0000\u0000\u0000jk\u0005\u0017\u0000\u0000k\u000f\u0001\u0000\u0000"+
		"\u0000lm\u0003\u0012\t\u0000m\u0011\u0001\u0000\u0000\u0000no\u0005\u0011"+
		"\u0000\u0000op\u0005\t\u0000\u0000ps\u0003\u0014\n\u0000qs\u0003\u0014"+
		"\n\u0000rn\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000s\u0013\u0001"+
		"\u0000\u0000\u0000tv\u0005\u0011\u0000\u0000uw\u0003\u0016\u000b\u0000"+
		"vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w|\u0001\u0000\u0000"+
		"\u0000x|\u0005\u0012\u0000\u0000y|\u0005\u0014\u0000\u0000z|\u0005\u0015"+
		"\u0000\u0000{t\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u0015\u0001\u0000\u0000"+
		"\u0000}\u007f\u0005\u0005\u0000\u0000~\u0080\u0003\u0018\f\u0000\u007f"+
		"~\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0007\u0000\u0000\u0082\u0017"+
		"\u0001\u0000\u0000\u0000\u0083\u0088\u0003\u001a\r\u0000\u0084\u0085\u0005"+
		"\u0006\u0000\u0000\u0085\u0087\u0003\u001a\r\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0019\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0003\u001c"+
		"\u000e\u0000\u008c\u001b\u0001\u0000\u0000\u0000\u008d\u0092\u0003\u001e"+
		"\u000f\u0000\u008e\u008f\u0007\u0000\u0000\u0000\u008f\u0091\u0003\u001e"+
		"\u000f\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u001d\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0095\u009a\u0003 \u0010\u0000\u0096\u0097\u0007\u0001\u0000"+
		"\u0000\u0097\u0099\u0003 \u0010\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u001f\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a1\u0003\"\u0011\u0000\u009e"+
		"\u00a0\u0003\u0016\u000b\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2!\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a4\u00ab\u0005\u0011\u0000\u0000\u00a5\u00ab"+
		"\u0005\u0013\u0000\u0000\u00a6\u00a7\u0005\u0005\u0000\u0000\u00a7\u00a8"+
		"\u0003\u001a\r\u0000\u00a8\u00a9\u0005\u0007\u0000\u0000\u00a9\u00ab\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a5\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000\u0000\u0000\u00ab#\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005\u0012\u0000\u0000\u00ad\u00ae\u0005\u0002"+
		"\u0000\u0000\u00ae\u00af\u0003&\u0013\u0000\u00af\u00b0\u0005\u0004\u0000"+
		"\u0000\u00b0%\u0001\u0000\u0000\u0000\u00b1\u00b6\u0003(\u0014\u0000\u00b2"+
		"\u00b3\u0005\u0003\u0000\u0000\u00b3\u00b5\u0003(\u0014\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\'\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003"+
		"*\u0015\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd)\u0001\u0000\u0000\u0000\u00be\u00c0\u0003,\u0016\u0000"+
		"\u00bf\u00c1\u0003.\u0017\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1+\u0001\u0000\u0000\u0000\u00c2\u00ca"+
		"\u0005\u0014\u0000\u0000\u00c3\u00ca\u0005\u0016\u0000\u0000\u00c4\u00ca"+
		"\u0005\u000e\u0000\u0000\u00c5\u00c6\u0005\u0005\u0000\u0000\u00c6\u00c7"+
		"\u0003&\u0013\u0000\u00c7\u00c8\u0005\u0007\u0000\u0000\u00c8\u00ca\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c2\u0001\u0000\u0000\u0000\u00c9\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c4\u0001\u0000\u0000\u0000\u00c9\u00c5\u0001"+
		"\u0000\u0000\u0000\u00ca-\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u0002"+
		"\u0000\u0000\u00cc/\u0001\u0000\u0000\u0000\u0016157@CKVdhrv{\u007f\u0088"+
		"\u0092\u009a\u00a1\u00aa\u00b6\u00bc\u00c0\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}