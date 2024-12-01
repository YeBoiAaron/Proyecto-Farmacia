/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.EmpleadoDAO;
import com.daos.interfaces.IEmpleadoDAO;
import com.dtos.EmpleadoDTO;
import com.entidades.Empleado;
import com.mappers.EmpleadoMapper;
import javax.persistence.EntityManager;

import at.favre.lib.crypto.bcrypt.BCrypt;
/**
 *
 * @author martinez
 */
public class EmpleadoPersistencia {
    private EntityManager em;
    private IEmpleadoDAO edao;
    
    public EmpleadoPersistencia(){
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
         edao = new EmpleadoDAO(em);
    }
}
