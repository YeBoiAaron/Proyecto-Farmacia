/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.MedicamentosRecetaDTO;
import com.entidades.MedicamentosReceta;

/**
 *
 * @author Aaron
 */
public class MedicamentosRecetaMapper {
    public static MedicamentosRecetaDTO toDto(MedicamentosReceta medicamentosReceta) {
        return new MedicamentosRecetaDTO(medicamentosReceta.getCantidad(), medicamentosReceta.getMedicamento().getNumeroSerie(), medicamentosReceta.getReceta().getNumeroReceta());
    }
}
