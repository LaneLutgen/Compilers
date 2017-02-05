grammar LITTLE;

/* To generate the ANTLR files run the following command
		java -cp antlr-4.6-complete.jar org.antlr.v4.Tool LITTLE.g4
   This works as long as there are no syntax errors in the .g4 file */

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
			    
INTLITERAL : [0-9]+;
			    
COMMENT : '--' StringCharacters?;

fragment
StringCharacters : (Escape | ~('\\' | '"'))* ;

fragment
Escape : '\\' ([a-z] | '\\' | '"');
     
WS : [ \t\r\n]+ -> skip;