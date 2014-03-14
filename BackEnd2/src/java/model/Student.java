/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStuid", query = "SELECT s FROM Student s WHERE s.stuid = :stuid"),
    @NamedQuery(name = "Student.findByFirstpri1electivesubjid", query = "SELECT s FROM Student s WHERE s.firstpri1electivesubjid = :firstpri1electivesubjid"),
    @NamedQuery(name = "Student.findByFirstpri2electivesubjid", query = "SELECT s FROM Student s WHERE s.firstpri2electivesubjid = :firstpri2electivesubjid"),
    @NamedQuery(name = "Student.findBySecondpri1electivesubjid", query = "SELECT s FROM Student s WHERE s.secondpri1electivesubjid = :secondpri1electivesubjid"),
    @NamedQuery(name = "Student.findBySecondpri2electivesubjid", query = "SELECT s FROM Student s WHERE s.secondpri2electivesubjid = :secondpri2electivesubjid")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUID")
    private BigDecimal stuid;
    @Column(name = "FIRSTPRI1ELECTIVESUBJID")
    private BigInteger firstpri1electivesubjid;
    @Column(name = "FIRSTPRI2ELECTIVESUBJID")
    private BigInteger firstpri2electivesubjid;
    @Column(name = "SECONDPRI1ELECTIVESUBJID")
    private BigInteger secondpri1electivesubjid;
    @Column(name = "SECONDPRI2ELECTIVESUBJID")
    private BigInteger secondpri2electivesubjid;
    @JoinColumn(name = "STUID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Student() {
    }

    public Student(BigDecimal stuid) {
        this.stuid = stuid;
    }

    public BigDecimal getStuid() {
        return stuid;
    }

    public void setStuid(BigDecimal stuid) {
        this.stuid = stuid;
    }

    public BigInteger getFirstpri1electivesubjid() {
        return firstpri1electivesubjid;
    }

    public void setFirstpri1electivesubjid(BigInteger firstpri1electivesubjid) {
        this.firstpri1electivesubjid = firstpri1electivesubjid;
    }

    public BigInteger getFirstpri2electivesubjid() {
        return firstpri2electivesubjid;
    }

    public void setFirstpri2electivesubjid(BigInteger firstpri2electivesubjid) {
        this.firstpri2electivesubjid = firstpri2electivesubjid;
    }

    public BigInteger getSecondpri1electivesubjid() {
        return secondpri1electivesubjid;
    }

    public void setSecondpri1electivesubjid(BigInteger secondpri1electivesubjid) {
        this.secondpri1electivesubjid = secondpri1electivesubjid;
    }

    public BigInteger getSecondpri2electivesubjid() {
        return secondpri2electivesubjid;
    }

    public void setSecondpri2electivesubjid(BigInteger secondpri2electivesubjid) {
        this.secondpri2electivesubjid = secondpri2electivesubjid;
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
        hash += (stuid != null ? stuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stuid == null && other.stuid != null) || (this.stuid != null && !this.stuid.equals(other.stuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ stuid=" + stuid + " ]";
    }
    
}
