import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MENU extends JFrame {
    private Connection conn;
    private String selectedTable = "";
    private JLabel titleLabel;
    private JPanel cardsPanel;
    private CardLayout cardLayout;

    // Lista de tablas con íconos personalizados
    private static final Object[][] TABLES = {
        {"📋", "administradores", "Administradores"},
        {"📄", "articulos_blog", "Artículos Blog"},
        {"🎯", "campanas", "Campañas"},
        {"🗂️", "categorias", "Categorías"},
        {"🖼️", "detalles_articulos", "Detalles Artículos"},
        {"✍️", "editores_blog", "Editores Blog"},
        {"📝", "inscripciones_campanas", "Inscripciones Campañas"},
        {"📋", "inscripciones_talleres", "Inscripciones Talleres"},
        {"👥", "organizadores", "Organizadores"},
        {"🗑️", "puntos_reciclaje", "Puntos Reciclaje"},
        {"🎓", "talleres_cursos", "Talleres/Cursos"},
        {"♻️", "tipos_desecho", "Tipos Desecho"},
        {"👤", "usuarios", "Usuarios"}
    };

    public MENU() {
        this.conn = ConexionSQL.conectar();
        initUI();
    }

    private void initUI() {
        setTitle("ZeroWaste CRUD");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Panel principal con CardLayout para transiciones
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        cardsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // 1. Panel de selección de tablas
        JPanel tablesPanel = createTablesPanel();
        cardsPanel.add(tablesPanel, "tables");

        // 2. Panel de operaciones CRUD
        JPanel crudPanel = createCrudPanel();
        cardsPanel.add(crudPanel, "crud");

        add(createHeader(), BorderLayout.NORTH);
        add(cardsPanel, BorderLayout.CENTER);
        

        
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(34, 139, 34));
        header.setBorder(new EmptyBorder(15, 25, 15, 25));

        titleLabel = new JLabel("ZeroWaste CRUD");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);


        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
        

        header.add(titlePanel, BorderLayout.WEST);

        return header;
    }

    private JPanel createTablesPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 15, 0);

        JLabel subtitle = new JLabel("Seleccione una tabla:");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle, gbc);

        JPanel buttonsPanel = new JPanel(new GridLayout(0, 3, 20, 20));
        buttonsPanel.setBackground(new Color(245, 245, 245));
        buttonsPanel.setBorder(new EmptyBorder(10, 50, 30, 50));

        for (Object[] table : TABLES) {
            JButton btn = createTableButton((String) table[0], (String) table[2]);
            btn.addActionListener(e -> {
                selectedTable = (String) table[1];
                titleLabel.setText("ZeroWaste CRUD - " + table[2]);
                cardLayout.show(cardsPanel, "crud");
            });
            buttonsPanel.add(btn);
        }

        gbc.weighty = 1;
        panel.add(buttonsPanel, gbc);

        return panel;
    }

    private JButton createTableButton(String icon, String text) {
        JButton button = new JButton("<html><center>" + icon + "<br>" + text + "</center></html>");
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(180, 100));
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(34, 139, 34));
        button.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(10, 10, 10, 10)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // Efecto hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(240, 255, 240));
                button.setBorder(new CompoundBorder(
                    new LineBorder(new Color(34, 139, 34), 1),
                    new EmptyBorder(10, 10, 10, 10)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setBorder(new CompoundBorder(
                    new LineBorder(new Color(200, 200, 200), 1),
                    new EmptyBorder(10, 10, 10, 10)
                ));
            }
        });

        return button;
    }

    private JPanel createCrudPanel() {
    // Panel principal
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(new Color(248, 249, 250)); // Fondo gris claro
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));

    // Título de la tabla seleccionada
    JLabel tableTitle = new JLabel("Tabla: " + formatTableName(selectedTable));
    tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
    tableTitle.setForeground(new Color(33, 150, 243));
    tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
    tableTitle.setBorder(new EmptyBorder(0, 0, 20, 0));

    // Panel de botones CRUD (centrado con Grid)
    JPanel buttonsPanel = new JPanel(new GridLayout(2, 2, 30, 30));
    buttonsPanel.setBackground(new Color(248, 249, 250));
    buttonsPanel.setBorder(new EmptyBorder(50, 150, 50, 150));

    // Configuración de botones
    String[] options = {
        "✨ Insertar Datos", 
        "🔍 Consultar Datos", 
        "✏️ Actualizar Datos", 
        "❌ Eliminar Datos"
    };
    
    Color[] colors = {
        new Color(33, 150, 243),  // Azul brillante
        new Color(76, 175, 80),   // Verde éxito
        new Color(255, 193, 7),   // Amarillo oro
        new Color(244, 67, 54)    // Rojo alerta
    };

    // Crear botones CRUD
    for (int i = 0; i < options.length; i++) {
        JButton btn = createCrudButton(options[i], colors[i]);
        final int option = i;
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    switch (option) {
                        case 0 -> {
                            // Insertar
                            MENU.this.setVisible(false);
                            new FormInsert(conn, selectedTable, MENU.this).setVisible(true);
                        }
                        case 1 -> {
                            MENU.this.setVisible(false);
                            new FormRead(conn, selectedTable, MENU.this).setVisible(true);
                        }
                        case 2 ->{ 
                            MENU.this.setVisible(false);
                            new FormUpdate(conn, selectedTable, MENU.this).setVisible(true);
                        }
                        case 3 -> {
                            MENU.this.setVisible(false);
                            new FormDelete(conn, selectedTable, MENU.this).setVisible(true);
                        }
                    }
                }catch (SQLException ex) {
                    showErrorDialog("Error: " + ex.getMessage());
                }
            }
        });
        buttonsPanel.add(btn);
    }

    // Botón "Volver"
    JButton backBtn = new JButton("↩ Volver a la selección de tablas");
    backBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Corregido: "PLAIN" en lugar de "PLAN"
    backBtn.setBackground(new Color(240, 240, 240));
    backBtn.setForeground(new Color(100, 100, 100));
    backBtn.setBorder(new CompoundBorder(
        new LineBorder(new Color(200, 200, 200)), // Paréntesis cerrado aquí
        new EmptyBorder(10, 20, 10, 20)
    ));
    backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    backBtn.addActionListener(e -> cardLayout.show(cardsPanel, "tables"));

    // Efecto hover para el botón Volver
    backBtn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            backBtn.setBackground(new Color(230, 230, 230));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            backBtn.setBackground(new Color(240, 240, 240));
        }
    });

    // Ensamblar componentes
    panel.add(tableTitle, BorderLayout.NORTH);
    panel.add(buttonsPanel, BorderLayout.CENTER);
    panel.add(backBtn, BorderLayout.SOUTH);

    return panel;
}

    private JButton createCrudButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(new Color(34, 139, 34));
        button.setBorder(new EmptyBorder(20, 10, 20, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        return button;
    }


    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, 
            message, 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new MENU().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Error al iniciar la aplicación: " + e.getMessage(), 
                    "Error crítico", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private String formatTableName(String tableName) {
    if (tableName == null || tableName.isEmpty()) {
        return "Seleccione tabla"; // Texto por defecto
    }
    
    // Versión segura con manejo de errores
    try {
        return tableName.replace("_", " ")
                       .substring(0, 1).toUpperCase() + 
               tableName.replace("_", " ").substring(1);
    } catch (StringIndexOutOfBoundsException e) {
        return tableName; // Devuelve el nombre original si hay error
    }
}
}