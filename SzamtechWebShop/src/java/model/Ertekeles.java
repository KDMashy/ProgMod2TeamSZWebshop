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
@Table(name = "ertekeles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ertekeles.findAll", query = "SELECT e FROM Ertekeles e")
    , @NamedQuery(name = "Ertekeles.findByErtekID", query = "SELECT e FROM Ertekeles e WHERE e.ertekID = :ertekID")
    , @NamedQuery(name = "Ertekeles.findByTErtekID", query = "SELECT e FROM Ertekeles e WHERE e.tErtekID = :tErtekID")
    , @NamedQuery(name = "Ertekeles.findByErtek", query = "SELECT e FROM Ertekeles e WHERE e.ertek = :ertek")
    , @NamedQuery(name = "Ertekeles.findByComment", query = "SELECT e FROM Ertekeles e WHERE e.comment = :comment")})
public class Ertekeles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ErtekID")
    private Integer ertekID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tErtekID")
    private int tErtekID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ertek")
    private int ertek;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Comment")
    private String comment;

    public Ertekeles() {
    }

    public Ertekeles(Integer ertekID) {
        this.ertekID = ertekID;
    }

    public Ertekeles(Integer ertekID, int tErtekID, int ertek, String comment) {
        this.ertekID = ertekID;
        this.tErtekID = tErtekID;
        this.ertek = ertek;
        this.comment = comment;
    }

    public Integer getErtekID() {
        return ertekID;
    }

    public void setErtekID(Integer ertekID) {
        this.ertekID = ertekID;
    }

    public int getTErtekID() {
        return tErtekID;
    }

    public void setTErtekID(int tErtekID) {
        this.tErtekID = tErtekID;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ertekID != null ? ertekID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ertekeles)) {
            return false;
        }
        Ertekeles other = (Ertekeles) object;
        if ((this.ertekID == null && other.ertekID != null) || (this.ertekID != null && !this.ertekID.equals(other.ertekID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ertekeles[ ertekID=" + ertekID + " ]";
    }
    
}
