/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import admin.home;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import kasir.kasir;
import kasir.menukasir;
import koneksi.database;

/**
 *
 * @author pc
 */
public class login extends javax.swing.JFrame {
 Connection koneksi;
    /**
     * Creates new form login
     */
    public login() {
       ResultSet rs = null;
        initComponents();
        koneksi = database.getKoneksi("localhost", "3306", "root","","tokosb");
        Tanggal_sekarang();
        Jam_digital();
        bersih_text();
       // setExtendedState(MAXIMIZED_BOTH);
    }
    
     public void log_in(){
           String lvl = "";
            try {
                Statement stmt = koneksi.createStatement();
                if (tnama.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "User Name tidak boleh kosong");
                    tnama.requestFocus();
                }
                else if (tpas.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Password tidak boleh kosong");
                    tpas.requestFocus();
                }
                else{
                    String query = "SELECT * FROM user WHERE username='"+ tnama.getText() +"' AND password='"+ tpas.getText()+"'";
                ResultSet rs = stmt.executeQuery(query);                
//                    if (rs.next()){
//                        new home().show();
//                        this.dispose();
//                    }
//                    else{
//                         JOptionPane.showMessageDialog(null, "UserName atau Password SALAH", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    stmt.close();
 while (rs.next()) {
               lvl = rs.getString(3);
           }
           if (lvl.equals("")) {
               JOptionPane.showMessageDialog(null, "USERNAME atau PASSWORD SALAH");
             //  clear();
           } 
           else {
               if (lvl.equals("0")) {
                   new menukasir().show();
                   //kondisiLogin = 0;

                   this.dispose();
               } else if (lvl.equals("1")) {
                   new home().show();
                   //kondisiLogin = 1;
                   this.dispose();
               } else {
                         JOptionPane.showMessageDialog(null, "UserName atau Password SALAH", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
//                 
               }
            //   userLogin = txtUser.getText();
           }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "koneksi GAGAL \n"+e);
            }            
        }
      public void bersih_text(){
        tnama.setText("");
        tpas.setText("");
        tnama.requestFocus();
    }
    
 //perintah menampilkan tanggal
    public void Tanggal_sekarang(){
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat ("yyyy-MM-dd") ;
        tanggal.setText(kal.format(sekarang));
    }
    
    //penrintah menampilkan jam
    public void Jam_digital(){
        new Thread(){
            @Override
            public void run(){
                int waktu_mulai = 0;
                while (waktu_mulai == 0){
                Calendar kalender = new GregorianCalendar();
                int jam = kalender.get(Calendar.HOUR);
                int menit = kalender.get(Calendar.MINUTE);
                int detik = kalender.get(Calendar.SECOND);
                int AM_PM = kalender.get(Calendar.AM_PM);
                String siang_malam = "";
                if (AM_PM == 1){
                    siang_malam = "PM";
                }
                else {
                    siang_malam = "AM";
                }
                String time = jam+" : "+menit+" : "+detik+" "+siang_malam;
                label_jam.setText(time);
                }
            }
        }.start();
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
        jPanel1 = new javax.swing.JPanel();
        tnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tpas = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_jam = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        kGradientPanel1.setBackground(new java.awt.Color(255, 102, 0));
        kGradientPanel1.setEndColor(new java.awt.Color(255, 0, 0));
        kGradientPanel1.setStartColor(new java.awt.Color(51, 255, 0));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tnama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tnama.setForeground(new java.awt.Color(102, 102, 102));
        tnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        jPanel1.add(tnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 278, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        tpas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tpas.setForeground(new java.awt.Color(102, 102, 102));
        tpas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        tpas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tpasKeyPressed(evt);
            }
        });
        jPanel1.add(tpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 280, -1));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel9MousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(45, 118, 232));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Masuk");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("lOGIN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 390, -1));

        label_jam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_jam.setForeground(new java.awt.Color(0, 0, 255));
        label_jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_jam.setText("Jam");
        jPanel1.add(label_jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 160, -1));

        tanggal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(0, 0, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("Tanggal");
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 340, 140, -1));

        kGradientPanel1.add(jPanel1);
        jPanel1.setBounds(70, 80, 390, 362);

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
        close.setBounds(470, 10, 8, 32);

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
        close1.setBounds(500, 10, 15, 32);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kintakun-dluxe-bc-new-edition-brooklyn-1.jpg"))); // NOI18N
        kGradientPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 530, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(528, 514));
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
 
    private void tpasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
           log_in(); }         // TODO add your handling code here:
    }//GEN-LAST:event_tpasKeyPressed

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        setColor(jPanel9);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        resetColor(jPanel9);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MousePressed
        log_in();       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MousePressed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
       setState(ICONIFIED);
    }//GEN-LAST:event_closeMouseClicked

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);         // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
xx = evt.getX();
        xy = evt.getY();          // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
log_in();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MousePressed

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
       System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_close1MouseClicked
int xx,xy;
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label_jam;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField tnama;
    private javax.swing.JPasswordField tpas;
    // End of variables declaration//GEN-END:variables
}