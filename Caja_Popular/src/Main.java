import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Crear cuentas con el constructor
        cuenta cuenta1 = new cuenta("12345", "Santiago Camacho", 30, 1000.0);
        cuenta cuenta2 = new cuenta("67890", "Iván Sánchez", 25, 500.0);
        boolean continuar = true;

        while (continuar) {
            // Mostrar menú de opciones
            String opcion = JOptionPane.showInputDialog(
                    "Menú de Opciones:\n" +
                            "1. Consultar Saldo\n" +
                            "2. Ingresar Efectivo\n" +
                            "3. Retirar Efectivo\n" +
                            "4. Transferir a Otra Cuenta\n" +
                            "5. Salir\n" +
                            "Ingrese el número de opción:"
            );

            if (opcion == null) {
                break; // Si el usuario presiona "Cancelar"
            }

            switch (opcion) {
                case "1":
                    // Consultar saldo
                    String numCtaConsulta = JOptionPane.showInputDialog("Ingrese el número de cuenta:").trim();
                    if (numCtaConsulta.equals(cuenta1.getNumeroCuenta())) {
                        cuenta1.consultarSaldo();
                    } else if (numCtaConsulta.equals(cuenta2.getNumeroCuenta())) {
                        cuenta2.consultarSaldo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "2":
                    // Ingresar efectivo
                    String numCtaIngreso = JOptionPane.showInputDialog("Ingrese el número de cuenta:").trim();
                    double montoIngreso = obtenerMonto("Ingrese el monto a ingresar:");
                    if (montoIngreso < 0) break; // Si el monto es inválido

                    if (numCtaIngreso.equals(cuenta1.getNumeroCuenta())) {
                        cuenta1.ingresarEfectivo(montoIngreso);
                    } else if (numCtaIngreso.equals(cuenta2.getNumeroCuenta())) {
                        cuenta2.ingresarEfectivo(montoIngreso);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "3":
                    // Retirar efectivo
                    String numCtaRetiro = JOptionPane.showInputDialog("Ingrese el número de cuenta:").trim();
                    double montoRetiro = obtenerMonto("Ingrese el monto a retirar:");
                    if (montoRetiro < 0) break;

                    if (numCtaRetiro.equals(cuenta1.getNumeroCuenta())) {
                        cuenta1.retirarEfectivo(montoRetiro);
                    } else if (numCtaRetiro.equals(cuenta2.getNumeroCuenta())) {
                        cuenta2.retirarEfectivo(montoRetiro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
                    }
                    break;

                case "4":
                    // Transferir a otra cuenta
                    String numCtaOrigen = JOptionPane.showInputDialog("Ingrese el número de cuenta origen:").trim();
                    String numCtaDestino = JOptionPane.showInputDialog("Ingrese el número de cuenta destino:").trim();
                    double montoTransferir = obtenerMonto("Ingrese el monto a transferir:");
                    if (montoTransferir < 0) break;

                    if (numCtaOrigen.equals(cuenta1.getNumeroCuenta()) && numCtaDestino.equals(cuenta2.getNumeroCuenta())) {
                        cuenta1.transferir(cuenta2, montoTransferir);
                    } else if (numCtaOrigen.equals(cuenta2.getNumeroCuenta()) && numCtaDestino.equals(cuenta1.getNumeroCuenta())) {
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

    private static double obtenerMonto(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return -1; // Usuario canceló
            try {
                double monto = Double.parseDouble(input);
                if (monto > 0) {
                    return monto;
                } else {
                    JOptionPane.showMessageDialog(null, "El monto debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto inválido. Ingrese un número válido.");
            }
        }
    }
}
