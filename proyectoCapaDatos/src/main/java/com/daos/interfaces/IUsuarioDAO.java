/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.Usuario;

/**
 *
 * @author Aaron
 */
public interface IUsuarioDAO extends IDAO<Usuario> {
    public Usuario obtenerPorNombreUsuarioYContrasena(String nombreUsuario, String contrasena);
}
