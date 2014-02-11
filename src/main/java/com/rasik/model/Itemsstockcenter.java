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
 * Itemsstockcenter generated by hbm2java
 */
@Entity
@Table(name = "itemsstockcenter", catalog = "rasiknew")
public class Itemsstockcenter implements java.io.Serializable {

	private Integer itemsStockCenterId;
	private Stockcenter stockcenter;
	private Items items;
	private String rackLocation;
	private Integer quantity;

	public Itemsstockcenter() {
	}

	public Itemsstockcenter(Stockcenter stockcenter, Items items) {
		this.stockcenter = stockcenter;
		this.items = items;
	}

	public Itemsstockcenter(Stockcenter stockcenter, Items items,
			String rackLocation, Integer quantity) {
		this.stockcenter = stockcenter;
		this.items = items;
		this.rackLocation = rackLocation;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "itemsStockCenterId", unique = true, nullable = false)
	public Integer getItemsStockCenterId() {
		return this.itemsStockCenterId;
	}

	public void setItemsStockCenterId(Integer itemsStockCenterId) {
		this.itemsStockCenterId = itemsStockCenterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StockCenterId", nullable = false)
	public Stockcenter getStockcenter() {
		return this.stockcenter;
	}

	public void setStockcenter(Stockcenter stockcenter) {
		this.stockcenter = stockcenter;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemId", nullable = false)
	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Column(name = "RackLocation", length = 45)
	public String getRackLocation() {
		return this.rackLocation;
	}

	public void setRackLocation(String rackLocation) {
		this.rackLocation = rackLocation;
	}

	@Column(name = "Quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
