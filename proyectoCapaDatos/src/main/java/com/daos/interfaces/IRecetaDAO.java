/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.Receta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IRecetaDAO extends IDAO<Receta> {
    public Receta obtenerPorNumeroReceta(String numeroReceta);
    
    public List<Receta> obtenerPorPaciente(String nombrePaciente, LocalDate fechaNacimiento);
}
