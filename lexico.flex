import java_cup.runtime.*;

%%

%class AnalizadorLexico

%line
%column

%cup

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}
Comment = {TraditionalComment} | {EndOfLineComment}

%%
/* "void"    { return new Symbol(sym.tvoid); } */


"void"    { return new Symbol(sym.tvoid, yyline, yycolumn, yytext()); }

"return"    { return new Symbol(sym.treturn, yyline, yycolumn, yytext()); }
"("    { return new Symbol(sym.l_par, yyline, yycolumn, yytext());	 }
")"    { return new Symbol(sym.r_par, yyline, yycolumn, yytext());	 }
"["    { return new Symbol(sym.l_bracket, yyline, yycolumn, yytext());	 }
"]"    { return new Symbol(sym.r_bracket, yyline, yycolumn, yytext());	 }
"{"    { return new Symbol(sym.l_brace, yyline, yycolumn, yytext());	 }
"}"    { return new Symbol(sym.r_brace, yyline, yycolumn, yytext());	 }
","    { return new Symbol(sym.comma, yyline, yycolumn, yytext());	 }
"int"    { return new Symbol(sym.tint, yyline, yycolumn, yytext());	 }
"float"    { return new Symbol(sym.tfloat, yyline, yycolumn, yytext());	 }
";"    { return new Symbol(sym.semicolon, yyline, yycolumn, yytext());	 }
"="    { return new Symbol(sym.assig, yyline, yycolumn, yytext());	 }
"+"    { return new Symbol(sym.add, yyline, yycolumn, yytext());	 }
"-"    { return new Symbol(sym.sub, yyline, yycolumn, yytext());	 }
"*"    { return new Symbol(sym.mul, yyline, yycolumn, yytext());	 }
"/"    { return new Symbol(sym.div, yyline, yycolumn, yytext());	 }
"if"    { return new Symbol(sym.tif, yyline, yycolumn, yytext());	 }
"then"    { return new Symbol(sym.tthen, yyline, yycolumn, yytext());	 }
"else"    { return new Symbol(sym.telse, yyline, yycolumn, yytext());	 }
"for"    { return new Symbol(sym.tfor, yyline, yycolumn, yytext());	 }
"while"    { return new Symbol(sym.twhile, yyline, yycolumn, yytext());	 }
"do"    { return new Symbol(sym.tdo, yyline, yycolumn, yytext());	 }
"until"    { return new Symbol(sym.tuntil, yyline, yycolumn, yytext());	 }
"not"    { return new Symbol(sym.tnot, yyline, yycolumn, yytext());	 }
"and"    { return new Symbol(sym.tand, yyline, yycolumn, yytext());	 }
"or"    { return new Symbol(sym.tor, yyline, yycolumn, yytext());	 }
"=="    { return new Symbol(sym.equals, yyline, yycolumn, yytext());	 }
"<"    { return new Symbol(sym.less, yyline, yycolumn, yytext());	 }
">"    { return new Symbol(sym.greater, yyline, yycolumn, yytext());	 }
">="    { return new Symbol(sym.greaterequal, yyline, yycolumn, yytext());	 }
"<="    { return new Symbol(sym.lessequal, yyline, yycolumn, yytext());	 }
"#include"	{ return new Symbol(sym.include, yyline, yycolumn, yytext());	 }
[a-zA-Z0-9_]+ ".h" { return new Symbol(sym.hfile, yyline, yycolumn, yytext());	 }

[a-zA-Z] [a-zA-Z0-9_]*	{ return new Symbol(sym.tid, yyline, yycolumn, yytext());	 }
("-")? [0-9]+ { return new Symbol(sym.constint, yyline, yycolumn, yytext());	 }
("-")? [0-9]+ "." [0-9]+ { return new Symbol(sym.constfloat, yyline, yycolumn, yytext());	 }

/* whitespace */
{WhiteSpace}    { /* ignore */ }

/* comments */
{Comment}   { /* ignore */ }

/* error fallback */
[^]     { throw new Error("Lexical Error (Line " + yyline + ", Column " + yycolumn + ") unkown character: " + yytext()); }
