/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jump;

import admin.barang_masuk;
//import admin.pemesanan;
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
public class jdistributor extends javax.swing.JFrame {
private Connection con;
    private Statement stat;
    private ResultSet res;
    private String tgllahir;
       public barang_masuk kog = null;
    /** Creates new form jdistributor */
    public jdistributor() {
        initComponents();
          koneksi();
        tabeltam();
        tabel1();
        kosongkan();
        autonomor();
        jPanel1.hide();
    }
    public void autonomor() {
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM distributor ORDER BY id_distributor DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_distributor").substring(3);
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
                id.setText("DST" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                id.setText("DST0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
      private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            stat = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);
        }
    }
private void kosongkan() {
        id.setText("");
        tlp.setText("");
      // jDateChooser2.setDate(null);
        alamat.setText("");
         nama.setText("");
          autonomor();
        
        id.requestFocus();
    }
 
     private void tabeltam() {
          int jumlah = 0;
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
       tb.addColumn("ID Distributor");
        tb.addColumn("Nama Distributor");
        tb.addColumn("Telepon");
        tb.addColumn("Alamat");
       
        
        tabelb.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from distributor");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                     res.getString("id_distributor"),
                    res.getString("nama_distributor"),
                    res.getString("tlp_distributor"),
                    res.getString("alamat_distributor")
                    
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
         tb.addColumn("ID Distributor");
        tb.addColumn("Nama Distributor");
        tb.addColumn("Telepon");
        tb.addColumn("Alamat");
       

        tabelb.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM distributor where id_distributor like '%" + itemcari + "%' or nama_distributor like '%" + itemcari + "%' order by id_distributor asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_distributor"),
                    res.getString("nama_distributor"),
                    res.getString("tlp_distributor"),
                    res.getString("alamat_distributor")

                });
            }
            jumlah = tabelb.getRowCount();
            jum.setText(jumlah + " Item");
        } catch (Exception e) {
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelb = new javax.swing.JTable();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jum1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tlp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        kGradientPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, 634, 160));

        jum.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum.setForeground(new java.awt.Color(255, 255, 255));
        jum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum.setText("jumlah");
        jum.setToolTipText("");
        kGradientPanel1.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        cari.setBackground(new java.awt.Color(255, 0, 0));
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        kGradientPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 140, 30));

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
        jLabel24.setText("Cari");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(48, 48, 48))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        kGradientPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        close1.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close1.setForeground(new java.awt.Color(255, 0, 0));
        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setText("X");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jump Distributor");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 650, 50));

        jum1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum1.setForeground(new java.awt.Color(255, 255, 255));
        jum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum1.setText("TIdak ada nama Distributor? Klik disini !");
        jum1.setToolTipText("");
        jum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jum1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id Distributor");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 0, 0));
        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nama Distributor");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        nama.setBackground(new java.awt.Color(255, 0, 0));
        nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Telepon Distributor");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 20));

        tlp.setBackground(new java.awt.Color(255, 0, 0));
        tlp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tlp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        tlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlpKeyTyped(evt);
            }
        });
        jPanel1.add(tlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        alamat.setBackground(new java.awt.Color(255, 0, 0));
        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alamat.setRows(5);
        alamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jScrollPane1.setViewportView(alamat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 270, 80));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Alamat Distributor");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 110, 20));

        jPanel10.setBackground(new java.awt.Color(255, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Simpan");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 650, 130));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 460));

        setSize(new java.awt.Dimension(654, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbMouseClicked
        try{
            int row = tabelb.rowAtPoint(evt.getPoint());

            kog.tidd  = tabelb.getValueAt(row, 0).toString();
            kog.tnamad = tabelb.getValueAt(row, 1).toString();
            kog.ttlp = tabelb.getValueAt(row, 2).toString();
            kog.talamat = tabelb.getValueAt(row, 3).toString();
           
            kog.itemTerpilih1();
            this.dispose();//String d = tabel.getValueAt(row, 3).toString();
            //String e = tabel.getValueAt(row, 4).toString();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Keterangan Error : " + e);

        }         // TODO add your handling code here:
    }//GEN-LAST:event_tabelbMouseClicked
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(255,0,0));
 }

 public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(255,204,0));
 }
    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            tabel1(); }            // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyPressed

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        resetColor(jPanel16); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        setColor(jPanel16);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        tabel1();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        //        System.exit(0);
        // TODO add your handling code here:
        //        new barang().show();
        this.dispose();
    }//GEN-LAST:event_close1MouseClicked

    private void jum1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jum1MouseClicked
        jPanel1.show();// TODO add your handling code here:
    }//GEN-LAST:event_jum1MouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void tlpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlpKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_tlpKeyTyped

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        setColor(jPanel10);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetColor(jPanel10);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed

        if (tlp == null || "".equals(tlp) || " ".equals(tlp)
            || nama == null || "".equals(nama) || " ".equals(nama)
            || alamat == null || "".equals(alamat) || " ".equals(alamat)  ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
            try {
                stat.executeUpdate("insert into distributor values ("
                    + "'" + id.getText() + "',"
                    + "'" + nama.getText() + "',"
                    + "'" + tlp.getText()+ "',"
                    + "'" + alamat.getText() + "')"
                );

                kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
                tabeltam();// Menampilkan isi tabel
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }

        }
    }//GEN-LAST:event_jPanel10MousePressed

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
            java.util.logging.Logger.getLogger(jdistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdistributor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdistributor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close1;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jum;
    private javax.swing.JLabel jum1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabelb;
    private javax.swing.JTextField tlp;
    // End of variables declaration//GEN-END:variables

}
