/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
/**
 *
 * @author Rizky
 */
public class koneksi2 {
 public Connection cc;
 public Statement ss;
 public ResultSet rr;

public void Class(){
try{
Class.forName("com.mysql.jdbc.Driver");
cc=DriverManager.getConnection("jdbc:mysql://localhost/tokosb","root","");
System.out.println("koneksi sukses");
}
catch (Exception e){
System.out.println (e);
}
}
}