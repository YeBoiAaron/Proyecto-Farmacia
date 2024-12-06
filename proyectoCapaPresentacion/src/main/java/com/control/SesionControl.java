/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.UsuarioDTO;
import com.pantallas.empleado.frmInicioEmpleadoFarmacia;
import com.pantallas.medico.frmInicioMedico;
import com.persistencias.SucursalPersistencia;
import com.persistencias.UsuarioPersistencia;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class SesionControl extends Control{
    private UsuarioPersistencia usrPersistencia;
    private SucursalPersistencia scrslPersistencia;

    public SesionControl() {
        usrPersistencia = new UsuarioPersistencia();
        scrslPersistencia = new SucursalPersistencia();
        
    }
    
    public void iniciarSesion(JFrame parent, String nombreUsuario, String contrasena) {
        if(nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                UsuarioDTO usuario = usrPersistencia.verificarCredenciales(nombreUsuario, contrasena);
                usuario.setContrasena("");
                Sesion.setUsuarioLogueado(usuario);
                if(usuario.getTipoUsuario().equals("medico")) {
                    frmInicioMedico medico = new frmInicioMedico();
                    medico.setVisible(true);
                } else if(usuario.getTipoUsuario().equalsIgnoreCase("Gerente") || usuario.getTipoUsuario().equalsIgnoreCase("Cajero")) {
                    Sesion.setSucursalEmpleado(usrPersistencia.obtenerSucursalDeEmpleado(usuario));
                    frmInicioEmpleadoFarmacia empleado = new frmInicioEmpleadoFarmacia();
                    empleado.setVisible(true);
                }
                parent.dispose();
            } catch(NullPointerException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean validarGerenteExiste(String nombreSucursal) {
        return scrslPersistencia.obtenerGerenteSucursal(nombreSucursal) != null;
    }
    
}
