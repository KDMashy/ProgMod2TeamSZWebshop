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
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByAdminid", query = "SELECT a FROM Admin a WHERE a.adminid = :adminid")
    , @NamedQuery(name = "Admin.findByAdminname", query = "SELECT a FROM Admin a WHERE a.adminname = :adminname")
    , @NamedQuery(name = "Admin.findByAdminpassword", query = "SELECT a FROM Admin a WHERE a.adminpassword = :adminpassword")
    , @NamedQuery(name = "Admin.findByAdmincode", query = "SELECT a FROM Admin a WHERE a.admincode = :admincode")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADMINID")
    private Integer adminid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADMINNAME")
    private String adminname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADMINPASSWORD")
    private String adminpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ADMINCODE")
    private String admincode;

    public Admin() {
    }

    public Admin(Integer adminid) {
        this.adminid = adminid;
    }

    public Admin(Integer adminid, String adminname, String adminpassword, String admincode) {
        this.adminid = adminid;
        this.adminname = adminname;
        this.adminpassword = adminpassword;
        this.admincode = admincode;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public String getAdmincode() {
        return admincode;
    }

    public void setAdmincode(String admincode) {
        this.admincode = admincode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminid != null ? adminid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminid == null && other.adminid != null) || (this.adminid != null && !this.adminid.equals(other.adminid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Admin[ adminid=" + adminid + " ]";
    }
    
}
