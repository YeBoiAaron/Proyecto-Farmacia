/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IMedicoDAO;
import com.entidades.Medico;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class MedicoDAO extends DAOBase<Medico> implements IMedicoDAO {
    
    public MedicoDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Medico obtenerPorNombreUsuario(String nombreUsuario) {
        try {
            String jpql = "SELECT medico FROM Medico medico WHERE medico.nombreUsuario = :nombreUsuario";
            return entityManager.createQuery(jpql, Medico.class).setParameter("nombreUsuario", nombreUsuario).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
