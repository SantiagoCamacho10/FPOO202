import java.util.Scanner;

public class Contraseña {
    public static void main(String[] args) {
        String contrasenaGuardada = "123456789";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la contraseña: ");
        String contrasenaIngresada = scanner.nextLine();
        if (contrasenaGuardada.equalsIgnoreCase(contrasenaIngresada)) {
            System.out.println("La contraseña es correcta.");
        } else {
            System.out.println("La contraseña es incorrecta.");
        }
    }
}