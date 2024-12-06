/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.InventarioSucursalDTO;
import com.dtos.MedicamentoDTO;
import com.dtos.SucursalDTO;
import com.persistencias.MedicamentoPersistencia;
import com.persistencias.SucursalPersistencia;
import com.servicios.InventarioServicio;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Aaron
 */
public class InventarioControl extends Control {
    
    private MedicamentoPersistencia medPersistencia;
    private SucursalPersistencia scrslPersistencia;
    private InventarioServicio invServicio;

    public InventarioControl() {
        medPersistencia = new MedicamentoPersistencia();
        scrslPersistencia = new SucursalPersistencia();
        invServicio = new InventarioServicio();
    }
    
    public DefaultComboBoxModel<String> listaSucursalesToComboBoxModel(List<SucursalDTO> listaSucursales) {
        DefaultComboBoxModel<String> nombresSucursales = new DefaultComboBoxModel<>();
        for (SucursalDTO sucursal : listaSucursales) {
            String nombreSucursal = sucursal.getNombreSucursal();
            nombresSucursales.addElement(nombreSucursal);
        }
        
        return nombresSucursales;
    }
    
    public InventarioSucursalDTO agregarMedicamento() {
        MedicamentoDTO medicamentoDto = new MedicamentoDTO();
        JTextField txfNombreMedicamento = new JTextField();
        JTextField txfPresentacion = new JTextField();
        JTextField txfActivo = new JTextField();
        JTextField txfConcentracion = new JTextField();
        JTextField txfPrecio = new JTextField();
        JTextField txfCantidad = new JTextField();
        Object[] mensaje = {
            "Nombre Medicamento:", txfNombreMedicamento,
            "Presentación:", txfPresentacion,
            "Activo:", txfActivo,
            "Concentración:", txfConcentracion,
            "Precio:", txfPrecio,
            "Cantidad:", txfCantidad
        };

        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Medicamento a agregar", JOptionPane.OK_CANCEL_OPTION);

        if(respuesta == JOptionPane.OK_OPTION) {
            try {
                super.validarComponentes(mensaje);
                int cantidad = Integer.parseInt(txfCantidad.getText().trim());
                float precio = Float.parseFloat(txfPrecio.getText().trim());
                if(cantidad <= 0 || precio <= 0) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad válida");
                }
                String nombreMedicamento = txfNombreMedicamento.getText().trim();
                if(nombreMedicamento.length() < 3) {
                    throw new IllegalArgumentException("Debe ingresar un nombre no mas corto que 3 caracteres");
                }
                String numeroSerie = invServicio.generarNumeroSerie(nombreMedicamento);
                medicamentoDto.setNumeroSerie(numeroSerie);
                medicamentoDto.setNombre(txfNombreMedicamento.getText().trim());
                medicamentoDto.setPresentacion(txfPresentacion.getText().trim());
                medicamentoDto.setActivo(txfActivo.getText().trim());
                medicamentoDto.setConcentracion(txfConcentracion.getText().trim());
                medicamentoDto.setPrecio(precio);

                medPersistencia.agregarMedicamento(medicamentoDto, Sesion.getSucursalEmpleado(), cantidad);
                InventarioSucursalDTO inventario = new InventarioSucursalDTO();
                inventario.setNumeroSerieMedicamento(numeroSerie);
                inventario.setNombreSucursal(Sesion.getSucursalEmpleado().getNombreSucursal());
                inventario.setCantidad(cantidad);
                return inventario;
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return null;
    }
    
    public InventarioSucursalDTO actualizarInventario(InventarioSucursalDTO inventario) {
        MedicamentoDTO medicamentoDto = medPersistencia.buscarMedicamento(inventario.getNumeroSerieMedicamento());
        JTextField txfNombreMedicamento = new JTextField(medicamentoDto.getNombre());
        JTextField txfPresentacion = new JTextField(medicamentoDto.getPresentacion());
        JTextField txfActivo = new JTextField(medicamentoDto.getActivo());
        JTextField txfConcentracion = new JTextField(medicamentoDto.getConcentracion());
        JTextField txfPrecio = new JTextField(Float.toString(medicamentoDto.getPrecio()));
        JTextField txfCantidad = new JTextField(Integer.toString(inventario.getCantidad()));
        Object[] mensaje = {
            "Nombre Medicamento:", txfNombreMedicamento,
            "Presentación:", txfPresentacion,
            "Activo:", txfActivo,
            "Concentración:", txfConcentracion,
            "Precio:", txfPrecio,
            "Cantidad:", txfCantidad
        };

        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Medicamento a agregar", JOptionPane.OK_CANCEL_OPTION);

        if(respuesta == JOptionPane.OK_OPTION) {
            try {
                super.validarComponentes(mensaje);
                String numeroSerie = medicamentoDto.getNumeroSerie();
                int cantidad = Integer.parseInt(txfCantidad.getText().trim());
                float precio = Float.parseFloat(txfPrecio.getText().trim());
                if(cantidad <= 0 || precio <= 0) {
                    throw new IllegalArgumentException("Debe ingresar una cantidad válida");
                }
                String nombreMedicamento = txfNombreMedicamento.getText().trim();
                if(nombreMedicamento.length() < 3) {
                    throw new IllegalArgumentException("Debe ingresar un nombre no mas corto que 3 caracteres");
                }
                medicamentoDto.setNombre(txfNombreMedicamento.getText().trim());
                medicamentoDto.setPresentacion(txfPresentacion.getText().trim());
                medicamentoDto.setActivo(txfActivo.getText().trim());
                medicamentoDto.setConcentracion(txfConcentracion.getText().trim());
                medicamentoDto.setPrecio(precio);

                medPersistencia.actualizarMedicamento(medicamentoDto, Sesion.getSucursalEmpleado(), cantidad);
                inventario.setNumeroSerieMedicamento(numeroSerie);
                inventario.setNombreSucursal(Sesion.getSucursalEmpleado().getNombreSucursal());
                inventario.setCantidad(cantidad);
                return inventario;
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return null;
    }
    
    public List<InventarioSucursalDTO> listaInventarioSucursal(SucursalDTO sucursalDto) {
        List<InventarioSucursalDTO> listaInventarioDto = scrslPersistencia.obtenerInventarioSucursal(sucursalDto.getNombreSucursal());
        return listaInventarioDto;
    }
}
