/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pantallas.empleado;

import com.control.Sesion;
import javax.swing.Box;

/**
 *
 * @author Aaron
 */
public class frmInicioEmpleadoFarmacia extends javax.swing.JFrame {

    /**
     * Creates new form frmInicioEmpleadoFarmacia
     */
    public frmInicioEmpleadoFarmacia() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());

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
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRealizarVentaActionPerformed
        frmVenta venta = new frmVenta();
        venta.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(frmInicioEmpleadoFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicioEmpleadoFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicioEmpleadoFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicioEmpleadoFarmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicioEmpleadoFarmacia().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menLabelSucursal;
    private javax.swing.JMenuItem miAgregarSucursal;
    private javax.swing.JMenuItem miConsultarInventario;
    private javax.swing.JMenuItem miConsultarRecetas;
    private javax.swing.JMenuItem miRealizarVenta;
    // End of variables declaration//GEN-END:variables
}
