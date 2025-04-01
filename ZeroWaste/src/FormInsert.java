import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FormInsert extends JFrame {
    private Connection conn;
    private String tableName;
    private JFrame parentWindow;
    private java.util.List<JTextField> fields = new java.util.ArrayList<>();

    public FormInsert(Connection conn, String tableName, JFrame parent) throws SQLException {
        this.conn = conn;
        this.tableName = tableName;
        this.parentWindow = parent;
        initUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initUI() throws SQLException {
        setTitle("Insertar en " + formatTableName(tableName));
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(248, 249, 250));

        // Header
        JLabel titleLabel = new JLabel("Nuevo Registro");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos de formulario
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(0, 2, 15, 15)); // Más legible por separado
        fieldsPanel.setBackground(Color.WHITE);
        fieldsPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        ResultSetMetaData meta = conn.createStatement()
            .executeQuery("SELECT * FROM " + tableName + " LIMIT 1").getMetaData();

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            if (meta.getColumnName(i).equalsIgnoreCase("id")) continue;
            
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

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(248, 249, 250));

        JButton btnSave = new JButton("Guardar");
        styleButton(btnSave, new Color(76, 175, 80), Color.BLACK);

        JButton btnBack = new JButton("Volver al CRUD");
        styleButton(btnBack, new Color(244, 67, 54), Color.BLACK);

        // Acciones
        btnSave.addActionListener(this::insertData);
        btnBack.addActionListener(e -> {
            this.dispose();
            parentWindow.setVisible(true);
        });

        // Ensamblado
        buttonPanel.add(btnSave);
        buttonPanel.add(btnBack);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(fieldsPanel), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
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

    private void insertData(ActionEvent e) {
        try {
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            
            ResultSetMetaData meta = conn.createStatement()
                .executeQuery("SELECT * FROM " + tableName + " LIMIT 1").getMetaData();
            
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                String colName = meta.getColumnName(i);
                if (colName.equalsIgnoreCase("id")) continue;
                
                if (columns.length() > 0) {
                    columns.append(", ");
                    values.append(", ");
                }
                columns.append(colName);
                values.append("'").append(fields.get(i-2).getText()).append("'");
            }
            
            String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
            conn.createStatement().executeUpdate(query);
            
            JOptionPane.showMessageDialog(this, "Registro insertado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            fields.forEach(field -> field.setText(""));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}