/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.interfaces.IMedicamentosRecetaDAO;
import com.daos.DAOBase;
import entidades.MedicamentosReceta;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicamentosRecetaDAO extends DAOBase<MedicamentosReceta> implements IMedicamentosRecetaDAO {
    
    public MedicamentosRecetaDAO(EntityManager em) {
        super(em);
    }
    
}
