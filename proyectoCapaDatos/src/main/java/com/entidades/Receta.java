/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Long idReceta;
    @Column(name = "numero_receta", unique = true)
    private String numeroReceta;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "receta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<MedicamentosReceta> listaMedicamentos;

    public Receta() {
    }

    public Receta(String numeroReceta, String diagnostico, String estado) {
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.estado = estado;
    }

    public Receta(Long idReceta, String numeroReceta, String diagnostico, String estado, Venta venta, Medico medico, Paciente paciente, List<MedicamentosReceta> medicamentos) {
        this.idReceta = idReceta;
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.estado = estado;
        this.venta = venta;
        this.medico = medico;
        this.paciente = paciente;
        this.listaMedicamentos = medicamentos;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public String getNumeroReceta() {
        return numeroReceta;
    }

    public void setNumeroReceta(String numeroReceta) {
        this.numeroReceta = numeroReceta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<MedicamentosReceta> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<MedicamentosReceta> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idReceta);
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
        final Receta other = (Receta) obj;
        return Objects.equals(this.idReceta, other.idReceta);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
