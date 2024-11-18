/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String numeroTelefono;
    private String correo;
    private String sexo;
    private float altura;
    private float peso;
    private int edad;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Receta> listaRecetas;

    public Paciente() {
    }

    public Paciente(String nombreCompleto, LocalDate fechaNacimiento, String numeroTelefono, String correo, String sexo, float altura, float peso, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
    }

    public Paciente(Long idPaciente, String nombreCompleto, LocalDate fechaNacimiento, String numeroTelefono, String correo, String sexo, float altura, float peso, int edad, List<Receta> recetas) {
        this.idPaciente = idPaciente;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.listaRecetas = recetas;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
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

    public List<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(List<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idPaciente fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", numeroTelefono=" + numeroTelefono + ", correo=" + correo + ", sexo=" + sexo + ", peso=" + peso + ", edad=" + edad + ", recetas=" + listaRecetas + '}';
    }

}
