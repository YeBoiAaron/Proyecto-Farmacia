/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pantallas.medico;

import com.control.Sesion;
import com.control.RecetaControl;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.PacienteDTO;
import com.dtos.RecetaDTO;
import com.persistencias.RecetaPersistencia;
import com.persistencias.UsuarioPersistencia;
import com.servicios.ConversionesTablas;
import com.servicios.RecetaServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aaron
 */
public class frmCrearReceta extends javax.swing.JFrame {

    /**
     * Creates new form frmCrearReceta
     */
    public frmCrearReceta() {
        initComponents();
        setLocationRelativeTo(null);
        recetaPersistencia = new RecetaPersistencia();
        usrPersistencia = new UsuarioPersistencia();
        recetaServicio = new RecetaServicio();
        control = new RecetaControl();
        convers = new ConversionesTablas();
        listaMedicamentos = new ArrayList<>();
        paciente = new PacienteDTO();
        receta = new RecetaDTO();
    }
    
    public void agregarMedicamentoReceta(MedicamentosRecetaDTO medicamento) {
        this.listaMedicamentos.add(medicamento);
        actualizarTablaMedicamentos(listaMedicamentos);
    }
    
    public void actualizarTablaMedicamentos(List<MedicamentosRecetaDTO> listaMedicamentos) {
        this.tblMedicamentos.setModel(convers.listaMedicamentosRecetaToTableModel(listaMedicamentos));
        this.tblMedicamentos.getColumnModel().removeColumn(tblMedicamentos.getColumnModel().getColumn(3));
    }
    
    public void actualizarPaciente() {
        if(paciente != null) {
            txfNombrePaciente.setText(paciente.getNombreCompleto());
            txfSexo.setText(paciente.getSexo());
            txfAltura.setText(Float.toString(paciente.getAltura()));
            txfPeso.setText(Float.toString(paciente.getPeso()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfNombrePaciente = new javax.swing.JTextField();
        txfDiagnostico = new javax.swing.JTextField();
        txfSexo = new javax.swing.JTextField();
        txfSexo.setEditable(false);
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        tblMedicamentos.setRowSelectionAllowed(true);
        tblMedicamentos.setColumnSelectionAllowed(false);
        tblMedicamentos.setDefaultEditor(Object.class, null);
        btnAgregarMedicamentos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txfAltura = new javax.swing.JTextField();
        txfAltura.setEditable(false);
        jLabel5 = new javax.swing.JLabel();
        txfPeso = new javax.swing.JTextField();
        txfPeso.setEditable(false);
        btnBuscarPaciente = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnActualizar.setVisible(false);
        btnActualizar.setEnabled(false);
        btnEliminar = new javax.swing.JButton();
        btnEliminar.setVisible(false);
        btnEliminar.setEnabled(false);
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        moCrearReceta = new javax.swing.JMenuItem();
        moConsultarReceta = new javax.swing.JMenuItem();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());

        jLabel1.setText("Nombre del Paciente");

        jLabel3.setText("Sexo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Diagnóstico");

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamentos", "Indicaciones", "Cantidad", "Numero Serie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicamentos);
        if (tblMedicamentos.getColumnModel().getColumnCount() > 0) {
            tblMedicamentos.getColumnModel().getColumn(3).setMinWidth(0);
            tblMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblMedicamentos.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        btnAgregarMedicamentos.setText("Agregar Medicamentos");
        btnAgregarMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedicamentosActionPerformed(evt);
            }
        });

        jLabel4.setText("Altura");

        jLabel5.setText("Peso");

        btnBuscarPaciente.setText("Buscar Paciente");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("cm");

        jLabel7.setText("kg");

        jMenu1.setText("Recetas");

