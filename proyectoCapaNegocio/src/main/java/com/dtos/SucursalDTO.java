/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class SucursalDTO {
    private String calle;
    private String numero;
    private String colonia;
    private int codigoPostal;
    private EmpleadoDTO gerente;
    private List<InventarioSucursalDTO> inventario;

    public SucursalDTO() {
    }

    public SucursalDTO(String calle, String numero, String colonia, int codigoPostal, EmpleadoDTO gerente, List<InventarioSucursalDTO> inventario) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.gerente = gerente;
        this.inventario = inventario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public EmpleadoDTO getGerente() {
        return gerente;
    }

    public void setGerente(EmpleadoDTO gerente) {
        this.gerente = gerente;
    }

    public List<InventarioSucursalDTO> getInventario() {
        return inventario;
    }

    public void setInventario(List<InventarioSucursalDTO> inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.calle);
        hash = 13 * hash + Objects.hashCode(this.numero);
        hash = 13 * hash + Objects.hashCode(this.colonia);
        hash = 13 * hash + this.codigoPostal;
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
        final SucursalDTO other = (SucursalDTO) obj;
        if (this.codigoPostal != other.codigoPostal) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.colonia, other.colonia);
    }

    @Override
    public String toString() {
        return "SucursalDTO{" + "calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", gerente=" + gerente + ", inventario=" + inventario + '}';
    }
}
