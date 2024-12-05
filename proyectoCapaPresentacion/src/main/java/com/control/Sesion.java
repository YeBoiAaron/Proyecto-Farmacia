/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.SucursalDTO;
import com.dtos.UsuarioDTO;

/**
 *
 * @author Aaron
 */
public class Sesion {
    private static UsuarioDTO usuarioLogueado;
    private static SucursalDTO sucursalEmpleado;
    
    public static void setUsuarioLogueado(UsuarioDTO usuario) {
        usuarioLogueado = usuario;
    }
    
    public static UsuarioDTO getUsuarioLogueado() {
        return usuarioLogueado;
    }
    
    public static void setSucursalEmpleado(SucursalDTO sucursal) {
        sucursalEmpleado = sucursal;
    }
    
    public static SucursalDTO getSucursalEmpleado() {
        return sucursalEmpleado;
    }
    
    public static void cerrarSesion() {
        usuarioLogueado = null;
    }
}
