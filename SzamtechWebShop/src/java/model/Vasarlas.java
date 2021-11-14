/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domak
 */
@Entity
@Table(name = "vasarlas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vasarlas.findAll", query = "SELECT v FROM Vasarlas v")
    , @NamedQuery(name = "Vasarlas.findBySorSzam", query = "SELECT v FROM Vasarlas v WHERE v.sorSzam = :sorSzam")
    , @NamedQuery(name = "Vasarlas.findByFelhasznalo", query = "SELECT v FROM Vasarlas v WHERE v.felhasznalo = :felhasznalo")
    , @NamedQuery(name = "Vasarlas.findBySzamla", query = "SELECT v FROM Vasarlas v WHERE v.szamla = :szamla")
    , @NamedQuery(name = "Vasarlas.findByFizMod", query = "SELECT v FROM Vasarlas v WHERE v.fizMod = :fizMod")
    , @NamedQuery(name = "Vasarlas.findByOsszeg", query = "SELECT v FROM Vasarlas v WHERE v.osszeg = :osszeg")
    , @NamedQuery(name = "Vasarlas.findByIRSzam", query = "SELECT v FROM Vasarlas v WHERE v.iRSzam = :iRSzam")
    , @NamedQuery(name = "Vasarlas.findByVaros", query = "SELECT v FROM Vasarlas v WHERE v.varos = :varos")
    , @NamedQuery(name = "Vasarlas.findByUtcaHSzam", query = "SELECT v FROM Vasarlas v WHERE v.utcaHSzam = :utcaHSzam")
    , @NamedQuery(name = "Vasarlas.findByIdopont", query = "SELECT v FROM Vasarlas v WHERE v.idopont = :idopont")
    , @NamedQuery(name = "Vasarlas.findByEgyeb", query = "SELECT v FROM Vasarlas v WHERE v.egyeb = :egyeb")})
public class Vasarlas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SorSzam")
    private Integer sorSzam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Felhasznalo")
    private String felhasznalo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Szamla")
    private short szamla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FizMod")
    private String fizMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Osszeg")
    private int osszeg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IRSzam")
    private String iRSzam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Varos")
    private String varos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "UtcaHSzam")
    private String utcaHSzam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Idopont")
    private String idopont;
    @Size(max = 10000)
    @Column(name = "Egyeb")
    private String egyeb;

    public Vasarlas() {
    }

    public Vasarlas(Integer sorSzam) {
        this.sorSzam = sorSzam;
    }

    public Vasarlas(Integer sorSzam, String felhasznalo, short szamla, String fizMod, int osszeg, String iRSzam, String varos, String utcaHSzam, String idopont) {
        this.sorSzam = sorSzam;
        this.felhasznalo = felhasznalo;
        this.szamla = szamla;
        this.fizMod = fizMod;
        this.osszeg = osszeg;
        this.iRSzam = iRSzam;
        this.varos = varos;
        this.utcaHSzam = utcaHSzam;
        this.idopont = idopont;
    }

    public Integer getSorSzam() {
        return sorSzam;
    }

    public void setSorSzam(Integer sorSzam) {
        this.sorSzam = sorSzam;
    }

    public String getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(String felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    public short getSzamla() {
        return szamla;
    }

    public void setSzamla(short szamla) {
        this.szamla = szamla;
    }

    public String getFizMod() {
        return fizMod;
    }

    public void setFizMod(String fizMod) {
        this.fizMod = fizMod;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public String getIRSzam() {
        return iRSzam;
    }

    public void setIRSzam(String iRSzam) {
        this.iRSzam = iRSzam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getUtcaHSzam() {
        return utcaHSzam;
    }

    public void setUtcaHSzam(String utcaHSzam) {
        this.utcaHSzam = utcaHSzam;
    }

    public String getIdopont() {
        return idopont;
    }

    public void setIdopont(String idopont) {
        this.idopont = idopont;
    }

    public String getEgyeb() {
        return egyeb;
    }

    public void setEgyeb(String egyeb) {
        this.egyeb = egyeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sorSzam != null ? sorSzam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vasarlas)) {
            return false;
        }
        Vasarlas other = (Vasarlas) object;
        if ((this.sorSzam == null && other.sorSzam != null) || (this.sorSzam != null && !this.sorSzam.equals(other.sorSzam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vasarlas[ sorSzam=" + sorSzam + " ]";
    }
    
}
