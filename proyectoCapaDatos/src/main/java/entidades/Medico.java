/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@DiscriminatorValue("Medico")
@Table(name="medicos")
public class Medico extends Usuario implements Serializable {
    
    private String nombreCompleto;
    private String numeroTelefono;
    private String cedulaProfesional;
    private LocalDate fechaNacimiento;
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.PERSIST)
    private List<Receta> recetas;

    public Medico() {
    }
    
    public Medico(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Medico(String nombreCompleto, String numeroTelefono, String cedulaProfesional, LocalDate fechaNacimiento, List<Receta> recetas, Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(idUsuario, nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.cedulaProfesional = cedulaProfesional;
        this.fechaNacimiento = fechaNacimiento;
        this.recetas = recetas;
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
        hash = 79 * hash + Objects.hashCode(this.getIdUsuario());
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
        return Objects.equals(super.getIdUsuario(), other.getIdUsuario());
    }

    @Override
    public String toString() {
        return "Medico{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefono=" + numeroTelefono + ", cedulaProfesional=" + cedulaProfesional + ", fechaNacimiento=" + fechaNacimiento + ", recetas=" + recetas + '}';
    }
    
}
