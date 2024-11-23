/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.SucursalDTO;
import com.entidades.Sucursal;

/**
 *
 * @author Aaron
 */
public class SucursalMapper {
    
    public static SucursalDTO toDTO(Sucursal sucursal) {
        SucursalDTO sucursalDto = new SucursalDTO(sucursal.getNombreSucursal(), sucursal.getCalle(), sucursal.getNumero(), sucursal.getColonia(), sucursal.getCodigoPostal());
        return sucursalDto;
    }
    
    public static Sucursal toEntity(SucursalDTO sucursalDto) {
        Sucursal sucursal = new Sucursal(sucursalDto.getNombreSucursal(), sucursalDto.getCalle(), sucursalDto.getNumero(), sucursalDto.getColonia(), sucursalDto.getCodigoPostal());
        return sucursal;
    }
}
