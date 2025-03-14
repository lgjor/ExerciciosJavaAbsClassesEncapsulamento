package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidaValorDouble {
    public static double validaValorDouble(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = scanner.nextDouble();
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("O valor deve ser maior que zero.");
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
