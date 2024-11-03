/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IMedicoDAO;
import com.entidades.Medico;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicoDAO extends DAOBase<Medico> implements IMedicoDAO {
    
    public MedicoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
