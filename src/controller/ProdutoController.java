package controller;

import dao.ProdutoDAO;
import javax.swing.table.DefaultTableModel;
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

    private void limpar() {
        view.getTxtCodigo().setText("");
        view.getTxtNome().setText("");
        view.getCbxTipo().setSelectedItem("Selecione...");
        view.getTxtEstoque().setText("");
        view.getTxtCusto().setText("");
        view.getTxtValor().setText("");
        view.getTblProdutos().setSelectionMode(0);
        alterar = false;
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
        limpar();
        preencherTabela();
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
}
