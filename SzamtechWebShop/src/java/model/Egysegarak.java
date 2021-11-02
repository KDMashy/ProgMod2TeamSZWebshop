/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domak
 */
@Entity
@Table(name = "egysegarak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Egysegarak.findAll", query = "SELECT e FROM Egysegarak e")
    , @NamedQuery(name = "Egysegarak.findByVasarlasSorSzam", query = "SELECT e FROM Egysegarak e WHERE e.egysegarakPK.vasarlasSorSzam = :vasarlasSorSzam")
    , @NamedQuery(name = "Egysegarak.findByTermekTermekID", query = "SELECT e FROM Egysegarak e WHERE e.egysegarakPK.termekTermekID = :termekTermekID")
    , @NamedQuery(name = "Egysegarak.findByTermekTermekAr", query = "SELECT e FROM Egysegarak e WHERE e.termekTermekAr = :termekTermekAr")
    , @NamedQuery(name = "Egysegarak.findByTermekMennyiseg", query = "SELECT e FROM Egysegarak e WHERE e.termekMennyiseg = :termekMennyiseg")})
public class Egysegarak implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EgysegarakPK egysegarakPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Termek_TermekAr")
    private int termekTermekAr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Termek_Mennyiseg")
    private int termekMennyiseg;

    public Egysegarak() {
    }

    public Egysegarak(EgysegarakPK egysegarakPK) {
        this.egysegarakPK = egysegarakPK;
    }

    public Egysegarak(EgysegarakPK egysegarakPK, int termekTermekAr, int termekMennyiseg) {
        this.egysegarakPK = egysegarakPK;
        this.termekTermekAr = termekTermekAr;
        this.termekMennyiseg = termekMennyiseg;
    }

    public Egysegarak(int vasarlasSorSzam, int termekTermekID) {
        this.egysegarakPK = new EgysegarakPK(vasarlasSorSzam, termekTermekID);
    }

    public EgysegarakPK getEgysegarakPK() {
        return egysegarakPK;
    }

    public void setEgysegarakPK(EgysegarakPK egysegarakPK) {
        this.egysegarakPK = egysegarakPK;
    }

    public int getTermekTermekAr() {
        return termekTermekAr;
    }

    public void setTermekTermekAr(int termekTermekAr) {
        this.termekTermekAr = termekTermekAr;
    }

    public int getTermekMennyiseg() {
        return termekMennyiseg;
    }

    public void setTermekMennyiseg(int termekMennyiseg) {
        this.termekMennyiseg = termekMennyiseg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (egysegarakPK != null ? egysegarakPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Egysegarak)) {
            return false;
        }
        Egysegarak other = (Egysegarak) object;
        if ((this.egysegarakPK == null && other.egysegarakPK != null) || (this.egysegarakPK != null && !this.egysegarakPK.equals(other.egysegarakPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Egysegarak[ egysegarakPK=" + egysegarakPK + " ]";
    }
    
}
