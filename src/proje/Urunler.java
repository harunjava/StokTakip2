/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JOptionPane;

/**
 *
 * @author Kubra
 */
@Entity
@Table(name = "URUNLER", catalog = "", schema = "DURSUN")
@NamedQueries({
    @NamedQuery(name = "Urunler.findAll", query = "SELECT u FROM Urunler u")
    , @NamedQuery(name = "Urunler.findByKod", query = "SELECT u FROM Urunler u WHERE u.kod = :kod")
    , @NamedQuery(name = "Urunler.findByKategori", query = "SELECT u FROM Urunler u WHERE u.kategori = :kategori")
    , @NamedQuery(name = "Urunler.findByUrunadi", query = "SELECT u FROM Urunler u WHERE u.urunadi = :urunadi")
    , @NamedQuery(name = "Urunler.findByBeden", query = "SELECT u FROM Urunler u WHERE u.beden = :beden")
    , @NamedQuery(name = "Urunler.findByRenk", query = "SELECT u FROM Urunler u WHERE u.renk = :renk")
    , @NamedQuery(name = "Urunler.findByFiyat", query = "SELECT u FROM Urunler u WHERE u.fiyat = :fiyat")
    , @NamedQuery(name = "Urunler.findByAdet", query = "SELECT u FROM Urunler u WHERE u.adet = :adet")
    , @NamedQuery(name = "Urunler.findByAciklama", query = "SELECT u FROM Urunler u WHERE u.aciklama = :aciklama")})
public class Urunler implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KOD")
    private Long kod;
    @Basic(optional = false)
    @Column(name = "KATEGORI")
    private String kategori;
    @Basic(optional = false)
    @Column(name = "URUNADI")
    private String urunadi;
    @Basic(optional = false)
    @Column(name = "BEDEN")
    private String beden;
    @Basic(optional = false)
    @Column(name = "RENK")
    private String renk;
    @Basic(optional = false)
    @Column(name = "FIYAT")
    private String fiyat;
    @Basic(optional = false)
    @Column(name = "ADET")
    private String adet;
    @Basic(optional = false)
    @Column(name = "ACIKLAMA")
    private String aciklama;

    public Urunler() {
    }

    public Urunler(Long kod) {
        this.kod = kod;
    }

    public Urunler(Long kod, String kategori, String urunadi, String beden, String renk, String fiyat, String adet, String aciklama) {
        this.kod = kod;
        this.kategori = kategori;
        this.urunadi = urunadi;
        this.beden = beden;
        this.renk = renk;
        this.fiyat = fiyat;
        this.adet = adet;
        this.aciklama = aciklama;
    }

    public Long getKod() {
        return kod;
    }

    public void setKod(Long kod) {
        Long oldKod = this.kod;
        this.kod = kod;
        changeSupport.firePropertyChange("kod", oldKod, kod);
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        String oldKategori = this.kategori;
        this.kategori = kategori;
        changeSupport.firePropertyChange("kategori", oldKategori, kategori);
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        String oldUrunadi = this.urunadi;
        this.urunadi = urunadi;
        changeSupport.firePropertyChange("urunadi", oldUrunadi, urunadi);
    }

    public String getBeden() {
        return beden;
    }

    public void setBeden(String beden) {
        String oldBeden = this.beden;
        this.beden = beden;
        changeSupport.firePropertyChange("beden", oldBeden, beden);
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        String oldRenk = this.renk;
        this.renk = renk;
        changeSupport.firePropertyChange("renk", oldRenk, renk);
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        String oldFiyat = this.fiyat;
        this.fiyat = fiyat;
        changeSupport.firePropertyChange("fiyat", oldFiyat, fiyat);
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        String oldAdet = this.adet;
        this.adet = adet;
        changeSupport.firePropertyChange("adet", oldAdet, adet);
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        String oldAciklama = this.aciklama;
        this.aciklama = aciklama;
        changeSupport.firePropertyChange("aciklama", oldAciklama, aciklama);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kod != null ? kod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urunler)) {
            return false;
        }
        Urunler other = (Urunler) object;
        if ((this.kod == null && other.kod != null) || (this.kod != null && !this.kod.equals(other.kod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje.Urunler[ kod=" + kod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public class Urunsayısı extends urunekleme {
}
   
   }
   
    

