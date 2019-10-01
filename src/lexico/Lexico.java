/*
 * Analizador Lexico
 */
package lexico;

import java.io.*;
import java.util.*;

public class Lexico {
    public static int linha = 1;
    private char prox = ' ';
    private Hashtable palavras = new Hashtable();
    private PushbackInputStream filename;
    
    void reserve(Word p){
        palavras.put(p.lexema, p);
    }
    
    //insere as palavras reservadas na tabela de simbolo
    public Lexico(String arquivo) throws LexicoException{
        reserve(new Word("start", Tag.START));
        reserve(new Word("exit", Tag.EXIT));
        reserve(new Word("int", Tag.INT));
        reserve(new Word("float", Tag.FLOAT));
        reserve(new Word("string", Tag.STRING));
        reserve(new Word("if", Tag.IF));
        reserve(new Word("then", Tag.THEN));
        reserve(new Word("end", Tag.END));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("scan", Tag.SCAN));
        reserve(new Word("print", Tag.PRINT));
        reserve(new Word("not", Tag.NOT));
        reserve(new Word("or", Tag.OR));
        reserve(new Word("and", Tag.AND));     
        
        //tenta abrir o arquivo de fonte
        try {
            filename = new PushbackInputStream(new FileInputStream(arquivo));
        } catch (Exception e) {
            throw new LexicoException("Nao foi possivel abrir o arquivo.");
        }
    }
    
    //le o proximo caractere de entrada na variavel prox
    void readch() throws IOException {
        prox = (char)System.in.read();
    }
    boolean readch(char c) throws IOException{
        readch();
        if(prox != c) return false;
        prox = ' ';
        return true;
    }
    
    public Token scan() throws IOException{
        for(;;readch()){
            if (prox == ' ' || prox == '\t') continue;
            else if(prox == '\n') linha++;
            else break;
        }
        //reconhecendo tokens compostos
        switch(prox){
            case '=':
                if(readch('=')) return Word.IGUAL;
                else return new Token('=');
            case '>':
                if(readch('=')) return Word.MAIOR_I;
                else return new Token('>');
            case '<':
                if(readch('=')) return Word.MENOR_I;
                else if(readch('>')) return Word.DIF;
                else return new Token('<');            
        }
        //reconhecendo digitos
        if(Character.isDigit(prox)){
         int v = 0;
         do{
             v = 10*v+Character.digit(prox, 10);
             readch();
         }while(Character.isDigit(prox));
         if(prox != '.') return new Inteiro(v);
         
         float x = v;
         float d = 10;
         for(;;){
             readch();
             if(!Character.isDigit(prox)) break;
             x = x+Character.digit(prox, 10)/d;
             d = d*10;
         }
         return new Real(x);
        }
        //reconhecendo palavras
        if(Character.isLetter(prox)){
            StringBuffer b = new StringBuffer();
            do{
                b.append(prox);
                readch();
            }while(Character.isLetterOrDigit(prox));
            String s = b.toString();
            Word p = (Word)palavras.get(s);
            if (p != null) return p;
            p = new Word(s, Tag.ID);
            palavras.put(s, p);
            return p;
        }        
        Token token = new Token(prox);
        prox = ' ';
        return token;
    }
}
