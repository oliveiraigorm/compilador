/*
 * Representa um token numerico do tipo real
 */
package lexico;

public class Real extends Token {
    public final float valor;
    
    public Real(float v){
        super(Tag.FLOAT);
        valor = v;
    }
    
    @Override
    public String toString(){
        return " "+valor;
    }    
}
