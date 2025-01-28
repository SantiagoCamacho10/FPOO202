import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas horas trabaja al día?: ");
        int horas = sc.nextInt();
        System.out.println("En cuanto pagan la hora de trabajo?: ");
        int paga = sc.nextInt();
        System.out.println("Su paga es de: " +(paga*horas));

    }
}