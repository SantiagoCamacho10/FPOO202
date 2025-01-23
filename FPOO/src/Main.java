//Zona de importacion
import java.util.Scanner;
//Clase principal
public class Main {
    //Metodo Main o Principal
    public static void main(String[] args) {
        /*System.out.println("Hello, World!");
        System.out.println("Santiago Camacho");
        System.out.println("Santiago Camacho");
        System.out.println("Santiago Camacho");
        System.out.println("Santiago Camacho");*/

        //2. Cadenas
        /*String cadena= "santiago" + "ivan" + "camacho" + "sanchez";
        System.out.println(cadena);

        System.out.println(cadena.length());

        //Extraccion de caracteres en base a parametros
        System.out.println(cadena.substring(2,5));//Rango del 2 al 5
        System.out.println(cadena.substring(2));//A partir del 2do dato
        System.out.println(cadena.substring(0,5));//Rango del 0 al 5*/

        //3. Variables
        /*String cadena="333", cadena2, cadena3;
        int entero=3, entero2, entero3;
        double decimal=3.386, decimal2, decimal3;

        //Convertir cadena a int
        entero2=Integer.parseInt(cadena);
        System.out.println(cadena);

        //Convertir double a int
        entero3=(int)decimal;
        System.out.println(entero3);

        //Convertir double a cadena
        cadena2=String.valueOf(decimal);
        System.out.println(cadena2);

        //Convertir int a double
        decimal2=Double.valueOf(entero);
        System.out.println(decimal2);

        //Conversion implicita
        int i=12;
        double numd=i;
        System.out.println(numd);*/

        //4. Solicitud de datos
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una cadena: ");
        String cadena = sc.nextLine();

        System.out.println("Escribe un numero entero: ");
        int entero = sc.nextInt();

        System.out.println("Escribe un numero decimal: ");
        double decimal = sc.nextDouble();

        System.out.println("Cadena guardada: "+cadena);
        System.out.println("Numero entero guardado: "+entero);
        System.out.println("Numero decimal guardado: "+decimal);*/

    //5. Boolean, operadores logicos y de comparacion
        System.out.println(10>9);//True
        System.out.println(10==9);//False
        System.out.println(10<9);//False
        System.out.println(10>=9);//True
        System.out.println(10<=9);//False
        System.out.println(10!=9);//True (!= : Diferente de)

        //Operadores logicos
        int x=3;
        System.out.println(x< 5 && x>10);//False
        System.out.println(x< 5 || x>10);//True
        System.out.println(!(x< 5 && x>10));//True
        System.out.println(!(x< 5 || x>10));//False
    }
}