package lexico;

public enum TokenType {
    
    //Simbolos
    ABRE_COL, //[
    FECHA_COL, //]
    ABRE_CH, //{
    FECHA_CH, //}
    ASPAS, //'
    PONTO_V, //;
    ABRE_PAR, //(
    FECHA_PAR, //)
    ATRIBUICAO, //=
    
    //Operadores
    ADD, //+
    SUB, //-
    MULT, //*
    DIV, // /
    IGUAL, // ==
    MAIOR_Q, // >
    MAIOR_I, // >=
    MENOR_Q, // <
    MENOR_I, // <=
    DIF, // <>
    
    //Palavra Reservada
    START, //start
    EXIT, //exit
    INT, //int
    FLOAT, //float
    STRING, //string
    IF, //if
    THEN, //then
    END, //end
    ELSE, //else
    DO, //do
    WHILE, //while
    SCAN, //scan
    PRINT, //print
    NOT, //not
    OR, //or
    AND, //and
    
    //Especiais
    TOKEN_INVALIDO,
    EOF_INESPERADO,
    END_OF_FILE,
};
