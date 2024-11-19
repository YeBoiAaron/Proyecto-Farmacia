/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "inventarios_sucursales")
public class InventarioSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inventario")
    private Long idInventario;
    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    public InventarioSucursal() {
    }

    public InventarioSucursal(int cantidad, Medicamento medicamento, Sucursal sucursal) {
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.sucursal = sucursal;
    }

    public InventarioSucursal(Long idInventario, int cantidad, Medicamento medicamento, Sucursal sucursal) {
        this.idInventario = idInventario;
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.sucursal = sucursal;
    }

    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idInventario fields are not set
        if (!(object instanceof InventarioSucursal)) {
            return false;
        }
        InventarioSucursal other = (InventarioSucursal) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventarioSucursal{" + "idInventario=" + idInventario + ", cantidad=" + cantidad + ", medicamento=" + medicamento + ", sucursal=" + sucursal + '}';
    }

}
