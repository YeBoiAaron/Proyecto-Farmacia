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
@Table(name = "empleados")
public class Empleado extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "tipo_empleado")
    private String tipoEmpleado;
    
    @OneToMany(mappedBy = "cajero", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Venta> ventas;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    public Empleado() {
    }

    public Empleado(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String tipoEmpleado) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String tipoEmpleado, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado(String nombreCompleto, String numeroTelefono, LocalDate fechaNacimiento, String tipoEmpleado, List<Venta> ventas, Sucursal sucursal, Long idEmpleado, String nombreUsuario, String correo, String contrasena) {
        super(nombreUsuario, correo, contrasena);
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipoEmpleado;
        this.ventas = ventas;
        this.sucursal = sucursal;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
        return Objects.equals(this.idEmpleado, other.getIdEmpleado());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
