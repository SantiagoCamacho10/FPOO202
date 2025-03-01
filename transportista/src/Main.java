import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo = null;
        Conductor conductor = null;
        Envio envio = null;
        Entrega entrega = null;
        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Menu de Gestion de Logistica\n" +
                            "1. Registrar Vehiculo\n" +
                            "2. Registrar Conductor\n" +
                            "3. Asignar Conductor a Vehiculo\n" +
                            "4. Registrar Envio\n" +
                            "5. Registrar Entrega\n" +
                            "6. Actualizar Estado de Entrega\n" +
                            "7. Mostrar Informacion\n" +
                            "8. Salir\n" +
                            "Ingrese una opcion:"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    vehiculo = new Vehiculo();
                    JOptionPane.showMessageDialog(null, "Vehiculo registrado con exito.");
                    break;
                case "2":
                    conductor = new Conductor();
                    JOptionPane.showMessageDialog(null, "Conductor registrado con exito");
                    break;
                case "3":
                    if (vehiculo != null && conductor != null) {
                        vehiculo.asignarConductor(conductor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe registrar un vehiculo y un conductor antes");
                    }
                    break;
                case "4":
                    envio = Envio.crearEnvio();
                    JOptionPane.showMessageDialog(null, "Envio registrado con exito.");
                    break;
                case "5":
                    if (envio != null) {
                        String numeroGuia = JOptionPane.showInputDialog("Ingrese el numero de guia:");
                        entrega = new Entrega(numeroGuia);
                        JOptionPane.showMessageDialog(null, "Entrega registrada con estado *Pendiente*");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe registrar un envío antes");
                    }
                    break;
                case "6":
                    if (entrega != null) {
                        entrega.actualizarEstado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe registrar una entrega antes");
                    }
                    break;
                case "7":
                    // Opción para mostrar la información utilizando getters
                    String info = "";
                    // Información del Vehículo
                    if (vehiculo != null) {
                        info += "Vehiculo:\n";
                        info += "Placa: " + vehiculo.getPlaca() + "\n";
                        info += "Modelo: " + vehiculo.getModelo() + "\n";
                        info += "Capacidad de Carga: " + vehiculo.getCapacidadCarga() + " kg\n";
                        if (vehiculo.getConductor() != null) {
                            Conductor c = vehiculo.getConductor();
                            info += "Conductor asignado:\n";
                            info += "  Nombre: " + c.getNombre() + "\n";
                            info += "  Identificacion: " + c.getIdentificacion() + "\n";
                            info += "  Licencia: " + c.getLicencia() + "\n";
                        } else {
                            info += "Conductor asignado: No asignado\n";
                        }
                    } else {
                        info += "Vehiculo no registrado\n";
                    }
                    info += "\n";

                    // Información del Conductor
                    if (conductor != null) {
                        info += "Conductor:\n";
                        info += "Nombre: " + conductor.getNombre() + "\n";
                        info += "Identificacion: " + conductor.getIdentificacion() + "\n";
                        info += "Licencia: " + conductor.getLicencia() + "\n";
                    } else {
                        info += "Conductor no registrado\n";
                    }
                    info += "\n";

                    // Información del Envio
                    if (envio != null) {
                        info += "Envio:\n";
                        info += "Codigo de Envio: " + envio.getCodigoEnvio() + "\n";
                        info += "Destino: " + envio.getDestino() + "\n";
                        info += "Peso: " + envio.getPeso() + " kg\n";
                    } else {
                        info += "Envio no registrado\n";
                    }
                    info += "\n";

                    // Información de la Entrega
                    if (entrega != null) {
                        info += "Entrega:\n";
                        info += "Numero de Guia: " + entrega.getNumeroGuia() + "\n";
                        info += "Estado: " + entrega.getEstado() + "\n";
                    } else {
                        info += "Entrega no registrada\n";
                    }

                    JOptionPane.showMessageDialog(null, info);
                    break;
                case "8":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion inválida");
                    break;
            }
        }
    }
}
