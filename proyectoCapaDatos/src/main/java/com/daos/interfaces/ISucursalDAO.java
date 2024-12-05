/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.Empleado;
import com.entidades.Sucursal;

/**
 *
 * @author Aaron
 */
public interface ISucursalDAO extends IDAO<Sucursal> {
    public Sucursal obtenerPorNombreSucursal(String nombreSucursal);
    
    public Empleado obtenerGerenteSucursal(String nombreSucursal);
}
