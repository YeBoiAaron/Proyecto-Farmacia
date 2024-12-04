/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.dtos.MedicamentosRecetaDTO;
import com.dtos.RecetaDTO;
import com.persistencias.MedicamentoPersistencia;
import com.persistencias.MedicamentosRecetaPersistencia;
import com.persistencias.RecetaPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author Aaron
 */
public class RecetaServicio {
    private RecetaPersistencia recetaPersistencia;
    private MedicamentoPersistencia medPersistencia;
    private MedicamentosRecetaPersistencia medsRecetaPersistencia;

    public RecetaServicio() {
        recetaPersistencia = new RecetaPersistencia();
        medPersistencia = new MedicamentoPersistencia();
        medsRecetaPersistencia = new MedicamentosRecetaPersistencia();
    }
    
    public String generarNumeroReceta() {
        String numeroReceta = new Random().ints(7, 0, "0123456789".length())
                .mapToObj("0123456789"::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
        if(numeroRecetaExiste(numeroReceta)) {
            return generarNumeroReceta();
        }else return numeroReceta;
    }
    
    public boolean numeroRecetaExiste(String numeroReceta) {
        RecetaDTO receta = recetaPersistencia.buscarReceta(numeroReceta);
        if(receta != null) {
            String busquedaNumReceta = receta.getNumeroReceta();
            return busquedaNumReceta.trim().equals(numeroReceta.trim());
        } 
        return false;
    }
    
    public List<String> obtenerMedicamentosInstruccionesDeReceta(String numeroReceta) {
        List<String> listaMedicamentosInstrucciones = new ArrayList<>();
        List<MedicamentosRecetaDTO> medsRecetaDto = medsRecetaPersistencia.buscarPorNumeroReceta(numeroReceta);
        if(medsRecetaDto != null) {
            for (MedicamentosRecetaDTO medRecetaDto : medsRecetaDto) {
                String medicamentoInstrucciones = medPersistencia.buscarMedicamento(medRecetaDto.getNumeroSerieMedicamento()).getNombre() + ": " + medRecetaDto.getInstrucciones();
                listaMedicamentosInstrucciones.add(medicamentoInstrucciones);
            }
            return listaMedicamentosInstrucciones;
        }
        
        return null;
    }
        
}
