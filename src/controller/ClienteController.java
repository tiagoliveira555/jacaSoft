package controller;

import dao.ClienteDAO;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Cliente;
import utils.Mensagem;
import view.TelaCliente;

public class ClienteController {

    private final TelaCliente view;
    private boolean editar = false;

    public ClienteController(TelaCliente view) {
        this.view = view;
        desabilitarCampos();
        gerirBotoes(true, false, false, false);
        atualizaTabela();
    }

    public void evento(String evento) {
        switch (evento) {
            case "FECHAR" ->
                fechar();
            case "NOVO" ->
                novo();
            case "CANCELAR" ->
                cancelar();
            case "SALVAR" ->
                salvar();
            case "LINHA_TABELA" ->
                setarCampos();
            case "EXCLUIR" ->
                excluir();
            case "PESQUISAR" ->
                pesquisar();
        }
    }

    private void fechar() {
        cancelar();
        view.dispose();
    }
    
    private void estiloTabela() {
        JTableHeader header = view.getTblClientes().getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 12));
        header.setForeground(Color.blue);
    }

    private void novo() {
        habilitarCampos();
        limparCampos();
        gerirBotoes(false, true, false, true);
        view.getTxtNome().requestFocus();
        editar = false;
        atualizaTabela();
        view.getTxtPesquisar().setText("");
    }

    private void cancelar() {
        desabilitarCampos();
        limparCampos();
        gerirBotoes(true, false, false, false);
        atualizaTabela();
        view.getTxtPesquisar().setText("");
        setarCorBorda();
    }

    private void limparCampos() {
        view.getTxtId().setText("");
        view.getTxtNome().setText("");
        view.getTxtCPF().setText("");
        view.getTxtEmail().setText("");
        view.getTxtCelular().setText("");
        view.getTxtDtNascimento().setText("");
        view.getCbxSexo().setSelectedItem("Selecione...");
        view.getTxtEndereco().setText("");
        view.getTxtCidade().setText("");
        view.getTxtUF().setText("");
        view.getTblClientes().setSelectionMode(0);
    }

    private void setarCampos() {
        int row = view.getTblClientes().getSelectedRow();
        if (row != -1) {
            int id = (int) view.getTblClientes().getValueAt(row, 0);
            Cliente cliente = ClienteDAO.obterPorId(id);

            view.getTxtId().setText(String.valueOf(cliente.getId()));
            view.getTxtNome().setText(cliente.getNome());
            view.getTxtCPF().setText(cliente.getCpf());
            view.getTxtEmail().setText(cliente.getEmail());
            view.getTxtCelular().setText(cliente.getCelular());
            view.getTxtDtNascimento().setText(cliente.getDataNascimento());
            view.getCbxSexo().setSelectedItem(cliente.getSexo());
            view.getTxtEndereco().setText(cliente.getEndereco());
            view.getTxtCidade().setText(cliente.getCidade());
            view.getTxtUF().setText(cliente.getUf());
        }
        editar = true;
        habilitarCampos();
        gerirBotoes(false, true, true, true);
        setarCorBorda();
    }

    private void atualizaTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblClientes().getModel();
        tableModel.setNumRows(0);

        ClienteDAO.obterAll().forEach(cliente -> {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSexo()
            });
        });
        estiloTabela();
    }

    private void pesquisar() {
        List<Cliente> pesquisa = ClienteDAO.obterPorNome(view.getTxtPesquisar().getText());
        DefaultTableModel tableModel = (DefaultTableModel) view.getTblClientes().getModel();
        tableModel.setNumRows(0);

        pesquisa.forEach(cliente -> {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getSexo()
            });
        });
    }

    private Cliente obterCliente() {
        Cliente cliente = new Cliente();
        if (!view.getTxtId().getText().isEmpty()) {
            cliente.setId(Integer.parseInt(view.getTxtId().getText()));
        }
        cliente.setNome(view.getTxtNome().getText());
        cliente.setCpf(view.getTxtCPF().getText());
        cliente.setEmail(view.getTxtEmail().getText());
        cliente.setCelular(view.getTxtCelular().getText());
        cliente.setDataNascimento(view.getTxtDtNascimento().getText());
        cliente.setSexo(view.getCbxSexo().getSelectedItem().toString());
        cliente.setEndereco(view.getTxtEndereco().getText());
        cliente.setCidade(view.getTxtCidade().getText());
        cliente.setUf(view.getTxtUF().getText());

        return cliente;
    }

    private void salvar() {
        String camposVazios = verificarCamposVazios();
        if (camposVazios.equals("")) {
            Cliente cliente = obterCliente();
            if (!editar) {
                boolean res = ClienteDAO.salvar(cliente);
                if (res) {
                    Mensagem.informacao("Cliente salvo com sucesso!");
                } else {
                    Mensagem.informacao("Erro ao salvar cliente!");
                }
            } else {
                boolean res = ClienteDAO.editar(cliente);
                if (res) {
                    Mensagem.informacao("Cliente editado com sucesso!");
                } else {
                    Mensagem.informacao("Erro ao editar cliente!");
                }
            }
            cancelar();
            atualizaTabela();
        } else {
            Mensagem.informacao("O(s) campo(s) abaixo:\n" + camposVazios
                    + "\nPrecisam ser preenchidos,\npreencha e tente novamente!");
        }

    }

    private void excluir() {
        boolean excluir = Mensagem.confirmacao("Tem certeza que deseja excluir?");
        if (excluir) {
            if (!view.getTxtId().getText().isEmpty()) {
                int id = Integer.parseInt(view.getTxtId().getText());
                boolean res = ClienteDAO.excluir(id);
                if (!res) {
                    Mensagem.informacao("Erro ao excluir cliente!");
                }
            }
            cancelar();
            limparCampos();
            atualizaTabela();
        }
    }

    private void gerirCampos(boolean estado) {
        view.getTxtId().setEnabled(estado);
        view.getTxtNome().setEnabled(estado);
        view.getTxtCPF().setEnabled(estado);
        view.getTxtEmail().setEnabled(estado);
        view.getTxtCelular().setEnabled(estado);
        view.getTxtDtNascimento().setEnabled(estado);
        view.getCbxSexo().setEnabled(estado);
        view.getTxtEndereco().setEnabled(estado);
        view.getTxtCidade().setEnabled(estado);
        view.getTxtCidade().setEnabled(estado);
        view.getTxtUF().setEnabled(estado);
    }

    private void habilitarCampos() {
        gerirCampos(true);
    }

    private void desabilitarCampos() {
        gerirCampos(false);
    }

    private void gerirBotoes(boolean novo, boolean salvar, boolean excluir, boolean cancelar) {
        view.getBtnNovo().setEnabled(novo);
        view.getBtnSalvar().setEnabled(salvar);
        view.getBtnExcluir().setEnabled(excluir);
        view.getBtnCancelar().setEnabled(cancelar);
    }

    private String verificarCamposVazios() {

        String retorno = "";

        if (view.getTxtNome().getText().equals("")) {
            retorno += "Nome\n";
            view.getTxtNome().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtNome().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtCPF().getText().replace(".", "").replace("-", "")
                .replace(" ", "").equals("")) {
            retorno += "CPF\n";
            view.getTxtCPF().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtCPF().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtEmail().getText().equals("")) {
            retorno += "E-mail\n";
            view.getTxtEmail().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtEmail().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtCelular().getText().replace("(", "").replace(")", "")
                .replace("-", "").replace(" ", "").equals("")) {
            retorno += "Celular\n";
            view.getTxtCelular().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtCelular().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtDtNascimento().getText().replace("/", "")
                .replace(" ", "").equals("")) {
            retorno += "Data de Nascimento\n";
            view.getTxtDtNascimento().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtDtNascimento().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getCbxSexo().getSelectedItem().equals("Selecione...")) {
            retorno += "Sexo\n";
            view.getCbxSexo().setBorder(new LineBorder(Color.red));
        } else {
            view.getCbxSexo().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtEndereco().getText().equals("")) {
            retorno += "Endereço\n";
            view.getTxtEndereco().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtEndereco().setBorder(new LineBorder(Color.lightGray));
        }        
        
        if (view.getTxtCidade().getText().equals("")) {
            retorno += "Cidade\n";
            view.getTxtCidade().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtCidade().setBorder(new LineBorder(Color.lightGray));
        }
        
        if (view.getTxtUF().getText().equals("")) {
            retorno += "UF\n";
            view.getTxtUF().setBorder(new LineBorder(Color.red));
        } else {
            view.getTxtUF().setBorder(new LineBorder(Color.lightGray));
        }

        return retorno;
    }
    
    private void setarCorBorda() {
        view.getTxtNome().setBorder(new LineBorder(Color.lightGray));
        view.getTxtCPF().setBorder(new LineBorder(Color.lightGray));
        view.getTxtEmail().setBorder(new LineBorder(Color.lightGray));
        view.getTxtCelular().setBorder(new LineBorder(Color.lightGray));
        view.getTxtDtNascimento().setBorder(new LineBorder(Color.lightGray));
        view.getCbxSexo().setBorder(new LineBorder(Color.lightGray));
        view.getTxtEndereco().setBorder(new LineBorder(Color.lightGray));
        view.getTxtCidade().setBorder(new LineBorder(Color.lightGray));
        view.getTxtUF().setBorder(new LineBorder(Color.lightGray));        
    }
}
