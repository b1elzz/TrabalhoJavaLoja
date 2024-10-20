package TRABALHO;

import java.util.Scanner;

public class TecladoUtil {
    Scanner teclado = new Scanner(System.in);

    public Integer lerInt(String mensagem){
        System.out.println(mensagem);
        return teclado.nextInt();
    }

    public String lerString(String mensagem){
        System.out.println(mensagem);
        return teclado.nextLine();
    }

    public String limparBuffer(){
        return teclado.nextLine();
    }

    public double lerDouble(String mensagem){
        System.out.println(mensagem);
        return teclado.nextDouble();
    }
}
