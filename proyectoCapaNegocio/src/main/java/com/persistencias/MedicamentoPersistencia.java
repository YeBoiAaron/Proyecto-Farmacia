/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import com.daos.implementaciones.InventarioSucursalDAO;
import com.servicios.JPAUtil;
import com.daos.implementaciones.MedicamentoDAO;
import com.daos.implementaciones.SucursalDAO;
import com.daos.interfaces.IInventarioSucursalDAO;
import com.daos.interfaces.IMedicamentoDAO;
import com.daos.interfaces.ISucursalDAO;
import com.dtos.MedicamentoDTO;
import com.dtos.SucursalDTO;
import com.entidades.InventarioSucursal;
import com.entidades.Medicamento;
import com.entidades.Sucursal;
import com.mappers.MedicamentoMapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author martinez
 */
public class MedicamentoPersistencia {
    private EntityManager entityManager;
    private IMedicamentoDAO medicamentoDao;
    private ISucursalDAO sucursalDao;
    private IInventarioSucursalDAO inventarioDao;
    
    public MedicamentoPersistencia(){
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        medicamentoDao = new MedicamentoDAO(entityManager);
        sucursalDao = new SucursalDAO(entityManager);
        inventarioDao = new InventarioSucursalDAO(entityManager);
    }
    
    public void agregarMedicamento(MedicamentoDTO medicamentoDto, SucursalDTO sucursalDto, int cantidad) {
        Medicamento medicamento = MedicamentoMapper.toEntity(medicamentoDto);
        Sucursal sucursal = sucursalDao.obtenerPorNombreSucursal(sucursalDto.getNombreSucursal());
        InventarioSucursal inventario = new InventarioSucursal();
        inventario.setMedicamento(medicamento);
        inventario.setSucursal(sucursal);
        inventario.setCantidad(cantidad);
        medicamento.setInventarios(new ArrayList<>());
        medicamento.getInventarios().add(inventario);
        sucursal.getInventario().add(inventario);

        medicamentoDao.agregar(medicamento);
    }
    
    public boolean actualizarMedicamento(MedicamentoDTO medicamentoDto, SucursalDTO sucursalDto, int cantidad) {
        InventarioSucursal inventario = inventarioDao.obtenerPorMedicamentoYSucursal(medicamentoDto.getNumeroSerie(), sucursalDto.getNombreSucursal());
        if(inventario != null) {
            inventario.setCantidad(cantidad);
            Medicamento medicamento = inventario.getMedicamento();
            medicamento.setPrecio(medicamentoDto.getPrecio());

            inventarioDao.actualizar(inventario);
            medicamentoDao.actualizar(medicamento);
            return true;
        } else {
            return false;
        }
    }
    
    public MedicamentoDTO buscarMedicamento(String numeroSerie) {
        Medicamento medicamento = medicamentoDao.obtenerPorNumeroSerie(numeroSerie);
        if(medicamento != null) {
            return MedicamentoMapper.toDTO(medicamento);
        }
        
        return null;
    }
    
    public List<MedicamentoDTO> obtenerMedicamentosPorNombre(String nombreMedicamento) {
        List<MedicamentoDTO> medicamentosDto = new ArrayList<>();
        List<Medicamento> medicamentos = medicamentoDao.obtenerPorNombre(nombreMedicamento);
        if(!medicamentos.isEmpty()) {
            for (Medicamento medicamento : medicamentos) {
                medicamentosDto.add(MedicamentoMapper.toDTO(medicamento));
            }
            return medicamentosDto;
        }
        
        return null;
    }
    
    public List<MedicamentoDTO> listaMedicamentos() {
        List<MedicamentoDTO> medicamentosDto = new ArrayList<>();
        List<Medicamento> medicamentos = medicamentoDao.lista();
        if(!medicamentos.isEmpty()) {
            for (Medicamento medicamento : medicamentos) {
                medicamentosDto.add(MedicamentoMapper.toDTO(medicamento));
            }
            return medicamentosDto;
        }
        
        return null;
    }
    
}
