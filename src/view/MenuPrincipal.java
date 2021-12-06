package view;

import controller.MenuPrincipalController;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPrincipal extends javax.swing.JFrame {

    private final MenuPrincipalController controller;
    
    public MenuPrincipal() {
        initComponents();
        controller = new MenuPrincipalController(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblCadeado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCadastro = new javax.swing.JMenu();
        menCadClientes = new javax.swing.JMenuItem();
        menCadProdutos = new javax.swing.JMenuItem();
        menCadUsuarios = new javax.swing.JMenuItem();
        menVenda = new javax.swing.JMenu();
        menVenRealizar = new javax.swing.JMenuItem();
        menVenConsultar = new javax.swing.JMenuItem();
        menRelatorios = new javax.swing.JMenu();
        menOpcoes = new javax.swing.JMenu();
        menOpcLogoff = new javax.swing.JMenuItem();
        menOpcSair = new javax.swing.JMenuItem();
        menAjuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(761, 481));
        setMinimumSize(new java.awt.Dimension(761, 481));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JacaSoft");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel1)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Usuário:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 255));
        lblUsuario.setText("jLabel3");
        lblUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblCadeado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cadeadoAberto.png"))); // NOI18N
        lblCadeado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadeadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCadeado))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCadeado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Jaca.jpg"))); // NOI18N

        menCadastro.setText("Cadastro");
        menCadastro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menCadClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menCadClientes.setText("Clientes");
        menCadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadClientesActionPerformed(evt);
            }
        });
        menCadastro.add(menCadClientes);

        menCadProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menCadProdutos.setText("Produtos");
        menCadProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadProdutosActionPerformed(evt);
            }
        });
        menCadastro.add(menCadProdutos);

        menCadUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menCadUsuarios.setText("Usuários");
        menCadastro.add(menCadUsuarios);

        jMenuBar1.add(menCadastro);

        menVenda.setText("Venda");
        menVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menVenRealizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menVenRealizar.setText("Realizar Venda");
        menVenRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menVenRealizarActionPerformed(evt);
            }
        });
        menVenda.add(menVenRealizar);

        menVenConsultar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menVenConsultar.setText("Consultar Vendas");
        menVenConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menVenConsultarActionPerformed(evt);
            }
        });
        menVenda.add(menVenConsultar);

        jMenuBar1.add(menVenda);

        menRelatorios.setText("Relatórios");
        menRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(menRelatorios);

        menOpcoes.setText("Opções");
        menOpcoes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menOpcLogoff.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menOpcLogoff.setText("Logoff");
        menOpcLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcLogoffActionPerformed(evt);
            }
        });
        menOpcoes.add(menOpcLogoff);

        menOpcSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menOpcSair.setText("Sair");
        menOpcSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcSairActionPerformed(evt);
            }
        });
        menOpcoes.add(menOpcSair);

        jMenuBar1.add(menOpcoes);

        menAjuda.setText("Ajuda");
        menAjuda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menAjuda.add(jMenuItem1);

        jMenuBar1.add(menAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(777, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menCadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadClientesActionPerformed
        controller.evento("TELA_CLIENTE");
    }//GEN-LAST:event_menCadClientesActionPerformed

    private void menOpcLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcLogoffActionPerformed
        controller.evento("LOGOFF");
    }//GEN-LAST:event_menOpcLogoffActionPerformed

    private void lblCadeadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadeadoMouseClicked
        controller.evento("LOGOFF");
    }//GEN-LAST:event_lblCadeadoMouseClicked

    private void menOpcSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcSairActionPerformed
        controller.evento("SAIR");
    }//GEN-LAST:event_menOpcSairActionPerformed

    private void menCadProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadProdutosActionPerformed
        controller.evento("TELA_PRODUTO");
    }//GEN-LAST:event_menCadProdutosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controller.evento("TELA_SOBRE");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menVenRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menVenRealizarActionPerformed
        controller.evento("TELA_VENDA");
    }//GEN-LAST:event_menVenRealizarActionPerformed

    private void menVenConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menVenConsultarActionPerformed
        controller.evento("CONSULTAR_VENDA");
    }//GEN-LAST:event_menVenConsultarActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCadeado;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAjuda;
    private javax.swing.JMenuItem menCadClientes;
    private javax.swing.JMenuItem menCadProdutos;
    private javax.swing.JMenuItem menCadUsuarios;
    private javax.swing.JMenu menCadastro;
    private javax.swing.JMenuItem menOpcLogoff;
    private javax.swing.JMenuItem menOpcSair;
    private javax.swing.JMenu menOpcoes;
    private javax.swing.JMenu menRelatorios;
    private javax.swing.JMenuItem menVenConsultar;
    private javax.swing.JMenuItem menVenRealizar;
    private javax.swing.JMenu menVenda;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public JMenuItem getMenCadUsuarios() {
        return menCadUsuarios;
    }

    public JMenu getMenRelatorios() {
        return menRelatorios;
    }
}
