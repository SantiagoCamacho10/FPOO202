import javax.swing.*;

public class Envio {
    private String codigoEnvio;
    private String destino;
    private double peso;

    //CONSTRUCTOR 1: Codigo y destino
    public Envio(String codigoEnvio, String destino) {
        this.codigoEnvio = codigoEnvio;
        this.destino = destino;
        this.peso = 0; // Si no se ingresa peso, se inicializa en 0
    }

    // CONSTRUCTOR 2: Codigo, destino y peso
    public Envio(String codigoEnvio, String destino, double peso) {
        this.codigoEnvio = codigoEnvio;
        this.destino = destino;
        this.peso = peso;
    }

    // METODO ESTATICO ENVIO
    public static Envio crearEnvio() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del envio:");
        String destino = JOptionPane.showInputDialog("Ingrese el destino del envio:");
        String pesoStr = JOptionPane.showInputDialog("Ingrese el peso del envo (dejar vacio si no aplica):");

        if (pesoStr == null || pesoStr.trim().isEmpty()) {
            return new Envio(codigo, destino);
        } else {
            double peso = Double.parseDouble(pesoStr);
            return new Envio(codigo, destino, peso);
        }
    }

    // Getters y setters
    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
