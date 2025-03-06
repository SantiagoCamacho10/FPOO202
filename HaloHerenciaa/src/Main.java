public class Main {
    public static void main(String[] args) {
        SpartanII jefemaestro = new SpartanII("John", 90, "Rifle de asalto", 0);
        jefemaestro.mostrarInfo();
        jefemaestro.usarManejoAvanzado();
        jefemaestro.atacar("Covenant");
        jefemaestro.recibirDano(50);
        jefemaestro.recargarEscudo();

        SpartanIII masterchief = new SpartanIII("Santi", 100, "Martillo Rotatorio", 150);
        masterchief.mostrarInfo();
        masterchief.camuflajeActivado();
        masterchief.atacar("Nave Covenant");
        masterchief.recibirDano(50);
        masterchief.recargarEscudo();

        SpartanIV superMasterChief = new SpartanIV("Ryan", 100, "MiniGun", 100);
        superMasterChief.mostrarInfo();
        superMasterChief.usarPropulsores();
        superMasterChief.atacar("ChekMalvado");
        superMasterChief.recibirDano(70);
        superMasterChief.recargarEscudo();
    }
}