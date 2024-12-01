/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.EmpleadoDTO;
import com.entidades.Empleado;
import java.time.LocalDate;

/**
 *
 * @author Aaron
 */
public class EmpleadoMapper {
    
    public static EmpleadoDTO toDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        
        // Asignar los atributos de Usuario (los que vienen de la clase Padre Usuario)
        empleadoDTO.setNombreUsuario(empleado.getNombreUsuario());
        empleadoDTO.setCorreo(empleado.getCorreo());
        empleadoDTO.setContrasena(empleado.getContrasena());

        // Asignar los atributos de Empleado (los que vienen de la clase hija Empleado)
        empleadoDTO.setNombreCompleto(empleado.getNombreCompleto());
        empleadoDTO.setNumeroTelefono(empleado.getNumeroTelefono());
        empleadoDTO.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoDTO.setTipoEmpleado(empleado.getTipoEmpleado());
        
        return empleadoDTO;
    }
    
    public static Empleado toEntity(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        
        // Asignar los atributos de Usuario (los que vienen de la clase Padre UsuarioDTO)
        empleado.setNombreUsuario(empleadoDTO.getNombreUsuario());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setContrasena(empleadoDTO.getContrasena());

        // Asignar los atributos de Empleado (los que vienen de la clase hija EmpleadoDTO)
        empleado.setNombreCompleto(empleadoDTO.getNombreCompleto());
        empleado.setNumeroTelefono(empleadoDTO.getNumeroTelefono());
        empleado.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
        empleado.setTipoEmpleado(empleadoDTO.getTipoEmpleado());
        
        return empleado;
    }
}
