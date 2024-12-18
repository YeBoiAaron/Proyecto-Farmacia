/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "medicamentos_recetas")
public class MedicamentosReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamentos_receta")
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "instrucciones")
    private String instrucciones;

    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_receta")
    private Receta receta;

    public MedicamentosReceta() {
    }

    public MedicamentosReceta(int cantidad, String instrucciones, Medicamento medicamento, Receta receta) {
        this.cantidad = cantidad;
        this.instrucciones = instrucciones;
        this.medicamento = medicamento;
        this.receta = receta;
    }

    public MedicamentosReceta(Long id, int cantidad, String instrucciones, Medicamento medicamento, Receta receta) {
        this.id = id;
        this.cantidad = cantidad;
        this.instrucciones = instrucciones;
        this.medicamento = medicamento;
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosReceta)) {
            return false;
        }
        MedicamentosReceta other = (MedicamentosReceta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
