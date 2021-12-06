package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import org.sqlite.SQLiteException;

public class ProdutoDAO {

    public static String salvar(Produto produto) {

        String sql = "INSERT INTO tbprodutos(codigo, nome_produto, tipo, estoque, "
                + "custo, valor) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, produto.getCodigo());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getTipo());
            pst.setInt(4, produto.getEstoque());
            pst.setFloat(5, produto.getCusto());
            pst.setFloat(6, produto.getValor());
            pst.executeUpdate();

            return "";

        } catch (SQLiteException e) {
            return "id";

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return "Erro no Banco de Dados!";
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static String alterar(Produto produto, int id) {

        String sql = "UPDATE tbprodutos SET codigo = ?, nome_produto = ?, "
                + "tipo = ?, estoque = ?, custo = ?, valor = ? WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, produto.getCodigo());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getTipo());
            pst.setInt(4, produto.getEstoque());
            pst.setFloat(5, produto.getCusto());
            pst.setFloat(6, produto.getValor());
            pst.setInt(7, id);
            pst.executeUpdate();

            return "";

        } catch (SQLiteException e) {
            return "id";

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return "Erro no Banco de Dados!";
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static boolean excluir(int id) {

        String sql = "DELETE FROM tbprodutos WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

            return true;
            
        }catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        }finally {
            Conexao.desconectar(pst, conn);
        }
    }

    

    public static List<Produto> listarProdutos() {

        List<Produto> produtos = null;

        String sql = "SELECT * FROM tbprodutos order by nome_produto";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs != null) {
                produtos = new ArrayList();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt("codigo"));
                    produto.setNome(rs.getString("nome_produto"));
                    produto.setTipo(rs.getString("tipo"));
                    produto.setEstoque(rs.getInt("estoque"));
                    produto.setCusto(rs.getFloat("custo"));
                    produto.setValor(rs.getFloat("valor"));

                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return produtos;
    }
    
    public static void alterarEstoque(Produto produto) {

        String sql = "UPDATE tbprodutos SET estoque = ? WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, produto.getEstoque());
            pst.setInt(2, produto.getCodigo());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }
}
