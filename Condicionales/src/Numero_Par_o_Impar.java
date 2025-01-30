import java.util.Scanner;

public class Numero_Par_o_Impar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " es par");
        }else{
            System.out.println(num + " es impar");
        }
    }
}