/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class database {
     public static Connection getKoneksi(String host, String port, String username, String password, String db){
        String konString ="jdbc:mysql://" + host + ":" + port + "/" + db;
        Connection koneksi = null;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(konString, username, password);
            System.out.println("koneksi berhasil");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Database Error " + ex.getMessage());
            koneksi = null;         
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "kelas Error " + ex.getMessage());
            
        }
       return koneksi;
    }
}
