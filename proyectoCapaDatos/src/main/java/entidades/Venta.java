/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private String folio;
    private float subtotal;
    private float total;
    private LocalDate fecha;
    
    @ManyToOne
    private Cajero cajero;
    
    @OneToOne
    @JoinColumn(name = "idReceta", referencedColumnName = "idReceta")
    private Receta receta;

    public Venta() {
    }

    public Venta(String folio, float subtotal, float total, LocalDate fecha) {
        this.folio = folio;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
    }

    public Venta(String folio, float subtotal, float total, LocalDate fecha, Cajero cajero, Receta receta) {
        this.folio = folio;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
        this.cajero = cajero;
        this.receta = receta;
    }

    public Venta(Long idVenta, String folio, float subtotal, float total, LocalDate fecha, Cajero cajero, Receta receta) {
        this.idVenta = idVenta;
        this.folio = folio;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
        this.cajero = cajero;
        this.receta = receta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idVenta fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", folio=" + folio + ", subtotal=" + subtotal + ", total=" + total + ", fecha=" + fecha + ", cajero=" + cajero + ", receta=" + receta + '}';
    }
    
}
