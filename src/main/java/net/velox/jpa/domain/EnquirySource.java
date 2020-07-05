/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.velox.jpa.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Çişem
 */
@Entity
@Table(name = "enquirysource")
@NamedQueries({
    @NamedQuery(name = "Enquirysource.findAll", query = "SELECT e FROM Enquirysource e")})
public class EnquirySource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquirySourceId")
    private Long enquirySourceId;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "enquirysource")
    private List<Enquiry> enquiryList;

    public EnquirySource() {
    }

    public EnquirySource(Long enquirySourceId) {
        this.enquirySourceId = enquirySourceId;
    }

    public Long getEnquirySourceId() {
        return enquirySourceId;
    }

    public void setEnquirySourceId(Long enquirySourceId) {
        this.enquirySourceId = enquirySourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enquiry> getEnquiryList() {
        return enquiryList;
    }

    public void setEnquiryList(List<Enquiry> enquiryList) {
        this.enquiryList = enquiryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquirySourceId != null ? enquirySourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnquirySource)) {
            return false;
        }
        EnquirySource other = (EnquirySource) object;
        if ((this.enquirySourceId == null && other.enquirySourceId != null) || (this.enquirySourceId != null && !this.enquirySourceId.equals(other.enquirySourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.velox.jpa.domain.Enquirysource[ enquirySourceId=" + enquirySourceId + " ]";
    }
    
}
