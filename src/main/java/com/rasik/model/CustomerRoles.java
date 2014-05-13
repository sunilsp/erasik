package com.rasik.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Generated May 12, 2014 8:05:35 PM by Hibernate Tools 4.0.0

/**
 * CustomerRoles generated by hbm2java
 */
@Entity
@Table(name = "customer_roles", catalog = "rasiknew")

public class CustomerRoles implements java.io.Serializable {

	private Integer customerRolesid;
	private Customer customer;
	private String authority;

	public CustomerRoles() {
	}

	public CustomerRoles(Customer customer, String authority) {
		this.customer = customer;
		this.authority = authority;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customer_rolesid", unique = true, nullable = false)	
	public Integer getCustomerRolesid() {
		return this.customerRolesid;
	}

	public void setCustomerRolesid(Integer customerRolesid) {
		this.customerRolesid = customerRolesid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Column(name = "Authority", length = 45)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}