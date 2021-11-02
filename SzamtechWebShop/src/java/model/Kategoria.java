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
@Table(name = "kategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategoria.findAll", query = "SELECT k FROM Kategoria k")
    , @NamedQuery(name = "Kategoria.findByKategoriaID", query = "SELECT k FROM Kategoria k WHERE k.kategoriaID = :kategoriaID")
    , @NamedQuery(name = "Kategoria.findByKategoriaNev", query = "SELECT k FROM Kategoria k WHERE k.kategoriaNev = :kategoriaNev")})
public class Kategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KategoriaID")
    private Integer kategoriaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "KategoriaNev")
    private String kategoriaNev;

    public Kategoria() {
    }

    public Kategoria(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public Kategoria(Integer kategoriaID, String kategoriaNev) {
        this.kategoriaID = kategoriaID;
        this.kategoriaNev = kategoriaNev;
    }

    public Integer getKategoriaID() {
        return kategoriaID;
    }

    public void setKategoriaID(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public String getKategoriaNev() {
        return kategoriaNev;
    }

    public void setKategoriaNev(String kategoriaNev) {
        this.kategoriaNev = kategoriaNev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriaID != null ? kategoriaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.kategoriaID == null && other.kategoriaID != null) || (this.kategoriaID != null && !this.kategoriaID.equals(other.kategoriaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Kategoria[ kategoriaID=" + kategoriaID + " ]";
    }
    
}
