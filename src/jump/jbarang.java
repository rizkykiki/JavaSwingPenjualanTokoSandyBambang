/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jump;

//import admin.barang;
import admin.barang_masuk;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class jbarang extends javax.swing.JFrame {
private Connection con;
    private Statement stat;
    private ResultSet res;
    private String tgllahir;
       public barang_masuk pi = null;
    /**
     * Creates new form jbarang
     */
    public jbarang() {
        initComponents();
         koneksi();
        tabeltam();
        tabel1();
        jPanel1.hide();   
//         jPanel17.hide();
    }
     public void badcovernih() {
       if (bmylove.isSelected() ){
             merek.setText("Bad Cover Mylove");
             // idd.setText("BC0228887");
                      try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCMYLOVE%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(11);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCMYLOVE" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCMYLOVE0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
           
        }   else if(bbonita.isSelected() ){
               //  idd.setText("BC0229997");
                merek.setText("Bad Cover Bonita");
                   try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCBonita%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(11);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCBonita" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCBonita0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
       
         } else if(blady.isSelected() ){
           //    idd.setText("BC0226666");
                merek.setText("Bad Cover Lady Rose");
                        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCLadyrose%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCLadyrose" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCLadyrose0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
       
        }   else if(bcal.isSelected() ){
              // idd.setText("BC0224447");
                merek.setText("Bad Cover California");
                        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCCalifornia%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCCalifornia" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCCalifornia0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
       
        }  else if(bsantika.isSelected() ){
              // idd.setText("BC0225557");
                merek.setText("Bad Cover Santika");
                          try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCSantika%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(12);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCSantika" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCSantika0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        } else if(bin.isSelected() ){
             //  idd.setText("BC0227771");
                merek.setText("Bad Cover Internal");
                          try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%BCInternal%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("BCInternal" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("BCInternal0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
       
        }  
 }
 public void selimutnih() {
       if(smylove.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut Mylove");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTMYLOVE120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTMYLOVE120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTMYLOVE120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(smylove.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut Mylove");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTMYLOVE160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTMYLOVE160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTMYLOVE160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
             JOptionPane.showMessageDialog(null, "pesan salah : " + e);
        }
       
        }else if(smylove.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut Mylove");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTMYLOVE180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTMYLOVE180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTMYLOVE180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        } else if(sbonita.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut Bonita");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTBonita120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTBonita120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTBonita120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(sbonita.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut Bonita");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTBonita160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTBonita160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTBonita160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(sbonita.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut Bonita");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTBonita180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTBonita180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTBonita180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }  else if(slady.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut Lady Rose");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTLadyRose120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTLadyRose120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTLadyRose120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(slady.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut Lady Rose");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTLadyRose160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTLadyRose160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTLadyRose160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(slady.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut Lady Rose");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTLadyRose180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTLadyRose180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTLadyRose180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }   else if(scal.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut California");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTCalifornia120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(17);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTCalifornia120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTCalifornia120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(scal.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut California");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTCalifornia160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(17);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTCalifornia160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTCalifornia160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(scal.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut California");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTCalifornia180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(17);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTCalifornia180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTCalifornia180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        } else if(ssan.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut Santika");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTSantika120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTSantika120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTSantika120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(ssan.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut Santika");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTSantika160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTSantika160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTSantika160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(ssan.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut Santika");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTSantika180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTSantika180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTSantika180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(sin.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Selimut Internal");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTInternal120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTInternal120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTInternal120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(sin.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Selimut Internal");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTInternal160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTInternal160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTInternal160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(sin.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Selimut Internal");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SMTInternal180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(15);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SMTInternal180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SMTInternal180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }
 }
 public void spring(){
     if(airland.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Spring Bad Airland");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPAirland120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPAirland120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPAirland120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(airland.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Spring bad Airland");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPAirland160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPAirland160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPAirland160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(airland.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Spring Bad Airland");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPAirland180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(13);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPAirland180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPAirland180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        } else if(comforta.isSelected() && ukuran.getSelectedItem() == "120x200" ){
                         merek.setText("Spring Bad Comforta");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPComforta120u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPComforta120u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPComforta120u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(comforta.isSelected() && ukuran.getSelectedItem() == "160x200" ){
                          merek.setText("Spring bad Comforta");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPComforta160u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPComforta160u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPComforta160u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }else if(comforta.isSelected() && ukuran.getSelectedItem() == "180x200" ){
                        merek.setText("Spring Bad Comforta");
               try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM stok_barang WHERE id_barang LIKE '%SPComforta180u%' ORDER BY id_barang DESC" ;
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barang").substring(14);
                String AN = "" + (Integer.parseInt(idperpuss) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                idd.setText("SPComforta180u" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idd.setText("SPComforta180u0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
       
        }
 }
 private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            stat = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     private void tabeltam() {
          int jumlah = 0;
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
            tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
        //tb.addColumn("Type Barang");
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Jual");
        tb.addColumn("Harga Beli");
        tb.addColumn("Stok Barang");
        

        
        tabelb.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from stok_barang");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                 //   res.getString("tipe_barang"),
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getString("harga_beli"),
                    res.getString("stokbarang")
                    
                });
            }
jumlah = tabelb.getRowCount();
 jum.setText(jumlah+" Item");
        } catch (Exception e) {
        }
    }
 private void tabel1() {
      int jumlah = 0;
      String itemcari = cari.getText();
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
         tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
        //tb.addColumn("Type Barang");
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Jual");
        tb.addColumn("Harga Beli");
        tb.addColumn("Stok Barang");
        
        tabelb.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM stok_barang where id_barang like '%"+itemcari+"%' or nama_barang like '%"+itemcari+"%' order by id_barang asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                 //   res.getString("tipe_barang"),
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getString("harga_beli"),
                    res.getString("stokbarang")
                    
                   
                });
            }
