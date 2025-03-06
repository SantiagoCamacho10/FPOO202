public class Soldado {
    protected String nombre;
    protected int salud;
    protected String arma;

    public Soldado(String nombre, int salud, String arma) {
        this.nombre = nombre;
        this.salud = salud;
        this.arma = arma;
    }

    public void atacar(String enemigo) {
        System.out.println(nombre + " ataca a " + enemigo + " con " + arma);
    }

    public void recibirDano(int dano) {
        salud -= dano;
        if (salud <= 0) {
            salud = 0;
            System.out.println(nombre + " ha sido eliminado.");
        } else {
            System.out.println(nombre + " ahora tiene " + salud + " de salud.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Soldado: " + nombre);
        System.out.println("Salud: " + salud);
        System.out.println("Arma: " + arma);
    }
}
