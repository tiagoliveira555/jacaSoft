package controller;

import dao.ProdutoDAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Produto;
import utils.Mensagem;
import view.TelaProduto;

public class ProdutoController {

    private final TelaProduto view;
    private boolean alterar = false;

    public ProdutoController(TelaProduto view) {
        this.view = view;
        preencherTabela();
    }

    public void evento(String evento) {
        switch (evento) {
            case "FECHAR" ->
                fechar();
            case "SALVAR" ->
                salvarProduto();
            case "LIMPAR" ->
                limpar();
            case "SETAR_CAMPOS" ->
                setarCampos();
            case "EXCLUIR" ->
                excluir();
        }
    }

    private void fechar() {
        view.dispose();
    }
    
    private void estiloTabela() {
        JTableHeader header = view.getTblProdutos().getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 12));
        header.setForeground(Color.blue);
        
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        right.setHorizontalAlignment(SwingConstants.RIGHT);        
        
        view.getTblProdutos().getColumnModel().getColumn(2).setCellRenderer(centro);
        view.getTblProdutos().getColumnModel().getColumn(3).setCellRenderer(centro);
        view.getTblProdutos().getColumnModel().getColumn(4).setCellRenderer(right);
        view.getTblProdutos().getColumnModel().getColumn(5).setCellRenderer(right);
    }

    private void limpar() {
        view.getTxtCodigo().setText("");
        view.getTxtNome().setText("");
        view.getCbxTipo().setSelectedItem("Selecione...");
        view.getTxtEstoque().setText("");
        view.getTxtCusto().setText("");
        view.getTxtValor().setText("");
        view.getTblProdutos().setSelectionMode(0);
        alterar = false;
        setarCorBorda();
    }

    private void preencherTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblProdutos().getModel();
        tableModel.setRowCount(0);

        ProdutoDAO.listarProdutos().forEach(produto -> {
            tableModel.addRow(new Object[]{
                produto.getCodigo(),
                produto.getNome(),
                produto.getTipo(),
                produto.getEstoque(),
                String.format("%.2f", produto.getCusto()),
                String.format("%.2f", produto.getValor())
            });
        });
        estiloTabela();
    }

    private void setarCampos() {
        int row = view.getTblProdutos().getSelectedRow();
        if (row != -1) {
            view.getTxtCodigo().setText(view.getTblProdutos().getValueAt(row, 0).toString());
            view.getTxtNome().setText(view.getTblProdutos().getValueAt(row, 1).toString());
            view.getCbxTipo().setSelectedItem(view.getTblProdutos().getValueAt(row, 2).toString());
            view.getTxtEstoque().setText(view.getTblProdutos().getValueAt(row, 3).toString());
            view.getTxtCusto().setText(view.getTblProdutos().getValueAt(row, 4).toString());
            view.getTxtValor().setText(view.getTblProdutos().getValueAt(row, 5).toString());
            alterar = true;
            setarCorBorda();
        }
    }

    private Produto obterProduto() {
        Produto produto = new Produto();
        produto.setCodigo(Integer.parseInt(view.getTxtCodigo().getText()));
        produto.setNome(view.getTxtNome().getText());
        produto.setTipo(view.getCbxTipo().getSelectedItem().toString());
        produto.setEstoque(Integer.parseInt(view.getTxtEstoque().getText()));
        produto.setCusto(Float.parseFloat(view.getTxtCusto().getText().replace(",", ".")));
        produto.setValor(Float.parseFloat(view.getTxtValor().getText().replace(",", ".")));

        return produto;
    }

    private void salvarProduto() {
        String validar = verificarCamposVazios();
        if (validar.equals("")) {
            Produto produto = obterProduto();
            if (!alterar) {
                String res = ProdutoDAO.salvar(produto);
                switch (res) {
                    case "" ->
                        Mensagem.informacao("Produto salvo com sucesso!");
                    case "id" ->
                        Mensagem.informacao("Já existe produto com esse Id!");
                    default ->
                        Mensagem.informacao("Erro ao salvar o produto!");
                }
            } else {
                int row = view.getTblProdutos().getSelectedRow();
                int id = Integer.parseInt(view.getTblProdutos().getValueAt(row, 0).toString());
                String res = ProdutoDAO.alterar(produto, id);
                switch (res) {
                    case "" ->
                        Mensagem.informacao("Produto alterado com sucesso!");
                    case "id" ->
                        Mensagem.informacao("Já existe produto com esse Id!");
                    default ->
                        Mensagem.informacao("Erro ao alterar o produto!");
                }
            }
            setarCorBorda();
            limpar();
            preencherTabela();
        } else {
            Mensagem.informacao("O(s) campo(s) abaixo:\n" + validar
                    + "\nPrecisam ser preenchidos,\npreencha e tente novamente!");
        }
    }

    private void excluir() {
        if (view.getTblProdutos().getSelectedRow() != -1) {
            boolean excluir = Mensagem.confirmacao("Deseja realmente excluir?");
            if (excluir) {
                int id = Integer.parseInt(view.getTxtCodigo().getText());
                boolean res = ProdutoDAO.excluir(id);

                if (!res) {
                    Mensagem.informacao("Erro ao excluir produto!");
                }
            }
        } else {
            Mensagem.informacao("Nenhum produto selecionado!");
        }
        limpar();
        preencherTabela();
    }

    private String verificarCamposVazios() {

        String retorno = "";

        if (view.getTxtCodigo().getText().equals("")) {
            retorno += "Código\n";
            view.getTxtCodigo().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtCodigo().setBorder(new LineBorder(Color.lightGray));
        }

        if (view.getTxtNome().getText().equals("")) {
            retorno += "Nome\n";
            view.getTxtNome().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtNome().setBorder(new LineBorder(Color.lightGray));
        }

        if (view.getCbxTipo().getSelectedItem().equals("Selecione...")) {
            retorno += "Tipo\n";
            view.getCbxTipo().setBorder(new LineBorder(Color.red));
        } else {
            view.getCbxTipo().setBorder(new LineBorder(Color.lightGray));
        }

        if (view.getTxtEstoque().getText().equals("")) {
            retorno += "Estoque\n";
            view.getTxtEstoque().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtEstoque().setBorder(new LineBorder(Color.lightGray));
        }

        if (view.getTxtCusto().getText().equals("")) {
            retorno += "Custo\n";
            view.getTxtCusto().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtCusto().setBorder(new LineBorder(Color.lightGray));
        }

        if (view.getTxtValor().getText().equals("")) {
            retorno += "Valor Venda\n";
            view.getTxtValor().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtValor().setBorder(new LineBorder(Color.lightGray));
        }

        return retorno;
    }

    private void setarCorBorda() {
        view.getTxtCodigo().setBorder(new LineBorder(Color.lightGray));
        view.getTxtNome().setBorder(new LineBorder(Color.lightGray));
        view.getCbxTipo().setBorder(new LineBorder(Color.lightGray));
        view.getTxtEstoque().setBorder(new LineBorder(Color.lightGray));
        view.getTxtCusto().setBorder(new LineBorder(Color.lightGray));
        view.getTxtValor().setBorder(new LineBorder(Color.lightGray));
    }
}
