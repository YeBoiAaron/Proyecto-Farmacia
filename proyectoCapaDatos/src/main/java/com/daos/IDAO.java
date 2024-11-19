/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IDAO<T> {

    T obtenerPorId(Long id);

    T agregar(T entity);

    T actualizar(T entity);

    void eliminar(T entity);

    List<T> lista();

}
