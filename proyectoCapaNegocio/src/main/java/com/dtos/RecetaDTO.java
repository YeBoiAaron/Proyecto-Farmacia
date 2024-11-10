/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtos;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aaron
 */
public class RecetaDTO {
    private String numeroReceta;
    private String diagnostico;
    private String instrucciones;
    private String estado;
    private VentaDTO venta;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    private List<MedicamentoDTO> listaMedicamentos;

    public RecetaDTO() {
    }

    public RecetaDTO(String numeroReceta, String diagnostico, String instrucciones, String estado, VentaDTO venta, MedicoDTO medico, PacienteDTO paciente, List<MedicamentoDTO> listaMedicamentos) {
        this.numeroReceta = numeroReceta;
        this.diagnostico = diagnostico;
        this.instrucciones = instrucciones;
        this.estado = estado;
        this.venta = venta;
        this.medico = medico;
        this.paciente = paciente;
        this.listaMedicamentos = listaMedicamentos;
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

    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }

    public MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public List<MedicamentoDTO> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(List<MedicamentoDTO> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.numeroReceta);
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
        final RecetaDTO other = (RecetaDTO) obj;
        return Objects.equals(this.numeroReceta, other.numeroReceta);
    }

    @Override
    public String toString() {
        return "RecetaDTO{" + "numeroReceta=" + numeroReceta + ", diagnostico=" + diagnostico + ", instrucciones=" + instrucciones + ", estado=" + estado + ", venta=" + venta + ", medico=" + medico + ", paciente=" + paciente + ", listaMedicamentos=" + listaMedicamentos + '}';
    }
}
