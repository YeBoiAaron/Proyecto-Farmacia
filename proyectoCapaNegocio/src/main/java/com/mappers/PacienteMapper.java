/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.PacienteDTO;
import com.entidades.Paciente;

/**
 *
 * @author Aaron
 */
public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente paciente) {
        return new PacienteDTO(paciente.getNombreCompleto(), paciente.getFechaNacimiento(), paciente.getNumeroTelefono(), paciente.getCorreo(), paciente.getSexo(), paciente.getAltura(), paciente.getPeso(), paciente.getEdad());
    }

    public static Paciente toEntity(PacienteDTO pacientedto) {
        return new Paciente(pacientedto.getNombreCompleto(), pacientedto.getFechaNacimiento(), pacientedto.getNumeroTelefono(), pacientedto.getCorreo(), pacientedto.getSexo(), pacientedto.getAltura(), pacientedto.getPeso(), pacientedto.getEdad());
    }
    
}
