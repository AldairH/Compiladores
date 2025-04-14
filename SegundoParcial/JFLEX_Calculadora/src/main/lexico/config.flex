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

Digit          = [0-9]
Integer        = {Digit}+
Float          = {Integer} \. {Integer} | \. {Integer} | {Integer} \.

%%

"("            { return new Token(TokenConstant.PARENI.getValue(), yytext(), yyline + 1, yycolumn + 1); }
")"            { return new Token(TokenConstant.PAREND.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"+"            { return new Token(TokenConstant.MAS.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"-"            { return new Token(TokenConstant.MENOS.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"*"            { return new Token(TokenConstant.MULT.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"/"            { return new Token(TokenConstant.DIV.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"^"            { return new Token(TokenConstant.POT.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"="            { return new Token(TokenConstant.IGUAL.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"%"            { return new Token(TokenConstant.MOD.getValue(), yytext(), yyline + 1, yycolumn + 1); }

"log"          { return new Token(TokenConstant.LOG.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"sqr"          { return new Token(TokenConstant.RAIZ.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"PI"           { return new Token(TokenConstant.PI.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"min"          { return new Token(TokenConstant.MIN.getValue(), yytext(), yyline + 1, yycolumn + 1); }
"max"          { return new Token(TokenConstant.MAX.getValue(), yytext(), yyline + 1, yycolumn + 1); }

{Float}        { return new Token(TokenConstant.FLOAT.getValue(), yytext(), yyline + 1, yycolumn + 1); }
{Integer}      { return new Token(TokenConstant.INTEGER.getValue(), yytext(), yyline + 1, yycolumn + 1); }

{WhiteSpace}   { /* Ignorar espacios en blanco */ }

.              {
                  System.err.printf("Error léxico en línea %d, columna %d: Carácter inválido '%s'%n",
                                  yyline + 1, yycolumn + 1, yytext());
                  return new Token(TokenConstant.ERROR.getValue(), yytext(), yyline + 1, yycolumn + 1);
              }