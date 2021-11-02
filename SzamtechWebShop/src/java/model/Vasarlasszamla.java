/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domak
 */
@Entity
@Table(name = "vasarlasszamla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vasarlasszamla.findAll", query = "SELECT v FROM Vasarlasszamla v")
    , @NamedQuery(name = "Vasarlasszamla.findByVasarlasSorSzam", query = "SELECT v FROM Vasarlasszamla v WHERE v.vasarlasszamlaPK.vasarlasSorSzam = :vasarlasSorSzam")
    , @NamedQuery(name = "Vasarlasszamla.findByVevoVevoID", query = "SELECT v FROM Vasarlasszamla v WHERE v.vasarlasszamlaPK.vevoVevoID = :vevoVevoID")
    , @NamedQuery(name = "Vasarlasszamla.findByVasarlasOsszeg", query = "SELECT v FROM Vasarlasszamla v WHERE v.vasarlasOsszeg = :vasarlasOsszeg")
    , @NamedQuery(name = "Vasarlasszamla.findByVasarlasIdopont", query = "SELECT v FROM Vasarlasszamla v WHERE v.vasarlasIdopont = :vasarlasIdopont")})
public class Vasarlasszamla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VasarlasszamlaPK vasarlasszamlaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vasarlas_Osszeg")
    private int vasarlasOsszeg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VasarlasIdopont")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vasarlasIdopont;
    @JoinColumn(name = "Vasarlas_SorSzam", referencedColumnName = "SorSzam", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vasarlas vasarlas;
    @JoinColumn(name = "Vevo_VevoID", referencedColumnName = "VevoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vevo vevo;

    public Vasarlasszamla() {
    }

    public Vasarlasszamla(VasarlasszamlaPK vasarlasszamlaPK) {
        this.vasarlasszamlaPK = vasarlasszamlaPK;
    }

    public Vasarlasszamla(VasarlasszamlaPK vasarlasszamlaPK, int vasarlasOsszeg, Date vasarlasIdopont) {
        this.vasarlasszamlaPK = vasarlasszamlaPK;
        this.vasarlasOsszeg = vasarlasOsszeg;
        this.vasarlasIdopont = vasarlasIdopont;
    }

    public Vasarlasszamla(int vasarlasSorSzam, int vevoVevoID) {
        this.vasarlasszamlaPK = new VasarlasszamlaPK(vasarlasSorSzam, vevoVevoID);
    }

    public VasarlasszamlaPK getVasarlasszamlaPK() {
        return vasarlasszamlaPK;
    }

    public void setVasarlasszamlaPK(VasarlasszamlaPK vasarlasszamlaPK) {
        this.vasarlasszamlaPK = vasarlasszamlaPK;
    }

    public int getVasarlasOsszeg() {
        return vasarlasOsszeg;
    }

    public void setVasarlasOsszeg(int vasarlasOsszeg) {
        this.vasarlasOsszeg = vasarlasOsszeg;
    }

    public Date getVasarlasIdopont() {
        return vasarlasIdopont;
    }

    public void setVasarlasIdopont(Date vasarlasIdopont) {
        this.vasarlasIdopont = vasarlasIdopont;
    }

    public Vasarlas getVasarlas() {
        return vasarlas;
    }

    public void setVasarlas(Vasarlas vasarlas) {
        this.vasarlas = vasarlas;
    }

    public Vevo getVevo() {
        return vevo;
    }

    public void setVevo(Vevo vevo) {
        this.vevo = vevo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vasarlasszamlaPK != null ? vasarlasszamlaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vasarlasszamla)) {
            return false;
        }
        Vasarlasszamla other = (Vasarlasszamla) object;
        if ((this.vasarlasszamlaPK == null && other.vasarlasszamlaPK != null) || (this.vasarlasszamlaPK != null && !this.vasarlasszamlaPK.equals(other.vasarlasszamlaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vasarlasszamla[ vasarlasszamlaPK=" + vasarlasszamlaPK + " ]";
    }
    
}
