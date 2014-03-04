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
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "rasiknew")
@NamedQueries(
{@NamedQuery(name="findAllCategories",query="from Category "),
@NamedQuery(name="findCategoryByName",query="from Category it where it.categoryHeadEnglish = :categoryHeadEnglish")
})
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String categoryHeadEnglish;
	private String categoryHeadMarathi;
	@JsonBackReference
	private Set<Items> items = new HashSet<Items>(0);

	public Category() {
	}

	public Category(String categoryHeadEnglish, String categoryHeadMarathi,
			Set<Items> itemscategories) {
		this.categoryHeadEnglish = categoryHeadEnglish;
		this.categoryHeadMarathi = categoryHeadMarathi;
		this.items = itemscategories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CategoryId", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CategoryHeadEnglish", length = 50)
	public String getCategoryHeadEnglish() {
		return this.categoryHeadEnglish;
	}

	public void setCategoryHeadEnglish(String categoryHeadEnglish) {
		this.categoryHeadEnglish = categoryHeadEnglish;
	}

	@Column(name = "CategoryHeadMarathi", length = 150)
	public String getCategoryHeadMarathi() {
		return this.categoryHeadMarathi;
	}

	public void setCategoryHeadMarathi(String categoryHeadMarathi) {
		this.categoryHeadMarathi = categoryHeadMarathi;
	}

	@ManyToMany(mappedBy = "categories")
	public Set<Items> getItems() {
		return this.items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	} 

}
