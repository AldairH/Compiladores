%%
%public
%class Lexer
%unicode
%line
%column
%type Token

%{
package main.app;
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

%%

"(" {return new Token(TokenConstant.PARENI.getValue(), yytext(), yyline + 1, yycolumn + 1); }
")" {return new Token(TokenConstant.PAREND.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"and" {return new Token(TokenConstant.AND.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"or" {return new Token(TokenConstant.OR.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"not" {return new Token(TokenConstant.NOT.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"true" {return new Token(TokenConstant.TRUE.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"false" {return new Token(TokenConstant.FALSE.getValue(), yytext(), yyline + 1, yycolumn + 1); }

<<EOF>>        { return new Token(TokenConstant.EOF.getValue(), "EOF", yyline + 1, yycolumn + 1);}




{WhiteSpace}   { /* Ignorar espacios */ }

.              {System.err.printf("Error léxico en línea %d, columna %d: Carácter inválido '%s'%n",yyline + 1, yycolumn + 1, yytext());
                  return new Token(TokenConstant.ERROR.getValue(), yytext(), yyline + 1, yycolumn + 1);
              }