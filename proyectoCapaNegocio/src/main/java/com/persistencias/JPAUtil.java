/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import javax.persistence.*;

/**
 *
 * @author Aaron
 */
public class JPAUtil {
    
    private static final String PERSISTENCE_UNIT_NAME = "Farmacia_PU";
    private static EntityManagerFactory emf;

    private JPAUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf != null
                ? emf 
                : (emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
