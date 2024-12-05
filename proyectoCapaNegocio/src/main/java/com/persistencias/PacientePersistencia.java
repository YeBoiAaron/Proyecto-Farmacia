/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.servicios.JPAUtil;
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
    EntityManager entityManager;
    IPacienteDAO pacienteDao;

    public PacientePersistencia() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        pacienteDao = new PacienteDAO(entityManager);
    }
    
    public void crearPaciente(PacienteDTO pacientedto) {
        Paciente paciente = PacienteMapper.toEntity(pacientedto);
        pacienteDao.agregar(paciente);
    }
    
    public List<PacienteDTO> buscarPaciente(String nombreCompleto) {
        List<Paciente> pacientes = pacienteDao.obtenerPorNombre(nombreCompleto);
        if(pacientes != null) {
            List<PacienteDTO> pacientesDto = new ArrayList<>();
            for (Paciente paciente : pacientes) {
                pacientesDto.add(PacienteMapper.toDTO(paciente));
            }
            return pacientesDto;
        }
        
        return null;
    }
    
    public PacienteDTO buscarPorCorreo(String correo) {
        return PacienteMapper.toDTO(pacienteDao.obtenerPorCorreo(correo));
    }
}
