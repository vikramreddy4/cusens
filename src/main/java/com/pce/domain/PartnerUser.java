package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="partner_user",
	uniqueConstraints = {@UniqueConstraint(columnNames={"email"})}
)
public class PartnerUser implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length=50)
    private String name;
    
    @Column(updatable = false, nullable = false, length=50)
    private String email;
    
    @Column(nullable = false, length=15)
    private String phone;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Partner partner;

    @Column
    private boolean emailOptIn;
    
    @Column
    private boolean phoneOptIn;
    
    @Column
    private boolean notificationsOptIn;
    
    @Column(updatable = false, nullable = false)
    private Calendar createdDate;
    
    @Column
    private Calendar updatedDate;

    public PartnerUser() {
    	
    }
    
    public PartnerUser(String name, String email, String phone, boolean emailOptIn, boolean phoneOptIn,
			boolean notificationsOptIn) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.emailOptIn = emailOptIn;
		this.phoneOptIn = phoneOptIn;
		this.notificationsOptIn = notificationsOptIn;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isEmailOptIn() {
		return emailOptIn;
	}

	public void setEmailOptIn(boolean emailOptIn) {
		this.emailOptIn = emailOptIn;
	}

	public boolean isPhoneOptIn() {
		return phoneOptIn;
	}

	public void setPhoneOptIn(boolean phoneOptIn) {
		this.phoneOptIn = phoneOptIn;
	}

	public boolean isNotificationsOptIn() {
		return notificationsOptIn;
	}

	public void setNotificationsOptIn(boolean notificationsOptIn) {
		this.notificationsOptIn = notificationsOptIn;
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

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "PartnerUser [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (phone != null ? "phone=" + phone + ", " : "")
				+ (partner != null ? "partner=" + partner + ", " : "") + "emailOptIn=" + emailOptIn + ", phoneOptIn="
				+ phoneOptIn + ", notificationsOptIn=" + notificationsOptIn + ", "
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (updatedDate != null ? "updatedDate=" + updatedDate : "") + "]";
	}

}