/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.interfaces.IRecetaDAO;
import com.daos.implementaciones.RecetaDAO;
import com.daos.implementaciones.VentaDAO;
import com.daos.interfaces.IVentaDAO;
import com.dtos.EmpleadoDTO;
import com.dtos.RecetaDTO;
import com.dtos.VentaDTO;
import com.entidades.Receta;
import com.entidades.Venta;
import com.mappers.RecetaMapper;
import com.mappers.VentaMapper;
import com.servicios.JPAUtil;
import javax.persistence.EntityManager;

/**
 * Clase de persistencia para manejar las recetas relacionadas con ventas.
 *
 * @author oribi
 */
public class VentaPersistencia {
    private IRecetaDAO recetaDao;
    private IVentaDAO ventaDao;

    /**
     * Constructor que inicializa recetaDao utilizando un EntityManager.
     */
    public VentaPersistencia() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        recetaDao = new RecetaDAO(entityManager);
        ventaDao = new VentaDAO(entityManager);
    }
    
    public void agregarVenta(VentaDTO venta, String nombreUsuario, String numeroReceta) {
        
    }
    
    public VentaDTO buscarVenta(String folio) {
        Venta venta = ventaDao.obtenerPorFolio(folio);
        if(venta != null) {
            return VentaMapper.toDTO(venta);
        } 
        
        return null;
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


