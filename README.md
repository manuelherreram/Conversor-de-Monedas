# Conversor de Monedas

Este proyecto es un conversor de monedas simple que utiliza la API de ExchangeRate-API para obtener las tasas de conversión actuales. El programa permite a los usuarios convertir entre diferentes monedas y mostrar el resultado en la consola.

## Características

- Conversión entre 10 tipos de monedas diferentes: USD (Dólar estadounidense), EUR (Euro), ARS (Peso argentino), BOB (Peso boliviano), COP (Peso colombiano), DOP (Peso dominicano).
- Menú interactivo para seleccionar la conversión deseada.
- Validación de entrada para asegurar que los datos ingresados sean válidos.
- Manejo de errores en caso de que la solicitud a la API falle o la conversión no sea posible.

## Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener instalado Java 11 o superior.
3. Compila el proyecto usando el comando `javac Principal.java`.
4. Ejecuta el archivo compilado con el comando `java Principal`.
5. Sigue las instrucciones en la consola para realizar la conversión deseada.

## Estructura del proyecto

El proyecto consta de dos archivos principales:

- `Principal.java`: contiene la clase principal del programa, que maneja la entrada y salida del usuario y llama a los métodos de conversión apropiados.
- `Conversion.java`: contiene la clase `Conversion`, que realiza la conversión de monedas utilizando la API de ExchangeRate-API.

## Dependencias

Este proyecto utiliza la biblioteca Gson para analizar la respuesta JSON de la API de ExchangeRate-API. Asegúrate de incluir la biblioteca Gson en tu proyecto antes de compilar y ejecutar el código. Puedes descargar la biblioteca desde el siguiente enlace: <https://mvnrepository.com/artifact/com.google.code.gson/gson>

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más información.