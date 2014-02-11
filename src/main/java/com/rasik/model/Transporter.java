package com.rasik.model;

// Generated Jan 20, 2014 10:30:33 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Transporter generated by hbm2java
 */
@Entity
@Table(name = "transporter", catalog = "rasiknew")
public class Transporter implements java.io.Serializable {

	private Integer transporterId;
	private Transporttypes transporttypes;
	private String englishName;
	private String marathiName;
	private String address1;
	private String address2;
	private String address3;
	private String phone1;
	private String phone2;
	private String contactPerson;

	public Transporter() {
	}

	public Transporter(Transporttypes transporttypes, String englishName,
			String marathiName, String address1, String address2,
			String address3, String phone1, String phone2, String contactPerson) {
		this.transporttypes = transporttypes;
		this.englishName = englishName;
		this.marathiName = marathiName;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.contactPerson = contactPerson;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TransporterId", unique = true, nullable = false)
	public Integer getTransporterId() {
		return this.transporterId;
	}

	public void setTransporterId(Integer transporterId) {
		this.transporterId = transporterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TransportTypeId")
	public Transporttypes getTransporttypes() {
		return this.transporttypes;
	}

	public void setTransporttypes(Transporttypes transporttypes) {
		this.transporttypes = transporttypes;
	}

	@Column(name = "EnglishName", length = 130)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "MarathiName", length = 130)
	public String getMarathiName() {
		return this.marathiName;
	}

	public void setMarathiName(String marathiName) {
		this.marathiName = marathiName;
	}

	@Column(name = "Address1", length = 130)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "Address2", length = 130)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "Address3", length = 130)
	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "Phone1", length = 15)
	public String getPhone1() {
		return this.phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Column(name = "Phone2", length = 15)
	public String getPhone2() {
		return this.phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Column(name = "ContactPerson", length = 130)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

}
