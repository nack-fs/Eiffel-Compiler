// Generated from java-escape by ANTLR 4.11.1
package parser;

	import ast.*;
	import ast.datatype.*;
	import ast.expression.*;
	import ast.stmt.*;

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
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, INT_LITERAL=51, REAL_LITERAL=52, 
		CHAR_LITERAL=53, LINE_COMMENT=54, MULTILINE_COMMENT=55, WHITESPACE=56, 
		IDENT=57;
	public static final int
		RULE_program = 0, RULE_classDef = 1, RULE_runInvoc = 2, RULE_stmts = 3, 
		RULE_stmt = 4, RULE_assigns = 5, RULE_assign = 6, RULE_procedure = 7, 
		RULE_expression = 8, RULE_args = 9, RULE_create = 10, RULE_idents = 11, 
		RULE_varsDefinitions = 12, RULE_varListDefinition = 13, RULE_varListIdents = 14, 
		RULE_fields = 15, RULE_field = 16, RULE_dataType = 17, RULE_features = 18, 
		RULE_feature = 19, RULE_params = 20, RULE_localBlock = 21, RULE_doBlock = 22, 
		RULE_returnInvoc = 23, RULE_global = 24, RULE_globalTypes = 25, RULE_varsTypes = 26, 
		RULE_deftuples = 27, RULE_deftuple = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDef", "runInvoc", "stmts", "stmt", "assigns", "assign", 
			"procedure", "expression", "args", "create", "idents", "varsDefinitions", 
			"varListDefinition", "varListIdents", "fields", "field", "dataType", 
			"features", "feature", "params", "localBlock", "doBlock", "returnInvoc", 
			"global", "globalTypes", "varsTypes", "deftuples", "deftuple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'end'", "'class'", "';'", "'run'", "'read'", "'print'", "'println'", 
			"'if'", "'then'", "'else'", "'from'", "'until'", "'loop'", "':='", "'('", 
			"')'", "'['", "']'", "'.'", "'-'", "'not'", "'to'", "'<'", "'>'", "'*'", 
			"'/'", "'mod'", "'+'", "'<='", "'>='", "'='", "'<>'", "'and'", "'or'", 
			"','", "'create'", "':'", "'INTEGER'", "'DOUBLE'", "'CHARACTER'", "'feature'", 
			"'is'", "'local'", "'do'", "'return'", "'global'", "'types'", "'vars'", 
			"'deftuple'", "'as'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT_LITERAL", "REAL_LITERAL", "CHAR_LITERAL", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE", "IDENT"
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
	public String getGrammarFileName() { return "java-escape"; }

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
		public Program ast;
		public ClassDefContext classDef;
		public GlobalContext global;
		public CreateContext create;
		public FeaturesContext features;
		public RunInvocContext runInvoc;
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public RunInvocContext runInvoc() {
			return getRuleContext(RunInvocContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
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
			setState(58);
			((ProgramContext)_localctx).classDef = classDef();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(59);
				((ProgramContext)_localctx).global = global();
				}
			}

			setState(62);
			((ProgramContext)_localctx).create = create();
			setState(63);
			((ProgramContext)_localctx).features = features();
			setState(64);
			match(T__0);
			setState(65);
			((ProgramContext)_localctx).runInvoc = runInvoc();
			setState(66);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(
					((ProgramContext)_localctx).classDef.ast, 
					(_localctx.global != null ? ((ProgramContext)_localctx).global.ast : null), 
					((ProgramContext)_localctx).create.ast, 
					((ProgramContext)_localctx).features.list,
					((ProgramContext)_localctx).runInvoc.ast
				);
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
	public static class ClassDefContext extends ParserRuleContext {
		public ClassDef ast;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__1);
			setState(70);
			((ClassDefContext)_localctx).IDENT = match(IDENT);
			setState(71);
			match(T__2);
			((ClassDefContext)_localctx).ast =  new ClassDef(((ClassDefContext)_localctx).IDENT);
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
	public static class RunInvocContext extends ParserRuleContext {
		public RunInvocation ast;
		public ProcedureContext procedure;
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public RunInvocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runInvoc; }
	}

	public final RunInvocContext runInvoc() throws RecognitionException {
		RunInvocContext _localctx = new RunInvocContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_runInvoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__3);
			setState(75);
			((RunInvocContext)_localctx).procedure = procedure();
			setState(76);
			match(T__2);
			 ((RunInvocContext)_localctx).ast =  new RunInvocation(((RunInvocContext)_localctx).procedure.ast); 
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
	public static class StmtsContext extends ParserRuleContext {
		public List<Stmt> list = new ArrayList<Stmt>();
		public StmtContext stmt;
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				((StmtsContext)_localctx).stmt = stmt();
				_localctx.list.add(((StmtsContext)_localctx).stmt.ast);
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 159912971151120864L) != 0 );
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
	public static class StmtContext extends ParserRuleContext {
		public Stmt ast;
		public ArgsContext args;
		public AssignContext assign;
		public ExpressionContext expression;
		public StmtsContext ifstmt;
		public StmtsContext elsestmt;
		public AssignsContext assigns;
		public StmtsContext stmts;
		public ProcedureContext procedure;
		public ReturnInvocContext returnInvoc;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public AssignsContext assigns() {
			return getRuleContext(AssignsContext.class,0);
		}
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public ReturnInvocContext returnInvoc() {
			return getRuleContext(ReturnInvocContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__4);
				setState(87);
				((StmtContext)_localctx).args = args();
				setState(88);
				match(T__2);
				((StmtContext)_localctx).ast =  new ReadStmt((((StmtContext)_localctx).args.list != null ? ((StmtContext)_localctx).args.list : new ArrayList<>()));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(91);
				match(T__5);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0) {
					{
					setState(92);
					((StmtContext)_localctx).args = args();
					}
				}

				setState(95);
				match(T__2);
				((StmtContext)_localctx).ast =  new PrintStmt((_localctx.args != null ? ((StmtContext)_localctx).args.list : new ArrayList<>()), "");
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(97);
				match(T__6);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0) {
					{
					setState(98);
					((StmtContext)_localctx).args = args();
					}
				}

				setState(101);
				match(T__2);
				((StmtContext)_localctx).ast =  new PrintStmt((_localctx.args != null ? ((StmtContext)_localctx).args.list : new ArrayList<>()), "ln");
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				((StmtContext)_localctx).assign = assign();
				((StmtContext)_localctx).ast =  new AssignStmt(((StmtContext)_localctx).assign.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				match(T__7);
				setState(107);
				((StmtContext)_localctx).expression = expression(0);
				setState(108);
				match(T__8);
				setState(109);
				((StmtContext)_localctx).ifstmt = stmts();
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(110);
					match(T__9);
					setState(111);
					((StmtContext)_localctx).elsestmt = stmts();
					}
				}

				setState(114);
				match(T__0);
				 ((StmtContext)_localctx).ast =  new IfStmt(
						((StmtContext)_localctx).expression.ast,
						((StmtContext)_localctx).ifstmt.list, 
						(_localctx.elsestmt != null ? ((StmtContext)_localctx).elsestmt.list : new ArrayList<>())
					);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(117);
					match(T__10);
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0) {
						{
						setState(118);
						((StmtContext)_localctx).assigns = assigns();
						}
					}

					}
				}

				setState(123);
				match(T__11);
				setState(124);
				((StmtContext)_localctx).expression = expression(0);
				setState(125);
				match(T__12);
				setState(126);
				((StmtContext)_localctx).stmts = stmts();
				setState(127);
				match(T__0);
				 ((StmtContext)_localctx).ast =  new FromStmt(
						(_localctx.assigns != null ? ((StmtContext)_localctx).assigns.list : new ArrayList<>()), 
						((StmtContext)_localctx).expression.ast, 
						((StmtContext)_localctx).stmts.list
					);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				((StmtContext)_localctx).procedure = procedure();
				setState(131);
				match(T__2);
				((StmtContext)_localctx).ast =  new ProcedureStmt(((StmtContext)_localctx).procedure.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(134);
				((StmtContext)_localctx).returnInvoc = returnInvoc();
				((StmtContext)_localctx).ast =  new ReturnStmt(((StmtContext)_localctx).returnInvoc.ast);
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
	public static class AssignsContext extends ParserRuleContext {
		public List<Assignment> list = new ArrayList<Assignment>();
		public AssignContext assign;
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public AssignsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigns; }
	}

	public final AssignsContext assigns() throws RecognitionException {
		AssignsContext _localctx = new AssignsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assigns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				((AssignsContext)_localctx).assign = assign();
				_localctx.list.add(((AssignsContext)_localctx).assign.ast);
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0 );
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
	public static class AssignContext extends ParserRuleContext {
		public Assignment ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((AssignContext)_localctx).left = expression(0);
			setState(147);
			match(T__13);
			setState(148);
			((AssignContext)_localctx).right = expression(0);
			setState(149);
			match(T__2);
			 ((AssignContext)_localctx).ast =  new Assignment(
					((AssignContext)_localctx).left.ast, 
					((AssignContext)_localctx).right.ast
				);
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
	public static class ProcedureContext extends ParserRuleContext {
		public Procedure ast;
		public Token IDENT;
		public Token op;
		public ArgsContext args;
		public Token cp;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((ProcedureContext)_localctx).IDENT = match(IDENT);
			setState(153);
			((ProcedureContext)_localctx).op = match(T__14);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0) {
				{
				setState(154);
				((ProcedureContext)_localctx).args = args();
				}
			}

			setState(157);
			((ProcedureContext)_localctx).cp = match(T__15);
			 ((ProcedureContext)_localctx).ast =  new Procedure(
					(((ProcedureContext)_localctx).IDENT!=null?((ProcedureContext)_localctx).IDENT.getText():null), 
					(_localctx.args != null ? ((ProcedureContext)_localctx).args.list : new ArrayList<>())
				);
				_localctx.ast.updatePositions(((ProcedureContext)_localctx).IDENT,((ProcedureContext)_localctx).op,(_localctx.args != null ? ((ProcedureContext)_localctx).args.list : null),((ProcedureContext)_localctx).cp);
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
		public Expression ast;
		public ExpressionContext exprArray;
		public ExpressionContext expStruct;
		public ExpressionContext left;
		public Token value;
		public Token name;
		public ProcedureContext procedure;
		public ExpressionContext expression;
		public DataTypeContext dataType;
		public Token operator;
		public ExpressionContext right;
		public ExpressionContext index;
		public Token IDENT;
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(GrammarParser.REAL_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(GrammarParser.CHAR_LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(161);
				((ExpressionContext)_localctx).value = match(INT_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).value); 
				}
				break;
			case 2:
				{
				setState(163);
				((ExpressionContext)_localctx).value = match(REAL_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).value); 
				}
				break;
			case 3:
				{
				setState(165);
				((ExpressionContext)_localctx).value = match(CHAR_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).value); 
				}
				break;
			case 4:
				{
				setState(167);
				((ExpressionContext)_localctx).name = match(IDENT);
				 ((ExpressionContext)_localctx).ast =  new Variable((((ExpressionContext)_localctx).name!=null?((ExpressionContext)_localctx).name.getText():null)); _localctx.ast.updatePositions(((ExpressionContext)_localctx).name);
				}
				break;
			case 5:
				{
				setState(169);
				((ExpressionContext)_localctx).procedure = procedure();
				 ((ExpressionContext)_localctx).ast =  new ProcedureExpression(((ExpressionContext)_localctx).procedure.ast); 
				}
				break;
			case 6:
				{
				setState(172);
				match(T__19);
				setState(173);
				((ExpressionContext)_localctx).expression = expression(10);
				 ((ExpressionContext)_localctx).ast =  new MinusExpression(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 7:
				{
				setState(176);
				match(T__14);
				setState(177);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(178);
				match(T__15);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				}
				break;
			case 8:
				{
				setState(181);
				match(T__20);
				setState(182);
				((ExpressionContext)_localctx).expression = expression(8);
				 ((ExpressionContext)_localctx).ast =  new NotExpression(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 9:
				{
				setState(185);
				match(T__21);
				setState(186);
				match(T__22);
				setState(187);
				((ExpressionContext)_localctx).dataType = dataType();
				setState(188);
				match(T__23);
				setState(189);
				match(T__14);
				setState(190);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(191);
				match(T__15);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).dataType.ast, ((ExpressionContext)_localctx).expression.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(236);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(197);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__27) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(203);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(6);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(207);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1635778560L) != 0) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(208);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(5);
						 ((ExpressionContext)_localctx).ast =  new ComparisonExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(212);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(213);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(4);
						 ((ExpressionContext)_localctx).ast =  new ComparisonExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(217);
						((ExpressionContext)_localctx).operator = match(T__32);
						setState(218);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(3);
						 ((ExpressionContext)_localctx).ast =  new LogicExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(222);
						((ExpressionContext)_localctx).operator = match(T__33);
						setState(223);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(2);
						 ((ExpressionContext)_localctx).ast =  new LogicExpression(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).operator!=null?((ExpressionContext)_localctx).operator.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exprArray = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(227);
						match(T__16);
						setState(228);
						((ExpressionContext)_localctx).index = ((ExpressionContext)_localctx).expression = expression(0);
						setState(229);
						match(T__17);
						 ((ExpressionContext)_localctx).ast =  new ArrayExpression(((ExpressionContext)_localctx).exprArray.ast, ((ExpressionContext)_localctx).index.ast); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expStruct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(233);
						match(T__18);
						setState(234);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						 ((ExpressionContext)_localctx).ast =  new StructExpression(((ExpressionContext)_localctx).expStruct.ast, ((ExpressionContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			((ArgsContext)_localctx).expression = expression(0);
			_localctx.list.add(((ArgsContext)_localctx).expression.ast);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(243);
				match(T__34);
				setState(244);
				((ArgsContext)_localctx).expression = expression(0);
				_localctx.list.add(((ArgsContext)_localctx).expression.ast);
				}
				}
				setState(251);
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
	public static class CreateContext extends ParserRuleContext {
		public Create ast;
		public Token c;
		public IdentsContext idents;
		public IdentsContext idents() {
			return getRuleContext(IdentsContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			((CreateContext)_localctx).c = match(T__35);
			setState(253);
			((CreateContext)_localctx).idents = idents();
			((CreateContext)_localctx).ast =  new Create(((CreateContext)_localctx).idents.list ); _localctx.ast.updatePositions(((CreateContext)_localctx).c,((CreateContext)_localctx).idents.list);
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
	public static class IdentsContext extends ParserRuleContext {
		public List<String> list = new ArrayList<String>();
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public IdentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idents; }
	}

	public final IdentsContext idents() throws RecognitionException {
		IdentsContext _localctx = new IdentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_idents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(256);
				((IdentsContext)_localctx).IDENT = match(IDENT);
				setState(257);
				match(T__2);
				_localctx.list.add((((IdentsContext)_localctx).IDENT!=null?((IdentsContext)_localctx).IDENT.getText():null));
				}
				}
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
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
	public static class VarsDefinitionsContext extends ParserRuleContext {
		public List<VarDefinition> list = new ArrayList<VarDefinition>();
		public VarListDefinitionContext varListDefinition;
		public List<VarListDefinitionContext> varListDefinition() {
			return getRuleContexts(VarListDefinitionContext.class);
		}
		public VarListDefinitionContext varListDefinition(int i) {
			return getRuleContext(VarListDefinitionContext.class,i);
		}
		public VarsDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsDefinitions; }
	}

	public final VarsDefinitionsContext varsDefinitions() throws RecognitionException {
		VarsDefinitionsContext _localctx = new VarsDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varsDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(263);
				((VarsDefinitionsContext)_localctx).varListDefinition = varListDefinition();
				 _localctx.list.addAll(((VarsDefinitionsContext)_localctx).varListDefinition.list);
				}
				}
				setState(270);
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
	public static class VarListDefinitionContext extends ParserRuleContext {
		public List<VarDefinition> list = new ArrayList<VarDefinition>();
		public VarListIdentsContext varListIdents;
		public DataTypeContext dataType;
		public VarListIdentsContext varListIdents() {
			return getRuleContext(VarListIdentsContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public VarListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varListDefinition; }
	}

	public final VarListDefinitionContext varListDefinition() throws RecognitionException {
		VarListDefinitionContext _localctx = new VarListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varListDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			((VarListDefinitionContext)_localctx).varListIdents = varListIdents();
			setState(272);
			match(T__36);
			setState(273);
			((VarListDefinitionContext)_localctx).dataType = dataType();
			setState(274);
			match(T__2);
			 for (int i = 0; i < ((VarListDefinitionContext)_localctx).varListIdents.list.size(); i++) _localctx.list.add(
				  new VarDefinition(((VarListDefinitionContext)_localctx).varListIdents.list.get(i),((VarListDefinitionContext)_localctx).dataType.ast)
				  );
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
	public static class VarListIdentsContext extends ParserRuleContext {
		public List<String> list = new ArrayList<>();
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public VarListIdentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varListIdents; }
	}

	public final VarListIdentsContext varListIdents() throws RecognitionException {
		VarListIdentsContext _localctx = new VarListIdentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varListIdents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(277);
			((VarListIdentsContext)_localctx).IDENT = match(IDENT);
			_localctx.list.add((((VarListIdentsContext)_localctx).IDENT!=null?((VarListIdentsContext)_localctx).IDENT.getText():null));
			}
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(280);
				match(T__34);
				setState(281);
				((VarListIdentsContext)_localctx).IDENT = match(IDENT);
				_localctx.list.add((((VarListIdentsContext)_localctx).IDENT!=null?((VarListIdentsContext)_localctx).IDENT.getText():null));
				}
				}
				setState(287);
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
	public static class FieldsContext extends ParserRuleContext {
		public List<Field> list = new ArrayList<>();
		public FieldContext field;
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(288);
				((FieldsContext)_localctx).field = field();
				_localctx.list.add(((FieldsContext)_localctx).field.ast);
				}
				}
				setState(295);
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
	public static class FieldContext extends ParserRuleContext {
		public Field ast;
		public Token IDENT;
		public DataTypeContext dataType;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			((FieldContext)_localctx).IDENT = match(IDENT);
			setState(297);
			match(T__36);
			setState(298);
			((FieldContext)_localctx).dataType = dataType();
			setState(299);
			match(T__2);
			((FieldContext)_localctx).ast =  new Field((((FieldContext)_localctx).IDENT!=null?((FieldContext)_localctx).IDENT.getText():null), ((FieldContext)_localctx).dataType.ast);
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
	public static class DataTypeContext extends ParserRuleContext {
		public DataType ast;
		public Token intType;
		public Token doubleType;
		public Token characterType;
		public Token name;
		public Token INT_LITERAL;
		public DataTypeContext dataType;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_dataType);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				((DataTypeContext)_localctx).intType = match(T__37);
				((DataTypeContext)_localctx).ast =  new IntegerType(); _localctx.ast.updatePositions(((DataTypeContext)_localctx).intType);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				((DataTypeContext)_localctx).doubleType = match(T__38);
				((DataTypeContext)_localctx).ast =  new DoubleType(); _localctx.ast.updatePositions(((DataTypeContext)_localctx).doubleType);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				((DataTypeContext)_localctx).characterType = match(T__39);
				((DataTypeContext)_localctx).ast =  new CharacterType(); _localctx.ast.updatePositions(((DataTypeContext)_localctx).characterType);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				((DataTypeContext)_localctx).name = match(IDENT);
				((DataTypeContext)_localctx).ast =  new StructType(((DataTypeContext)_localctx).name);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(T__16);
				setState(311);
				((DataTypeContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				setState(312);
				match(T__17);
				setState(313);
				((DataTypeContext)_localctx).dataType = dataType();
				((DataTypeContext)_localctx).ast =  new ArrayType((((DataTypeContext)_localctx).INT_LITERAL!=null?((DataTypeContext)_localctx).INT_LITERAL.getText():null), ((DataTypeContext)_localctx).dataType.ast);
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
	public static class FeaturesContext extends ParserRuleContext {
		public List<Feature> list = new ArrayList<Feature>();
		public FeatureContext feature;
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public FeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_features; }
	}

	public final FeaturesContext features() throws RecognitionException {
		FeaturesContext _localctx = new FeaturesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(318);
				((FeaturesContext)_localctx).feature = feature();
				_localctx.list.add(((FeaturesContext)_localctx).feature.ast);
				}
				}
				setState(323); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__40 );
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
	public static class FeatureContext extends ParserRuleContext {
		public Feature ast;
		public Token IDENT;
		public ParamsContext params;
		public DataTypeContext dataType;
		public LocalBlockContext localBlock;
		public DoBlockContext doBlock;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DoBlockContext doBlock() {
			return getRuleContext(DoBlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public LocalBlockContext localBlock() {
			return getRuleContext(LocalBlockContext.class,0);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_feature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(T__40);
			setState(326);
			((FeatureContext)_localctx).IDENT = match(IDENT);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(327);
				((FeatureContext)_localctx).params = params();
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(330);
				match(T__36);
				setState(331);
				((FeatureContext)_localctx).dataType = dataType();
				}
			}

			setState(334);
			match(T__41);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__42) {
				{
				setState(335);
				((FeatureContext)_localctx).localBlock = localBlock();
				}
			}

			setState(338);
			((FeatureContext)_localctx).doBlock = doBlock();
			setState(339);
			match(T__0);
			((FeatureContext)_localctx).ast =  new Feature(
					(((FeatureContext)_localctx).IDENT!=null?((FeatureContext)_localctx).IDENT.getText():null), 
					(_localctx.params != null ? ((FeatureContext)_localctx).params.list : new ArrayList<>()),  
					(_localctx.dataType != null ? ((FeatureContext)_localctx).dataType.ast : null), 
					(_localctx.localBlock != null ? ((FeatureContext)_localctx).localBlock.ast : null),
					((FeatureContext)_localctx).doBlock.ast
				) ;
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
		public List<VarDefinition> list = new ArrayList<VarDefinition>();
		public Token IDENT;
		public DataTypeContext dataType;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(T__14);
			setState(343);
			((ParamsContext)_localctx).IDENT = match(IDENT);
			setState(344);
			match(T__36);
			setState(345);
			((ParamsContext)_localctx).dataType = dataType();
			_localctx.list.add(new VarDefinition(((ParamsContext)_localctx).IDENT,((ParamsContext)_localctx).dataType.ast));
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__34) {
				{
				{
				setState(347);
				match(T__34);
				setState(348);
				((ParamsContext)_localctx).IDENT = match(IDENT);
				setState(349);
				match(T__36);
				setState(350);
				((ParamsContext)_localctx).dataType = dataType();
				_localctx.list.add(new VarDefinition(((ParamsContext)_localctx).IDENT,((ParamsContext)_localctx).dataType.ast));
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
			match(T__15);
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
	public static class LocalBlockContext extends ParserRuleContext {
		public LocalBlock ast;
		public VarsDefinitionsContext varsDefinitions;
		public VarsDefinitionsContext varsDefinitions() {
			return getRuleContext(VarsDefinitionsContext.class,0);
		}
		public LocalBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localBlock; }
	}

	public final LocalBlockContext localBlock() throws RecognitionException {
		LocalBlockContext _localctx = new LocalBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_localBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__42);
			setState(361);
			((LocalBlockContext)_localctx).varsDefinitions = varsDefinitions();
			((LocalBlockContext)_localctx).ast =  new LocalBlock(
					(_localctx.varsDefinitions != null ? ((LocalBlockContext)_localctx).varsDefinitions.list : new ArrayList<>())
				);
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
	public static class DoBlockContext extends ParserRuleContext {
		public DoBlock ast;
		public StmtsContext stmts;
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public DoBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doBlock; }
	}

	public final DoBlockContext doBlock() throws RecognitionException {
		DoBlockContext _localctx = new DoBlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(T__43);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159912971151120864L) != 0) {
				{
				setState(365);
				((DoBlockContext)_localctx).stmts = stmts();
				}
			}

			((DoBlockContext)_localctx).ast =  new DoBlock(
					(_localctx.stmts != null ? ((DoBlockContext)_localctx).stmts.list : new ArrayList<>())
				);
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
	public static class ReturnInvocContext extends ParserRuleContext {
		public ReturnInvoc ast;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnInvocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnInvoc; }
	}

	public final ReturnInvocContext returnInvoc() throws RecognitionException {
		ReturnInvocContext _localctx = new ReturnInvocContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnInvoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__44);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 159877786779025408L) != 0) {
				{
				setState(371);
				((ReturnInvocContext)_localctx).expression = expression(0);
				}
			}

			setState(374);
			match(T__2);
			((ReturnInvocContext)_localctx).ast =  new ReturnInvoc(
					(_localctx.expression != null ? ((ReturnInvocContext)_localctx).expression.ast : null)
				);
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
	public static class GlobalContext extends ParserRuleContext {
		public Global ast;
		public GlobalTypesContext globalTypes;
		public VarsTypesContext varsTypes;
		public GlobalTypesContext globalTypes() {
			return getRuleContext(GlobalTypesContext.class,0);
		}
		public VarsTypesContext varsTypes() {
			return getRuleContext(VarsTypesContext.class,0);
		}
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(T__45);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(378);
				((GlobalContext)_localctx).globalTypes = globalTypes();
				}
			}

			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__47) {
				{
				setState(381);
				((GlobalContext)_localctx).varsTypes = varsTypes();
				}
			}

			((GlobalContext)_localctx).ast =  new Global(
					(_localctx.globalTypes != null ? ((GlobalContext)_localctx).globalTypes.ast : null),
					(_localctx.varsTypes != null ? ((GlobalContext)_localctx).varsTypes.ast : null)
				);
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
	public static class GlobalTypesContext extends ParserRuleContext {
		public GlobalTypes ast;
		public DeftuplesContext deftuples;
		public DeftuplesContext deftuples() {
			return getRuleContext(DeftuplesContext.class,0);
		}
		public GlobalTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalTypes; }
	}

	public final GlobalTypesContext globalTypes() throws RecognitionException {
		GlobalTypesContext _localctx = new GlobalTypesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_globalTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(T__46);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__48) {
				{
				setState(387);
				((GlobalTypesContext)_localctx).deftuples = deftuples();
				}
			}

			((GlobalTypesContext)_localctx).ast =  new GlobalTypes(
					(_localctx.deftuples != null ? ((GlobalTypesContext)_localctx).deftuples.list : new ArrayList<>())
				);
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
	public static class VarsTypesContext extends ParserRuleContext {
		public VarsTypes ast;
		public VarsDefinitionsContext varsDefinitions;
		public VarsDefinitionsContext varsDefinitions() {
			return getRuleContext(VarsDefinitionsContext.class,0);
		}
		public VarsTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsTypes; }
	}

	public final VarsTypesContext varsTypes() throws RecognitionException {
		VarsTypesContext _localctx = new VarsTypesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_varsTypes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(T__47);
			setState(393);
			((VarsTypesContext)_localctx).varsDefinitions = varsDefinitions();
			((VarsTypesContext)_localctx).ast =  new VarsTypes(
					(_localctx.varsDefinitions != null ? ((VarsTypesContext)_localctx).varsDefinitions.list : new ArrayList<>())
				);
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
	public static class DeftuplesContext extends ParserRuleContext {
		public List<Deftuple> list = new ArrayList<Deftuple>();
		public DeftupleContext deftuple;
		public List<DeftupleContext> deftuple() {
			return getRuleContexts(DeftupleContext.class);
		}
		public DeftupleContext deftuple(int i) {
			return getRuleContext(DeftupleContext.class,i);
		}
		public DeftuplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deftuples; }
	}

	public final DeftuplesContext deftuples() throws RecognitionException {
		DeftuplesContext _localctx = new DeftuplesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_deftuples);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(396);
				((DeftuplesContext)_localctx).deftuple = deftuple();
				_localctx.list.add(((DeftuplesContext)_localctx).deftuple.ast);
				}
				}
				setState(401); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__48 );
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
	public static class DeftupleContext extends ParserRuleContext {
		public Deftuple ast;
		public Token IDENT;
		public FieldsContext fields;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public DeftupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deftuple; }
	}

	public final DeftupleContext deftuple() throws RecognitionException {
		DeftupleContext _localctx = new DeftupleContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_deftuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(T__48);
			setState(404);
			((DeftupleContext)_localctx).IDENT = match(IDENT);
			setState(405);
			match(T__49);
			setState(406);
			((DeftupleContext)_localctx).fields = fields();
			setState(407);
			match(T__0);
			((DeftupleContext)_localctx).ast =  new Deftuple(
					(((DeftupleContext)_localctx).IDENT!=null?((DeftupleContext)_localctx).IDENT.getText():null), 
					(_localctx.fields != null ? ((DeftupleContext)_localctx).fields.list : new ArrayList<>())
				);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u019b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0003\u0000=\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003S\b\u0003\u000b\u0003\f\u0003T\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004^\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004d\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004q\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004x\b\u0004\u0003\u0004z\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u008a\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005\u008f\b\u0005\u000b\u0005\f\u0005\u0090\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u009c\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u00c3\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00ed\b\b\n"+
		"\b\f\b\u00f0\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00f8\b\t\n\t\f\t\u00fb\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0004\u000b\u0104\b\u000b\u000b\u000b\f\u000b"+
		"\u0105\u0001\f\u0001\f\u0001\f\u0005\f\u010b\b\f\n\f\f\f\u010e\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u011c\b\u000e\n"+
		"\u000e\f\u000e\u011f\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u0124\b\u000f\n\u000f\f\u000f\u0127\t\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u013d\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0004\u0012"+
		"\u0142\b\u0012\u000b\u0012\f\u0012\u0143\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0149\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u014d"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0151\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0162\b\u0014\n\u0014\f\u0014\u0165"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u016f\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0175\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u017c\b\u0018\u0001"+
		"\u0018\u0003\u0018\u017f\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0185\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0004"+
		"\u001b\u0190\b\u001b\u000b\u001b\f\u001b\u0191\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0000\u0001\u0010\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0004\u0001\u0000"+
		"\u0019\u001b\u0002\u0000\u0014\u0014\u001c\u001c\u0002\u0000\u0017\u0018"+
		"\u001d\u001e\u0001\u0000\u001f \u01b1\u0000:\u0001\u0000\u0000\u0000\u0002"+
		"E\u0001\u0000\u0000\u0000\u0004J\u0001\u0000\u0000\u0000\u0006R\u0001"+
		"\u0000\u0000\u0000\b\u0089\u0001\u0000\u0000\u0000\n\u008e\u0001\u0000"+
		"\u0000\u0000\f\u0092\u0001\u0000\u0000\u0000\u000e\u0098\u0001\u0000\u0000"+
		"\u0000\u0010\u00c2\u0001\u0000\u0000\u0000\u0012\u00f1\u0001\u0000\u0000"+
		"\u0000\u0014\u00fc\u0001\u0000\u0000\u0000\u0016\u0103\u0001\u0000\u0000"+
		"\u0000\u0018\u010c\u0001\u0000\u0000\u0000\u001a\u010f\u0001\u0000\u0000"+
		"\u0000\u001c\u0115\u0001\u0000\u0000\u0000\u001e\u0125\u0001\u0000\u0000"+
		"\u0000 \u0128\u0001\u0000\u0000\u0000\"\u013c\u0001\u0000\u0000\u0000"+
		"$\u0141\u0001\u0000\u0000\u0000&\u0145\u0001\u0000\u0000\u0000(\u0156"+
		"\u0001\u0000\u0000\u0000*\u0168\u0001\u0000\u0000\u0000,\u016c\u0001\u0000"+
		"\u0000\u0000.\u0172\u0001\u0000\u0000\u00000\u0179\u0001\u0000\u0000\u0000"+
		"2\u0182\u0001\u0000\u0000\u00004\u0188\u0001\u0000\u0000\u00006\u018f"+
		"\u0001\u0000\u0000\u00008\u0193\u0001\u0000\u0000\u0000:<\u0003\u0002"+
		"\u0001\u0000;=\u00030\u0018\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0003\u0014\n\u0000?@\u0003$"+
		"\u0012\u0000@A\u0005\u0001\u0000\u0000AB\u0003\u0004\u0002\u0000BC\u0005"+
		"\u0000\u0000\u0001CD\u0006\u0000\uffff\uffff\u0000D\u0001\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0002\u0000\u0000FG\u00059\u0000\u0000GH\u0005\u0003"+
		"\u0000\u0000HI\u0006\u0001\uffff\uffff\u0000I\u0003\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0004\u0000\u0000KL\u0003\u000e\u0007\u0000LM\u0005\u0003"+
		"\u0000\u0000MN\u0006\u0002\uffff\uffff\u0000N\u0005\u0001\u0000\u0000"+
		"\u0000OP\u0003\b\u0004\u0000PQ\u0006\u0003\uffff\uffff\u0000QS\u0001\u0000"+
		"\u0000\u0000RO\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0007\u0001\u0000\u0000"+
		"\u0000VW\u0005\u0005\u0000\u0000WX\u0003\u0012\t\u0000XY\u0005\u0003\u0000"+
		"\u0000YZ\u0006\u0004\uffff\uffff\u0000Z\u008a\u0001\u0000\u0000\u0000"+
		"[]\u0005\u0006\u0000\u0000\\^\u0003\u0012\t\u0000]\\\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0003"+
		"\u0000\u0000`\u008a\u0006\u0004\uffff\uffff\u0000ac\u0005\u0007\u0000"+
		"\u0000bd\u0003\u0012\t\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000ef\u0005\u0003\u0000\u0000f\u008a\u0006"+
		"\u0004\uffff\uffff\u0000gh\u0003\f\u0006\u0000hi\u0006\u0004\uffff\uffff"+
		"\u0000i\u008a\u0001\u0000\u0000\u0000jk\u0005\b\u0000\u0000kl\u0003\u0010"+
		"\b\u0000lm\u0005\t\u0000\u0000mp\u0003\u0006\u0003\u0000no\u0005\n\u0000"+
		"\u0000oq\u0003\u0006\u0003\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0005\u0001\u0000\u0000st\u0006"+
		"\u0004\uffff\uffff\u0000t\u008a\u0001\u0000\u0000\u0000uw\u0005\u000b"+
		"\u0000\u0000vx\u0003\n\u0005\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xz\u0001\u0000\u0000\u0000yu\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005\f\u0000\u0000|}\u0003"+
		"\u0010\b\u0000}~\u0005\r\u0000\u0000~\u007f\u0003\u0006\u0003\u0000\u007f"+
		"\u0080\u0005\u0001\u0000\u0000\u0080\u0081\u0006\u0004\uffff\uffff\u0000"+
		"\u0081\u008a\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u000e\u0007\u0000"+
		"\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u0085\u0006\u0004\uffff\uffff"+
		"\u0000\u0085\u008a\u0001\u0000\u0000\u0000\u0086\u0087\u0003.\u0017\u0000"+
		"\u0087\u0088\u0006\u0004\uffff\uffff\u0000\u0088\u008a\u0001\u0000\u0000"+
		"\u0000\u0089V\u0001\u0000\u0000\u0000\u0089[\u0001\u0000\u0000\u0000\u0089"+
		"a\u0001\u0000\u0000\u0000\u0089g\u0001\u0000\u0000\u0000\u0089j\u0001"+
		"\u0000\u0000\u0000\u0089y\u0001\u0000\u0000\u0000\u0089\u0082\u0001\u0000"+
		"\u0000\u0000\u0089\u0086\u0001\u0000\u0000\u0000\u008a\t\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0003\f\u0006\u0000\u008c\u008d\u0006\u0005\uffff\uffff"+
		"\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u000b\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0003\u0010\b\u0000\u0093\u0094\u0005\u000e\u0000\u0000"+
		"\u0094\u0095\u0003\u0010\b\u0000\u0095\u0096\u0005\u0003\u0000\u0000\u0096"+
		"\u0097\u0006\u0006\uffff\uffff\u0000\u0097\r\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u00059\u0000\u0000\u0099\u009b\u0005\u000f\u0000\u0000\u009a\u009c"+
		"\u0003\u0012\t\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\u0010\u0000\u0000\u009e\u009f\u0006\u0007\uffff\uffff\u0000\u009f\u000f"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006\b\uffff\uffff\u0000\u00a1\u00a2"+
		"\u00053\u0000\u0000\u00a2\u00c3\u0006\b\uffff\uffff\u0000\u00a3\u00a4"+
		"\u00054\u0000\u0000\u00a4\u00c3\u0006\b\uffff\uffff\u0000\u00a5\u00a6"+
		"\u00055\u0000\u0000\u00a6\u00c3\u0006\b\uffff\uffff\u0000\u00a7\u00a8"+
		"\u00059\u0000\u0000\u00a8\u00c3\u0006\b\uffff\uffff\u0000\u00a9\u00aa"+
		"\u0003\u000e\u0007\u0000\u00aa\u00ab\u0006\b\uffff\uffff\u0000\u00ab\u00c3"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u0014\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0010\b\n\u00ae\u00af\u0006\b\uffff\uffff\u0000\u00af\u00c3\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\u000f\u0000\u0000\u00b1\u00b2\u0003"+
		"\u0010\b\u0000\u00b2\u00b3\u0005\u0010\u0000\u0000\u00b3\u00b4\u0006\b"+
		"\uffff\uffff\u0000\u00b4\u00c3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"\u0015\u0000\u0000\u00b6\u00b7\u0003\u0010\b\b\u00b7\u00b8\u0006\b\uffff"+
		"\uffff\u0000\u00b8\u00c3\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0016"+
		"\u0000\u0000\u00ba\u00bb\u0005\u0017\u0000\u0000\u00bb\u00bc\u0003\"\u0011"+
		"\u0000\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00be\u0005\u000f\u0000"+
		"\u0000\u00be\u00bf\u0003\u0010\b\u0000\u00bf\u00c0\u0005\u0010\u0000\u0000"+
		"\u00c0\u00c1\u0006\b\uffff\uffff\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c2\u00a0\u0001\u0000\u0000\u0000\u00c2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00c2\u00a5\u0001\u0000\u0000\u0000\u00c2\u00a7\u0001\u0000\u0000\u0000"+
		"\u00c2\u00a9\u0001\u0000\u0000\u0000\u00c2\u00ac\u0001\u0000\u0000\u0000"+
		"\u00c2\u00b0\u0001\u0000\u0000\u0000\u00c2\u00b5\u0001\u0000\u0000\u0000"+
		"\u00c2\u00b9\u0001\u0000\u0000\u0000\u00c3\u00ee\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\n\u0006\u0000\u0000\u00c5\u00c6\u0007\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0003\u0010\b\u0007\u00c7\u00c8\u0006\b\uffff\uffff\u0000\u00c8"+
		"\u00ed\u0001\u0000\u0000\u0000\u00c9\u00ca\n\u0005\u0000\u0000\u00ca\u00cb"+
		"\u0007\u0001\u0000\u0000\u00cb\u00cc\u0003\u0010\b\u0006\u00cc\u00cd\u0006"+
		"\b\uffff\uffff\u0000\u00cd\u00ed\u0001\u0000\u0000\u0000\u00ce\u00cf\n"+
		"\u0004\u0000\u0000\u00cf\u00d0\u0007\u0002\u0000\u0000\u00d0\u00d1\u0003"+
		"\u0010\b\u0005\u00d1\u00d2\u0006\b\uffff\uffff\u0000\u00d2\u00ed\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\n\u0003\u0000\u0000\u00d4\u00d5\u0007\u0003"+
		"\u0000\u0000\u00d5\u00d6\u0003\u0010\b\u0004\u00d6\u00d7\u0006\b\uffff"+
		"\uffff\u0000\u00d7\u00ed\u0001\u0000\u0000\u0000\u00d8\u00d9\n\u0002\u0000"+
		"\u0000\u00d9\u00da\u0005!\u0000\u0000\u00da\u00db\u0003\u0010\b\u0003"+
		"\u00db\u00dc\u0006\b\uffff\uffff\u0000\u00dc\u00ed\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\n\u0001\u0000\u0000\u00de\u00df\u0005\"\u0000\u0000\u00df"+
		"\u00e0\u0003\u0010\b\u0002\u00e0\u00e1\u0006\b\uffff\uffff\u0000\u00e1"+
		"\u00ed\u0001\u0000\u0000\u0000\u00e2\u00e3\n\f\u0000\u0000\u00e3\u00e4"+
		"\u0005\u0011\u0000\u0000\u00e4\u00e5\u0003\u0010\b\u0000\u00e5\u00e6\u0005"+
		"\u0012\u0000\u0000\u00e6\u00e7\u0006\b\uffff\uffff\u0000\u00e7\u00ed\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\n\u000b\u0000\u0000\u00e9\u00ea\u0005\u0013"+
		"\u0000\u0000\u00ea\u00eb\u00059\u0000\u0000\u00eb\u00ed\u0006\b\uffff"+
		"\uffff\u0000\u00ec\u00c4\u0001\u0000\u0000\u0000\u00ec\u00c9\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ce\u0001\u0000\u0000\u0000\u00ec\u00d3\u0001\u0000"+
		"\u0000\u0000\u00ec\u00d8\u0001\u0000\u0000\u0000\u00ec\u00dd\u0001\u0000"+
		"\u0000\u0000\u00ec\u00e2\u0001\u0000\u0000\u0000\u00ec\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u0011\u0001\u0000"+
		"\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003\u0010"+
		"\b\u0000\u00f2\u00f9\u0006\t\uffff\uffff\u0000\u00f3\u00f4\u0005#\u0000"+
		"\u0000\u00f4\u00f5\u0003\u0010\b\u0000\u00f5\u00f6\u0006\t\uffff\uffff"+
		"\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0013\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005$\u0000\u0000"+
		"\u00fd\u00fe\u0003\u0016\u000b\u0000\u00fe\u00ff\u0006\n\uffff\uffff\u0000"+
		"\u00ff\u0015\u0001\u0000\u0000\u0000\u0100\u0101\u00059\u0000\u0000\u0101"+
		"\u0102\u0005\u0003\u0000\u0000\u0102\u0104\u0006\u000b\uffff\uffff\u0000"+
		"\u0103\u0100\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000"+
		"\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000"+
		"\u0106\u0017\u0001\u0000\u0000\u0000\u0107\u0108\u0003\u001a\r\u0000\u0108"+
		"\u0109\u0006\f\uffff\uffff\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a"+
		"\u0107\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c"+
		"\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d"+
		"\u0019\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0003\u001c\u000e\u0000\u0110\u0111\u0005%\u0000\u0000\u0111\u0112"+
		"\u0003\"\u0011\u0000\u0112\u0113\u0005\u0003\u0000\u0000\u0113\u0114\u0006"+
		"\r\uffff\uffff\u0000\u0114\u001b\u0001\u0000\u0000\u0000\u0115\u0116\u0005"+
		"9\u0000\u0000\u0116\u0117\u0006\u000e\uffff\uffff\u0000\u0117\u011d\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0005#\u0000\u0000\u0119\u011a\u00059\u0000"+
		"\u0000\u011a\u011c\u0006\u000e\uffff\uffff\u0000\u011b\u0118\u0001\u0000"+
		"\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u001d\u0001\u0000"+
		"\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0003 \u0010"+
		"\u0000\u0121\u0122\u0006\u000f\uffff\uffff\u0000\u0122\u0124\u0001\u0000"+
		"\u0000\u0000\u0123\u0120\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000"+
		"\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u001f\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u00059\u0000\u0000\u0129\u012a\u0005%\u0000\u0000"+
		"\u012a\u012b\u0003\"\u0011\u0000\u012b\u012c\u0005\u0003\u0000\u0000\u012c"+
		"\u012d\u0006\u0010\uffff\uffff\u0000\u012d!\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0005&\u0000\u0000\u012f\u013d\u0006\u0011\uffff\uffff\u0000\u0130"+
		"\u0131\u0005\'\u0000\u0000\u0131\u013d\u0006\u0011\uffff\uffff\u0000\u0132"+
		"\u0133\u0005(\u0000\u0000\u0133\u013d\u0006\u0011\uffff\uffff\u0000\u0134"+
		"\u0135\u00059\u0000\u0000\u0135\u013d\u0006\u0011\uffff\uffff\u0000\u0136"+
		"\u0137\u0005\u0011\u0000\u0000\u0137\u0138\u00053\u0000\u0000\u0138\u0139"+
		"\u0005\u0012\u0000\u0000\u0139\u013a\u0003\"\u0011\u0000\u013a\u013b\u0006"+
		"\u0011\uffff\uffff\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u012e"+
		"\u0001\u0000\u0000\u0000\u013c\u0130\u0001\u0000\u0000\u0000\u013c\u0132"+
		"\u0001\u0000\u0000\u0000\u013c\u0134\u0001\u0000\u0000\u0000\u013c\u0136"+
		"\u0001\u0000\u0000\u0000\u013d#\u0001\u0000\u0000\u0000\u013e\u013f\u0003"+
		"&\u0013\u0000\u013f\u0140\u0006\u0012\uffff\uffff\u0000\u0140\u0142\u0001"+
		"\u0000\u0000\u0000\u0141\u013e\u0001\u0000\u0000\u0000\u0142\u0143\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001"+
		"\u0000\u0000\u0000\u0144%\u0001\u0000\u0000\u0000\u0145\u0146\u0005)\u0000"+
		"\u0000\u0146\u0148\u00059\u0000\u0000\u0147\u0149\u0003(\u0014\u0000\u0148"+
		"\u0147\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149"+
		"\u014c\u0001\u0000\u0000\u0000\u014a\u014b\u0005%\u0000\u0000\u014b\u014d"+
		"\u0003\"\u0011\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u0150\u0005"+
		"*\u0000\u0000\u014f\u0151\u0003*\u0015\u0000\u0150\u014f\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0003,\u0016\u0000\u0153\u0154\u0005\u0001\u0000\u0000"+
		"\u0154\u0155\u0006\u0013\uffff\uffff\u0000\u0155\'\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0005\u000f\u0000\u0000\u0157\u0158\u00059\u0000\u0000\u0158"+
		"\u0159\u0005%\u0000\u0000\u0159\u015a\u0003\"\u0011\u0000\u015a\u0163"+
		"\u0006\u0014\uffff\uffff\u0000\u015b\u015c\u0005#\u0000\u0000\u015c\u015d"+
		"\u00059\u0000\u0000\u015d\u015e\u0005%\u0000\u0000\u015e\u015f\u0003\""+
		"\u0011\u0000\u015f\u0160\u0006\u0014\uffff\uffff\u0000\u0160\u0162\u0001"+
		"\u0000\u0000\u0000\u0161\u015b\u0001\u0000\u0000\u0000\u0162\u0165\u0001"+
		"\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001"+
		"\u0000\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u0163\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0005\u0010\u0000\u0000\u0167)\u0001\u0000"+
		"\u0000\u0000\u0168\u0169\u0005+\u0000\u0000\u0169\u016a\u0003\u0018\f"+
		"\u0000\u016a\u016b\u0006\u0015\uffff\uffff\u0000\u016b+\u0001\u0000\u0000"+
		"\u0000\u016c\u016e\u0005,\u0000\u0000\u016d\u016f\u0003\u0006\u0003\u0000"+
		"\u016e\u016d\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0006\u0016\uffff\uffff"+
		"\u0000\u0171-\u0001\u0000\u0000\u0000\u0172\u0174\u0005-\u0000\u0000\u0173"+
		"\u0175\u0003\u0010\b\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0174\u0175"+
		"\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177"+
		"\u0005\u0003\u0000\u0000\u0177\u0178\u0006\u0017\uffff\uffff\u0000\u0178"+
		"/\u0001\u0000\u0000\u0000\u0179\u017b\u0005.\u0000\u0000\u017a\u017c\u0003"+
		"2\u0019\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000"+
		"\u0000\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017f\u00034\u001a"+
		"\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0181\u0006\u0018\uffff"+
		"\uffff\u0000\u01811\u0001\u0000\u0000\u0000\u0182\u0184\u0005/\u0000\u0000"+
		"\u0183\u0185\u00036\u001b\u0000\u0184\u0183\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0006\u0019\uffff\uffff\u0000\u01873\u0001\u0000\u0000\u0000\u0188"+
		"\u0189\u00050\u0000\u0000\u0189\u018a\u0003\u0018\f\u0000\u018a\u018b"+
		"\u0006\u001a\uffff\uffff\u0000\u018b5\u0001\u0000\u0000\u0000\u018c\u018d"+
		"\u00038\u001c\u0000\u018d\u018e\u0006\u001b\uffff\uffff\u0000\u018e\u0190"+
		"\u0001\u0000\u0000\u0000\u018f\u018c\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0192"+
		"\u0001\u0000\u0000\u0000\u01927\u0001\u0000\u0000\u0000\u0193\u0194\u0005"+
		"1\u0000\u0000\u0194\u0195\u00059\u0000\u0000\u0195\u0196\u00052\u0000"+
		"\u0000\u0196\u0197\u0003\u001e\u000f\u0000\u0197\u0198\u0005\u0001\u0000"+
		"\u0000\u0198\u0199\u0006\u001c\uffff\uffff\u0000\u01999\u0001\u0000\u0000"+
		"\u0000\u001e<T]cpwy\u0089\u0090\u009b\u00c2\u00ec\u00ee\u00f9\u0105\u010c"+
		"\u011d\u0125\u013c\u0143\u0148\u014c\u0150\u0163\u016e\u0174\u017b\u017e"+
		"\u0184\u0191";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}