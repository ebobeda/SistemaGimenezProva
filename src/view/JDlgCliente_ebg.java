/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteEbg;
import dao.Cliente_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util_ebg;

/**
 *
 * @author user u08004655122
 */
public class JDlgCliente_ebg extends javax.swing.JDialog {
    private boolean incluindo;
    
    private MaskFormatter mascaraCPF, mascaraCelular,mascaraNascimento, mascaraRg, mascaraNumero;
    public ClienteEbg clienteEbg;
    public Cliente_DAO cliente_DAO;

    JDlgCliente_ebg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cliente_DAO = new Cliente_DAO();
        
        Util_ebg.limparCampos(jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);    
        Util_ebg.habilitar(false, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(true, jBtnIncluir_ebg, jBtnPesquisar_ebg);
        
        setTitle("Cadastro de Clientes");
        setLocationRelativeTo(null);
        
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraRg = new MaskFormatter("#.###.###");
            mascaraCelular = new MaskFormatter("(##)####-####");
            mascaraNascimento = new MaskFormatter("##/##/####");
            mascaraNumero = new MaskFormatter("####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente_ebg.class.getName()).log(Level.SEVERE, null, ex);
        }
         jFmtCpf_ebg.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
         jFmtRg_ebg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
         jFmtCelular_ebg.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));
         jFmtNascimento_ebg.setFormatterFactory(new DefaultFormatterFactory(mascaraNascimento));
         jFmtNumero_ebg.setFormatterFactory(new DefaultFormatterFactory(mascaraNumero));
    }
        public ClienteEbg viewBean() {
        ClienteEbg clienteEbg = new ClienteEbg();
        
        clienteEbg.setIdclienteEbg(Util_ebg.strInt(jTxtCodigo_ebg.getText()));
        clienteEbg.setNomeEbg(jTxtNome_ebg.getText());
        clienteEbg.setGeneroEbg(jTxtGenero_ebg.getText());clienteEbg.setProfissaoEbg(jTxtProfissao_ebg.getText());
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            clienteEbg.setNascimentoEbg (formato.parse(jFmtNascimento_ebg.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente_ebg.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        clienteEbg.setRgEbg(jFmtRg_ebg.getText());
        clienteEbg.setCpfEbg(jTxtCep_ebg.getText());
        clienteEbg.setEmailEbg(jTxtEmail_ebg.getText());
        clienteEbg.setCelularEbg(jFmtCelular_ebg.getText());
        clienteEbg.setCepEbg(Util_ebg.strInt(jTxtCep_ebg.getText()));
        clienteEbg.setEnderecoEbg(jTxtEndereco_ebg.getText());
        clienteEbg.setNumeroEbg(jFmtNumero_ebg.getText());
        clienteEbg.setBairroEbg(jTxtBairro_ebg.getText());
        clienteEbg.setCidadeEbg(jTxtCidade_ebg.getText());
        clienteEbg.setUfEbg(jTxtUf_ebg.getText());
        clienteEbg.setComplementoEbg(jTxtComplemento_ebg.getText());
        
        
        return clienteEbg;
        
    }
        
         public void beanView(ClienteEbg clienteEbg) {
        String id = String.valueOf(clienteEbg.getIdclienteEbg());
        
        jTxtCodigo_ebg.setText(id);
        jTxtNome_ebg.setText(clienteEbg.getNomeEbg());
        jTxtGenero_ebg.setText(clienteEbg.getGeneroEbg());
        jTxtProfissao_ebg.setText(clienteEbg.getProfissaoEbg());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtNascimento_ebg.setText(formato.format (clienteEbg.getNascimentoEbg()));
        jFmtRg_ebg.setText(clienteEbg.getRgEbg());
        jTxtCep_ebg.setText(clienteEbg.getCpfEbg());
        jTxtEmail_ebg.setText(clienteEbg.getEmailEbg());
        jFmtCelular_ebg.setText(clienteEbg.getCelularEbg());
        jTxtCep_ebg.setText(Util_ebg.intStr(clienteEbg.getCepEbg()));
        jTxtEndereco_ebg.setText(clienteEbg.getEnderecoEbg());
        jFmtNumero_ebg.setText(clienteEbg.getNumeroEbg());
        jTxtBairro_ebg.setText(clienteEbg.getBairroEbg());
        jTxtCidade_ebg.setText(clienteEbg.getCidadeEbg());
        jTxtUf_ebg.setText(clienteEbg.getUfEbg());
        jTxtComplemento_ebg.setText(clienteEbg.getComplementoEbg());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnExcluir_ebg = new javax.swing.JButton();
        jBtnConfirmar_ebg = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jBtnCancelar_ebg = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtProfissao_ebg = new javax.swing.JTextField();
        jTxtEmail_ebg = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtCodigo_ebg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtNome_ebg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFmtCelular_ebg = new javax.swing.JFormattedTextField();
        jTxtEndereco_ebg = new javax.swing.JTextField();
        jFmtNascimento_ebg = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFmtNumero_ebg = new javax.swing.JFormattedTextField();
        jTxtUf_ebg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtBairro_ebg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtCidade_ebg = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtComplemento_ebg = new javax.swing.JTextField();
        jTxtGenero_ebg = new javax.swing.JTextField();
        jBtnPesquisar_ebg = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnIncluir_ebg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBtnAlterar_ebg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jFmtRg_ebg = new javax.swing.JFormattedTextField();
        jTxtCep_ebg = new javax.swing.JTextField();
        jFmtCpf_ebg = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnExcluir_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/02 - excluir.png"))); // NOI18N
        jBtnExcluir_ebg.setText("Excluir");
        jBtnExcluir_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluir_ebgActionPerformed(evt);
            }
        });

        jBtnConfirmar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/05 - ok.png"))); // NOI18N
        jBtnConfirmar_ebg.setText("Confirmar");
        jBtnConfirmar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmar_ebgActionPerformed(evt);
            }
        });

        jLabel5.setText("CPF");

        jBtnCancelar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/03 - exit.png"))); // NOI18N
        jBtnCancelar_ebg.setText("Cancelar");
        jBtnCancelar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelar_ebgActionPerformed(evt);
            }
        });

        jLabel15.setText("Profissão");

        jLabel6.setText("E-mail");

        jTxtEmail_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmail_ebgActionPerformed(evt);
            }
        });

        jLabel16.setText("Código");

        jLabel7.setText("Celular");

        jTxtCodigo_ebg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCodigo_ebgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCodigo_ebgFocusLost(evt);
            }
        });
        jTxtCodigo_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigo_ebgActionPerformed(evt);
            }
        });

        jLabel9.setText("CEP");

        jLabel8.setText("Endereço");

        jLabel10.setText("Número");

        jLabel11.setText("UF");

        jLabel12.setText("Bairro");

        jTxtBairro_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtBairro_ebgActionPerformed(evt);
            }
        });

        jLabel13.setText("Cidade");

        jTxtCidade_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCidade_ebgActionPerformed(evt);
            }
        });

        jLabel14.setText("Complemento");

        jLabel1.setText("Nome");

        jBtnPesquisar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/06 - pesquisar.png"))); // NOI18N
        jBtnPesquisar_ebg.setText("Pesquisar");
        jBtnPesquisar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisar_ebgActionPerformed(evt);
            }
        });

        jLabel2.setText("Gênero");

        jBtnIncluir_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/04 - incluir.png"))); // NOI18N
        jBtnIncluir_ebg.setText("Incluir");
        jBtnIncluir_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluir_ebgActionPerformed(evt);
            }
        });

        jLabel3.setText("Nascimento:");

        jBtnAlterar_ebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/01 - alterar.png"))); // NOI18N
        jBtnAlterar_ebg.setText("Alterar");
        jBtnAlterar_ebg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterar_ebgActionPerformed(evt);
            }
        });

        jLabel4.setText("RG");

        try {
            jFmtRg_ebg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jFmtCelular_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtComplemento_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTxtCodigo_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtGenero_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFmtRg_ebg, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtProfissao_ebg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(jTxtNome_ebg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jFmtNascimento_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                    .addGap(26, 26, 26))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jFmtCpf_ebg)
                                                    .addGap(18, 18, 18)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel9)
                                                .addComponent(jTxtEmail_ebg, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jFmtNumero_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jTxtUf_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jTxtCep_ebg)))
                                        .addComponent(jTxtEndereco_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(119, 119, 119))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTxtBairro_ebg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(313, 313, 313)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnIncluir_ebg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnAlterar_ebg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnExcluir_ebg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnConfirmar_ebg))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtCidade_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(81, 81, 81)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancelar_ebg)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar_ebg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtCodigo_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtNome_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtGenero_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtProfissao_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFmtNascimento_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFmtRg_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtEmail_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCpf_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtCelular_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCep_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEndereco_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFmtNumero_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtBairro_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtCidade_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtUf_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtComplemento_ebg, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtnIncluir_ebg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnAlterar_ebg)
                            .addComponent(jBtnExcluir_ebg)
                            .addComponent(jBtnConfirmar_ebg)
                            .addComponent(jBtnPesquisar_ebg)))
                    .addComponent(jBtnCancelar_ebg))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExcluir_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluir_ebgActionPerformed
        // TODO add your handling code here:
        if (Util_ebg.perguntar("Deseja excluir o projeto?") == true){
            clienteEbg = viewBean();
            cliente_DAO.delete(clienteEbg);
            Util_ebg.mensagem("Exclusão executada com sucesso.");
            }else {
                Util_ebg.mensagem("Exclusão cancelada.");
            }
        Util_ebg.habilitar(false, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(true, jBtnIncluir_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnPesquisar_ebg);
        Util_ebg.limparCampos(jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
    }//GEN-LAST:event_jBtnExcluir_ebgActionPerformed

    private void jBtnConfirmar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmar_ebgActionPerformed
        // TODO add your handling code here:
        ClienteEbg clienteEbg = viewBean();
        Cliente_DAO cliente_DAO = new Cliente_DAO();

        if (incluindo == true) {
            cliente_DAO.insert(clienteEbg);
        } else {
            cliente_DAO.update(clienteEbg);
        }

        Util_ebg.habilitar(false, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(true, jBtnIncluir_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnPesquisar_ebg);
        Util_ebg.limparCampos(jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        
        Util_ebg.mensagem("Incluido com sucesso!");
    }//GEN-LAST:event_jBtnConfirmar_ebgActionPerformed

    private void jBtnCancelar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelar_ebgActionPerformed
        // TODO add your handling code here:
        Util_ebg.habilitar(false, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtCep_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(true, jBtnIncluir_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnPesquisar_ebg);
        Util_ebg.limparCampos(jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jFmtCpf_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.mensagem("Operação cancelada");
    }//GEN-LAST:event_jBtnCancelar_ebgActionPerformed

    private void jTxtEmail_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmail_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmail_ebgActionPerformed

    private void jTxtCodigo_ebgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigo_ebgFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo_ebgFocusGained

    private void jTxtCodigo_ebgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigo_ebgFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo_ebgFocusLost

    private void jTxtCodigo_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigo_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo_ebgActionPerformed

    private void jTxtBairro_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtBairro_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtBairro_ebgActionPerformed

    private void jTxtCidade_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCidade_ebgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCidade_ebgActionPerformed

    private void jBtnPesquisar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisar_ebgActionPerformed
        JDlgClientePesquisar_ebg jDlgClientePesquisar_ebg = new JDlgClientePesquisar_ebg(null, true);
        jDlgClientePesquisar_ebg.setTelaAnterior(this);
        jDlgClientePesquisar_ebg.setVisible(true);
        Util_ebg.habilitar(true, jBtnCancelar_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg);
        Util_ebg.habilitar(false, jBtnIncluir_ebg, jBtnConfirmar_ebg);
    }//GEN-LAST:event_jBtnPesquisar_ebgActionPerformed

    private void jBtnIncluir_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluir_ebgActionPerformed
        // TODO add your handling code here:
        Util_ebg.habilitar(true, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jTxtCep_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(false, jBtnIncluir_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnPesquisar_ebg);
        Util_ebg.limparCampos(jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jTxtCep_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluir_ebgActionPerformed

    private void jBtnAlterar_ebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterar_ebgActionPerformed
        // TODO add your handling code here:
        Util_ebg.habilitar(true, jBtnCancelar_ebg, jBtnConfirmar_ebg, jTxtCodigo_ebg, jTxtNome_ebg, jTxtGenero_ebg, jTxtProfissao_ebg, jFmtNascimento_ebg, jFmtRg_ebg, jTxtCep_ebg, jTxtEmail_ebg, jFmtCelular_ebg, jTxtCep_ebg, jTxtEndereco_ebg, jFmtNumero_ebg, jTxtBairro_ebg, jTxtCidade_ebg, jTxtUf_ebg, jTxtComplemento_ebg);
        Util_ebg.habilitar(false, jBtnIncluir_ebg, jBtnAlterar_ebg, jBtnExcluir_ebg, jBtnPesquisar_ebg);
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterar_ebgActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCliente_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente_ebg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente_ebg dialog = new JDlgCliente_ebg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar_ebg;
    private javax.swing.JButton jBtnCancelar_ebg;
    private javax.swing.JButton jBtnConfirmar_ebg;
    private javax.swing.JButton jBtnExcluir_ebg;
    private javax.swing.JButton jBtnIncluir_ebg;
    private javax.swing.JButton jBtnPesquisar_ebg;
    private javax.swing.JFormattedTextField jFmtCelular_ebg;
    private javax.swing.JFormattedTextField jFmtCpf_ebg;
    private javax.swing.JFormattedTextField jFmtNascimento_ebg;
    private javax.swing.JFormattedTextField jFmtNumero_ebg;
    private javax.swing.JFormattedTextField jFmtRg_ebg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtBairro_ebg;
    private javax.swing.JTextField jTxtCep_ebg;
    private javax.swing.JTextField jTxtCidade_ebg;
    private javax.swing.JTextField jTxtCodigo_ebg;
    private javax.swing.JTextField jTxtComplemento_ebg;
    private javax.swing.JTextField jTxtEmail_ebg;
    private javax.swing.JTextField jTxtEndereco_ebg;
    private javax.swing.JTextField jTxtGenero_ebg;
    private javax.swing.JTextField jTxtNome_ebg;
    private javax.swing.JTextField jTxtProfissao_ebg;
    private javax.swing.JTextField jTxtUf_ebg;
    // End of variables declaration//GEN-END:variables
}
