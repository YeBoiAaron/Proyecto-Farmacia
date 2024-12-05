/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.ISucursalDAO;
import com.entidades.Empleado;
import com.entidades.Sucursal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class SucursalDAO extends DAOBase<Sucursal> implements ISucursalDAO {
    
    public SucursalDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Sucursal obtenerPorNombreSucursal(String nombreSucursal) {
        try {
            String jpql = "SELECT sucursal FROM Sucursal sucursal WHERE sucursal.nombreSucursal = :nombreSucursal";
            return entityManager.createQuery(jpql, Sucursal.class).setParameter("nombreSucursal", nombreSucursal).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public Empleado obtenerGerenteSucursal(String nombreSucursal) {
        try {
            String jpql = "SELECT empleado FROM Empleado empleado WHERE empleado.sucursal.nombreSucursal = :nombreSucursal AND empleado.tipoEmpleado = 'Gerente'";
            return entityManager.createQuery(jpql, Empleado.class).setParameter("nombreSucursal", nombreSucursal).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        
    }
    
}
