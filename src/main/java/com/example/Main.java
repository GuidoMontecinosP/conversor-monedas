package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Mostrar monedas disponibles");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    CurrencyConverter.convert(scanner);
                    break;
                case 2:
                    APIClient.showAvailableCurrencies();
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
