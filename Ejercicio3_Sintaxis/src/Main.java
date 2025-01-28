import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero entero cualquiera: ");
        int numero = sc.nextInt();
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            System.out.println(i);
            suma += i;
        }
        System.out.println("El resultado de la suma es: "+suma);
    }
}