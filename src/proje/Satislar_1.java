/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Kubra
 */
@Entity
@Table(name = "SATISLAR", catalog = "", schema = "DURSUN")
@NamedQueries({
    @NamedQuery(name = "Satislar_1.findAll", query = "SELECT s FROM Satislar_1 s")
    , @NamedQuery(name = "Satislar_1.findByKod", query = "SELECT s FROM Satislar_1 s WHERE s.kod = :kod")
    , @NamedQuery(name = "Satislar_1.findByKategori", query = "SELECT s FROM Satislar_1 s WHERE s.kategori = :kategori")
    , @NamedQuery(name = "Satislar_1.findBy\u00dcr\u00fcnadi", query = "SELECT s FROM Satislar_1 s WHERE s.\u00fcr\u00fcnadi = :\u00fcr\u00fcnadi")
    , @NamedQuery(name = "Satislar_1.findByFiyat", query = "SELECT s FROM Satislar_1 s WHERE s.fiyat = :fiyat")
    , @NamedQuery(name = "Satislar_1.findByAdet", query = "SELECT s FROM Satislar_1 s WHERE s.adet = :adet")
    , @NamedQuery(name = "Satislar_1.findByToplam\u00dccret", query = "SELECT s FROM Satislar_1 s WHERE s.toplam\u00dccret = :toplam\u00dccret")})
public class Satislar_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "KOD")
    private BigDecimal kod;
    @Basic(optional = false)
    @Column(name = "KATEGORI")
    private String kategori;
    @Basic(optional = false)
    @Column(name = "\u00dcR\u00dcNADI")
    private String ürünadi;
    @Basic(optional = false)
    @Column(name = "FIYAT")
    private BigInteger fiyat;
    @Basic(optional = false)
    @Column(name = "ADET")
    private BigInteger adet;
    @Column(name = "TOPLAM_\u00dcCRET")
    private BigInteger toplamÜcret;

    public Satislar_1() {
    }

    public Satislar_1(BigDecimal kod) {
        this.kod = kod;
    }

    public Satislar_1(BigDecimal kod, String kategori, String ürünadi, BigInteger fiyat, BigInteger adet) {
        this.kod = kod;
        this.kategori = kategori;
        this.ürünadi = ürünadi;
        this.fiyat = fiyat;
        this.adet = adet;
    }

    public BigDecimal getKod() {
        return kod;
    }

    public void setKod(BigDecimal kod) {
        BigDecimal oldKod = this.kod;
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

    public String getÜrünadi() {
        return ürünadi;
    }

    public void setÜrünadi(String ürünadi) {
        String oldÜrünadi = this.ürünadi;
        this.ürünadi = ürünadi;
        changeSupport.firePropertyChange("\u00fcr\u00fcnadi", oldÜrünadi, ürünadi);
    }

    public BigInteger getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigInteger fiyat) {
        BigInteger oldFiyat = this.fiyat;
        this.fiyat = fiyat;
        changeSupport.firePropertyChange("fiyat", oldFiyat, fiyat);
    }

    public BigInteger getAdet() {
        return adet;
    }

    public void setAdet(BigInteger adet) {
        BigInteger oldAdet = this.adet;
        this.adet = adet;
        changeSupport.firePropertyChange("adet", oldAdet, adet);
    }

    public BigInteger getToplamÜcret() {
        return toplamÜcret;
    }

    public void setToplamÜcret(BigInteger toplamÜcret) {
        BigInteger oldToplamÜcret = this.toplamÜcret;
        this.toplamÜcret = toplamÜcret;
        changeSupport.firePropertyChange("toplam\u00dccret", oldToplamÜcret, toplamÜcret);
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
        if (!(object instanceof Satislar_1)) {
            return false;
        }
        Satislar_1 other = (Satislar_1) object;
        if ((this.kod == null && other.kod != null) || (this.kod != null && !this.kod.equals(other.kod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje.Satislar_1[ kod=" + kod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
