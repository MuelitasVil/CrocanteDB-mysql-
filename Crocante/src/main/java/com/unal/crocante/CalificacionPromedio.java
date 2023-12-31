/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import com.mysql.cj.util.StringUtils;
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
 * @author sfc
 */
public class CalificacionPromedio extends javax.swing.JFrame {

    Connection conexion;

    /**
     * Creates new form CalificacionPromedio
     */
    public CalificacionPromedio() {
        initComponents();
        MysqlConexion conector = new MysqlConexion("Venus", "gerente");
        conexion = conector.iniciarConexion();
        cargarTabla();
        cargarclientes();
        cargarventasmes();
        cargarbarrio();
        ganancias();
        TiempoDomicilios();
        TiempoDomiciliosBarrio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        calificacion = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Clientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Dias = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tipo = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Producto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Venta = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Ganan = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Barrio = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TiempoPromedioBarrio = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TiempoPromedio = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        calificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto", "Promedio Estrellas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(calificacion);

        Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "Total Ventas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Clientes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mejores Clientes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Productos Mejor Calificados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Barrios que más venden");

        jPanel1.setBackground(new java.awt.Color(240, 109, 19));
        jPanel1.setForeground(new java.awt.Color(204, 102, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tipo de Producto");

        Dias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        Dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Más vendido");

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Día", "Ventas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Tipo);
        if (Tipo.getColumnModel().getColumnCount() > 0) {
            Tipo.getColumnModel().getColumn(0).setPreferredWidth(5);
            Tipo.getColumnModel().getColumn(0).setHeaderValue("ID");
            Tipo.getColumnModel().getColumn(2).setResizable(false);
            Tipo.getColumnModel().getColumn(2).setHeaderValue("Dir Entrega");
            Tipo.getColumnModel().getColumn(3).setResizable(false);
            Tipo.getColumnModel().getColumn(3).setHeaderValue("Barrio");
        }

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Día", "Ventas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(Producto);
        if (Producto.getColumnModel().getColumnCount() > 0) {
            Producto.getColumnModel().getColumn(1).setResizable(false);
            Producto.getColumnModel().getColumn(1).setHeaderValue("Dir Entrega");
            Producto.getColumnModel().getColumn(2).setResizable(false);
            Producto.getColumnModel().getColumn(2).setHeaderValue("Barrio");
        }

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Productos más vendidos por día");

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ventas realizadas", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Venta.setAutoscrolls(false);
        jScrollPane3.setViewportView(Venta);
        if (Venta.getColumnModel().getColumnCount() > 0) {
            Venta.getColumnModel().getColumn(1).setPreferredWidth(5);
            Venta.getColumnModel().getColumn(1).setHeaderValue("ID");
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Total ventas último mes");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Ganancia Hoy");

        Ganan.setEditable(false);
        Ganan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ganan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dias, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(75, 75, 75))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ganan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(Ganan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Barrio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "# Domicilios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Barrio);
        if (Barrio.getColumnModel().getColumnCount() > 0) {
            Barrio.getColumnModel().getColumn(0).setPreferredWidth(5);
            Barrio.getColumnModel().getColumn(0).setHeaderValue("ID");
            Barrio.getColumnModel().getColumn(2).setResizable(false);
            Barrio.getColumnModel().getColumn(2).setHeaderValue("Dir Entrega");
        }

        jButton2.setText("Volver a Menú");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TiempoPromedioBarrio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Barrio", "Tiempo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TiempoPromedioBarrio);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tiempo promedio por barrio");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tiempo promedio domicilio ");

        TiempoPromedio.setEditable(false);
        TiempoPromedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TiempoPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoPromedioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel12))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TiempoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TiempoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DefaultTableModel modelito = (DefaultTableModel) Tipo.getModel();
            while (modelito.getRowCount() > 0) {
                modelito.setRowCount(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) Producto.getModel();
            while (model.getRowCount() > 0) {
                model.setRowCount(0);
            }
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        MysqlConexion conector = new MysqlConexion("Venus", "gerente");
        Connection conexion = conector.iniciarConexion();
        cargarprocedimientos();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
            
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
                
                 Menu m = new Menu();
                 m.setVisible(true);
                 dispose();   
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionPromedio.class.getName()).log(Level.SEVERE, null, ex);
        }




        
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GananActionPerformed

    private void TiempoPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoPromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoPromedioActionPerformed

    private void cargarprocedimientos() {

        String TipoPro = Dias.getSelectedItem().toString();

        if (StringUtils.isNullOrEmpty(TipoPro)) {
            JOptionPane.showMessageDialog(this, "Seleccione un día de la semana", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String consulta = "Call Tipo_mas_dia(?);";

            PreparedStatement s;
            try {
                s = conexion.prepareStatement(consulta);
                s.setString(1, Dias.getSelectedItem().toString());
                ResultSet resultado = s.executeQuery();
                while (resultado.next()) {
                    int id = resultado.getInt(1);
                    String nombre = resultado.getString(2);
                    String dia = resultado.getString(3);
                    int ventas = resultado.getInt(4);

                    System.out.println(String.format("%s %s %s %s ", Integer.toString(id), nombre.toString(), dia.toString(), Integer.toString(ventas)));
                    DefaultTableModel model = (DefaultTableModel) Tipo.getModel();
                    model.addRow(new Object[]{id, nombre, dia, ventas});
                }

            } catch (SQLException ex) {
                Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            String consulta1 = "Call Venta_Producto_dia(?);";

            PreparedStatement s1;
            try {
                s1 = conexion.prepareStatement(consulta1);
                s1.setString(1, Dias.getSelectedItem().toString());
                ResultSet resultado = s1.executeQuery();
                while (resultado.next()) {
                    String nombre = resultado.getString(1);
                    String dia = resultado.getString(2);
                    int cantidad = resultado.getInt(3);

                    System.out.println(String.format("%s %s %s ", nombre.toString(), dia.toString(), Integer.toString(cantidad)));
                    DefaultTableModel model = (DefaultTableModel) Producto.getModel();
                    model.addRow(new Object[]{nombre, dia, cantidad});
                }

            } catch (SQLException ex) {
                Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

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
            java.util.logging.Logger.getLogger(CalificacionPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalificacionPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalificacionPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalificacionPromedio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalificacionPromedio().setVisible(true);
            }
        });
    }

    private void cargarTabla() {
        String consulta = "select * from vw_Mejores_Platos;";

        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                String pro = resultado.getString(1);
                int star = resultado.getInt(2);

                System.out.println(String.format("%s %s", pro.toString(), Integer.toString(star)));
                DefaultTableModel model = (DefaultTableModel) calificacion.getModel();
                model.addRow(new Object[]{pro, star});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarclientes() {
        String consulta = "select * from vw_Mejores_Clientes;";

        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                String Nombre = resultado.getString(1);
                String Apellido = resultado.getString(2);
                long tel = resultado.getLong(3);
                int totalv = resultado.getInt(4);

                System.out.println(String.format("%s %s %s %s", Nombre.toString(), Apellido.toString(), Long.toString(tel), Integer.toString(totalv)));
                DefaultTableModel model1 = (DefaultTableModel) Clientes.getModel();
                model1.addRow(new Object[]{Nombre, Apellido, tel, totalv});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarbarrio() {

        String consulta = "select * from vw_Barrio_mas_vende;";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                int ID = resultado.getInt(1);
                String Nombre = resultado.getString(2);
                int Numdom = resultado.getInt(3);

                System.out.println(String.format("%s %s %s ", Integer.toString(ID), Nombre.toString(), Integer.toString(Numdom)));
                DefaultTableModel model2 = (DefaultTableModel) Barrio.getModel();
                model2.addRow(new Object[]{ID, Nombre, Numdom});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarventasmes() {
        String consulta = "select * from vw_Venta_Mes;";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                long Total = resultado.getLong(1);
                int Ventas = resultado.getInt(2);

                System.out.println(String.format("%s %s", Long.toString(Total), Integer.toString(Ventas)));
                DefaultTableModel model1 = (DefaultTableModel) Venta.getModel();
                model1.addRow(new Object[]{Ventas, Total});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ganancias() {
        String consulta = "SELECT ganancia_diaria();";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            resultado.next();
            int Ganancia = resultado.getInt(1);

            System.out.println(String.format("%s", Integer.toString(Ganancia)));
            Ganan.setText(String.format("%s", Integer.toString(Ganancia)));
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionPromedio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void TiempoDomicilios() {
      String consulta = "call time_domicilio();";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                String Promedio = resultado.getString(1);            

            System.out.println(String.format("%s", Promedio));
            TiempoPromedio.setText(String.format("%s",Promedio));
            }
        }catch (SQLException ex) {
            Logger.getLogger(CalificacionPromedio.class.getName()).log(Level.SEVERE, null, ex);
        }
               
   }
   private void TiempoDomiciliosBarrio(){
     String consulta = "call time_domicilio_Barrio();";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                String Nombre = resultado.getString(1);
                String Promedio = resultado.getString(2);

                System.out.println(String.format("%s %s", Nombre ,Promedio));
                DefaultTableModel model1 = (DefaultTableModel) TiempoPromedioBarrio.getModel();
                model1.addRow(new Object[]{Nombre, Promedio});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CalificacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Barrio;
    private javax.swing.JTable Clientes;
    private javax.swing.JComboBox<String> Dias;
    private javax.swing.JTextField Ganan;
    private javax.swing.JTable Producto;
    private javax.swing.JTextField TiempoPromedio;
    private javax.swing.JTable TiempoPromedioBarrio;
    private javax.swing.JTable Tipo;
    private javax.swing.JTable Venta;
    private javax.swing.JTable calificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
