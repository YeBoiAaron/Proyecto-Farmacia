/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.daos.implementaciones.MedicamentoDAO;
import com.dtos.MedicamentoDTO;
import com.dtos.MedicamentosRecetaDTO;
import com.entidades.Medicamento;
import com.persistencias.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Aaron
 */
public class ConversionesTablas {
    private String nombresColumnasTablaMedicamentosReceta[] = {"Medicamentos", "Indicaciones", "Cantidad"};
    private String nombresColumnasTablaMedicamentos[] = {"Nombre", "Activo", "Presentacion", "Concentración", "Numero Serie"};
    
    public ArrayList<MedicamentosRecetaDTO> tablaMedicamentosRecetaToArray(TableModel tabla, String numeroReceta) {
        ArrayList<MedicamentosRecetaDTO> listaMedicamentos = new ArrayList<>();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            listaMedicamentos.add(new MedicamentosRecetaDTO((int)tabla.getValueAt(i, 2), (String)tabla.getValueAt(i, 1), (String)tabla.getValueAt(i, 0), numeroReceta));
        }
        
        return listaMedicamentos;
    }
    
    public DefaultTableModel listaMedicamentosRecetaToTableModel(List<MedicamentosRecetaDTO> listaMedicamentosReceta) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaMedicamentosReceta, 0);
        for (MedicamentosRecetaDTO medicamento : listaMedicamentosReceta) {
            Object[] datosFila = {
                new MedicamentoDAO(JPAUtil.getEntityManagerFactory().createEntityManager()).obtenerPorNumeroSerie(medicamento.getNumeroSerieMedicamento()).getNombre(),
                medicamento.getInstrucciones(),
                medicamento.getCantidad()
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
    
    public DefaultTableModel listaMedicamentosToTableModel(List<MedicamentoDTO> listaMedicamentos) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaMedicamentos, 0);
        for (MedicamentoDTO medicamento : listaMedicamentos) {
            Object[] datosFila = {
                medicamento.getNombre(),
                medicamento.getActivo(),
                medicamento.getPresentacion(),
                medicamento.getConcentracion(),
                medicamento.getNumeroSerie()
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
}
