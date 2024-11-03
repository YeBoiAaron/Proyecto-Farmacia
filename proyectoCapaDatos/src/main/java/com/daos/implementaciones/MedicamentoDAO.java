/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IMedicamentoDAO;
import com.entidades.Medicamento;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicamentoDAO extends DAOBase<Medicamento> implements IMedicamentoDAO {
    
    public MedicamentoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
