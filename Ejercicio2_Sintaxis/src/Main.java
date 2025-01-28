import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Escribe tu apellido paterno: ");
        String apellidoPaterno = sc.nextLine();
        System.out.println("Escribe tu apellido materno: ");
        String apellidoMaterno = sc.nextLine();

        System.out.println(nombre.toUpperCase() + " " + apellidoPaterno.toUpperCase() + " " + apellidoMaterno.toUpperCase());
        System.out.println(nombre.toLowerCase() + " " + apellidoPaterno.toLowerCase() + " " + apellidoMaterno.toLowerCase());
        System.out.println((nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase())+" " + (apellidoPaterno.substring(0,1).toUpperCase() + apellidoPaterno.substring(1).toLowerCase()) + " " + (apellidoMaterno.substring(0,1).toUpperCase() + apellidoMaterno.substring(1).toLowerCase()));


    }
}