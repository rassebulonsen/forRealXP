/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherid", query = "SELECT t FROM Teacher t WHERE t.teacherid = :teacherid")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEACHERID")
    private BigDecimal teacherid;
    @ManyToMany(mappedBy = "teacherCollection")
    private Collection<Electivesubject> electivesubjectCollection;
    @JoinColumn(name = "TEACHERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Teacher() {
    }

    public Teacher(BigDecimal teacherid) {
        this.teacherid = teacherid;
    }

    public BigDecimal getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(BigDecimal teacherid) {
        this.teacherid = teacherid;
    }

    @XmlTransient
    public Collection<Electivesubject> getElectivesubjectCollection() {
        return electivesubjectCollection;
    }

    public void setElectivesubjectCollection(Collection<Electivesubject> electivesubjectCollection) {
        this.electivesubjectCollection = electivesubjectCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Teacher[ teacherid=" + teacherid + " ]";
    }
    
}
