/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "medicamentos")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;
    private String numeroSerie;
    private String nombre;
    private String presentacion;
    private String concentracion;
    private String activo;
    private float precio;

    @OneToMany(mappedBy = "medicamento", fetch = FetchType.LAZY)
    private List<MedicamentosReceta> recetas;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<InventarioSucursal> inventarios;

    public Medicamento() {
    }

    public Medicamento(String nombre, String numeroSerie, String presentacion, String concentracion, String activo, float precio) {
        this.nombre = nombre;
        this.numeroSerie = numeroSerie;
        this.presentacion = presentacion;
        this.concentracion = concentracion;
        this.activo = activo;
        this.precio = precio;
    }

    public Medicamento(Long idMedicamento, String nombre, String numeroSerie, String presentacion, String concentracion, String activo, float precio, List<MedicamentosReceta> recetas, List<InventarioSucursal> inventarios) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.numeroSerie = numeroSerie;
        this.presentacion = presentacion;
        this.concentracion = concentracion;
        this.activo = activo;
        this.precio = precio;
        this.recetas = recetas;
        this.inventarios = inventarios;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
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

    public List<MedicamentosReceta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<MedicamentosReceta> recetas) {
        this.recetas = recetas;
    }

    public List<InventarioSucursal> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<InventarioSucursal> inventarios) {
        this.inventarios = inventarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.numeroSerie);
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
        final Medicamento other = (Medicamento) obj;
        return Objects.equals(this.numeroSerie, other.numeroSerie);
    }

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + idMedicamento + ", nombre=" + nombre + ", numero de serie=" + numeroSerie + ", presentacion=" + presentacion + ", concentracion=" + concentracion + ", activo=" + activo + ", precio=" + precio + ", recetas=" + recetas + ", inventarios=" + inventarios + '}';
    }

}
