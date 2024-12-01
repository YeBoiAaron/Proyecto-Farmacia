/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IMedicamentoDAO;
import com.entidades.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicamentoDAO extends DAOBase<Medicamento> implements IMedicamentoDAO {
    
    public MedicamentoDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Medicamento obtenerPorNumeroSerie(String numeroSerie) {
        String jpql = "SELECT medicamento FROM Medicamento medicamento WHERE medicamento.numeroSerie = :numeroSerie";
        return entityManager.createQuery(jpql, Medicamento.class).setParameter("numeroSerie", numeroSerie).getSingleResult();
    }

    @Override
    public List<Medicamento> obtenerPorNombre(String nombreMedicamento) {
        String jpql = "SELECT medicamento FROM Medicamento medicamento WHERE LOWER(medicamento.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))";
        return entityManager.createQuery(jpql, Medicamento.class).setParameter("nombre", nombreMedicamento).getResultList();
    }
    
}
