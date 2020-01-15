/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

//import static admin.datakaryawan.jDateChooser2;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jump.jbarang;
import jump.jdistributor;
//import jump.jpemesanan;
import kasir.kasir;

/**
 *
 * @author pc
 */
public class barang_masuk extends javax.swing.JFrame {
 public String tid, tnama,tjenis,ttype,tharga,tstok,tidd,tnamad,ttlp,talamat,tukuran,tmerek,tgll,jum,tbeli;

    public String getTbeli() {
        return tbeli;
    }

    public void setTbeli(String tbeli) {
        this.tbeli = tbeli;
    }

    public String getTgll() {
        return tgll;
    }

    public void setTgll(String tgll) {
        this.tgll = tgll;
    }

    public String getJum() {
        return jum;
    }

    public void setJum(String jum) {
        this.jum = jum;
    }
String pola = null;
        Locale lokal = null;
        String hasil = null;
         Date tanggalDanWaktu = new Date();
    public String getTukuran() {
        return tukuran;
    }

    public void setTukuran(String tukuran) {
        this.tukuran = tukuran;
    }

    public String getTmerek() {
        return tmerek;
    }

    public void setTmerek(String tmerek) {
        this.tmerek = tmerek;
    }

    public String getTidd() {
        return tidd;
    }

    public void setTidd(String tidd) {
        this.tidd = tidd;
    }

    public String getTnamad() {
        return tnamad;
    }

    public void setTnamad(String tnamad) {
        this.tnamad = tnamad;
    }

    public String getTtlp() {
        return ttlp;
    }

    public void setTtlp(String ttlp) {
        this.ttlp = ttlp;
    }

    public String getTalamat() {
        return talamat;
    }

    public void setTalamat(String talamat) {
        this.talamat = talamat;
    }

    public String getTstok() {
        return tstok;
    }

    public void setTstok(String tstok) {
        this.tstok = tstok;
    }
     private Connection con;
    private Statement stat;
    private ResultSet res;
    public String tgllahir;
    String sql;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTnama() {
        return tnama;
    }

    public void setTnama(String tnama) {
        this.tnama = tnama;
    }

    public String getTjenis() {
        return tjenis;
    }

