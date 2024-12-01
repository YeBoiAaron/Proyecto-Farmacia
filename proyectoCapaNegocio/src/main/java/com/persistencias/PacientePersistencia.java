/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.PacienteDAO;
import com.daos.interfaces.IPacienteDAO;
import com.dtos.PacienteDTO;
import com.entidades.Paciente;
import com.mappers.PacienteMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class PacientePersistencia {
    EntityManager em;
    IPacienteDAO pdao;

    public PacientePersistencia() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        pdao = new PacienteDAO(em);
    }
    
    public void crearPaciente(PacienteDTO pacientedto) {
        Paciente paciente = PacienteMapper.toEntity(pacientedto);
        pdao.agregar(paciente);
    }
    
    public List<PacienteDTO> buscarPaciente(String nombreCompleto) {
        List<Paciente> pacientes = pdao.obtenerPorNombre(nombreCompleto);
        if(pacientes != null) {
            List<PacienteDTO> pacientesDto = new ArrayList<>();
            for (Paciente paciente : pacientes) {
                pacientesDto.add(PacienteMapper.toDTO(paciente));
            }
            return pacientesDto;
        }
        
        return null;
    }
}
