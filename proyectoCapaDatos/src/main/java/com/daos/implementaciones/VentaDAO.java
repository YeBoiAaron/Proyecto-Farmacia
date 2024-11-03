/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IVentaDAO;
import com.entidades.Venta;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class VentaDAO extends DAOBase<Venta> implements IVentaDAO {
    
    public VentaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
