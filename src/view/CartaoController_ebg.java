/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CartaoEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08004655122
 */
public class CartaoController_ebg extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public CartaoEbg getBean(int linha) {
        return (CartaoEbg) lista.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CartaoEbg cartaoEbg = (CartaoEbg) lista.get(rowIndex);
        if (columnIndex == 0) {
            return cartaoEbg.getIdcartaoEbg();
        }
        if (columnIndex == 1) {
            return cartaoEbg.getNomecompletoEbg();
        }
        if (columnIndex == 2) {
            return cartaoEbg.getCscEbg();
        }
        if (columnIndex == 3) {
            return cartaoEbg.getNumerocartaoEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Id";
        }
        if (columnIndex == 1) {
            return "NomeCompleto";
        }
        if (columnIndex == 2) {
            return "Csc";
        }
        if (columnIndex == 3) {
            return "NumeroCartao";
        }
        return "";
    }
}
