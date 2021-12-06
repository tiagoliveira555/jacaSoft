package controller;

import dao.ClienteDAO;
import dao.ItensVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Cliente;
import model.ItensVenda;
import model.Produto;
import model.Venda;
import utils.Mensagem;
import view.TelaVenda;

public class VendasController {

    private final TelaVenda view;
    ArrayList<ItensVenda> itens = new ArrayList();

    public VendasController(TelaVenda view) {
        this.view = view;
        telaOpen();
    }

    public void evento(String evento) {
        switch (evento) {
            case "TELA_OPEN" ->
                telaOpen();
            case "CLIENTE_SELECIONADO" ->
                clienteSelecionado();
            case "PRODUTO_SELECIONADO" ->
                produtoSelecionado();
            case "VALOR_TOTAL" ->
                produtoValorTotal();
            case "ADICIONAR_ITEM" ->
                adicionarItem();
            case "REMOVER_ITEM" ->
                removerItem();
            case "CANCELAR_VENDA" ->
                cancelarVenda();
            case "FINALIZAR_VENDA" ->
                finalizarVenda();
            case "SELECIONAR_VENDA" ->
                preencherTabelaItensVenda();
            case "PESQUISAR_VENDA" ->
                preencherTabelaVendas();
        }
    }

    private void telaOpen() {
        preencherComboBoxCliente();
        preencherComboBoxProduto();
        numVenda();
        preencherTabelaVendas();
        estiloTabelas();
    }

    private void preencherComboBoxCliente() {
        DefaultComboBoxModel comboBoxClientes = (DefaultComboBoxModel) view.getCbxCliente().getModel();

        ClienteDAO.obterAll().forEach(cliente -> {
            comboBoxClientes.addElement(cliente);
        });
    }

    private void preencherComboBoxProduto() {       
        DefaultComboBoxModel comboBoxProdutos = (DefaultComboBoxModel) view.getCbxProduto().getModel();
        ProdutoDAO.listarProdutos().forEach(produto -> {
            comboBoxProdutos.addElement(produto);
        });
    }
    
    private void estiloTabelas() {
        JTableHeader headerVenda = view.getTblVenda().getTableHeader();
        JTableHeader headerVendas = view.getTblVendas().getTableHeader();
        JTableHeader headerItens = view.getTblItensVenda().getTableHeader();
        headerVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
        headerVenda.setForeground(Color.blue);
        headerVendas.setFont(new Font("Tahoma", Font.BOLD, 12));
        headerVendas.setForeground(Color.blue);
        headerItens.setFont(new Font("Tahoma", Font.BOLD, 12));
        headerItens.setForeground(Color.blue);
        
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        view.getTblVenda().getColumnModel().getColumn(3).setCellRenderer(centro);
        view.getTblVenda().getColumnModel().getColumn(4).setCellRenderer(right);
        view.getTblVenda().getColumnModel().getColumn(5).setCellRenderer(right);
        
        view.getTblVendas().getColumnModel().getColumn(2).setCellRenderer(centro);
        view.getTblVendas().getColumnModel().getColumn(3).setCellRenderer(right);
        
        view.getTblItensVenda().getColumnModel().getColumn(2).setCellRenderer(centro);
        view.getTblItensVenda().getColumnModel().getColumn(3).setCellRenderer(right);
        view.getTblItensVenda().getColumnModel().getColumn(4).setCellRenderer(right);
    }

    //atibui o número da venda
    private void numVenda() {
        int numVenda = VendaDAO.vendaAtual() + 1;

        if (numVenda >= 100) {
            view.getTxtNumVenda().setText(String.format("00%d", numVenda));
        } else if ((numVenda >= 10)) {
            view.getTxtNumVenda().setText(String.format("000%d", numVenda));
        } else {
            view.getTxtNumVenda().setText(String.format("0000%d", numVenda));
        }
    }

    //pega o cliente selecionado no ComboBox
    private void clienteSelecionado() {
        if (view.getCbxCliente().getSelectedItem().equals("Selecione...")) {
            view.getTxtCodCliente().setText("");
        } else {
            Cliente cliente = (Cliente) view.getCbxCliente().getSelectedItem();
            view.getTxtCodCliente().setText(Integer.toString(cliente.getId()));
        }
    }

