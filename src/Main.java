package com.example.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Bienvenido al conversor de monedas");

        while (true) {
            System.out.println("Seleccione una opción de conversión:");
            System.out.println("1. USD a EUR");
            System.out.println("2. EUR a USD");
            System.out.println("3. USD a GBP");
            System.out.println("4. GBP a USD");
            System.out.println("5. USD a JPY");
            System.out.println("6. JPY a USD");
            System.out.println("7. Salir");

            int option = scanner.nextInt();

            if (option == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                break;
            }

            System.out.println("Ingrese la cantidad a convertir:");
            double amount = scanner.nextDouble();

            double result = 0;
            switch (option) {
                case 1:
                    result = converter.convert("USD", "EUR", amount);
                    break;
                case 2:
                    result = converter.convert("EUR", "USD", amount);
                    break;
                case 3:
                    result = converter.convert("USD", "COP", amount);
                    break;
                case 4:
                    result = converter.convert("COP", "USD", amount);
                    break;
                case 5:
                    result = converter.convert("USD", "MXC", amount);
                    break;
                case 6:
                    result = converter.convert("MXC", "USD", amount);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.println("Resultado: " + result);
        }

        scanner.close();
    }
}
