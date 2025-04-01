import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FormDelete extends JFrame {
    private Connection conn;
    private String tableName;
    private JFrame parentWindow;
    private JTextField conditionField;

    public FormDelete(Connection conn, String tableName, JFrame parent) {
        this.conn = conn;
        this.tableName = tableName;
        this.parentWindow = parent;
        initUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentWindow.setVisible(false);
    }

    

    private void initUI() {
        setTitle("Eliminar de: " + formatTableName(tableName));
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(248, 249, 250));

        // Header
        JLabel titleLabel = new JLabel("Eliminar Registros");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(244, 67, 54));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel de condición
        JPanel conditionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        conditionPanel.setBackground(Color.WHITE);
        conditionPanel.setBorder(new CompoundBorder(
            new LineBorder(new Color(230, 230, 230)),
            new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel instructionLabel = new JLabel("Ingrese la condición para eliminar (ej: id=5):");
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        conditionField = new JTextField();
        conditionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        conditionPanel.add(instructionLabel);
        conditionPanel.add(conditionField);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton btnDelete = new JButton("Confirmar Eliminación");
        styleButton(btnDelete, new Color(244, 67, 54), Color.BLACK);
        
        JButton btnBack = new JButton("Volver al CRUD");
        styleButton(btnBack, new Color(100, 100, 100), Color.BLACK);

        btnDelete.addActionListener(this::deleteData);
        btnBack.addActionListener(e -> {
            this.dispose();
            parentWindow.setVisible(true);
        });

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnBack);

        // Ensamblado
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(conditionPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void deleteData(ActionEvent e) {
        String condition = conditionField.getText().trim();
        if (condition.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una condición válida", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar estos registros?\nCondición: " + condition,
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM " + tableName + " WHERE " + condition;
                int affectedRows = conn.createStatement().executeUpdate(query);
                
                JOptionPane.showMessageDialog(
                    this,
                    "Registros eliminados: " + affectedRows,
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                conditionField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Error al eliminar: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setBorder(new CompoundBorder(
            new LineBorder(bgColor.darker(), 1),
            new EmptyBorder(10, 20, 10, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.brighter());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
    }

    private String formatTableName(String name) {
        return name.replace("_", " ").substring(0, 1).toUpperCase() + 
               name.replace("_", " ").substring(1);
    }
}
