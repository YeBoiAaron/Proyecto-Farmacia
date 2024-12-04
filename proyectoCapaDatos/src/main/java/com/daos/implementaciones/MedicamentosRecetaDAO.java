/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IMedicamentosRecetaDAO;
import com.entidades.MedicamentosReceta;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicamentosRecetaDAO extends DAOBase<MedicamentosReceta> implements IMedicamentosRecetaDAO {
    
    public MedicamentosRecetaDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<MedicamentosReceta> obtenerPorNumeroDeReceta(String numeroReceta) {
        String jpql = "SELECT medicamentosReceta FROM MedicamentosReceta medicamentosReceta WHERE medicamentosReceta.receta.numeroReceta = :numeroReceta";
        return entityManager.createQuery(jpql, MedicamentosReceta.class).setParameter("numeroReceta", numeroReceta).getResultList();
    }
    
}
