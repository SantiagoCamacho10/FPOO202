import javax.swing.*;

public class Entrega {
    private String numeroGuia;
    private String estado;

    // Constructor (Estado "Pendiente" por defecto)
    public Entrega(String numeroGuia) {
        this.numeroGuia = numeroGuia;
        this.estado = "Pendiente";
    }

    //METODO ACTUALIZAR ESTADO
    public void actualizarEstado() {
        String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (En transito / Entregado): ");

        if (nuevoEstado.equalsIgnoreCase("En transito") || nuevoEstado.equalsIgnoreCase("Entregado")) {
            this.estado = nuevoEstado;
            JOptionPane.showMessageDialog(null, "Estado actualizado a: " + this.estado);
        } else {
            JOptionPane.showMessageDialog(null, "Estado invalido. Solo se permite *En transito* o *Entregado*.");
        }
    }

    //GETTERS Y SETTERS
    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
