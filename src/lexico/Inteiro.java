/*
 * Representa um token numérico do tipo inteiro
 */
package lexico;
public class Inteiro extends Token{
    public final int valor;
    
    public Inteiro(int v){
        super(Tag.INT);
        valor = v;
    }
    
    @Override
    public String toString(){
        return " "+valor;
    }
}
