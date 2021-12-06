package controller;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import dao.UsuarioDAO;
import javax.swing.UIManager;
import utils.Mensagem;
import view.MenuPrincipal;
import view.TelaLogin;

public class UsuarioController {

    private final TelaLogin view;

    public UsuarioController(TelaLogin view) {
        this.view = view;
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
    }

    public void evento(String evento) {
        switch (evento) {
            case "LOGIN" ->
                login();
            case "DATA" ->
                data();
        }
    }

    private void login() {

        String login = view.getTxtUsuario().getText();
        String senha = new String(view.getTxtSenha().getPassword());

        String[] res = UsuarioDAO.login(login, senha);

        switch (res[0]) {
            case "ErroUsuario" ->
                Mensagem.informacao("Usuário e/ou senha incorreto!");
            case "Marivaldo" ->
                Mensagem.informacao("Nunca terá acesso ao meu sistema!");
            default -> {
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                menu.getLblUsuario().setText(res[0]);
                view.dispose();
                switch (res[1]) {
                    case "admin" -> {
                        menu.getLblUsuario().setForeground(Color.red);
                    }
                    case "user" -> {
                        menu.getMenCadUsuarios().setEnabled(false);
                        menu.getMenRelatorios().setEnabled(false);
                    }
                }
            }
        }
    }

    private void data() {
        Date data = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);

        view.getLblData().setText(formato.format(data));
    }

}
