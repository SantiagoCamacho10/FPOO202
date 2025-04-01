import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FormRead extends JFrame {
    private Connection conn;
    private String tableName;
    private JFrame parentWindow;
    private DefaultTableModel model;
    private JTable table;

    public FormRead(Connection conn, String tableName, JFrame parent) throws SQLException {
        this.conn = conn;
        this.tableName = tableName;
        this.parentWindow = parent;
        initUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentWindow.setVisible(false);
    }

    private void initUI() throws SQLException {
        setTitle("Consultar: " + formatTableName(tableName));
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(248, 249, 250));

        // **Título centrado**
        JLabel titleLabel = new JLabel("Consultar Datos");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 150, 243));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel de búsqueda
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchPanel.setBackground(new Color(248, 249, 250));
        
        JLabel searchLabel = new JLabel("Buscar por ID:");
        searchLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JTextField searchField = new JTextField(15);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JButton searchButton = new JButton("Buscar");
        styleButton(searchButton, new Color(33, 150, 243), Color.BLACK);
        
        JButton showAllButton = new JButton("Mostrar Todos");
        styleButton(showAllButton, new Color(76, 175, 80), Color.BLACK);
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(showAllButton);

        // Tabla de datos
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);

        // Cargar todos los datos inicialmente
        loadData("SELECT * FROM " + tableName);

        // Acción para el botón de búsqueda
        searchButton.addActionListener(e -> {
            String id = searchField.getText().trim();
            if (!id.isEmpty()) {
                try {
                    loadData("SELECT * FROM " + tableName + " WHERE id = " + id);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Acción para el botón Mostrar Todos
        showAllButton.addActionListener(e -> {
            try {
                loadData("SELECT * FROM " + tableName);
                searchField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Botón Volver
        JButton btnBack = new JButton("Volver al CRUD");
        styleButton(btnBack, new Color(244, 67, 54), Color.BLACK);
        btnBack.addActionListener(e -> {
            this.dispose();
            parentWindow.setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnBack);

        // Ensamblado de los componentes
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(searchPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Reorganizar layout para mejor distribución
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        
        // Panel para los componentes superiores
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.CENTER);
        
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(contentPanel);
    }

    private void loadData(String query) throws SQLException {
    model.setRowCount(0); // Limpiar filas
    model.setColumnCount(0); // Limpiar columnas también (esto es clave)

    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        // Agregar columnas (solo una vez)
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(meta.getColumnName(i));
        }

        // Agregar datos
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
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