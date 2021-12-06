package controller;

import utils.Mensagem;
import view.MenuPrincipal;
import view.TelaCliente;
import view.TelaLogin;
import view.TelaProduto;
import view.TelaSobre;
import view.TelaVenda;

public class MenuPrincipalController {

    private final MenuPrincipal view;
    private TelaCliente telaCliente;
    private TelaProduto telaProduto;
    private TelaSobre telaSobre;
    private TelaVenda telaVenda;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }

    public void evento(String evento) {
        switch (evento) {
            case "LOGOFF" ->
                logoff();
            case "SAIR" ->
                sair();
            case "TELA_CLIENTE" ->
                telaCliente();
            case "TELA_PRODUTO" ->
                telaProduto();
            case "TELA_SOBRE" ->
                telaSobre();
            case "TELA_VENDA" ->
                telaVenda();
            case "CONSULTAR_VENDA" ->
                consultarVenda();
        }
    }

    private void logoff() {
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        view.dispose();
    }

    private void sair() {
        boolean sair = Mensagem.confirmacao("Deseja sair realmente?");
        if (sair) {
            System.exit(0);
        }
    }

    private void telaCliente() {
        if (telaCliente == null) {
            telaCliente = new TelaCliente();
        }
        if (!telaCliente.isVisible()) {
            telaCliente.setVisible(true);
        }
        telaCliente.toFront();
    }

    private void telaProduto() {
        if (telaProduto == null) {
            telaProduto = new TelaProduto();
        }
        if (!telaProduto.isVisible()) {
            telaProduto.setVisible(true);
        }
        telaProduto.toFront();
    }

    private void telaSobre() {
        if (telaSobre == null) {
            telaSobre = new TelaSobre();
        }
        if (!telaSobre.isVisible()) {
            telaSobre.setVisible(true);
        }
        telaSobre.toFront();
    }

    private void venda() {
        telaVenda = new TelaVenda();
        if (!telaVenda.isVisible()) {
            telaVenda.setVisible(true);
        }
        telaVenda.toFront();
    }

    private void telaVenda() {
        venda();
        telaVenda.getPainelPrincipal().setSelectedIndex(0);

    }

    private void consultarVenda() {
        venda();
        telaVenda.getPainelPrincipal().setSelectedIndex(1);
    }
}
