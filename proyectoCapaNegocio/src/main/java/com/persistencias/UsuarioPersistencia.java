/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.EmpleadoDAO;
import com.daos.implementaciones.MedicoDAO;
import com.daos.implementaciones.UsuarioDAO;
import com.daos.interfaces.IEmpleadoDAO;
import com.daos.interfaces.IMedicoDAO;
import com.daos.interfaces.IUsuarioDAO;
import com.dtos.EmpleadoDTO;
import com.dtos.MedicoDTO;
import com.dtos.UsuarioDTO;
import com.entidades.Empleado;
import com.entidades.Medico;
import com.entidades.Usuario;
import com.mappers.EmpleadoMapper;
import com.mappers.MedicoMapper;
import com.mappers.UsuarioMapper;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class UsuarioPersistencia {
    private EntityManager em;
    private IUsuarioDAO udao;
    private IMedicoDAO mdao;
    private IEmpleadoDAO edao;

    public UsuarioPersistencia() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        udao = new UsuarioDAO(em);
        mdao = new MedicoDAO(em);
        edao = new EmpleadoDAO(em);
    }
    
    public UsuarioDTO validarCredenciales(String nombreUsuario, char[] contrasena) {
        String stringContrasena = String.valueOf(contrasena);
        Usuario usuario = udao.obtenerPorNombreUsuarioYContrasena(nombreUsuario, stringContrasena);
        if(usuario != null) {
            if(usuario instanceof Medico) {
                return UsuarioMapper.toDto(usuario, "medico");
            } else if(usuario instanceof Empleado) {
                return UsuarioMapper.toDto(usuario, "empleado");
            }
        }
        
        return null;
    }
    
    public MedicoDTO obtenerMedico(UsuarioDTO usuario) {
        if(usuario.getTipoUsuario().equals("medico")) {
            Medico medico = mdao.obtenerPorNombreUsuario(usuario.getNombreUsuario());
            return MedicoMapper.toDTO(medico);
        }
        
        return null;
    }
    
    public EmpleadoDTO obtenerEmpleado(UsuarioDTO usuario) {
        if(usuario.getTipoUsuario().equals("empleado")) {
            Empleado empleado = edao.obtenerPorNombreUsuario(usuario.getNombreUsuario());
            return EmpleadoMapper.toDTO(empleado);
        }
        
        return null;
    }
}