    public void setTjenis(String tjenis) {
        this.tjenis = tjenis;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getTharga() {
        return tharga;
    }

    public void setTharga(String tharga) {
        this.tharga = tharga;
    }
    
 
    /**
     * Creates new form barang_masuk
     */
    public barang_masuk() {
        initComponents();
         tabel();
         kosongkan();
        ClearTabel();
        koneksi();
        tabel();
        tabel1();
         ops.hide();    
         //jPanel2.hide();
        autonomor();
    }
     public void autonomor() {
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM barang_masuk ORDER BY id_barangmasuk DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_barangmasuk").substring(5);
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
                idbarangmasuk.setText("Masuk" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idbarangmasuk.setText("Masuk0001");//sesuaikan dengan variable namenya
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
private void kosongkan() {
        id.setText("");
        nama.setText("");
        jenis.setText("");
        Beli.setText("");
      // jDateChooser2.setDate(null);
      //  type.setText("");
         harga.setText("");
         jumlah.setText("");
           ukuran.setText("");
         merek.setText("");
           tlp_dist.setText("");
             alamat_dit.setText("");
        
        stok.setText("");
        id_dist.setText("");
         nama_dist.setText("");
        //jenis.setText(tjenis);
//        tlp.setText("");
  //      alamat.setText("");
        
          jDateChooser2.setDate(null);
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
tb.addColumn("ID Barang masuk");
//tb.addColumn("ID Pemesanan");
        tb.addColumn("ID Distributor");
        
        tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
      //  tb.addColumn("Type Barang");
           tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
       tb.addColumn("Tanggal");
        tb.addColumn("Jumlah Barang");
          tb.addColumn("Harga beli");
      

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from barang_masuk");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getString("id_barangmasuk"),
                   // res.getString("id_pemesanan"),
                     res.getString("id_distributor"),
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                   // res.getString("type_barang"),
                       res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("tanggal"),
                    res.getInt("jumlah_barang"),
                    res.getString("harga_beli")
                 

                });
            }
            jumlah = tabel.getRowCount();
            juml.setText(jumlah + " Item");
        } catch (Exception e) {
        }
    }
   private void tabel1() {
        int jumlah = 0;
        String itemcari = cari.getText();
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
tb.addColumn("ID Barang masuk");
//tb.addColumn("ID Pemesanan");
        tb.addColumn("ID Distributor");
        
        tb.addColumn("ID Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Jenis Barang");
      //  tb.addColumn("Type Barang");
           tb.addColumn("Ukuran Barang");
        tb.addColumn("Merek Barang");
       tb.addColumn("Tanggal");
        tb.addColumn("Jumlah Barang");
          tb.addColumn("Harga beli");
      
       

        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("SELECT * FROM barang_masuk where id_barang like '%" + itemcari + "%' or nama_barang like '%" + itemcari + "%' or tanggal like '%" + itemcari + "%' order by id_barang asc");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                        res.getString("id_barangmasuk"),
                   // res.getString("id_pemesanan"),
                     res.getString("id_distributor"),
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jenis_barang"),
                   // res.getString("type_barang"),
                       res.getString("ukuran"),
                      res.getString("merek"),
                    res.getString("tanggal"),
                    res.getInt("jumlah_barang"),
                    res.getString("harga_beli")
                 

                });
            }
            jumlah = tabel.getRowCount();
            juml.setText(jumlah + " Item");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        stok = new javax.swing.JLabel();
        jenis = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        tanggal2 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        type2 = new javax.swing.JLabel();
        type3 = new javax.swing.JLabel();
        ukuran = new javax.swing.JLabel();
        tanggal4 = new javax.swing.JLabel();
        alamat_dit = new javax.swing.JLabel();
        id_dist = new javax.swing.JLabel();
        nama_dist = new javax.swing.JLabel();
        tanggal6 = new javax.swing.JLabel();
        tanggal8 = new javax.swing.JLabel();
        idbarangmasuk = new javax.swing.JLabel();
        merek = new javax.swing.JLabel();
        ops = new javax.swing.JPanel();
        ido = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        tanggal10 = new javax.swing.JLabel();
        tanggal11 = new javax.swing.JLabel();
        tanggal7 = new javax.swing.JLabel();
        tlp_dist = new javax.swing.JLabel();
        tanggal12 = new javax.swing.JLabel();
        tanggal13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        Beli = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        students = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        juml = new javax.swing.JLabel();
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
        tgl.setText("Barang Masuk");
        tgl.setToolTipText("");
        kGradientPanel1.add(tgl);
        tgl.setBounds(280, 50, 480, 50);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 120));

        kGradientPanel2.setGradientFocus(400);
        kGradientPanel2.setStartColor(new java.awt.Color(255, 0, 153));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Jumlah Barang");
        jLabel11.setToolTipText("");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 100, 20));

        nama.setBackground(new java.awt.Color(0, 0, 0));
        nama.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama.setToolTipText("");
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 110, 20));

        harga.setBackground(new java.awt.Color(0, 0, 0));
        harga.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 255));
        harga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        harga.setToolTipText("");
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 100, 20));

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

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Hapus");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));
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

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Cari Barang");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        id.setBackground(new java.awt.Color(0, 0, 0));
        id.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setToolTipText("");
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 110, 20));

        stok.setBackground(new java.awt.Color(0, 0, 0));
        stok.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        stok.setForeground(new java.awt.Color(255, 255, 255));
        stok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stok.setToolTipText("");
        jPanel1.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 110, 20));

        jenis.setBackground(new java.awt.Color(0, 0, 0));
        jenis.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jenis.setForeground(new java.awt.Color(255, 255, 255));
        jenis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jenis.setToolTipText("");
        jPanel1.add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 100, 20));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nama Barang :");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        type1.setBackground(new java.awt.Color(0, 0, 0));
        type1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        type1.setForeground(new java.awt.Color(255, 255, 255));
        type1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type1.setText("Karena data langsung di tambah ke stok barang");
        type1.setToolTipText("");
        jPanel1.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 230, -1, 20));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Tanggal Masuk");
        jLabel27.setToolTipText("");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 110, 20));

        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 130, -1));

        tanggal2.setBackground(new java.awt.Color(0, 0, 0));
        tanggal2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal2.setForeground(new java.awt.Color(255, 255, 255));
        tanggal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal2.setText("Jenis Barang :");
        tanggal2.setToolTipText("");
        jPanel1.add(tanggal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, 20));

        jumlah.setBackground(new java.awt.Color(0, 0, 0));
        jumlah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jumlah.setForeground(new java.awt.Color(255, 255, 255));
        jumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahKeyTyped(evt);
            }
        });
        jPanel1.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, -1));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Id Barang :");
        jLabel29.setToolTipText("");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        type2.setBackground(new java.awt.Color(0, 0, 0));
        type2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        type2.setForeground(new java.awt.Color(255, 255, 255));
        type2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type2.setText("Stok Awal :");
        type2.setToolTipText("");
        jPanel1.add(type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 20));

        type3.setBackground(new java.awt.Color(0, 0, 0));
        type3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        type3.setForeground(new java.awt.Color(255, 255, 255));
        type3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type3.setText("Cek dulu sebelum menyimpan data");
        type3.setToolTipText("");
        jPanel1.add(type3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 220, 20));

        ukuran.setBackground(new java.awt.Color(0, 0, 0));
        ukuran.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ukuran.setForeground(new java.awt.Color(255, 255, 255));
        ukuran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ukuran.setToolTipText("");
        jPanel1.add(ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, 20));

        tanggal4.setBackground(new java.awt.Color(0, 0, 0));
        tanggal4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal4.setForeground(new java.awt.Color(255, 255, 255));
        tanggal4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal4.setText("Id Dirstributor : ");
        tanggal4.setToolTipText("");
        jPanel1.add(tanggal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 100, 20));

        alamat_dit.setBackground(new java.awt.Color(0, 0, 0));
        alamat_dit.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        alamat_dit.setForeground(new java.awt.Color(255, 255, 255));
        alamat_dit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alamat_dit.setToolTipText("");
        jPanel1.add(alamat_dit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 130, 20));

        id_dist.setBackground(new java.awt.Color(0, 0, 0));
        id_dist.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        id_dist.setForeground(new java.awt.Color(255, 255, 255));
        id_dist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id_dist.setToolTipText("");
        jPanel1.add(id_dist, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 130, 20));

        nama_dist.setBackground(new java.awt.Color(0, 0, 0));
        nama_dist.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        nama_dist.setForeground(new java.awt.Color(255, 255, 255));
        nama_dist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama_dist.setToolTipText("");
        jPanel1.add(nama_dist, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 120, 20));

        tanggal6.setBackground(new java.awt.Color(0, 0, 0));
        tanggal6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal6.setForeground(new java.awt.Color(255, 255, 255));
        tanggal6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal6.setText("Harga Barang : ");
        tanggal6.setToolTipText("");
        jPanel1.add(tanggal6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 20));

        tanggal8.setBackground(new java.awt.Color(0, 0, 0));
        tanggal8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal8.setForeground(new java.awt.Color(255, 255, 255));
        tanggal8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal8.setText("Ukuran :");
        tanggal8.setToolTipText("");
        jPanel1.add(tanggal8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

        idbarangmasuk.setBackground(new java.awt.Color(0, 0, 0));
        idbarangmasuk.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        idbarangmasuk.setForeground(new java.awt.Color(255, 255, 255));
        idbarangmasuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idbarangmasuk.setToolTipText("");
        jPanel1.add(idbarangmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 110, 20));

        merek.setBackground(new java.awt.Color(0, 0, 0));
        merek.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        merek.setForeground(new java.awt.Color(255, 255, 255));
        merek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merek.setToolTipText("");
        jPanel1.add(merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 20));

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

        jPanel1.add(ops, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 200, 70));

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
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 170, -1));

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

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Cetak laporan");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, -1));

        tanggal10.setBackground(new java.awt.Color(0, 0, 0));
        tanggal10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal10.setForeground(new java.awt.Color(255, 255, 255));
        tanggal10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal10.setText("Merek :");
        tanggal10.setToolTipText("");
        jPanel1.add(tanggal10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 100, 20));

        tanggal11.setBackground(new java.awt.Color(0, 0, 0));
        tanggal11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal11.setForeground(new java.awt.Color(255, 255, 255));
        tanggal11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal11.setText("Id barang masuk :");
        tanggal11.setToolTipText("");
        jPanel1.add(tanggal11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 20));

        tanggal7.setBackground(new java.awt.Color(0, 0, 0));
        tanggal7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal7.setForeground(new java.awt.Color(255, 255, 255));
        tanggal7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal7.setText("Nama distributor :");
        tanggal7.setToolTipText("");
        jPanel1.add(tanggal7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 110, 20));

        tlp_dist.setBackground(new java.awt.Color(0, 0, 0));
        tlp_dist.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tlp_dist.setForeground(new java.awt.Color(255, 255, 255));
        tlp_dist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlp_dist.setToolTipText("");
        jPanel1.add(tlp_dist, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 130, 20));

        tanggal12.setBackground(new java.awt.Color(0, 0, 0));
        tanggal12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal12.setForeground(new java.awt.Color(255, 255, 255));
        tanggal12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal12.setText("Alamat distributor :");
        tanggal12.setToolTipText("");
        jPanel1.add(tanggal12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 130, 20));

        tanggal13.setBackground(new java.awt.Color(0, 0, 0));
        tanggal13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        tanggal13.setForeground(new java.awt.Color(255, 255, 255));
        tanggal13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal13.setText("Telpon distributor :");
        tanggal13.setToolTipText("");
        jPanel1.add(tanggal13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 130, 20));

        jPanel20.setBackground(new java.awt.Color(0, 0, 0));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel20MousePressed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Cari DIstributor");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel21MousePressed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Buka DIstributor");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));

        Beli.setBackground(new java.awt.Color(0, 0, 0));
        Beli.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        Beli.setForeground(new java.awt.Color(255, 255, 255));
        Beli.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Beli.setToolTipText("");
        jPanel1.add(Beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 180, 20));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Harga beli");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 110, 20));

        kGradientPanel2.add(jPanel1);
        jPanel1.setBounds(30, 30, 970, 290);

        students.setBackground(new java.awt.Color(0, 0, 0));
        students.setForeground(new java.awt.Color(255, 255, 255));
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
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

        juml.setBackground(new java.awt.Color(0, 0, 0));
        juml.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        juml.setForeground(new java.awt.Color(255, 255, 255));
        juml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        juml.setText("jumlah");
        juml.setToolTipText("");
        students.add(juml, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

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

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        setColor(jPanel10);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetColor(jPanel10);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited
public void setColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(51,255,51));
 }
