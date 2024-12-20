/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos.interfaces;

import com.daos.IDAO;
import com.entidades.Paciente;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IPacienteDAO extends IDAO<Paciente> {
    public Paciente obtenerPorCorreo(String correo);
    
    public List<Paciente> obtenerPorNombre(String nombrePaciente);
}
