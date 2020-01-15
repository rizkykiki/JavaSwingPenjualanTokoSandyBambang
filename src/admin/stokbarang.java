/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import kasir.transaksi;
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
import jump.tambahid;

/**
 *
 * @author pc
 */
public class stokbarang extends javax.swing.JFrame {

    private Connection con;
    private Statement stat;
    private ResultSet res;
    public String tgllahir;
    String sql;
public String jenisp,merekp,ukuranp,typep,idp;

    public String getJenisp() {
        return jenisp;
    }

    public void setJenisp(String jenisp) {
        this.jenisp = jenisp;
    }

    public String getMerekp() {
        return merekp;
    }

    public void setMerekp(String merekp) {
        this.merekp = merekp;
    }

    public String getUkuranp() {
        return ukuranp;
    }

    public void setUkuranp(String ukuranp) {
        this.ukuranp = ukuranp;
    }

    public String getTypep() {
        return typep;
    }

    public void setTypep(String typep) {
        this.typep = typep;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }
    /**
     * Creates new form stokbarang
     */
    public stokbarang() {
        initComponents();
        kosongkan();
        ClearTabel();
        koneksi();
        tabel();
        tabel1();
         ops.hide();  
         ops1.hide();
    }

public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(51,255,51));
 }
public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(0,0,0));
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
        idd.setText("");
        nama.setText("");
        // jDateChooser2.setDate(null);
        stok.setText("");
        harga.setText("");
        // type.setText("");
        jenis.setText("");
         ukuran.setText("");
        merek.setText("");
        //  autonomor();
        beli.setText("");

        idd.requestFocus();
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
        tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
       // tb.addColumn("Type Barang");
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Jual");
         tb.addColumn("Harga Beli");
        tb.addColumn("Stok Barang");

        tabel.setModel(tb);
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
                //    res.getString("tipe_barang"),
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getString("harga_beli"),
                    res.getString("stokbarang")

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
           tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
       // tb.addColumn("Type Barang");
        tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
        tb.addColumn("Harga Jual");
         tb.addColumn("Harga Beli");
        tb.addColumn("Stok Barang");

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM stok_barang where id_barang like '%" + itemcari + "%' or nama_barang like '%" + itemcari + "%' order by id_barang asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                  //  res.getString("tipe_barang"),
                     res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("harga_barang"),
                    res.getString("harga_beli"),
                    res.getString("stokbarang")
                });
            }
            jumlah = tabel.getRowCount();
            jum.setText(jumlah + " Item");
        } catch (Exception e) {
        }
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        stok = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        merek = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        ukuran = new javax.swing.JTextField();
        jenis = new javax.swing.JTextField();
        ops = new javax.swing.JPanel();
        ido = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        beli = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        ops1 = new javax.swing.JPanel();
        ido1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        students = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tgl.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setText("Stok Barang");
        tgl.setToolTipText("");
        kGradientPanel1.add(tgl);
        tgl.setBounds(280, 50, 480, 50);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 120));

        kGradientPanel2.setEndColor(new java.awt.Color(255, 255, 0));
        kGradientPanel2.setGradientFocus(400);
        kGradientPanel2.setStartColor(new java.awt.Color(255, 0, 153));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stok.setEditable(false);
        stok.setBackground(new java.awt.Color(0, 0, 0));
        stok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stok.setForeground(new java.awt.Color(255, 255, 255));
        stok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stokKeyTyped(evt);
            }
        });
        jPanel1.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 170, -1));

        nama.setBackground(new java.awt.Color(0, 0, 0));
        nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        harga.setBackground(new java.awt.Color(0, 0, 0));
        harga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 255));
        harga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKeyTyped(evt);
            }
        });
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 170, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Stok Barang");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 100, 20));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Jenis Barang");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 100, 20));

        idd.setEditable(false);
        idd.setBackground(new java.awt.Color(0, 0, 0));
        idd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idd.setForeground(new java.awt.Color(255, 255, 255));
        idd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        idd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iddActionPerformed(evt);
            }
        });
        jPanel1.add(idd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 170, -1));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Harga Barang");
        jLabel17.setToolTipText("");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 100, 20));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
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

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel13MousePressed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Edit Data");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 130, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
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

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nama Barang");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 20));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Merek");
        jLabel26.setToolTipText("");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

        merek.setEditable(false);
        merek.setBackground(new java.awt.Color(0, 0, 0));
        merek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        merek.setForeground(new java.awt.Color(255, 255, 255));
        merek.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        merek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                merekKeyTyped(evt);
            }
        });
        jPanel1.add(merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 170, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Ukuran");
        jLabel27.setToolTipText("");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        ukuran.setEditable(false);
        ukuran.setBackground(new java.awt.Color(0, 0, 0));
        ukuran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ukuran.setForeground(new java.awt.Color(255, 255, 255));
        ukuran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 170, -1));

        jenis.setEditable(false);
        jenis.setBackground(new java.awt.Color(0, 0, 0));
        jenis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jenis.setForeground(new java.awt.Color(255, 255, 255));
        jenis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 170, -1));

        ops.setBackground(new java.awt.Color(0, 0, 0));
        ops.setForeground(new java.awt.Color(255, 255, 255));

        ido.setBackground(new java.awt.Color(0, 0, 0));
        ido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ido.setForeground(new java.awt.Color(255, 255, 255));
        ido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        ido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idoKeyTyped(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Cetak berdasarkan :");
        jLabel37.setToolTipText("");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel37MousePressed(evt);
            }
        });

        javax.swing.GroupLayout opsLayout = new javax.swing.GroupLayout(ops);
        ops.setLayout(opsLayout);
        opsLayout.setHorizontalGroup(
            opsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opsLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(opsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ido)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        opsLayout.setVerticalGroup(
            opsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ops, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 200, 70));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Opsi Cetak Laporan");
        jLabel39.setToolTipText("");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 170, -1));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel18MousePressed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Cetak laporan");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Id Barang");
        jLabel21.setToolTipText("");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 100, 20));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Hapus");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        beli.setBackground(new java.awt.Color(0, 0, 0));
        beli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beli.setForeground(new java.awt.Color(255, 255, 255));
        beli.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                beliKeyTyped(evt);
            }
        });
        jPanel1.add(beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 170, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Harga Beli");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 100, -1));

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Cetak laporan  stok perbulan");
        jLabel38.setToolTipText("");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel38MousePressed(evt);
            }
        });
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        ops1.setBackground(new java.awt.Color(0, 0, 0));
        ops1.setForeground(new java.awt.Color(255, 255, 255));

        ido1.setBackground(new java.awt.Color(0, 0, 0));
        ido1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ido1.setForeground(new java.awt.Color(255, 255, 255));
        ido1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        ido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ido1KeyTyped(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Cetak stok perbulan");
        jLabel40.setToolTipText("");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel40MousePressed(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(0, 0, 0));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel19MousePressed(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Cetak laporan");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ops1Layout = new javax.swing.GroupLayout(ops1);
        ops1.setLayout(ops1Layout);
        ops1Layout.setHorizontalGroup(
            ops1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ops1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(ops1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ops1Layout.createSequentialGroup()
                        .addGroup(ops1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ido1)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ops1Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        ops1Layout.setVerticalGroup(
            ops1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ops1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ops1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, 100));

        kGradientPanel2.add(jPanel1);
        jPanel1.setBounds(50, 30, 950, 290);

        students.setBackground(new java.awt.Color(0, 0, 0));
        students.setForeground(new java.awt.Color(255, 255, 255));
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
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
        jum.setForeground(new java.awt.Color(255, 255, 255));
        jum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jum.setText("jumlah");
        jum.setToolTipText("");
        students.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        cari.setBackground(new java.awt.Color(0, 0, 0));
        cari.setForeground(new java.awt.Color(255, 255, 255));
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

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 590));

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        setState(ICONIFIED);
    }//GEN-LAST:event_closeMouseClicked

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
new home().show();
        this.dispose();//        System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_close1MouseClicked

    private void iddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iddActionPerformed

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        setColor(jPanel12);       //  setColor(jPanel12);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        resetColor(jPanel12);   ///  resetColor(jPanel12); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MousePressed
        ClearTabel();   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MousePressed

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        setColor(jPanel13); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseExited
        resetColor(jPanel13);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseExited

    private void jPanel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MousePressed

        if (nama.getText() == null || "".equals(nama.getText()) || " ".equals(nama.getText())
          //  || type.getText() == null || "".equals(type.getText()) || " ".equals(type.getText())
            || idd.getText() == null || "".equals(idd.getText()) || " ".equals(idd.getText()) 
                || harga.getText() == null || "".equals(harga.getText()) || " ".equals(harga.getText())
                || stok.getText() == null || "".equals(stok.getText()) || " ".equals(stok.getText())) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
            try {
                stat.executeUpdate("update stok_barang set "
                        //   + "id_peg='" + idperpus.getText() + "',"
                        + "nama_barang='" + nama.getText() + "',"
//                        + "jenis_barang='" + jenis.getText() + "',"
//                        + "tipe_barang='" + type.getText()+ "',"
                        + "harga_barang='" + harga.getText() + "',"
                          + "harga_beli='" + beli.getText() + "',"       
                        + "stokbarang='" + stok.getText() + "'"
                        + " where "
                        + "id_barang='" + idd.getText() + "'"
                );
              //  kosongkan();
                tabel();
                 JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }  try {
                stat.executeUpdate("update barang_masuk set "
                        //   + "id_peg='" + idperpus.getText() + "',"
                        + "nama_barang='" + nama.getText() + "',"
//                        + "jenis_barang='" + jenis.getText() + "',"
//                        + "tipe_barang='" + type.getText()+ "',"
                   //     + "harga_barang='" + harga.getText() + "',"
                          + "harga_beli='" + beli.getText() + "'"       
                   //     + "stokbarang='" + stok.getText() + "'"
                        + " where "
                        + "id_barang='" + idd.getText() + "'"
                );
                kosongkan();
                tabel();
                 JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
//            try {
//                stat.executeUpdate("update barang set "
//                        //   + "id_peg='" + idperpus.getText() + "',"
//                        + "nama_barang='" + nama.getText() + "',"
//                    //    + "jenis_barang='" + jenis.getText() + "',"
//                     //   + "tipe_barang='" + type.getText() + "',"
//                        + "harga_barang='" + harga.getText() + "'"
//                        + " where "
//                        + "id_barang='" + idd.getText() + "'"
//                );
//                kosongkan();
//                tabel();
//                JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
//            }
        }
    }//GEN-LAST:event_jPanel13MousePressed

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        setColor(jPanel11);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        resetColor(jPanel11);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        tabel();
        // autonomor();
        kosongkan();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

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
        try {
            int row = tabel.rowAtPoint(evt.getPoint());

            String a = tabel.getValueAt(row, 0).toString();
            String b = tabel.getValueAt(row, 1).toString();
            String c = tabel.getValueAt(row, 2).toString();
            String d = tabel.getValueAt(row, 3).toString();
            String e = tabel.getValueAt(row, 4).toString();
            String f = tabel.getValueAt(row, 5).toString();
             String g = tabel.getValueAt(row, 6).toString();
              String h = tabel.getValueAt(row, 7).toString();
            idd.setText(String.valueOf(a));
            nama.setText(String.valueOf(b));
               jenis.setText(String.valueOf(c));
                ukuran.setText(String.valueOf(d));
            merek.setText(String.valueOf(e));
            harga.setText(String.valueOf(f));
            //  buttonGroup1.setSelected(valueOf(d));
          beli.setText(String.valueOf(g));
         //   type.setText(String.valueOf(d));
           
            stok.setText(String.valueOf(h));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);

        }          // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_stokKeyTyped

    private void hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_hargaKeyTyped

    private void merekKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_merekKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_merekKeyTyped

    private void idoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idoKeyTyped

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        ops.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        setColor(jPanel18);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        resetColor(jPanel18); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited
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
    private void jPanel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MousePressed
         pola = "EEEE+dd+MMMM+yyyy";
        
                hasil = stokbarang.tampilkanTanggalDanWaktu(tanggalDanWaktu,pola,lokal);
                String aa =  hasil ;
                String gg= "http://localhost/tokosb/stok_barang.php?id="+ido.getText();
             // String gg= "http://localhost/tokosb/printid.php?id="+ido.getText();
                String gg1="&idu="+aa;
             //   String ide= ido.getText();// TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try {
              Desktop.getDesktop().browse(new URI(gg+gg1));   //  Desktop.getDesktop().browse(new URI("http://localhost/tokosb/stok_barang.php?id="+ido.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jPanel18MousePressed
