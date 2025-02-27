import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        generar_Pass pass = new generar_Pass(8,false, false);
        String longitud = JOptionPane.showInputDialog("Ingresa la Longitud de la contraseña: ");
        // Verificar si el usuario no ingresó ningún valor o presionó cancelar
        if (longitud == null || longitud.trim().equals("")) {
            pass.setLenght(8); // Valor por defecto /////////////////////////
        } else {
            try {
                pass.setLenght(Integer.parseInt(longitud)); /////////////////////////
            } catch (NumberFormatException e) {
                // valor no numérico
                JOptionPane.showMessageDialog(null, "Valor inválido, se usará 8 por defecto.");
                pass.setLenght(8); /////////////////////////
            }
        }

        JCheckBox checkBox = new JCheckBox("Agregar mayusculas: ");
        Object[] message = {"Seleccione una opción:", checkBox};
        int option = JOptionPane.showConfirmDialog(null, message, "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Casilla marcada");
                pass.setInclude_May(true); /////////////////////////
            } else {
                JOptionPane.showMessageDialog(null, "Casilla no marcada");
                pass.setInclude_May(false); /////////////////////////
            }
        }

        JCheckBox checkBocs = new JCheckBox("Caracteres especiales: ");
        Object[] messages = {"Seleccione una opción:", checkBocs};
        int options = JOptionPane.showConfirmDialog(null, messages, "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        if (options == JOptionPane.OK_OPTION) {
            if (checkBocs.isSelected()) {
                JOptionPane.showMessageDialog(null, "Casilla marcada");
                pass.setCaract_Esp(true);
            } else {
                JOptionPane.showMessageDialog(null, "Casilla no marcada");
                pass.setCaract_Esp(false);
            }
        }

        // Generar y mostrar la contraseña
        String password = generar_Pass.getPassword(pass.getLenght(), pass.isInclude_May(), pass.isCaract_Esp()); /////////////////////////
        JOptionPane.showMessageDialog(null, "La contraseña generada es: " + password);
    }
}
