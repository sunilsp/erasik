package com.rasik.model;

// Generated Jan 20, 2014 10:30:33 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Items generated by hbm2java
 */
@Entity
@Table(name = "items", catalog = "rasiknew")
public class Items implements java.io.Serializable {

	private Integer itemId;
	private Bindingtype bindingtype;
	private Itemtype itemtype;
	private Discounts discounts;
	private Itemlanguage itemlanguage;
	private Itemsedition itemsedition;
	private String userBookCode;
	private String englishName;
	private String marathiName;
	private Integer publisherCode;
	private Double price;
	private Integer qtyInHand;
	private Integer minLevel;
	private Integer maxLevel;
	private Double maxSaleDiscountPrice;
	private Byte publMonth;
	private Integer publYear;
	private String isbnno;
	private Integer noOfPages;
	private String description;
	private String itemCoverImage;
	private String ebookFile;
	private String audioBookFile;
	private String printStatus;
	private Date maxSalePriceEndDate;
	private Double maxSaleDiscountPrecent;
	private Date maxOwDiscountEndDate;
	private Double purchaseDiscountPercent;
	private Date maxInwDiscountEndDate;
	private Double discountedPrice;
	private Date discountedPriceEndDate;
	private Double purchasePrice;
	private Integer stock;
	private String location;
	private Set<Stockcenter> stockcenters = new HashSet<Stockcenter>(
			0);
	private Set<Authors> authors = new HashSet<Authors>(0);
	private Set<Publsuppl> publsuppls = new HashSet<Publsuppl>(0);
	private Set<Customer> customers = new HashSet<Customer>(
			0);
	private Set<Translation> translations = new HashSet<Translation>(0);
	private Set<Category> categories = new HashSet<Category>(0);
	private Set<Awarddetail> awarddetails = new HashSet<Awarddetail>(0);
	private Set<Edition> editions = new HashSet<Edition>(
			0);
	private Set<Reprint> reprints = new HashSet<Reprint>(
			0);
	
	public Items() {
	}

	public Items(Bindingtype bindingtype, Itemtype itemtype,
			Discounts discounts, Itemlanguage itemlanguage,
			Itemsedition itemsedition, String userBookCode, String englishName,
			String marathiName, Integer publisherCode, Double price,
			Integer qtyInHand, Integer minLevel, Integer maxLevel,
			Double maxSalePrice, Byte publMonth, Integer publYear,
			String isbnno, Integer noOfPages, String description,
			String itemCoverImage, String ebookFile, String audioBookFile,
			String printStatus, Date maxSalePriceEndDate,
			Double maxOwDiscountPrecent, Date maxOwDiscountEndDate,
			Double maxInwDiscountPercent, Date maxInwDiscountEndDate,
			Set<Stockcenter> stockcenters,
			Set<Authors> authors,
			Set<Publsuppl> publsuppls,
			Set<Customer> customers,
			Set<Translation> translations, Set<Category> categories,
			Set<Awarddetail> awarddetails) {
		this.bindingtype = bindingtype;
		this.itemtype = itemtype;
		this.discounts = discounts;
		this.itemlanguage = itemlanguage;
		this.itemsedition = itemsedition;
		this.userBookCode = userBookCode;
		this.englishName = englishName;
		this.marathiName = marathiName;
		this.publisherCode = publisherCode;
		this.price = price;
		this.qtyInHand = qtyInHand;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.maxSaleDiscountPrice = maxSalePrice;
		this.publMonth = publMonth;
		this.publYear = publYear;
		this.isbnno = isbnno;
		this.noOfPages = noOfPages;
		this.description = description;
		this.itemCoverImage = itemCoverImage;
		this.ebookFile = ebookFile;
		this.audioBookFile = audioBookFile;
		this.printStatus = printStatus;
		this.maxSalePriceEndDate = maxSalePriceEndDate;
		this.maxSaleDiscountPrecent = maxOwDiscountPrecent;
		this.maxOwDiscountEndDate = maxOwDiscountEndDate;
		this.purchaseDiscountPercent = maxInwDiscountPercent;
		this.maxInwDiscountEndDate = maxInwDiscountEndDate;
		this.stockcenters = stockcenters;
		this.authors = authors;
		this.publsuppls = publsuppls;
		this.customers = customers;
		this.translations = translations;
		this.categories = categories;
		this.awarddetails = awarddetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ItemId", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BindingTypeId")
	public Bindingtype getBindingtype() {
		return this.bindingtype;
	}

