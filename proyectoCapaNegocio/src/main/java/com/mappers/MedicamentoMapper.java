/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.MedicamentoDTO;
import com.entidades.Medicamento;

/**
 *
 * @author Aaron
 */
public class MedicamentoMapper implements IMapper<Medicamento, MedicamentoDTO> {

    @Override
    public MedicamentoDTO toDTO(Medicamento medicamento) {
        return new MedicamentoDTO(medicamento.getNombre(), medicamento.getPresentacion(), medicamento.getConcentracion(), medicamento.getConcentracion(), medicamento.getPrecio());
    }

    @Override
    public Medicamento toEntity(MedicamentoDTO medicamentodto) {
        return new Medicamento(medicamentodto.getNombre(), medicamentodto.getPresentacion(), medicamentodto.getConcentracion(), medicamentodto.getConcentracion(), medicamentodto.getPrecio());
    }
    
}
