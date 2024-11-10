/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class PacienteDTO {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String numeroTelefono;
    private String correo;
    private String sexo;
    private float peso;
    private int edad;
    private List<RecetaDTO> listaRecetas;

    public PacienteDTO() {
    }

    public PacienteDTO(String nombreCompleto, LocalDate fechaNacimiento, String numeroTelefono, String correo, String sexo, float peso, int edad, List<RecetaDTO> listaRecetas) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.listaRecetas = listaRecetas;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<RecetaDTO> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(List<RecetaDTO> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombreCompleto);
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
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
        final PacienteDTO other = (PacienteDTO) obj;
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public String toString() {
        return "PacienteDTO{" + "nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", numeroTelefono=" + numeroTelefono + ", correo=" + correo + ", sexo=" + sexo + ", peso=" + peso + ", edad=" + edad + ", listaRecetas=" + listaRecetas + '}';
    }
}
