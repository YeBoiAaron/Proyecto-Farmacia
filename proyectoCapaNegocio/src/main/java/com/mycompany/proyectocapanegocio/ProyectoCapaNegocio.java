/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectocapanegocio;

import com.daos.implementaciones.MedicamentoDAO;
import com.daos.implementaciones.MedicoDAO;
import com.daos.interfaces.IMedicamentoDAO;
import com.daos.interfaces.IMedicoDAO;
import com.dtos.MedicamentoDTO;
import com.dtos.MedicamentosRecetaDTO;
import com.dtos.MedicoDTO;
import com.dtos.PacienteDTO;
import com.dtos.RecetaDTO;
import com.mappers.MedicamentoMapper;
import com.mappers.MedicoMapper;
import com.persistencias.JPAUtil;
import com.persistencias.RecetaPersistencia;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class ProyectoCapaNegocio {

    public static void main(MedicamentoDTO[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        
        IMedicamentoDAO mDAO = new MedicamentoDAO(em);
        IMedicoDAO mdDAO = new MedicoDAO(em);
        
        MedicamentoDTO m1 = new MedicamentoDTO("Paracetamol", "123456789", "Tabletas", "600mg", "Paracetamol", 60.00f);
        MedicamentoDTO m2 = new MedicamentoDTO("Xanax", "987654321", "Capsulas", "1mg", "Alprazolam", 200.00f);
        PacienteDTO p1 = new PacienteDTO("Juan Perez", LocalDate.parse("1987-11-24"), "1234567890", "jp@gmail.com", "M", 172.0f, 86.0f, (int)(long)ChronoUnit.YEARS.between(LocalDate.parse("1987-11-24"),LocalDate.now()));
        MedicoDTO md1 = new MedicoDTO("Juan Mendez", "0123456789", "123456789a", LocalDate.parse("1976-03-13"));
        RecetaDTO r1 = new RecetaDTO("123456789a", "Dolor de cabeza", "1 tableta paracetamol 600mg c/8h", "sin surtir");
        
        List<MedicamentosRecetaDTO> mr1 = new ArrayList<>();
        
        mr1.add(new MedicamentosRecetaDTO(1, m2.getNumeroSerie(), r1.getNumeroReceta()));
        mr1.add(new MedicamentosRecetaDTO(2, m1.getNumeroSerie(), r1.getNumeroReceta()));
        
        RecetaPersistencia rp = new RecetaPersistencia();
        try{
            mDAO.agregar(MedicamentoMapper.toEntity(m2));
            mDAO.agregar(MedicamentoMapper.toEntity(m1));
            mdDAO.agregar(MedicoMapper.toEntity(md1));
            rp.crearReceta(r1, mr1, md1, p1);
            System.out.println("Operacion realizada");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Operacion fallida");
        }
    }
}
