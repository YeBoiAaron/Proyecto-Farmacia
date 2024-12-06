/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicios;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;

import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Aaron
 */
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
    
    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");

        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        
        setSize(table.getColumnModel().getColumn(column).getWidth(), Integer.MAX_VALUE);

        int rowHeight = getPreferredSize().height;
        if (table.getRowHeight(row) != rowHeight) {
            table.setRowHeight(row, rowHeight);
        }

        return this;
    }
}
