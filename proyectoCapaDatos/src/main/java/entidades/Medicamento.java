/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name="medicamentos")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;
    private String nombre;
    private String presentacion;
    private String concentracion;
    private String activo;
    private float precio;
    
    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.PERSIST)
    private List<MedicamentosReceta> recetas;
    
    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.PERSIST)
    private List<InventarioSucursal> inventarios;

    public Medicamento() {
    }

    public Medicamento(String nombre, String presentacion, String concentracion, String activo, float precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.concentracion = concentracion;
        this.activo = activo;
        this.precio = precio;
    }

    public Medicamento(Long idMedicamento, String nombre, String presentacion, String concentracion, String activo, float precio, List<MedicamentosReceta> recetas, List<InventarioSucursal> inventarios) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.concentracion = concentracion;
        this.activo = activo;
        this.precio = precio;
        this.recetas = recetas;
        this.inventarios = inventarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idMedicamento fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + idMedicamento + ", nombre=" + nombre + ", presentacion=" + presentacion + ", concentracion=" + concentracion + ", activo=" + activo + ", precio=" + precio + ", recetas=" + recetas + ", inventarios=" + inventarios + '}';
    }
    
}
