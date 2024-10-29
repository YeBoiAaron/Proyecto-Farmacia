/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name="sucursales")
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;
    private String calle;
    private String numero;
    private String colonia;
    private int codigoPostal;
    
    @OneToOne(mappedBy = "sucursal")
    private Gerente gerente;
    
    @OneToMany(mappedBy = "sucursal")
    private InventarioSucursal inventario;

    public Sucursal() {
    }

    public Sucursal(String calle, String numero, String colonia, int codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Sucursal(String calle, String numero, String colonia, int codigoPostal, Gerente gerente, InventarioSucursal inventario) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.gerente = gerente;
        this.inventario = inventario;
    }

    public Sucursal(Long idSucursal, String calle, String numero, String colonia, int codigoPostal, Gerente gerente, InventarioSucursal inventario) {
        this.idSucursal = idSucursal;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.gerente = gerente;
        this.inventario = inventario;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public InventarioSucursal getInventario() {
        return inventario;
    }

    public void setInventario(InventarioSucursal inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idSucursal);
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
        final Sucursal other = (Sucursal) obj;
        return Objects.equals(this.idSucursal, other.idSucursal);
    }

    @Override
    public String toString() {
        return "Sucursal{" + "idSucursal=" + idSucursal + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", gerente=" + gerente + ", inventario=" + inventario + '}';
    }
    
}
