/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.MedicamentosRecetaDAO;
import com.daos.implementaciones.RecetaDAO;
import com.daos.interfaces.IMedicamentosRecetaDAO;
import com.daos.interfaces.IRecetaDAO;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.MedicoDTO;
import com.dtos.PacienteDTO;
import com.dtos.RecetaDTO;
import com.entidades.Medicamento;
import com.entidades.MedicamentosReceta;
import com.entidades.Receta;
import com.mappers.MedicamentoMapper;
import com.mappers.MedicoMapper;
import com.mappers.PacienteMapper;
import com.mappers.RecetaMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class RecetaPersistencia {
    
    private EntityManager em;
    private IRecetaDAO rdao;
    private IMedicamentosRecetaDAO mrdao;

    public RecetaPersistencia() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        mrdao = new MedicamentosRecetaDAO(em);
        rdao = new RecetaDAO(em);
    }
    
    public void crearReceta(RecetaDTO recetadto, List<MedicamentosRecetaDTO> medicamentosdto, MedicoDTO medicodto, PacienteDTO pacientedto) {
        Receta receta = RecetaMapper.toEntity(recetadto);
        receta.setMedico(MedicoMapper.toEntity(medicodto));
        receta.setPaciente(PacienteMapper.toEntity(pacientedto));
        
        List<MedicamentosReceta> medicamentos = new ArrayList<MedicamentosReceta>();
        for (MedicamentosRecetaDTO medicamentosreceta : medicamentosdto) {
            medicamentos.add(new MedicamentosReceta(medicamentosreceta.getCantidad(), MedicamentoMapper.toEntity(medicamentosreceta.getMedicamento()), receta));
        }
        
        receta.setListaMedicamentos(medicamentos);
        rdao.agregar(receta);
    }
}
