/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.dtos.PacienteDTO;
import com.persistencias.PacientePersistencia;
import com.servicios.ConversionesTablas;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Aaron
 */
public class RecetaControl {
    private PacientePersistencia pctPersistencia;
    private ConversionesTablas convers;
    
    public RecetaControl() {
        pctPersistencia = new PacientePersistencia();
        convers = new ConversionesTablas();
    }
    
    public PacienteDTO buscarPaciente(JFrame parent, String nombrePaciente) {
        if(nombrePaciente.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Ingresa el nombre del paciente a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            List<PacienteDTO> rsltBusquedaPaciente = pctPersistencia.buscarPaciente(nombrePaciente);
            if(!rsltBusquedaPaciente.isEmpty()) {
                PacienteDTO paciente;
                JOptionPane.showMessageDialog(null, "Existen paciente(s) bajo ese nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                JTable tblPacientes = new JTable(convers.listaPacientesToTableModel(rsltBusquedaPaciente));
                tblPacientes.setRowSelectionAllowed(true);
                
                Object[] opciones = {
                    "Seleccionar paciente",
                    "Crear nuevo",
                    "Cancelar"};
                
                int respuesta = JOptionPane.showOptionDialog(
                        parent,
                        tblPacientes,
                        "Selecciona un paciente",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );
                
                if(respuesta == JOptionPane.YES_OPTION && tblPacientes.getSelectedRow() != -1) {
                    paciente = pctPersistencia.buscarPorCorreo((String) tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 2));
                    return paciente;
                } else if(respuesta == JOptionPane.NO_OPTION) {
                    return crearNuevoPaciente(parent, nombrePaciente);
                }
            } else {
                return crearNuevoPaciente(parent, nombrePaciente);
            }
        }
        return null;
    }
    
    public PacienteDTO crearNuevoPaciente(JFrame parent, String nombrePaciente) {
        PacienteDTO paciente = new PacienteDTO();
        JTextField txfNombreCompleto = new JTextField(nombrePaciente);
        com.github.lgooddatepicker.components.DatePicker dtfFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        JTextField txfNumeroTelefono = new JTextField();
        JTextField txfCorreo = new JTextField();
        JTextField txfSexo = new JTextField();
        JTextField txfAltura = new JTextField();
        JTextField txfPeso = new JTextField();
        Object[] mensaje = {
            "Nombre Completo:", txfNombreCompleto,
            "Fecha de Nacimiento", dtfFechaNacimiento,
            "Número de teléfono:", txfNumeroTelefono,
            "Correo electrónico:", txfCorreo,
            "Sexo:", txfSexo,
            "Altura (cm):", txfAltura,
            "Peso (kg):", txfPeso,};

        int respuesta = JOptionPane.showConfirmDialog(
                parent,
                mensaje,
                "Ingresa los datos del paciente",
                JOptionPane.OK_CANCEL_OPTION
        );

        if(respuesta == JOptionPane.OK_OPTION) {
            try {
                float altura = Float.parseFloat(txfAltura.getText().trim());
                float peso = Float.parseFloat(txfPeso.getText().trim());
                LocalDate fechaNacimiento = dtfFechaNacimiento.getDate();
                if(fechaNacimiento.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("Debe ingresar una fecha válida");
                }

                paciente.setNombreCompleto(txfNombreCompleto.getText().trim());
                paciente.setFechaNacimiento(fechaNacimiento);
                paciente.setCorreo(txfCorreo.getText().trim());
                paciente.setNumeroTelefono(txfNumeroTelefono.getText().trim());
                paciente.setSexo(txfSexo.getText().trim());
                paciente.setAltura(altura);
                paciente.setPeso(peso);
                paciente.setEdad((int) ChronoUnit.YEARS.between(paciente.getFechaNacimiento(), LocalDate.now()));
                
                pctPersistencia.crearPaciente(paciente);
                return paciente;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "La altura y peso deben ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(IllegalArgumentException e) {
                JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return null;
    }
}