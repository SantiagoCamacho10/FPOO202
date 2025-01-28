import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca su nombre: ");
        String nombre = sc.nextLine();
        System.out.println(nombre.toUpperCase());
        System.out.println("Numero de caracteres: " + nombre.length());
    }
}