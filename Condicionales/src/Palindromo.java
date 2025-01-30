import java.util.Scanner;
public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una palabra o frase: ");
        String palabra = sc.nextLine();
        String invertida = new StringBuilder(palabra).reverse().toString();
        if (palabra.equals(invertida)) {
            System.out.println("Palabra o frase palindroma");
        }else{
            System.out.println("Palabra o frase no palindroma");
        }
    }
}