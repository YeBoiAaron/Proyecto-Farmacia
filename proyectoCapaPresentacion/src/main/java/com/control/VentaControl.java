/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.RecetaDTO;
import com.persistencias.RecetaPersistencia;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentaControl {
    private RecetaPersistencia recetaPersistencia;

    public VentaControl() {
        recetaPersistencia = new RecetaPersistencia();
    }

  /* 
    public RecetaDTO buscarRecetaPorNumero(JFrame parent, String numeroReceta) {
    if (numeroReceta.isEmpty()) {
        JOptionPane.showMessageDialog(parent, "Ingresa el número de receta a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
           
            RecetaPersistencia recetaPersistencia = new RecetaPersistencia();
          
            RecetaDTO receta = recetaPersistencia.buscarReceta(numeroReceta);
            
            if (receta != null) {
               
                return receta;
            } else {
                
                JOptionPane.showMessageDialog(parent, "No se encontró una receta con ese número.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
          
            JOptionPane.showMessageDialog(parent, "Error al buscar la receta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    return null;
}
*/
}


