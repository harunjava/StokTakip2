/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kubra
 */
public class Raporlama extends javax.swing.JFrame{
interface Urun_Sayi{//urun_sayi adında bir interface oluşturduk. bu interface bağlı sayı_sonuc ve satıs_sonuc adında 2 metodumuz var.
    void sayı_sonuc();
    void satis_sonuc();
}
    class Test implements Urun_Sayi // test adında urun_Sayı interfacesine bağlı bir class oluşturduk.
    {// bu classta interfacede isimlerini verdiğimiz(sayı_sonuc, satıs_sonuc) iki metodun gövdelerini yazıyoruz.
       public void sayı_sonuc(){
        ResultSet rs;
        Connection cn = null;
        Statement st ;
    
        try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement();    
        rs = st.executeQuery("select sum(adet) from satislar");
        rs.next();
        txt_t_urun.setText(rs.getString(1)+" adet");// rs ile geri döndürülen toplam adet sayısının 1.sini txt_t_urune aktarıyoruz
           
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    }   
       public void satis_sonuc(){
        ResultSet rs;
        Connection cn = null;
        Statement st;
        try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement();    
        rs = st.executeQuery("select sum(toplam_fiyat) from satislar");
        rs.next();
        txt_t_tutar.setText(rs.getString(1)+" TL");// rs ile geri döndürülen toplam_fiyatların toplamını 1.sini txt_t_tutar aktarıyoruz
        rs.close();
        cn.close();
    }
   
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    
    }   
   }

    private void UrunListeGuncelle(){
    ResultSet rs;
    Connection cn = null;
    Statement st ;
    int sutunSayisi ;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement();    
        rs=st.executeQuery("Select * from satislar ");     
        sutunSayisi=rs.getMetaData().getColumnCount();   
        DefaultTableModel table=new DefaultTableModel();      
        for(int i=1;i<=sutunSayisi;i++)
            table.addColumn(rs.getMetaData().getColumnName(i)); 
         while(rs.next()){
              Object[] row=new Object[sutunSayisi];
               for(int i=1;i<=sutunSayisi;i++)
                  row[i-1]=rs.getObject(i);
              table.addRow(row);
         }
         tablo_satislar.setModel(table);     
        rs.close();
        cn.close();
    }
   
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    
    }
        
    public Raporlama() {
        super("Raporlama Formu");       
        initComponents();
        UrunListeGuncelle();
        Test a=new Test();
        a.sayı_sonuc();//interface de tanımladığımız sayı_sonuc u çalıştırıyoruz.
        a.satis_sonuc();//interface de tanımladığımız sayı_sonuc u çalıştırıyoruz.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_satislar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_t_urun = new javax.swing.JTextField();
        txt_t_tutar = new javax.swing.JTextField();
        satis = new javax.swing.JButton();
        Urun_Ekleme = new javax.swing.JButton();
        kullanıcıekle = new javax.swing.JButton();
        txt_arama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablo_satislar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablo_satislar);

        jLabel1.setText("Satılan Toplam Ürün");

        jLabel2.setText("Toplam Satış Tutarı");

        txt_t_urun.setEditable(false);

        txt_t_tutar.setEditable(false);
        txt_t_tutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_t_tutarActionPerformed(evt);
            }
        });

        satis.setText("Satislar");
        satis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisActionPerformed(evt);
            }
        });

        Urun_Ekleme.setText("Ürün Ekleme");
        Urun_Ekleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Urun_EklemeActionPerformed(evt);
            }
        });

        kullanıcıekle.setText("Yeni Kullanıcı Ekle");
        kullanıcıekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanıcıekleActionPerformed(evt);
            }
        });

        txt_arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_aramaKeyPressed(evt);
            }
        });

        jLabel3.setText("ARAMA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_t_tutar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_t_urun, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(satis, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Urun_Ekleme, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kullanıcıekle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_arama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_t_urun, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_t_tutar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satis, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Urun_Ekleme, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kullanıcıekle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Urun_EklemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Urun_EklemeActionPerformed
      urunekleme aktif = new urunekleme();
      aktif.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_Urun_EklemeActionPerformed

    private void satisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisActionPerformed
       satislar aktif = new satislar();
       aktif.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_satisActionPerformed

    private void kullanıcıekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanıcıekleActionPerformed
       uye_ekle aktif = new uye_ekle();
       aktif.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kullanıcıekleActionPerformed

    private void txt_aramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_aramaKeyPressed
     ResultSet rs;
    Connection cn = null;
    Statement st ;
    int sutunSayisi ;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement(); 
        
       String sorgu ="select * from satislar where upper(urunadi) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(kategori) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(beden) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(renk) like upper('%"+txt_arama.getText()+"%') or"
            +" kod like '%"+txt_arama.getText()+"%' or"
            +" adet like '%"+txt_arama.getText()+"%' "; //urunadı,kategori,..,adet sütünlarında büyük/küçük ayrımı olmaksızın arama yapılıyor.
       rs = st.executeQuery(sorgu);
        sutunSayisi=rs.getMetaData().getColumnCount();   
        DefaultTableModel table=new DefaultTableModel();      
        for(int i=1;i<=sutunSayisi;i++)
            table.addColumn(rs.getMetaData().getColumnName(i)); 
         while(rs.next()){
              Object[] row=new Object[sutunSayisi];
               for(int i=1;i<=sutunSayisi;i++)
                  row[i-1]=rs.getObject(i);
              table.addRow(row);
              
         }
         
         tablo_satislar.setModel(table);
         
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    }//GEN-LAST:event_txt_aramaKeyPressed

    private void txt_t_tutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_t_tutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_t_tutarActionPerformed

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
            java.util.logging.Logger.getLogger(Raporlama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Raporlama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Raporlama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Raporlama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Raporlama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Urun_Ekleme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kullanıcıekle;
    private javax.swing.JButton satis;
    private javax.swing.JTable tablo_satislar;
    private javax.swing.JTextField txt_arama;
    private javax.swing.JTextField txt_t_tutar;
    private javax.swing.JTextField txt_t_urun;
    // End of variables declaration//GEN-END:variables
}
