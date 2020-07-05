/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.velox.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Çişem
 */
@Entity
@Table(name = "institute")
@NamedQueries({
    @NamedQuery(name = "Institute.findAll", query = "SELECT i FROM Institute i")})
public class Institute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instituteId")
    private Long instituteId;
    @Column(name = "name")
    private String name;
    @Column(name = "doe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doe;
    @OneToMany(mappedBy = "institute")
    private List<Course> courseList;
    @OneToMany(mappedBy = "institute")
    private List<Enquiry> enquiryList;
    @JoinColumn(name = "contactId", referencedColumnName = "contactId")
    @ManyToOne
    private Contact contact;

    public Institute() {
    }

    public Institute(Long instituteId) {
        this.instituteId = instituteId;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Enquiry> getEnquiryList() {
        return enquiryList;
    }

    public void setEnquiryList(List<Enquiry> enquiryList) {
        this.enquiryList = enquiryList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instituteId != null ? instituteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institute)) {
            return false;
        }
        Institute other = (Institute) object;
        if ((this.instituteId == null && other.instituteId != null) || (this.instituteId != null && !this.instituteId.equals(other.instituteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.velox.jpa.domain.Institute[ instituteId=" + instituteId + " ]";
    }
    
}
