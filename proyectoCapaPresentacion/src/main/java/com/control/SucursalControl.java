/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.EmpleadoDTO;
import com.dtos.SucursalDTO;
import com.persistencias.SucursalPersistencia;
import com.servicios.ConversionesTablas;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Aaron
 */
public class SucursalControl extends Control{
    private SucursalPersistencia scrslPersistencia;
    private ConversionesTablas convers;
    
    public SucursalControl() {
        scrslPersistencia = new SucursalPersistencia();
        convers = new ConversionesTablas();
    }
    
    public SucursalDTO seleccionarSucursal(EmpleadoDTO empleadoDto) {
        List<SucursalDTO> sucursalesDto = scrslPersistencia.listaSucursales();
        if(sucursalesDto == null && empleadoDto.getTipoEmpleado().equals("Gerente")) {
            return crearSucursal();
        } else if (sucursalesDto != null){
            JTable tblSucursales = new JTable(convers.listaSucursalesToTableModel(sucursalesDto));
            tblSucursales.setRowSelectionAllowed(true);
            int respuesta;
            if(empleadoDto.getTipoEmpleado().equals("Gerente")) {
                Object[] opciones = {
                    "Seleccionar sucursal",
                    "Crear sucursal",
                    "Cancelar"
                };

                respuesta = JOptionPane.showOptionDialog(
                        null,
                        tblSucursales,
                        "Selecciona una sucursal",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );
            } else {
                Object[] opciones = {
                    "Seleccionar sucursal",
                    "Cancelar"
                };

                respuesta = JOptionPane.showOptionDialog(
                        null,
                        tblSucursales,
                        "Selecciona una sucursal",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );
            }
            
            
            if((respuesta == JOptionPane.YES_OPTION || respuesta == JOptionPane.OK_OPTION) && tblSucursales.getSelectedRow() != -1) {
                SucursalDTO sucursalDto = scrslPersistencia.obtenerSucursalPorNombre((String) tblSucursales.getValueAt(tblSucursales.getSelectedRow(), 0));
                return sucursalDto;
                
            } else if(respuesta == JOptionPane.NO_OPTION) {
                return crearSucursal();
            }
        }
        
        return null;
    }
    
    public SucursalDTO crearSucursal() {
        SucursalDTO sucursalDto = new SucursalDTO();
        JTextField txfNombreSucursal = new JTextField();
        JTextField txfCalle = new JTextField();
        JTextField txfNumero = new JTextField();
        JTextField txfColonia = new JTextField();
        JTextField txfCodigoPostal = new JTextField();
        Object[] mensaje = {
            "Nombre sucursal:", txfNombreSucursal,
            "Calle:", txfCalle,
            "Numero:", txfNumero,
            "Colonia:", txfColonia,
            "Codigo Postal:", txfCodigoPostal
        };

        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Crear sucursal", JOptionPane.OK_CANCEL_OPTION);

        if(respuesta == JOptionPane.OK_OPTION) {
            try {
                super.validarComponentes(mensaje);
                int numero = Integer.parseInt(txfNumero.getText().trim());
                int codigoPostal = Integer.parseInt(txfCodigoPostal.getText().trim());
                if(numero <= 0 || codigoPostal <= 0) {
                    throw new IllegalArgumentException("Debe ingresar una dirección válida");
                }
                sucursalDto.setNombreSucursal(txfNombreSucursal.getText().trim());
                sucursalDto.setCalle(txfCalle.getText().trim());
                sucursalDto.setNumero(numero);
                sucursalDto.setColonia(txfColonia.getText().trim());
                sucursalDto.setCodigoPostal(codigoPostal);

                scrslPersistencia.crearSucursal(sucursalDto);
                return sucursalDto;
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch(PersistenceException e) {
                JOptionPane.showMessageDialog(null, "Ya hay una sucursal con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return null;
    }
}
