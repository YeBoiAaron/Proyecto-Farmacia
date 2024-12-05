/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.SucursalDTO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aaron
 */
public class InventarioControl extends Control {
    
    public DefaultComboBoxModel<String> listaSucursalesToComboBoxModel(List<SucursalDTO> listaSucursales) {
        DefaultComboBoxModel<String> nombresSucursales = new DefaultComboBoxModel<>();
        for (SucursalDTO sucursal : listaSucursales) {
            String nombreSucursal = sucursal.getNombreSucursal();
            nombresSucursales.addElement(nombreSucursal);
        }
        
        return nombresSucursales;
    }
}
