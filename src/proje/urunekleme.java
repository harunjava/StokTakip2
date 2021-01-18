
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


public class urunekleme extends javax.swing.JFrame {
public void ToplamMal() {
	    ResultSet rs;
            Connection cn = null;
            Statement st ;
    
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
        st=cn.createStatement();    
     	
	 rs = st.executeQuery("select sum(adet) from urunler");//urunler tablosundaki adet sayılarını toplayıp rs ile döndürür
         rs.next();
         int toplamMal=rs.getInt(1);//döndürülen veri toplamMal değişkenine aktarılır
         String malsayısı=String.valueOf(toplamMal);// toplamMal integer değişkeni malsayısı Stringine çevrilir
         
         JOptionPane.showMessageDialog(null, malsayısı+" adet ürün var");
         rs.close();
         cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
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
public urunekleme() {
        super("Ürün Ekleme Formu");       
        initComponents();
        UrunListeGuncelle();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@localhost:1521:XEPU").createEntityManager();
        urunlerQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Urunler u");
        urunlerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : urunlerQuery.getResultList();
        urunlerQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Urunler u");
        urunlerList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : urunlerQuery1.getResultList();
        ekle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo_urunler = new javax.swing.JTable();
        txt_kod = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        txt_adi = new javax.swing.JTextField();
        txt_beden = new javax.swing.JTextField();
        txt_renk = new javax.swing.JTextField();
        txt_fiyat = new javax.swing.JTextField();
        txt_adet = new javax.swing.JTextField();
        txt_aciklama = new javax.swing.JTextField();
        lbl_kod = new javax.swing.JLabel();
        lbl_kategori = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        lbl_beden = new javax.swing.JLabel();
        lbl_renk = new javax.swing.JLabel();
        lbl_fiyat = new javax.swing.JLabel();
        lbl_adet = new javax.swing.JLabel();
        lbl_aciklama = new javax.swing.JLabel();
        guncelle = new javax.swing.JButton();
        sil = new javax.swing.JButton();
        txt_arama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_urunsatısayısı = new javax.swing.JButton();
        rapor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ekle.setText("Ekle");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, urunlerList, tablo_urunler);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kod}"));
        columnBinding.setColumnName("Kod");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${kategori}"));
        columnBinding.setColumnName("Kategori");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${urunadi}"));
        columnBinding.setColumnName("Urunadi");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${beden}"));
        columnBinding.setColumnName("Beden");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${renk}"));
        columnBinding.setColumnName("Renk");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fiyat}"));
        columnBinding.setColumnName("Fiyat");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${adet}"));
        columnBinding.setColumnName("Adet");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${aciklama}"));
        columnBinding.setColumnName("Aciklama");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        tablo_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_urunlerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablo_urunler);

        txt_kod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodActionPerformed(evt);
            }
        });

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

        lbl_beden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_beden.setText("Beden");
        lbl_beden.setName(""); // NOI18N
        lbl_beden.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_renk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_renk.setText("Renk");
        lbl_renk.setName(""); // NOI18N
        lbl_renk.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_fiyat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fiyat.setText("Fiyat");
        lbl_fiyat.setName(""); // NOI18N
        lbl_fiyat.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_adet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adet.setText("Adet");
        lbl_adet.setName(""); // NOI18N
        lbl_adet.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbl_aciklama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_aciklama.setText("Açıklama");
        lbl_aciklama.setName(""); // NOI18N
        lbl_aciklama.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        guncelle.setText("Güncelle");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });

        sil.setText("Sil");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        txt_arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_aramaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_aramaKeyReleased(evt);
            }
        });

        jLabel1.setText("ARAMA");

        btn_urunsatısayısı.setText("Ürün Sayısı");
        btn_urunsatısayısı.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunsatısayısıActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kod, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_beden, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_urunsatısayısı, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rapor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kod, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbl_kod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_kategori, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_adet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_arama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_urunsatısayısı, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rapor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
            String kod=txt_kod.getText();//textlerin içindeki bütün veriler sırasıyla değişkenlere aktarılır
            String kategori=txt_kategori.getText();
            String adi=txt_adi.getText();
            String beden=txt_beden.getText();
            String renk=txt_renk.getText();
            String fiyat=txt_fiyat.getText();
            String adet=txt_adet.getText();
            String aciklama=txt_aciklama.getText();   
            try {
                if (kategori.equals("") || adi.equals("") || renk.equals("") || fiyat.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");
                } else {            
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
                    st = con.createStatement();
                    
                    String sql = "INSERT INTO urunler (kod,kategori,urunadi,beden,renk,fiyat,adet,aciklama)" 
                            + " VALUES ('"+kod+"', '"+kategori+"', '"+adi+"', '"+beden+"', '"+renk+"', '"+fiyat+"', '"+adet+"', '"+aciklama+"')";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, adi + "  adlı ürün eklenmiştir.");
                    UrunListeGuncelle();
                }
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }  
       
        txt_kod.setText("");//kayır yapıldıktan sonra bütün textleri boşaltıyorsun
        txt_kategori.setText("");
        txt_adi.setText("");
        txt_beden.setText("");
        txt_renk.setText("");
        txt_fiyat.setText("");
        txt_adet.setText("");
        txt_aciklama.setText("");
    }//GEN-LAST:event_ekleActionPerformed

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
       try {
            
            int row = tablo_urunler.getSelectedRow(); //tabloda tıklanılan satırı seçer           
            String secim=(tablo_urunler.getValueAt(row, 0).toString()); // seçilen satırdaki 1.hücreyi seçim değişkenine atar
           
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");

            String sorgu = "UPDATE urunler SET kod='"+txt_kod.getText()+"'"
                    +",kategori='"+txt_kategori.getText()+"'"
                    +",urunadi='"+txt_adi.getText()+"'"
                    +",beden='"+txt_beden.getText()+"'"
                    +",renk='"+txt_renk.getText()+"'"
                    +",fiyat='"+txt_fiyat.getText()+"'"
                    +",adet='"+txt_adet.getText()+"'"
                    +",aciklama='"+txt_aciklama.getText()+"' where kod='"+secim+"'";//seçilen satırda güncelleme yapar.
                    
          
            st = con.createStatement();//nesne oluşturur.
            st.executeUpdate(sorgu);//sorgu çalıştırır.

            JOptionPane.showMessageDialog(null, "Ürün Güncellemesi Tamamlanmıştır.");

            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
    }//GEN-LAST:event_guncelleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        try {
            int row = tablo_urunler.getSelectedRow();            
            String secim=(tablo_urunler.getValueAt(row, 0).toString());                       
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hk", "1453");
            String sorgu = "delete from urunler where kod='"+secim+"'";                  
            st = con.createStatement();
            st.executeUpdate(sorgu);
            JOptionPane.showMessageDialog(null, "Ürün Başarıyla Silinmiştir");
       
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
        
    }//GEN-LAST:event_silActionPerformed

    private void txt_kodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kodActionPerformed

    private void tablo_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_urunlerMouseClicked
    
       DefaultTableModel model=(DefaultTableModel)tablo_urunler.getModel();
       int secim=tablo_urunler.getSelectedRow();//tabloda tıklanılan satırı seçim değişkenine atar
       txt_kod.setText(model.getValueAt(secim,0).toString());//tabloda seçilen satırı sırasıyla textlere aktarır. burdaki 0,1,2 vs seçilen satırın sütun sıralamasıdır
       txt_kategori.setText(model.getValueAt(secim,1).toString());
       txt_adi.setText(model.getValueAt(secim,2).toString());
       txt_beden.setText(model.getValueAt(secim,3).toString());
       txt_renk.setText(model.getValueAt(secim,4).toString());
       txt_fiyat.setText(model.getValueAt(secim,5).toString());
       txt_adet.setText(model.getValueAt(secim,6).toString());
       txt_aciklama.setText(model.getValueAt(secim,7).toString());
    }//GEN-LAST:event_tablo_urunlerMouseClicked

    private void txt_aramaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_aramaKeyReleased
  
    }//GEN-LAST:event_txt_aramaKeyReleased

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
            +" adet like '%"+txt_arama.getText()+"%'";// urunadı,kategori,..,adet sütünlarında büyük/küçük ayrımı olmaksızın arama yapılıyor.
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
         
         tablo_urunler.setModel(table);//aramadan sonra çıkan sonuç tabloya aktarılır
         
        rs.close();
        cn.close();
    }
    catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
    }         

    }//GEN-LAST:event_txt_aramaKeyPressed

    private void btn_urunsatısayısıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunsatısayısıActionPerformed
       Urunsayısı sonuc=new Urunsayısı();//urunsayısı classını urunekleme formunda kalıttık. yani urunekleme formunun bütün özelliklerini urunsayısı classı taşıyor. 
       sonuc.ToplamMal(); // burda urunsayısı classından bir nesne ürettik. bu nesnede urunekleme formunun bütün özelliklerini taşıyor. bu nesne ile urunekleme formunda bulunamn toplamMal metodunu çağırdık
       
       
    }//GEN-LAST:event_btn_urunsatısayısıActionPerformed

    private void raporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raporActionPerformed
       Raporlama ac=new Raporlama();
       ac.setVisible(true);
       
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
            java.util.logging.Logger.getLogger(urunekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(urunekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(urunekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(urunekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new urunekleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_urunsatısayısı;
    private javax.swing.JButton ekle;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton guncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_aciklama;
    private javax.swing.JLabel lbl_adet;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_beden;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_kod;
    private javax.swing.JLabel lbl_renk;
    protected javax.swing.JButton rapor;
    private javax.swing.JButton sil;
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
    private java.util.List<proje.Urunler> urunlerList;
    private java.util.List<proje.Urunler> urunlerList1;
    private javax.persistence.Query urunlerQuery;
    private javax.persistence.Query urunlerQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