public void resetColor(JPanel panel)
 {
     panel.setBackground(new java.awt.Color(0,0,0));
 }

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
//        userId u= new userId();
//        String id32=u.userDataId();
 String rp = "Rp. ";
        if (tgllahir == null || "".equals(tgllahir) || " ".equals(tgllahir)
            || jumlah.getText() == null || "".equals(jumlah.getText()) || " ".equals(jumlah.getText())
                || stok.getText() == null || "".equals(stok.getText()) || " ".equals(stok.getText())
            || id.getText() == null || "".equals(id.getText()) || " ".equals(id.getText())|| id_dist.getText() == null || "".equals(id_dist.getText()) || " ".equals(id_dist.getText())  ) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
            int ok = JOptionPane.showConfirmDialog(null,"Data akan di simpan?","Konfrim", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            try {
                
                stat.executeUpdate("insert into barang_masuk values ("
//                        + "'" + id32 + "',"
                        + "'" + idbarangmasuk.getText() + "',"
                             
                     + "'" + id_dist.getText() + "',"
                       + "'" + nama_dist.getText() + "',"
                       + "'" + tlp_dist.getText() + "',"
                       + "'" + alamat_dit.getText() + "',"
                    + "'" + id.getText() + "',"
                    + "'" + nama.getText() + "',"
                     + "'" + jenis.getText() + "',"
              //      + "'" + type.getText() + "',"
                      + "'" + ukuran.getText() + "',"
                    + "'" + merek.getText() + "',"
                   
                    + "'" + tgllahir + "',"
                         +"'" + jumlah.getText() + "',"
                    + "'" + Beli.getText() + "',"
                          + "'" + harga.getText() + "')"

                );

               // kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
                tabel();// Menampilkan isi tabel
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
            String baru=stok.getText();
            String baru1= jumlah.getText();
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
                        + "id_barang='" + id.getText() + "'"
                );
                kosongkan();
                tabel();
               // JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
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

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        setColor(jPanel11);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        resetColor(jPanel11);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        tabel();
    //    autonomor();
        kosongkan();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
      setColor(jPanel14);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
 resetColor(jPanel14);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseExited

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
//        export();  
  int ok = JOptionPane.showConfirmDialog(null,"hapus? data stok juga akan di kurangi","Konfrimasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
              String baru=stok.getText();
            String baru1= jumlah.getText();
            int a1 = Integer.parseInt(baru);
            int b2 = Integer.parseInt(baru1);
            int jumk= a1-b2;
            
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
                        + "id_barang='" + id.getText() + "'"
                );
               // kosongkan();
                tabel();
               // JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
            try {
                stat.executeUpdate("delete from barang_masuk where "
                    + "id_barangmasuk='" + idbarangmasuk.getText() + "'"
                );
                kosongkan();
                tabel();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }

        }// TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
      setColor(jPanel17);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
 resetColor(jPanel17);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseExited
  public void itemTerpilih(){
        jbarang cr = new jbarang();
        cr.pi = this;
        id.setText(tid);
        nama.setText(tnama);
        jenis.setText(tjenis);
       // type.setText(ttype);
        ukuran.setText(tukuran);
        merek.setText(tmerek);
        harga.setText(tharga);
           Beli.setText(tbeli);
        stok.setText(tstok);
        
    }
 
    private void jPanel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MousePressed
