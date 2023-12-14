/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ProdutoEbg;
import bean.VendaprodutoEbg;
import dao.Produto_DAO;
import dao.Venda_DAO;
import java.util.List;
import tools.Util_ebg;

/**
 *
 * @author u08004655122
 */
public class JDlgVendaproduto_ebg extends javax.swing.JDialog {
         Produto_DAO produto_DAO;
         JDlgVenda_ebg jDlgVenda_ebg;
         Venda_DAO venda_DAO;
         JDlgVendaproduto_ebg jDlgVendaproduto_ebg;
         VendaprodutoController_ebg vendaprodutoController_ebg;
    /**
     * Creates new form JDlgVendaproduto_ebg
     */
    public JDlgVendaproduto_ebg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        produto_DAO = new Produto_DAO();
        
        Produto_DAO produto_DAO = new Produto_DAO();
        List listaProd = produto_DAO.listAll();
        for (int i = 0; i < listaProd.size(); i++) {
           jCboProduto_ebg.addItem((ProdutoEbg) listaProd.get(i));
        }
    }
         public void setTelaAnterior(JDlgVenda_ebg jDlgVenda_ebg) {
        this.jDlgVenda_ebg = jDlgVenda_ebg;
    }
         
         public VendaprodutoEbg beanView(VendaprodutoEbg VendaprodutoEbg) {
        jCboProduto_ebg.setSelectedItem(VendaprodutoEbg.getProdutoEbg());
        jTxtQuantidade_ebg.setText(Integer.toString(VendaprodutoEbg.getQuantidadeEbg()));
        jTxtValorunit_ebg.setText(Double.toString(VendaprodutoEbg.getValorunitEbg()));
        return VendaprodutoEbg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnCancelar_ebg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCboProduto_ebg = new javax.swing.JComboBox<Produto>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtQuantidade_ebg = new javax.swing.JTextField();
        jTxtValorunit_ebg = new javax.swing.JTextField();
        jTxtTotal_ebg = new javax.swing.JTextField();
        jBtnConfirmar_ebg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnCancelar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/03 - exit.png"))); // NOI18N
        jBtnCancelar_ebg.setText("Cancelar");
        jBtnCancelar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelar_ebgActionPerformed(evt);
            }
        });

        jLabel1.setText("Produto");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Valor unitario");

        jLabel4.setText("Total");

        jTxtQuantidade_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtQuantidade_ebgActionPerformed(evt);
            }
        });

        jTxtValorunit_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtValorunit_ebgActionPerformed(evt);
            }
        });

        jBtnConfirmar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/05 - ok.png"))); // NOI18N
        jBtnConfirmar_ebg.setText("Confirmar");
        jBtnConfirmar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmar_ebgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jTxtQuantidade_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jTxtValorunit_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jTxtTotal_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jCboProduto_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jBtnConfirmar_ebg)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar_ebg)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCboProduto_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtQuantidade_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValorunit_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnConfirmar_ebg)
                    .addComponent(jBtnCancelar_ebg))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelar_ebgActionPerformed
        // TODO add your handling code here:

        desabilitar();
        setVisible(false);
    }//GEN-LAST:event_jBtnCancelar_ebgActionPerformed

    private void jTxtQuantidade_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtQuantidade_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtQuantidade_ebgActionPerformed

    private void jTxtValorunit_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtValorunit_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtValorunit_ebgActionPerformed

    private void jBtnConfirmar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmar_ebgActionPerformed
        // TODO add your handling code here:
        VendaprodutoEbg vendaprodutoEbg = new VendaprodutoEbg();
        vendaprodutoEbg.setProdutoEbg ((ProdutoEbg) jCboProduto_ebg.getSelectedItem() );
        vendaprodutoEbg.setQuantidadeEbg (Util_ebg.strInt(jTxtQuantidade_ebg.getText()));
        vendaprodutoEbg.setValorunitEbg(Util_ebg.strDouble(jTxtValorunit_ebg.getText()));
        
        if (getTitle().toUpperCase().substring(0, 1).equals("I")) {
            jDlgVenda_ebg.vendaprodutoController_ebg.addBean(vendaprodutoEbg);
        } else{
        jDlgVenda_ebg.vendaprodutoController_ebg.updateBean(jDlgVenda_ebg.getSelectedRowProd(), vendaprodutoEbg);
        }
        setVisible(false);
    }//GEN-LAST:event_jBtnConfirmar_ebgActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgVendaproduto_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendaproduto_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendaproduto_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendaproduto_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendaproduto_ebg dialog = new JDlgVendaproduto_ebg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar_ebg;
    private javax.swing.JButton jBtnConfirmar_ebg;
    private javax.swing.JComboBox<ProdutoEbg> jCboProduto_ebg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtQuantidade_ebg;
    private javax.swing.JTextField jTxtTotal_ebg;
    private javax.swing.JTextField jTxtValorunit_ebg;
    // End of variables declaration//GEN-END:variables
}
