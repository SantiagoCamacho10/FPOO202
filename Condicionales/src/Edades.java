import java.util.Scanner;

public class Edades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.println("Ingrese su edad: ");
        edad = sc.nextInt();
        if (edad < 4) {
            System.out.println("Puede entrar gratis");
        }else if (edad <= 18) {
            System.out.println("Debe pagar $110 pesos por la entrada");
        }else{
            System.out.println("Debe pagar $190 pesos por la entrada");
        }
    }
}