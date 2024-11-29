/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.dtos.UsuarioDTO;

/**
 *
 * @author Aaron
 */
public class Sesion {
    private static UsuarioDTO usuarioLogueado;
    
    public static void setUsuarioLogueado(UsuarioDTO usuario) {
        usuarioLogueado = usuario;
    }
    
    public static UsuarioDTO getUsuarioLogueado() {
        return usuarioLogueado;
    }
    
    public static void cerrarSesion() {
        usuarioLogueado = null;
    }
}
