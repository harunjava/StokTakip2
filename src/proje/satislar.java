
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class satislar extends javax.swing.JFrame {
   abstract class Sepet{  //sepet adında abstract classı oluşturuyoruz.
      abstract void Tutar();  }// bu abstract classına ait bir tutar metodu oluşturuyoruz
   
    class Satis extends Sepet{//satıs classını sepet abstract classına bağlıyoruz.

        @Override
        void Tutar() {
        ResultSet rs;
        Connection cn = null;
        Statement st ;
        try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement(); 
         rs = st.executeQuery("select sum(toplam_fiyat) from satisanlik");
         rs.next();
         double toplamtutar=rs.getDouble(1);
         double kdvt=toplamtutar+(toplamtutar*kdv);
         String kdvtutar=Double.toString(kdvt);
         txt_toplam.setText(kdvtutar);
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    }
            
        }
  
static int a=0;//a ve b değişkenlerine değer alsın yada almasın static ifadesi ile bellekte yer ayırıyoruz
static int b=0;
final double kdv=0.18;// kdv değişkenine değer atıyoruz ve bu değer değiştirilemez final ifadesinden dolayı
    private void UrunListeGuncelle(){
    ResultSet rs;
    Connection cn = null;
    Statement st ;
    int sutunSayisi ;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement(); 
        rs=st.executeQuery("Select * from urunler ");  
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
         tablo_urunler.setModel(table);
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         
    }
    private void SatisListeGuncelle(){
    ResultSet rs;
    Connection cn = null;
    Statement st ;
    int sutunSayisi ;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement(); 
        rs=st.executeQuery("Select * from satisanlik ");  
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
    private void sil(){
        try
        {
            Statement st = null;
            Connection cn;
            Class.forName("oracle.jdbc.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
            st = cn.createStatement();
            String sorgu="delete from satisanlik";
            st.executeUpdate(sorgu);
            cn.close();
        }catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");    
    }
    }

    public satislar() {
      super("Satış Formu");       
      initComponents();
      UrunListeGuncelle();
      SatisListeGuncelle();
      Satis sonuc=new Satis();
      sonuc.Tutar();//abstract classına bağlı satıs sınıfının içinde gövdesi tanımalanan tutar metodunu çalıştırıyoruz
      
      

    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_adet = new javax.swing.JTextField();
        txt_aciklama = new javax.swing.JTextField();
        lbl_kod = new javax.swing.JLabel();
        lbl_kategori = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        txt_kod = new javax.swing.JTextField();
        lbl_beden = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JTextField();
        lbl_renk = new javax.swing.JLabel();
        txt_adi = new javax.swing.JTextField();
        lbl_fiyat = new javax.swing.JLabel();
        txt_beden = new javax.swing.JTextField();
        lbl_adet = new javax.swing.JLabel();
        txt_renk = new javax.swing.JTextField();
        lbl_aciklama = new javax.swing.JLabel();
        txt_fiyat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_urunler = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo_satislar = new javax.swing.JTable();
        btn_sepet = new javax.swing.JButton();
        txt_arama = new javax.swing.JTextField();
        sil = new javax.swing.JButton();
        odeme = new javax.swing.JButton();
        lbl_arama = new javax.swing.JLabel();
        txt_toplam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rapor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_aciklama.setEditable(false);
        txt_aciklama.setBackground(java.awt.SystemColor.inactiveCaption);

        lbl_kod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_kod.setText("Ürün Kodu");
        lbl_kod.setToolTipText("");
        lbl_kod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_kod.setName(""); // NOI18N
        lbl_kod.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_kategori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_kategori.setText("Katagori");
        lbl_kategori.setName(""); // NOI18N
        lbl_kategori.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_adi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adi.setText("Ürün adı");
        lbl_adi.setName(""); // NOI18N
        lbl_adi.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_kod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodActionPerformed(evt);
            }
        });

        lbl_beden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_beden.setText("Beden");
        lbl_beden.setName(""); // NOI18N
        lbl_beden.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_kategori.setEditable(false);
        txt_kategori.setBackground(java.awt.SystemColor.inactiveCaption);

        lbl_renk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_renk.setText("Renk");
        lbl_renk.setName(""); // NOI18N
        lbl_renk.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_adi.setEditable(false);
        txt_adi.setBackground(java.awt.SystemColor.inactiveCaption);

        lbl_fiyat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fiyat.setText("Fiyat");
        lbl_fiyat.setName(""); // NOI18N
        lbl_fiyat.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_beden.setEditable(false);
        txt_beden.setBackground(java.awt.SystemColor.inactiveCaption);

        lbl_adet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adet.setText("Adet");
        lbl_adet.setName(""); // NOI18N
        lbl_adet.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_renk.setEditable(false);
        txt_renk.setBackground(java.awt.SystemColor.inactiveCaption);

        lbl_aciklama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_aciklama.setText("Açıklama");
        lbl_aciklama.setName(""); // NOI18N
        lbl_aciklama.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txt_fiyat.setEditable(false);
        txt_fiyat.setBackground(java.awt.SystemColor.inactiveCaption);
        txt_fiyat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_fiyatMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_fiyatMouseExited(evt);
            }
        });
        txt_fiyat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fiyatActionPerformed(evt);
            }
        });

        tablo_urunler.setModel(new javax.swing.table.DefaultTableModel(
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
        tablo_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_urunlerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_urunler);

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
        jScrollPane2.setViewportView(tablo_satislar);

        btn_sepet.setText("SEPETE AT");
        btn_sepet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sepetActionPerformed(evt);
            }
        });

        txt_arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_aramaKeyPressed(evt);
            }
        });

        sil.setText("SİL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        odeme.setText("ÖDEME YAP");
        odeme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                odemeMouseExited(evt);
            }
        });
        odeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odemeActionPerformed(evt);
            }
        });

        lbl_arama.setText("ARAMA");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOPLAM TUTAR+ kdv");

        rapor.setText("Raporlama");
        rapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raporActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_kod, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_beden, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_fiyat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_adet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_aciklama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_adet, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(txt_fiyat)
                                    .addComponent(txt_renk)
                                    .addComponent(txt_beden)
                                    .addComponent(txt_adi)
                                    .addComponent(txt_kategori)
                                    .addComponent(txt_kod)
                                    .addComponent(txt_aciklama)))
                            .addComponent(btn_sepet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(odeme, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rapor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kod, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_kod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_adi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_beden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_beden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txt_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rapor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sepet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(odeme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_kodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kodActionPerformed

    private void btn_sepetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sepetActionPerformed
        try {
            int row = tablo_urunler.getSelectedRow();            
            int secim=Integer.parseInt((tablo_urunler.getValueAt(row, 0)).toString());// seçilen satırdaki 1.hücreyi seçim değişkenine atar
             
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
            st = con.createStatement();
            
            rs = st.executeQuery("select * from urunler where kod='"+secim+"'");
            rs.next();
            
            
            
            int eski_adet=Integer.parseInt(rs.getString("adet")); //yukarıda ki sorgudan gelen "adet" sayısını integeri çevirip eski_adet değişkenine aktarıyoruz.         
            int satilan_adet = Integer.parseInt(txt_adet.getText()); // text'in içindeki verileri integere cevirip satılan_adet değişkenine aktarıyoruz.
            int kalan = eski_adet - satilan_adet;// veritabanından gelen "adet" sayısından text'in içindeki adet sayısını cıkarıyoruz.
            
            
            String sorgu1 = "UPDATE urunler SET kod='"+txt_kod.getText()+"'"
            +",kategori='"+txt_kategori.getText()+"'"
            +",urunadi='"+txt_adi.getText()+"'"
            +",beden='"+txt_beden.getText()+"'"
            +",renk='"+txt_renk.getText()+"'"
            +",fiyat='"+txt_fiyat.getText()+"'"
            +",adet='"+kalan+"'"// kalan adet sayısını veritabanına aktarıyoruz.
            +",aciklama='"+txt_aciklama.getText()+"'where kod='"+secim+"'";     
        
            st.executeUpdate(sorgu1);
          
            
            int bkod = Integer.parseInt(txt_kod.getText());// kod text'indeki değeri integer olarak bkod değişkenine aktarıyoruz.
            int s_adet = Integer.parseInt(txt_adet.getText()); //adet text'indeki değeri integer olarak s_adet değişkenine aktarıyoruz
            
            rs = st.executeQuery("select count(*) from satislar where kod='"+bkod+"'");// rs(resulset) ile satıslar satıslar tablosundaki bkod'a eşit olan satırların sayısı döndürüyoruz.
            rs.next();
            a=Integer.parseInt(rs.getString("Count(*)")); // sorgudan dönen veriyi integere çevirip a'ya aktarıyoruz.
            
            
            if(a>0)// a 0'dan büyük ise demekki satıslar tablosunda girmek istediğimiz ürünün kod numarasından var. o zaman güncelleme yapıyoruz
            {
                String sorgu="UPDATE satislar SET adet=adet+'"+s_adet+"' where kod='"+secim+"'"; // satislar tablosunda var olan ürünün adet sayısına text'e belirttiğimizi adet sayısını ekliyoruz.
                st.executeUpdate(sorgu);     
            }  else {//eğer a 0'dan büyük değilse ürün satislar tablosunda yok demektir. o zaman yeni veri olarak gireceğiz.
                String sorgu2 = "INSERT INTO satislar (kod,kategori,urunadi,beden,renk,fiyat,adet,aciklama) VALUES ("
                        + "'"+txt_kod.getText()+"', '"+txt_kategori.getText()+"', '"+txt_adi.getText()+"', '"+txt_beden.getText()+"'"
                        +", '"+txt_renk.getText()+"', '"+txt_fiyat.getText()+"', '"+txt_adet.getText()+"'"
                        +", '"+txt_aciklama.getText()+"')";
                st.executeUpdate(sorgu2); 
            }
            rs = st.executeQuery("select count(*) from satisanlik where kod='"+bkod+"'");//yukarıda ki işlemleri satisanlık(sepet) tablosuna da yapıyoruz.
            rs.next();
            
            b=Integer.parseInt(rs.getString("Count(*)"));
            if(b>0)
            {
                String sorgu="UPDATE satisanlik SET adet=adet+'"+s_adet+"' where kod='"+secim+"'";
                st.executeUpdate(sorgu);
                
            }  else {
                String sorgu = "INSERT INTO satisanlik (kod,kategori,urunadi,beden,renk,fiyat,adet,aciklama) VALUES ("
                        + "'"+txt_kod.getText()+"', '"+txt_kategori.getText()+"', '"+txt_adi.getText()+"', '"+txt_beden.getText()+"'"
                        +", '"+txt_renk.getText()+"', '"+txt_fiyat.getText()+"', '"+txt_adet.getText()+"'"
                        +", '"+txt_aciklama.getText()+"')";
                st.executeUpdate(sorgu);
            }
            
            if(kalan==0){
            String sorgu2="Delete from urunler where adet=0";
            st.executeUpdate(sorgu2);}
            JOptionPane.showMessageDialog(null, txt_adi.getText() + " adlı ürün satılmışır.");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        SatisListeGuncelle();
        UrunListeGuncelle();
        Satis sonuc=new Satis();
        sonuc.Tutar();//abstract classına bağlı tutar metodunu çaığırıyoruz.

    }//GEN-LAST:event_btn_sepetActionPerformed

    private void tablo_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_urunlerMouseClicked
       DefaultTableModel model=(DefaultTableModel)tablo_urunler.getModel();
       int secim=tablo_urunler.getSelectedRow();//tabloda tıklanılan satırı textlere aktarıyoruz.
       txt_kod.setText(model.getValueAt(secim,0).toString());
       txt_kategori.setText(model.getValueAt(secim,1).toString());
       txt_adi.setText(model.getValueAt(secim,2).toString());
       txt_beden.setText(model.getValueAt(secim,3).toString());
       txt_renk.setText(model.getValueAt(secim,4).toString());
       txt_fiyat.setText(model.getValueAt(secim,5).toString());
       txt_adet.setText(model.getValueAt(secim,6).toString());
       txt_aciklama.setText(model.getValueAt(secim,7).toString());
    }//GEN-LAST:event_tablo_urunlerMouseClicked

    private void txt_fiyatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fiyatMouseClicked
       
    }//GEN-LAST:event_txt_fiyatMouseClicked

    private void txt_fiyatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fiyatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fiyatActionPerformed

    private void txt_fiyatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fiyatMouseExited
       
       
    }//GEN-LAST:event_txt_fiyatMouseExited

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
       try {
            int row = tablo_satislar.getSelectedRow();            
            String secim=(tablo_satislar.getValueAt(row, 0).toString());                       
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = null;
            Statement st = null;
            ResultSet rs= null;
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
            st = con.createStatement();
           
            rs = st.executeQuery("select * from satisanlik where kod='"+secim+"'");
            rs.next();
            int sil_adet=Integer.parseInt(rs.getString("adet"));//yukarıdaki satısanlık tablosundaki sorgudan dönen "adet" verisini sil_adet değişkenine aktarıyoruz.
            int sil_kod=Integer.parseInt(rs.getString("kod")); //yukarıdaki satısanlık tablosundaki sorgudan dönen "kod" verisini sil_kod değişkenine aktarıyoruz.
            
            String sorgu = "delete from satisanlik where kod='"+secim+"'";
            st.executeUpdate(sorgu);//satisanlık tablosunda seçilen satırı siler
            String sorgu3="UPDATE urunler SET adet=adet+'"+sil_adet+"' where kod='"+sil_kod+"'";
            st.executeUpdate(sorgu3);//satisanlik tablosundaki silinen ürünün adetini urunler tablosundaki aynı kod numaralı ürüne ekler. 
  
            String sorgu1="UPDATE satislar SET adet=adet-'"+sil_adet+"' where kod='"+sil_kod+"'";
            st.executeUpdate(sorgu1); //satisanlik tablosundaki silinen ürünün adetini ürünler tablosundaki aynı kod numaralı üründen çıkarır.
            
            
            
            rs = st.executeQuery("select * from satislar where kod='"+sil_kod+"'");
            
            rs.next();
             int kalanadet=Integer.parseInt(rs.getString("adet"));
             if (kalanadet==0){
                 String sorgu2="Delete from satislar where adet=0";//satislar tablosunda adet sayısı 0'dan küçük olan satırları siler  
                 st.executeUpdate(sorgu2);}
             
           
            JOptionPane.showMessageDialog(null, "Ürün Başarıyla Silinmiştir");
      
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        UrunListeGuncelle();
        SatisListeGuncelle();
         Satis sonuc=new Satis();
         sonuc.Tutar();
        
    }//GEN-LAST:event_silActionPerformed

    private void odemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odemeActionPerformed
        
        String tutar=txt_toplam.getText();
       
        Object[] obje = {"Evet, Faturayı Yazdır",
                    "İptal"};
        int odeme = JOptionPane.showOptionDialog(null, "ÖDENECEK TUTAR = "+tutar+"\nDevam Etmek İstiyor musunuz", "Ödeme...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, obje, obje[1]);
            if(odeme == JOptionPane.OK_OPTION){
            try
            {
            Statement st=null;
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
            String raporsorgu="C:\\Users\\Harun\\Documents\\NetBeansProjects\\Rapor\\report2.jrxml";
           
           
            JasperReport jr=JasperCompileManager.compileReport(raporsorgu);
            
            JasperPrint jp=JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
             sil();
             con.close();
          }   
            catch (Exception ex){
             System.out.println(ex.getMessage());
        }     
         }else if (odeme == JOptionPane.NO_OPTION){
        JOptionPane.showMessageDialog(null, "Ödeme İptal Edildi");
         Satis sonuc=new Satis();
        sonuc.Tutar();
     }        
            SatisListeGuncelle();
    }//GEN-LAST:event_odemeActionPerformed

    private void odemeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odemeMouseExited

    }//GEN-LAST:event_odemeMouseExited

    private void txt_aramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_aramaKeyPressed
    ResultSet rs;
    Connection cn = null;
    Statement st ;
    int sutunSayisi ;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement(); 
        
       String sorgu ="select * from urunler where upper(urunadi) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(kategori) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(beden) like upper('%"+txt_arama.getText()+"%') or"
            +" upper(renk) like upper('%"+txt_arama.getText()+"%') or"
            +" kod like '%"+txt_arama.getText()+"%' or"
            +" adet like '%"+txt_arama.getText()+"%' ";
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
         tablo_urunler.setModel(table);
         
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         

    }//GEN-LAST:event_txt_aramaKeyPressed

    private void raporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raporActionPerformed
        Raporlama ac=new Raporlama();
        ac.setVisible(true);//Raporlama formunu aç
        
        this.setVisible(false);
    }//GEN-LAST:event_raporActionPerformed

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
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new satislar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sepet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_aciklama;
    private javax.swing.JLabel lbl_adet;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_arama;
    private javax.swing.JLabel lbl_beden;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_kod;
    private javax.swing.JLabel lbl_renk;
    private javax.swing.JButton odeme;
    protected javax.swing.JButton rapor;
    private javax.swing.JButton sil;
    private javax.swing.JTable tablo_satislar;
    private javax.swing.JTable tablo_urunler;
    private javax.swing.JTextField txt_aciklama;
    private javax.swing.JTextField txt_adet;
    private javax.swing.JTextField txt_adi;
    private javax.swing.JTextField txt_arama;
    private javax.swing.JTextField txt_beden;
    private javax.swing.JTextField txt_fiyat;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_kod;
    private javax.swing.JTextField txt_renk;
    private javax.swing.JTextField txt_toplam;
    // End of variables declaration//GEN-END:variables

    private void Sil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
