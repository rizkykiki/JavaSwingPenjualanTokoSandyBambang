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
public class pembeli extends javax.swing.JFrame {
private Connection con;
    private Statement stat;
    private ResultSet res;
    public String tgllahir;
    String sql;
    /**
     * Creates new form pembeli
     */
    public pembeli() {
        initComponents();
          kosongkan();
        ClearTabel();
        koneksi();
        tabel();
        tabel1();
  ops.hide(); 
        autonomor();
    }
public void autonomor() {
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM pembeli ORDER BY id_pembeli DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_pembeli").substring(3);
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
                id.setText("CSN" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                id.setText("CSN0001");//sesuaikan dengan variable namenya
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
        tb.addColumn("ID Pembeli");
        tb.addColumn("Nama Pembeli");
        tb.addColumn("Telepon");
        tb.addColumn("Alamat");
      
      

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from pembeli");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_pembeli"),
                    res.getString("nama_pembeli"),
                    res.getString("tlp"),
                    res.getString("alamat_pembeli")
                    
                    
                 

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
        tb.addColumn("ID Pembeli");
        tb.addColumn("Nama Pembeli");
        tb.addColumn("Telepon");
        tb.addColumn("Alamat");
       

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM pembeli where id_pembeli like '%" + itemcari + "%' or nama_pembeli like '%" + itemcari + "%' order by id_pembeli asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                     res.getString("id_pembeli"),
                    res.getString("nama_pembeli"),
                    res.getString("tlp"),
                    res.getString("alamat_pembeli")

                });
            }
            jumlah = tabel.getRowCount();
            jum.setText(jumlah + " Item");
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
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        students = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tlp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        ops = new javax.swing.JPanel();
        ido = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
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
        tgl.setText("Data Pembeli");
        tgl.setToolTipText("");
        kGradientPanel1.add(tgl);
        tgl.setBounds(290, 50, 480, 50);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 120));

        kGradientPanel2.setGradientFocus(400);
        kGradientPanel2.setStartColor(new java.awt.Color(255, 0, 153));

        students.setBackground(new java.awt.Color(0, 0, 0));
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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tlp.setBackground(new java.awt.Color(0, 0, 0));
        tlp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tlp.setForeground(new java.awt.Color(255, 255, 255));
        tlp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        tlp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tlpKeyTyped(evt);
            }
        });
        jPanel1.add(tlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nama Pembeli");
        jLabel12.setToolTipText("");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 20));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(0, 0, 0));
        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id Pembeli");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 20));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
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
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
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

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
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
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
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

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
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

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
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
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
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

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
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
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
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

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Telepon");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 20));

        nama.setBackground(new java.awt.Color(0, 0, 0));
        nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Alamat");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 110, 20));

        alamat.setBackground(new java.awt.Color(0, 0, 0));
        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setRows(5);
        alamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jScrollPane1.setViewportView(alamat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 260, 80));

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

        jPanel1.add(ops, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 200, 70));

        jLabel39.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Opsi Cetak Laporan");
        jLabel39.setToolTipText("");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 170, -1));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
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

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
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

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        kGradientPanel2.add(jPanel1);
        jPanel1.setBounds(160, 30, 740, 290);

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1030, 590));

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(51,255,51));
 }
public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(0,0,0));
 }
    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        setState(ICONIFIED);
    }//GEN-LAST:event_closeMouseClicked

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
       // System.exit(0);  
        new menukasir().show();
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_close1MouseClicked

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

            id.setText(String.valueOf(a));
            tlp.setText(String.valueOf(c));
            nama.setText(String.valueOf(b));
            //  buttonGroup1.setSelected(valueOf(d));
            alamat.setText(String.valueOf(d));
            //tlp.setText(String.valueOf(e));
            // jumlah.setText(String.valueOf(f));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);

        }         // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        setColor(jPanel10);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetColor(jPanel10);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed

        if (tlp.getText() == null || "".equals(tlp.getText()) || " ".equals(tlp.getText())
            || nama.getText() == null || "".equals(nama.getText()) || " ".equals(nama.getText())
            || alamat.getText() == null || "".equals(alamat.getText()) || " ".equals(alamat.getText())|| id.getText() == null || "".equals(id.getText()) || " ".equals(id.getText())  ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
            try {
                stat.executeUpdate("insert into pembeli values ("
                    + "'" + id.getText() + "',"
                    + "'" + nama.getText() + "',"
                    + "'" + tlp.getText()+ "',"
                    + "'" + alamat.getText() + "')"
                );

                kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
                tabel();// Menampilkan isi tabel
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }

        }
    }//GEN-LAST:event_jPanel10MousePressed

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

       if (tlp.getText() == null || "".equals(tlp.getText()) || " ".equals(tlp.getText())
            || nama.getText() == null || "".equals(nama.getText()) || " ".equals(nama.getText())
            || alamat.getText() == null || "".equals(alamat.getText()) || " ".equals(alamat.getText())|| id.getText() == null || "".equals(id.getText()) || " ".equals(id.getText())  ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {

            try {
                stat.executeUpdate("update pembeli set "

                    //   + "id_peg='" + idperpus.getText() + "',"
                    + "nama_pembeli='" + nama.getText() + "',"
                    + "tlp='" + tlp.getText()+ "',"
                    + "alamat_pembeli='" + alamat.getText() + "'"

                    + " where "
                    + "id_pembeli='" + id.getText() + "'"
                );
                kosongkan();
                tabel();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }// TODO add your handling code here:
        }
    }//GEN-LAST:event_jPanel13MousePressed

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        setColor(jPanel15);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        resetColor(jPanel15); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfrimasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
            try {
                stat.executeUpdate("delete from pembeli where "
                    + "id_pembeli='" + id.getText() + "'"
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
        autonomor();
        kosongkan();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

    private void tlpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tlpKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_tlpKeyTyped

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
        
                hasil = pembeli.tampilkanTanggalDanWaktu(tanggalDanWaktu,pola,lokal);
                String aa =  hasil ;
                String gg= "http://localhost/tokosb/pembeli.php?id="+ido.getText();
             // String gg= "http://localhost/tokosb/printid.php?id="+ido.getText();
                String gg1="&idu="+aa;
             //   String ide= ido.getText();
                // TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(new URI(gg+gg1));  // Desktop.getDesktop().browse(new URI("http://localhost/tokosb/pembeli.php?id="+ido.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jPanel18MousePressed

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
ops.hide();          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MousePressed
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
            java.util.logging.Logger.getLogger(pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembeli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JTextField id;
    private javax.swing.JTextField ido;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jum;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel ops;
    private javax.swing.JPanel students;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tlp;
    // End of variables declaration//GEN-END:variables
}
