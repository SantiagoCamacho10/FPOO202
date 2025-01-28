import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa una frase: ");
        String frase = sc.nextLine();
        String fraseInvertida = new StringBuilder(frase).reverse().toString();
        System.out.println("La frase invertida es: "+fraseInvertida);
    }
}