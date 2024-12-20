/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "medicos")
public class Medico extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Column(name = "cedula_profesional", unique = true)
    private String cedulaProfesional;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Receta> recetas;

    public Medico() {
    }

    public Medico(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Medico(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Medico(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento, List<Receta> recetas, Long idMedico, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.idMedico = idMedico;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
        this.recetas = recetas;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
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

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idMedico);
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
        final Medico other = (Medico) obj;
        return Objects.equals(this.idMedico, other.getIdMedico());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