jbarang cr = new jbarang();
        cr.pi = this;
       cr.setVisible(true);
        cr.setResizable(false); 
     //   this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MousePressed

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
                  String i = tabel.getValueAt(row, 8).toString();
             String j = tabel.getValueAt(row, 9).toString();
           //    String l = tabel.getValueAt(row, 10).toString();
               //  String m = tabel.getValueAt(row, 9).toString();
            idbarangmasuk.setText(String.valueOf(a));
          //  nama_dist.setText(String.valueOf(b));
             id_dist.setText(String.valueOf(b));
            id.setText(String.valueOf(c));
            nama.setText(String.valueOf(d));
            //  buttonGroup1.setSelected(valueOf(d));
            jenis.setText(String.valueOf(e));
          ukuran.setText(String.valueOf(f));
          merek.setText(String.valueOf(g));
            jumlah.setText(String.valueOf(i));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);

        }       try
            {
                sql="select * from stok_barang where id_barang='"+id.getText()+"'";
                stat=con.createStatement();
                res=stat.executeQuery(sql);

                if (res.next())
                { // JOptionPane.showMessageDialog(rootPane, "data ketemu nih");
                    stok.setText(res.getString("stokbarang"));
                    
                   
                }
                 
                else{
                   //  JOptionPane.showMessageDialog(rootPane, "silakan masukkan kembali");
                     kosongkan();
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }       // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        if (jDateChooser2.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            tgllahir = format.format(jDateChooser2.getDate());
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyTyped
  char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahKeyTyped

    private void idoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idoKeyTyped

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        ops.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        setColor(jPanel19);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
        resetColor(jPanel19); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseExited

    private void jPanel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MousePressed
  pola = "EEEE+dd+MMMM+yyyy";
        
                hasil = barang_masuk.tampilkanTanggalDanWaktu(tanggalDanWaktu,pola,lokal);
                String aa =  hasil ;
                String gg= "http://localhost/tokosb/barangmasuk.php?id="+ido.getText();
             // String gg= "http://localhost/tokosb/printid.php?id="+ido.getText();
                String gg1="&idu="+aa;
             //   String ide= ido.getText();
        if(Desktop.isDesktopSupported()){
            try {
               // Desktop.getDesktop().browse(new URI("http://localhost/tokosb/barangmasuk.php?id="+ido.getText()));
                Desktop.getDesktop().browse(new URI(gg+gg1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jPanel19MousePressed

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
       setColor(jPanel20);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
      resetColor(jPanel20);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseExited
 public void itemTerpilih1(){
        jdistributor cr = new jdistributor();
        cr.kog = this;
        id_dist.setText(tidd);
        nama_dist.setText(tnamad);
        //jenis.setText(tjenis);
        tlp_dist.setText(ttlp);
        alamat_dit.setText(talamat);
        //stok.setText(tstok);
        
    }
    private void jPanel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MousePressed
        jdistributor cr = new jdistributor();
        cr.kog = this;
        cr.setVisible(true);
        cr.setResizable(false);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MousePressed

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        setColor(jPanel21);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
        resetColor(jPanel21); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        new distributor().show();
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MousePressed

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
ops.hide();          // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang_masuk().setVisible(true);
            }
        });
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Beli;
    private javax.swing.JLabel alamat_dit;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id_dist;
    private javax.swing.JLabel idbarangmasuk;
    private javax.swing.JTextField ido;
    public static com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jenis;
    private javax.swing.JLabel juml;
    private javax.swing.JTextField jumlah;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel merek;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama_dist;
    private javax.swing.JPanel ops;
    private javax.swing.JLabel stok;
    private javax.swing.JPanel students;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tanggal10;
    private javax.swing.JLabel tanggal11;
    private javax.swing.JLabel tanggal12;
    private javax.swing.JLabel tanggal13;
    private javax.swing.JLabel tanggal2;
    private javax.swing.JLabel tanggal4;
    private javax.swing.JLabel tanggal6;
    private javax.swing.JLabel tanggal7;
    private javax.swing.JLabel tanggal8;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tlp_dist;
    private javax.swing.JLabel type1;
    private javax.swing.JLabel type2;
    private javax.swing.JLabel type3;
    private javax.swing.JLabel ukuran;
    // End of variables declaration//GEN-END:variables
}
