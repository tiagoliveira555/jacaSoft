package utils;

import javax.swing.JOptionPane;

public class Mensagem {
    
    public static void informacao(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static boolean confirmacao(String msg) {
        int res = JOptionPane.showConfirmDialog(null, msg, "Atenção", JOptionPane.YES_NO_OPTION);
        
        return res == JOptionPane.YES_OPTION; 
    }
}
