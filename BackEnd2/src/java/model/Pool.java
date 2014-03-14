/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "POOL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pool.findAll", query = "SELECT p FROM Pool p"),
    @NamedQuery(name = "Pool.findByPoolname", query = "SELECT p FROM Pool p WHERE p.poolname = :poolname")})
public class Pool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "POOLNAME")
    private String poolname;
    @ManyToMany(mappedBy = "poolCollection")
    private Collection<Electivesubject> electivesubjectCollection;

    public Pool() {
    }

    public Pool(String poolname) {
        this.poolname = poolname;
    }

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    @XmlTransient
    public Collection<Electivesubject> getElectivesubjectCollection() {
        return electivesubjectCollection;
    }

    public void setElectivesubjectCollection(Collection<Electivesubject> electivesubjectCollection) {
        this.electivesubjectCollection = electivesubjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poolname != null ? poolname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pool)) {
            return false;
        }
        Pool other = (Pool) object;
        if ((this.poolname == null && other.poolname != null) || (this.poolname != null && !this.poolname.equals(other.poolname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pool[ poolname=" + poolname + " ]";
    }
    
}
