/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.daos.implementaciones.MedicamentoDAO;
import com.daos.implementaciones.RecetaDAO;
import com.dtos.MedicamentosRecetaDTO;
import com.entidades.MedicamentosReceta;
import com.persistencias.JPAUtil;

/**
 *
 * @author Aaron
 */
public class MedicamentosRecetaMapper {
    
    public static MedicamentosRecetaDTO toDto(MedicamentosReceta medicamentosReceta) {
        MedicamentosRecetaDTO medicamentosRecetaDto = new MedicamentosRecetaDTO(
                medicamentosReceta.getCantidad(),
                medicamentosReceta.getInstrucciones(),
                medicamentosReceta.getMedicamento().getNumeroSerie(),
                medicamentosReceta.getReceta().getNumeroReceta());
        return medicamentosRecetaDto;
    }
    
    public static MedicamentosReceta toEntity(MedicamentosRecetaDTO medicamentosRecetaDto) {
        MedicamentosReceta medicamentosReceta = new MedicamentosReceta(
                medicamentosRecetaDto.getCantidad(),
                medicamentosRecetaDto.getInstrucciones(),
                new MedicamentoDAO(JPAUtil.getEntityManagerFactory().createEntityManager()).obtenerPorNumeroSerie(medicamentosRecetaDto.getNumeroSerieMedicamento()),
                new RecetaDAO(JPAUtil.getEntityManagerFactory().createEntityManager()).obtenerPorNumeroReceta(medicamentosRecetaDto.getNumeroReceta()));
        return medicamentosReceta;
    }
}
