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
    private String numeroSerieMedicamento;
    private String nombreSucursal;

    public InventarioSucursalDTO() {
    }

    public InventarioSucursalDTO(int cantidad, String numeroSerieMedicamento, String nombreSucursal) {
        this.cantidad = cantidad;
        this.numeroSerieMedicamento = numeroSerieMedicamento;
        this.nombreSucursal = nombreSucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumeroSerieMedicamento() {
        return numeroSerieMedicamento;
    }

    public void setNumeroSerieMedicamento(String numeroSerieMedicamento) {
        this.numeroSerieMedicamento = numeroSerieMedicamento;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.numeroSerieMedicamento);
        hash = 83 * hash + Objects.hashCode(this.nombreSucursal);
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
        if (!Objects.equals(this.numeroSerieMedicamento, other.numeroSerieMedicamento)) {
            return false;
        }
        return Objects.equals(this.nombreSucursal, other.nombreSucursal);
    }

    @Override
    public String toString() {
        return "InventarioSucursalDTO{" + "cantidad=" + cantidad + ", numero de serie medicamento=" + numeroSerieMedicamento + ", nombre sucursal=" + nombreSucursal + '}';
    }
}
