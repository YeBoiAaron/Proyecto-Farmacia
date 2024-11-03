/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.ISucursalDAO;
import com.entidades.Sucursal;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class SucursalDAO extends DAOBase<Sucursal> implements ISucursalDAO {
    
    public SucursalDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
