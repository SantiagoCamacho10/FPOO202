import java.util.Random;
import java.time.Year;

class GenerarMatricula {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int anioNacimiento;
    private String carrera;
    private String matricula;


    public GenerarMatricula(String nombre, String apellidoPaterno, String apellidoMaterno, int anioNacimiento, String carrera) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.anioNacimiento = anioNacimiento;
        this.carrera = carrera;
        this.matricula = generarMatricula();
    }

    private String generarMatricula() {
        Random rand = new Random();
        int anioActual = Year.now().getValue(); // Obtiene el año actual
        String primeraLetraNombre = nombre.substring(0, 1).toUpperCase();
        String dosLetrasApellidoPaterno = apellidoPaterno.substring(0, 2).toUpperCase();
        String dosLetrasApellidoMaterno = apellidoMaterno.substring(0, 2).toUpperCase();
        String dosUltimosNacimiento = String.valueOf(anioNacimiento).substring(2);
        String dosUltimosActual = String.valueOf(anioActual).substring(2);
        String tresLetrasCarrera = carrera.substring(0, 3).toUpperCase();
        String dosDigitosAleatorios = String.format("%02d", rand.nextInt(100));

        return primeraLetraNombre + dosLetrasApellidoPaterno + dosLetrasApellidoMaterno + dosUltimosNacimiento + dosUltimosActual + tresLetrasCarrera + dosDigitosAleatorios;
    }

    public String getMatricula() {
        return matricula;
    }

    public String obtenerInformacion() {
        return "Nombre completo: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + "\n" +
                "Año de Nacimiento: " + anioNacimiento + "\n" +
                "Carrera: " + carrera + "\n" +
                "Matrícula Generada: " + matricula;
    }
}
