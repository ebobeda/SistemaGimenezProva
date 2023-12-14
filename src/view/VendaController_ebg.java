/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.VendaEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estefan
 */
public class VendaController_ebg extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public VendaEbg getBean(int linha) {
        return (VendaEbg) lista.get(linha);
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
        VendaEbg venda = (VendaEbg) lista.get(rowIndex);
        if (columnIndex == 0) {
            return venda.getIdvendaEbg();
        }
        if (columnIndex == 1) {
            return venda.getClienteEbg();
        }
        if (columnIndex == 2) {
            return venda.getVendedorEbg();
        }
        if (columnIndex == 3) {
            return venda.getDataEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Id";
        }
        if (columnIndex == 1) {
            return "Cliente";
        }
        if (columnIndex == 2) {
            return "Vendedor";
        }
        if (columnIndex == 3) {
            return "Data";
        }
        return "";
    }
}
