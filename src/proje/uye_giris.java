package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class uye_giris extends javax.swing.JFrame {

    /**
     * Creates new form uye_giris
     */
    public uye_giris() {
        super("Uye Giriş Formu"); 
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_adi = new javax.swing.JTextField();
        giris = new javax.swing.JButton();
        unuttum = new javax.swing.JLabel();
        goster = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();

        jPasswordField1.setText("jPasswordField1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("    Uye Adı");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jLabel1.setInheritsPopupMenu(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("   Uye Şifre");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jLabel2.setInheritsPopupMenu(false);

        txt_adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adiActionPerformed(evt);
            }
        });

        giris.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        giris.setText("GİRİŞ");
        giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisActionPerformed(evt);
            }
        });

        unuttum.setForeground(new java.awt.Color(0, 51, 255));
        unuttum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unuttum.setText("Şifremi Unuttum");
        unuttum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unuttumMouseClicked(evt);
            }
        });

        pass.setText("jPa");
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(goster)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unuttum, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_adi)
                    .addComponent(giris, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(pass))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(pass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unuttum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(giris, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(goster)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisActionPerformed
            
            String kadi=txt_adi.getText();// text'in içindekileri değişkene aktarma
            String parola=pass.getText();  
            try {
                if (kadi.equals("") || parola.equals("")) {// değişkenleri boş/dolu kontrolü
                    JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");

                } else {            
                    Class.forName("oracle.jdbc.OracleDriver");//oracle driveri çalıştırma
                    Connection cn = null;
                    Statement st = null;
                    ResultSet rs = null;
                    cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");//veritabanı ile bağlantı kurma
                    st = cn.createStatement();// nesne oluturma
                    String sorgu="select * from uyeler where kadı='"+kadi+"' and parola='"+parola+"'";
                    rs = st.executeQuery(sorgu);//çalıştırılan sorgu rs(resulset) ile geri döndürülür
                    
                    if(rs.next()){
                        if(rs.getString("pozisyon").equals("Müdür")){//sorgudan dönen verileri karşılaştırma
                            Raporlama ac = new Raporlama();
                            ac.setVisible(true);//Raporlama formunu açma
                           
                            this.setVisible(false);// bu formu kapat
                            
                            
                            
                        }
                         else if(rs.getString("pozisyon").equals("Satış Danışmanı")){
                            satislar ac = new satislar();
                            ac.setVisible(true);//satışlar formunu açma
                            ac.rapor.setVisible(false); //satislar formundaki rapor butonunu görünmez yapma
                            this.setVisible(false);
                            
                         }
                         if(rs.getString("pozisyon").equals("Depocu")){
                            urunekleme ac = new urunekleme();
                            ac.setVisible(true);
                            ac.rapor.setVisible(false);//urunekleme formundaki rapor butonunu görünmez yapma
                            
                            this.setVisible(false);
                        } 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Parola Hatalı! "); 
                    }
                }
            
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }
        
    }//GEN-LAST:event_girisActionPerformed

    private void txt_adiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adiActionPerformed

    }//GEN-LAST:event_txt_adiActionPerformed
    
    private void unuttumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unuttumMouseClicked
        JOptionPane.showMessageDialog(null, "Müdürünüze Başvurun...");// sifremi unuttum yazısına tıklanınca gelen mesaj

    }//GEN-LAST:event_unuttumMouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
           
    }//GEN-LAST:event_passActionPerformed

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        pass.setText(""); //password textine tıklanınca içini boşaltır
    }//GEN-LAST:event_passMouseClicked
    
    
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
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton giris;
    private javax.swing.JLabel goster;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField txt_adi;
    private javax.swing.JLabel unuttum;
    // End of variables declaration//GEN-END:variables
}
