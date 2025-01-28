import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PEDIDO ");
        System.out.print("Ingrese el numero de payasos vendidos: ");
        int numPayasos = sc.nextInt();
        System.out.print("Ingrese el numero de muñecas vendidas: ");
        int numMunecas = sc.nextInt();
        int pesoTotal= (numPayasos * 112) + (numMunecas * 75);
        System.out.println("El peso total: "+pesoTotal+" gramos");
    }
}