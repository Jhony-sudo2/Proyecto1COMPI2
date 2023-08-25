/*Java Code Specification*/
package com.mycompany.server.parser;
import static com.mycompany.server.parser.ParserSym.*;
import com.mycompany.server.parser.errores.Type;
import java.util.ArrayList;
import java_cup.runtime.Symbol;

%%
%class Lexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%{
    private Symbol token(int type,String Value){
        return new Symbol(type, new Token(Value,yyline+1,yycolumn+1,type));
    }

    private Symbol token(int Type){
        return new Symbol(Type,new Token(yyline+1,yycolumn+1,Type));
    }

%}

/*Regular expresions*/

Id 		= [:jletter:] [:jletterdigit:]*
Integer 	= 0 | [1-9][0-9]*
Decimal 	= {Integer}\.\d+
InputCharacter = [^\r\n]
LineTerminator  = \r|\n|\r\n
WhiteSpace      = {LineTerminator} | [ \t\f]
ComentarioLine     = ">>" {InputCharacter}* {LineTerminator}?
ComentarioBloque = "<-" [^*]~ "->"

%eofval{
    return token(EOF);
%eofval}
%eofclose

/*Actions*/
%%

/*Palabras reservadas*/
(entero)                {return token(entero);}
(doble)                 {return token(doble);}
(boolean)               {return token(boolean);}
(caracter)              {return token(caracter);}
(cadena)                {return token(cadena);}
(si)                    {return token(si);}
(sino)                  {return token(sino);}
(switch)                {return token(switch);}
(caso)                  {return token(caso);}
(salir)                 {return token(salir);}
(default)               {return token(default);}
(para)                  {return token(para);}
(mientras)              {return token(mientras);}
(hacer)                 {return token(hacer);}
(continuar)             {return token(continuar);}
(retorna)               {return token(retorna);}
(Reproducir)            {return token(reproducir);}
(Esperar)               {return token(esperar);}
(Ordenar)               {return token(ordenar);}
(Sumarizar)             {return token(sumarizar);}
(Longitud)              {return token(longitud);}
(Mensaje)               {return token(mensaje);}
(Principal)             {return token(principal);}
(lista)                 {return token(lista);}
(pistas)                {return token(pistas);}
(arreglo)               {return token(arreglo);}
(extiende)              {return token(extiende);}
(Keep)                  {return token(keep);}
(Pista)                 {return token(pista);}
(var)                   {return token(var);}

{Id}                    {return token(id);}
{Integer}               {return token(int);}
{Decimal}               {return token(decimal);}

/*Operators*/
"="                     {return token(igual);}
"!="                    {return token(diferente);}
">"                     {return token(mayor);}
"<"                     {return token(menor);}
">="                    {return token(mayorigual);}
"<="                    {return token(menorigual);}
"!!"                    {return token(nulo);}
"&&"                    {return token(and);}
"!&&"                   {return token(nand);}
"||"                    {return token(or);}
"!||"                   {return token(nor);}
"!|"                    {return token(xor);}
"!"                     {return token(not);}
"+"			{return token(mas);}
"-"			{return token(menos);}
"/"			{return token(div);}
"*"			{return token(mult);}
"%"                     {return token(modulo);}
"^"                     {return token(potencia);}
":"			{return token(dpuntos);}
";"                     {return token(pcoma);}
","			{return token(coma);}
"\""			{return token(comillas);}
")"			{return token(parentc);}	
"("			{return token(parenta);}
"{"			{return token(keyO);}
"}"			{return token(keyC);}
"["			{return token(corO);}
"]"			{return token(corC);}
"'"                     {return token(comilla);}
{WhiteSpace}                {/*Ignorar*/}
{ComentarioLine}            {/*Ignorar*/}
{ComentarioBloque}          {/*Ignorar*/}
[^]			{Errores.add(new ErrorP(yytext(),yyline+1,yycolumn+1,7,Type.LEXICO));}











 
