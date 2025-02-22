import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        generar_Pass pass = new generar_Pass();
        String longitud = JOptionPane.showInputDialog("Ingresa la Longitud de la contraseña: ");
        // Verificar si el usuario no ingresó ningún valor o presionó cancelar
        if (longitud == null || longitud.trim().equals("")) {
            pass.lenght = 8; // Valor por defecto
        } else {
            try {
                pass.lenght = Integer.parseInt(longitud);
            } catch (NumberFormatException e) {
                // valor no numérico
                JOptionPane.showMessageDialog(null, "Valor inválido, se usará 8 por defecto.");
                pass.lenght = 8;
            }
        }

        JCheckBox checkBox = new JCheckBox("Agregar mayusculas: ");
        Object[] message = {"Seleccione una opción:", checkBox};
        int option = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Casilla marcada");
                pass.include_May = true;
            } else {
                JOptionPane.showMessageDialog(null, "Casilla no marcada");
                pass.include_May = false;
            }
        }

        JCheckBox checkBocs = new JCheckBox("Caracteres especiales: ");
        Object[] messages = {"Seleccione una opción:", checkBocs};
        int options = JOptionPane.showConfirmDialog(null, messages, "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        if (options == JOptionPane.OK_OPTION) {
            if (checkBocs.isSelected()) {
                JOptionPane.showMessageDialog(null, "Casilla marcada");
                pass.caract_Esp = true;
            } else {
                JOptionPane.showMessageDialog(null, "Casilla no marcada");
                pass.caract_Esp = false;
            }
        }

        // Generar y mostrar la contraseña
        String password = generar_Pass.getPassword(pass.lenght, pass.include_May, pass.caract_Esp);
        JOptionPane.showMessageDialog(null, "La contraseña generada es: " + password);
    }
}
