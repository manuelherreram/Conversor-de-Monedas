import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                *************************************************
                BIENVENIDOS AL CONVERSOR DE MONEDAS!
                **************************************************
                1-Convertir de USD (Dolares) => a EUR (EUROS).
                2-Convertir de EUR (EUROS) => a USD (Dolares).
                3-Convertir de USD (Dolares) => a ARS (Peso Argentino).
                4-Convertir de ARS (Peso Argentino) => a USD (Dolares).
                5-Convertir de USD (Dolares) => a BOB (Peso Boliviano).
                6-Convertir de BOB (Peso Boliviano) => a USD (Dolares).
                7-Convertir de USD (Dolares) => a COP (Peso Colombiano).
                8-Convertir de COP (Peso Colombiano) => a USD (Dolares).
                9-Convertir de USD (Dolares) => a DOP (Peso Dominicano).
                10-Convertir de DOP (Peso Dominicano) => a USD (Dolares).
                11-Salir
                """;

        int opcion;

        do {
            System.out.println(menu);
            System.out.println("Elija las Monedas que desea Convertir del Menu: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 10) {
                convertirYSeguir(opcion, scanner);
            } else if (opcion == 11) {
                System.out.println("**********************************************************");
                System.out.println(" ");
                System.out.println("GRACIAS POR USAR NUESTRO CONVERSOR DE MONEDAS...");
                System.out.println(" ");
                System.out.println("***********************************************************");
            } else {
                System.out.println("Opción no válida, elija una opción del menú.");
            }
        } while (opcion != 11);

        System.out.println("**********************************************************");
        System.out.println(" ");
        System.out.println("GRACIAS POR USAR NUESTRO CONVERSOR DE MONEDAS!");
        System.out.println(" ");
        System.out.println("***********************************************************");

        scanner.close();
    }

    private static void convertirYSeguir(int opcion, Scanner scanner) {
        String baseCode;
        String targetCode;

        switch (opcion) {
            case 1:
                baseCode = "USD";
                targetCode = "EUR";
                break;
            case 2:
                baseCode = "EUR";
                targetCode = "USD";
                break;
            case 3:
                baseCode = "USD";
                targetCode = "ARS";
                break;
            case 4:
                baseCode = "ARS";
                targetCode = "USD";
                break;
            case 5:
                baseCode = "USD";
                targetCode = "BOB";
                break;
            case 6:
                baseCode = "BOB";
                targetCode = "USD";
                break;
            case 7:
                baseCode = "USD";
                targetCode = "COP";
                break;
            case 8:
                baseCode = "COP";
                targetCode = "USD";
                break;
            case 9:
                baseCode = "USD";
                targetCode = "DOP";
                break;
            case 10:
                baseCode = "DOP";
                targetCode = "USD";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida");
        }

        convertirMoneda(baseCode, targetCode, scanner);

        System.out.println("Quiere seguir Convirtiendo? ");
        System.out.println("1-si");
        System.out.println("2-no");
        int seguir = scanner.nextInt();

        if (seguir != 1) {
            System.out.println("**********************************************************");
            System.out.println(" ");
            System.out.println("GRACIAS POR USAR NUESTRO CONVERSOR DE MONEDAS...");
            System.out.println(" ");
            System.out.println("***********************************************************");
            System.exit(0);
        }
    }

    private static void convertirMoneda(String baseCode, String targetCode, Scanner scanner) {
        System.out.println("Ingrese el monto total a convertir: ");
        double amount = scanner.nextDouble();
        Conversion conversion = new Conversion(baseCode, targetCode, amount);
        try {
            double result = conversion.convert();
            System.out.println(amount + " " + baseCode + " son " + result + " " + targetCode);
            System.out.println("********************************************************************");
            System.out.println("SU MONEDA A SIDO CONVERTIDA A LA OPCION DESEADA!");
            System.out.println("*********************************************************************");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
