/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.VentaDTO;
import com.entidades.Venta;

/**
 *
 * @author Aaron
 */
public class VentaMapper {
    
    public static VentaDTO toDTO(Venta venta) {
        VentaDTO ventaDto = new VentaDTO(venta.getFolio(), venta.getSubtotal(), venta.getTotal(), venta.getFecha());
        return ventaDto;
    }
    
    public static Venta toEntity(VentaDTO ventaDto) {
        Venta venta = new Venta(ventaDto.getFolio(), ventaDto.getSubtotal(), ventaDto.getTotal(), ventaDto.getFecha());
        return venta;
    }
}
