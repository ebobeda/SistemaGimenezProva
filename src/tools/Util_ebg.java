/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author u08004655122
 */
public class Util_ebg {

    public static void habilitar(boolean valor, JComponent... vetComp) { //tem static ra nâo precisas instanciar, este laço percorre todos os itens do vetor vetcomp
        for (int i = 0; i < vetComp.length; i++) { //esse for é pra pegar varios componentes
            vetComp[i].setEnabled(valor);
        }
    }

    public static void limparCampos(JComponent... vetComp) { //limpar campos é polimorffismo
        for (JComponent componente : vetComp) {
            if (componente instanceof JTextField) { //if pergunta se alguma vez ele já foi textfield
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) { //if pergunta se alguma vez ele já foi textfield
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JCheckBox) { //if pergunta se alguma vez ele já foi textfield
                ((JCheckBox) componente).setSelected(false);
                //     JTextField objeto = (JTextField) componente;//criou um novo objeto e atribui ao objeto se ja tiver sido textfield
                //      objeto.setText(""); //cast pegando o component e transformando em textfield
            }

        }
    }
    
    public static void mensagem(String cadeia) {
        JOptionPane.showMessageDialog(null, cadeia); //usa o parâmetro cadeia para a mensagem vir de onde o método foi chamado "exclusao cancelada"
    }
    
    public static boolean perguntar(String cadeia) {
        
        JOptionPane.showConfirmDialog(null, cadeia,
        "Perguntar", JOptionPane.YES_NO_OPTION); //passa a pergunta que quer aqui
        int resp = JOptionPane.showConfirmDialog(null, "Confirmar excluir?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
         return true;
        } else {
        return false;
        }   
    }
    
    public static int strInt(String  cad) { //str é pegar string e transformar em inteiro
            return Integer.parseInt(cad);
    }
    
    public static String intStr(int num){
        return Integer.toString(num);
    }
    
    public static double strDouble(String cad){
        return Double.parseDouble(cad);
    }
    
    public static String doubleStr(double num){
     return Double.toString(num);
    }
    
    public static Date strDate(String cad)throws ParseException{
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.parse(cad);
    
    }
    
    public static String dateStr(Date date){
        SimpleDateFormat formataNascimento = new SimpleDateFormat("dd/MM/yyyy");
        return formataNascimento.format(date);
    }
}
