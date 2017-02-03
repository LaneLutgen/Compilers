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
		KEYWORD=1, IDENTIFIER=2, OPERATOR=3, STRINGLITERAL=4;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "IDENTIFIER", "OPERATOR", "STRINGLITERAL", "StringCharacter", 
		"StringCharacters"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "IDENTIFIER", "OPERATOR", "STRINGLITERAL"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\6\62\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\21\n\2\r\2\16\2\22\3"+
		"\3\6\3\26\n\3\r\3\16\3\27\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"$\n\4\3\5\3\5\5\5(\n\5\3\5\3\5\3\6\3\6\3\7\6\7/\n\7\r\7\16\7\60\2\2\b"+
		"\3\3\5\4\7\5\t\6\13\2\r\2\3\2\7\3\2C\\\3\2c|\6\2,-//\61\61??\6\2*+..="+
		">@@\4\2))^^8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\20\3\2"+
		"\2\2\5\25\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13+\3\2\2\2\r.\3\2\2\2\17\21\t"+
		"\2\2\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\4\3"+
		"\2\2\2\24\26\t\3\2\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3"+
		"\2\2\2\30\6\3\2\2\2\31\32\7<\2\2\32$\7?\2\2\33$\t\4\2\2\34\35\7#\2\2\35"+
		"$\7?\2\2\36$\t\5\2\2\37 \7>\2\2 $\7?\2\2!\"\7@\2\2\"$\7?\2\2#\31\3\2\2"+
		"\2#\33\3\2\2\2#\34\3\2\2\2#\36\3\2\2\2#\37\3\2\2\2#!\3\2\2\2$\b\3\2\2"+
		"\2%\'\7$\2\2&(\5\r\7\2\'&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7$\2\2*\n\3\2"+
		"\2\2+,\n\6\2\2,\f\3\2\2\2-/\5\13\6\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2"+
		"\60\61\3\2\2\2\61\16\3\2\2\2\b\2\22\27#\'\60\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}