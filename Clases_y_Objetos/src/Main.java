public class Main {
    public static void main(String[] args) {
        //Crear el primer objeto
        Spartan masterChief = new Spartan();

        //Usar Atributos
        masterChief.nombre="John";
        masterChief.salud=100;
        masterChief.escudo=100;
        masterChief.armaprincipal="Martillo Gravitatorio";

        //Invocamos los metodos
        masterChief.MostrarInfo();
        masterChief.Atacar("Grunt");
        masterChief.RecargarArma(75);
        masterChief.Correr(true);

        //Creamos el segundo objeto
        Spartan Cortana = new Spartan();

        //Usar Atributos
        masterChief.nombre="Cortana";
        masterChief.salud=1000;
        masterChief.escudo=1000;
        masterChief.armaprincipal="Espada de la Misericordia";

        //Invocamos los metodos
        masterChief.MostrarInfo();
        masterChief.Atacar("Elite");
        masterChief.RecargarArma(100);
        masterChief.Correr(false);
    }
}