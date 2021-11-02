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
public class VasarlasszamlaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Vasarlas_SorSzam")
    private int vasarlasSorSzam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vevo_VevoID")
    private int vevoVevoID;

    public VasarlasszamlaPK() {
    }

    public VasarlasszamlaPK(int vasarlasSorSzam, int vevoVevoID) {
        this.vasarlasSorSzam = vasarlasSorSzam;
        this.vevoVevoID = vevoVevoID;
    }

    public int getVasarlasSorSzam() {
        return vasarlasSorSzam;
    }

    public void setVasarlasSorSzam(int vasarlasSorSzam) {
        this.vasarlasSorSzam = vasarlasSorSzam;
    }

    public int getVevoVevoID() {
        return vevoVevoID;
    }

    public void setVevoVevoID(int vevoVevoID) {
        this.vevoVevoID = vevoVevoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) vasarlasSorSzam;
        hash += (int) vevoVevoID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VasarlasszamlaPK)) {
            return false;
        }
        VasarlasszamlaPK other = (VasarlasszamlaPK) object;
        if (this.vasarlasSorSzam != other.vasarlasSorSzam) {
            return false;
        }
        if (this.vevoVevoID != other.vevoVevoID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VasarlasszamlaPK[ vasarlasSorSzam=" + vasarlasSorSzam + ", vevoVevoID=" + vevoVevoID + " ]";
    }
    
}
