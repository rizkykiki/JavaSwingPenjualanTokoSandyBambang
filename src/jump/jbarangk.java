/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jump;

import admin.barang_masuk;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import kasir.kasir;

/**
 *
 * @author pc
 */
public class jbarangk extends javax.swing.JFrame {
private Connection con;
    private Statement stat;
    private ResultSet res;
    private String tgllahir;
       public kasir pil = null;
    /**
     * Creates new form jbarangk
     */
    public jbarangk() {
        initComponents();
         koneksi();
        tabeltam();
        tabel1();
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
     
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Barang");
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
                
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
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
       
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Barang");
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
                  
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
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

        kGradientPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, 634, 256));

        jum.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum.setForeground(new java.awt.Color(255, 255, 255));
        jum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum.setText("jumlah");
        jum.setToolTipText("");
        kGradientPanel1.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        cari.setBackground(new java.awt.Color(255, 0, 0));
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        kGradientPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 146, 140, 30));

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
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        kGradientPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 146, -1, -1));

        close1.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close1.setForeground(new java.awt.Color(255, 0, 0));
        close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close1.setText("X");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jump Barang Kasir");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 650, 40));

        jum1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum1.setForeground(new java.awt.Color(255, 255, 255));
        jum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum1.setText("Perhatikan selalu stok barang !!");
        jum1.setToolTipText("");
        jum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jum1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 450, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 460));

        setSize(new java.awt.Dimension(654, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbMouseClicked
        try{
            int row = tabelb.rowAtPoint(evt.getPoint());

            pil.gid  = tabelb.getValueAt(row, 0).toString();
            pil.gnama = tabelb.getValueAt(row, 1).toString();
            pil.gjenis = tabelb.getValueAt(row, 2).toString();
           
             pil.gukuran = tabelb.getValueAt(row, 3).toString();
                pil.gmerek = tabelb.getValueAt(row, 4).toString();
            pil.gharga = tabelb.getValueAt(row, 5).toString();
            pil.gstok = tabelb.getValueAt(row, 6).toString();
            pil.itemTerpilih3();
          
            this.dispose();//String d = tabel.getValueAt(row, 3).toString();
            //String e = tabel.getValueAt(row, 4).toString();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Keterangan Error : " + e);
        }
        // TODO add your handling code here:
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
        // //jPanel17.show();
        //new barang().show();
        //        this.dispose();
        //dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jum1MouseClicked

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
            java.util.logging.Logger.getLogger(jbarangk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jbarangk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jbarangk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jbarangk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jbarangk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jum;
    private javax.swing.JLabel jum1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tabelb;
    // End of variables declaration//GEN-END:variables
}
