/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estefan
 */
public class ClienteController_ebg extends AbstractTableModel {
    private List lista;
    
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public ClienteEbg getBean(int linha) {
        return (ClienteEbg) lista.get(linha);
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
        ClienteEbg clienteEbg = (ClienteEbg) lista.get(rowIndex);
        if (columnIndex == 0) {
            return clienteEbg.getIdclienteEbg();
        }
        if (columnIndex == 1) {
            return clienteEbg.getNomeEbg();
        }
        if (columnIndex == 2) {
            return clienteEbg.getCepEbg();
        }
        if (columnIndex == 3) {
            return clienteEbg.getEmailEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Id";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Cep";
        }
        if (columnIndex == 3) {
            return "Email";
        }
        return "";
    }
}
