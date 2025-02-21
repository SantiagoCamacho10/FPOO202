import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        cuenta cuenta1 = new cuenta();
        cuenta1.numeroCuenta = "12345";
        cuenta1.titular = "Santiago Camacho";
        cuenta1.edad = 30;
        cuenta1.saldo = 1000.0;

        cuenta cuenta2 = new cuenta();
        cuenta2.numeroCuenta = "67890";
        cuenta2.titular = "Iván Sánchez";
        cuenta2.edad = 25;
        cuenta2.saldo = 500.0;
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú de opciones
            String opcion = JOptionPane.showInputDialog(
                    "Menú de Opciones: \n" + "1. Consultar Saldo\n" + "2. Ingresar Efectivo\n" + "3. Retirar Efectivo\n" + "4. Transferir a Otra Cuenta\n" + "5. Salir. \n" + "Ingrese el número de opción:");

            if (opcion == null) {
                break;
            }
            switch (opcion) {
                case "1":
                    // Consultar saldo
                    String numCtaConsulta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
                    if (numCtaConsulta.equals(cuenta1.numeroCuenta)) {
                        cuenta1.consultarSaldo();
                    } else if (numCtaConsulta.equals(cuenta2.numeroCuenta)) {
                        cuenta2.consultarSaldo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "2":
                    // Ingresar efectivo
                    String numCtaIngreso = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
                    String montoIngStr = JOptionPane.showInputDialog("Ingrese el monto a ingresar:");
                    double montoIngreso = Double.parseDouble(montoIngStr);

                    if (numCtaIngreso.equals(cuenta1.numeroCuenta)) {
                        cuenta1.ingresarEfectivo(montoIngreso);
                    } else if (numCtaIngreso.equals(cuenta2.numeroCuenta)) {
                        cuenta2.ingresarEfectivo(montoIngreso);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "3":
                    // Retirar efectivo
                    String numCtaRetiro = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
                    String montoRetStr = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                    double montoRetiro = Double.parseDouble(montoRetStr);

                    if (numCtaRetiro.equals(cuenta1.numeroCuenta)) {
                        cuenta1.retirarEfectivo(montoRetiro);
                    } else if (numCtaRetiro.equals(cuenta2.numeroCuenta)) {
                        cuenta2.retirarEfectivo(montoRetiro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "4":
                    // Transferir a otra cuenta
                    String numCtaOrigen = JOptionPane.showInputDialog("Ingrese el número de cuenta origen:");
                    String numCtaDestino = JOptionPane.showInputDialog("Ingrese el número de cuenta destino:");
                    String montoTransStr = JOptionPane.showInputDialog("Ingrese el monto a transferir:");
                    double montoTransferir = Double.parseDouble(montoTransStr);

                    if (numCtaOrigen.equals(cuenta1.numeroCuenta) && numCtaDestino.equals(cuenta2.numeroCuenta)) {
                        cuenta1.transferir (cuenta2, montoTransferir);
                    } else if (numCtaOrigen.equals(cuenta2.numeroCuenta) && numCtaDestino.equals(cuenta1.numeroCuenta)) {
                        cuenta2.transferir(cuenta1, montoTransferir);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta de origen o destino incorrecta.");
                    }
                    break;

                case "5":
                    // Salir
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}
