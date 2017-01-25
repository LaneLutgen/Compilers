grammar LITTLE;

tokens : .* EOF;

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