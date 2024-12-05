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
public class SucursalDTO {
    private String nombreSucursal;
    private String calle;
    private int numero;
    private String colonia;
    private int codigoPostal;

    public SucursalDTO() {
    }

    public SucursalDTO(String nombreSucursal, String calle, int numero, String colonia, int codigoPostal) {
        this.nombreSucursal = nombreSucursal;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombreSucursal);
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
        return Objects.equals(this.nombreSucursal, other.nombreSucursal);
    }

    @Override
    public String toString() {
        return "SucursalDTO{" + "nombre sucursal=" + nombreSucursal + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigo postal=" + codigoPostal + '}';
    }
}
