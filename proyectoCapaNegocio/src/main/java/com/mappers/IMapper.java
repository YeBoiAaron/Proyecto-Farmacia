/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mappers;

/**
 *
 * @author Aaron
 */
public interface IMapper<S,T> {
    T toDTO(S obj);
    S toEntity(T obj);
}
