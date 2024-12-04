/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.servicios.JPAUtil;
import com.daos.implementaciones.MedicamentoDAO;
import com.daos.implementaciones.MedicoDAO;
import com.daos.implementaciones.PacienteDAO;
import com.daos.implementaciones.RecetaDAO;
import com.daos.interfaces.IMedicamentoDAO;
import com.daos.interfaces.IMedicoDAO;
import com.daos.interfaces.IPacienteDAO;
import com.daos.interfaces.IRecetaDAO;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.MedicoDTO;
import com.dtos.PacienteDTO;
import com.dtos.RecetaDTO;
import com.entidades.Medicamento;
import com.entidades.MedicamentosReceta;
import com.entidades.Receta;
import com.mappers.RecetaMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class RecetaPersistencia {
    
    private EntityManager entityManager;
    private IRecetaDAO recetaDao;
    private IMedicamentoDAO medicamentoDao;
    private IMedicoDAO medicoDao;
    private IPacienteDAO pacienteDao;

    public RecetaPersistencia() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        recetaDao = new RecetaDAO(entityManager);
        medicamentoDao = new MedicamentoDAO(entityManager);
        medicoDao = new MedicoDAO(entityManager);
        pacienteDao = new PacienteDAO(entityManager);
    }
    
    public void crearReceta(RecetaDTO recetadto, List<MedicamentosRecetaDTO> medicamentosrecetadto, MedicoDTO medicodto, PacienteDTO pacientedto) {
        Receta receta = RecetaMapper.toEntity(recetadto);
        receta.setMedico(medicoDao.obtenerPorNombreUsuario(medicodto.getNombreUsuario()));
        receta.setPaciente(pacienteDao.obtenerPorCorreo(pacientedto.getCorreo()));
        
        List<MedicamentosReceta> medicamentos = new ArrayList<>();
        for (MedicamentosRecetaDTO medicamentosreceta : medicamentosrecetadto) {
            Medicamento medicamento = medicamentoDao.obtenerPorNumeroSerie(medicamentosreceta.getNumeroSerieMedicamento());
            medicamentos.add(new MedicamentosReceta(medicamentosreceta.getCantidad(), medicamentosreceta.getInstrucciones(), medicamento, receta));
        }
        
        receta.setListaMedicamentos(medicamentos);
        recetaDao.agregar(receta);
    }
    
    public RecetaDTO buscarReceta(String numeroReceta) {
        Receta receta = recetaDao.obtenerPorNumeroReceta(numeroReceta);
        if(receta != null) {
            return RecetaMapper.toDTO(receta);
        } 
        
        return null;
    }
    
    public List<RecetaDTO> buscarPorPaciente(String nombrePaciente, LocalDate fechaNacimiento) {
        List<Receta> recetas = recetaDao.obtenerPorPaciente(nombrePaciente, fechaNacimiento);
        if(recetas != null) {
            List<RecetaDTO> recetasDto = new ArrayList<>();
            for (Receta receta : recetas) {
                recetasDto.add(RecetaMapper.toDTO(receta));
            }
            return recetasDto;
        }
        
        return null;
    }
}