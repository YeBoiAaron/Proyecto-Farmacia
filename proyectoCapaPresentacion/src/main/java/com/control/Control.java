/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Aaron
 */
public class Control {
    public void validarFormulario(JFrame frame) throws IllegalArgumentException{
        for (Component component : frame.getContentPane().getComponents()) {
            if(component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if(textField.getText().trim().isEmpty()) {
                    throw new IllegalArgumentException("Es obligatorio llenar todos los campos de texto");
                }
            }

            if(component instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) component;
                if(datePicker.getDate() == null) {
                    throw new IllegalArgumentException("Es obligatorio elegir una fecha");
                }
            }
        }
    }
    
    public void validarComponentes(Object[] componentes) throws IllegalArgumentException{
        for (Object componente : componentes) {
            if(componente instanceof JTextField) {
                JTextField textField = (JTextField) componente;
                if(textField.getText().trim().isEmpty()) {
                    throw new IllegalArgumentException("Es obligatorio llenar todos los campos de texto");
                }
            }

            if(componente instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) componente;
                if(datePicker.getDate() == null) {
                    throw new IllegalArgumentException("Es obligatorio elegir una fecha");
                }
            }
        }
    }
}
