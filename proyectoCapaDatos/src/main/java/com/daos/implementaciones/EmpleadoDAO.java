/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IEmpleadoDAO;
import com.entidades.Empleado;
import com.entidades.Sucursal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class EmpleadoDAO extends DAOBase<Empleado> implements IEmpleadoDAO {
    
    public EmpleadoDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Empleado obtenerPorNombreUsuario(String nombreUsuario) {
        try {
            String jpql = "SELECT empleado FROM Empleado empleado WHERE empleado.nombreUsuario = :nombreUsuario";
            return entityManager.createQuery(jpql, Empleado.class).setParameter("nombreUsuario", nombreUsuario).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public Sucursal obtenerSucursalPorEmpleado(String nombreUsuario) {
        try {
            String jpql = "SELECT empleado.sucursal FROM Empleado empleado WHERE empleado.nombreUsuario = :nombreUsuario";
            return entityManager.createQuery(jpql, Sucursal.class).setParameter("nombreUsuario", nombreUsuario).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
