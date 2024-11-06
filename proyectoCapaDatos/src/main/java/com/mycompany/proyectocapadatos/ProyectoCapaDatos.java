/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectocapadatos;

import com.daos.implementaciones.*;
import com.entidades.*;
import com.daos.interfaces.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;

/**
 *
 * @author Aaron
 */
public class ProyectoCapaDatos {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Farmacia_PU");
        EntityManager em = emf.createEntityManager();
        
        IMedicamentoDAO mDAO = new MedicamentoDAO(em);
        IMedicamentosRecetaDAO mrDAO = new MedicamentosRecetaDAO(em);
        IMedicoDAO mdDAO = new MedicoDAO(em);
        
        Medicamento m1 = new Medicamento("Paracetamol", "Tabletas", "600mg", "Paracetamol", 60.00f);
        Paciente p1 = new Paciente("Juan Perez", LocalDate.parse("1987-11-24"), "1234567890", "jp@gmail.com", "M", 86.0f, (int)(long)ChronoUnit.YEARS.between(LocalDate.parse("1987-11-24"),LocalDate.now()));
        Medico md1 = new Medico("Juan Mendez", "0123456789", "123456789a", LocalDate.parse("1976-03-13"), "jmendez76", "drjuanmendez@hotmail.com", "contraseña");
        Receta r1 = new Receta("123456789a", "Dolor de cabeza", "1 tableta paracetamol 600mg c/8h", "sin surtir");
        
        r1.setMedico(md1);
        r1.setPaciente(p1);
        
        MedicamentosReceta mr1 = new MedicamentosReceta(2, m1, r1);
        
        try{
            mdDAO.agregar(md1);
            mDAO.agregar(m1);
            mrDAO.agregar(mr1);
            System.out.println("Operacion exitosa");
        }catch(PersistenceException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Operacion fallida");
        }
    }
}
