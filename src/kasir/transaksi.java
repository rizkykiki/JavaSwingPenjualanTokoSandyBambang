/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

import admin.home;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author pc
 */
public class transaksi extends javax.swing.JFrame {
 private Connection con;
    private Statement stat;
    private ResultSet res;
    public String tgllahir;
    String sql;
    /**
     * Creates new form transaksi
     */
    public transaksi() {
        initComponents();
         kosongkan();
        ClearTabel();
        koneksi();
        tabel();
        tabel1();
        jPanel2.hide();
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
        idt.setText("");
        idp.setText("");
        alamatp.setText("");
      // jDateChooser2.setDate(null);
       idb.setText("");
        ukuran.setText("");
         harga.setText("");
        namap.setText("");
    //    typeb.setText("");
        merek.setText("");
        jenisb.setText("");
        namab.setText("");
         kembalian.setText("");
        kuantitas.setText("");
        tgl.setText("");
        total.setText("");
        cash.setText("");
        st.setText("");
        
         // jDateChooser2.setDate(null);
        //  autonomor();
        
        kuantitas.requestFocus();
    }
  private void ClearTabel() {
        int cb = tabel.getRowCount();
        int cc = tabel.getColumnCount();
        for (int i = 0; i < cb; i++) {
            for (int j = 0; j < cc; j++) {
                tabel.setValueAt(null, i, j);
            }
        }
    }
  private void tabel() {
        int jumlah = 0;
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
           tb.addColumn("ID Transaksi");
        tb.addColumn("ID Pembeli");
        tb.addColumn("Nama Pembeli");
        tb.addColumn("Alamat Pembeli");
        tb.addColumn("Tanggal");
        tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
      
          tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Barang");
        tb.addColumn("Kuantitas");
        tb.addColumn("Total");
        tb.addColumn("Cash");
        tb.addColumn("Kembalian");
      

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from transaksi");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                  res.getString("id_trans"),
                    res.getString("id_pembeli"),
                    res.getString("nama_pembeli"),
                    res.getString("alamat_pembeli"),
                    res.getString("tanggal"),
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                  
                        res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getInt("kuantitas"),
                    res.getString("total"),
                    res.getString("cash"),
                    res.getString("kembalian")
                 

                });
            }
            jumlah = tabel.getRowCount();
            jum.setText(jumlah + " Item");
        } catch (Exception e) {
        }
    }
   private void tabel1() {
        int jumlah = 0;
        String itemcari = cari.getText();
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
          tb.addColumn("ID Transaksi");
        tb.addColumn("ID Pembeli");
        tb.addColumn("Nama Pembeli");
        tb.addColumn("Alamat Pembeli");
        tb.addColumn("Tanggal");
        tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
      
          tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Barang");
        tb.addColumn("Kuantitas");
        tb.addColumn("Total");
        tb.addColumn("Cash");
        tb.addColumn("Kembalian");
       

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM transaksi where id_trans like '%" + itemcari + "%' or id_pembeli like '%" + itemcari + "%' order by id_barang asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                 res.getString("id_trans"),
                    res.getString("id_pembeli"),
                    res.getString("nama_pembeli"),
                    res.getString("alamat_pembeli"),
                    res.getString("tanggal"),
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                  
                        res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getInt("kuantitas"),
                    res.getString("total"),
                    res.getString("cash"),
                    res.getString("kembalian")

                });
            }
            jumlah = tabel.getRowCount();
            jum.setText(jumlah + " Item");
        } catch (Exception e) {
        }
    }
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(51,255,51));
 }
