package Tste;

import java.util.*;

public class teste {

    public static void main(String[] args) {
        boolean sair = true;
        Scanner teclado = new Scanner(System.in);

        while (sair) {
            try {
                System.out.println("1");
                System.out.println("2");
                System.out.println("3");
                System.out.println("4");
                int opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("a");
                        break;
                    case 2:
                        System.out.println("b");
                        break;
                    case 3:
                        System.out.println("c");
                        break;
                    case 4:
                    sair = false;
                        System.out.println("d");
                        break;
                    default:
                        System.out.println("gurizes");
                        break;
                }
            } catch (Exception e) {
                System.out.println("erro");
                teclado.nextLine();
            }

        }
    }
}
