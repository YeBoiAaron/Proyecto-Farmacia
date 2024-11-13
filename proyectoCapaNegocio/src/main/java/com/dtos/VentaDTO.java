/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class VentaDTO {
    private String folio;
    private float subtotal;
    private float total;
    private LocalDate fecha;

    public VentaDTO() {
    }

    public VentaDTO(String folio, float subtotal, float total, LocalDate fecha) {
        this.folio = folio;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.folio);
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
        final VentaDTO other = (VentaDTO) obj;
        return Objects.equals(this.folio, other.folio);
    }

    @Override
    public String toString() {
        return "VentaDTO{" + "folio=" + folio + ", subtotal=" + subtotal + ", total=" + total + ", fecha=" + fecha + '}';
    }
}
