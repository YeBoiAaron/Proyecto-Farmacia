/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import com.dtos.VentaDTO;
import com.persistencias.VentaPersistencia;
import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author Aaron
 */
public class VentaServicio {
    private VentaPersistencia ventaPersistencia;

    public VentaServicio() {
        ventaPersistencia = new VentaPersistencia();
    }
    
    public String generarFolio() {
        String folio = new Random().ints(5, 0, "0123456789".length())
                .mapToObj("0123456789"::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
        folio = folio + LocalDate.now().toString().substring(5,9);
        if(folioExiste(folio)) {
            return generarFolio();
        }else return folio;
    }
    
    public boolean folioExiste(String folio) {
        VentaDTO venta = ventaPersistencia.buscarVenta(folio);
        if(venta != null) {
            String busquedaFolio = venta.getFolio();
            return busquedaFolio.trim().equals(folio.trim());
        } 
        return false;
    }
}
