/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.interfaces.IInventarioSucursalDAO;
import com.daos.DAOBase;
import com.entidades.InventarioSucursal;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class InventarioSucursalDAO extends DAOBase<InventarioSucursal> implements IInventarioSucursalDAO {
    
    public InventarioSucursalDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
