import javax.swing.JOptionPane;

public class cuenta {
    // Atributos públicos para simplificar el ejemplo
    public String numeroCuenta;
    public String titular;
    public int edad;
    public double saldo;

    // Métodos de la clase

    public void consultarSaldo() {
        JOptionPane.showMessageDialog(null, "El saldo de la cuenta " + numeroCuenta + " es: $" + saldo);
    }

    public void ingresarEfectivo(double monto) {
        if (monto > 0) {
            saldo += monto;
            JOptionPane.showMessageDialog(null, "Ingresaste $" + monto + ". Saldo actual: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0.");
        }
    }

    public void retirarEfectivo(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiraste $" + monto + ". Saldo actual: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede retirar esa cantidad. Verifica el saldo.");
        }
    }

    public void transferir(cuenta cuentaDestino, double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            cuentaDestino.saldo += monto;
            JOptionPane.showMessageDialog(null, "Transferiste $" + monto + " a la cuenta " + cuentaDestino.numeroCuenta + ". Tu nuevo saldo es: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede transferir esa cantidad. Verifica el saldo.");
        }
    }
}
