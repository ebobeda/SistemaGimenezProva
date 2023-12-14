/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.VendaprodutoEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estefan
 */
public class VendaprodutoController_ebg extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public VendaprodutoEbg getBean(int linha) {
        return (VendaprodutoEbg) lista.get(linha);
    }
    
    public void addBean(VendaprodutoEbg vendaprodutoEbg) {
            lista.add(vendaprodutoEbg);
            this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
            lista.remove(index);
            this.fireTableDataChanged();
    }
    
    public void updateBean(int index, VendaprodutoEbg vendaprodutoEbg){
        lista.set(index, vendaprodutoEbg);
        this.fireTableDataChanged();
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
        VendaprodutoEbg venda = (VendaprodutoEbg) lista.get(rowIndex);
        if (columnIndex == 0) {
            return venda.getIdvendaprodutoEbg();
        }
        if (columnIndex == 1) {
            return venda.getProdutoEbg();
        }
        if (columnIndex == 2) {
            return venda.getQuantidadeEbg();
        }
        if (columnIndex == 3) {
            return venda.getValorunitEbg();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Id";
        }
        if (columnIndex == 1) {
            return "Produto";
        }
        if (columnIndex == 2) {
            return "Quantidade";
        }
        if (columnIndex == 3) {
            return "Valorunit";
        }
        return "";
    }
}
