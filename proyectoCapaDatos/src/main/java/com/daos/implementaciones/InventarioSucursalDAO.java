/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IInventarioSucursalDAO;
import com.entidades.InventarioSucursal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class InventarioSucursalDAO extends DAOBase<InventarioSucursal> implements IInventarioSucursalDAO {
    
    public InventarioSucursalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public InventarioSucursal obtenerPorMedicamentoYSucursal(String numeroSerie, String nombreSucursal) {
        try {
            String jpql = "SELECT inventario " + 
                    "FROM InventarioSucursal inventario " +
                    "WHERE inventario.medicamento.numeroSerie = :numeroSerie " + 
                    "AND inventario.sucursal.nombreSucursal = :nombreSucursal";
            return entityManager.createQuery(jpql, InventarioSucursal.class).
                    setParameter("numeroSerie", numeroSerie).
                    setParameter("nombreSucursal", nombreSucursal).
                    getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public List<InventarioSucursal> obtenerInventarioPorSucursal(String nombreSucursal) {
        try {
            String jpql = "SELECT inventario "+
                    "FROM InventarioSucursal inventario " +
                    "WHERE inventario.sucursal.nombreSucursal = :nombreSucursal";
            return entityManager.createQuery(jpql, InventarioSucursal.class).
                    setParameter("nombreSucursal", nombreSucursal).
                    getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
