import javax.swing.*;

public class Empleado {
    protected String nombre;
    protected int id;
    protected double salario;

    public Empleado(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Empleado: " + nombre +
                "\nID: " + id +
                "\nSalario: " + salario);
    }
}

