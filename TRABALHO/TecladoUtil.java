package TRABALHO;

import java.util.Scanner;

public class TecladoUtil {
    Scanner teclado = new Scanner(System.in);

    public Integer lerInt(String mensagem){
        Integer inteiro = teclado.nextInt();
        return inteiro;
    }

    public String lerString(String mensagem){
        String texto = teclado.nextLine();
        return texto;
    }

    public double lerDouble(String mensagem){
        double valor = teclado.nextDouble();
        return valor;
    }
}
