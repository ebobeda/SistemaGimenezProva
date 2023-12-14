/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.UsuarioEbg;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08004655122
 */
public class UsuarioController_ebg extends AbstractTableModel {
    private List lista;  //é preciso ter linhas clunas e conteúdo para montar o jtable da tela de compra e venda
    //dentro do usuariocrontrole nao tem o metodo lista entao eu crio ele aqui
    
    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public UsuarioEbg getBean(int linha) {
        return (UsuarioEbg) lista.get(linha);
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
        UsuarioEbg usuarios = (UsuarioEbg) lista.get(rowIndex);
        if (columnIndex == 0) { //values get e set vem dessa lista verde de cima
            return usuarios.getIdusuarioEbg();
        }
        if (columnIndex == 1) {
            return usuarios.getNomeEbg();
        }
        if (columnIndex == 2) {
            return usuarios.getApelidoEbg();
        }
        if (columnIndex == 3) {
            return usuarios.getCpfEbg();
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
            return "Apelido";
        }
        if (columnIndex == 3) {
            return "Cpf";
        }
        return ""; //precisa do return caso tenha algo difeente das psoições 0,1,2 e 3 pq se nao da inonsistencia
    }
}
