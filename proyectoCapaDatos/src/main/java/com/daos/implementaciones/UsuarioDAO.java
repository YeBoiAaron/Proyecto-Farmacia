/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos.implementaciones;

import com.daos.DAOBase;
import com.daos.interfaces.IUsuarioDAO;
import com.entidades.Empleado;
import com.entidades.Medico;
import com.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Aaron
 */
public class UsuarioDAO extends DAOBase<Usuario> implements IUsuarioDAO{

    public UsuarioDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    @Override
    public Usuario obtenerPorNombreUsuarioYContrasena(String nombreUsuario, String contrasena) {
        try {
            String jpqlMedico = "SELECT usuario FROM Medico usuario WHERE usuario.nombreUsuario = :nombreUsuario AND usuario.contrasena = :contrasena";
            return entityManager.createQuery(jpqlMedico, Medico.class)
                    .setParameter("nombreUsuario", nombreUsuario)
                    .setParameter("contrasena", contrasena)
                    .getSingleResult();
        } catch(NoResultException e1) {
            try {
                String jpqlEmpleado = "SELECT usuario FROM Empleado usuario WHERE usuario.nombreUsuario = :nombreUsuario AND usuario.contrasena = :contrasena";
                return entityManager.createQuery(jpqlEmpleado, Empleado.class)
                        .setParameter("nombreUsuario", nombreUsuario)
                        .setParameter("contrasena", contrasena)
                        .getSingleResult();
            } catch(NoResultException e2) {
                return null;
            }
        }
    }
    
}
