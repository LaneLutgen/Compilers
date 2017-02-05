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
		KEYWORD=1, IDENTIFIER=2, OPERATOR=3, INTLITERAL=4, STRINGLITERAL=5, COMMENT=6, 
		WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "IDENTIFIER", "OPERATOR", "INTLITERAL", "STRINGLITERAL", "COMMENT", 
		"WS", "StringCharacter", "StringCharacters"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "IDENTIFIER", "OPERATOR", "INTLITERAL", "STRINGLITERAL", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\u00a7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2t\n\2\3\3\3\3\7\3x\n\3\f\3\16\3{\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0087\n\4\3\5\6\5\u008a\n\5\r\5"+
		"\16\5\u008b\3\6\3\6\5\6\u0090\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0098\n"+
		"\7\3\b\6\b\u009b\n\b\r\b\16\b\u009c\3\b\3\b\3\t\3\t\3\n\6\n\u00a4\n\n"+
		"\r\n\16\n\u00a5\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\3\2\t\3"+
		"\2c|\4\2\62;c|\6\2,-//\61\61??\6\2*+..=>@@\3\2\62;\5\2\13\f\16\17\"\""+
		"\4\2))^^\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3s\3\2\2\2\5u\3\2\2\2\7\u0086\3\2\2\2"+
		"\t\u0089\3\2\2\2\13\u008d\3\2\2\2\r\u0093\3\2\2\2\17\u009a\3\2\2\2\21"+
		"\u00a0\3\2\2\2\23\u00a3\3\2\2\2\25\26\7R\2\2\26\27\7T\2\2\27\30\7Q\2\2"+
		"\30\31\7I\2\2\31\32\7T\2\2\32\33\7C\2\2\33t\7O\2\2\34\35\7D\2\2\35\36"+
		"\7G\2\2\36\37\7I\2\2\37 \7K\2\2 !\7P\2\2!\"\3\2\2\2\"#\7G\2\2#$\7P\2\2"+
		"$t\7F\2\2%&\7H\2\2&\'\7W\2\2\'(\7P\2\2()\7E\2\2)*\7V\2\2*+\7K\2\2+,\7"+
		"Q\2\2,t\7P\2\2-.\7T\2\2./\7G\2\2/\60\7C\2\2\60t\7F\2\2\61\62\7Y\2\2\62"+
		"\63\7T\2\2\63\64\7K\2\2\64\65\7V\2\2\65t\7G\2\2\66\67\7K\2\2\67t\7H\2"+
		"\289\7G\2\29:\7N\2\2:;\7U\2\2;t\7G\2\2<=\7G\2\2=>\7P\2\2>?\7F\2\2?@\7"+
		"K\2\2@t\7H\2\2AB\7Y\2\2BC\7J\2\2CD\7K\2\2DE\7N\2\2Et\7G\2\2FG\7G\2\2G"+
		"H\7P\2\2HI\7F\2\2IJ\7Y\2\2JK\7J\2\2KL\7K\2\2LM\7N\2\2Mt\7G\2\2NO\7E\2"+
		"\2OP\7Q\2\2PQ\7P\2\2QR\7V\2\2RS\7K\2\2ST\7P\2\2TU\7W\2\2Ut\7G\2\2VW\7"+
		"D\2\2WX\7T\2\2XY\7G\2\2YZ\7C\2\2Zt\7M\2\2[\\\7T\2\2\\]\7G\2\2]^\7V\2\2"+
		"^_\7W\2\2_`\7T\2\2`t\7P\2\2ab\7K\2\2bc\7P\2\2ct\7V\2\2de\7X\2\2ef\7Q\2"+
		"\2fg\7K\2\2gt\7F\2\2hi\7U\2\2ij\7V\2\2jk\7T\2\2kl\7K\2\2lm\7P\2\2mt\7"+
		"I\2\2no\7H\2\2op\7N\2\2pq\7Q\2\2qr\7C\2\2rt\7V\2\2s\25\3\2\2\2s\34\3\2"+
		"\2\2s%\3\2\2\2s-\3\2\2\2s\61\3\2\2\2s\66\3\2\2\2s8\3\2\2\2s<\3\2\2\2s"+
		"A\3\2\2\2sF\3\2\2\2sN\3\2\2\2sV\3\2\2\2s[\3\2\2\2sa\3\2\2\2sd\3\2\2\2"+
		"sh\3\2\2\2sn\3\2\2\2t\4\3\2\2\2uy\t\2\2\2vx\t\3\2\2wv\3\2\2\2x{\3\2\2"+
		"\2yw\3\2\2\2yz\3\2\2\2z\6\3\2\2\2{y\3\2\2\2|}\7<\2\2}\u0087\7?\2\2~\u0087"+
		"\t\4\2\2\177\u0080\7#\2\2\u0080\u0087\7?\2\2\u0081\u0087\t\5\2\2\u0082"+
		"\u0083\7>\2\2\u0083\u0087\7?\2\2\u0084\u0085\7@\2\2\u0085\u0087\7?\2\2"+
		"\u0086|\3\2\2\2\u0086~\3\2\2\2\u0086\177\3\2\2\2\u0086\u0081\3\2\2\2\u0086"+
		"\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087\b\3\2\2\2\u0088\u008a\t\6\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\n\3\2\2\2\u008d\u008f\7$\2\2\u008e\u0090\5\23\n\2\u008f"+
		"\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7$"+
		"\2\2\u0092\f\3\2\2\2\u0093\u0094\7/\2\2\u0094\u0095\7/\2\2\u0095\u0097"+
		"\3\2\2\2\u0096\u0098\5\23\n\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\16\3\2\2\2\u0099\u009b\t\7\2\2\u009a\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\b\b\2\2\u009f\20\3\2\2\2\u00a0\u00a1\n\b\2\2\u00a1\22\3\2\2\2\u00a2"+
		"\u00a4\5\21\t\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\24\3\2\2\2\13\2sy\u0086\u008b\u008f\u0097"+
		"\u009c\u00a5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}