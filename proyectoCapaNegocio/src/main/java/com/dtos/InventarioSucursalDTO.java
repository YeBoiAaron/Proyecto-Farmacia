/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class InventarioSucursalDTO {
    private int cantidad;
    private MedicamentoDTO medicamento;
    private SucursalDTO sucursal;

    public InventarioSucursalDTO() {
    }

    public InventarioSucursalDTO(int cantidad, MedicamentoDTO medicamento, SucursalDTO sucursal) {
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.sucursal = sucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO medicamento) {
        this.medicamento = medicamento;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.medicamento);
        hash = 83 * hash + Objects.hashCode(this.sucursal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventarioSucursalDTO other = (InventarioSucursalDTO) obj;
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return Objects.equals(this.sucursal, other.sucursal);
    }

    @Override
    public String toString() {
        return "InventarioSucursalDTO{" + "cantidad=" + cantidad + ", medicamento=" + medicamento + ", sucursal=" + sucursal + '}';
    }
}
