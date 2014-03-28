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
 * @author Rasmus
 */
@Entity
@Table(name = "STUDENT_ROUND2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentRound2.findAll", query = "SELECT s FROM StudentRound2 s"),
    @NamedQuery(name = "StudentRound2.findByStuid", query = "SELECT s FROM StudentRound2 s WHERE s.stuid = :stuid"),
    @NamedQuery(name = "StudentRound2.findByFirstpripoolaelectivesubjid", query = "SELECT s FROM StudentRound2 s WHERE s.firstpripoolaelectivesubjid = :firstpripoolaelectivesubjid"),
    @NamedQuery(name = "StudentRound2.findBySecondpripoolaelectivesubjid", query = "SELECT s FROM StudentRound2 s WHERE s.secondpripoolaelectivesubjid = :secondpripoolaelectivesubjid"),
    @NamedQuery(name = "StudentRound2.findByFirstpripoolb1electivesubjid", query = "SELECT s FROM StudentRound2 s WHERE s.firstpripoolb1electivesubjid = :firstpripoolb1electivesubjid"),
    @NamedQuery(name = "StudentRound2.findBySecondpripoolbelectivesubjid", query = "SELECT s FROM StudentRound2 s WHERE s.secondpripoolbelectivesubjid = :secondpripoolbelectivesubjid")})
public class StudentRound2 implements Serializable {
    @Column(name = "FIRSTPRIPOOLAELECTIVESUBJID")
    private Integer firstpripoolaelectivesubjid;
    @Column(name = "SECONDPRIPOOLAELECTIVESUBJID")
    private Integer secondpripoolaelectivesubjid;
    @Column(name = "FIRSTPRIPOOLB1ELECTIVESUBJID")
    private Integer firstpripoolb1electivesubjid;
    @Column(name = "SECONDPRIPOOLBELECTIVESUBJID")
    private Integer secondpripoolbelectivesubjid;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUID")
    private Integer stuid;
    @JoinColumn(name = "STUID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public StudentRound2() {
    }

    public StudentRound2(Integer stuid) {
        this.stuid = stuid;
    }

    public StudentRound2(Integer stuid, Integer firstpripoolaelectivesubjid, Integer secondpripoolaelectivesubjid, Integer firstpripoolb1electivesubjid, Integer secondpripoolbelectivesubjid, Person person) {
        this.stuid = stuid;
        this.firstpripoolaelectivesubjid = firstpripoolaelectivesubjid;
        this.secondpripoolaelectivesubjid = secondpripoolaelectivesubjid;
        this.firstpripoolb1electivesubjid = firstpripoolb1electivesubjid;
        this.secondpripoolbelectivesubjid = secondpripoolbelectivesubjid;
        this.person = person;
    }
    
    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
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
        if (!(object instanceof StudentRound2)) {
            return false;
        }
        StudentRound2 other = (StudentRound2) object;
        if ((this.stuid == null && other.stuid != null) || (this.stuid != null && !this.stuid.equals(other.stuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StudentRound2[ stuid=" + stuid + " ]";
    }

    public Integer getFirstpripoolaelectivesubjid() {
        return firstpripoolaelectivesubjid;
    }

    public void setFirstpripoolaelectivesubjid(Integer firstpripoolaelectivesubjid) {
        this.firstpripoolaelectivesubjid = firstpripoolaelectivesubjid;
    }

    public Integer getSecondpripoolaelectivesubjid() {
        return secondpripoolaelectivesubjid;
    }

    public void setSecondpripoolaelectivesubjid(Integer secondpripoolaelectivesubjid) {
        this.secondpripoolaelectivesubjid = secondpripoolaelectivesubjid;
    }

    public Integer getFirstpripoolb1electivesubjid() {
        return firstpripoolb1electivesubjid;
    }

    public void setFirstpripoolb1electivesubjid(Integer firstpripoolb1electivesubjid) {
        this.firstpripoolb1electivesubjid = firstpripoolb1electivesubjid;
    }

    public Integer getSecondpripoolbelectivesubjid() {
        return secondpripoolbelectivesubjid;
    }

    public void setSecondpripoolbelectivesubjid(Integer secondpripoolbelectivesubjid) {
        this.secondpripoolbelectivesubjid = secondpripoolbelectivesubjid;
    }
    
}
