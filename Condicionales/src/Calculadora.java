import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();
        System.out.println("OPERACIONES DISPONIBLES");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("Qué opcion quiere que haga la calculadora?(1-4): ");
        int op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println("La suma de: " + num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case 2:
                System.out.println("La resta de: " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case 3:
                System.out.println("La multiplicacion de: " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case 4:
                System.out.println("La division de: " + num1 + " / " + num2 + " = " + (num1 / num2));
                break;
        }
    }
}
