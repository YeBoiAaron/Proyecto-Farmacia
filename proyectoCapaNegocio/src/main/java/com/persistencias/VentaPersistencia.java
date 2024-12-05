/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.interfaces.IRecetaDAO;
import com.daos.implementaciones.RecetaDAO;
import com.dtos.RecetaDTO;
import com.entidades.Receta;
import com.mappers.RecetaMapper;

import javax.persistence.EntityManager;

/**
 * Clase de persistencia para manejar las recetas relacionadas con ventas.
 *
 * @author oribi
 */
public class VentaPersistencia {
    private IRecetaDAO recetaDao;

    /**
     * Constructor que inicializa recetaDao utilizando un EntityManager.
     *
     * @param entityManager el EntityManager a utilizar.
     */
    public VentaPersistencia(EntityManager entityManager) {
        this.recetaDao = new RecetaDAO(entityManager);
    }

    /**
     * Busca una receta por su número.
     *
     * @param numeroReceta el número de la receta a buscar.
     * @return un objeto RecetaDTO con los detalles de la receta, o null si no se encuentra.
     */
    public RecetaDTO buscarReceta(String numeroReceta) {
        try {
            Receta receta = recetaDao.obtenerPorNumeroReceta(numeroReceta);
            if (receta != null) {
                return RecetaMapper.toDTO(receta);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo adicional de errores, si es necesario
        }
        return null;
    }
}


