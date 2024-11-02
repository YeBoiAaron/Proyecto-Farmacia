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
@DiscriminatorValue("Cajero")
public class Cajero extends Empleado implements Serializable {

    @OneToMany(mappedBy = "cajero", cascade = CascadeType.PERSIST)
    private List<Venta> ventas;

    public Cajero() {
    }

    public Cajero(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, nombreUsuario, correo, contrasena);
    }

    public Cajero(List<Venta> ventas, String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, nombreUsuario, correo, contrasena);
        this.ventas = ventas;
    }

    public Cajero(List<Venta> ventas, String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, idUsuario, nombreUsuario, correo, contrasena);
        this.ventas = ventas;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(super.getIdUsuario());
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
        final Cajero other = (Cajero) obj;
        return Objects.equals(super.getIdUsuario(), other.getIdUsuario());
    }

    @Override
    public String toString() {
        return "Cajero{" + "ventas=" + ventas + '}';
    }
}