    //pega o produto selecionado no ComboBox
    private void produtoSelecionado() {
        if (view.getCbxProduto().getSelectedItem().equals("Selecione...")) {
            limparProdutos();
        } else {
            Produto produto = (Produto) view.getCbxProduto().getSelectedItem();
            view.getTxtCodProduto().setText(Integer.toString(produto.getCodigo()));
            view.getTxtValorUnitario().setText(String.format("%.2f", produto.getValor()));

            view.getSpnQtde().setValue(1);
            produtoValorTotal();
        }
    }

    private void limparProdutos() {
        view.getCbxProduto().setSelectedItem("Selecione...");
        view.getTxtCodProduto().setText("");
        view.getTxtValorUnitario().setText("");
        view.getTxtValorTotal().setText("");
        view.getSpnQtde().setValue(1);
    }

    private void produtoValorTotal() {
        if (!view.getTxtValorUnitario().getText().isEmpty()) {
            Produto produto = (Produto) view.getCbxProduto().getSelectedItem();

            //pega a quantidade selecionada
            int qtde = Integer.parseInt(view.getSpnQtde().getValue().toString());

            //verifica se a quantidade selecionada é menor ou igual a quantidade em estoque
            if (qtde <= produto.getEstoque()) {
                view.getTxtValorTotal().setText(String.format("%.2f", produto.getValor() * qtde));
                //não deixa selecionar um quantidade superior ao de estoque do produto
            } else {
                view.getSpnQtde().setValue(qtde - 1);
            }
        }
    }

    private void adicionarItem() {
        if (!view.getCbxProduto().getSelectedItem().equals("Selecione...")) {

            Produto produto = (Produto) view.getCbxProduto().getSelectedItem();
            if (produto.getEstoque() != 0) {
                for (int i = 0; i < view.getTblVenda().getRowCount(); i++) {
                    int codigo = Integer.parseInt(view.getTblVenda().getValueAt(i, 1).toString());
                    if (codigo == produto.getCodigo()) {
                        Mensagem.informacao("Este produto já foi selecionado!");
                        return;
                    }
                }
                itens();
                atualizarTabela();
                somarSubTotal();
                limparProdutos();
            } else {
                Mensagem.informacao("Produto sem estoque");
            }
        } else {
            Mensagem.informacao("Nenhum produto selecionado");
        }
    }

    private ArrayList<ItensVenda> itens() {

        ItensVenda item = new ItensVenda();
        item.setProduto((Produto) view.getCbxProduto().getSelectedItem());
        item.setQtde(Integer.parseInt(view.getSpnQtde().getValue().toString()));
        item.setValorUnitario(Float.parseFloat(view.getTxtValorUnitario().getText().replace(",", ".")));
        item.setValorTotal(Float.parseFloat(view.getTxtValorTotal().getText().replace(",", ".")));

        itens.add(item);

        return itens;
    }

    private void somarSubTotal() {
        float subTotal = 0;
        for (int i = 0; i < view.getTblVenda().getRowCount(); i++) {
            subTotal += Float.parseFloat(view.getTblVenda().getValueAt(i, 5).toString().replace(",", "."));
        }
        view.getTxtSubTotal().setText(String.format("%.2f", subTotal));
    }

    private void atualizarTabela() {

        DefaultTableModel table = (DefaultTableModel) view.getTblVenda().getModel();
        table.setNumRows(0);

        for (int i = 0; i < itens.size(); i++) {
            ItensVenda item = itens.get(i);
            table.addRow(new Object[]{
                view.getTblVenda().getRowCount() + 1,
                item.getProduto().getCodigo(),
                item.getProduto(),
                item.getQtde(),
                String.format("%.2f", item.getValorUnitario()),
                String.format("%.2f", item.getValorTotal())
            });
        }
    }

    private void removerItem() {
        itens.remove(view.getTblVenda().getSelectedRow());
        atualizarTabela();
        somarSubTotal();
    }

    private void cancelarVenda() {
        if (view.getTblVenda().getRowCount() > 0) {
            boolean res = Mensagem.confirmacao("Existem produtos adicionados para venda,\ndeseja realmente cancelar?");
            if (res) {
                limparTela();
            }
        }
    }

    private void limparTela() {
        view.getTxtCodCliente().setText("");
        view.getCbxCliente().setSelectedItem("Selecione...");
        limparProdutos();
        DefaultTableModel table = (DefaultTableModel) view.getTblVenda().getModel();
        table.setRowCount(0);
        view.getTxtSubTotal().setText("");
        itens.clear();
    }

