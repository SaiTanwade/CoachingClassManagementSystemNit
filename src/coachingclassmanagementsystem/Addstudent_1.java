/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coachingclassmanagementsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author saita
 */
@Entity
@Table(name = "addstudent", catalog = "coachingclass", schema = "")
@NamedQueries({
    @NamedQuery(name = "Addstudent_1.findAll", query = "SELECT a FROM Addstudent_1 a")
    , @NamedQuery(name = "Addstudent_1.findById", query = "SELECT a FROM Addstudent_1 a WHERE a.id = :id")
    , @NamedQuery(name = "Addstudent_1.findByStdname", query = "SELECT a FROM Addstudent_1 a WHERE a.stdname = :stdname")
    , @NamedQuery(name = "Addstudent_1.findByStddob", query = "SELECT a FROM Addstudent_1 a WHERE a.stddob = :stddob")
    , @NamedQuery(name = "Addstudent_1.findByGender", query = "SELECT a FROM Addstudent_1 a WHERE a.gender = :gender")
    , @NamedQuery(name = "Addstudent_1.findByStdcontact", query = "SELECT a FROM Addstudent_1 a WHERE a.stdcontact = :stdcontact")
    , @NamedQuery(name = "Addstudent_1.findByPcontact", query = "SELECT a FROM Addstudent_1 a WHERE a.pcontact = :pcontact")
    , @NamedQuery(name = "Addstudent_1.findByAdmdate", query = "SELECT a FROM Addstudent_1 a WHERE a.admdate = :admdate")
    , @NamedQuery(name = "Addstudent_1.findByClass1", query = "SELECT a FROM Addstudent_1 a WHERE a.class1 = :class1")
    , @NamedQuery(name = "Addstudent_1.findBySubject", query = "SELECT a FROM Addstudent_1 a WHERE a.subject = :subject")
    , @NamedQuery(name = "Addstudent_1.findByAddress", query = "SELECT a FROM Addstudent_1 a WHERE a.address = :address")
    , @NamedQuery(name = "Addstudent_1.findByRemark", query = "SELECT a FROM Addstudent_1 a WHERE a.remark = :remark")
    , @NamedQuery(name = "Addstudent_1.findByTotal", query = "SELECT a FROM Addstudent_1 a WHERE a.total = :total")
    , @NamedQuery(name = "Addstudent_1.findByFeespaid", query = "SELECT a FROM Addstudent_1 a WHERE a.feespaid = :feespaid")
    , @NamedQuery(name = "Addstudent_1.findByFeesremaining", query = "SELECT a FROM Addstudent_1 a WHERE a.feesremaining = :feesremaining")})
public class Addstudent_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "stdname")
    private String stdname;
    @Column(name = "stddob")
    private String stddob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "stdcontact")
    private BigInteger stdcontact;
    @Column(name = "pcontact")
    private BigInteger pcontact;
    @Column(name = "admdate")
    private String admdate;
    @Column(name = "class")
    private String class1;
    @Column(name = "subject")
    private String subject;
    @Column(name = "address")
    private String address;
    @Column(name = "remark")
    private String remark;
    @Column(name = "total")
    private Integer total;
    @Basic(optional = false)
    @Column(name = "feespaid")
    private int feespaid;
    @Basic(optional = false)
    @Column(name = "feesremaining")
    private int feesremaining;

    public Addstudent_1() {
    }

    public Addstudent_1(Integer id) {
        this.id = id;
    }

    public Addstudent_1(Integer id, int feespaid, int feesremaining) {
        this.id = id;
        this.feespaid = feespaid;
        this.feesremaining = feesremaining;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        String oldStdname = this.stdname;
        this.stdname = stdname;
        changeSupport.firePropertyChange("stdname", oldStdname, stdname);
    }

    public String getStddob() {
        return stddob;
    }

    public void setStddob(String stddob) {
        String oldStddob = this.stddob;
        this.stddob = stddob;
        changeSupport.firePropertyChange("stddob", oldStddob, stddob);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public BigInteger getStdcontact() {
        return stdcontact;
    }

    public void setStdcontact(BigInteger stdcontact) {
        BigInteger oldStdcontact = this.stdcontact;
        this.stdcontact = stdcontact;
        changeSupport.firePropertyChange("stdcontact", oldStdcontact, stdcontact);
    }

    public BigInteger getPcontact() {
        return pcontact;
    }

    public void setPcontact(BigInteger pcontact) {
        BigInteger oldPcontact = this.pcontact;
        this.pcontact = pcontact;
        changeSupport.firePropertyChange("pcontact", oldPcontact, pcontact);
    }

    public String getAdmdate() {
        return admdate;
    }

    public void setAdmdate(String admdate) {
        String oldAdmdate = this.admdate;
        this.admdate = admdate;
        changeSupport.firePropertyChange("admdate", oldAdmdate, admdate);
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        String oldClass1 = this.class1;
        this.class1 = class1;
        changeSupport.firePropertyChange("class1", oldClass1, class1);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        String oldSubject = this.subject;
        this.subject = subject;
        changeSupport.firePropertyChange("subject", oldSubject, subject);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        String oldRemark = this.remark;
        this.remark = remark;
        changeSupport.firePropertyChange("remark", oldRemark, remark);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        Integer oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public int getFeespaid() {
        return feespaid;
    }

    public void setFeespaid(int feespaid) {
        int oldFeespaid = this.feespaid;
        this.feespaid = feespaid;
        changeSupport.firePropertyChange("feespaid", oldFeespaid, feespaid);
    }

    public int getFeesremaining() {
        return feesremaining;
    }

    public void setFeesremaining(int feesremaining) {
        int oldFeesremaining = this.feesremaining;
        this.feesremaining = feesremaining;
        changeSupport.firePropertyChange("feesremaining", oldFeesremaining, feesremaining);
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
        if (!(object instanceof Addstudent_1)) {
            return false;
        }
        Addstudent_1 other = (Addstudent_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coachingclassmanagementsystem.Addstudent_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
