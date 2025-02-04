import java.util.Scanner;

public class ConversorTemperaturas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;
        do {
            System.out.println("*******Menú de conversión de temperaturas*******");
            System.out.println("1. Convertir Fahrenheit a Centígrados");
            System.out.println("2. Convertir Centígrados a Fahrenheit");
            System.out.println("3. Convertir Centígrados a Kelvin");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Ingrese la temperatura en Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    double centigrados = convertirFahrenheitACentigrados(fahrenheit);
                    System.out.printf("%.2f Fahrenheit son %.2f Centígrados%n", fahrenheit, centigrados);
                    break;
                case 2:
                    System.out.print("Ingrese la temperatura en Centígrados: ");
                    centigrados = scanner.nextDouble();
                    fahrenheit = convertirCentigradosAFahrenheit(centigrados);
                    System.out.printf("%.2f Centígrados son %.2f Fahrenheit%n", centigrados, fahrenheit);
                    break;
                case 3:
                    System.out.print("Ingrese la temperatura en Centígrados: ");
                    centigrados = scanner.nextDouble();
                    double kelvin = convertirCentigradosAKelvin(centigrados);
                    System.out.printf("%.2f Centígrados son %.2f Kelvin%n", centigrados, kelvin);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
            System.out.println();
        } while (op != 4);
        scanner.close();
    }
    public static double convertirFahrenheitACentigrados(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double convertirCentigradosAFahrenheit(double centigrados) {
        return (centigrados * 9 / 5) + 32;
    }
    public static double convertirCentigradosAKelvin(double centigrados) {
        return centigrados + 273.15;
    }
}
