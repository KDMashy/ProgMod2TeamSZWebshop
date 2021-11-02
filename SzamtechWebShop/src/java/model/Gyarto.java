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
@Table(name = "gyarto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gyarto.findAll", query = "SELECT g FROM Gyarto g")
    , @NamedQuery(name = "Gyarto.findByGyartoID", query = "SELECT g FROM Gyarto g WHERE g.gyartoID = :gyartoID")
    , @NamedQuery(name = "Gyarto.findByGyartoNev", query = "SELECT g FROM Gyarto g WHERE g.gyartoNev = :gyartoNev")
    , @NamedQuery(name = "Gyarto.findByGyartoElerhetoseg", query = "SELECT g FROM Gyarto g WHERE g.gyartoElerhetoseg = :gyartoElerhetoseg")
    , @NamedQuery(name = "Gyarto.findByGyartoiGarancia", query = "SELECT g FROM Gyarto g WHERE g.gyartoiGarancia = :gyartoiGarancia")})
public class Gyarto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GyartoID")
    private Integer gyartoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "GyartoNev")
    private String gyartoNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "GyartoElerhetoseg")
    private String gyartoElerhetoseg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GyartoiGarancia")
    private short gyartoiGarancia;

    public Gyarto() {
    }

    public Gyarto(Integer gyartoID) {
        this.gyartoID = gyartoID;
    }

    public Gyarto(Integer gyartoID, String gyartoNev, String gyartoElerhetoseg, short gyartoiGarancia) {
        this.gyartoID = gyartoID;
        this.gyartoNev = gyartoNev;
        this.gyartoElerhetoseg = gyartoElerhetoseg;
        this.gyartoiGarancia = gyartoiGarancia;
    }

    public Integer getGyartoID() {
        return gyartoID;
    }

    public void setGyartoID(Integer gyartoID) {
        this.gyartoID = gyartoID;
    }

    public String getGyartoNev() {
        return gyartoNev;
    }

    public void setGyartoNev(String gyartoNev) {
        this.gyartoNev = gyartoNev;
    }

    public String getGyartoElerhetoseg() {
        return gyartoElerhetoseg;
    }

    public void setGyartoElerhetoseg(String gyartoElerhetoseg) {
        this.gyartoElerhetoseg = gyartoElerhetoseg;
    }

    public short getGyartoiGarancia() {
        return gyartoiGarancia;
    }

    public void setGyartoiGarancia(short gyartoiGarancia) {
        this.gyartoiGarancia = gyartoiGarancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gyartoID != null ? gyartoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gyarto)) {
            return false;
        }
        Gyarto other = (Gyarto) object;
        if ((this.gyartoID == null && other.gyartoID != null) || (this.gyartoID != null && !this.gyartoID.equals(other.gyartoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gyarto[ gyartoID=" + gyartoID + " ]";
    }
    
}
