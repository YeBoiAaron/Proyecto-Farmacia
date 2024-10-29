/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name="recetas")
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;
    private String numeroReceta;
    private String diagnostico;
    private String instrucciones;
    private String estado;
    
    @OneToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    private Venta venta;
    
    @ManyToOne
    private Medico medico;
    
    @ManyToOne
    private Paciente paciente;
    
    @OneToMany(mappedBy = "receta")
    private List<MedicamentosReceta> medicamentos;

    public Receta() {
    }

    public Receta(String numeroReceta, String diagnostico, String instrucciones, String estado) {
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.instrucciones = instrucciones;
        this.estado = estado;
    }

    public Receta(String numeroReceta, String diagnostico, String instrucciones, String estado, Venta venta, Medico medico, Paciente paciente, List<MedicamentosReceta> medicamentos) {
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.instrucciones = instrucciones;
        this.estado = estado;
        this.venta = venta;
        this.medico = medico;
        this.paciente = paciente;
        this.medicamentos = medicamentos;
    }

    public Receta(Long idReceta, String numeroReceta, String diagnostico, String instrucciones, String estado, Venta venta, Medico medico, Paciente paciente, List<MedicamentosReceta> medicamentos) {
        this.idReceta = idReceta;
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.instrucciones = instrucciones;
        this.estado = estado;
        this.venta = venta;
        this.medico = medico;
        this.paciente = paciente;
        this.medicamentos = medicamentos;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public String getNumeroReceta() {
        return numeroReceta;
    }

    public void setNumeroReceta(String numeroReceta) {
        this.numeroReceta = numeroReceta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<MedicamentosReceta> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentosReceta> medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idReceta);
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
        final Receta other = (Receta) obj;
        return Objects.equals(this.idReceta, other.idReceta);
    }
    
}
