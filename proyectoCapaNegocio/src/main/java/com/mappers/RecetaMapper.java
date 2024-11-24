/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mappers;

import com.dtos.RecetaDTO;
import com.entidades.Receta;

/**
 *
 * @author Aaron
 */
public class RecetaMapper {
    
    public static RecetaDTO toDTO(Receta receta) {
        RecetaDTO recetadto = new RecetaDTO(receta.getNumeroReceta(), receta.getDiagnostico(), receta.getEstado());
        return recetadto;
    }
    
    public static Receta toEntity(RecetaDTO recetaDto) {
        Receta receta = new Receta(recetaDto.getNumeroReceta(), recetaDto.getDiagnostico(), recetaDto.getEstado());
        return receta;
    }
}
