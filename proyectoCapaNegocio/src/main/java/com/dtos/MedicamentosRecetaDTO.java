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
    private MedicamentoDTO medicamento;
    private RecetaDTO receta;

    public MedicamentosRecetaDTO() {
    }

    public MedicamentosRecetaDTO(int cantidad, MedicamentoDTO medicamento, RecetaDTO receta) {
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.receta = receta;
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

    public RecetaDTO getReceta() {
        return receta;
    }

    public void setReceta(RecetaDTO receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.medicamento);
        hash = 47 * hash + Objects.hashCode(this.receta);
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
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return Objects.equals(this.receta, other.receta);
    }

    @Override
    public String toString() {
        return "MedicamentosRecetaDTO{" + "cantidad=" + cantidad + ", medicamento=" + medicamento + ", receta=" + receta + '}';
    }
}
