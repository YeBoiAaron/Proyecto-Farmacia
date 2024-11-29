/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class UsuarioDTO {
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private String tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombreUsuario, String correo, String contrasena, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombreUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDTO other = (UsuarioDTO) obj;
        return Objects.equals(this.nombreUsuario, other.nombreUsuario);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "nombre usuario=" + nombreUsuario + ", correo=" + correo + ", contrasena=" + contrasena + ", tipo usuario=" + tipoUsuario + '}';
    }
}
