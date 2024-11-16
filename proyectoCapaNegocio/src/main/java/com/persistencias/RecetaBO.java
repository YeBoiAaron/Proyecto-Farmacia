/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencias;

import javax.persistence.EntityManager;

/**
 *
 * @author Aaron
 */
public class RecetaBO {
    private EntityManager em;

    public RecetaBO() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }
    
    
}
