/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.velox.jpa.domain;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author Çişem
 */
@Entity
@Table(name = "enquirycourse")
@NamedQueries({
    @NamedQuery(name = "Enquirycourse.findAll", query = "SELECT e FROM Enquirycourse e")})
public class Enquirycourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquiryCourseId")
    private Long enquiryCourseId;
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
    @ManyToOne
    private Enquiry enquiry;

    public Enquirycourse() {
    }

    public Enquirycourse(Long enquiryCourseId) {
        this.enquiryCourseId = enquiryCourseId;
    }

    public Long getEnquiryCourseId() {
        return enquiryCourseId;
    }

    public void setEnquiryCourseId(Long enquiryCourseId) {
        this.enquiryCourseId = enquiryCourseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquiryCourseId != null ? enquiryCourseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquirycourse)) {
            return false;
        }
        Enquirycourse other = (Enquirycourse) object;
        if ((this.enquiryCourseId == null && other.enquiryCourseId != null) || (this.enquiryCourseId != null && !this.enquiryCourseId.equals(other.enquiryCourseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.velox.jpa.domain.Enquirycourse[ enquiryCourseId=" + enquiryCourseId + " ]";
    }
    
}
