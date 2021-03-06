package com.rasik.model;

// Generated Jan 20, 2014 10:30:33 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Transporttypes generated by hbm2java
 */
@Entity
@Table(name = "transporttypes", catalog = "rasiknew")
public class Transporttypes implements java.io.Serializable {

	private Integer transportTypeId;
	private String transportType;
	private Set<Transporter> transporters = new HashSet<Transporter>(0);

	public Transporttypes() {
	}

	public Transporttypes(String transportType, Set<Transporter> transporters) {
		this.transportType = transportType;
		this.transporters = transporters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TransportTypeId", unique = true, nullable = false)
	public Integer getTransportTypeId() {
		return this.transportTypeId;
	}

	public void setTransportTypeId(Integer transportTypeId) {
		this.transportTypeId = transportTypeId;
	}

	@Column(name = "TransportType", length = 50)
	public String getTransportType() {
		return this.transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transporttypes")
	public Set<Transporter> getTransporters() {
		return this.transporters;
	}

	public void setTransporters(Set<Transporter> transporters) {
		this.transporters = transporters;
	}

}
