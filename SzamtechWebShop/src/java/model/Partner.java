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
@Table(name = "partner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
    , @NamedQuery(name = "Partner.findByPartnerID", query = "SELECT p FROM Partner p WHERE p.partnerID = :partnerID")
    , @NamedQuery(name = "Partner.findByPartnerNev", query = "SELECT p FROM Partner p WHERE p.partnerNev = :partnerNev")
    , @NamedQuery(name = "Partner.findByPartnerElerhetoseg", query = "SELECT p FROM Partner p WHERE p.partnerElerhetoseg = :partnerElerhetoseg")
    , @NamedQuery(name = "Partner.findByPartnerAdoszam", query = "SELECT p FROM Partner p WHERE p.partnerAdoszam = :partnerAdoszam")})
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PartnerID")
    private Integer partnerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PartnerNev")
    private String partnerNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PartnerElerhetoseg")
    private String partnerElerhetoseg;
    @Size(max = 11)
    @Column(name = "PartnerAdoszam")
    private String partnerAdoszam;

    public Partner() {
    }

    public Partner(Integer partnerID) {
        this.partnerID = partnerID;
    }

    public Partner(Integer partnerID, String partnerNev, String partnerElerhetoseg) {
        this.partnerID = partnerID;
        this.partnerNev = partnerNev;
        this.partnerElerhetoseg = partnerElerhetoseg;
    }

    public Integer getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(Integer partnerID) {
        this.partnerID = partnerID;
    }

    public String getPartnerNev() {
        return partnerNev;
    }

    public void setPartnerNev(String partnerNev) {
        this.partnerNev = partnerNev;
    }

    public String getPartnerElerhetoseg() {
        return partnerElerhetoseg;
    }

    public void setPartnerElerhetoseg(String partnerElerhetoseg) {
        this.partnerElerhetoseg = partnerElerhetoseg;
    }

    public String getPartnerAdoszam() {
        return partnerAdoszam;
    }

    public void setPartnerAdoszam(String partnerAdoszam) {
        this.partnerAdoszam = partnerAdoszam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerID != null ? partnerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.partnerID == null && other.partnerID != null) || (this.partnerID != null && !this.partnerID.equals(other.partnerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Partner[ partnerID=" + partnerID + " ]";
    }
    
}
