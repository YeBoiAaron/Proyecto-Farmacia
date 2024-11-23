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
}
