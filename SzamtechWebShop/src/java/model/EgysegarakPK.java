/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author domak
 */
@Embeddable
public class EgysegarakPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Vasarlas_SorSzam")
    private int vasarlasSorSzam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Termek_TermekID")
    private int termekTermekID;

    public EgysegarakPK() {
    }

    public EgysegarakPK(int vasarlasSorSzam, int termekTermekID) {
        this.vasarlasSorSzam = vasarlasSorSzam;
        this.termekTermekID = termekTermekID;
    }

    public int getVasarlasSorSzam() {
        return vasarlasSorSzam;
    }

    public void setVasarlasSorSzam(int vasarlasSorSzam) {
        this.vasarlasSorSzam = vasarlasSorSzam;
    }

    public int getTermekTermekID() {
        return termekTermekID;
    }

    public void setTermekTermekID(int termekTermekID) {
        this.termekTermekID = termekTermekID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vasarlasSorSzam;
        hash += (int) termekTermekID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgysegarakPK)) {
            return false;
        }
        EgysegarakPK other = (EgysegarakPK) object;
        if (this.vasarlasSorSzam != other.vasarlasSorSzam) {
            return false;
        }
        if (this.termekTermekID != other.termekTermekID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EgysegarakPK[ vasarlasSorSzam=" + vasarlasSorSzam + ", termekTermekID=" + termekTermekID + " ]";
    }
    
}
