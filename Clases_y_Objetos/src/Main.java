public class Main {
    public static void main(String[] args) {
        //Crear el primer objeto
        Spartan masterChief = new Spartan("John",100,100,"Martillo Gravitatorio");

        //Invocamos los metodos
        masterChief.MostrarInfo();
        masterChief.Atacar("Grunt");
        masterChief.RecargarArma(75);
        masterChief.Correr(true);

        /*Intento de uso de un metodo privado
        masterChief.ConsultaCortana();*/

        //Usamos get y set para cambiar atributo: nombre
        masterChief.setNombre("Santiago Gravitatorio");
        masterChief.MostrarInfo();
        System.out.println(masterChief.getNombre());

        //Creamos el segundo objeto
        Spartan Cortana = new Spartan("Cortana",1000,1000, "Espada de la Misericordia");

        //Invocamos los metodos
        Cortana.MostrarInfo();
        Cortana.Atacar("Elite");
        Cortana.RecargarArma(100);
        Cortana.Correr(false);
    }
}