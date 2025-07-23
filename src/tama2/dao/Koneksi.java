/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tama2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Koneksi {
    private final String url = "jdbc:mysql://localhost:3306/pbo_2401091028";
    private final String username = "root";
    private final String password = "";
    
    public Connection getKoneksi() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void main(String[] args) {
        Koneksi k = new Koneksi();
        try {
            k.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" 
                    + ex.getMessage());
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
