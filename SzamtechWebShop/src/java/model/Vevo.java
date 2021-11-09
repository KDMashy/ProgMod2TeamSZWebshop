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
@Table(name = "vevo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vevo.findAll", query = "SELECT v FROM Vevo v")
    , @NamedQuery(name = "Vevo.findByVevoID", query = "SELECT v FROM Vevo v WHERE v.vevoID = :vevoID")
    , @NamedQuery(name = "Vevo.findByVevoNev", query = "SELECT v FROM Vevo v WHERE v.vevoNev = :vevoNev")
    , @NamedQuery(name = "Vevo.findByVevoPassword", query = "SELECT v FROM Vevo v WHERE v.vevoPassword = :vevoPassword")
    , @NamedQuery(name = "Vevo.findByVevoEmail", query = "SELECT v FROM Vevo v WHERE v.vevoEmail = :vevoEmail")
    , @NamedQuery(name = "Vevo.findByVevoSzamCim", query = "SELECT v FROM Vevo v WHERE v.vevoSzamCim = :vevoSzamCim")
    , @NamedQuery(name = "Vevo.findByVevoAdoszam", query = "SELECT v FROM Vevo v WHERE v.vevoAdoszam = :vevoAdoszam")
    , @NamedQuery(name = "Vevo.findByTorzsVasarlo", query = "SELECT v FROM Vevo v WHERE v.torzsVasarlo = :torzsVasarlo")})
public class Vevo implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VevoID")
    private Integer vevoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VevoNev")
    private String vevoNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "VevoPassword")
    private String vevoPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VevoEmail")
    private String vevoEmail;
    @Size(max = 45)
    @Column(name = "VevoSzamCim")
    private String vevoSzamCim;
    @Size(max = 11)
    @Column(name = "VevoAdoszam")
    private String vevoAdoszam;
    @Column(name = "TorzsVasarlo")
    private Short torzsVasarlo;

    public Vevo() {
    }

    public Vevo(Integer vevoID) {
        this.vevoID = vevoID;
    }

    public Vevo(Integer vevoID, String vevoNev, String vevoPassword, String vevoEmail) {
        this.vevoID = vevoID;
        this.vevoNev = vevoNev;
        this.vevoPassword = vevoPassword;
        this.vevoEmail = vevoEmail;
    }

    public Integer getVevoID() {
        return vevoID;
    }

    public void setVevoID(Integer vevoID) {
        this.vevoID = vevoID;
    }

    public String getVevoNev() {
        return vevoNev;
    }

    public void setVevoNev(String vevoNev) {
        this.vevoNev = vevoNev;
    }

    public String getVevoPassword() {
        return vevoPassword;
    }

    public void setVevoPassword(String vevoPassword) {
        this.vevoPassword = vevoPassword;
    }

    public String getVevoEmail() {
        return vevoEmail;
    }

    public void setVevoEmail(String vevoEmail) {
        this.vevoEmail = vevoEmail;
    }

    public String getVevoSzamCim() {
        return vevoSzamCim;
    }

    public void setVevoSzamCim(String vevoSzamCim) {
        this.vevoSzamCim = vevoSzamCim;
    }

    public String getVevoAdoszam() {
        return vevoAdoszam;
    }

    public void setVevoAdoszam(String vevoAdoszam) {
        this.vevoAdoszam = vevoAdoszam;
    }

    public Short getTorzsVasarlo() {
        return torzsVasarlo;
    }

    public void setTorzsVasarlo(Short torzsVasarlo) {
        this.torzsVasarlo = torzsVasarlo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vevoID != null ? vevoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vevo)) {
            return false;
        }
        Vevo other = (Vevo) object;
        if ((this.vevoID == null && other.vevoID != null) || (this.vevoID != null && !this.vevoID.equals(other.vevoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vevo[ vevoID=" + vevoID + " ]";
    }
    
}
