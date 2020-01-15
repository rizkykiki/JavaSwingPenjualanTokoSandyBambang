/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jump;

//import admin.barang;
import admin.barang_masuk;
import admin.home;
import admin.stokbarang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class tambahid extends javax.swing.JFrame {
public stokbarang rtt = null;
    /**
     * Creates new form tambahid
     */
    public tambahid() {
        initComponents();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        ukuran = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        idd = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        bin = new javax.swing.JRadioButton();
        bmylove = new javax.swing.JRadioButton();
        bbonita = new javax.swing.JRadioButton();
        blady = new javax.swing.JRadioButton();
        bcal = new javax.swing.JRadioButton();
        bsantika = new javax.swing.JRadioButton();
        merek = new javax.swing.JLabel();
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
        close1 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Jenis");
        jLabel12.setToolTipText("");
        kGradientPanel1.add(jLabel12);
        jLabel12.setBounds(200, 100, 31, 16);

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
        kGradientPanel1.add(jenis);
        jenis.setBounds(280, 100, 140, 20);

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ukuran");
        jLabel27.setToolTipText("");
        kGradientPanel1.add(jLabel27);
        jLabel27.setBounds(190, 140, 41, 16);

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
        kGradientPanel1.add(ukuran);
        ukuran.setBounds(280, 140, 140, 20);

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id Barang");
        jLabel16.setToolTipText("");
        kGradientPanel1.add(jLabel16);
        jLabel16.setBounds(180, 350, 60, 16);

        idd.setBackground(new java.awt.Color(255, 0, 0));
        idd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        idd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iddKeyTyped(evt);
            }
        });
        kGradientPanel1.add(idd);
        idd.setBounds(270, 350, 220, 22);

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Merek Badcover");
        jLabel26.setToolTipText("");
        kGradientPanel1.add(jLabel26);
        jLabel26.setBounds(160, 180, 100, 16);

        buttonGroup2.add(bin);
        bin.setText("Internal");
        bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binActionPerformed(evt);
            }
        });
        kGradientPanel1.add(bin);
        bin.setBounds(470, 210, 63, 23);

        buttonGroup2.add(bmylove);
        bmylove.setText("Mylove");
        bmylove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmyloveActionPerformed(evt);
            }
        });
        kGradientPanel1.add(bmylove);
        bmylove.setBounds(270, 180, 59, 23);

        buttonGroup2.add(bbonita);
        bbonita.setText("Bonita");
        bbonita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbonitaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(bbonita);
        bbonita.setBounds(370, 180, 55, 23);

        buttonGroup2.add(blady);
        blady.setText("Lady Rose");
        blady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bladyActionPerformed(evt);
            }
        });
        kGradientPanel1.add(blady);
        blady.setBounds(470, 180, 75, 23);

        buttonGroup2.add(bcal);
        bcal.setText("California");
        bcal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcalActionPerformed(evt);
            }
        });
        kGradientPanel1.add(bcal);
        bcal.setBounds(270, 210, 71, 23);

        buttonGroup2.add(bsantika);
        bsantika.setText("Santika");
        bsantika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsantikaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(bsantika);
        bsantika.setBounds(370, 210, 61, 23);

        merek.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        merek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merek.setText("ini merek");
        merek.setToolTipText("");
        kGradientPanel1.add(merek);
        merek.setBounds(440, 140, 180, 16);

        buttonGroup2.add(smylove);
        smylove.setText("Mylove");
        smylove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smyloveActionPerformed(evt);
            }
        });
        kGradientPanel1.add(smylove);
        smylove.setBounds(270, 240, 59, 23);

        buttonGroup2.add(comforta);
        comforta.setText("Comforta");
        comforta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfortaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(comforta);
        comforta.setBounds(370, 310, 71, 23);

        buttonGroup2.add(ssan);
        ssan.setText("Santika");
        ssan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssanActionPerformed(evt);
            }
        });
        kGradientPanel1.add(ssan);
        ssan.setBounds(370, 270, 61, 23);

        buttonGroup2.add(sbonita);
        sbonita.setText("Bonita");
        sbonita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbonitaActionPerformed(evt);
            }
        });
        kGradientPanel1.add(sbonita);
        sbonita.setBounds(370, 240, 55, 23);

        buttonGroup2.add(slady);
        slady.setText("Lady Rose");
        slady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sladyActionPerformed(evt);
            }
        });
        kGradientPanel1.add(slady);
        slady.setBounds(470, 240, 75, 23);

        buttonGroup2.add(sin);
        sin.setText("Internal");
        sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinActionPerformed(evt);
            }
        });
        kGradientPanel1.add(sin);
        sin.setBounds(470, 270, 63, 23);

        jLabel29.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Merek Selimut");
        jLabel29.setToolTipText("");
        kGradientPanel1.add(jLabel29);
        jLabel29.setBounds(160, 240, 100, 16);

        buttonGroup2.add(scal);
        scal.setText("California");
        scal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scalActionPerformed(evt);
            }
        });
        kGradientPanel1.add(scal);
        scal.setBounds(270, 270, 71, 23);

        buttonGroup2.add(airland);
        airland.setText("Airland");
        airland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlandActionPerformed(evt);
            }
        });
        kGradientPanel1.add(airland);
        airland.setBounds(270, 310, 59, 23);

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Merek Springbad");
        jLabel30.setToolTipText("");
        kGradientPanel1.add(jLabel30);
        jLabel30.setBounds(150, 310, 100, 16);

        close1.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close1.setForeground(new java.awt.Color(255, 0, 0));
        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setText("X");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(close1);
        close1.setBounds(620, 10, 15, 32);

        jPanel16.setBackground(new java.awt.Color(255, 0, 0));
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
        jLabel24.setText("Lanjutkan");

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

        kGradientPanel1.add(jPanel16);
        jPanel16.setBounds(260, 380, 130, 30);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 654, 454));

        setSize(new java.awt.Dimension(654, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                   idd.setEnabled(false);
                 //merek.setEnabled(false);
   
        } else if (jenis.getSelectedItem() == "Selimut (Balmut)" ){
              
             // type.setEnabled(false);
             // type.setSelectedItem("Kelas 1");
              
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
                   idd.setEnabled(false);
                 //merek.setEnabled(false);
   
        }else if (jenis.getSelectedItem() == "Spring Bad" ){
              
            //  type.setEnabled(false);
             // type.setSelectedItem("Kelas 1");
              
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
                   idd.setEnabled(false);
                 //merek.setEnabled(false);
   
        }
      else {
            idd.setText("");
                idd.setEnabled(true);
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

    private void iddKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iddKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_iddKeyTyped

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

    private void binActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binActionPerformed
       badcovernih();    // TODO add your handling code here:
    }//GEN-LAST:event_binActionPerformed

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        //        System.exit(0);
        // TODO add your handling code here:
//        new barang().show();
        this.dispose();
    }//GEN-LAST:event_close1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        String c= "Bad Cover";
        jenis.setSelectedItem(String.valueOf(c));  // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void smyloveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smyloveActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_smyloveActionPerformed

    private void sbonitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbonitaActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sbonitaActionPerformed

    private void sladyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sladyActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sladyActionPerformed

    private void scalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scalActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_scalActionPerformed

    private void ssanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssanActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_ssanActionPerformed

    private void sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
