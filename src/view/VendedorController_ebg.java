/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.VendedorEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08004655122
 */
public class VendedorController_ebg extends AbstractTableModel{
    List lista;
    
    public void setList(List lista){
    this.lista = lista;
    this.fireTableDataChanged();
    };
    public VendedorEbg getBean(int row){
    return (VendedorEbg)lista.get(row);
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
        VendedorEbg vendedorEbg = (VendedorEbg) lista.get(rowIndex);
        if (columnIndex == 0){ //values get e set vem dessa lista verde de cima
        return vendedorEbg.getIdvendedorEbg();
        }
        if (columnIndex == 1){
        return vendedorEbg.getNomeEbg();
        }
        if (columnIndex == 2){
        return vendedorEbg.getCpfEbg();
        }
        if (columnIndex == 3){
        return vendedorEbg.getDataexpedienteEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "nome";
        }
        if (column == 2){
        return "cpf";
        }
        if (column == 3){
        return "data de expediente";
        }
               
        return ""; //precisa do return caso tenha algo difeente das psoições 0,1,2 e 3 pq se nao da inonsistencia
    };
}
