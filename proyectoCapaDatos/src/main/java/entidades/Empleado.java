/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEmpleado")
@DiscriminatorValue("Empleado")
@Table(name = "empleados")
public class Empleado extends Usuario implements Serializable {

    private String nombreCompleto;
    private String numeroTelefono;
    private LocalDate fechaNacimiento;

    public Empleado() {
    }

    public Empleado(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(idUsuario, nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nombreCompleto);
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
        final Empleado other = (Empleado) obj;
        return Objects.equals(super.getIdUsuario(), other.getIdUsuario());
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombreCompleto=" + nombreCompleto + ", numeroTelefono=" + numeroTelefono + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}
