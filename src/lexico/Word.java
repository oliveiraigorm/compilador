/*
 * Representa um token de palavras reservadas e identificadores
 */
package lexico;

public class Word extends Token{
    public String lexema = " ";
    public Word(String s, int tag){
        super(tag);
        lexema = s;
    }
    @Override
    public String toString(){
        return lexema;
    }    
    public static final Word ADD = new Word("+", Tag.ADD);
    public static final Word SUB = new Word("-", Tag.SUB);
    public static final Word MULT = new Word("*", Tag.MULT);
    public static final Word DIV = new Word("/", Tag.DIV);
    public static final Word IGUAL = new Word("==", Tag.IGUAL);
    public static final Word MAIOR_Q = new Word(">", Tag.MAIOR_Q);
    public static final Word MAIOR_I = new Word(">=", Tag.MAIOR_I);
    public static final Word MENOR_Q = new Word("<", Tag.MENOR_Q);
    public static final Word MENOR_I = new Word("<=", Tag.MENOR_I);
    public static final Word DIF = new Word("<>", Tag.DIF);    
}
