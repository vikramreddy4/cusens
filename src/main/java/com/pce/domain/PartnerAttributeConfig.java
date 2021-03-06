package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="partner_attribute_config"
//,
//	uniqueConstraints = {@UniqueConstraint(columnNames={"partner_code", "attributeName"})},
//	indexes = {
//			@Index(name = "idx_ptr_attr_cfg_attrName", columnList = "attributeName")
//	}
)
@IdClass(PartnerAttributeConfigPK.class)
public class PartnerAttributeConfig implements Serializable {
	@Id
	private Partner partner;
    
	@Id
    private String attributeName;
	
    @Column(nullable = false, length=15)
    private String attributeType;
    
    @Column(nullable = false)
    private boolean segment;
    
    @JsonIgnore
    @Column(updatable = false, nullable = false)
    private Calendar createdDate;

    @JsonIgnore
    @Column
    private Calendar updatedDate;

    public PartnerAttributeConfig() {
    	
    }

	public PartnerAttributeConfig(Long id, Partner partner, String attributeName, String attributeType,
			boolean segment, Calendar createdDate, Calendar updatedDate) {
		super();
//		this.id = id;
//		this.partner = partner;
//		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.segment = segment;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public boolean isSegment() {
		return segment;
	}

	public void setSegment(boolean segment) {
		this.segment = segment;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

}

@Embeddable
class PartnerAttributeConfigPK implements Serializable {

	@ManyToOne(cascade=CascadeType.ALL)
	private Partner partner;
    
    @Column(nullable = false, length=50, unique=true)
    private String attributeName;

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartnerAttributeConfigPK)) return false;
        PartnerAttributeConfigPK that = (PartnerAttributeConfigPK) o;
        return Objects.equals(getPartner(), that.getPartner()) &&
                Objects.equals(getAttributeName(), that.getAttributeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartner(), getAttributeName());
    }
}