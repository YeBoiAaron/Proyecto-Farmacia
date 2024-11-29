/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.UsuarioDTO;
import com.entidades.Usuario;

/**
 *
 * @author Aaron
 */
public class UsuarioMapper {
    
    public static UsuarioDTO toDto(Usuario usuario, String tipoUsuario) {
        UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getNombreUsuario(), usuario.getCorreo(), usuario.getContrasena(), tipoUsuario);
        return usuarioDto;
    }
    
}
