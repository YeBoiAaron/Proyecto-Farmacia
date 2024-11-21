/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.MedicoDTO;
import com.entidades.Medico;

/**
 *
 * @author Aaron
 */
public class MedicoMapper {

    public static MedicoDTO toDTO(Medico medico) {
        return new MedicoDTO(medico.getNombreCompleto(), medico.getNumeroTelefono(), medico.getCedulaProfesional(), medico.getFechaNacimiento());
    }

    public static Medico toEntity(MedicoDTO medicoDto) {
        return new Medico(medicoDto.getNombreCompleto(), medicoDto.getNumeroTelefono(), medicoDto.getCedulaProfesional(), medicoDto.getFechaNacimiento());
    }
    
}
