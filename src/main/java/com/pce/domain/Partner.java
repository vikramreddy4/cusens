package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="partner",
indexes = {
		@Index(name = "idx_partner_hashCode", columnList = "hashCode")
}
)
public class Partner implements Serializable {

	@Id
    @Column(nullable = false, length=25, unique=true)
    private String code;
    
    @Column(updatable = false, nullable = false, length=50, unique=true)
    private String hashCode;
    
    @Column(nullable = false, length=15)
    private String phone;
    
    @Column(nullable = false, length=100)
    private String email;
    
    @Column(nullable = false)
    private boolean disabled;
    
    @Column(updatable = false, nullable = false)
    private Calendar createdDate;

    @Column
    private Calendar updatedDate;

    public Partner() {
    	
    }
    
    public Partner(String code, String hashCode, String phone, String email) {
    	this.code = code;
    	this.hashCode = hashCode;
    	this.phone = phone;
    	this.email = email;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "Partner [" + (code != null ? "code=" + code + ", " : "")
				+ (hashCode != null ? "hashCode=" + hashCode + ", " : "")
				+ (phone != null ? "phone=" + phone + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ "disabled=" + disabled + ", " + (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (updatedDate != null ? "updatedDate=" + updatedDate : "") + "]";
	}

}