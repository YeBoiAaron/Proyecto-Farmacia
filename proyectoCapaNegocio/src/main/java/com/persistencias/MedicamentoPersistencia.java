/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

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
    private EntityManager em;
    private IMedicamentoDAO mdao;
    
    public MedicamentoPersistencia(){
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        mdao = new MedicamentoDAO(em);
    }
    
    public void agregarMedicamento(MedicamentoDTO medicamentoDTO){
        Medicamento medicamento = MedicamentoMapper.toEntity(medicamentoDTO);
        mdao.agregar(medicamento);
    }
    
    public List<MedicamentoDTO> listaMedicamentos() {
        List<MedicamentoDTO> medicamentosDto = new ArrayList<>();
        List<Medicamento> medicamentos = mdao.lista();
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
        List<Medicamento> medicamentos = mdao.obtenerPorNombre(nombreMedicamento);
        if(!medicamentos.isEmpty()) {
            for (Medicamento medicamento : medicamentos) {
                medicamentosDto.add(MedicamentoMapper.toDTO(medicamento));
            }
            return medicamentosDto;
        }
        
        return null;
    }
}
