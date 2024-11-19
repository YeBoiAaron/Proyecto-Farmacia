/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.ISucursalDAO;
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
    public Sucursal obtener(String identificador) {
        try {
            String jpql = "SELECT sucursal FROM Sucursal sucursal WHERE sucursal.identificador = :identificador";
            return entityManager.createQuery(jpql, Sucursal.class).setParameter("identificador", identificador).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
