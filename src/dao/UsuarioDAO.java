package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static String[] login(String login, String senha) {

        String sql = "SELECT * FROM tbusuarios WHERE login = ? AND senha = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String[] resposta = new String[2];

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            if (rs.next()) {
                resposta[0] = rs.getString("nome");
                resposta[1] = rs.getString("perfil");
            } else {
                resposta[0] = "ErroUsuario";
                resposta[1] = "ErroSenha";
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return resposta;
    }

}
