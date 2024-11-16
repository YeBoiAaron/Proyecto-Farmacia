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
public class EmpleadoDTO {
    private String nombreCompleto;
    private String numeroTelefono;
    private LocalDate fechaNacimiento;
    private String tipoEmpleado;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String tipoEmpleado) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombreCompleto);
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
        final EmpleadoDTO other = (EmpleadoDTO) obj;
        return Objects.equals(this.nombreCompleto, other.nombreCompleto);
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefono=" + numeroTelefono + ", fechaNacimiento=" + fechaNacimiento + ", tipoEmpleado=" + tipoEmpleado + '}';
    }
}
