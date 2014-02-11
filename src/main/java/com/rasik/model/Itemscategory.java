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
 * Itemscategory generated by hbm2java
 */
@Entity
@Table(name = "itemscategory", catalog = "rasiknew")
public class Itemscategory implements java.io.Serializable {

	private Integer itemsCategoryId;
	private Category category;
	private Items items;

	public Itemscategory() {
	}

	public Itemscategory(Category category, Items items) {
		this.category = category;
		this.items = items;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "itemsCategoryId", unique = true, nullable = false)
	public Integer getItemsCategoryId() {
		return this.itemsCategoryId;
	}

	public void setItemsCategoryId(Integer itemsCategoryId) {
		this.itemsCategoryId = itemsCategoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryId", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemId", nullable = false)
	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

}
