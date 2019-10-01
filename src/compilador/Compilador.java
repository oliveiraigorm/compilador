package compilador;

import java.io.*;
import java.util.Scanner;
import lexico.Lexico;
import lexico.LexicoException;

public class Compilador {

    public static void main(String[] args) throws IOException, LexicoException{
        String arquivo;
        System.out.print("Escreva o nome do arquivo teste: ");
        Scanner arq = new Scanner(System.in);
        arquivo = arq.next();
        Lexico lexico = new Lexico(arquivo);  
    }    
}
