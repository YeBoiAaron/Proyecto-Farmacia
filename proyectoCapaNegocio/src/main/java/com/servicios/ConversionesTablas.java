/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.daos.implementaciones.MedicamentoDAO;
import com.daos.implementaciones.SucursalDAO;
import com.dtos.EmpleadoDTO;
import com.dtos.MedicamentoDTO;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.PacienteDTO;
import com.dtos.RecetaDTO;
import com.dtos.SucursalDTO;
import com.persistencias.MedicamentoPersistencia;
import com.persistencias.SucursalPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Aaron
 */
public class ConversionesTablas {
    private String nombresColumnasTablaMedicamentosReceta[] = {"Medicamentos", "Indicaciones", "Cantidad", "Numero Serie"};
    private String nombresColumnasTablaMedicamentos[] = {"Nombre", "Activo", "Presentacion", "Concentración", "Numero Serie"};
    private String nombresColumnasTablaPacientes[] = {"Nombre", "Fecha de Nacimiento", "Correo Electronico"};
    private String nombresColumnasTablaRecetas[] = {"Numero de Receta", "Instrucciones"};
    private String nombresColumnasTablaSucursales[] = {"Sucursal", "Dirección", "Gerente"};
    
    private RecetaServicio recetaServicio = new RecetaServicio();
    private MedicamentoPersistencia medPersistencia = new MedicamentoPersistencia();
    private SucursalPersistencia scrslPersistencia = new SucursalPersistencia();
    
    public ArrayList<MedicamentosRecetaDTO> tablaMedicamentosRecetaToArray(TableModel tabla, String numeroReceta) {
        ArrayList<MedicamentosRecetaDTO> listaMedicamentos = new ArrayList<>();
        MedicamentosRecetaDTO medicamento = new MedicamentosRecetaDTO();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            medicamento.setNumeroReceta(numeroReceta);
            medicamento.setNumeroSerieMedicamento((String) tabla.getValueAt(i, 3));
            medicamento.setInstrucciones((String)tabla.getValueAt(i, 1));
            medicamento.setCantidad((int) tabla.getValueAt(i, 2));
            listaMedicamentos.add(medicamento);
        }
        
        return listaMedicamentos;
    }
    
    public DefaultTableModel listaMedicamentosRecetaToTableModel(List<MedicamentosRecetaDTO> listaMedicamentosReceta) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaMedicamentosReceta, 0);
        for (MedicamentosRecetaDTO medicamento : listaMedicamentosReceta) {
            String numeroSerie = medicamento.getNumeroSerieMedicamento();
            Object[] datosFila = {
                medPersistencia.buscarMedicamento(numeroSerie).getNombre(),
                medicamento.getInstrucciones(),
                medicamento.getCantidad(),
                numeroSerie
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
    
    public DefaultTableModel listaPacientesToTableModel(List<PacienteDTO> listaPacientes) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaPacientes, 0);
        for (PacienteDTO paciente : listaPacientes) {
            Object[] datosFila = {
                paciente.getNombreCompleto(),
                paciente.getFechaNacimiento().toString(),
                paciente.getCorreo()
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
    
    public DefaultTableModel listaRecetasToTableModel(List<RecetaDTO> listaRecetas) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaRecetas, 0);
        for (RecetaDTO receta : listaRecetas) {
            String numeroReceta = receta.getNumeroReceta();
            List<String> recetas = recetaServicio.obtenerMedicamentosInstruccionesDeReceta(numeroReceta);
            Object[] datosFila = {
                numeroReceta, String.join("\n", recetas)
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
    
    public DefaultTableModel listaSucursalesToTableModel(List<SucursalDTO> listaSucursales) {
        DefaultTableModel modelo = new DefaultTableModel(nombresColumnasTablaSucursales, 0);
        for (SucursalDTO sucursal : listaSucursales) {
            String nombreSucursal = sucursal.getNombreSucursal();
            String direccion = String.join(
                    ", ",
                    sucursal.getCalle() + " #" + Integer.toString(sucursal.getNumero()),
                    sucursal.getColonia(), "CP: " + Integer.toString(sucursal.getCodigoPostal())
            );
            EmpleadoDTO empleado = scrslPersistencia.obtenerGerenteSucursal(nombreSucursal);
            String nombreGerente = (empleado == null ? "" : empleado.getNombreCompleto());
            Object[] datosFila = {
                nombreSucursal,
                direccion,
                nombreGerente
            };
            modelo.addRow(datosFila);
        }
        
        return modelo;
    }
}
