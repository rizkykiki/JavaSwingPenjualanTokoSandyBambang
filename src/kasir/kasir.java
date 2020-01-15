/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir;

//import admin.barang;
import static admin.barang_masuk.jDateChooser2;
import admin.home;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jump.jbarangk;
import jump.jpembeli;

/**
 *
 * @author pc
 */

public class kasir extends javax.swing.JFrame {
public String nnama,ntlp,nalamat,nid;
public String gid,gnama,gtype,gjenis,gharga,gstok,gukuran,gmerek,id2,nlp2,alamat2,nama2;

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getNlp2() {
        return nlp2;
    }

    public void setNlp2(String nlp2) {
        this.nlp2 = nlp2;
    }

    public String getAlamat2() {
        return alamat2;
    }

    public void setAlamat2(String alamat2) {
        this.alamat2 = alamat2;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getGukuran() {
        return gukuran;
    }

    public void setGukuran(String gukuran) {
        this.gukuran = gukuran;
    }

    public String getGmerek() {
        return gmerek;
    }

    public void setGmerek(String gmerek) {
        this.gmerek = gmerek;
    }
   String pola = null;
        Locale lokal = null;
        String hasil = null;
          Date tanggalDanWaktu = new Date();
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGnama() {
        return gnama;
    }

    public void setGnama(String gnama) {
        this.gnama = gnama;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getGjenis() {
        return gjenis;
    }

    public void setGjenis(String gjenis) {
        this.gjenis = gjenis;
    }

    public String getGharga() {
        return gharga;
    }

    public void setGharga(String gharga) {
        this.gharga = gharga;
    }

    public String getGstok() {
        return gstok;
    }

    public void setGstok(String gstok) {
        this.gstok = gstok;
    }

    public String getNnama() {
        return nnama;
    }

    public void setNnama(String nnama) {
        this.nnama = nnama;
    }

    public String getNtlp() {
        return ntlp;
    }

    public void setNtlp(String ntlp) {
        this.ntlp = ntlp;
    }

    public String getNalamat() {
        return nalamat;
    }

    public void setNalamat(String nalamat) {
        this.nalamat = nalamat;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
     private Connection con;
    private Statement stat;
    private ResultSet res;
    public String tgllahir;
    String sql;
     int timeRun = 0;
    /**
     * Creates new form kasir
     */
    public kasir() {
        initComponents();
           kosongkan();
        ClearTabel();
        koneksi();
        tabel();
        tabel1();
        //Tanggal_sekarang();
        autonomor();
         new Thread()
        {
            public void run()
            {
                while (timeRun== 0)
                {
                    Calendar cal = new GregorianCalendar();
                    int HOUR_OF_DAY = cal.get(Calendar.HOUR_OF_DAY);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    
                    
                    String time = HOUR_OF_DAY + ":" + min + ":" + sec ;
                   // clock.setText(time);
                    pola = "EEEE dd MMMM yyyy";
                hasil = kasir.tampilkanTanggalDanWaktu(
                tanggalDanWaktu, pola, lokal);
                String aa =  hasil +" "+ time;
                tgl.setText(aa);
                }
            }
        }.start();
    }
    public void autonomor() {
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection kon = DriverManager.getConnection("jdbc:mysql://localhost/tokosb", "root", "");
            Statement stt = kon.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY id_trans DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String idperpuss = rs.getString("id_trans").substring(3);
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
                idt.setText("TRS" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                idt.setText("TRS0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            kon.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
     public void Tanggal_sekarang(){
        //java.util.Date sekarang = new java.util.Date();
        //java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat ("dd-MM-yyyy") ;
          Calendar now = Calendar.getInstance();
    
    //create an array of months
    String[] strMonths = new String[]{
                      "Januari",
                      "Februari",
                      "Maret",
                      "April",
                      "Mei",
                      "Juni",
                      "Juli",
                      "Agustus",
                      "September",
                      "oktober",
                      "November",
                      "Desember"
                    };
   
    String bln=(strMonths[now.get(Calendar.MONTH)]   );
       // tgl.setText(kal.format(sekarang));
//       tgl.setText(now.get(Calendar.DATE)
//                        + "-"
//                        + (bln)
//                        + "-"
//                        + now.get(Calendar.YEAR));

       
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
       // idt.setText("");
        idp.setText("");
        alamat.setText("");
      // jDateChooser2.setDate(null);
       idb.setText("");
//         type.setText("");
         harga.setText("");
        namap.setText("");
        sisa.setText("");
        ukuran.setText("");
        merek.setText("");
        jenis.setText("");
        namab.setText("");
         kembali.setText("");
        kuantitas.setText("");
        total.setText("");
       cash.setText("");
        
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
        jPanel1 = new javax.swing.JPanel();
        merek = new javax.swing.JLabel();
        namap = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        sisa = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kuantitas = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        idb = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        idt = new javax.swing.JLabel();
        idp = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        kembali = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jenis = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        namab = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ukuran = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        students = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jum = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        tgl1 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        merek.setBackground(new java.awt.Color(0, 0, 0));
        merek.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        merek.setForeground(new java.awt.Color(255, 255, 255));
        merek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merek.setToolTipText("");
        jPanel1.add(merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 140, 20));

        namap.setBackground(new java.awt.Color(0, 0, 0));
        namap.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        namap.setForeground(new java.awt.Color(255, 255, 255));
        namap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namap.setToolTipText("");
        jPanel1.add(namap, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 220, 20));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id Transaksi");
        jLabel16.setToolTipText("");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, 20));

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

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

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

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Cetak Struk");

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

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

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

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        sisa.setBackground(new java.awt.Color(0, 0, 0));
        sisa.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        sisa.setForeground(new java.awt.Color(255, 255, 255));
        sisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sisa.setToolTipText("");
        jPanel1.add(sisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 150, 20));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Kuantitas");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 100, 20));

        kuantitas.setBackground(new java.awt.Color(0, 0, 0));
        kuantitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kuantitas.setForeground(new java.awt.Color(255, 255, 255));
        kuantitas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        kuantitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kuantitasKeyTyped(evt);
            }
        });
        jPanel1.add(kuantitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 170, -1));

        total.setBackground(new java.awt.Color(0, 0, 0));
        total.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setToolTipText("");
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 170, 30));

        tgl.setBackground(new java.awt.Color(0, 0, 0));
        tgl.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setText("Tanggal");
        tgl.setToolTipText("");
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 470, 20));

        idb.setBackground(new java.awt.Color(0, 0, 0));
        idb.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        idb.setForeground(new java.awt.Color(255, 255, 255));
        idb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idb.setToolTipText("");
        jPanel1.add(idb, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 140, 20));

        cash.setBackground(new java.awt.Color(0, 0, 0));
        cash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashKeyTyped(evt);
            }
        });
        jPanel1.add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 170, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Cash");
        jLabel28.setToolTipText("");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 100, 20));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Kembalian");
        jLabel29.setToolTipText("");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, 20));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Alamat");
        jLabel31.setToolTipText("");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 20));

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

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Hitung");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 80, 30));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Harga Barang :");
        jLabel26.setToolTipText("");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 20));

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

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Total");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 80, 30));

        idt.setBackground(new java.awt.Color(0, 0, 0));
        idt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        idt.setForeground(new java.awt.Color(255, 255, 255));
        idt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idt.setToolTipText("");
        jPanel1.add(idt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 180, -1));

        idp.setBackground(new java.awt.Color(0, 0, 0));
        idp.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        idp.setForeground(new java.awt.Color(255, 255, 255));
        idp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idp.setToolTipText("");
        jPanel1.add(idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 220, -1));

        alamat.setBackground(new java.awt.Color(0, 0, 0));
        alamat.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alamat.setToolTipText("");
        jPanel1.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 220, -1));

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Stok Barang");
        jLabel35.setToolTipText("");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 100, 20));

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

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Cari pembeli");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        kembali.setBackground(new java.awt.Color(0, 0, 0));
        kembali.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        kembali.setForeground(new java.awt.Color(255, 255, 255));
        kembali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kembali.setToolTipText("");
        jPanel1.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 120, 20));

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel19MouseReleased(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Cari barang");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 110, -1));

        jenis.setBackground(new java.awt.Color(0, 0, 0));
        jenis.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jenis.setForeground(new java.awt.Color(255, 255, 255));
        jenis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jenis.setToolTipText("");
        jPanel1.add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 150, 20));

        harga.setBackground(new java.awt.Color(0, 0, 0));
        harga.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 255));
        harga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        harga.setToolTipText("");
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 150, 20));

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("id Barang");
        jLabel36.setToolTipText("");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 100, 20));

        namab.setBackground(new java.awt.Color(0, 0, 0));
        namab.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        namab.setForeground(new java.awt.Color(255, 255, 255));
        namab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namab.setToolTipText("");
        jPanel1.add(namab, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 150, 20));

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Jenis Barang :");
        jLabel38.setToolTipText("");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 100, 20));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Nama Barang :");
        jLabel39.setToolTipText("");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 100, 20));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("id Pembeli");
        jLabel17.setToolTipText("");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 20));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Nama Pembeli");
        jLabel18.setToolTipText("");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 20));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Total");
        jLabel23.setToolTipText("");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 100, 20));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ukuran");
        jLabel14.setToolTipText("");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, 20));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Merek");
        jLabel15.setToolTipText("");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 100, 20));

        ukuran.setBackground(new java.awt.Color(0, 0, 0));
        ukuran.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        ukuran.setForeground(new java.awt.Color(255, 255, 255));
        ukuran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ukuran.setToolTipText("");
        jPanel1.add(ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 140, 20));

        kGradientPanel1.add(jPanel1);
        jPanel1.setBounds(60, 100, 930, 330);

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

        kGradientPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 470, 1010, 210);

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
        students.add(jum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        cari.setBackground(new java.awt.Color(0, 0, 0));
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 204)));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        students.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 120, 30));

        kGradientPanel1.add(students);
        students.setBounds(250, 440, 570, 30);

        tgl1.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        tgl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl1.setText("Kasir");
        tgl1.setToolTipText("");
        kGradientPanel1.add(tgl1);
        tgl1.setBounds(260, 40, 480, 50);

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 700));

        setSize(new java.awt.Dimension(1024, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void itemTerpilih2(){
        jpembeli cr = new jpembeli();
        cr.kol = this;
        idp.setText(nid);
        alamat.setText(nalamat);
        namap.setText(nnama);
       
        
    }
  public void itemTerpilih3(){
        jbarangk cri = new jbarangk();
        cri.pil = this;
        idb.setText(gid);
      
        harga.setText(gharga);
           jenis.setText(gjenis);
              sisa.setText(gstok);
              ukuran.setText(gukuran);
              merek.setText(gmerek);
                 namab.setText(gnama);
                
       
    
          
              
             
     
        
    }
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
new menukasir().show();
this.dispose();//        System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_close1MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        setColor(jPanel10);   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetColor(jPanel10);    // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        
        if (idp.getText() == null || "".equals(idp.getText()) || " ".equals(idp.getText())
            || kuantitas.getText() == null || "".equals(kuantitas.getText()) || " ".equals(kuantitas.getText()) || total.getText() == null || "".equals(total.getText()) || " ".equals(total.getText())
            || cash.getText() == null || "".equals(cash.getText()) || " ".equals(cash.getText()) || kembali.getText() == null || "".equals( kembali.getText()) || " ".equals( kembali.getText())
            || idb.getText() == null || "".equals(idb.getText()) || " ".equals(idb.getText())) {
            JOptionPane.showMessageDialog(null, "Data masih ada yg kosong nih");
        } else {
            try {
                stat.executeUpdate("insert into transaksi values ("
                    + "'" + idt.getText() + "',"
                    + "'" + idp.getText() + "',"
                    + "'" + namap.getText()+ "',"
                    + "'" + alamat.getText() + "',"
                    + "'" + tgl.getText() + "',"
                    + "'" + idb.getText() + "',"
                    + "'" + namab.getText() + "',"
                        + "'" + jenis.getText() + "',"
                       
                                 + "'" + ukuran.getText() + "',"
                        + "'" + merek.getText() + "',"
                                
                        + "'" + harga.getText() + "',"
                        + "'" + kuantitas.getText() + "',"
                        + "'" + total.getText() + "',"
                        + "'" + "Rp. "+cash.getText() + "',"
                        + "'" + kembali.getText() + "')"

                );

               // kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
                tabel();// Menampilkan isi tabel
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
            }
//             try {
//                stat.executeUpdate("insert into barang_keluar values ("
////                    + "'" + idt.getText() + "',"
////                    + "'" + idp.getText() + "',"
////                    + "'" + namap.getText()+ "',"
////                    + "'" + alamat.getText() + "',"
//                   
//                    + "'" + idb.getText() + "',"
//                    + "'" + namab.getText() + "',"
//                        + "'" + jenis.getText() + "',"
//                        + "'" + type.getText() + "',"
//                        + "'" + tgl.getText() + "',"
//                       // + "'" + harga.getText() + "',"
//                        + "'" + kuantitas.getText() + "')"
//                     //   + "'" + total.getText() + "',"
//                     //   + "'" + cash.getText() + "',"
//                    //    + "'" + kembali.getText() + "')"
//
//                );
//
//               // kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
//                tabel();// Menampilkan isi tabel
//                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "pesan salah : " + e);
//            }
            try {
                  String gg1=sisa.getText();
        String baru12=kuantitas.getText();
    
          int a = Integer.parseInt(gg1);
            int b = Integer.parseInt(baru12);
           
            int ju= a-b;
             String n=Integer.toString(ju);  
                stat.executeUpdate("update stok_barang set "
                        //   + "id_peg='" + idperpus.getText() + "',"
                      //  + "nama_barang='" + nama.getText() + "',"
                      //  + "jenis_barang='" + jenis.getSelectedItem() + "',"
                      //  + "tipe_barang='" + type.getSelectedItem()+ "',"
                      //  + "harga_barang='" + harga.getText() + "',"
                        + "stokbarang='" + ju + "'"
                        + " where "
                        + "id_barang='" + idb.getText() + "'"
                );

               // kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
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

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        setColor(jPanel15);  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        resetColor(jPanel15); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(new URI("http://localhost/tokosb/struk.php?id="+idt.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }   
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
         Tanggal_sekarang();
        kosongkan();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MousePressed

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
            alamat.setText(String.valueOf(d));
            //  buttonGroup1.setSelected(valueOf(d));
            tgl.setText(String.valueOf(e));
            idb.setText(String.valueOf(f));
            namab.setText(String.valueOf(g));
              jenis.setText(String.valueOf(h));
             
              ukuran.setText(String.valueOf(j));
              merek.setText(String.valueOf(k));
              harga.setText(String.valueOf(l));
              kuantitas.setText(String.valueOf(m));
              total.setText(String.valueOf(n));
              cash.setText(String.valueOf(o));
              kembali.setText(String.valueOf(p));
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);

        }         // TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
 setColor(jPanel18);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
  resetColor(jPanel18);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MousePressed
jpembeli cr = new jpembeli();
        cr.kol = this;
       cr.setVisible(true);
        cr.setResizable(false);           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MousePressed

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
 setColor(jPanel19);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseExited
  resetColor(jPanel19);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseExited

    private void jPanel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MousePressed
jbarangk cri = new jbarangk();
        cri.pil = this;
       cri.setVisible(true);
        cri.setResizable(false);       
        kuantitas.setText("");
        total.setText("");
    
      
    }//GEN-LAST:event_jPanel19MousePressed

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
 setColor(jPanel20);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
  resetColor(jPanel20);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MousePressed
    String ambilkata2 = total.getText().substring(4); 
    String hh= cash.getText();
    String baruu= ambilkata2;
    int a = Integer.parseInt(baruu);
            int b = Integer.parseInt(hh);
            int juml= b-a;
              if (cash.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Masukan Nominal Uang!");
            cash.requestFocus();
        }else if (b < a) {
            JOptionPane.showMessageDialog(null, "Maaf Uang Tidak Cukup!");
            cash.setText("");
            kembali.setText("");
            cash.requestFocus();
        } else {
           
            kembali.setText("Rp. "+String.valueOf(juml));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MousePressed

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
 setColor(jPanel21);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
   resetColor(jPanel21);       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MousePressed
        String gg=sisa.getText();
        String baru=kuantitas.getText();
        String ambilkata = harga.getText().substring(4);
         String baru1= ambilkata;
          int a = Integer.parseInt(baru);
            int b = Integer.parseInt(baru1);
            int c = Integer.parseInt(gg);
            int jum= a*b;
             String n=Integer.toString(jum);  
          
         if (kuantitas.getText().equals("") || sisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf DATA TIDAK BENAR");
        } else if (c < a) {
            JOptionPane.showMessageDialog(null, "Maaf stok tidak cukup");
            kuantitas.setText("");
            total.setText("");

        } else if (c == a) {
//           JOptionPane.showMessageDialog(null, "sisa sama dengan kuantiti");
//            kuantitas.setText("");
//             total.setText("");
            total.setText("Rp. " + n);
        } else {
            total.setText("Rp. " + n);
            // JOptionPane.showMessageDialog(null, "sisa lebih besar dari kuantiti");
            //inidia        
        }
        
            
           
           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MousePressed

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

    private void kuantitasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kuantitasKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_kuantitasKeyTyped

    private void cashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyTyped
char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();}            // TODO add your handling code here:
    }//GEN-LAST:event_cashKeyTyped

    private void jPanel19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseReleased
  
               // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseReleased

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
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField cash;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel idb;
    private javax.swing.JLabel idp;
    private javax.swing.JLabel idt;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jenis;
    private javax.swing.JLabel jum;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel kembali;
    private javax.swing.JTextField kuantitas;
    private javax.swing.JLabel merek;
    private javax.swing.JLabel namab;
    private javax.swing.JLabel namap;
    private javax.swing.JLabel sisa;
    private javax.swing.JPanel students;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tgl1;
    private javax.swing.JLabel total;
    private javax.swing.JLabel ukuran;
    // End of variables declaration//GEN-END:variables
}
