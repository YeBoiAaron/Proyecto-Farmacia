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
public class MedicoMapper implements IMapper<Medico, MedicoDTO> {

    @Override
    public MedicoDTO toDTO(Medico medico) {
        return new MedicoDTO(medico.getNombreCompleto(), medico.getNumeroTelefono(), medico.getCedulaProfesional(), medico.getFechaNacimiento());
    }

    @Override
    public Medico toEntity(MedicoDTO obj) {
        return new Medico(obj.getNombreCompleto(), obj.getNumeroTelefono(), obj.getCedulaProfesional(), obj.getFechaNacimiento());
    }
    
}