	public void setBindingtype(Bindingtype bindingtype) {
		this.bindingtype = bindingtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ItemTypeId")
	public Itemtype getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(Itemtype itemtype) {
		this.itemtype = itemtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DiscountId")
	public Discounts getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(Discounts discounts) {
		this.discounts = discounts;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LanguageId")
	public Itemlanguage getItemlanguage() {
		return this.itemlanguage;
	}

	public void setItemlanguage(Itemlanguage itemlanguage) {
		this.itemlanguage = itemlanguage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemseditionId")
	public Itemsedition getItemsedition() {
		return this.itemsedition;
	}

	public void setItemsedition(Itemsedition itemsedition) {
		this.itemsedition = itemsedition;
	}

	@Column(name = "UserBookCode", length = 15)
	public String getUserBookCode() {
		return this.userBookCode;
	}

	public void setUserBookCode(String userBookCode) {
		this.userBookCode = userBookCode;
	}

	@Column(name = "EnglishName", length = 120)
	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	@Column(name = "MarathiName", length = 350)
	public String getMarathiName() {
		return this.marathiName;
	}

	public void setMarathiName(String marathiName) {
		this.marathiName = marathiName;
	}

	@Column(name = "PublisherCode")
	public Integer getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(Integer publisherCode) {
		this.publisherCode = publisherCode;
	}

	@Column(name = "Price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "QtyInHand")
	public Integer getQtyInHand() {
		return this.qtyInHand;
	}

	public void setQtyInHand(Integer qtyInHand) {
		this.qtyInHand = qtyInHand;
	}

	@Column(name = "MinLevel")
	public Integer getMinLevel() {
		return this.minLevel;
	}

	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}

	@Column(name = "MaxLevel")
	public Integer getMaxLevel() {
		return this.maxLevel;
	}

	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	@Column(name = "MaxSalePrice", precision = 22, scale = 0)
	public Double getMaxSaleDiscountPrice() {
		return this.maxSaleDiscountPrice;
	}

	public void setMaxSaleDiscountPrice(Double maxSalePrice) {
		this.maxSaleDiscountPrice = maxSalePrice;
	}

	@Column(name = "PublMonth")
	public Byte getPublMonth() {
		return this.publMonth;
	}

	public void setPublMonth(Byte publMonth) {
		this.publMonth = publMonth;
	}

	@Column(name = "PublYear")
	public Integer getPublYear() {
		return this.publYear;
	}

	public void setPublYear(Integer publYear) {
		this.publYear = publYear;
	}

	@Column(name = "ISBNNo", length = 13)
	public String getIsbnno() {
		return this.isbnno;
	}

	public void setIsbnno(String isbnno) {
		this.isbnno = isbnno;
	}

	@Column(name = "NoOfPages")
	public Integer getNoOfPages() {
		return this.noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	@Column(name = "Description", length = 1245)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ItemCoverImage", length = 145)
	public String getItemCoverImage() {
		return this.itemCoverImage;
	}

	public void setItemCoverImage(String itemCoverImage) {
		this.itemCoverImage = itemCoverImage;
	}

	@Column(name = "EbookFile", length = 145)
	public String getEbookFile() {
		return this.ebookFile;
	}

	public void setEbookFile(String ebookFile) {
		this.ebookFile = ebookFile;
	}

	@Column(name = "AudioBookFile", length = 145)
	public String getAudioBookFile() {
		return this.audioBookFile;
	}

	public void setAudioBookFile(String audioBookFile) {
		this.audioBookFile = audioBookFile;
	}

	@Column(name = "printStatus", length = 45)
	public String getPrintStatus() {
		return this.printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MaxSalePriceEndDate", length = 10)
	public Date getMaxSalePriceEndDate() {
		return this.maxSalePriceEndDate;
	}

	public void setMaxSalePriceEndDate(Date maxSalePriceEndDate) {
		this.maxSalePriceEndDate = maxSalePriceEndDate;
	}

	@Column(name = "MaxOwDiscountPrecent", precision = 22, scale = 0)
	public Double getMaxSaleDiscountPrecent() {
		return this.maxSaleDiscountPrecent;
	}

	public void setMaxSaleDiscountPrecent(Double maxOwDiscountPrecent) {
		this.maxSaleDiscountPrecent = maxOwDiscountPrecent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MaxOwDiscountEndDate", length = 10)
	public Date getMaxOwDiscountEndDate() {
		return this.maxOwDiscountEndDate;
	}

	public void setMaxOwDiscountEndDate(Date maxOwDiscountEndDate) {
		this.maxOwDiscountEndDate = maxOwDiscountEndDate;
	}

	@Column(name = "PurchaseDiscountPercent", precision = 22, scale = 0)
	public Double getPurchaseDiscountPercent() {
		return this.purchaseDiscountPercent;
	}

	public void setPurchaseDiscountPercent(Double maxInwDiscountPercent) {
		this.purchaseDiscountPercent = maxInwDiscountPercent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MaxInwDiscountEndDate", length = 10)
	public Date getMaxInwDiscountEndDate() {
		return this.maxInwDiscountEndDate;
	}

	public void setMaxInwDiscountEndDate(Date maxInwDiscountEndDate) {
		this.maxInwDiscountEndDate = maxInwDiscountEndDate;
	}

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="Itemsstockcenter", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="StockCenterId")})
	public Set<Stockcenter> getStockcenters() {
		return this.stockcenters;
	}

	public void setStockcenters(Set<Stockcenter> stockcenters) {
		this.stockcenters = stockcenters;
	}

	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="Itemsauthors", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="AuthorId")})

	public Set<Authors> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="Itemspublsuppl", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="PubSupId")})

	public Set<Publsuppl> getPublsuppls() {
		return this.publsuppls;
	}

	public void setPublsuppls(Set<Publsuppl> publsuppls) {
		this.publsuppls = publsuppls;
	}

	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="Itemscustomerrating", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="CustomerId")})
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(
			Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "items")
	public Set<Translation> getTranslations() {
		return this.translations;
	}

	public void setTranslations(Set<Translation> translations) {
		this.translations = translations;
	}


	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="Itemscategory", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="CategoryId")})

	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="Itemsawarddetail", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="AwarddetailId")})
	public Set<Awarddetail> getAwarddetails() {
		return this.awarddetails;
	}

	public void setAwarddetails(Set<Awarddetail> awarddetails) {
		this.awarddetails = awarddetails;
	}

	/**
	 * @return the discountedPrice
	 */
	
	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	/**
	 * @param discountedPrice the discountedPrice to set
	 */
	@Column(name = "DiscountedPrice", precision = 22, scale = 0)
	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	/**
	 * @return the discountedPriceEndDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DiscountedPriceEndDate", length = 10)

	public Date getDiscountedPriceEndDate() {
		return discountedPriceEndDate;
	}

	/**
	 * @param discountedPriceEndDate the discountedPriceEndDate to set
	 */
	public void setDiscountedPriceEndDate(Date discountedPriceEndDate) {
		this.discountedPriceEndDate = discountedPriceEndDate;
	}

	/**
	 * @return the purchasePrice
	 */
	@Column(name = "PurchasePrice", precision = 22, scale = 0)
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the editions
	 */
	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="itemsedition", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="editionId")})

	public Set<Edition> getEditions() {
		return editions;
	}

	/**
	 * @param editions the editions to set
	 */
	public void setEditions(Set<Edition> editions) {
		this.editions = editions;
	}

	/**
	 * @return the reprints
	 */
	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="itemsreprint", 
                joinColumns={@JoinColumn(name="itemId")}, 
                inverseJoinColumns={@JoinColumn(name="reprintId")})

	public Set<Reprint> getReprints() {
		return reprints;
	}

	/**
	 * @param reprints the reprints to set
	 */
	public void setReprints(Set<Reprint> reprints) {
		this.reprints = reprints;
	}

	/**
	 * @return the stock
	 */
	@Column(name = "stock")
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the location
	 */
	@Column(name = "location", precision = 25, scale = 0)
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
