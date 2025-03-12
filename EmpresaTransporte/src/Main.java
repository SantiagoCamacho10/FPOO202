import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Agregar Empleado", "Listar Empleados", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Empleados",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    agregarEmpleado();
                    break;
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }

    private static void agregarEmpleado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado:"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));

        String[] tipos = {"Conductor", "Administrativo"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de empleado", "Tipo de Empleado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        if (tipo == 0) {
            String licencia = JOptionPane.showInputDialog("Ingrese el tipo de licencia del conductor:");
            empleados.add(new Conductor(nombre, id, salario, licencia));
        } else {
            String departamento = JOptionPane.showInputDialog("Ingrese el departamento del administrativo:");
            empleados.add(new Administrativo(nombre, id, salario, departamento));
        }
    }

    private static void listarEmpleados() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            for (Empleado e : empleados) {
                e.mostrarInfo();
            }
        }
    }
}
