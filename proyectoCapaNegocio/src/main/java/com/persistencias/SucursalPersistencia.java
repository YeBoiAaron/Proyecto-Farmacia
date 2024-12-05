/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.SucursalDAO;
import com.daos.interfaces.ISucursalDAO;
import com.dtos.EmpleadoDTO;
import com.dtos.SucursalDTO;
import com.entidades.Empleado;
import com.entidades.Sucursal;
import com.mappers.EmpleadoMapper;
import com.mappers.SucursalMapper;
import com.servicios.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class SucursalPersistencia {
    
    private EntityManager entityManager;
    ISucursalDAO sucursalDao;

    public SucursalPersistencia() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        sucursalDao = new SucursalDAO(entityManager);
    }
    
    public void crearSucursal(SucursalDTO sucursalDto) {
        Sucursal sucursal = SucursalMapper.toEntity(sucursalDto);
        sucursalDao.agregar(sucursal);
    }
    
    public SucursalDTO obtenerSucursalPorNombre(String nombreSucursal) {
        Sucursal sucursal = sucursalDao.obtenerPorNombreSucursal(nombreSucursal);
        if(sucursal != null) {
            SucursalDTO sucursalDto = SucursalMapper.toDTO(sucursal);
            return sucursalDto;
        }
        
        return null;
    }
    
    public EmpleadoDTO obtenerGerenteSucursal(String nombreSucursal) {
        Empleado empleado = sucursalDao.obtenerGerenteSucursal(nombreSucursal);
        if(empleado != null) {
            EmpleadoDTO empleadoDto = EmpleadoMapper.toDTO(empleado);
            return empleadoDto;
        }

        return null;
    }
    
    public List<SucursalDTO> listaSucursales() {
        List<SucursalDTO> sucursalesDto = new ArrayList<>();
        List<Sucursal> sucursales = sucursalDao.lista();
        
        if(!sucursales.isEmpty()) {
            for (Sucursal sucursal : sucursales) {
                sucursalesDto.add(SucursalMapper.toDTO(sucursal));
            }
            return sucursalesDto;
        }
        
        return null;
    }
}
