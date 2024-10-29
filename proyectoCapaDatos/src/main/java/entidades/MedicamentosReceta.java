/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "medicamentosReceta")
public class MedicamentosReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "idMedicamento")
    private Medicamento medicamento;
    
    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta receta;

    public MedicamentosReceta() {
    }

    public MedicamentosReceta(int cantidad, Medicamento medicamento, Receta receta) {
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.receta = receta;
    }

    public MedicamentosReceta(Long id, int cantidad, Medicamento medicamento, Receta receta) {
        this.id = id;
        this.cantidad = cantidad;
        this.medicamento = medicamento;
        this.receta = receta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosReceta)) {
            return false;
        }
        MedicamentosReceta other = (MedicamentosReceta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicamentosReceta{" + "id=" + id + ", cantidad=" + cantidad + ", medicamento=" + medicamento + ", receta=" + receta + '}';
    }
    
}
