/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByFname", query = "SELECT p FROM Person p WHERE p.fname = :fname"),
    @NamedQuery(name = "Person.findByLname", query = "SELECT p FROM Person p WHERE p.lname = :lname"),
    @NamedQuery(name = "Person.findByCpr", query = "SELECT p FROM Person p WHERE p.cpr = :cpr"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password")})
@SequenceGenerator(name = "PERSEQ", sequenceName = "person_seq")
public class Person implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private StudentRound2 studentRound2;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator = "PERSEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Size(max = 20)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 20)
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "CPR")
    private Integer cpr;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Teacher teacher;

    public Person() {
    }

//    public Person(Integer id) {
//        this.id = id;
//    }

    public Person( String fname, String lname, Integer cpr, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.cpr = cpr;
        this.email = email;
        this.password = password;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
        this.cpr = cpr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Person[ id=" + id + " ]";
    }

    public StudentRound2 getStudentRound2() {
        return studentRound2;
    }

    public void setStudentRound2(StudentRound2 studentRound2) {
        this.studentRound2 = studentRound2;
    }
    
}
