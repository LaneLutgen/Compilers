package generated;
// Generated from LITTLE.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LITTLELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, PROGRAM=2, BEGIN=3, END=4, FUNCTION=5, READ=6, WRITE=7, IF=8, 
		ELSE=9, ENDIF=10, WHILE=11, ENDWHILE=12, CONTINUE=13, BREAK=14, RETURN=15, 
		INT=16, VOID=17, STRING=18, FLOAT=19, IDENTIFIER=20, STRINGLITERAL=21, 
		OPERATOR=22, ASSIGN=23, ADD=24, SUBTRACT=25, MULT=26, DIVIDE=27, EQUALS=28, 
		NOT_EQUAL=29, LESS_THAN=30, GREATER_THAN=31, LEFT_PAREN=32, RIGHT_PAREN=33, 
		SEMI_COLON=34, COMMA=35, LESS_OR_EQUAL=36, GREATER_OR_EQUAL=37, COMMENT=38, 
		FLOATLITERAL=39, INTLITERAL=40, WS=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", 
		"ELSE", "ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", 
		"VOID", "STRING", "FLOAT", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", 
		"ASSIGN", "ADD", "SUBTRACT", "MULT", "DIVIDE", "EQUALS", "NOT_EQUAL", 
		"LESS_THAN", "GREATER_THAN", "LEFT_PAREN", "RIGHT_PAREN", "SEMI_COLON", 
		"COMMA", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", "COMMENT", "FLOATLITERAL", 
		"INTLITERAL", "StringCharacters", "Escape", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'PROGRAM'", "'BEGIN'", "'END'", "'FUNCTION'", "'READ'", "'WRITE'", 
		"'IF'", "'ELSE'", "'ENDIF'", "'WHILE'", "'ENDWHILE'", "'CONTINUE'", "'BREAK'", 
		"'RETURN'", "'INT'", "'VOID'", "'STRING'", "'FLOAT'", null, null, null, 
		"':='", "'+'", "'-'", "'*'", "'/'", "'='", "'!='", "'<'", "'>'", "'('", 
		"')'", "';'", "','", "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", 
		"IF", "ELSE", "ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", 
		"INT", "VOID", "STRING", "FLOAT", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", 
		"ASSIGN", "ADD", "SUBTRACT", "MULT", "DIVIDE", "EQUALS", "NOT_EQUAL", 
		"LESS_THAN", "GREATER_THAN", "LEFT_PAREN", "RIGHT_PAREN", "SEMI_COLON", 
		"COMMA", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", "COMMENT", "FLOATLITERAL", 
		"INTLITERAL", "WS"
	};
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


	public LITTLELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LITTLE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u0190\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00b7\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u012a\n\25"+
		"\f\25\16\25\u012d\13\25\3\26\3\26\5\26\u0131\n\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u013f\n\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\7\'\u0167\n\'\f\'\16\'\u016a\13\'\3\'\3\'\3(\7(\u016f\n(\f(\16(\u0172"+
		"\13(\3(\3(\6(\u0176\n(\r(\16(\u0177\3)\6)\u017b\n)\r)\16)\u017c\3*\3*"+
		"\7*\u0181\n*\f*\16*\u0184\13*\3+\3+\5+\u0188\n+\3,\6,\u018b\n,\r,\16,"+
		"\u018c\3,\3,\2\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S\2U\2W+\3\2\13\4\2C\\c|\5\2"+
		"\62;C\\c|\6\2,-//\61\61??\6\2*+..=>@@\4\2\f\f\17\17\3\2\62;\4\2$$^^\5"+
		"\2$$^^c|\5\2\13\f\17\17\"\"\u01ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2W\3\2\2\2\3\u00b6\3\2\2\2\5\u00b8\3\2\2\2\7\u00c0"+
		"\3\2\2\2\t\u00c6\3\2\2\2\13\u00ca\3\2\2\2\r\u00d3\3\2\2\2\17\u00d8\3\2"+
		"\2\2\21\u00de\3\2\2\2\23\u00e1\3\2\2\2\25\u00e6\3\2\2\2\27\u00ec\3\2\2"+
		"\2\31\u00f2\3\2\2\2\33\u00fb\3\2\2\2\35\u0104\3\2\2\2\37\u010a\3\2\2\2"+
		"!\u0111\3\2\2\2#\u0115\3\2\2\2%\u011a\3\2\2\2\'\u0121\3\2\2\2)\u0127\3"+
		"\2\2\2+\u012e\3\2\2\2-\u013e\3\2\2\2/\u0140\3\2\2\2\61\u0143\3\2\2\2\63"+
		"\u0145\3\2\2\2\65\u0147\3\2\2\2\67\u0149\3\2\2\29\u014b\3\2\2\2;\u014d"+
		"\3\2\2\2=\u0150\3\2\2\2?\u0152\3\2\2\2A\u0154\3\2\2\2C\u0156\3\2\2\2E"+
		"\u0158\3\2\2\2G\u015a\3\2\2\2I\u015c\3\2\2\2K\u015f\3\2\2\2M\u0162\3\2"+
		"\2\2O\u0170\3\2\2\2Q\u017a\3\2\2\2S\u0182\3\2\2\2U\u0185\3\2\2\2W\u018a"+
		"\3\2\2\2YZ\7R\2\2Z[\7T\2\2[\\\7Q\2\2\\]\7I\2\2]^\7T\2\2^_\7C\2\2_\u00b7"+
		"\7O\2\2`a\7D\2\2ab\7G\2\2bc\7I\2\2cd\7K\2\2d\u00b7\7P\2\2ef\7G\2\2fg\7"+
		"P\2\2g\u00b7\7F\2\2hi\7H\2\2ij\7W\2\2jk\7P\2\2kl\7E\2\2lm\7V\2\2mn\7K"+
		"\2\2no\7Q\2\2o\u00b7\7P\2\2pq\7T\2\2qr\7G\2\2rs\7C\2\2s\u00b7\7F\2\2t"+
		"u\7Y\2\2uv\7T\2\2vw\7K\2\2wx\7V\2\2x\u00b7\7G\2\2yz\7K\2\2z\u00b7\7H\2"+
		"\2{|\7G\2\2|}\7N\2\2}~\7U\2\2~\u00b7\7G\2\2\177\u0080\7G\2\2\u0080\u0081"+
		"\7P\2\2\u0081\u0082\7F\2\2\u0082\u0083\7K\2\2\u0083\u00b7\7H\2\2\u0084"+
		"\u0085\7Y\2\2\u0085\u0086\7J\2\2\u0086\u0087\7K\2\2\u0087\u0088\7N\2\2"+
		"\u0088\u00b7\7G\2\2\u0089\u008a\7G\2\2\u008a\u008b\7P\2\2\u008b\u008c"+
		"\7F\2\2\u008c\u008d\7Y\2\2\u008d\u008e\7J\2\2\u008e\u008f\7K\2\2\u008f"+
		"\u0090\7N\2\2\u0090\u00b7\7G\2\2\u0091\u0092\7E\2\2\u0092\u0093\7Q\2\2"+
		"\u0093\u0094\7P\2\2\u0094\u0095\7V\2\2\u0095\u0096\7K\2\2\u0096\u0097"+
		"\7P\2\2\u0097\u0098\7W\2\2\u0098\u00b7\7G\2\2\u0099\u009a\7D\2\2\u009a"+
		"\u009b\7T\2\2\u009b\u009c\7G\2\2\u009c\u009d\7C\2\2\u009d\u00b7\7M\2\2"+
		"\u009e\u009f\7T\2\2\u009f\u00a0\7G\2\2\u00a0\u00a1\7V\2\2\u00a1\u00a2"+
		"\7W\2\2\u00a2\u00a3\7T\2\2\u00a3\u00b7\7P\2\2\u00a4\u00a5\7K\2\2\u00a5"+
		"\u00a6\7P\2\2\u00a6\u00b7\7V\2\2\u00a7\u00a8\7X\2\2\u00a8\u00a9\7Q\2\2"+
		"\u00a9\u00aa\7K\2\2\u00aa\u00b7\7F\2\2\u00ab\u00ac\7U\2\2\u00ac\u00ad"+
		"\7V\2\2\u00ad\u00ae\7T\2\2\u00ae\u00af\7K\2\2\u00af\u00b0\7P\2\2\u00b0"+
		"\u00b7\7I\2\2\u00b1\u00b2\7H\2\2\u00b2\u00b3\7N\2\2\u00b3\u00b4\7Q\2\2"+
		"\u00b4\u00b5\7C\2\2\u00b5\u00b7\7V\2\2\u00b6Y\3\2\2\2\u00b6`\3\2\2\2\u00b6"+
		"e\3\2\2\2\u00b6h\3\2\2\2\u00b6p\3\2\2\2\u00b6t\3\2\2\2\u00b6y\3\2\2\2"+
		"\u00b6{\3\2\2\2\u00b6\177\3\2\2\2\u00b6\u0084\3\2\2\2\u00b6\u0089\3\2"+
		"\2\2\u00b6\u0091\3\2\2\2\u00b6\u0099\3\2\2\2\u00b6\u009e\3\2\2\2\u00b6"+
		"\u00a4\3\2\2\2\u00b6\u00a7\3\2\2\2\u00b6\u00ab\3\2\2\2\u00b6\u00b1\3\2"+
		"\2\2\u00b7\4\3\2\2\2\u00b8\u00b9\7R\2\2\u00b9\u00ba\7T\2\2\u00ba\u00bb"+
		"\7Q\2\2\u00bb\u00bc\7I\2\2\u00bc\u00bd\7T\2\2\u00bd\u00be\7C\2\2\u00be"+
		"\u00bf\7O\2\2\u00bf\6\3\2\2\2\u00c0\u00c1\7D\2\2\u00c1\u00c2\7G\2\2\u00c2"+
		"\u00c3\7I\2\2\u00c3\u00c4\7K\2\2\u00c4\u00c5\7P\2\2\u00c5\b\3\2\2\2\u00c6"+
		"\u00c7\7G\2\2\u00c7\u00c8\7P\2\2\u00c8\u00c9\7F\2\2\u00c9\n\3\2\2\2\u00ca"+
		"\u00cb\7H\2\2\u00cb\u00cc\7W\2\2\u00cc\u00cd\7P\2\2\u00cd\u00ce\7E\2\2"+
		"\u00ce\u00cf\7V\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1\7Q\2\2\u00d1\u00d2"+
		"\7P\2\2\u00d2\f\3\2\2\2\u00d3\u00d4\7T\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6"+
		"\7C\2\2\u00d6\u00d7\7F\2\2\u00d7\16\3\2\2\2\u00d8\u00d9\7Y\2\2\u00d9\u00da"+
		"\7T\2\2\u00da\u00db\7K\2\2\u00db\u00dc\7V\2\2\u00dc\u00dd\7G\2\2\u00dd"+
		"\20\3\2\2\2\u00de\u00df\7K\2\2\u00df\u00e0\7H\2\2\u00e0\22\3\2\2\2\u00e1"+
		"\u00e2\7G\2\2\u00e2\u00e3\7N\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7G\2\2"+
		"\u00e5\24\3\2\2\2\u00e6\u00e7\7G\2\2\u00e7\u00e8\7P\2\2\u00e8\u00e9\7"+
		"F\2\2\u00e9\u00ea\7K\2\2\u00ea\u00eb\7H\2\2\u00eb\26\3\2\2\2\u00ec\u00ed"+
		"\7Y\2\2\u00ed\u00ee\7J\2\2\u00ee\u00ef\7K\2\2\u00ef\u00f0\7N\2\2\u00f0"+
		"\u00f1\7G\2\2\u00f1\30\3\2\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4\7P\2\2\u00f4"+
		"\u00f5\7F\2\2\u00f5\u00f6\7Y\2\2\u00f6\u00f7\7J\2\2\u00f7\u00f8\7K\2\2"+
		"\u00f8\u00f9\7N\2\2\u00f9\u00fa\7G\2\2\u00fa\32\3\2\2\2\u00fb\u00fc\7"+
		"E\2\2\u00fc\u00fd\7Q\2\2\u00fd\u00fe\7P\2\2\u00fe\u00ff\7V\2\2\u00ff\u0100"+
		"\7K\2\2\u0100\u0101\7P\2\2\u0101\u0102\7W\2\2\u0102\u0103\7G\2\2\u0103"+
		"\34\3\2\2\2\u0104\u0105\7D\2\2\u0105\u0106\7T\2\2\u0106\u0107\7G\2\2\u0107"+
		"\u0108\7C\2\2\u0108\u0109\7M\2\2\u0109\36\3\2\2\2\u010a\u010b\7T\2\2\u010b"+
		"\u010c\7G\2\2\u010c\u010d\7V\2\2\u010d\u010e\7W\2\2\u010e\u010f\7T\2\2"+
		"\u010f\u0110\7P\2\2\u0110 \3\2\2\2\u0111\u0112\7K\2\2\u0112\u0113\7P\2"+
		"\2\u0113\u0114\7V\2\2\u0114\"\3\2\2\2\u0115\u0116\7X\2\2\u0116\u0117\7"+
		"Q\2\2\u0117\u0118\7K\2\2\u0118\u0119\7F\2\2\u0119$\3\2\2\2\u011a\u011b"+
		"\7U\2\2\u011b\u011c\7V\2\2\u011c\u011d\7T\2\2\u011d\u011e\7K\2\2\u011e"+
		"\u011f\7P\2\2\u011f\u0120\7I\2\2\u0120&\3\2\2\2\u0121\u0122\7H\2\2\u0122"+
		"\u0123\7N\2\2\u0123\u0124\7Q\2\2\u0124\u0125\7C\2\2\u0125\u0126\7V\2\2"+
		"\u0126(\3\2\2\2\u0127\u012b\t\2\2\2\u0128\u012a\t\3\2\2\u0129\u0128\3"+
		"\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"*\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0130\7$\2\2\u012f\u0131\5S*\2\u0130"+
		"\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7$"+
		"\2\2\u0133,\3\2\2\2\u0134\u0135\7<\2\2\u0135\u013f\7?\2\2\u0136\u013f"+
		"\t\4\2\2\u0137\u0138\7#\2\2\u0138\u013f\7?\2\2\u0139\u013f\t\5\2\2\u013a"+
		"\u013b\7>\2\2\u013b\u013f\7?\2\2\u013c\u013d\7@\2\2\u013d\u013f\7?\2\2"+
		"\u013e\u0134\3\2\2\2\u013e\u0136\3\2\2\2\u013e\u0137\3\2\2\2\u013e\u0139"+
		"\3\2\2\2\u013e\u013a\3\2\2\2\u013e\u013c\3\2\2\2\u013f.\3\2\2\2\u0140"+
		"\u0141\7<\2\2\u0141\u0142\7?\2\2\u0142\60\3\2\2\2\u0143\u0144\7-\2\2\u0144"+
		"\62\3\2\2\2\u0145\u0146\7/\2\2\u0146\64\3\2\2\2\u0147\u0148\7,\2\2\u0148"+
		"\66\3\2\2\2\u0149\u014a\7\61\2\2\u014a8\3\2\2\2\u014b\u014c\7?\2\2\u014c"+
		":\3\2\2\2\u014d\u014e\7#\2\2\u014e\u014f\7?\2\2\u014f<\3\2\2\2\u0150\u0151"+
		"\7>\2\2\u0151>\3\2\2\2\u0152\u0153\7@\2\2\u0153@\3\2\2\2\u0154\u0155\7"+
		"*\2\2\u0155B\3\2\2\2\u0156\u0157\7+\2\2\u0157D\3\2\2\2\u0158\u0159\7="+
		"\2\2\u0159F\3\2\2\2\u015a\u015b\7.\2\2\u015bH\3\2\2\2\u015c\u015d\7>\2"+
		"\2\u015d\u015e\7?\2\2\u015eJ\3\2\2\2\u015f\u0160\7@\2\2\u0160\u0161\7"+
		"?\2\2\u0161L\3\2\2\2\u0162\u0163\7/\2\2\u0163\u0164\7/\2\2\u0164\u0168"+
		"\3\2\2\2\u0165\u0167\n\6\2\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016b\u016c\b\'\2\2\u016cN\3\2\2\2\u016d\u016f\t\7\2\2\u016e\u016d"+
		"\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0175\7\60\2\2\u0174\u0176\t"+
		"\7\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178P\3\2\2\2\u0179\u017b\t\7\2\2\u017a\u0179\3\2\2\2"+
		"\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017dR\3"+
		"\2\2\2\u017e\u0181\5U+\2\u017f\u0181\n\b\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183T\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0187\7^\2\2\u0186\u0188"+
		"\t\t\2\2\u0187\u0186\3\2\2\2\u0188V\3\2\2\2\u0189\u018b\t\n\2\2\u018a"+
		"\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u018e\3\2\2\2\u018e\u018f\b,\2\2\u018fX\3\2\2\2\17\2\u00b6"+
		"\u012b\u0130\u013e\u0168\u0170\u0177\u017c\u0180\u0182\u0187\u018c\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}