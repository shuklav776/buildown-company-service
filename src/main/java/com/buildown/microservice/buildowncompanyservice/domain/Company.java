package com.buildown.microservice.buildowncompanyservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Company")
@Table(name = "Company")
@Configurable
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CompanyID")
	private Integer companyID;
	
	@Column(name = "CompanyCode", length = 10)
	private String companyCode;
	
	@Column(name = "CompanyName", length = 100)
	private String companyName;
	
	@Column(name = "ParentCompanyID", length = 11)
	private Integer parentCompanyID;
	
	@Column(name = "Address", length = 100)
	private String address;
	
	@Column(name = "Address2", length = 100)
	private String address2;
	
	@Column(name = "City", length = 50)
	private String city;
	
	@Column(name = "State", length = 50)
	private String state;
	
	@Column(name = "Zip", length = 20)
	private String zip;
	
	@Column(name = "Country", length = 20)
	private String country;
	
	@Column(name = "About", length = 200)
	private String about;
	
	@Column(name = "CreatedDTTM")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Date createdDTTM;
	
	@Column(name = "UpdatedDTTM")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Date updatedDTTM;
	
	@Column(name = "Active")
	private Boolean active;
	
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getParentCompanyID() {
		return parentCompanyID;
	}
	public void setParentCompanyID(Integer parentCompanyID) {
		this.parentCompanyID = parentCompanyID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Date getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(Date createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public Date getUpdatedDTTM() {
		return updatedDTTM;
	}
	public void setUpdatedDTTM(Date updatedDTTM) {
		this.updatedDTTM = updatedDTTM;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", parentCompanyID=" + parentCompanyID + ", address=" + address + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", country=" + country + ", about=" + about
				+ ", createdDTTM=" + createdDTTM + ", updatedDTTM=" + updatedDTTM + ", active=" + active + "]";
	}
	
}
