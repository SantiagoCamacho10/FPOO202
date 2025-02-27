import javax.swing.JOptionPane;

public class cuenta {
    private String numeroCuenta;
    private String titular;
    private int edad;
    private double saldo;

    // Constructor
    public cuenta(String numeroCuenta, String titular, int edad, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.edad = edad;
        this.saldo = saldo;
    }

    // Métodos de la clase
    public void consultarSaldo() {
        JOptionPane.showMessageDialog(null, "El saldo de la cuenta " + numeroCuenta + " es: $" + saldo);
    }

    public void ingresarEfectivo(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            JOptionPane.showMessageDialog(null, "Ingresaste $" + monto + ". Saldo actual: $" + getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0.");
        }
    }

    public void retirarEfectivo(double monto) {
        if (monto > 0 && monto <= saldo) {
            setSaldo(getSaldo() - monto);
            JOptionPane.showMessageDialog(null, "Retiraste $" + monto + ". Saldo actual: $" + getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede retirar esa cantidad. Verifica el saldo.");
        }
    }

    public void transferir(cuenta cuentaDestino, double monto) {
        if (monto > 0 && monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            JOptionPane.showMessageDialog(null,
                    "Transferiste $" + monto + " a la cuenta " + cuentaDestino.getNumeroCuenta() +
                            ". Tu nuevo saldo es: $" + getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede transferir esa cantidad. Verifica el saldo.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
