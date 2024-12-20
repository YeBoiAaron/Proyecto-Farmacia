/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.MedicamentosReceta;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IMedicamentosRecetaDAO extends IDAO<MedicamentosReceta> {
    public List<MedicamentosReceta> obtenerPorNumeroDeReceta(String numeroReceta);
}
