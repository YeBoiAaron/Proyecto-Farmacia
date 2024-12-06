/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.EmpleadoDTO;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.VentaDTO;
import com.persistencias.MedicamentosRecetaPersistencia;
import com.persistencias.RecetaPersistencia;
import com.persistencias.VentaPersistencia;
import com.servicios.ConversionesTablas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaControl {
    private VentaPersistencia ventaPersistencia;
    private ConversionesTablas convers;

    public VentaControl() {
        ventaPersistencia = new VentaPersistencia();
        convers = new ConversionesTablas();
    }

    public DefaultTableModel buscarReceta(String numeroReceta) {
        MedicamentosRecetaPersistencia persistencia = new MedicamentosRecetaPersistencia();
        List<MedicamentosRecetaDTO> medicamentosRecetaDTOs = persistencia.buscarPorNumeroReceta(numeroReceta);

        if (medicamentosRecetaDTOs != null && !medicamentosRecetaDTOs.isEmpty()) {
            DefaultTableModel modelo = convers.listaMedicamentosVentaToTableModel(medicamentosRecetaDTOs, numeroReceta);
            return modelo;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la receta con el número proporcionado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
}


