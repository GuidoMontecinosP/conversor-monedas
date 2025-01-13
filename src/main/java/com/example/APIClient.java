package com.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIClient {
    private static final String API_KEY = "f995027a13d285f9f85de5d0"; // Reemplaza con tu clave
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Variable para almacenar las tasas de cambio
    private static JsonObject conversionRates = null;

    /**
     * Obtiene las tasas de cambio desde la API
     */
    public static JsonObject fetchConversionRates() {
        if (conversionRates == null) { // Solo obtenemos las tasas una vez
            try {
                String endpoint = BASE_URL + API_KEY + "/latest/USD";
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endpoint))
                        .GET()
                        .header("Accept", "application/json")
                        .build();

                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) { // Si la respuesta es exitosa
                    String responseBody = response.body();

                    // Parseamos el JSON recibido
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                    conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                } else {
                    System.err.println("Error al obtener las tasas de cambio: Código HTTP " + response.statusCode());
                }
            } catch (Exception e) {
                System.err.println("Error al obtener las tasas de cambio:");
                e.printStackTrace();
            }
        }
        return conversionRates;
    }

    /**
     * Muestra las monedas disponibles, pero solo las filtradas
     */
    public static void showAvailableCurrencies() {
        JsonObject rates = fetchConversionRates();
        if (rates != null) {
            // Lista de monedas a filtrar
            String[] filteredCurrencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

            System.out.println("Monedas disponibles (filtradas):");
            for (String currency : filteredCurrencies) {
                if (rates.has(currency)) {
                    double rate = rates.get(currency).getAsDouble();
                    System.out.printf("%s: %.2f%n", currency, rate);
                } else {
                    System.out.printf("%s: No disponible%n", currency);
                }
            }
        } else {
            System.out.println("No se pudieron obtener las monedas disponibles.");
        }
    }
}
