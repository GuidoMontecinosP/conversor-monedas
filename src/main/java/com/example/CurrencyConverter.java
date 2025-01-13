package com.example;

import com.google.gson.JsonObject;
import java.util.Scanner;

public class CurrencyConverter {
    public static void convert(Scanner scanner) {
        JsonObject conversionRates = APIClient.fetchConversionRates();
        if (conversionRates == null) {
            System.out.println("Error al obtener las tasas de cambio. Inténtelo más tarde.");
            return;
        }

        System.out.print("Ingrese la moneda de origen (ejemplo: USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Ingrese la moneda de destino (ejemplo: CLP): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Ingrese el monto a convertir: ");
        double amount = scanner.nextDouble();

        if (conversionRates.has(fromCurrency) && conversionRates.has(toCurrency)) {
            double fromRate = conversionRates.get(fromCurrency).getAsDouble();
            double toRate = conversionRates.get(toCurrency).getAsDouble();
            double convertedAmount = (amount / fromRate) * toRate;
            System.out.printf("El monto convertido es: %.2f %s%n", convertedAmount, toCurrency);
        } else {
            System.out.println("Error: Una o ambas monedas no están disponibles.");
        }
    }
}
