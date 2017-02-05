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
		KEYWORD=1, IDENTIFIER=2, STRINGLITERAL=3, OPERATOR=4, INTLITERAL=5, COMMENT=6, 
		WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", "INTLITERAL", "COMMENT", 
		"StringCharacters", "Escape", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "IDENTIFIER", "STRINGLITERAL", "OPERATOR", "INTLITERAL", 
		"COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\u00aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2s\n\2\3\3\3\3\7\3w\n\3\f\3\16\3z\13\3\3\4\3\4\5"+
		"\4~\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008c\n\5"+
		"\3\6\6\6\u008f\n\6\r\6\16\6\u0090\3\7\3\7\3\7\3\7\5\7\u0097\n\7\3\b\3"+
		"\b\7\b\u009b\n\b\f\b\16\b\u009e\13\b\3\t\3\t\5\t\u00a2\n\t\3\n\6\n\u00a5"+
		"\n\n\r\n\16\n\u00a6\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2"+
		"\23\t\3\2\n\3\2c|\4\2\62;c|\6\2,-//\61\61??\6\2*+..=>@@\3\2\62;\4\2$$"+
		"^^\5\2$$^^c|\5\2\13\f\17\17\"\"\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\3r\3\2\2\2\5t\3"+
		"\2\2\2\7{\3\2\2\2\t\u008b\3\2\2\2\13\u008e\3\2\2\2\r\u0092\3\2\2\2\17"+
		"\u009c\3\2\2\2\21\u009f\3\2\2\2\23\u00a4\3\2\2\2\25\26\7R\2\2\26\27\7"+
		"T\2\2\27\30\7Q\2\2\30\31\7I\2\2\31\32\7T\2\2\32\33\7C\2\2\33s\7O\2\2\34"+
		"\35\7D\2\2\35\36\7G\2\2\36\37\7I\2\2\37 \7K\2\2 s\7P\2\2!\"\7G\2\2\"#"+
		"\7P\2\2#s\7F\2\2$%\7H\2\2%&\7W\2\2&\'\7P\2\2\'(\7E\2\2()\7V\2\2)*\7K\2"+
		"\2*+\7Q\2\2+s\7P\2\2,-\7T\2\2-.\7G\2\2./\7C\2\2/s\7F\2\2\60\61\7Y\2\2"+
		"\61\62\7T\2\2\62\63\7K\2\2\63\64\7V\2\2\64s\7G\2\2\65\66\7K\2\2\66s\7"+
		"H\2\2\678\7G\2\289\7N\2\29:\7U\2\2:s\7G\2\2;<\7G\2\2<=\7P\2\2=>\7F\2\2"+
		">?\7K\2\2?s\7H\2\2@A\7Y\2\2AB\7J\2\2BC\7K\2\2CD\7N\2\2Ds\7G\2\2EF\7G\2"+
		"\2FG\7P\2\2GH\7F\2\2HI\7Y\2\2IJ\7J\2\2JK\7K\2\2KL\7N\2\2Ls\7G\2\2MN\7"+
		"E\2\2NO\7Q\2\2OP\7P\2\2PQ\7V\2\2QR\7K\2\2RS\7P\2\2ST\7W\2\2Ts\7G\2\2U"+
		"V\7D\2\2VW\7T\2\2WX\7G\2\2XY\7C\2\2Ys\7M\2\2Z[\7T\2\2[\\\7G\2\2\\]\7V"+
		"\2\2]^\7W\2\2^_\7T\2\2_s\7P\2\2`a\7K\2\2ab\7P\2\2bs\7V\2\2cd\7X\2\2de"+
		"\7Q\2\2ef\7K\2\2fs\7F\2\2gh\7U\2\2hi\7V\2\2ij\7T\2\2jk\7K\2\2kl\7P\2\2"+
		"ls\7I\2\2mn\7H\2\2no\7N\2\2op\7Q\2\2pq\7C\2\2qs\7V\2\2r\25\3\2\2\2r\34"+
		"\3\2\2\2r!\3\2\2\2r$\3\2\2\2r,\3\2\2\2r\60\3\2\2\2r\65\3\2\2\2r\67\3\2"+
		"\2\2r;\3\2\2\2r@\3\2\2\2rE\3\2\2\2rM\3\2\2\2rU\3\2\2\2rZ\3\2\2\2r`\3\2"+
		"\2\2rc\3\2\2\2rg\3\2\2\2rm\3\2\2\2s\4\3\2\2\2tx\t\2\2\2uw\t\3\2\2vu\3"+
		"\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\6\3\2\2\2zx\3\2\2\2{}\7$\2\2|~\5"+
		"\17\b\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7$\2\2\u0080\b\3\2"+
		"\2\2\u0081\u0082\7<\2\2\u0082\u008c\7?\2\2\u0083\u008c\t\4\2\2\u0084\u0085"+
		"\7#\2\2\u0085\u008c\7?\2\2\u0086\u008c\t\5\2\2\u0087\u0088\7>\2\2\u0088"+
		"\u008c\7?\2\2\u0089\u008a\7@\2\2\u008a\u008c\7?\2\2\u008b\u0081\3\2\2"+
		"\2\u008b\u0083\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0086\3\2\2\2\u008b\u0087"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008c\n\3\2\2\2\u008d\u008f\t\6\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\f\3\2\2\2\u0092\u0093\7/\2\2\u0093\u0094\7/\2\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0097\5\17\b\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\16\3\2\2\2\u0098\u009b\5\21\t\2\u0099\u009b\n\7\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\20\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7^\2\2"+
		"\u00a0\u00a2\t\b\2\2\u00a1\u00a0\3\2\2\2\u00a2\22\3\2\2\2\u00a3\u00a5"+
		"\t\t\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\n\2\2\u00a9\24\3\2\2"+
		"\2\r\2rx}\u008b\u0090\u0096\u009a\u009c\u00a1\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}