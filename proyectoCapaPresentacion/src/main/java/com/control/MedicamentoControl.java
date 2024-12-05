/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.MedicamentoDTO;
import com.dtos.MedicamentosRecetaDTO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aaron
 */
public class MedicamentoControl extends Control{
    
    public MedicamentosRecetaDTO seleccionarMedicamentoReceta(JDialog parent, JTable tblMedicamentos) {
        int filaSeleccionada = tblMedicamentos.getSelectedRow();
        if(filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(parent, "Debe seleccionar un medicamento de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        MedicamentosRecetaDTO medicamentorecetaDto = new MedicamentosRecetaDTO();
        medicamentorecetaDto.setNumeroSerieMedicamento(obtenerMedicamentoSeleccionado(tblMedicamentos,filaSeleccionada).getNumeroSerie());
        
        JTextField tfCantidad = new JTextField();
        JTextField tfInstrucciones = new JTextField();
        Object[] mensaje = {
            "Cantidad:", tfCantidad,
            "Instrucciones:", tfInstrucciones
        };

        int respuesta = JOptionPane.showConfirmDialog(
            parent,
            mensaje,
            "Ingrese cantidad e instrucciones",
            JOptionPane.OK_CANCEL_OPTION
        );
        
        if(respuesta == JOptionPane.OK_OPTION) {
            try {
                int cantidad = Integer.parseInt(tfCantidad.getText().trim());
                String instrucciones = tfInstrucciones.getText().trim();

                if(cantidad <= 0 || instrucciones.isEmpty()) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad e instrucciones válidas");
                }
                
                medicamentorecetaDto.setCantidad(cantidad);
                medicamentorecetaDto.setInstrucciones(instrucciones);
                
                return medicamentorecetaDto;
                
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "La cantidad debe ser un número entero válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        return null;
    }
    
    private MedicamentoDTO obtenerMedicamentoSeleccionado(JTable tblMedicamentos, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblMedicamentos.getModel();
        MedicamentoDTO medicamento = new MedicamentoDTO();
        medicamento.setNombre((String) modelo.getValueAt(fila, 0));
        medicamento.setActivo((String) modelo.getValueAt(fila, 1));
        medicamento.setPresentacion((String) modelo.getValueAt(fila, 2));
        medicamento.setConcentracion((String) modelo.getValueAt(fila, 3));
        medicamento.setNumeroSerie((String) modelo.getValueAt(fila, 4));
        return medicamento;
    }
}