public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(0,0,0));
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        students = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        namap = new javax.swing.JTextField();
        alamatp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idb = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        kuantitas = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        st = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        namab = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        idp = new javax.swing.JTextField();
        tgl = new javax.swing.JLabel();
        jenisb = new javax.swing.JTextField();
        ukuran = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        merek = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ido = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        tgl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setGradientFocus(400);
        kGradientPanel2.setStartColor(new java.awt.Color(255, 0, 153));

        students.setBackground(new java.awt.Color(0, 0, 0));
        students.setForeground(new java.awt.Color(255, 255, 255));
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel16.setForeground(java.awt.Color.white);
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

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
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

        students.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jum.setBackground(new java.awt.Color(0, 0, 0));
        jum.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jum.setForeground(java.awt.Color.white);
        jum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum.setText("jumlah");
        jum.setToolTipText("");
        students.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        cari.setBackground(new java.awt.Color(0, 0, 0));
        cari.setForeground(java.awt.Color.white);
        cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 204)));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        students.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 120, 30));

        kGradientPanel2.add(students);
        students.setBounds(230, 330, 570, 30);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        tabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel.setForeground(new java.awt.Color(51, 51, 51));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.setGridColor(new java.awt.Color(255, 255, 255));
        tabel.setRowHeight(20);
        tabel.setSelectionBackground(new java.awt.Color(1, 198, 83));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel);

        kGradientPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 360, 1010, 210);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namap.setBackground(new java.awt.Color(0, 0, 0));
        namap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namap.setForeground(java.awt.Color.white);
        namap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(namap, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, -1));

        alamatp.setBackground(new java.awt.Color(0, 0, 0));
        alamatp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alamatp.setForeground(java.awt.Color.white);
        alamatp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(alamatp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Id Pembeli");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tanggal");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 100, 20));

        idt.setEditable(false);
        idt.setBackground(new java.awt.Color(0, 0, 0));
        idt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idt.setForeground(java.awt.Color.white);
        idt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        idt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtActionPerformed(evt);
            }
        });
        jPanel1.add(idt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id Transaksi");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel12.setForeground(java.awt.Color.white);
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel12MousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Clear Tabel");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel15.setForeground(java.awt.Color.white);
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Hapus");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel11.setForeground(java.awt.Color.white);
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Refresh");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nama Pembeli");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Alamat Pembeli");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Id Barang");
        jLabel18.setToolTipText("");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 20));

        idb.setBackground(new java.awt.Color(0, 0, 0));
        idb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idb.setForeground(java.awt.Color.white);
        idb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(idb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setForeground(java.awt.Color.white);
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Kuantitas");
        jLabel27.setToolTipText("");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 100, 20));

        kuantitas.setBackground(new java.awt.Color(0, 0, 0));
        kuantitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kuantitas.setForeground(java.awt.Color.white);
        kuantitas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        kuantitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kuantitasKeyTyped(evt);
            }
        });
        jPanel1.add(kuantitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 170, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setForeground(java.awt.Color.white);
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Total");
        jLabel28.setToolTipText("");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 100, 20));

        total.setBackground(new java.awt.Color(0, 0, 0));
        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setForeground(java.awt.Color.white);
        total.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalKeyTyped(evt);
            }
        });
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 170, -1));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel29.setForeground(java.awt.Color.white);
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Cash");
        jLabel29.setToolTipText("");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 100, 20));

        cash.setBackground(new java.awt.Color(0, 0, 0));
        cash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cash.setForeground(java.awt.Color.white);
        cash.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashKeyTyped(evt);
            }
        });
        jPanel1.add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 170, -1));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel30.setForeground(java.awt.Color.white);
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Kembalian");
        jLabel30.setToolTipText("");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 100, 20));

        kembalian.setBackground(new java.awt.Color(0, 0, 0));
        kembalian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kembalian.setForeground(java.awt.Color.white);
        kembalian.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        kembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kembalianKeyTyped(evt);
            }
        });
        jPanel1.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 170, -1));

        st.setBackground(new java.awt.Color(0, 0, 0));
        st.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        st.setForeground(java.awt.Color.white);
        st.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st.setText("Harga");
        st.setToolTipText("");
        st.setEnabled(false);
        jPanel1.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 20));

        harga.setBackground(new java.awt.Color(0, 0, 0));
        harga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        harga.setForeground(java.awt.Color.white);
        harga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKeyTyped(evt);
            }
        });
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 170, -1));

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel32.setForeground(java.awt.Color.white);
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Nama Barang");
        jLabel32.setToolTipText("");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 20));

        namab.setBackground(new java.awt.Color(0, 0, 0));
        namab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namab.setForeground(new java.awt.Color(255, 255, 255));
        namab.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(namab, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, -1));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel33.setForeground(java.awt.Color.white);
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Jenis Barang");
        jLabel33.setToolTipText("");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 20));

        idp.setBackground(new java.awt.Color(0, 0, 0));
        idp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idp.setForeground(java.awt.Color.white);
        idp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, -1));

        tgl.setBackground(new java.awt.Color(0, 0, 0));
        tgl.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tgl.setForeground(java.awt.Color.white);
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setText("Tanggal");
        tgl.setToolTipText("");
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 100, 20));

        jenisb.setBackground(new java.awt.Color(0, 0, 0));
        jenisb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jenisb.setForeground(java.awt.Color.white);
        jenisb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(jenisb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 170, -1));

        ukuran.setBackground(new java.awt.Color(0, 0, 0));
        ukuran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ukuran.setForeground(java.awt.Color.white);
        ukuran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        ukuran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ukuranKeyTyped(evt);
            }
        });
        jPanel1.add(ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, -1));

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel34.setForeground(java.awt.Color.white);
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Ukuran");
        jLabel34.setToolTipText("");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 100, -1));

        merek.setBackground(new java.awt.Color(0, 0, 0));
        merek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        merek.setForeground(java.awt.Color.white);
        merek.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        merek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                merekKeyTyped(evt);
            }
        });
        jPanel1.add(merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 170, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(java.awt.Color.white);

        ido.setBackground(new java.awt.Color(0, 0, 0));
        ido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ido.setForeground(new java.awt.Color(255, 255, 255));
        ido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        ido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idoKeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Cetak berdasarkan  :");
        jLabel37.setToolTipText("");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel37MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 200, 70));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel17.setForeground(java.awt.Color.white);
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

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Cetak laporan");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel38.setForeground(java.awt.Color.white);
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Merek");
        jLabel38.setToolTipText("");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, -1));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel39.setForeground(java.awt.Color.white);
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Opsi Cetak Laporan");
        jLabel39.setToolTipText("");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 170, -1));

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel35.setForeground(java.awt.Color.white);
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Harga");
        jLabel35.setToolTipText("");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 100, 20));

        kGradientPanel2.add(jPanel1);
        jPanel1.setBounds(30, 30, 970, 290);

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 590));

        kGradientPanel1.setEndColor(new java.awt.Color(0, 255, 255));

        close.setFont(new java.awt.Font("Segoe WP", 0, 24)); // NOI18N
        close.setForeground(new java.awt.Color(255, 0, 0));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("-");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        kGradientPanel1.add(close);
        close.setBounds(950, 10, 8, 32);

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
        close1.setBounds(980, 10, 15, 32);

        tgl1.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        tgl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl1.setText("Data Transaksi");
        tgl1.setToolTipText("");
        kGradientPanel1.add(tgl1);
        tgl1.setBounds(270, 40, 480, 50);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 120));

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        setColor(jPanel16); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        resetColor(jPanel16);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        tabel1();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MousePressed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tabel1();
        }                    // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyPressed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        
          try{
            int row = tabel.rowAtPoint(evt.getPoint());

            String a = tabel.getValueAt(row, 0).toString();
            String b = tabel.getValueAt(row, 1).toString();
            String c = tabel.getValueAt(row, 2).toString();
            String d = tabel.getValueAt(row, 3).toString();
            String e = tabel.getValueAt(row, 4).toString();
            String f = tabel.getValueAt(row, 5).toString();
            String g = tabel.getValueAt(row, 6).toString();
             String h = tabel.getValueAt(row, 7).toString();
             
               
              String j = tabel.getValueAt(row, 8).toString();
            String k = tabel.getValueAt(row, 9).toString();
            String l = tabel.getValueAt(row, 10).toString();
            String m = tabel.getValueAt(row, 11).toString();
             String n = tabel.getValueAt(row, 12).toString();
               String o = tabel.getValueAt(row, 13).toString();
             String p = tabel.getValueAt(row, 14).toString();
              idt.setText(String.valueOf(a));
            idp.setText(String.valueOf(b));
            namap.setText(String.valueOf(c));
            alamatp.setText(String.valueOf(d));
            //  buttonGroup1.setSelected(valueOf(d));
            tgl.setText(String.valueOf(e));
            idb.setText(String.valueOf(f));
            namab.setText(String.valueOf(g));
              jenisb.setText(String.valueOf(h));
             
              ukuran.setText(String.valueOf(j));
              merek.setText(String.valueOf(k));
              harga.setText(String.valueOf(l));
              kuantitas.setText(String.valueOf(m));
              total.setText(String.valueOf(n));
              cash.setText(String.valueOf(o));
              kembalian.setText(String.valueOf(p));
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);

        }    
            try
            {
                sql="select * from stok_barang where id_barang='"+idb.getText()+"'";
                stat=con.createStatement();
                res=stat.executeQuery(sql);

                if (res.next())
                { // JOptionPane.showMessageDialog(rootPane, "data ketemu nih");
                    st.setText(res.getString("stokbarang"));
                    
                   
                }
                 
                else{
                   //  JOptionPane.showMessageDialog(rootPane, "silakan masukkan kembali");
                     kosongkan();
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }    // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        setState(ICONIFIED);
    }//GEN-LAST:event_closeMouseClicked

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
      new menukasir().show(); this.dispose();//  System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_close1MouseClicked

    private void idtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtActionPerformed

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        setColor(jPanel12);       //  setColor(jPanel12);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        resetColor(jPanel12);   ///  resetColor(jPanel12); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        ClearTabel();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        setColor(jPanel15);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        resetColor(jPanel15); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        int ok = JOptionPane.showConfirmDialog(null,"Yakin mau hapus trnasaksi ? stok akan di kembalikan?","Konfrimasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
                  String baru=kuantitas.getText();
            String baru1= st.getText();
            int a1 = Integer.parseInt(baru);
            int b2 = Integer.parseInt(baru1);
            int jumk= a1+b2;
            
            String nm=Integer.toString(jumk);
            
            try {
                stat.executeUpdate("update stok_barang set "
                        //   + "id_peg='" + idperpus.getText() + "',"
                      //  + "nama_barang='" + nama.getText() + "',"
                       // + "jenis_barang='" + jenis.getText() + "',"
           //             + "tipe_barang='" + type.getText() + "',"
                       // + "harga_barang='" + harga.getText() + "',"
                     //   + "harga_beli='" +rp + beli.getText() + "',"
                        + "stokbarang='" + nm + "'"
                        + " where "
                        + "id_barang='" + idb.getText() + "'"
                );
               // kosongkan();
                tabel();
               // JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
            try {
                stat.executeUpdate("delete from transaksi where "
                    + "id_trans='" + idt.getText() + "'"
                );
                kosongkan();
                tabel();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
           
        }// TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        setColor(jPanel11);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        resetColor(jPanel11);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        tabel();
//        autonomor();
        kosongkan();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed
 private void export() {

        FileWriter fileWriter;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("export_output/excel"));

        int retrival = chooser.showSaveDialog(null);

        if (retrival == JFileChooser.APPROVE_OPTION) {

            try {

                TableModel tModel = tabel.getModel();

                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xls"));

                // write header
                for (int i = 0; i < tModel.getColumnCount(); i++) {

                    fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");

                }

                fileWriter.write("\n");

                // write record
                for (int i = 0; i < tModel.getRowCount(); i++) {

                    for (int j = 0; j < tModel.getColumnCount(); j++) {

                        fileWriter.write(tModel.getValueAt(i, j).toString() + "\t");

                    }

                    fileWriter.write("\n");

                }

                fileWriter.close();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }

        }

    }

    private void hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_hargaKeyTyped

    private void kuantitasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kuantitasKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_kuantitasKeyTyped

    private void totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_totalKeyTyped

    private void cashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_cashKeyTyped

    private void kembalianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kembalianKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_kembalianKeyTyped

    private void ukuranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ukuranKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ukuranKeyTyped

    private void merekKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_merekKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_merekKeyTyped

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        setColor(jPanel17);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        resetColor(jPanel17); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited
String pola = null;
        Locale lokal = null;
        String hasil = null;
         Date tanggalDanWaktu = new Date();
          protected static String tampilkanTanggalDanWaktu(Date tanggalDanWaktu,
            String pola, Locale lokal) {
      String tanggalStr = null;
        SimpleDateFormat formatter = null;
        if (lokal == null) {
            formatter = new SimpleDateFormat(pola);
        } else {
            formatter = new SimpleDateFormat(pola, lokal);
        }
 
        tanggalStr = formatter.format(tanggalDanWaktu);
        return tanggalStr;
 }
    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
     
  pola = "EEEE+dd+MMMM+yyyy";
        
                hasil = transaksi.tampilkanTanggalDanWaktu(tanggalDanWaktu,pola,lokal);
                String aa =  hasil ;
                String gg= "http://localhost/tokosb/datatransaksi2.php?id="+ido.getText();
             // String gg= "http://localhost/tokosb/printid.php?id="+ido.getText();
                String gg1="&idu="+aa;
             //   String ide= ido.getText();
           
// TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try {
               // Desktop.getDesktop().browse(new URI("http://localhost/tokosb/datatransaksi2.php?id="+ido.getText()));
                    Desktop.getDesktop().browse(new URI(gg+gg1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jPanel17MousePressed

    private void idoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idoKeyTyped

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
  jPanel2.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
   jPanel2.hide();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MousePressed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatp;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField cash;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField idb;
    private javax.swing.JTextField ido;
    private javax.swing.JTextField idp;
    private javax.swing.JTextField idt;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jenisb;
    private javax.swing.JLabel jum;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField kuantitas;
    private javax.swing.JTextField merek;
    private javax.swing.JTextField namab;
    private javax.swing.JTextField namap;
    private javax.swing.JLabel st;
    private javax.swing.JPanel students;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tgl1;
    private javax.swing.JTextField total;
    private javax.swing.JTextField ukuran;
    // End of variables declaration//GEN-END:variables
}
