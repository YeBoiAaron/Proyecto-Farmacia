/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.InventarioSucursalDTO;
import com.entidades.InventarioSucursal;

/**
 *
 * @author Aaron
 */
public class InventarioSucursalMapper {
    
    public static InventarioSucursalDTO toDto(InventarioSucursal inventario) {
        InventarioSucursalDTO inventarioDto = new InventarioSucursalDTO();
        inventarioDto.setNumeroSerieMedicamento(inventario.getMedicamento().getNumeroSerie());
        inventarioDto.setNombreSucursal(inventario.getSucursal().getNombreSucursal());
        inventarioDto.setCantidad(inventario.getCantidad());
        
        return inventarioDto;
    }
}
