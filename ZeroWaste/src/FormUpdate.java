import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class FormUpdate extends JFrame {
    private Connection conn;
    private String tableName;
    private JFrame parentWindow;
    private ArrayList<JTextField> fields = new ArrayList<>();
    private JTextField conditionField;

    public FormUpdate(Connection conn, String tableName, JFrame parent) throws SQLException {
        this.conn = conn;
        this.tableName = tableName;
        this.parentWindow = parent;
        initUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentWindow.setVisible(false);
    }


    private void initUI() throws SQLException {
        setTitle("Actualizar: " + formatTableName(tableName));
        setSize(700, 600);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(248, 249, 250));

        // Header
        JLabel titleLabel = new JLabel("Actualizar Registro");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos
        JPanel fieldsPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        fieldsPanel.setBackground(Color.WHITE);
        fieldsPanel.setBorder(new CompoundBorder(
            new LineBorder(new Color(230, 230, 230)),
            new EmptyBorder(20, 20, 20, 20)
        ));

        ResultSetMetaData meta = conn.createStatement()
            .executeQuery("SELECT * FROM " + tableName + " LIMIT 1").getMetaData();

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            JLabel label = new JLabel(formatColumnName(meta.getColumnName(i)));
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            
            JTextField textField = new JTextField();
            textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            textField.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(5, 10, 5, 10)
            ));
            
            fieldsPanel.add(label);
            fieldsPanel.add(textField);
            fields.add(textField);
        }

        // Condición WHERE
        JPanel conditionPanel = new JPanel(new BorderLayout());
        conditionPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JLabel conditionLabel = new JLabel("Condición WHERE (ej: id=1):");
        conditionLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        conditionField = new JTextField();
        conditionField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        conditionPanel.add(conditionLabel, BorderLayout.NORTH);
        conditionPanel.add(conditionField, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton btnUpdate = new JButton("Guardar Cambios");
        styleButton(btnUpdate, new Color(255, 193, 7), Color.BLACK);
        
        JButton btnBack = new JButton("Volver al CRUD");
        styleButton(btnBack, new Color(244, 67, 54), Color.BLACK);

        btnUpdate.addActionListener(this::updateData);
        btnBack.addActionListener(e -> {
            this.dispose();
            parentWindow.setVisible(true);
        });

        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnBack);

        // Ensamblado
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        mainPanel.add(conditionPanel, BorderLayout.SOUTH);
        
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(contentPanel);
    }

    private void updateData(ActionEvent e) {
        try {
            StringBuilder setClause = new StringBuilder();
            ResultSetMetaData meta = conn.createStatement()
                .executeQuery("SELECT * FROM " + tableName + " LIMIT 1").getMetaData();
            
            for (int i = 0; i < fields.size(); i++) {
                if (!fields.get(i).getText().isEmpty()) {
                    if (setClause.length() > 0) setClause.append(", ");
                    setClause.append(meta.getColumnName(i+1))
                             .append("='")
                             .append(fields.get(i).getText())
                             .append("'");
                }
            }
            
            String condition = conditionField.getText();
            if (setClause.length() == 0 || condition.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los campos requeridos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + condition;
            int affectedRows = conn.createStatement().executeUpdate(query);
            
            JOptionPane.showMessageDialog(this, 
                affectedRows + " registro(s) actualizado(s)", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private String formatColumnName(String name) {
        return formatTableName(name) + ":";
    }
}
