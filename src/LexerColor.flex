import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/* Identificador */
\@{Identificador} {return textColor(yychar, yylength(), new Color(55, 149, 189)); }

/* Tipos de dato */
cadena | entero | decimal {return textColor(yychar, yylength(), new Color(47, 88, 205));  }

/* Numero*/
{Numero} {return textColor(yychar, yylength(), new Color(7, 10, 82)); }

/* Cadena de texto*/
\"[^\"]*\" {return textColor(yychar, yylength(), new Color(22, 255, 0));  }

/* Operadores relacionales*/
">=" | "<=" | "<" | "==" | "[" | "]" | "(" | ")" | "{" | "}" {return textColor(yychar, yylength(), new Color(252, 79, 0));}

/* signos de puntuacion*/

"," {/* Ignorar */}
";" {/* Ignorar */}

/*Operador de asignacion*/
::= {/* Ignorar */ }

/* Palabras reservadas*/
si | sino | mientras | para {return textColor(yychar, yylength(), new Color(55, 149, 189));}

/*funciones*/
suma | resta | multiplicacion | division | tablaMultiplicar | areaCuadrado | areaRectangulo | perimetroCirculo |
convertirUnidades | problemasMatematicos | porcentaje | maximoComunDivisor | minimoComunMultiplo | areaTriangulo | imprimir | escribir | leer
{return textColor(yychar, yylength(), new Color(55, 149, 189));}

/*Operadores logicos*/
"&" | "|" {return textColor(yychar, yylength(), new Color(158, 111, 33)); }

/*Final del programa*/
FIN { /* Ignorar */  }

/*Numeros no validos*/
0{Numero} {return textColor(yychar, yylength(), new Color(231, 70, 70)); }

/*Identificadores no validos*/
{Identificador} {return textColor(yychar, yylength(), new Color(231, 70, 70)); }

. { /* Ignorar */ }