grammar LITTLE;

/* To generate the ANTLR files run the following command
		java -cp antlr-4.6-complete.jar org.antlr.v4.Tool LITTLE.g4
   This works as long as there are no syntax errors in the .g4 file */
   
/* Lexer rules are CAPITALIZED while parser rules are lowercaser */


/* LEXER RULES */

tokens: .* EOF;


KEYWORD : 'PROGRAM' | 'BEGIN' | 'END' |
		  'FUNCTION' | 'READ' | 'WRITE' |
		  'IF' | 'ELSE' | 'ENDIF' |
		  'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' |
		  'RETURN' | 'INT' | 'VOID' | 'STRING' |
		  'FLOAT';

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]*;

STRINGLITERAL : '"' StringCharacters? '"' ;

OPERATOR : ':=' | '+' | '-' | '*' 
			    | '/' | '=' | '!='
			    | '<' | '>' | '(' 
			    | ')' | ';' | ','
			    | '<='| '>=';
			    
COMMENT : '--' ~( '\r' | '\n')* -> skip;

FLOATLITERAL : [0-9]*'.'[0-9]+;
		
INTLITERAL : [0-9]+;
			    

fragment
StringCharacters : (Escape | ~('\\' | '"'))* ;

fragment
Escape : '\\' ([a-z] | '\\' | '"');

WS : [ \t\r\n]+ -> skip;

/* PARSER RULES */