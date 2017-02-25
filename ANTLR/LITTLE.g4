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

/* Program */
program : ;
id : ;
pgm_body : ;
decl : ;

/* Global String Declaration */
string_decl : ;
str : ;

/* Variable Declaration */
var_decl : ;
var_type : ;
any_type : ;
id_list : ;
id_tail : ;

/* Function Paramater List */
param_decl_list : ;
param_decl : ;
param_decl_tail : ;

/* Function Declarations */
func_declarations : ;
func_decl : ;
func_body : ;

/* Statement List */
stmt_list : ;
stmt : ;
base_stmt : ;

/* Basic Statements */
assign_stmt : ;
assign_expr : ;
read_stmt : ;
write_stmt : ;
return_stmt : ;

/* Expressions */
expr : ;
expr_prefix : ;
factor : ;
factor_prefix : ;
postfix_expr : ;
call_expr : ;
expr_list : ;
expr_list_tail : ;
primary : ;
addop : ;
mulOp : ;

/* Complex Statements and Condition */ 
if_stmt : ;
else_part : ;
cond : ;
compop : ;

/* While statements */
while_stmt : ;
