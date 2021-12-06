package dao;

import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItensVenda;

public class ItensVendaDAO {
    
    public static boolean salvarItens(ItensVenda itens) {
        
        String sql = "INSERT INTO tbitens(venda, num_item, produto, qtde, valor_unitario,"
                + "valor_total) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, itens.getVenda().getId_venda());
            pst.setInt(2, itens.getNumItem());
            pst.setInt(3, itens.getProduto().getCodigo());
            pst.setInt(4, itens.getQtde());
            pst.setFloat(5, itens.getValorUnitario());
            pst.setFloat(6, itens.getValorTotal());            
            
            pst.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(pst, conn);
        }
    }
    
    public static List<Object[]> selecionarItensVenda(int numVenda) {
        
        List<Object[]> itensVenda = new ArrayList();
        
        String sql = "SELECT I.num_item, P.nome_produto, I.qtde, I.valor_unitario, "
                + "I.valor_total FROM tbitens as I join tbprodutos as P "
                + "on (I.produto = P.codigo) WHERE I.venda = ?;";
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Conexao.conectar();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, numVenda);
            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] itens = new Object[5];
                itens[0] = rs.getInt(1);
                itens[1] = rs.getString(2);
                itens[2] = rs.getInt(3);
                itens[3] = rs.getFloat(4);
                itens[4] = rs.getFloat(5);
                
                itensVenda.add(itens);
            }           
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        } finally {
            Conexao.desconectar(rs, pst, conn);
        }        
        return itensVenda;
    }
}
