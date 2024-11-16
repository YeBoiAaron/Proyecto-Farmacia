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
public class MedicoDTO {
    private String nombreCompleto;
    private String numeroTelefono;
    private String cedulaProfesional;
    private LocalDate fechaNacimiento;

    public MedicoDTO() {
    }

    public MedicoDTO(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.cedulaProfesional);
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
        final MedicoDTO other = (MedicoDTO) obj;
        return Objects.equals(this.cedulaProfesional, other.cedulaProfesional);
    }

    @Override
    public String toString() {
        return "MedicoDTO{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefono=" + numeroTelefono + ", cedulaProfesional=" + cedulaProfesional + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}
