package com.rasik.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rasik.model.Authors;
import com.rasik.model.AuthorsDao;
import com.rasik.model.Awarddetail;
import com.rasik.model.AwarddetailDao;
import com.rasik.model.Bindingtype;
import com.rasik.model.BindingtypeDao;
import com.rasik.model.Category;
import com.rasik.model.CategoryDao;
import com.rasik.model.Customer;
import com.rasik.model.CustomerDao;
import com.rasik.model.Customertype;
import com.rasik.model.CustomertypeDao;
import com.rasik.model.Discounts;
import com.rasik.model.DiscountsDao;
import com.rasik.model.Edition;
import com.rasik.model.EditionDao;
import com.rasik.model.Itemlanguage;
import com.rasik.model.ItemlanguageDao;
import com.rasik.model.Items;
import com.rasik.model.ItemsDao;
import com.rasik.model.Itemsedition;
import com.rasik.model.ItemseditionDao;
import com.rasik.model.Itemsstockcenter;
import com.rasik.model.Itemtype;
import com.rasik.model.ItemtypeDao;
import com.rasik.model.Publsuppl;
import com.rasik.model.PublsupplDao;
import com.rasik.model.Stockcenter;
import com.rasik.model.StockcenterDao;
import com.rasik.model.Translation;
import com.rasik.model.TranslationDao;
import com.rasik.model.UserInfo;
import com.rasik.model.UserInfoDao;

@Service
@Transactional
public class RasikServiceImpl implements RasikService {

	@Inject
	UserInfoDao userInfoDao;
	@Inject
	ItemtypeDao itemTypeDao;
	@Inject
	CustomerDao customerDao;
	@Inject
	CustomertypeDao customerTypeDao;
	@Inject
	AuthorsDao authorDao;
	@Inject
	BindingtypeDao bindingTypeDao;
	@Inject
	DiscountsDao discountsDao;
	@Inject
	ItemseditionDao itemsEditionDao;
	@Inject
	ItemlanguageDao itemLanguageDao;
	@Inject
	TranslationDao translationDao;
	@Inject
	StockcenterDao stockCenterDao;
	@Inject	
	CategoryDao categoryDao;
	@Inject
	PublsupplDao publsupplDao;
	@Inject
	ItemsDao itemsDao;
	@Inject
	AwarddetailDao awardDetailDao;
	@Inject
	EditionDao editionDao;
	
	
	@Override
	public UserInfo getUserInfo(Long l) {
		return userInfoDao.findById(l);
		
	}

	@Override
	public String getMessage() {
		return "Spring + JSF integration";
	}

	@Override
	public String saveItemTypes(Itemtype itemType) {
		itemTypeDao.persist(itemType);
		return "saved";
	
	}

	@Override
	public Itemtype findItemType(Itemtype itemType) {
		 return itemTypeDao.findItemTypeByDesc(itemType.getDescription());
	}

	@Override
	public List<Itemtype> findAllItemTypes() {
		return itemTypeDao.findAllItemTypes();
		
	}

	@Override
	public Itemtype findItemByType(String itemTypeId) {
		 return itemTypeDao.findById(Integer.valueOf(itemTypeId));
	}

	@Override
	public String updateItemTypes(Itemtype itemType) {
		itemTypeDao.merge(itemType);
		return "saved";
	}

	@Override
	public Itemtype findItemTypeById(Integer itemTypeId) {
		return itemTypeDao.findById(itemTypeId);
		
	}

	@Override
	public void deleteItemTypes(Itemtype itemTypeExist) {
		itemTypeDao.delete(itemTypeExist);
	}

// Customer CRUD below
	
