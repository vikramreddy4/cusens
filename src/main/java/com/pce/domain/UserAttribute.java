package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_attribute",
//	uniqueConstraints = {@UniqueConstraint(columnNames={"partner_code", "attribute_name"})},
	indexes = {
			@Index(name = "idx_ptr_attr_cfg_attrName", columnList = "attributeName")
	}
)
@IdClass(UserAttributePK.class)
public class UserAttribute implements Serializable {
    @JsonIgnore
    @Id
    private Partner partner;
    
    @JsonIgnore
    @Id
    private User user;

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

    public UserAttribute() {
    	
    }

	public UserAttribute(Partner partner, String attributeName, String attributeType,
			boolean segment, Calendar createdDate, Calendar updatedDate) {
		super();
		this.partner = partner;
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.segment = segment;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
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
		return "PartnerAttributeConfig [" + (partner != null ? "partner=" + partner + ", " : "")
				+ (attributeName != null ? "attributeName=" + attributeName + ", " : "")
				+ (attributeType != null ? "attributeType=" + attributeType + ", " : "") + "segment=" + segment + ", "
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (updatedDate != null ? "updatedDate=" + updatedDate : "") + "]";
	}
    
}
@Embeddable
class UserAttributePK implements Serializable {

	@ManyToOne(cascade=CascadeType.ALL)
	private Partner partner;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAttributePK)) return false;
        UserAttributePK that = (UserAttributePK) o;
        return Objects.equals(getPartner(), that.getPartner()) &&
                Objects.equals(getAttributeName(), that.getAttributeName()) &&
                		Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartner(), getAttributeName(), getUser());
    }
}