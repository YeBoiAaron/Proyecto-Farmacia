/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IVentaDAO;
import com.entidades.Venta;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class VentaDAO extends DAOBase<Venta> implements IVentaDAO {
    
    public VentaDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Venta obtenerPorFolio(String folio) {
        try {
            String jpql = "SELECT venta FROM Venta venta WHERE venta.folio = :folio";
            return entityManager.createQuery(jpql, Venta.class).setParameter("folio", folio).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
