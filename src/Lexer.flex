import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}


/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"


/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}


/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*
CadenaTexto = [^/\"]*

/* Numero */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\@{Identificador} {return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }

/* Tipo de dato entero*/
entero {return token(yytext(), "DATO_ENTERO", yyline, yycolumn); }

/* Tipo de dato entero*/
decimal {return token(yytext(), "DATO_DECIMAL", yyline, yycolumn); }

/* Tipos de dato texto*/
cadena {return token(yytext(), "DATO_TEXTO", yyline, yycolumn); }

/* Numeros decimales*/
{Numero}"."{Numero} {return token(yytext(), "DECIMAL", yyline, yycolumn);}

/* Numero*/
{Numero} {return token(yytext(), "NUMERO", yyline, yycolumn); }

/* Cadena de texto*/
\" {CadenaTexto} \" {return token(yytext(), "CADENA_DE_TEXTO", yyline, yycolumn); }


/* Operadores relacionales*/

">=" {return token(yytext(), "MAYOR_IGUAL", yyline, yycolumn); }
"<=" {return token(yytext(), "MENOR_IGUAL", yyline, yycolumn); }
">" {return token(yytext(), "MAYOR", yyline, yycolumn); }
"<" {return token(yytext(), "MENOR", yyline, yycolumn); }
"==" {return token(yytext(), "COMPARADOR", yyline, yycolumn); }
"[" {return token(yytext(), "CORCHETE_ABIERTO", yyline, yycolumn); }
"]" {return token(yytext(), "CORCHETE_CERRADO", yyline, yycolumn); }
"(" {return token(yytext(), "PARENTESIS_ABIERTO", yyline, yycolumn); }
")" {return token(yytext(), "PARENTESIS_CERRADO", yyline, yycolumn); }
"{" {return token(yytext(), "LLAVE_ABIERTA", yyline, yycolumn); }
"}" {return token(yytext(), "LLAVE_CERRADA", yyline, yycolumn); }
"," {return token(yytext(), "COMA", yyline, yycolumn); }
";" {return token(yytext(), "PUNTO_COMA", yyline, yycolumn); }

/*Operador de asignacion*/
::= {return token(yytext(), "OP_ASIGNACION", yyline, yycolumn); }

/* Palabras reservadas*/
si | sino | mientras | para {return token(yytext(), "ESTRUCTURAS_CONTROL", yyline, yycolumn);}

/*funciones*/
suma | resta | multiplicacion | division | tablaMultiplicar | areaCuadrado | areaRectangulo | perimetroCirculo |
convertirUnidades | problemasMatematicos | porcentaje | maximoComunDivisor | minimoComunMultiplo | areaTriangulo | imprimir | escribir | leer
{return token(yytext(), "FUNCION", yyline, yycolumn); }

/*Operadores logicos*/
"&" | "|" {return token(yytext(), "OPERADOR_LOGICO", yyline, yycolumn); }

/*Final del programa*/
FIN {return token(yytext(), "FINAL_DEL_PROGRAMA", yyline, yycolumn); }

/*Numeros no validos*/
0{Numero} {return token(yytext(), "ERROR1", yyline, yycolumn); }

/*Identificadores no validos*/
{Identificador} {return token(yytext(), "ERROR2", yyline, yycolumn); }

. { return token(yytext(), "ERROR", yyline, yycolumn); }