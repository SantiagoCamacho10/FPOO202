import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class FormAdminsitracionArticulos extends javax.swing.JFrame {
    JTextField nombreField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField cantidadField = new JTextField();
        JTextField precioField = new JTextField();

        // Diseño del panel con los campos
        Object[] campos = {
            "Nombre:", nombreField,
            "Descripción:", descripcionField,
            "Cantidad:", cantidadField,
            "Precio por unidad:", precioField
        
        };
    public FormAdminsitracionArticulos() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setText("Administración de Artículos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Cantidad", "Precio/Unidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_buscar.setText("Consulta por ID");

        jLabel2.setText("ID:");

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addGap(37, 37, 37)
                        .addComponent(btn_eliminar)
                        .addGap(43, 43, 43)
                        .addComponent(btn_limpiar)))
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_buscar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_limpiar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
            null,
            campos,
            "Registro de Artículo",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        // Si el usuario hace clic en "OK"
        if (opcion == JOptionPane.OK_OPTION) {
            // Obtener los valores de los campos
            String nombre = nombreField.getText();
            String descripcion = descripcionField.getText();
            String cantidadStr = cantidadField.getText();
            String precioStr = precioField.getText();

            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || descripcion.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Todos los campos son obligatorios.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            try {
                // Convertir cantidad y precio a números
                int cantidad = Integer.parseInt(cantidadStr);
                double precio = Double.parseDouble(precioStr);

                // Mostrar mensaje de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quiere registrar este artículo?\n\n" +
                    "Nombre: " + nombre + "\n" +
                    "Descripción: " + descripcion + "\n" +
                    "Cantidad: " + cantidad + "\n" +
                    "Precio por unidad: $" + precio,
                    "Confirmar Registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );

                // Si confirma, guardar los datos (aquí puedes agregar tu lógica de guardado)
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Lógica para guardar los datos (ejemplo: en una base de datos o lista)
                    JOptionPane.showMessageDialog(
                        null,
                        "Artículo registrado exitosamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        "Registro cancelado.",
                        "Cancelado",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Cantidad y Precio deben ser números válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Registro cancelado.",
                "Cancelado",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btn_agregarActionPerformed
    private void limpiarCampos(){
            jTextField1.setText("");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); 
        }
    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormAdminsitracionArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdminsitracionArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdminsitracionArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdminsitracionArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdminsitracionArticulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btn_agregar;
    javax.swing.JButton btn_buscar;
    javax.swing.JButton btn_eliminar;
    javax.swing.JButton btn_limpiar;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable1;
    javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
