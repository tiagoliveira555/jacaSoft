package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {

        Connection conexao;
        try {

            String url = "jdbc:sqlite:banco/bd.db";

            conexao = DriverManager.getConnection(url);
            
            return conexao;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

    public static void desconectar(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }
    }
    
    public static void desconectar(PreparedStatement pst, Connection conn) {

        try {
            if (pst != null) {
                pst.close();
            }
            desconectar(conn);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
     public static void desconectar(ResultSet rs, PreparedStatement pst, 
             Connection conn) {

        try {
            if (rs != null) {
                rs.close();
            }
            desconectar(pst, conn);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