        moCrearReceta.setText("Crear Receta");
        moCrearReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moCrearRecetaActionPerformed(evt);
            }
        });
        jMenu1.add(moCrearReceta);

        moConsultarReceta.setText("Consultar Receta");
        moConsultarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moConsultarRecetaActionPerformed(evt);
            }
        });
        jMenu1.add(moConsultarReceta);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarMedicamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(20, 20, 20)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txfDiagnostico, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addComponent(txfNombrePaciente)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel2)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPaciente)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txfDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregarMedicamentos)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(listaMedicamentos.isEmpty()) {
                throw new IllegalArgumentException("No ha seleccionado ningun medicamento");
            }
            
            String numeroReceta = recetaServicio.generarNumeroReceta();
            receta.setNumeroReceta(numeroReceta);
            receta.setDiagnostico(txfDiagnostico.getText());
            receta.setEstado("sin surtir");
        
            recetaPersistencia.crearReceta(
                    receta, 
                    listaMedicamentos, 
                    usrPersistencia.obtenerMedico(Sesion.getUsuarioLogueado()),
                    paciente
            );
            JOptionPane.showMessageDialog(null, "Operación realizada con éxito", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            frmInicioMedico inicio = new frmInicioMedico();
            inicio.setVisible(true);
            this.dispose();
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado", "Operacion fallida", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmInicioMedico inicio = new frmInicioMedico();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void moCrearRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moCrearRecetaActionPerformed
        frmConsultarReceta consultar_receta = new frmConsultarReceta();
        consultar_receta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moCrearRecetaActionPerformed

    private void moConsultarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moConsultarRecetaActionPerformed
        frmCrearReceta crear_receta = new frmCrearReceta();
        crear_receta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moConsultarRecetaActionPerformed

    private void btnAgregarMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicamentosActionPerformed
        dlgSeleccionarMedicamento seleccionarMed = new dlgSeleccionarMedicamento(this);
        seleccionarMed.setVisible(true);
    }//GEN-LAST:event_btnAgregarMedicamentosActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        String nombrePaciente = txfNombrePaciente.getText().trim();
        paciente = control.buscarPaciente(this, nombrePaciente);
        actualizarPaciente();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void tblMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentosMouseClicked
        btnActualizar.setVisible(true);
        btnActualizar.setEnabled(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblMedicamentosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        MedicamentosRecetaDTO medicamento = listaMedicamentos.get(tblMedicamentos.getSelectedRow());
        MedicamentosRecetaDTO medicamentoActualizado = control.actualizarMedicamentoReceta(this, medicamento);
        listaMedicamentos.set(tblMedicamentos.getSelectedRow(), medicamentoActualizado);
        actualizarTablaMedicamentos(listaMedicamentos);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblMedicamentos.getModel();
            listaMedicamentos.remove(tblMedicamentos.getSelectedRow());
            modelo.removeRow(tblMedicamentos.getSelectedRow());
            if(listaMedicamentos.isEmpty()) {
                btnActualizar.setVisible(false);
                btnActualizar.setEnabled(false);
                btnEliminar.setVisible(false);
                btnEliminar.setEnabled(false);
            }
        } catch(IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un medicamento para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmCrearReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCrearReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCrearReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCrearReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCrearReceta().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarMedicamentos;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem moConsultarReceta;
    private javax.swing.JMenuItem moCrearReceta;
    private javax.swing.JTable tblMedicamentos;
    private javax.swing.JTextField txfAltura;
    private javax.swing.JTextField txfDiagnostico;
    private javax.swing.JTextField txfNombrePaciente;
    private javax.swing.JTextField txfPeso;
    private javax.swing.JTextField txfSexo;
    // End of variables declaration//GEN-END:variables
    private RecetaPersistencia recetaPersistencia;
    private UsuarioPersistencia usrPersistencia;
    private RecetaServicio recetaServicio;
    private RecetaControl control;
    private ConversionesTablas convers;
    private List<MedicamentosRecetaDTO> listaMedicamentos;
    private PacienteDTO paciente;
    private RecetaDTO receta;
}
