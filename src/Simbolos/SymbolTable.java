package Simbolos;

import java.util.HashMap;
import java.util.Map;
import lexico.TokenType;

public class SymbolTable {
    private Map<String, TokenType> st;
    
    public SymbolTable(){
        st = new HashMap<String, TokenType>();
        
        //Simbolos
        st.put("[", TokenType.ABRE_COL);
        st.put("]", TokenType.FECHA_COL);
        st.put("{", TokenType.ABRE_CH);
        st.put("}", TokenType.FECHA_CH);
        st.put("'", TokenType.ASPAS);
        st.put(";", TokenType.PONTO_V);
        st.put("(", TokenType.ABRE_PAR);
        st.put(")", TokenType.FECHA_PAR);
        st.put("=", TokenType.ATRIBUICAO);
        
         //Operadores
        st.put("+", TokenType.ADD);
        st.put("-", TokenType.SUB);
        st.put("*", TokenType.MULT);
        st.put("/", TokenType.DIV);
        st.put("==", TokenType.IGUAL);
        st.put(">", TokenType.MAIOR_Q);
        st.put(">=", TokenType.MAIOR_I);
        st.put("<", TokenType.MENOR_Q);
        st.put("<=", TokenType.MENOR_I);
        st.put("<>", TokenType.DIF);
        
         //Palavra Reservada
        st.put("start", TokenType.START);
        st.put("exit", TokenType.EXIT);
        st.put("int", TokenType.INT);
        st.put("float", TokenType.FLOAT);
        st.put("string", TokenType.STRING);
        st.put("if", TokenType.IF);
        st.put("then", TokenType.THEN);
        st.put("end", TokenType.END);
        st.put("else", TokenType.ELSE);
        st.put("do", TokenType.DO);
        st.put("while", TokenType.WHILE);
        st.put("scan", TokenType.SCAN);
        st.put("print", TokenType.PRINT);
        st.put("not", TokenType.NOT);
        st.put("or", TokenType.OR);
        st.put("and", TokenType.AND);
    }
    
    public boolean contem(String token){
        return st.containsKey(token);
    }
    
    public TokenType encontrar(String token){
        if (this.contem(token) == true) return st.get(token);
        else return TokenType.TOKEN_INVALIDO;
    }
}
