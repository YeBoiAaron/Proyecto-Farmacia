/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.servicios.JPAUtil;
import org.mindrot.jbcrypt.BCrypt;
import com.daos.implementaciones.EmpleadoDAO;
import com.daos.implementaciones.MedicoDAO;
import com.daos.implementaciones.SucursalDAO;
import com.daos.implementaciones.UsuarioDAO;
import com.daos.interfaces.IEmpleadoDAO;
import com.daos.interfaces.IMedicoDAO;
import com.daos.interfaces.ISucursalDAO;
import com.daos.interfaces.IUsuarioDAO;
import com.dtos.EmpleadoDTO;
import com.dtos.MedicoDTO;
import com.dtos.SucursalDTO;
import com.dtos.UsuarioDTO;
import com.entidades.Empleado;
import com.entidades.Medico;
import com.entidades.Sucursal;
import com.entidades.Usuario;
import com.mappers.EmpleadoMapper;
import com.mappers.MedicoMapper;
import com.mappers.SucursalMapper;
import com.mappers.UsuarioMapper;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class UsuarioPersistencia {
    private EntityManager entityManager;
    private IUsuarioDAO usuarioDao;
    private IMedicoDAO medicoDao;
    private IEmpleadoDAO empleadoDao;
    private ISucursalDAO sucursalDao;

    public UsuarioPersistencia() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuarioDao = new UsuarioDAO(entityManager);
        medicoDao = new MedicoDAO(entityManager);
        empleadoDao = new EmpleadoDAO(entityManager);
        sucursalDao = new SucursalDAO(entityManager);
    }
    
    public void agregarEmpleado(EmpleadoDTO empleadoDto, SucursalDTO sucursalDto){
        Empleado empleado = EmpleadoMapper.toEntity(empleadoDto);
        String password = empleadoDto.getContrasena();
        String hashedPass = encriptar(password);
        empleado.setContrasena(hashedPass);
        empleado.setNombreUsuario(empleadoDto.getNombreUsuario());
        empleado.setCorreo(empleadoDto.getCorreo());
        
        Sucursal sucursal = sucursalDao.obtenerPorNombreSucursal(sucursalDto.getNombreSucursal());
        empleado.setSucursal(sucursal);
        empleadoDao.agregar(empleado);
    }
    
    public void agregarMedico(MedicoDTO medicoDto) {
        Medico medico = MedicoMapper.toEntity(medicoDto);
        String password = medicoDto.getContrasena();
        String hashedPass = encriptar(password);
        medico.setContrasena(hashedPass);
        medico.setNombreUsuario(medicoDto.getNombreUsuario());
        medico.setCorreo(medicoDto.getCorreo());
        medicoDao.agregar(medico);
    }
    
    public static String encriptar(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }
    public UsuarioDTO verificarCredenciales(String nombreUsuario, String stringContra) {
        Usuario usuario = usuarioDao.obtenerPorNombreUsuario(nombreUsuario);
        
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
        boolean enEmpleado = (empleadoDao.obtenerPorNombreUsuario(nombreUsuario) != null);
        boolean enMedico = (medicoDao.obtenerPorNombreUsuario(nombreUsuario) != null);
        return (enEmpleado || enMedico);
    }
    
    public MedicoDTO obtenerMedico(UsuarioDTO usuario) {
        if(usuario.getTipoUsuario().equals("medico")) {
            Medico medico = medicoDao.obtenerPorNombreUsuario(usuario.getNombreUsuario());
            return MedicoMapper.toDTO(medico);
        }
        
        return null;
    }
    
    public EmpleadoDTO obtenerEmpleado(UsuarioDTO usuario) {
        if(usuario.getTipoUsuario().equals("empleado")) {
            Empleado empleado = empleadoDao.obtenerPorNombreUsuario(usuario.getNombreUsuario());
            return EmpleadoMapper.toDTO(empleado);
        }
        
        return null;
    }
    
    public SucursalDTO obtenerSucursalDeEmpleado(UsuarioDTO usuario) {
        if(usuario.getTipoUsuario().equals("empleado")) {
            Sucursal sucursal = empleadoDao.obtenerSucursalPorEmpleado(usuario.getNombreUsuario());
            return SucursalMapper.toDTO(sucursal);
        }
        
        return null;
    }
}
