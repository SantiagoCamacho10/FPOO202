public class Spartan {

    private String nombre;
    private int escudo, salud;
    private String armaprincipal;

    // Constructor
    public Spartan(String nombre, int escudo, int salud, String armaprincipal) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.salud = salud;
        this.armaprincipal = armaprincipal;
    }

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
    private void ConsultaCortana(){
        System.out.println("Conversacion privada");
    }
    //Zona de Getts y Setts
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getArmaprincipal() {
        return armaprincipal;
    }

    public void setArmaprincipal(String armaprincipal) {
        this.armaprincipal = armaprincipal;
    }
}