	@Override
	public String saveCustomer(Customer customer) {
		customerDao.persist(customer);
		return "saved";
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public Customer findCustomerById(String customerId) {
		return customerDao.findById(Integer.valueOf(customerId));
	}

	@Override
	public String updateCustomer(Customer customer) {
		customerDao.merge(customer);
		return "saved";

	}

	@Override
	public void deleteCustomer(Customer customerExists) {
		customerDao.delete(customerExists);
		
	}

	
// CutomerType CRUD below	
	
	@Override
	public Customertype findCustomerType(Customertype customerType) {
		List<Customertype> cust=customerTypeDao.findByCutomerType(customerType);
			if(cust.size()>0){
				return cust.get(0);
		    }
			else{
				return null;
			}
				
	}
	
	@Override
	public List<Customertype> findAllCustomerTypes() {
		
		return customerTypeDao.findAllCutomerTypes();
	}


	@Override
	public String saveCustomerTypes(Customertype customerType) {
		customerTypeDao.persist(customerType);
		return "saved";
	}


	// Author CRUD below

	@Override
	public String saveAuthor(Authors author) {
		authorDao.persist(author);
		return "saved";
	}

	@Override
	public Customertype findCustomerTypeById(String customerTypeId) {
		return customerTypeDao.findById(Integer.valueOf(customerTypeId));
	}


	@Override
	public String updateCustomerTypes(Customertype customerTypeExist) {
		customerTypeDao.merge(customerTypeExist);
		return "saved";
	}

	@Override
	public void deleteCustomerTypes(Customertype customerTypeExist) {
		customerTypeDao.delete(customerTypeExist);		
	}

	@Override
	public List<Authors> findAllAuthors() {
		return authorDao.findAllAuthors();
		
	}

	@Override
	public Authors findAuthorById(String authorId) {
		return authorDao.findById(Integer.valueOf(authorId));

	}

	@Override
	public String updateAuthor(Authors authorExist) {
		authorDao.merge(authorExist);
		return "saved";
	}

	@Override
	public List<Bindingtype> findAllBindingTypes() {
		return bindingTypeDao.findAllBindingTypes();
		
	}

	@Override
	public List<Discounts> findAllDiscounts() {
		return discountsDao.findAllDiscounts();
	}

	@Override
	public List<Itemlanguage> findAllLanguages() {
		return itemLanguageDao.findAllLanguages();	
	}

	@Override
	public List<Itemsedition> findAllitemseditions() {
		return itemsEditionDao.findAllitemseditions();
	}

	@Override
	public Bindingtype findBindingTypeByName(Bindingtype bindingType) {
		return bindingTypeDao.findBindingTypeByName(bindingType.getBindingTypeName());
		
	}

	@Override
	public String saveBindingType(Bindingtype bindingType) {
		bindingTypeDao.persist(bindingType);
		return "saved";
	}

	@Override
	public void deleteAuthor(Authors authorExist) {
		authorDao.delete(authorExist);
	}

	@Override
	public Bindingtype findBindingTypeById(Integer bindingTypeId) {
		return bindingTypeDao.findById(bindingTypeId);
	}

	@Override
	public String updateBindingTypes(Bindingtype bindingTypeExist) {
		bindingTypeDao.merge(bindingTypeExist);
		return "saved";
		
	}

	@Override
	public void deleteBindingTypes(Bindingtype bindingTypeExist) {
		bindingTypeDao.delete(bindingTypeExist);
		
	}

	@Override
	public Itemlanguage findItemlanguageByName(Itemlanguage itemlanguage) {
		return itemLanguageDao.findItemlanguageByName(itemlanguage.getLanguageName());
		
	}

	@Override
	public String saveItemlanguage(Itemlanguage itemlanguage) {
		itemLanguageDao.persist(itemlanguage);
		return "saved";
	}

	@Override
	public String saveItemsedition(Itemsedition itemsedition) {
		itemsEditionDao.persist(itemsedition);
		return "saved";
	}

	@Override
	public Itemsedition findItemseditionByDesc(Itemsedition itemsedition) {
		return itemsEditionDao.findItemseditionByDesc(itemsedition.getItemsedition());
		
	}

	@Override
	public Translation findTranslationByName(Translation translation) {
		return translationDao.findTranslationByName(translation.getOriginalname());
	}

	@Override
	public String saveTranslation(Translation translation) {
		translationDao.persist(translation);
		return "saved";
	}

	@Override
	public List<Translation> findAllTranslations() {
		return translationDao.findAllTranslations();
	}

	@Override
	public Stockcenter findStockCenterByName(Stockcenter stockCenter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveStockCenter(Stockcenter stockCenter) {
		stockCenterDao.persist(stockCenter);
		return "saved";
	}

	@Override
	public List<Stockcenter> findAllStockCenters() {
		return stockCenterDao.findAllStockCenters();
		
	}

	@Override
	public Category findCategoryByName(Category category) {
		categoryDao.findCategoryByName(category.getCategoryHeadEnglish());
		return null;
	}

	@Override
	public String saveCategory(Category category) {
	categoryDao.persist(category);
		return null;
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDao.findAllCategories();
		
	}

	@Override
	public Authors findAuthorByName(Authors author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publsuppl> findAllPublsuppl() {
		return publsupplDao.findAllPublsuppl();
	}
	
	@Override
	public Publsuppl findPublsupplByName(Publsuppl publsuppl) {
		return publsupplDao.findPublsupplByName(publsuppl.getEnglishName());
	}
	
	@Override
	public String savePublsuppl(Publsuppl publsuppl) {
		publsupplDao.persist(publsuppl);
		return "saved";
	}

	@Override
	public void prepareItemObject(Items item, String bindingtype,
			String itemtype, String itemlanguage, String itemsedition,
			String stockcenters, String authors,
			String publsuppls, String translations,
			String category, String awarddetails) {
		
		HashSet<Stockcenter>stockCenterSet= new HashSet<Stockcenter>(0);
		stockCenterSet.add(stockCenterDao.findById(Integer.valueOf(stockcenters)));
		item.setStockcenters(stockCenterSet);
		
		HashSet<Publsuppl> publsupplSet= new HashSet<Publsuppl>(0);
		publsupplSet.add(publsupplDao.findById(Integer.valueOf(publsuppls)));
		item.setPublsuppls(publsupplSet);
		
		HashSet<Authors> authorsSet= new HashSet<Authors>(0);
		authorsSet.add(authorDao.findById(Integer.valueOf(authors)));
		item.setAuthors(authorsSet);
		
		HashSet<Category> categorySet= new HashSet<Category>(0);
		categorySet.add(categoryDao.findById(Integer.valueOf(category)));
		item.setCategories(categorySet);
		
		if(!awarddetails.isEmpty()){
			HashSet<Awarddetail> awardDetailSet= new HashSet<Awarddetail>(0);
			awardDetailSet.add(awardDetailDao.findById(Integer.valueOf(awarddetails)));
			item.setAwarddetails(awardDetailSet);
		}
		
		if(!itemlanguage.isEmpty()){
			
			item.setItemlanguage(itemLanguageDao.findById(Integer.valueOf(itemlanguage)));
		}
		
		if(!translations.isEmpty()){
			HashSet<Translation> translationSet= new HashSet<Translation>(0);
			translationSet.add(translationDao.findById(Integer.valueOf(translations)));
			item.setTranslations(translationSet);
		}



	}

	@Override
	public String saveItem(Items item) {
		return itemsDao.merge(item).getItemId().toString();
		
	}

	@Override
	public List<Items> findAllItems() {
	  return itemsDao.findAllItems();
	}

	@Override
	public List<Awarddetail> findAllAwarddetails() {
		return awardDetailDao.findAllAwarddetails();
	}

	@Override
	public Awarddetail findAwardDetailsByName(Awarddetail awardDetail) {
		return awardDetailDao.findAwarddetailByName(awardDetail.getAwardDetailsEnglish());
	}

	@Override
	public String saveAwardDetails(Awarddetail awardDetail) {
		awardDetailDao.persist(awardDetail);
		return "saved";
	}

	@Override
	public void renameUploadedFiles(String tempFileId, String rowId) throws IOException {
		Path filePathAudio=FileSystems.getDefault().getPath("C:\\Users\\sunilsp\\apache-tomcat-7.0.30\\webapps\\erasik\\assets\\images\\",tempFileId+".mp3");
		if(Files.exists(filePathAudio)){
			Files.move(filePathAudio, filePathAudio.resolveSibling(rowId+".mp3"));
		}
	
		
		Path filePathImage=FileSystems.getDefault().getPath("C:\\Users\\sunilsp\\apache-tomcat-7.0.30\\webapps\\erasik\\assets\\images\\",tempFileId+".jpg");
		if(Files.exists(filePathImage)){
			Files.move(filePathImage, filePathImage.resolveSibling(rowId+".jpg"));
		}
		
		Path filePathEbook=FileSystems.getDefault().getPath("C:\\Users\\sunilsp\\apache-tomcat-7.0.30\\webapps\\erasik\\assets\\images\\",tempFileId+".epub");
		if(Files.exists(filePathEbook)){
			Files.move(filePathEbook, filePathEbook.resolveSibling(rowId+".epub"));
		}
	}

	@Override
	public List<Edition> findAllEditions() {
		return editionDao.findAllEditions();
	}


}
