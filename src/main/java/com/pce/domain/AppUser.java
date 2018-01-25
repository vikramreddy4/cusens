package com.pce.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="app_user",
	indexes = {
			@Index(name = "idx_app_user_email", columnList = "email"),
			@Index(name = "idx_app_user_disabled", columnList = "disabled")
	}
)
public class AppUser implements Serializable {

	@Id
	@Column(nullable = false, length=15)
    private String email;
    
    @Column(nullable = false, length=50)
    private String name;
    
    @Column(updatable = false, nullable = false, length=50)
    private String privilege;
    
    @Column(nullable = false, length=15)
    private String password;

    @Column(nullable = false)
    private boolean disabled;
    
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    private Partner partner;
    
    @JsonIgnore
    @Column(updatable = false, nullable = false)
    private Calendar createdDate;

    @JsonIgnore
    @Column
    private Calendar updatedDate;

    public AppUser() {
    	
    }

	public AppUser(Long id, String name, String privilege, String email, String password, boolean disabled,
			Calendar createdDate, Calendar updatedDate) {
		super();
		this.name = name;
		this.privilege = privilege;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
    	this.createdDate = Calendar.getInstance();
    	this.updatedDate = Calendar.getInstance();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
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

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
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
		return "AppUser [" + (name != null ? "name=" + name + ", " : "")
				+ (privilege != null ? "privilege=" + privilege + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "disabled=" + disabled + ", "
				+ (partner != null ? "partner=" + partner + ", " : "")
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "")
				+ (updatedDate != null ? "updatedDate=" + updatedDate : "") + "]";
	}
    
}