/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.servicios.JPAUtil;
import com.daos.implementaciones.MedicamentosRecetaDAO;
import com.daos.interfaces.IMedicamentosRecetaDAO;
import com.dtos.MedicamentosRecetaDTO;
import com.entidades.MedicamentosReceta;
import com.mappers.MedicamentosRecetaMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class MedicamentosRecetaPersistencia {
    
    private EntityManager entityManager;
    private IMedicamentosRecetaDAO medRecetaDao;

    public MedicamentosRecetaPersistencia() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        medRecetaDao = new MedicamentosRecetaDAO(entityManager);
    }
    
    public List<MedicamentosRecetaDTO> buscarPorNumeroReceta(String numeroReceta) {
        List<MedicamentosReceta> medicamentosReceta = medRecetaDao.obtenerPorNumeroDeReceta(numeroReceta);
        if(medicamentosReceta != null) {
            List<MedicamentosRecetaDTO> medsRecetaDto = new ArrayList<>();
            for(MedicamentosReceta medicamentoReceta : medicamentosReceta) {
                medsRecetaDto.add(MedicamentosRecetaMapper.toDto(medicamentoReceta));
            }
            return medsRecetaDto;
        }
        
        return null;
    }
}
