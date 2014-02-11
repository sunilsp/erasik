package com.rasik.model;

// Generated Jan 20, 2014 10:30:33 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.NamedQuery;

/**
 * Customertype generated by hbm2java
 */
@Entity
@Table(name = "customertype", catalog = "rasiknew")
@NamedQuery(name="findAllCustomertypes",query="from Customertype ")
public class Customertype implements java.io.Serializable {

	private int customertypeId;
	private String customerType;
	private String customertypeDesc;
	@JsonBackReference
	private Set<Customer> customers = new HashSet<Customer>(0);

	public Customertype() {
	}

	public Customertype(int customertypeId) {
		this.customertypeId = customertypeId;
	}

	public Customertype(int customertypeId, String customerType,
			String customertypeDesc, Set<Customer> customers) {
		this.customertypeId = customertypeId;
		this.customerType = customerType;
		this.customertypeDesc = customertypeDesc;
		this.customers = customers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customertypeId", unique = true, nullable = false)
	public int getCustomertypeId() {
		return this.customertypeId;
	}

	public void setCustomertypeId(int customertypeId) {
		this.customertypeId = customertypeId;
	}

	@Column(name = "customerType", length = 45)
	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	@Column(name = "customertypeDesc", length = 245)
	public String getCustomertypeDesc() {
		return this.customertypeDesc;
	}

	public void setCustomertypeDesc(String customertypeDesc) {
		this.customertypeDesc = customertypeDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customertype")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}