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
@Table(name = "szerviz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szerviz.findAll", query = "SELECT s FROM Szerviz s")
    , @NamedQuery(name = "Szerviz.findBySzervizID", query = "SELECT s FROM Szerviz s WHERE s.szervizID = :szervizID")
    , @NamedQuery(name = "Szerviz.findBySzervizNev", query = "SELECT s FROM Szerviz s WHERE s.szervizNev = :szervizNev")
    , @NamedQuery(name = "Szerviz.findBySzervizElerhetoseg", query = "SELECT s FROM Szerviz s WHERE s.szervizElerhetoseg = :szervizElerhetoseg")})
public class Szerviz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SzervizID")
    private Integer szervizID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SzervizNev")
    private String szervizNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SzervizElerhetoseg")
    private String szervizElerhetoseg;

    public Szerviz() {
    }

    public Szerviz(Integer szervizID) {
        this.szervizID = szervizID;
    }

    public Szerviz(Integer szervizID, String szervizNev, String szervizElerhetoseg) {
        this.szervizID = szervizID;
        this.szervizNev = szervizNev;
        this.szervizElerhetoseg = szervizElerhetoseg;
    }

    public Integer getSzervizID() {
        return szervizID;
    }

    public void setSzervizID(Integer szervizID) {
        this.szervizID = szervizID;
    }

    public String getSzervizNev() {
        return szervizNev;
    }

    public void setSzervizNev(String szervizNev) {
        this.szervizNev = szervizNev;
    }

    public String getSzervizElerhetoseg() {
        return szervizElerhetoseg;
    }

    public void setSzervizElerhetoseg(String szervizElerhetoseg) {
        this.szervizElerhetoseg = szervizElerhetoseg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (szervizID != null ? szervizID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szerviz)) {
            return false;
        }
        Szerviz other = (Szerviz) object;
        if ((this.szervizID == null && other.szervizID != null) || (this.szervizID != null && !this.szervizID.equals(other.szervizID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Szerviz[ szervizID=" + szervizID + " ]";
    }
    
}
