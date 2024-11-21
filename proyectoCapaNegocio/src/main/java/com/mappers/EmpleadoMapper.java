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
        return new EmpleadoDTO(empleado.getNombreCompleto(), empleado.getNumeroTelefono(), empleado.getFechaNacimiento(), empleado.getTipoEmpleado());
    }
    
    public static Empleado toEntity(EmpleadoDTO empleadoDto) {
        return new Empleado(empleadoDto.getNombreCompleto(), empleadoDto.getNumeroTelefono(), empleadoDto.getFechaNacimiento(), empleadoDto.getTipoEmpleado());
    }
}
