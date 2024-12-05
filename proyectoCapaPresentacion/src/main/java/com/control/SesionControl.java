/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.EmpleadoDTO;
import com.dtos.UsuarioDTO;
import com.pantallas.empleado.frmInicioEmpleadoFarmacia;
import com.pantallas.medico.frmInicioMedico;
import com.persistencias.UsuarioPersistencia;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class SesionControl extends Control{
    private UsuarioPersistencia usrPersistencia;

    public SesionControl() {
        usrPersistencia = new UsuarioPersistencia();
    }
    
    public void iniciarSesion(String nombreUsuario, String contrasena) {
        if(nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                UsuarioDTO usuario = usrPersistencia.verificarCredenciales(nombreUsuario, contrasena);
                Sesion.setUsuarioLogueado(usuario);
                if(usuario.getTipoUsuario().equals("medico")) {
                    frmInicioMedico medico = new frmInicioMedico();
                    medico.setVisible(true);
                } else if(usuario.getTipoUsuario().equals("empleado")) {
                    frmInicioEmpleadoFarmacia empleado = new frmInicioEmpleadoFarmacia();
                    empleado.setVisible(true);
                }
            } catch(NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void crearNuevaSucursal(EmpleadoDTO empleado) {
        
    }
    
}