selimutnih();        // TODO add your handling code here:
    }//GEN-LAST:event_sinActionPerformed

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        resetColor(jPanel16); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        setColor(jPanel16);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(255,0,0));
 }

 public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(255,204,0));
 }
    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
  //String yype = (String) type.getSelectedItem();
        rtt.idp  = idd.getText();
           // rtt.typep = (String) type.getSelectedItem();
             rtt.jenisp = (String) jenis.getSelectedItem();
              rtt.merekp = merek.getText();
               rtt.ukuranp = (String) ukuran.getSelectedItem();
            
            rtt.itemTerpilih();   
            this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void airlandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlandActionPerformed
spring();        // TODO add your handling code here:
    }//GEN-LAST:event_airlandActionPerformed

    private void comfortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfortaActionPerformed
spring();        // TODO add your handling code here:
    }//GEN-LAST:event_comfortaActionPerformed

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
            java.util.logging.Logger.getLogger(tambahid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton airland;
    private javax.swing.JRadioButton bbonita;
    private javax.swing.JRadioButton bcal;
    private javax.swing.JRadioButton bin;
    private javax.swing.JRadioButton blady;
    private javax.swing.JRadioButton bmylove;
    private javax.swing.JRadioButton bsantika;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel close1;
    private javax.swing.JRadioButton comforta;
    private javax.swing.JTextField idd;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JComboBox<String> jenis;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel merek;
    private javax.swing.JRadioButton sbonita;
    private javax.swing.JRadioButton scal;
    private javax.swing.JRadioButton sin;
    private javax.swing.JRadioButton slady;
    private javax.swing.JRadioButton smylove;
    private javax.swing.JRadioButton ssan;
    private javax.swing.JComboBox<String> ukuran;
    // End of variables declaration//GEN-END:variables
}
