/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.servicios.JPAUtil;
import com.daos.implementaciones.MedicamentoDAO;
import com.daos.interfaces.IMedicamentoDAO;
import com.dtos.MedicamentoDTO;
import com.entidades.Medicamento;
import com.mappers.MedicamentoMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author martinez
 */
public class MedicamentoPersistencia {
    private EntityManager entityManager;
    private IMedicamentoDAO medicamentoDao;
    
    public MedicamentoPersistencia(){
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        medicamentoDao = new MedicamentoDAO(entityManager);
    }
    
    public void agregarMedicamento(MedicamentoDTO medicamentoDTO){
        Medicamento medicamento = MedicamentoMapper.toEntity(medicamentoDTO);
        medicamentoDao.agregar(medicamento);
    }
    
    public MedicamentoDTO buscarMedicamento(String numeroSerie) {
        Medicamento medicamento = medicamentoDao.obtenerPorNumeroSerie(numeroSerie);
        if(medicamento != null) {
            return MedicamentoMapper.toDTO(medicamento);
        }
        
        return null;
    }
    
    public List<MedicamentoDTO> listaMedicamentos() {
        List<MedicamentoDTO> medicamentosDto = new ArrayList<>();
        List<Medicamento> medicamentos = medicamentoDao.lista();
        if(!medicamentos.isEmpty()) {
            for (Medicamento medicamento : medicamentos) {
                medicamentosDto.add(MedicamentoMapper.toDTO(medicamento));
            }
            return medicamentosDto;
        }
        
        return null;
    }
    
    public List<MedicamentoDTO> obtenerMedicamentosPorNombre(String nombreMedicamento) {
        List<MedicamentoDTO> medicamentosDto = new ArrayList<>();
        List<Medicamento> medicamentos = medicamentoDao.obtenerPorNombre(nombreMedicamento);
        if(!medicamentos.isEmpty()) {
            for (Medicamento medicamento : medicamentos) {
                medicamentosDto.add(MedicamentoMapper.toDTO(medicamento));
            }
            return medicamentosDto;
        }
        
        return null;
    }
}
