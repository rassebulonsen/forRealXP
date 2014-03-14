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
import javax.persistence.JoinTable;
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
@Table(name = "ELECTIVESUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electivesubject.findAll", query = "SELECT e FROM Electivesubject e"),
    @NamedQuery(name = "Electivesubject.findBySubjectid", query = "SELECT e FROM Electivesubject e WHERE e.subjectid = :subjectid"),
    @NamedQuery(name = "Electivesubject.findByName", query = "SELECT e FROM Electivesubject e WHERE e.name = :name"),
    @NamedQuery(name = "Electivesubject.findByDescription", query = "SELECT e FROM Electivesubject e WHERE e.description = :description")})
public class Electivesubject implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECTID")
    private Integer subjectid;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "POOL_SUBJECTS", joinColumns = {
        @JoinColumn(name = "SUBJECTID", referencedColumnName = "SUBJECTID")}, inverseJoinColumns = {
        @JoinColumn(name = "POOLNAME", referencedColumnName = "POOLNAME")})
    @ManyToMany
    private Collection<Pool> poolCollection;
    @JoinTable(name = "TEACHER_SUBJECT", joinColumns = {
        @JoinColumn(name = "SUBJECTID", referencedColumnName = "SUBJECTID")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHERID", referencedColumnName = "TEACHERID")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;

    public Electivesubject() {
    }

    public Electivesubject(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Pool> getPoolCollection() {
        return poolCollection;
    }

    public void setPoolCollection(Collection<Pool> poolCollection) {
        this.poolCollection = poolCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectid != null ? subjectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Electivesubject)) {
            return false;
        }
        Electivesubject other = (Electivesubject) object;
        if ((this.subjectid == null && other.subjectid != null) || (this.subjectid != null && !this.subjectid.equals(other.subjectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Electivesubject[ subjectid=" + subjectid + " ]";
    }
    
}
