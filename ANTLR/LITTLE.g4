grammar LITTLE;

/* To generate the ANTLR files run the following command
		java -cp antlr-4.6-complete.jar org.antlr.Tool little.g4
   This works as long as there are no syntax errors in the .g4 file */

tokens: .* EOF;

KEYWORD : [A-Z]+;

IDENTIFIER : [a-z]+;

OPERATOR : ':=' | '+' | '-' | '*' 
			    | '/' | '=' | '!='
			    | '<' | '>' | '(' 
			    | ')' | ';' | ','
			    | '<='| '>=';
			    
STRINGLITERAL : '"' StringCharacters? '"';

fragment
StringCharacter : ~['\\] ;

fragment
StringCharacters : StringCharacter+;