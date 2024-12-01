/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.Medicamento;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IMedicamentoDAO extends IDAO<Medicamento> {
    public Medicamento obtenerPorNumeroSerie(String numeroSerie);
    
    public List<Medicamento> obtenerPorNombre(String nombreMedicamento);
}
