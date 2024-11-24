/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import ui.empleado.jpnInicio;
import ui.empleado.jpnInventario;
import ui.empleado.jpnRecetas;
import ui.empleado.jpnVenta;
import ui.medico.jpnConsultasMed;
import ui.medico.jpnInicioMed;
import ui.medico.jpnMedicamentosMed;
import ui.medico.jpnRecetaMed;

/**
 *
 * @author martinez
 */
public class Farmacia extends javax.swing.JFrame {
    private int xMouse, yMouse;
    /**
     * Creates new form Farmacia
     */
    public Farmacia() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setSize(710, 520);
        initComponents();
        setLocationRelativeTo(null);
        
        RoundedPanel mainPanel = new RoundedPanel(50, new Color(51,51,51));
        mainPanel.setOpaque(false);
        setContentPane(mainPanel);
        
        // Añadir un layout para respetar margenes internos
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(layout);

        // Ajustar márgenes para evitar que los componentes cubran los bordes redondeados
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10) // Márgenes izquierdos
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGap(10)) // Márgenes derechos
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10) // Márgenes superiores
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGap(10)) // Márgenes inferiores
        );
        
        pnlMain.setOpaque(false);
        pnlTopBar.setOpaque(false);
        
        pnlTopBar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });

        pnlTopBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
            }
        });
        
        jpnLogin login = new jpnLogin();
        jpnInicio inicioEmpleado = new jpnInicio();
        jpnVenta ventaEmpleado = new jpnVenta();
        jpnRecetas recetaEmpleado = new jpnRecetas();
        jpnInventario inventarioEmpleado = new jpnInventario();
        jpnInicioMed inicioMedico = new jpnInicioMed();
        jpnRecetaMed recetasMedico = new jpnRecetaMed();
        jpnConsultasMed consultasMedico = new jpnConsultasMed();
        jpnMedicamentosMed medicamentosMedico = new jpnMedicamentosMed();
        
        contentPanel.add(login, "Login");
        contentPanel.add(inicioEmpleado, "InicioEmpleado");
        contentPanel.add(ventaEmpleado, "VentaEmpleado");
        contentPanel.add(recetaEmpleado, "RecetaEmpleado");
        contentPanel.add(inventarioEmpleado, "InventarioEmpleado");
        contentPanel.add(inicioMedico, "InicioMedico");
        contentPanel.add(recetasMedico, "RecetasMedico");
        contentPanel.add(consultasMedico, "ConsultasMedico");
        contentPanel.add(medicamentosMedico, "MedicamentosMedico");
        
        lblEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("InicioEmpleado");
            }
        });
        lblVenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("VentaEmpleado");
            }
        });
        lblReceta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("RecetaEmpleado");
            }
        });
        
        lblMedico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("InicioMedico");
            }
        });
        lblRecetaMed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("RecetasMedico");
            }
        });
        lblConsultaMed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("ConsultasMedico");
            }
        });
        lblMedicamentosMed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("MedicamentosMedico");
            }
        });
        lblInventario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel("InventarioEmpleado");
            }
        });
    }
    
    /**
     * Panel personalizado con bordes redondeados.
     */
    private static class RoundedPanel extends JPanel {
        private final int cornerRadius;
        private final Color backgroundColor;

        public RoundedPanel(int cornerRadius, Color backgroundColor) {
            this.cornerRadius = cornerRadius;
            this.backgroundColor = backgroundColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar el fondo con bordes redondeados
            g2.setColor(backgroundColor);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

            g2.dispose();
        }
    }
    
    public void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlTopBar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMedico = new javax.swing.JLabel();
        lblReceta = new javax.swing.JLabel();
        lblInventario = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        lblVenta = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRecetaMed = new javax.swing.JLabel();
        lblConsultaMed = new javax.swing.JLabel();
        lblMedicamentosMed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(51, 51, 51));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTopBar.setBackground(new java.awt.Color(0, 0, 0));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimizar.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expandir.png"))); // NOI18N

        javax.swing.GroupLayout pnlTopBarLayout = new javax.swing.GroupLayout(pnlTopBar);
        pnlTopBar.setLayout(pnlTopBarLayout);
        pnlTopBarLayout.setHorizontalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnCerrar)
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(jLabel19)
                .addContainerGap(644, Short.MAX_VALUE))
        );
        pnlTopBarLayout.setVerticalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlTopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú de Empleado");
        pnlMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lblMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedico.setForeground(new java.awt.Color(255, 255, 255));
        lblMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/medico.png"))); // NOI18N
        lblMedico.setText("Medico");
        lblMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMedicoMouseClicked(evt);
            }
        });
        pnlMain.add(lblMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblReceta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblReceta.setForeground(new java.awt.Color(255, 255, 255));
        lblReceta.setText("Receta");
        lblReceta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        lblInventario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInventario.setForeground(new java.awt.Color(255, 255, 255));
        lblInventario.setText("Inventario");
        lblInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        contentPanel.setLayout(new java.awt.CardLayout());
        pnlMain.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 470, 430));

        lblVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblVenta.setText("Venta");
        lblVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lblEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/empleado.png"))); // NOI18N
        lblEmpleado.setText("Empleado");
        lblEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmpleadoMouseClicked(evt);
            }
        });
        pnlMain.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menú de Medico");
        pnlMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        lblRecetaMed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRecetaMed.setForeground(new java.awt.Color(255, 255, 255));
        lblRecetaMed.setText("Recetas");
        lblRecetaMed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblRecetaMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lblConsultaMed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblConsultaMed.setForeground(new java.awt.Color(255, 255, 255));
        lblConsultaMed.setText("Consultas");
        lblConsultaMed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblConsultaMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        lblMedicamentosMed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMedicamentosMed.setForeground(new java.awt.Color(255, 255, 255));
        lblMedicamentosMed.setText("Medicamentos");
        lblMedicamentosMed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMain.add(lblMedicamentosMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void lblMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMedicoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMedicoMouseClicked

    private void lblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEmpleadoMouseClicked

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
            java.util.logging.Logger.getLogger(Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Farmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblConsultaMed;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblMedicamentosMed;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblReceta;
    private javax.swing.JLabel lblRecetaMed;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTopBar;
    // End of variables declaration//GEN-END:variables
}
