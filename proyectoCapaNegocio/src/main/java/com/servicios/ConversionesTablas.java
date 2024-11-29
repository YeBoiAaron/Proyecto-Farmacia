/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.daos.implementaciones.MedicamentoDAO;
import com.dtos.MedicamentosRecetaDTO;
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
    
    public ArrayList<MedicamentosRecetaDTO> tablaMedicamentosRecetaToArray(TableModel tabla, String numeroReceta) {
        ArrayList<MedicamentosRecetaDTO> listaMedicamentos = new ArrayList<>();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            listaMedicamentos.add(new MedicamentosRecetaDTO((int)tabla.getValueAt(i, 0), (String)tabla.getValueAt(i, 1), (String)tabla.getValueAt(i, 2), numeroReceta));
        }
        
        return listaMedicamentos;
    }
    
    public DefaultTableModel listaMedicamentosRecetaToTableModel(List<MedicamentosRecetaDTO> listaMedicamentos) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaMedicamentosReceta, 0);
        for (MedicamentosRecetaDTO medicamento : listaMedicamentos) {
            Object[] datosFila = {
                new MedicamentoDAO(JPAUtil.getEntityManagerFactory().createEntityManager()).obtenerPorNumeroSerie(medicamento.getNumeroSerieMedicamento()).getNombre(),
                medicamento.getInstrucciones(),
                medicamento.getCantidad()
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
}
