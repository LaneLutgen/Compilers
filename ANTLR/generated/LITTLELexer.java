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
		KEYWORD=1, IDENTIFIER=2, STRINGLITERAL=3, OPERATOR=4, COMMENT=5, FLOATLITERAL=6, 
		INTLITERAL=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", "COMMENT", "FLOATLITERAL", 
		"INTLITERAL", "StringCharacters", "Escape", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", "COMMENT", 
		"FLOATLITERAL", "INTLITERAL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u00bd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2u\n\2\3\3\3\3\7\3y\n\3\f\3\16\3|\13\3"+
		"\3\4\3\4\5\4\u0080\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u008e\n\5\3\6\3\6\3\6\3\6\7\6\u0094\n\6\f\6\16\6\u0097\13\6\3\6\3"+
		"\6\3\7\7\7\u009c\n\7\f\7\16\7\u009f\13\7\3\7\3\7\6\7\u00a3\n\7\r\7\16"+
		"\7\u00a4\3\b\6\b\u00a8\n\b\r\b\16\b\u00a9\3\t\3\t\7\t\u00ae\n\t\f\t\16"+
		"\t\u00b1\13\t\3\n\3\n\5\n\u00b5\n\n\3\13\6\13\u00b8\n\13\r\13\16\13\u00b9"+
		"\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\n\3\2\13\4"+
		"\2C\\c|\5\2\62;C\\c|\6\2,-//\61\61??\6\2*+..=>@@\4\2\f\f\17\17\3\2\62"+
		";\4\2$$^^\5\2$$^^c|\5\2\13\f\17\17\"\"\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\25\3\2"+
		"\2\2\3t\3\2\2\2\5v\3\2\2\2\7}\3\2\2\2\t\u008d\3\2\2\2\13\u008f\3\2\2\2"+
		"\r\u009d\3\2\2\2\17\u00a7\3\2\2\2\21\u00af\3\2\2\2\23\u00b2\3\2\2\2\25"+
		"\u00b7\3\2\2\2\27\30\7R\2\2\30\31\7T\2\2\31\32\7Q\2\2\32\33\7I\2\2\33"+
		"\34\7T\2\2\34\35\7C\2\2\35u\7O\2\2\36\37\7D\2\2\37 \7G\2\2 !\7I\2\2!\""+
		"\7K\2\2\"u\7P\2\2#$\7G\2\2$%\7P\2\2%u\7F\2\2&\'\7H\2\2\'(\7W\2\2()\7P"+
		"\2\2)*\7E\2\2*+\7V\2\2+,\7K\2\2,-\7Q\2\2-u\7P\2\2./\7T\2\2/\60\7G\2\2"+
		"\60\61\7C\2\2\61u\7F\2\2\62\63\7Y\2\2\63\64\7T\2\2\64\65\7K\2\2\65\66"+
		"\7V\2\2\66u\7G\2\2\678\7K\2\28u\7H\2\29:\7G\2\2:;\7N\2\2;<\7U\2\2<u\7"+
		"G\2\2=>\7G\2\2>?\7P\2\2?@\7F\2\2@A\7K\2\2Au\7H\2\2BC\7Y\2\2CD\7J\2\2D"+
		"E\7K\2\2EF\7N\2\2Fu\7G\2\2GH\7G\2\2HI\7P\2\2IJ\7F\2\2JK\7Y\2\2KL\7J\2"+
		"\2LM\7K\2\2MN\7N\2\2Nu\7G\2\2OP\7E\2\2PQ\7Q\2\2QR\7P\2\2RS\7V\2\2ST\7"+
		"K\2\2TU\7P\2\2UV\7W\2\2Vu\7G\2\2WX\7D\2\2XY\7T\2\2YZ\7G\2\2Z[\7C\2\2["+
		"u\7M\2\2\\]\7T\2\2]^\7G\2\2^_\7V\2\2_`\7W\2\2`a\7T\2\2au\7P\2\2bc\7K\2"+
		"\2cd\7P\2\2du\7V\2\2ef\7X\2\2fg\7Q\2\2gh\7K\2\2hu\7F\2\2ij\7U\2\2jk\7"+
		"V\2\2kl\7T\2\2lm\7K\2\2mn\7P\2\2nu\7I\2\2op\7H\2\2pq\7N\2\2qr\7Q\2\2r"+
		"s\7C\2\2su\7V\2\2t\27\3\2\2\2t\36\3\2\2\2t#\3\2\2\2t&\3\2\2\2t.\3\2\2"+
		"\2t\62\3\2\2\2t\67\3\2\2\2t9\3\2\2\2t=\3\2\2\2tB\3\2\2\2tG\3\2\2\2tO\3"+
		"\2\2\2tW\3\2\2\2t\\\3\2\2\2tb\3\2\2\2te\3\2\2\2ti\3\2\2\2to\3\2\2\2u\4"+
		"\3\2\2\2vz\t\2\2\2wy\t\3\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{"+
		"\6\3\2\2\2|z\3\2\2\2}\177\7$\2\2~\u0080\5\21\t\2\177~\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7$\2\2\u0082\b\3\2\2\2\u0083"+
		"\u0084\7<\2\2\u0084\u008e\7?\2\2\u0085\u008e\t\4\2\2\u0086\u0087\7#\2"+
		"\2\u0087\u008e\7?\2\2\u0088\u008e\t\5\2\2\u0089\u008a\7>\2\2\u008a\u008e"+
		"\7?\2\2\u008b\u008c\7@\2\2\u008c\u008e\7?\2\2\u008d\u0083\3\2\2\2\u008d"+
		"\u0085\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\n\3\2\2\2\u008f\u0090\7/\2\2\u0090\u0091"+
		"\7/\2\2\u0091\u0095\3\2\2\2\u0092\u0094\n\6\2\2\u0093\u0092\3\2\2\2\u0094"+
		"\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0098\u0099\b\6\2\2\u0099\f\3\2\2\2\u009a\u009c"+
		"\t\7\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7\60"+
		"\2\2\u00a1\u00a3\t\7\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\16\3\2\2\2\u00a6\u00a8\t\7\2"+
		"\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\20\3\2\2\2\u00ab\u00ae\5\23\n\2\u00ac\u00ae\n\b\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\22\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4"+
		"\7^\2\2\u00b3\u00b5\t\t\2\2\u00b4\u00b3\3\2\2\2\u00b5\24\3\2\2\2\u00b6"+
		"\u00b8\t\n\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\13\2\2\u00bc"+
		"\26\3\2\2\2\17\2tz\177\u008d\u0095\u009d\u00a4\u00a9\u00ad\u00af\u00b4"+
		"\u00b9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}