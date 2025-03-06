public class Spartan extends Soldado {
    private int escudo;
    public Spartan(String nombre, int salud, String arma, int escudo) {
        super(nombre, salud, arma);
        this.escudo = escudo;
    }
    @Override
    public void recibirDano(int dano){
        if(escudo > 0){
            escudo -= dano;
            if (escudo < 0) {
                salud -= escudo;
                escudo = 0;
            }
            System.out.println(nombre+ " recibió daño: " +escudo+ " Salud: " + salud);
        }else{
            super.recibirDano(dano);
        }
    }
    public void recargarEscudo(){
        this.escudo = 100;
        System.out.println(nombre+ " no ha recargado escudo al Máximo ");
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Escudo: "+ this.escudo);
    }
}
