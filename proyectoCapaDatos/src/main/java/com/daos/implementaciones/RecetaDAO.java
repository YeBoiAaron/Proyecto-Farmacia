/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IRecetaDAO;
import com.entidades.Receta;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class RecetaDAO extends DAOBase<Receta> implements IRecetaDAO {
    
    public RecetaDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Receta obtenerPorNumeroReceta(String numeroReceta) {
        try {
            String jpql = "SELECT receta FROM Receta receta WHERE receta.numeroReceta = :numeroReceta";
            return entityManager.createQuery(jpql, Receta.class).setParameter("nombreUsuario", numeroReceta).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
