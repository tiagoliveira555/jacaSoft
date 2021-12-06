package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaDAO {

    public static int vendaAtual() {

        String sql = "SELECT max(id_venda) FROM tbvendas";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int n = 0;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            n = rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return n;
    }

    public static boolean salvarVenda(Venda venda) {

        String sql = "INSERT INTO tbvendas(data, subtotal, cliente) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, venda.getHoraVenda());
            pst.setFloat(2, venda.getSubtotal());
            pst.setInt(3, venda.getCliente().getId());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static List<Object[]> selecionarTodasVendas() {

        List<Object[]> vendas = new ArrayList();

        String sql = "SELECT V.id_venda, V.data, C.nome, V.subtotal "
                + "FROM tbvendas as V JOIN tbclientes as C "
                + "ON (V.cliente = C.id);";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] venda = new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4)
                };
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return vendas;
    }

    public static List<Object[]> obterVendasId(int idVenda) {

        List<Object[]> vendas = new ArrayList();

        String sql = "SELECT V.id_venda, V.data, C.nome, V.subtotal "
                + "FROM tbvendas as V JOIN tbclientes as C "
                + "ON (V.cliente = C.id) WHERE id_venda = ?;";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idVenda);
            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] venda = new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4)
                };
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return vendas;
    }
}
