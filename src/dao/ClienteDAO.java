package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {

    public static boolean salvar(Cliente cliente) {

        String sql = "INSERT INTO tbclientes(nome, cpf, email, celular, data_nascimento, "
                + "sexo, endereco, cidade, uf) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCelular());
            pst.setString(5, cliente.getDataNascimento());
            pst.setString(6, cliente.getSexo());
            pst.setString(7, cliente.getEndereco());
            pst.setString(8, cliente.getCidade());
            pst.setString(9, cliente.getUf());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static boolean editar(Cliente cliente) {

        String sql = "UPDATE tbclientes SET nome = ?, cpf = ?, email = ?, celular = ?, "
                + "data_nascimento = ?, sexo = ?, endereco = ?, cidade = ?, uf = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCelular());
            pst.setString(5, cliente.getDataNascimento());
            pst.setString(6, cliente.getSexo());
            pst.setString(7, cliente.getEndereco());
            pst.setString(8, cliente.getCidade());
            pst.setString(9, cliente.getUf());
            pst.setInt(10, cliente.getId());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static boolean excluir(int id) {

        String sql = "DELETE FROM tbclientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }

    public static List<Cliente> obterAll() {
        List<Cliente> clientes = new ArrayList();

        String sql = "SELECT * FROM tbclientes";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return clientes;
    }

    public static Cliente obterPorId(int id) {

        String sql = "SELECT * FROM tbclientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Cliente cliente = new Cliente();
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return cliente;
    }

    public static List<Cliente> obterPorNome(String nome) {
        List<Cliente> clientes = new ArrayList();

        String sql = "SELECT * FROM tbclientes WHERE nome LIKE(?)";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }
        return clientes;
    }

}
