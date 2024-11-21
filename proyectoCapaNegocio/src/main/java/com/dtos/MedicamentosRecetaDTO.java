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
public class MedicamentosRecetaDTO {
    private int cantidad;
    private String numeroSerieMedicamento;
    private String numeroReceta;

    public MedicamentosRecetaDTO() {
    }

    public MedicamentosRecetaDTO(int cantidad, String medicamento, String receta) {
        this.cantidad = cantidad;
        this.numeroSerieMedicamento = medicamento;
        this.numeroReceta = receta;
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

    public void setNumeroSerieMedicamento(String medicamento) {
        this.numeroSerieMedicamento = medicamento;
    }

    public String getNumeroReceta() {
        return numeroReceta;
    }

    public void setNumeroReceta(String receta) {
        this.numeroReceta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroSerieMedicamento);
        hash = 47 * hash + Objects.hashCode(this.numeroReceta);
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
        final MedicamentosRecetaDTO other = (MedicamentosRecetaDTO) obj;
        if (!Objects.equals(this.numeroSerieMedicamento, other.numeroSerieMedicamento)) {
            return false;
        }
        return Objects.equals(this.numeroReceta, other.numeroReceta);
    }

    @Override
    public String toString() {
        return "MedicamentosRecetaDTO{" + "cantidad=" + cantidad + ", medicamento=" + numeroSerieMedicamento + ", receta=" + numeroReceta + '}';
    }
}
