import javax.swing.*;

public class Conductor {
    private String nombre;
    private String identificacion;
    private String licencia;

    //CONSTRUCTOR
    public Conductor() {
        this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del conductor: ");
        this.identificacion = JOptionPane.showInputDialog("Ingrese la identificacion del conductor: ");
        this.licencia = JOptionPane.showInputDialog("Ingrese el numero de licencia del conductor: ");
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getLicencia() {
        return licencia;
    }
}

