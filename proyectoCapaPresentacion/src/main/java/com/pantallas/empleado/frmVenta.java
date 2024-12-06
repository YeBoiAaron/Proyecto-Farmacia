/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pantallas.empleado;

import com.control.Sesion;
import com.control.VentaControl;
import com.dtos.VentaDTO;
import com.persistencias.VentaPersistencia;
import com.servicios.VentaServicio;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martinez
 */
public class frmVenta extends javax.swing.JFrame {

    /**
     * Creates new form frmVenta
     */
    public frmVenta() {
        initComponents();
        setLocationRelativeTo(null);
        ventaControl = new VentaControl();
        ventaServicio = new VentaServicio();
        ventaPersistencia = new VentaPersistencia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        txfBuscarReceta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarReceta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfTotal = new javax.swing.JTextField();
        DecimalFormat df = new DecimalFormat("#.00");
        txfTotal.setText(df.format(0.00));
        btnCrearVenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        TablaIndicaciones = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miRealizarVenta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miConsultarRecetas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miConsultarInventario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        if(!Sesion.getUsuarioLogueado().getTipoUsuario().equals("Gerente")){
            jMenu4.setVisible(false);
            jMenu4.setEnabled(false);
        }
        miAgregarSucursal = new javax.swing.JMenuItem();
        menLabelSucursal = new javax.swing.JMenu();
        menLabelSucursal.setEnabled(false);
        menLabelSucursal.setText(Sesion.getSucursalEmpleado().getNombreSucursal());

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Numero de Receta:");

        btnBuscarReceta.setText("Buscar");
        btnBuscarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRecetaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Subtotal:");

        txfTotal.setEditable(false);

        btnCrearVenta.setText("Confirmar");
        btnCrearVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVentaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Cantidad", "Precio", "Surtir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableModel modelo = (DefaultTableModel) tblMedicamentos.getModel();
        modelo.addTableModelListener(e -> {
            int column = e.getColumn();
            int row = e.getFirstRow();

            if (column == 3) {
                boolean isSelected = (boolean) modelo.getValueAt(row, column);
                Object cantidadObj = modelo.getValueAt(row, 1);
                Object precioObj = modelo.getValueAt(row, 2);

                if (cantidadObj != null && precioObj != null) {
                    try {
                        float cantidad = (float) cantidadObj;
                        float precioUnitario = (float) precioObj;
                        float value = cantidad * precioUnitario;

                        float currentTotal = Float.parseFloat(txfTotal.getText());
                        if (isSelected) {
                            currentTotal += value;
                        } else {
                            currentTotal -= value;
                        }
                        txfTotal.setText(df.format(currentTotal));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error en el cálculo del total.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        TablaIndicaciones.setViewportView(tblMedicamentos);
        if (tblMedicamentos.getColumnModel().getColumnCount() > 0) {
            tblMedicamentos.getColumnModel().getColumn(0).setResizable(false);
            tblMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblMedicamentos.getColumnModel().getColumn(1).setResizable(false);
            tblMedicamentos.getColumnModel().getColumn(2).setResizable(false);
            tblMedicamentos.getColumnModel().getColumn(3).setResizable(false);
        }

        jMenu1.setText("Venta");

        miRealizarVenta.setText("Realizar Venta");
        miRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRealizarVentaActionPerformed(evt);
            }
        });
        jMenu1.add(miRealizarVenta);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Recetas");

        miConsultarRecetas.setText("Consultar Recetas");
        miConsultarRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarRecetasActionPerformed(evt);
            }
        });
        jMenu2.add(miConsultarRecetas);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Inventario");

        miConsultarInventario.setText("Consultar Inventario");
        miConsultarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarInventarioActionPerformed(evt);
            }
        });
        jMenu3.add(miConsultarInventario);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sucursal");

        miAgregarSucursal.setText("Crear Sucursal");
        jMenu4.add(miAgregarSucursal);

        jMenuBar1.add(jMenu4);

        menLabelSucursal.setToolTipText("");
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(menLabelSucursal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCrearVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txfBuscarReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarReceta))
                        .addComponent(TablaIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfBuscarReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarReceta))
                .addGap(18, 18, 18)
                .addComponent(TablaIndicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearVenta)
                    .addComponent(btnCancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRealizarVentaActionPerformed
    }//GEN-LAST:event_miRealizarVentaActionPerformed

    private void miConsultarRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarRecetasActionPerformed
        frmRecetas recetas = new frmRecetas();
        recetas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miConsultarRecetasActionPerformed

    private void miConsultarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarInventarioActionPerformed
        frmInventarioMedicamentos inventario = new frmInventarioMedicamentos();
        inventario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miConsultarInventarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmInicioEmpleadoFarmacia frmAM = new frmInicioEmpleadoFarmacia();
        frmAM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        String numeroReceta = txfBuscarReceta.getText().trim();
        if (numeroReceta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número de receta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        receta = numeroReceta;
        DefaultTableModel modelo = ventaControl.buscarReceta(numeroReceta);
        tblMedicamentos.setModel(modelo);
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void txfBuscarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarRecetaActionPerformed

    private void btnCrearVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVentaActionPerformed
        Float subtotal = Float.valueOf(txfTotal.getText().trim());
        if(subtotal <= 0){
            JOptionPane.showMessageDialog(this, "Por favor selecciona medicamentos para surtir", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            VentaDTO ventaDto = new VentaDTO();
            ventaDto.setFolio(ventaServicio.generarFolio());
            ventaDto.setSubtotal(subtotal);
            Float total = subtotal + (subtotal * 0.16f);
            ventaDto.setTotal(total);
            ventaDto.setFecha(LocalDate.now());
            
            ventaPersistencia.agregarVenta(ventaDto, Sesion.getUsuarioLogueado().getNombreUsuario(), receta);
        }
    }//GEN-LAST:event_btnCrearVentaActionPerformed

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
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TablaIndicaciones;
    private javax.swing.JButton btnBuscarReceta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.Label label1;
    private javax.swing.JMenu menLabelSucursal;
    private javax.swing.JMenuItem miAgregarSucursal;
    private javax.swing.JMenuItem miConsultarInventario;
    private javax.swing.JMenuItem miConsultarRecetas;
    private javax.swing.JMenuItem miRealizarVenta;
    private javax.swing.JTable tblMedicamentos;
    private javax.swing.JTextField txfBuscarReceta;
    private javax.swing.JTextField txfTotal;
    // End of variables declaration//GEN-END:variables
  private String receta;
  private VentaControl ventaControl;
  private VentaPersistencia ventaPersistencia;
  private VentaServicio ventaServicio;
}
