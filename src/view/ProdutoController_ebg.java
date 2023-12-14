/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ProdutoEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estefan
 */
public class ProdutoController_ebg extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public ProdutoEbg getBean(int linha) {
        return (ProdutoEbg) lista.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoEbg produtoEbg = (ProdutoEbg) lista.get(rowIndex);
        if (columnIndex == 0) {
            return produtoEbg.getIdprodutoEbg();
        }
        if (columnIndex == 1) {
            return produtoEbg.getMassaEbg();
        }
        if (columnIndex == 2) {
            return produtoEbg.getTamanhoEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Id";
        }
        if (columnIndex == 1) {
            return "Massa";
        }
        if (columnIndex == 2) {
            return "Tamanho";
        }
        return "";
    }
}
