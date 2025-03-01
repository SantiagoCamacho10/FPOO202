import javax.swing.*;
public class Vehiculo {
    private String placa;
    private String modelo;
    private double capacidadCarga;
    private Conductor conductor; //RELACION CON CLASE CONDUCTOR

    //CONSTRUCTOR
    public Vehiculo() {
        this.placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo: ");
        this.modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo: ");
        this.capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga (kg): "));
        this.conductor = null; //NO HAY CONDUCTOR ASIGNADO
    }

    //GETTERS Y SETTERS
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void asignarConductor(Conductor conductor) {
        if (this.conductor == null) {
            this.conductor = conductor;
            JOptionPane.showMessageDialog(null, "Conductor asignado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Este vehiculo ya tiene un conductor asignado");
        }
    }

}