jumlah = tabelb.getRowCount();
 jum.setText(jumlah+" Item");
        } catch (Exception e) {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        ukuran = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        bin = new javax.swing.JRadioButton();
        bmylove = new javax.swing.JRadioButton();
        bbonita = new javax.swing.JRadioButton();
        blady = new javax.swing.JRadioButton();
        bcal = new javax.swing.JRadioButton();
        bsantika = new javax.swing.JRadioButton();
        smylove = new javax.swing.JRadioButton();
        comforta = new javax.swing.JRadioButton();
        ssan = new javax.swing.JRadioButton();
        sbonita = new javax.swing.JRadioButton();
        slady = new javax.swing.JRadioButton();
        sin = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        scal = new javax.swing.JRadioButton();
        airland = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        idd = new javax.swing.JLabel();
        namaa = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        merek = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        close2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        beli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        jum1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Jenis");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bad Cover", "Selimut (Balmut)", "Spring Bad" }));
        jenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jenisMousePressed(evt);
            }
        });
        jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisActionPerformed(evt);
            }
        });
        jPanel1.add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 10, 140, -1));

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ukuran");
        jLabel27.setToolTipText("");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        ukuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "120x200", "160x200", "180x200" }));
        ukuran.setEnabled(false);
        ukuran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ukuranMouseClicked(evt);
            }
        });
        ukuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukuranActionPerformed(evt);
            }
        });
        jPanel1.add(ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 50, 140, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Nama Model");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 100, 20));

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Merek Badcover");
        jLabel26.setToolTipText("");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 90, 100, -1));

        bin.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bin);
        bin.setForeground(new java.awt.Color(255, 255, 255));
        bin.setText("Internal");
        bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binActionPerformed(evt);
            }
        });
        jPanel1.add(bin, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 120, -1, -1));

        bmylove.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bmylove);
        bmylove.setForeground(new java.awt.Color(255, 255, 255));
        bmylove.setText("Mylove");
        bmylove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmyloveActionPerformed(evt);
            }
        });
        jPanel1.add(bmylove, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 90, -1, -1));

        bbonita.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bbonita);
        bbonita.setForeground(new java.awt.Color(255, 255, 255));
        bbonita.setText("Bonita");
        bbonita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbonitaActionPerformed(evt);
            }
        });
        jPanel1.add(bbonita, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 90, -1, -1));

        blady.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(blady);
        blady.setForeground(new java.awt.Color(255, 255, 255));
        blady.setText("Lady Rose");
        blady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bladyActionPerformed(evt);
            }
        });
        jPanel1.add(blady, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 90, -1, -1));

        bcal.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bcal);
        bcal.setForeground(new java.awt.Color(255, 255, 255));
        bcal.setText("California");
        bcal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcalActionPerformed(evt);
            }
        });
        jPanel1.add(bcal, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 120, -1, -1));

        bsantika.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(bsantika);
        bsantika.setForeground(new java.awt.Color(255, 255, 255));
        bsantika.setText("Santika");
        bsantika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsantikaActionPerformed(evt);
            }
        });
        jPanel1.add(bsantika, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 120, -1, -1));

        smylove.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(smylove);
        smylove.setForeground(new java.awt.Color(255, 255, 255));
        smylove.setText("Mylove");
        smylove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smyloveActionPerformed(evt);
            }
        });
        jPanel1.add(smylove, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 150, -1, -1));

        comforta.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(comforta);
        comforta.setForeground(new java.awt.Color(255, 255, 255));
        comforta.setText("Comforta");
        comforta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfortaActionPerformed(evt);
            }
        });
        jPanel1.add(comforta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        ssan.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(ssan);
        ssan.setForeground(new java.awt.Color(255, 255, 255));
        ssan.setText("Santika");
        ssan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssanActionPerformed(evt);
            }
        });
        jPanel1.add(ssan, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 180, -1, -1));

        sbonita.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(sbonita);
        sbonita.setForeground(new java.awt.Color(255, 255, 255));
        sbonita.setText("Bonita");
        sbonita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbonitaActionPerformed(evt);
            }
        });
        jPanel1.add(sbonita, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 150, -1, -1));

        slady.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(slady);
        slady.setForeground(new java.awt.Color(255, 255, 255));
        slady.setText("Lady Rose");
        slady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sladyActionPerformed(evt);
            }
        });
        jPanel1.add(slady, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 150, -1, -1));

        sin.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(sin);
        sin.setForeground(new java.awt.Color(255, 255, 255));
        sin.setText("Internal");
        sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinActionPerformed(evt);
            }
        });
        jPanel1.add(sin, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 180, -1, -1));

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Merek Selimut");
        jLabel29.setToolTipText("");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 150, 100, -1));

        scal.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(scal);
        scal.setForeground(new java.awt.Color(255, 255, 255));
        scal.setText("California");
        scal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scalActionPerformed(evt);
            }
        });
        jPanel1.add(scal, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 180, -1, -1));

        airland.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(airland);
        airland.setForeground(new java.awt.Color(255, 255, 255));
        airland.setText("Airland");
        airland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlandActionPerformed(evt);
            }
        });
        jPanel1.add(airland, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Merek Springbad");
        jLabel30.setToolTipText("");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, -1));

        jPanel17.setBackground(new java.awt.Color(0, 0, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel17MousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Simpan");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Keuntungan untuk selimut 25 ribu, untuk Badcover 35 ribu dan untuk spring bad 250 ribu");
        jLabel17.setToolTipText("");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 510, -1));

        harga.setBackground(new java.awt.Color(0, 0, 0));
        harga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 255));
        harga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKeyTyped(evt);
            }
        });
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 220, -1));

        idd.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        idd.setForeground(new java.awt.Color(255, 255, 255));
        idd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idd.setToolTipText("");
        jPanel1.add(idd, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 220, -1));

        namaa.setBackground(new java.awt.Color(0, 0, 0));
        namaa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaa.setForeground(new java.awt.Color(255, 255, 255));
        namaa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        namaa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaaKeyTyped(evt);
            }
        });
        jPanel1.add(namaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 220, -1));

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Harga Jual");
        jLabel18.setToolTipText("");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 80, -1));

        merek.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        merek.setForeground(new java.awt.Color(255, 255, 255));
        merek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merek.setToolTipText("");
        jPanel1.add(merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 220, -1));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Id Barang");
        jLabel19.setToolTipText("");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        close2.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close2.setForeground(new java.awt.Color(255, 0, 0));
        close2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close2.setText("X");
        close2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close2MouseClicked(evt);
            }
        });
        jPanel1.add(close2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, 20));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Harga Beli");
        jLabel20.setToolTipText("");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 80, -1));

        beli.setBackground(new java.awt.Color(0, 0, 0));
        beli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beli.setForeground(new java.awt.Color(255, 255, 255));
        beli.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                beliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                beliKeyTyped(evt);
            }
        });
        jPanel1.add(beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 220, -1));

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Nama Merek");
        jLabel21.setToolTipText("");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 270));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        tabelb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelb.setForeground(new java.awt.Color(51, 51, 51));
        tabelb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelb.setGridColor(new java.awt.Color(255, 255, 255));
        tabelb.setRowHeight(20);
        tabelb.setSelectionBackground(new java.awt.Color(1, 198, 83));
        tabelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelb);

        kGradientPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 770, 170));

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jump Barang Masuk");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 600, 50));

        jum.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum.setForeground(new java.awt.Color(255, 255, 255));
        jum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum.setText("jumlah");
        jum.setToolTipText("");
        kGradientPanel1.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        cari.setBackground(new java.awt.Color(0, 0, 255));
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        kGradientPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 140, 30));

        jPanel16.setBackground(new java.awt.Color(0, 0, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cari");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        kGradientPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        close1.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close1.setForeground(new java.awt.Color(255, 0, 0));
        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setText("X");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jum1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum1.setText("TIdak ada id Barang? Silahkan buka Form barang terlebih dahulu !");
        jum1.setToolTipText("");
        jum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jum1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        setSize(new java.awt.Dimension(797, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbMouseClicked
       try{
            int row = tabelb.rowAtPoint(evt.getPoint());

            pi.tid  = tabelb.getValueAt(row, 0).toString();
            pi.tnama = tabelb.getValueAt(row, 1).toString();
             pi.tjenis = tabelb.getValueAt(row, 2).toString();
             
           //   pi.ttype = tabelb.getValueAt(row, 3).toString();
               pi.tukuran = tabelb.getValueAt(row, 3).toString();
                pi.tmerek = tabelb.getValueAt(row, 4).toString();
               pi.tharga = tabelb.getValueAt(row, 5).toString();
                  pi.tbeli = tabelb.getValueAt(row, 6).toString();
             pi.tstok = tabelb.getValueAt(row, 7).toString();
            pi.itemTerpilih();
           // new barang_masuk().show();
       
 this.dispose();//String d = tabel.getValueAt(row, 3).toString();
            //String e = tabel.getValueAt(row, 4).toString();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Keterangan Error : " + e);

        }         // TODO add your handling code here:
    }//GEN-LAST:event_tabelbMouseClicked

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            tabel1(); }            // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyPressed

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        setColor(jPanel16); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        resetColor(jPanel16);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        tabel1();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
tabeltam();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        //        System.exit(0);
        // TODO add your handling code here:
        //        new barang().show();
       this.dispose();
     
    }//GEN-LAST:event_close1MouseClicked

    private void jum1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jum1MouseClicked
jPanel1.show();   
//// //jPanel17.show();
//dispose();
//dispose();
////new barang_masuk().show();
//new barang_masuk().dispose();
//new barang().show();


     
//dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jum1MouseClicked

    private void jenisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jenisMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisMousePressed

    private void jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisActionPerformed
        if (jenis.getSelectedItem() == "Bad Cover" ){

       //     type.setEnabled(true);

            bmylove.setEnabled(true);
            bbonita.setEnabled(true);
            blady.setEnabled(true);
            bcal.setEnabled(true);
            bsantika.setEnabled(true);
            bin.setEnabled(true);

            smylove.setEnabled(false);
            sbonita.setEnabled(false);
            slady.setEnabled(false);
            scal.setEnabled(false);
            ssan.setEnabled(false);
            sin.setEnabled(false);
            airland.setEnabled(false);
            comforta.setEnabled(false);

            ukuran.setEnabled(false);
            ukuran.setSelectedItem("180x200") ;
           // idd.setEnabled(false);
            //merek.setEnabled(false);

        } else if (jenis.getSelectedItem() == "Selimut (Balmut)" ){

         //   type.setEnabled(false);
         //   type.setSelectedItem("Kelas 1");

            bmylove.setEnabled(false);
            bbonita.setEnabled(false);
            blady.setEnabled(false);
            bcal.setEnabled(false);
            bsantika.setEnabled(false);
            bin.setEnabled(false);

            smylove.setEnabled(true);
            sbonita.setEnabled(true);
            slady.setEnabled(true);
            scal.setEnabled(true);
            ssan.setEnabled(true);
            sin.setEnabled(true);

            airland.setEnabled(false);
            comforta.setEnabled(false);

            ukuran.setEnabled(true);
            //  ukuran.setSelectedItem("180x200") ;
          //  idd.setEnabled(false);
            //merek.setEnabled(false);

        }else if (jenis.getSelectedItem() == "Spring Bad" ){

         //   type.setEnabled(false);
         //   type.setSelectedItem("Kelas 1");

            bmylove.setEnabled(false);
            bbonita.setEnabled(false);
            blady.setEnabled(false);
            bcal.setEnabled(false);
            bsantika.setEnabled(false);
            bin.setEnabled(false);

            smylove.setEnabled(false);
            sbonita.setEnabled(false);
            slady.setEnabled(false);
            scal.setEnabled(false);
            ssan.setEnabled(false);
            sin.setEnabled(false);

            airland.setEnabled(true);
            comforta.setEnabled(true);

            ukuran.setEnabled(true);
            //  ukuran.setSelectedItem("180x200") ;
           // idd.setEnabled(false);
            //merek.setEnabled(false);

        }
        else {
            idd.setText("");
          //  idd.setEnabled(true);
            merek.setEnabled(true);
            merek.setText("");
            ukuran.setEnabled(true);

        }     // TODO add your handling code here:
    }//GEN-LAST:event_jenisActionPerformed

    private void ukuranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ukuranMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ukuranMouseClicked

    private void ukuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukuranActionPerformed
        selimutnih();
        spring();
    }//GEN-LAST:event_ukuranActionPerformed

    private void binActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binActionPerformed
        badcovernih();    // TODO add your handling code here:
    }//GEN-LAST:event_binActionPerformed

    private void bmyloveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmyloveActionPerformed
        badcovernih();    // TODO add your handling code here:
    }//GEN-LAST:event_bmyloveActionPerformed

    private void bbonitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbonitaActionPerformed
        badcovernih();  // TODO add your handling code here:
    }//GEN-LAST:event_bbonitaActionPerformed

    private void bladyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bladyActionPerformed
        badcovernih();       // TODO add your handling code here:
    }//GEN-LAST:event_bladyActionPerformed

    private void bcalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcalActionPerformed
        badcovernih();   // TODO add your handling code here:
    }//GEN-LAST:event_bcalActionPerformed

    private void bsantikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsantikaActionPerformed
        badcovernih();    // TODO add your handling code here:
    }//GEN-LAST:event_bsantikaActionPerformed

    private void smyloveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smyloveActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_smyloveActionPerformed

    private void comfortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfortaActionPerformed
        spring();        // TODO add your handling code here:
    }//GEN-LAST:event_comfortaActionPerformed

    private void ssanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssanActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_ssanActionPerformed

    private void sbonitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbonitaActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sbonitaActionPerformed

    private void sladyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sladyActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sladyActionPerformed

    private void sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sinActionPerformed

    private void scalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scalActionPerformed
        selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_scalActionPerformed

    private void airlandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlandActionPerformed
        spring();        // TODO add your handling code here:
    }//GEN-LAST:event_airlandActionPerformed

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        setColor(jPanel17); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        resetColor(jPanel17);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited

    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
         
        String rp = "Rp. ";
       if (harga.getText() == null || "".equals(harga.getText()) || " ".equals(harga.getText())
            || merek.getText() == null || "".equals(merek.getText()) || " ".equals(merek.getText())
               || namaa.getText() == null || "".equals(namaa.getText()) || " ".equals(namaa.getText())
            || idd.getText() == null || "".equals(idd.getText()) || " ".equals(idd.getText())  
               ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
           
            //simpan ke stok barang
             try {
                 int a = 0;
                stat.executeUpdate("insert into stok_barang values ("
                    + "'" + idd.getText() + "',"
                   + "'" + namaa.getText() + "',"
                   + "'" +  jenis.getSelectedItem()+ "',"
                 
                    + "'" + ukuran.getSelectedItem() + "',"
                    + "'" + merek.getText() + "',"
                    + "'" +  harga.getText() + "',"
                     + "'" + rp+beli.getText() + "',"
                    + "'" + a + "')"
                );

         //       kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
         harga.setText("");
         namaa.setText("");
               // tabel();// Menampilkan isi tabel
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
                int ok = JOptionPane.showConfirmDialog(null,"Lanjutkan?","Konfrimasi lanjutkan simpan barang masuk", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
   //String yype = (String) type.getSelectedItem();
//        rtt.idp  = harga.getText();
//        rtt.typep = (String) type.getSelectedItem();
//        rtt.jenisp = (String) jenis.getSelectedItem();
//        rtt.merekp = merek.getText();
//        rtt.ukuranp = (String) ukuran.getSelectedItem();
//
//        rtt.itemTerpilih();
//        this.dispose();// TODO add your handling code here:
             try {
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
        }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Id barang sudah ada mohon periksa kembali. " + e);
            }
        }
    }//GEN-LAST:event_jPanel17MousePressed

    private void hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_hargaKeyTyped

    private void namaaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_namaaKeyTyped

    private void close2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close2MouseClicked