public void itemTerpilih(){
        tambahid cr = new tambahid();
        cr.rtt = this;
        idd.setText(idp);
        jenis.setText(jenisp);
        ukuran.setText(ukuranp);
        merek.setText(merekp);
     //   type.setText(typep);
        
        
    }
    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        setColor(jPanel10);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetColor(jPanel10);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed

        String rp = "Rp. ";
        if (nama.getText() == null || "".equals(nama.getText()) || " ".equals(nama.getText())
            || merek.getText() == null || "".equals(merek.getText()) || " ".equals(merek.getText())
            || harga.getText() == null || "".equals(harga.getText()) || " ".equals(harga.getText())
            || idd.getText() == null || "".equals(idd.getText()) || " ".equals(idd.getText())
        ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
       int ok = JOptionPane.showConfirmDialog(null,"hapus?","Konfrimasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){         
            try {
                stat.executeUpdate("delete from stok_barang where "
                    + "id_barang='" + idd.getText() + "'"
                );
                kosongkan();
                tabel();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }

        }  
        
        }
    }//GEN-LAST:event_jPanel10MousePressed

    private void beliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_beliKeyTyped
      char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}    // TODO add your handling code here:
    }//GEN-LAST:event_beliKeyTyped

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
ops.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MousePressed

    private void jLabel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MousePressed
