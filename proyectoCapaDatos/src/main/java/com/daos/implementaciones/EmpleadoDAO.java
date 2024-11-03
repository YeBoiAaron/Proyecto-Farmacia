/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IEmpleadoDAO;
import com.entidades.Empleado;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class EmpleadoDAO extends DAOBase<Empleado> implements IEmpleadoDAO {
    
    public EmpleadoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}