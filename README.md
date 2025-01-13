# Conversor de Monedas

Este es un proyecto de conversión de monedas desarrollado en **Java** utilizando Maven y la API [ExchangeRate-API](https://www.exchangerate-api.com/).

## Descripción

El conversor de monedas permite:
1. Convertir entre diferentes monedas seleccionadas.
2. Consultar tasas de cambio filtradas de monedas específicas, como el Peso Argentino (ARS), el Peso Chileno (CLP) y el Dólar Estadounidense (USD).

El proyecto utiliza:
- **Java 11 o superior**
- **Maven** para la gestión de dependencias.
- La biblioteca **Gson** para trabajar con datos JSON.

---

## Cómo Compilar y Ejecutar

### **Requisitos Previos**
1. Tener instalado [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versión 11 o superior).
2. Tener instalado [Maven](https://maven.apache.org/).

### **Instrucciones**
1. Clona este repositorio en tu máquina local:
```
   git clone https://github.com/GuidoMontecinosP/conversor-monedas.git
```
```
   cd conversor-monedas
```

2.Compila el proyecto:
```
   mvn compile
```
3.Ejecuta el proyecto:
```
   mvn exec:java -Dexec.mainClass=com.example.Main
```
Uso

Al ejecutar el programa, aparecerá un menú con las siguientes opciones:

Convertir monedas: Ingresar la moneda de origen, destino y monto para obtener el resultado.
Mostrar monedas disponibles: Lista las monedas filtradas según las tasas de cambio obtenidas de la API.
Salir: Cierra el programa.

API Utilizada
Este proyecto utiliza la API ExchangeRate-API para obtener las tasas de cambio. Es necesario configurar una clave de API en el archivo APIClient.java para que funcione correctamente.
```
private static final String API_KEY = "TU_CLAVE_DE_API";
```