ops1.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MousePressed

    private void ido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ido1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ido1KeyTyped

    private void jLabel40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MousePressed
ops1.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MousePressed

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
     setColor(jPanel19);      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
        resetColor(jPanel19);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseExited

    private void jPanel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MousePressed
       pola = "EEEE+dd+MMMM+yyyy";
        
                hasil = stokbarang.tampilkanTanggalDanWaktu(tanggalDanWaktu,pola,lokal);
                String aa =  hasil ;
                String gg= "http://localhost/tokosb/stokbulanan.php?id="+ido1.getText();
             // String gg= "http://localhost/tokosb/printid.php?id="+ido.getText();
                String gg1="&idu="+aa;
             //   String ide= ido.getText();// TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try {
              Desktop.getDesktop().browse(new URI(gg+gg1));   //  Desktop.getDesktop().browse(new URI("http://localhost/tokosb/stok_barang.php?id="+ido.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MousePressed

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
            java.util.logging.Logger.getLogger(stokbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stokbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stokbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stokbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stokbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beli;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField idd;
    private javax.swing.JTextField ido;
    private javax.swing.JTextField ido1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jenis;
    private javax.swing.JLabel jum;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField merek;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel ops;
    private javax.swing.JPanel ops1;
    private javax.swing.JTextField stok;
    private javax.swing.JPanel students;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField ukuran;
    // End of variables declaration//GEN-END:variables
}
