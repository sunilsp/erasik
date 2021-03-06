package com.rasik.model;

// Generated Jan 20, 2014 10:30:33 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.NamedQuery;

/**
 * Stockcenter generated by hbm2java
 */
@Entity
@Table(name = "stockcenter", catalog = "rasiknew")
@NamedQuery(name="findAllStockcenters",query="from Stockcenter ")
public class Stockcenter implements java.io.Serializable {

	private Integer stockCenterId;
	private String stockCenterHead;
	private String address1;
	private String address2;
	private String address3;
	private String phone1;
	private String phone2;
	private String contactPerson;
	private Integer centerCount;
	private String canCreateInvoice;
	@JsonBackReference
	private Set<Items> items = new HashSet<Items>(
			0);

	public Stockcenter() {
	}

	public Stockcenter(String stockCenterHead, String address1,
			String address2, String address3, String phone1, String phone2,
			String contactPerson, Integer centerCount, String canCreateInvoice,
			Set<Items> items) {
		this.stockCenterHead = stockCenterHead;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.contactPerson = contactPerson;
		this.centerCount = centerCount;
		this.canCreateInvoice = canCreateInvoice;
		this.items = items;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "StockCenterId", unique = true, nullable = false)
	public Integer getStockCenterId() {
		return this.stockCenterId;
	}

	public void setStockCenterId(Integer stockCenterId) {
		this.stockCenterId = stockCenterId;
	}

	@Column(name = "StockCenterHead", length = 30)
	public String getStockCenterHead() {
		return this.stockCenterHead;
	}

	public void setStockCenterHead(String stockCenterHead) {
		this.stockCenterHead = stockCenterHead;
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

	@Column(name = "CenterCount")
	public Integer getCenterCount() {
		return this.centerCount;
	}

	public void setCenterCount(Integer centerCount) {
		this.centerCount = centerCount;
	}

	@Column(name = "CanCreateInvoice", length = 1)
	public String getCanCreateInvoice() {
		return this.canCreateInvoice;
	}

	public void setCanCreateInvoice(String canCreateInvoice) {
		this.canCreateInvoice = canCreateInvoice;
	}

	@ManyToMany(fetch=FetchType.EAGER,mappedBy = "stockcenters")
	public Set<Items> getItems() {
		return this.items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

}
