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
@DiscriminatorValue("Gerente")
public class Gerente extends Empleado implements Serializable {
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
    private Sucursal sucursal;

    public Gerente() {
    }

    public Gerente(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Gerente(String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
    }

    public Gerente(Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(idUsuario, nombreUsuario, correo, contrasena);
    }

    public Gerente(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento);
    }

    public Gerente(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, nombreUsuario, correo, contrasena);
    }

    public Gerente(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, idUsuario, nombreUsuario, correo, contrasena);
    }

    public Gerente(Sucursal sucursal, String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento);
        this.sucursal = sucursal;
    }

    public Gerente(Sucursal sucursal, String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, nombreUsuario, correo, contrasena);
        this.sucursal = sucursal;
    }

    public Gerente(Sucursal sucursal, String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, Long idUsuario, String nombreUsuario, String correo, String contrasena) {
        super(nombreCompleto, numeroTelefono, fechaNacimiento, idUsuario, nombreUsuario, correo, contrasena);
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.sucursal);
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
        final Gerente other = (Gerente) obj;
        return Objects.equals(super.getIdUsuario(), other.getIdUsuario());
    }
}