    private void finalizarVenda() {

        if (view.getTblVenda().getRowCount() != 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            Venda venda = new Venda();
            venda.setId_venda(Integer.parseInt(view.getTxtNumVenda().getText()));
            venda.setHoraVenda(dtf.format(LocalDateTime.now()));
            venda.setSubtotal(Float.parseFloat(view.getTxtSubTotal().getText().replace(",", ".")));

            if (view.getCbxCliente().getSelectedItem().equals("Selecione...")) {
                Mensagem.informacao("Nenhum cliente selecionado!");
                return;

            } else {
                Cliente cliente = (Cliente) view.getCbxCliente().getSelectedItem();
                venda.setCliente(cliente);
                boolean resVenda = VendaDAO.salvarVenda(venda);
                if (!resVenda) {
                    return;
                }
            }

            for (int i = 0; i < itens.size(); i++) {
                ItensVenda item = itens.get(i);
                item.setNumItem(Integer.parseInt(view.getTblVenda().getValueAt(i, 0).toString()));
                item.setProduto((Produto) view.getTblVenda().getValueAt(i, 2));
                item.setQtde(Integer.parseInt(view.getTblVenda().getValueAt(i, 3).toString()));
                item.setValorUnitario(Float.parseFloat(view.getTblVenda().getValueAt(i, 4).toString().replace(",", ".")));
                item.setValorTotal(Float.parseFloat(view.getTblVenda().getValueAt(i, 5).toString().replace(",", ".")));

                item.setVenda(venda);

                boolean resItem = ItensVendaDAO.salvarItens(item);
                if (!resItem) {
                    return;
                }
            }
            atualizarEstoque();
            Mensagem.informacao("Venda efetuada com sucesso!");
            limparTela();
            numVenda();
            preencherTabelaVendas();
        } else {
            Mensagem.informacao("Nenhum produto selecionado para venda!");
        }
    }

    private void atualizarEstoque() {
        for (int i = 0; i < view.getTblVenda().getRowCount(); i++) {
            Produto produtoVendido = (Produto) view.getTblVenda().getValueAt(i, 2);
            int estoqueAntigo = produtoVendido.getEstoque();
            int qtdeVendida = Integer.parseInt(view.getTblVenda().getValueAt(i, 3).toString());
            produtoVendido.setEstoque(estoqueAntigo - qtdeVendida);
            ProdutoDAO.alterarEstoque(produtoVendido);
        }
    }

    /////////////////////////////////////////////////////////////////////
    //ConsultaVenda
    /////////////////////////////////////////////////////////////////////
    private void preencherTabelaVendas() {

        DefaultTableModel tabela = (DefaultTableModel) view.getTblVendas().getModel();
        tabela.setNumRows(0);
        List<Object[]> itensVenda;

        if (view.getTxtPesquisaVenda().getText().isEmpty()) {
            itensVenda = VendaDAO.selecionarTodasVendas();
        } else {
            int idVenda = Integer.parseInt(view.getTxtPesquisaVenda().getText());
            itensVenda = VendaDAO.obterVendasId(idVenda);
        }

        itensVenda.forEach(venda -> {
            tabela.addRow(new Object[]{
                venda[0],
                venda[1],                
                venda[2],
                String.format("%.2f", venda[3])
            });
        });
        DefaultTableModel tabelaItens = (DefaultTableModel) view.getTblItensVenda().getModel();
        tabelaItens.setNumRows(0);
    }

    private void preencherTabelaItensVenda() {
        DefaultTableModel tabelaItens = (DefaultTableModel) view.getTblItensVenda().getModel();
        tabelaItens.setNumRows(0);

        int row = view.getTblVendas().getSelectedRow();
        if (row != -1) {
            int numVenda = Integer.parseInt(view.getTblVendas().getValueAt(row, 0).toString());
            List<Object[]> itensVenda = ItensVendaDAO.selecionarItensVenda(numVenda);

            itensVenda.forEach(item -> {
                tabelaItens.addRow(new Object[]{
                    item[0],
                    item[1],
                    item[2],
                    String.format("%.2f", item[3]),
                    String.format("%.2f", item[4]),});
            });
        }
    }
}
