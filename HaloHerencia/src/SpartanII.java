public class SpartanII extends Spartan {
    public SpartanII(String nombre, int salud, String arma, int escudo) {
        super(nombre, salud, arma, 150);
    }

    public void usarManejoAvanzado(){
        System.out.println(nombre+ " Usa tacticas avanzadas y cuenta con más Escudo");
    }
}
