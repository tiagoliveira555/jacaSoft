package view;

import controller.VendasController;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaVenda extends javax.swing.JFrame {

    private final VendasController controller;

    public TelaVenda() {
        initComponents();
        controller = new VendasController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JTabbedPane();
        painelRealizarVenda = new javax.swing.JPanel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNumVenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JFormattedTextField();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnNova = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JButton();
        spnQtde = new javax.swing.JSpinner();
        btnRemover = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        txtValorTotal = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        painelConsultaVenda = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItensVenda = new javax.swing.JTable();
        txtPesquisaVenda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Vendas");
        setMaximumSize(new java.awt.Dimension(880, 532));
        setMinimumSize(new java.awt.Dimension(880, 532));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        painelPrincipal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        painelRealizarVenda.setToolTipText("");

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cod. Cliente");

        cbxCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        cbxCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Cliente");

        txtNumVenda.setEditable(false);
        txtNumVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("N. da Venda");

        txtCodProduto.setEditable(false);
        txtCodProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cod. Produto");

        cbxProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        cbxProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Produto");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Qtde");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Valor Unitário");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionarVenda.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código do Produto", "Nome do Produto", "Qtde", "Valor Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVenda);
        if (tblVenda.getColumnModel().getColumnCount() > 0) {
            tblVenda.getColumnModel().getColumn(0).setResizable(false);
            tblVenda.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblVenda.getColumnModel().getColumn(1).setResizable(false);
            tblVenda.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblVenda.getColumnModel().getColumn(2).setResizable(false);
            tblVenda.getColumnModel().getColumn(2).setPreferredWidth(300);
            tblVenda.getColumnModel().getColumn(3).setResizable(false);
            tblVenda.getColumnModel().getColumn(3).setPreferredWidth(1);
            tblVenda.getColumnModel().getColumn(4).setResizable(false);
            tblVenda.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblVenda.getColumnModel().getColumn(5).setResizable(false);
            tblVenda.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar (2).png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNova.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNova.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/novaVenda.png"))); // NOI18N
        btnNova.setText("Nova");

        btnFinalizarVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/finalizarVenda.png"))); // NOI18N
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        spnQtde.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spnQtde.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQtde.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnQtdeStateChanged(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SubTotal:");

        txtValorUnitario.setEditable(false);
        txtValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtValorTotal.setEditable(false);
        txtValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Valor Total");

        javax.swing.GroupLayout painelRealizarVendaLayout = new javax.swing.GroupLayout(painelRealizarVenda);
        painelRealizarVenda.setLayout(painelRealizarVendaLayout);
        painelRealizarVendaLayout.setHorizontalGroup(
            painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                        .addComponent(btnNova)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarVenda))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRealizarVendaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                                .addComponent(txtCodCliente)
                                .addGap(19, 19, 19)))
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodProduto))
                        .addGap(18, 18, 18)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(spnQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorUnitario))
                        .addGap(18, 18, 18)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelRealizarVendaLayout.setVerticalGroup(
            painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelRealizarVendaLayout.createSequentialGroup()
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12)))
                            .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(painelRealizarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarVenda)
                    .addComponent(btnRemover)
                    .addComponent(btnCancelar)
                    .addComponent(btnNova))
                .addGap(19, 19, 19))
        );

        painelPrincipal.addTab("Realizar Venda", painelRealizarVenda);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Id Venda:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pesquisar.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tblVendas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Venda", "Hora da Venda", "Cliente", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblVendas.getTableHeader().setResizingAllowed(false);
        tblVendas.getTableHeader().setReorderingAllowed(false);
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        tblVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblVendasKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblVendas);
        if (tblVendas.getColumnModel().getColumnCount() > 0) {
            tblVendas.getColumnModel().getColumn(0).setResizable(false);
            tblVendas.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblVendas.getColumnModel().getColumn(1).setResizable(false);
            tblVendas.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblVendas.getColumnModel().getColumn(2).setResizable(false);
            tblVendas.getColumnModel().getColumn(2).setPreferredWidth(300);
            tblVendas.getColumnModel().getColumn(3).setResizable(false);
            tblVendas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tblItensVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Item", "Produto", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItensVenda.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblItensVenda.getTableHeader().setResizingAllowed(false);
        tblItensVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblItensVenda);
        if (tblItensVenda.getColumnModel().getColumnCount() > 0) {
            tblItensVenda.getColumnModel().getColumn(0).setResizable(false);
            tblItensVenda.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblItensVenda.getColumnModel().getColumn(1).setResizable(false);
            tblItensVenda.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblItensVenda.getColumnModel().getColumn(2).setResizable(false);
            tblItensVenda.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblItensVenda.getColumnModel().getColumn(3).setResizable(false);
            tblItensVenda.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblItensVenda.getColumnModel().getColumn(4).setResizable(false);
            tblItensVenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtPesquisaVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtPesquisaVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout painelConsultaVendaLayout = new javax.swing.GroupLayout(painelConsultaVenda);
        painelConsultaVenda.setLayout(painelConsultaVendaLayout);
        painelConsultaVendaLayout.setHorizontalGroup(
            painelConsultaVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelConsultaVendaLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelConsultaVendaLayout.setVerticalGroup(
            painelConsultaVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(painelConsultaVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtPesquisaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        painelPrincipal.addTab("Consultar Vendas", painelConsultaVenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );

        setSize(new java.awt.Dimension(894, 571));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
        controller.evento("CLIENTE_SELECIONADO");
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        controller.evento("PRODUTO_SELECIONADO");
    }//GEN-LAST:event_cbxProdutoActionPerformed

    private void spnQtdeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnQtdeStateChanged
        controller.evento("VALOR_TOTAL");
    }//GEN-LAST:event_spnQtdeStateChanged

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        controller.evento("ADICIONAR_ITEM");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        controller.evento("REMOVER_ITEM");
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        controller.evento("CANCELAR_VENDA");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        controller.evento("FINALIZAR_VENDA");
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        controller.evento("SELECIONAR_VENDA");
    }//GEN-LAST:event_tblVendasMouseClicked

    private void tblVendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVendasKeyReleased
        controller.evento("SELECIONAR_VENDA");
    }//GEN-LAST:event_tblVendasKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        controller.evento("PESQUISAR_VENDA");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //controller.evento("TELA_OPEN");
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new TelaVenda().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnNova;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<Object> cbxCliente;
    private javax.swing.JComboBox<Object> cbxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel painelConsultaVenda;
    private javax.swing.JTabbedPane painelPrincipal;
    private javax.swing.JPanel painelRealizarVenda;
    private javax.swing.JSpinner spnQtde;
    private javax.swing.JTable tblItensVenda;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtNumVenda;
    private javax.swing.JFormattedTextField txtPesquisaVenda;
    private javax.swing.JFormattedTextField txtSubTotal;
    private javax.swing.JFormattedTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables

    public JComboBox<Object> getCbxCliente() {
        return cbxCliente;
    }

    public JComboBox<Object> getCbxProduto() {
        return cbxProduto;
    }

    public JSpinner getSpnQtde() {
        return spnQtde;
    }

    public JTable getTblVenda() {
        return tblVenda;
    }

    public JTextField getTxtCodCliente() {
        return txtCodCliente;
    }

    public JTextField getTxtCodProduto() {
        return txtCodProduto;
    }

    public JTextField getTxtNumVenda() {
        return txtNumVenda;
    }

    public JFormattedTextField getTxtSubTotal() {
        return txtSubTotal;
    }

    public JFormattedTextField getTxtValorUnitario() {
        return txtValorUnitario;
    }

    public JFormattedTextField getTxtValorTotal() {
        return txtValorTotal;
    }

    public JTabbedPane getPainelPrincipal() {
        return painelPrincipal;
    }

    /////////////////////////////////////////////////////////////////////
    //ConsultaVenda
    /////////////////////////////////////////////////////////////////////
    public JTable getTblItensVenda() {
        return tblItensVenda;
    }

    public JTable getTblVendas() {
        return tblVendas;
    }

    public JFormattedTextField getTxtPesquisaVenda() {
        return txtPesquisaVenda;
    }
}
