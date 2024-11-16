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
public class MedicamentoDTO {
    private String nombre;
    private String presentacion;
    private String concentracion;
    private String activo;
    private float precio;

    public MedicamentoDTO() {
    }

    public MedicamentoDTO(String nombre, String presentacion, String concentracion, String activo, float precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.concentracion = concentracion;
        this.activo = activo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.presentacion);
        hash = 83 * hash + Objects.hashCode(this.concentracion);
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
        final MedicamentoDTO other = (MedicamentoDTO) obj;
        if (!Objects.equals(this.presentacion, other.presentacion)) {
            return false;
        }
        if (!Objects.equals(this.concentracion, other.concentracion)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "MedicamentoDTO{" + "nombre=" + nombre + ", presentacion=" + presentacion + ", concentracion=" + concentracion + ", activo=" + activo + ", precio=" + precio + '}';
    }
}
