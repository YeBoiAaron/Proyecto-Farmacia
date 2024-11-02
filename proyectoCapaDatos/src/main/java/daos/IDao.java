/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IDao<T> {

    T obtener(Long id);

    T agregar(T entity);

    T actualizar(T entity);

    void Eliminar(T entity);

    List<T> lista();

}
