/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import org.mindrot.jbcrypt.BCrypt;
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
    
    public void agregarUsuarioEmpleado(EmpleadoDTO edto){
        Empleado empleado = EmpleadoMapper.toEntity(edto);
        String password = edto.getContrasena();
        String hashedPass = encriptar(password);
        empleado.setContrasena(hashedPass);
        empleado.setNombreUsuario(edto.getNombreUsuario());
        empleado.setCorreo(edto.getCorreo());
        edao.agregar(empleado);
    }
    
    public void agregarMedico(MedicoDTO medicoDto) {
        Medico medico = MedicoMapper.toEntity(medicoDto);
        String password = medicoDto.getContrasena();
        String hashedPass = encriptar(password);
        medico.setContrasena(hashedPass);
        medico.setNombreUsuario(medicoDto.getNombreUsuario());
        medico.setCorreo(medicoDto.getCorreo());
        mdao.agregar(medico);
    }
    
    public static String encriptar(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }
    public UsuarioDTO verificarCredenciales(String nombreUsuario, String stringContra) {
        Usuario usuario = udao.obtenerPorNombreUsuario(nombreUsuario);
        
        if(usuario != null && BCrypt.checkpw(stringContra, usuario.getContrasena())) {
            if(usuario instanceof Medico) {
                return UsuarioMapper.toDto(usuario, "medico");
            } else if(usuario instanceof Empleado) {
                return UsuarioMapper.toDto(usuario, "empleado");
            }
        }
        
        return null;
    }
    
    public boolean nombreUsuarioExiste(String nombreUsuario) {
        boolean enEmpleado = (edao.obtenerPorNombreUsuario(nombreUsuario) != null);
        boolean enMedico = (mdao.obtenerPorNombreUsuario(nombreUsuario) != null);
        return (enEmpleado || enMedico);
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
