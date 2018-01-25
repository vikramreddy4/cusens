package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="partner_attribute_config",
	uniqueConstraints = {@UniqueConstraint(columnNames={"partner_code", "attributeName"})},
	indexes = {
			@Index(name = "idx_ptr_attr_cfg_attrName", columnList = "attributeName")
	}
)
public class PartnerAttributeConfig implements Serializable {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    private Partner partner;
    
    @Column(updatable = false, nullable = false, length=50, unique=true)
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
		this.id = id;
		this.partner = partner;
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.segment = segment;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "PartnerAttributeConfig [" + (id != null ? "id=" + id + ", " : "")
				+ (partner != null ? "partner=" + partner + ", " : "")
				+ (attributeName != null ? "attributeName=" + attributeName + ", " : "")
				+ (attributeType != null ? "attributeType=" + attributeType + ", " : "") + "segment=" + segment + ", "
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (updatedDate != null ? "updatedDate=" + updatedDate : "") + "]";
	}
    
}