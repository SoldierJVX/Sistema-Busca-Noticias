/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SoldierJVX
 */
public class FormTela extends javax.swing.JFrame {

    JFileChooser escolherArquivo;
    ArrayList<URL> listaUrls;
    HashMap<String, ArrayList<URL>> hashListaUrls;
    FormTela formTela;
    Thread_SinalCarregamento sinalCarregando;

    public FormTela() {
        initComponents();

        formTela = this;
        listaUrls = new ArrayList<>();
        hashListaUrls = new HashMap<>();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    public JButton getBtnCarregarArquivo() {
        return btnCarregarArquivo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbtTipoPesquisa = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnCarregarArquivo = new javax.swing.JButton();
        txtCaminho = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbtAND = new javax.swing.JRadioButton();
        rbtOR = new javax.swing.JRadioButton();
        rbtTodosDados = new javax.swing.JRadioButton();
        btnPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca - Trabalho de Iniciação Científica");

        jLabel1.setText("Pesquisa:");

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        btnCarregarArquivo.setText("Carregar Arquivo");
        btnCarregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarArquivoActionPerformed(evt);
            }
        });

        txtCaminho.setEditable(false);

        jLabel2.setText("Caminho do arquivo:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Busca"));

        gbtTipoPesquisa.add(rbtAND);
        rbtAND.setSelected(true);
        rbtAND.setText("Todos os termos");

        gbtTipoPesquisa.add(rbtOR);
        rbtOR.setText("Pelo menos um");

        gbtTipoPesquisa.add(rbtTodosDados);
        rbtTodosDados.setText("Exibir Dados (Não Ordenados)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtAND)
                .addGap(28, 28, 28)
                .addComponent(rbtOR)
                .addGap(18, 18, 18)
                .addComponent(rbtTodosDados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtOR)
                    .addComponent(rbtAND)
                    .addComponent(rbtTodosDados))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setEnabled(false);
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisa)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 7, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCaminho))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCarregarArquivo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(btnPesquisa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarregarArquivo)
                    .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(btnPesquisa)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarArquivoActionPerformed

        escolherArquivo = new JFileChooser();

        txtCaminho.setText("");
        btnPesquisa.setEnabled(false);

        escolherArquivo.setDialogTitle("Carregar Arquivo");
        escolherArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        escolherArquivo.setCurrentDirectory(new File("."));

        escolherArquivo.showOpenDialog(null);

        if (escolherArquivo.getSelectedFile() == null) {

            btnPesquisa.setEnabled(false);
            return;

        }

        txtCaminho.setText(escolherArquivo.getSelectedFile().getPath());

        sinalCarregando = new Thread_SinalCarregamento(formTela);

        btnCarregarArquivo.setEnabled(false);
        sinalCarregando.start();

        new Thread(new Runnable() {

            @Override
            public void run() {

                ManipulacaoDados.recuperarDados(formTela);

                btnPesquisa.setEnabled(true);

                sinalCarregando.stop();

                btnCarregarArquivo.setText("Carregar Arquivo");
                btnCarregarArquivo.setEnabled(true);

            }
        }).start();


    }//GEN-LAST:event_btnCarregarArquivoActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed

        if (txtPesquisa.getText().equals("") && !rbtTodosDados.isSelected()) {
            JOptionPane.showMessageDialog(null, "Digite um termo para pesquisa", "Sem termo a pesquisar", JOptionPane.INFORMATION_MESSAGE);

            return;
        }

        if (rbtAND.isSelected()) {
            ManipulacaoDados.pesquisaAnd(this);
        } else if (rbtOR.isSelected()) {
            ManipulacaoDados.pesquisaOr(this);
        } else {
            ManipulacaoDados.exibirTodosDados(this);
        }


    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

        if (btnPesquisa.isEnabled()) {

            btnPesquisaActionPerformed(evt);

        }
    }//GEN-LAST:event_txtPesquisaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarArquivo;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.ButtonGroup gbtTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtAND;
    private javax.swing.JRadioButton rbtOR;
    private javax.swing.JRadioButton rbtTodosDados;
    private javax.swing.JTextField txtCaminho;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
