package com.unal.crocante.cliente;

import com.unal.crocante.CalificacionPromedio;
import com.unal.crocante.Menu;
import com.unal.crocante.MysqlConexion;
import com.unal.crocante.Vista_caja;
import com.unal.crocante.venta.AgregarVenta;
import com.unal.crocante.venta.VentaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VenusBaquero
 */
public class ClientePrincipal extends javax.swing.JFrame {

    Connection conexion;

    /**
     * Creates new form ClientePrincipal
     */
    public ClientePrincipal() {
        initComponents();
        MysqlConexion conector = new MysqlConexion("Venus", "gerente");
        conexion = conector.iniciarConexion();
        String clienteQuery = "select * from persona"
                + " left join empleado on (per_id = Persona_per_id)"
                + " where Persona_per_id is null;";
        llenarInfoClientes(clienteQuery);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientes = new javax.swing.JTable();
        clienteLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        searchFormattedTextField = new javax.swing.JFormattedTextField();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        ccLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CC", "Nombre", "Apellido", "Dirección", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(clientes);

        clienteLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clienteLabel.setText("Clientes");

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Editar");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        sellButton.setText("Realizar Venta");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        searchFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Recargar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        ccLabel.setText("Ingrese la cédula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellButton))
                            .addComponent(backButton)
                            .addComponent(ccLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(clienteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(ccLabel)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(sellButton))
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if (searchFormattedTextField.getText().isEmpty()) {
            return;
        } else {
            String id = searchFormattedTextField.getText();
            String clienteQuery = "select * from persona"
                    + " left join empleado on (per_id = Persona_per_id)"
                    + " where Persona_per_id is null and per_id like '%" + id + "%';";

            System.out.println(clienteQuery);
            llenarInfoClientes(clienteQuery);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        String clienteQuery = "select * from persona"
                + " left join empleado on (per_id = Persona_per_id)"
                + " where Persona_per_id is null;";
        searchFormattedTextField.setText(null);
        searchFormattedTextField.setValue(null);
        llenarInfoClientes(clienteQuery);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AgregarCliente nuevo = new AgregarCliente();
        nuevo.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        DefaultTableModel model = (DefaultTableModel) clientes.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        String clienteQuery = "select * from persona"
                + " left join empleado on (per_id = Persona_per_id)"
                + " where Persona_per_id is null;";
        llenarInfoClientes(clienteQuery);
    }//GEN-LAST:event_formWindowGainedFocus

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = clientes.getSelectedRow();
        if (row >= 0) {
            System.out.println(clientes.getModel().getValueAt(row, 0));
            EditarCliente edit = new EditarCliente((Long) clientes.getModel().getValueAt(row, 0));
            edit.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        int row = clientes.getSelectedRow();
        if (row >= 0) {
            VentaPrincipal venta = new VentaPrincipal();
            AgregarVenta nueva = new AgregarVenta((Long) clientes.getModel().getValueAt(row, 0));
            venta.setVisible(true);
            nueva.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();

    }//GEN-LAST:event_sellButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
           
            PreparedStatement s = conexion.prepareStatement("SELECT car_nombre FROM Persona join Empleado on (per_id = persona_per_id) join Sesion on (a = per_nombre) join Cargo on (car_id = Cargo_car_id);");

            ResultSet resultado = s.executeQuery();

            resultado.next();
            
            String cargo = resultado.getString(1);
            
            System.out.println(cargo);
            
            if ("Cajero".equals(cargo)){
                
                 Vista_caja m = new Vista_caja();
                 m.setVisible(true);
                 dispose();
            
            }else{
                
                 dispose();   
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionPromedio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel ccLabel;
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JTable clientes;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JFormattedTextField searchFormattedTextField;
    private javax.swing.JButton sellButton;
    // End of variables declaration//GEN-END:variables

    private void llenarInfoClientes(String clienteQuery) {

        DefaultTableModel modelo = (DefaultTableModel) clientes.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.setRowCount(0);
        }

        PreparedStatement s;
        try {
            s = conexion.prepareStatement(clienteQuery);
            ResultSet result = s.executeQuery();
            while (result.next()) {
                long id = result.getLong(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String direccion = result.getString(4);
                long telefono = result.getLong(5);
                String correo = result.getString(6);
                DefaultTableModel model = (DefaultTableModel) clientes.getModel();
                model.addRow(new Object[]{id, nombre, apellido, direccion, telefono, correo});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
