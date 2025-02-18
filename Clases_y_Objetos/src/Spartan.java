public class Spartan {
    public String nombre;
    public int escudo;
    public int salud;
    public String armaprincipal;

    public void MostrarInfo(){
        System.out.println("-------MOSTRAR INFO DEL SPARTAN------");
        System.out.println("Nombre: " + nombre);
        System.out.println("% Escudo: " + escudo);
        System.out.println("% Salud: " + salud);
        System.out.println("Arma Disponible: " + armaprincipal);
        System.out.println("-------------------------------------");
    }
    public void Atacar(String enemigo){
        System.out.println(nombre+ " ataca a "+ enemigo+ " con "+ armaprincipal);
    }
    public void RecargarArma(int municiones){
        int restantes = 10;
        int total = restantes + municiones;
        System.out.println(armaprincipal+ " ahora tiene disponible "+ total+ " de municiones");
    }
    public void Correr(boolean status){
        if(status){
            System.out.println(nombre+ " esta corriendo");
        }else{
            System.out.println(nombre+ " no esta corriendo");
        }
    }
}