jPanel1.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_close2MouseClicked

    private void beliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_beliKeyTyped
    char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}   
           // int jum= a+;  
           // TODO add your handling code here:
    }//GEN-LAST:event_beliKeyTyped

    private void beliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_beliKeyPressed
        String baru=beli.getText();
         //   String baru1= jual.getText();
          
       //     int b = Integer.parseInt(baru1);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
           int a = Integer.parseInt(baru);
       if(jenis.getSelectedItem() == "Bad Cover"){
           int aa=35000;
           int jum = a+aa;
            String n=Integer.toString(jum);
            harga.setText("Rp. "+n);
       }else if(jenis.getSelectedItem() == "Selimut (Balmut)" ){
           int aa=25000;
           int jum = a+aa;
                 String n=Integer.toString(jum);
            harga.setText("Rp. "+n);
       }else if(jenis.getSelectedItem() == "Spring Bad" ){
           int aa=250000;
           int jum = a+aa;
                 String n=Integer.toString(jum);
            harga.setText("Rp. "+n);
       }}  // TODO add your handling code here:
    }//GEN-LAST:event_beliKeyPressed
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(255,0,0));
 }

 public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(0,0,255));
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton airland;
    private javax.swing.JRadioButton bbonita;
    private javax.swing.JRadioButton bcal;
    private javax.swing.JTextField beli;
    private javax.swing.JRadioButton bin;
    private javax.swing.JRadioButton blady;
    private javax.swing.JRadioButton bmylove;
    private javax.swing.JRadioButton bsantika;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel close2;
    private javax.swing.JRadioButton comforta;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel idd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JLabel jum;
    private javax.swing.JLabel jum1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel merek;
    private javax.swing.JTextField namaa;
    private javax.swing.JRadioButton sbonita;
    private javax.swing.JRadioButton scal;
    private javax.swing.JRadioButton sin;
    private javax.swing.JRadioButton slady;
    private javax.swing.JRadioButton smylove;
    private javax.swing.JRadioButton ssan;
    private javax.swing.JTable tabelb;
    private javax.swing.JComboBox<String> ukuran;
    // End of variables declaration//GEN-END:variables
}
