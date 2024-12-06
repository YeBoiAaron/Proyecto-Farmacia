/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.dtos.MedicamentoDTO;
import com.persistencias.MedicamentoPersistencia;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author Aaron
 */
public class InventarioServicio {
    
    private MedicamentoPersistencia medPersistencia;

    public InventarioServicio() {
        medPersistencia = new MedicamentoPersistencia();
    }
    
    public String generarNumeroSerie(String nombreMedicamento) {
        String numeroSerie = new Random().ints(7, 0, "0123456789".length())
                .mapToObj("0123456789"::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
        numeroSerie = numeroSerie.substring(0,3) + numeroSerie;
        if(numeroSerieExiste(numeroSerie)) {
            return generarNumeroSerie(nombreMedicamento);
        }else return numeroSerie;
    }
    
    public boolean numeroSerieExiste(String numeroSerie) {
        MedicamentoDTO medicamento = medPersistencia.buscarMedicamento(numeroSerie);
        if(medicamento != null) {
            String busquedaNumReceta = medicamento.getNumeroSerie();
            return busquedaNumReceta.trim().equals(numeroSerie.trim());
        } 
        return false;
    }
}
