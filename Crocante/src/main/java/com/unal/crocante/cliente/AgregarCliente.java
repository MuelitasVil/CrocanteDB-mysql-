package com.unal.crocante.cliente;

import com.unal.crocante.MysqlConexion;
import com.unal.crocante.venta.AgregarVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VenusBaquero
 */
public class AgregarCliente extends javax.swing.JFrame {

    Connection conexion;

    /**
     * Creates new form AgregarCliente
     */
    public AgregarCliente() {
        initComponents();
        MysqlConexion conector = new MysqlConexion("Venus", "gerente");
        conexion = conector.iniciarConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idFormattedTextField = new javax.swing.JFormattedTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoTextField = new javax.swing.JTextField();
        dirLabel = new javax.swing.JLabel();
        dirTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneFormattedTextField = new javax.swing.JFormattedTextField();
        mailLabel = new javax.swing.JLabel();
        mailTextField = new javax.swing.JTextField();
        editText = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        idLabel.setText("Id Cliente:");

        idFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        dirLabel.setText("Dirección:");

        phoneLabel.setText("Teléfono:");

        phoneFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        mailLabel.setText("Correo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dirLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idFormattedTextField)
                    .addComponent(phoneFormattedTextField)
                    .addComponent(nombreTextField)
                    .addComponent(apellidoTextField)
                    .addComponent(dirTextField)
                    .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dirLabel)
                    .addComponent(dirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLabel)
                    .addComponent(mailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        editText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editText.setText("Agregar Cliente");

        addBtn.setText("Aceptar");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(addBtn)
                        .addGap(27, 27, 27)
                        .addComponent(cancelBtn)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        long id = -1;
        String nombre = null;
        String apellido = null;
        String direccion = null;
        long phone = 0;
        String correo = null;

        try {
            id = Long.parseLong(idFormattedTextField.getText());
            nombre = nombreTextField.getText();
            if (!(apellidoTextField.getText().equals(null))) {
                apellido = apellidoTextField.getText();
            }

            if (!dirTextField.getText().equals(null)) {
                direccion = dirTextField.getText();
            }

            if (!phoneFormattedTextField.getText().equals(null)) {
                phone = Long.parseLong(phoneFormattedTextField.getText());
            }

            if (!mailTextField.getText().equals(null)) {
                correo = mailTextField.getText();
            }

        } catch (NumberFormatException numberFormatException) {
            Logger.getLogger(AgregarVenta.class.getName()).log(Level.SEVERE, null, numberFormatException);
            JOptionPane.showMessageDialog(this, "No se insertaron datos validos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String insert = "insert into persona values (?,?,?,?,?,?);";
        System.out.println(insert);

        PreparedStatement s;
        try {
            s = conexion.prepareStatement(insert);
            s.setLong(1, id);
            s.setString(2, nombre);
            s.setString(3, apellido);
            s.setString(4, direccion);
            s.setLong(5, phone);
            s.setString(6, correo);

            int resultado = s.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro satisfactorio", "Exito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Imposible añadir el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField apellidoTextField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel dirLabel;
    private javax.swing.JTextField dirTextField;
    private javax.swing.JLabel editText;
    private javax.swing.JFormattedTextField idFormattedTextField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JFormattedTextField phoneFormattedTextField;
    private javax.swing.JLabel phoneLabel;
    // End of variables declaration//GEN-END:variables
}