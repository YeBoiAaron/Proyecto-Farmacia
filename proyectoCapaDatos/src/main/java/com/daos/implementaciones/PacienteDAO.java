/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IPacienteDAO;
import com.entidades.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class PacienteDAO extends DAOBase<Paciente> implements IPacienteDAO {
    
    public PacienteDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Paciente obtenerPorCorreo(String correo) {
        try {
            String jpql = "SELECT paciente FROM Paciente paciente WHERE paciente.correo = :correo";
            return entityManager.createQuery(jpql, Paciente.class).setParameter("correo", correo).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
