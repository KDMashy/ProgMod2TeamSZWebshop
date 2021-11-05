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
@Table(name = "termek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Termek.findAll", query = "SELECT t FROM Termek t")
    , @NamedQuery(name = "Termek.findByTermekID", query = "SELECT t FROM Termek t WHERE t.termekID = :termekID")
    , @NamedQuery(name = "Termek.findByTermekNev", query = "SELECT t FROM Termek t WHERE t.termekNev = :termekNev")
    , @NamedQuery(name = "Termek.findByTermekDesc", query = "SELECT t FROM Termek t WHERE t.termekDesc = :termekDesc")
    , @NamedQuery(name = "Termek.findByTermekAr", query = "SELECT t FROM Termek t WHERE t.termekAr = :termekAr")
    , @NamedQuery(name = "Termek.findByTermekKep", query = "SELECT t FROM Termek t WHERE t.termekKep = :termekKep")
    , @NamedQuery(name = "Termek.findByTermekKeszlet", query = "SELECT t FROM Termek t WHERE t.termekKeszlet = :termekKeszlet")
    , @NamedQuery(name = "Termek.findByTermekKatID", query = "SELECT t FROM Termek t WHERE t.termekKatID = :termekKatID")})
public class Termek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TermekID")
    private Integer termekID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TermekNev")
    private String termekNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "TermekDesc")
    private String termekDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TermekAr")
    private int termekAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TermekKep")
    private String termekKep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TermekKeszlet")
    private short termekKeszlet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TermekKatID")
    private short termekKatID;

    public Termek() {
    }

    public Termek(Integer termekID) {
        this.termekID = termekID;
    }

    public Termek(Integer termekID, String termekNev, String termekDesc, int termekAr, String termekKep, short termekKeszlet, short termekKatID) {
        this.termekID = termekID;
        this.termekNev = termekNev;
        this.termekDesc = termekDesc;
        this.termekAr = termekAr;
        this.termekKep = termekKep;
        this.termekKeszlet = termekKeszlet;
        this.termekKatID = termekKatID;
    }

    public Integer getTermekID() {
        return termekID;
    }

    public void setTermekID(Integer termekID) {
        this.termekID = termekID;
    }

    public String getTermekNev() {
        return termekNev;
    }

    public void setTermekNev(String termekNev) {
        this.termekNev = termekNev;
    }

    public String getTermekDesc() {
        return termekDesc;
    }

    public void setTermekDesc(String termekDesc) {
        this.termekDesc = termekDesc;
    }

    public int getTermekAr() {
        return termekAr;
    }

    public void setTermekAr(int termekAr) {
        this.termekAr = termekAr;
    }

    public String getTermekKep() {
        return termekKep;
    }

    public void setTermekKep(String termekKep) {
        this.termekKep = termekKep;
    }

    public short getTermekKeszlet() {
        return termekKeszlet;
    }

    public void setTermekKeszlet(short termekKeszlet) {
        this.termekKeszlet = termekKeszlet;
    }

    public short getTermekKatID() {
        return termekKatID;
    }

    public void setTermekKatID(short termekKatID) {
        this.termekKatID = termekKatID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (termekID != null ? termekID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Termek)) {
            return false;
        }
        Termek other = (Termek) object;
        if ((this.termekID == null && other.termekID != null) || (this.termekID != null && !this.termekID.equals(other.termekID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Termek[ termekID=" + termekID + " ]";
    }
    
}
