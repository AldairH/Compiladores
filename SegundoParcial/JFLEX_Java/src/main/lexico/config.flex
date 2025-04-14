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
Float1         = {Integer}\.{Integer}?
Float2         = \.{Integer}
Exponent       = [eE][+-]?{Integer}
Scientific     = ({Float1}|{Float2}|{Integer}){Exponent}

Reserved       = "abstract" | "assert" | "boolean" | "break" | "byte" | "case" |
                 "catch" | "char" | "class" | "const" | "continue" | "default" |
                 "do" | "double" | "else" | "enum" | "extends" | "final" |
                 "finally" | "float" | "for" | "goto" | "if" | "implements" |
                 "import" | "instanceof" | "int" | "interface" | "long" | "native" |
                 "new" | "package" | "private" | "protected" | "public" | "return" |
                 "short" | "static" | "strictfp" | "super" | "switch" | "synchronized" |
                 "this" | "throw" | "throws" | "transient" | "try" | "void" |
                 "volatile" | "while" | "true" | "false" | "null"

%%

{WhiteSpace}    { /* Ignorar */ }
{Reserved}      { return new Token(1, yytext(), yyline + 1, yycolumn + 1); }
{Scientific}    { return new Token(3, yytext(), yyline + 1, yycolumn + 1); }
{Float1}        { return new Token(2, yytext(), yyline + 1, yycolumn + 1); }
{Float2}        { return new Token(2, yytext(), yyline + 1, yycolumn + 1); }
{Integer}       { return new Token(5, yytext(), yyline + 1, yycolumn + 1); }

[^]             { return new Token(999, yytext(), yyline + 1, yycolumn + 1); }