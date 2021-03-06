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
		PROGRAM=1, BEGIN=2, END=3, FUNCTION=4, READ=5, WRITE=6, IF=7, ELSE=8, 
		ENDIF=9, WHILE=10, ENDWHILE=11, CONTINUE=12, BREAK=13, RETURN=14, INT=15, 
		VOID=16, STRING=17, FLOAT=18, IDENTIFIER=19, STRINGLITERAL=20, ASSIGN=21, 
		ADD=22, SUBTRACT=23, MULT=24, DIVIDE=25, EQUALS=26, NOT_EQUAL=27, LESS_THAN=28, 
		GREATER_THAN=29, LEFT_PAREN=30, RIGHT_PAREN=31, SEMI_COLON=32, COMMA=33, 
		LESS_OR_EQUAL=34, GREATER_OR_EQUAL=35, COMMENT=36, FLOATLITERAL=37, INTLITERAL=38, 
		WS=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", 
		"ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", 
		"STRING", "FLOAT", "IDENTIFIER", "STRINGLITERAL", "ASSIGN", "ADD", "SUBTRACT", 
		"MULT", "DIVIDE", "EQUALS", "NOT_EQUAL", "LESS_THAN", "GREATER_THAN", 
		"LEFT_PAREN", "RIGHT_PAREN", "SEMI_COLON", "COMMA", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", 
		"COMMENT", "FLOATLITERAL", "INTLITERAL", "StringCharacters", "Escape", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PROGRAM'", "'BEGIN'", "'END'", "'FUNCTION'", "'READ'", "'WRITE'", 
		"'IF'", "'ELSE'", "'ENDIF'", "'WHILE'", "'ENDWHILE'", "'CONTINUE'", "'BREAK'", 
		"'RETURN'", "'INT'", "'VOID'", "'STRING'", "'FLOAT'", null, null, "':='", 
		"'+'", "'-'", "'*'", "'/'", "'='", "'!='", "'<'", "'>'", "'('", "')'", 
		"';'", "','", "'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", 
		"ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", 
		"STRING", "FLOAT", "IDENTIFIER", "STRINGLITERAL", "ASSIGN", "ADD", "SUBTRACT", 
		"MULT", "DIVIDE", "EQUALS", "NOT_EQUAL", "LESS_THAN", "GREATER_THAN", 
		"LEFT_PAREN", "RIGHT_PAREN", "SEMI_COLON", "COMMA", "LESS_OR_EQUAL", "GREATER_OR_EQUAL", 
		"COMMENT", "FLOATLITERAL", "INTLITERAL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u0121\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7"+
		"\24\u00c7\n\24\f\24\16\24\u00ca\13\24\3\25\3\25\5\25\u00ce\n\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#"+
		"\3#\3$\3$\3$\3%\3%\3%\3%\7%\u00f8\n%\f%\16%\u00fb\13%\3%\3%\3&\7&\u0100"+
		"\n&\f&\16&\u0103\13&\3&\3&\6&\u0107\n&\r&\16&\u0108\3\'\6\'\u010c\n\'"+
		"\r\'\16\'\u010d\3(\3(\7(\u0112\n(\f(\16(\u0115\13(\3)\3)\5)\u0119\n)\3"+
		"*\6*\u011c\n*\r*\16*\u011d\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S)\3\2\t"+
		"\4\2C\\c|\5\2\62;C\\c|\4\2\f\f\17\17\3\2\62;\4\2$$^^\5\2$$^^c|\5\2\13"+
		"\f\17\17\"\"\u0127\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2S\3\2\2\2\3U\3\2"+
		"\2\2\5]\3\2\2\2\7c\3\2\2\2\tg\3\2\2\2\13p\3\2\2\2\ru\3\2\2\2\17{\3\2\2"+
		"\2\21~\3\2\2\2\23\u0083\3\2\2\2\25\u0089\3\2\2\2\27\u008f\3\2\2\2\31\u0098"+
		"\3\2\2\2\33\u00a1\3\2\2\2\35\u00a7\3\2\2\2\37\u00ae\3\2\2\2!\u00b2\3\2"+
		"\2\2#\u00b7\3\2\2\2%\u00be\3\2\2\2\'\u00c4\3\2\2\2)\u00cb\3\2\2\2+\u00d1"+
		"\3\2\2\2-\u00d4\3\2\2\2/\u00d6\3\2\2\2\61\u00d8\3\2\2\2\63\u00da\3\2\2"+
		"\2\65\u00dc\3\2\2\2\67\u00de\3\2\2\29\u00e1\3\2\2\2;\u00e3\3\2\2\2=\u00e5"+
		"\3\2\2\2?\u00e7\3\2\2\2A\u00e9\3\2\2\2C\u00eb\3\2\2\2E\u00ed\3\2\2\2G"+
		"\u00f0\3\2\2\2I\u00f3\3\2\2\2K\u0101\3\2\2\2M\u010b\3\2\2\2O\u0113\3\2"+
		"\2\2Q\u0116\3\2\2\2S\u011b\3\2\2\2UV\7R\2\2VW\7T\2\2WX\7Q\2\2XY\7I\2\2"+
		"YZ\7T\2\2Z[\7C\2\2[\\\7O\2\2\\\4\3\2\2\2]^\7D\2\2^_\7G\2\2_`\7I\2\2`a"+
		"\7K\2\2ab\7P\2\2b\6\3\2\2\2cd\7G\2\2de\7P\2\2ef\7F\2\2f\b\3\2\2\2gh\7"+
		"H\2\2hi\7W\2\2ij\7P\2\2jk\7E\2\2kl\7V\2\2lm\7K\2\2mn\7Q\2\2no\7P\2\2o"+
		"\n\3\2\2\2pq\7T\2\2qr\7G\2\2rs\7C\2\2st\7F\2\2t\f\3\2\2\2uv\7Y\2\2vw\7"+
		"T\2\2wx\7K\2\2xy\7V\2\2yz\7G\2\2z\16\3\2\2\2{|\7K\2\2|}\7H\2\2}\20\3\2"+
		"\2\2~\177\7G\2\2\177\u0080\7N\2\2\u0080\u0081\7U\2\2\u0081\u0082\7G\2"+
		"\2\u0082\22\3\2\2\2\u0083\u0084\7G\2\2\u0084\u0085\7P\2\2\u0085\u0086"+
		"\7F\2\2\u0086\u0087\7K\2\2\u0087\u0088\7H\2\2\u0088\24\3\2\2\2\u0089\u008a"+
		"\7Y\2\2\u008a\u008b\7J\2\2\u008b\u008c\7K\2\2\u008c\u008d\7N\2\2\u008d"+
		"\u008e\7G\2\2\u008e\26\3\2\2\2\u008f\u0090\7G\2\2\u0090\u0091\7P\2\2\u0091"+
		"\u0092\7F\2\2\u0092\u0093\7Y\2\2\u0093\u0094\7J\2\2\u0094\u0095\7K\2\2"+
		"\u0095\u0096\7N\2\2\u0096\u0097\7G\2\2\u0097\30\3\2\2\2\u0098\u0099\7"+
		"E\2\2\u0099\u009a\7Q\2\2\u009a\u009b\7P\2\2\u009b\u009c\7V\2\2\u009c\u009d"+
		"\7K\2\2\u009d\u009e\7P\2\2\u009e\u009f\7W\2\2\u009f\u00a0\7G\2\2\u00a0"+
		"\32\3\2\2\2\u00a1\u00a2\7D\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4\7G\2\2\u00a4"+
		"\u00a5\7C\2\2\u00a5\u00a6\7M\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7T\2\2\u00a8"+
		"\u00a9\7G\2\2\u00a9\u00aa\7V\2\2\u00aa\u00ab\7W\2\2\u00ab\u00ac\7T\2\2"+
		"\u00ac\u00ad\7P\2\2\u00ad\36\3\2\2\2\u00ae\u00af\7K\2\2\u00af\u00b0\7"+
		"P\2\2\u00b0\u00b1\7V\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7X\2\2\u00b3\u00b4"+
		"\7Q\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7F\2\2\u00b6\"\3\2\2\2\u00b7\u00b8"+
		"\7U\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba\7T\2\2\u00ba\u00bb\7K\2\2\u00bb"+
		"\u00bc\7P\2\2\u00bc\u00bd\7I\2\2\u00bd$\3\2\2\2\u00be\u00bf\7H\2\2\u00bf"+
		"\u00c0\7N\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7C\2\2\u00c2\u00c3\7V\2\2"+
		"\u00c3&\3\2\2\2\u00c4\u00c8\t\2\2\2\u00c5\u00c7\t\3\2\2\u00c6\u00c5\3"+
		"\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"(\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\7$\2\2\u00cc\u00ce\5O(\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7$"+
		"\2\2\u00d0*\3\2\2\2\u00d1\u00d2\7<\2\2\u00d2\u00d3\7?\2\2\u00d3,\3\2\2"+
		"\2\u00d4\u00d5\7-\2\2\u00d5.\3\2\2\2\u00d6\u00d7\7/\2\2\u00d7\60\3\2\2"+
		"\2\u00d8\u00d9\7,\2\2\u00d9\62\3\2\2\2\u00da\u00db\7\61\2\2\u00db\64\3"+
		"\2\2\2\u00dc\u00dd\7?\2\2\u00dd\66\3\2\2\2\u00de\u00df\7#\2\2\u00df\u00e0"+
		"\7?\2\2\u00e08\3\2\2\2\u00e1\u00e2\7>\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7"+
		"@\2\2\u00e4<\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6>\3\2\2\2\u00e7\u00e8\7+"+
		"\2\2\u00e8@\3\2\2\2\u00e9\u00ea\7=\2\2\u00eaB\3\2\2\2\u00eb\u00ec\7.\2"+
		"\2\u00ecD\3\2\2\2\u00ed\u00ee\7>\2\2\u00ee\u00ef\7?\2\2\u00efF\3\2\2\2"+
		"\u00f0\u00f1\7@\2\2\u00f1\u00f2\7?\2\2\u00f2H\3\2\2\2\u00f3\u00f4\7/\2"+
		"\2\u00f4\u00f5\7/\2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f8\n\4\2\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\b%\2\2\u00fdJ\3\2\2\2\u00fe"+
		"\u0100\t\5\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0106\7\60\2\2\u0105\u0107\t\5\2\2\u0106\u0105\3\2\2\2\u0107\u0108\3"+
		"\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109L\3\2\2\2\u010a\u010c"+
		"\t\5\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010eN\3\2\2\2\u010f\u0112\5Q)\2\u0110\u0112\n\6\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114P\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118"+
		"\7^\2\2\u0117\u0119\t\7\2\2\u0118\u0117\3\2\2\2\u0119R\3\2\2\2\u011a\u011c"+
		"\t\b\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b*\2\2\u0120T\3\2\2\2\r"+
		"\2\u00c8\u00cd\u00f9\u0101\u0108\u010d\u0111\u0113\u0118\u011d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}