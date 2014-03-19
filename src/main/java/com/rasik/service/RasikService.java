package com.rasik.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.rasik.model.Authors;
import com.rasik.model.Awarddetail;
import com.rasik.model.Bindingtype;
import com.rasik.model.Category;
import com.rasik.model.Customer;
import com.rasik.model.Customertype;
import com.rasik.model.Discounts;
import com.rasik.model.Edition;
import com.rasik.model.Itemlanguage;
import com.rasik.model.Items;
import com.rasik.model.Itemsedition;
import com.rasik.model.Itemtype;
import com.rasik.model.Publsuppl;
import com.rasik.model.Reprint;
import com.rasik.model.Stockcenter;
import com.rasik.model.Translation;
import com.rasik.model.UserInfo;


public interface RasikService {

	public UserInfo getUserInfo(Long id);

	public String getMessage();
	
	public String saveItemTypes(Itemtype itemType);

	public Itemtype findItemType(Itemtype itemType);

	public List<Itemtype> findAllItemTypes();

	public Itemtype findItemByType(String itemTypeId);

	public String updateItemTypes(Itemtype itemType);

	public Itemtype findItemTypeById(Integer itemTypeId);

	public void deleteItemTypes(Itemtype itemTypeExist);
	
	
	
	public String saveCustomer(Customer customer);

	public List<Customer> findAllCustomers();

	public Customer findCustomerById(String customerId);

	public String updateCustomer(Customer customer);

	public void deleteCustomer(Customer customerExists);


	
	public Customertype findCustomerType(Customertype customerType);

	public List<Customertype> findAllCustomerTypes();

	public String saveCustomerTypes(Customertype customerType);

	public Customertype findCustomerTypeById(String customerTypeId);

	public String updateCustomerTypes(Customertype customerTypeExist);

	public void deleteCustomerTypes(Customertype customerTypeExist);

	
	
	public String saveAuthor(Authors author);
	
	public List<Authors> findAllAuthors();

	public Authors findAuthorById(String authorId);

	public String updateAuthor(Authors authorExist);

	
	
	public List<Bindingtype> findAllBindingTypes();
	
	public List<Discounts> findAllDiscounts();
	
	public List<Itemlanguage> findAllLanguages();
	
	public List<Itemsedition> findAllitemseditions();

	public Bindingtype findBindingTypeByName(Bindingtype bindingType);

	public String saveBindingType(Bindingtype bindingType);

	public void deleteAuthor(Authors authorExist);

	public Bindingtype findBindingTypeById(Integer bindingTypeId);

	public String updateBindingTypes(Bindingtype bindingTypeExist);

	public void deleteBindingTypes(Bindingtype bindingTypeExist);

	public Itemlanguage findItemlanguageByName(Itemlanguage itemlanguage);

	public String saveItemsedition(Edition itemsedition);

	public Itemsedition findItemseditionByDesc(Edition itemsedition);

	public String saveItemlanguage(Itemlanguage itemlanguage);

	public Translation findTranslationByName(Translation translation);

	public String saveTranslation(Translation translation);

	public List<Translation> findAllTranslations();

	public Stockcenter findStockCenterByName(Stockcenter stockCenter);

	public String saveStockCenter(Stockcenter stockCenter);

	public List<Stockcenter> findAllStockCenters();

	public Category findCategoryByName(Category category);
	
	public List<Category> findAllCategories();

	public String saveCategory(Category category);

	public Authors findAuthorByName(Authors author);

	public List<Publsuppl> findAllPublsuppl();

	public Publsuppl findPublsupplByName(Publsuppl publsuppl);

	public String savePublsuppl(Publsuppl publsuppl);

	public void prepareItemObject(Items item,  String bindingtype,String itemtype,
			String itemlanguage, String itemsedition, String itemsstockcenters,
			String itemsauthorses, String itemspublsuppls, String translations,
			String itemscategories, String awarddetails);

	public String saveItem(Items item);

	public List<Items> findAllItems();

	public List<Awarddetail> findAllAwarddetails();

	public Awarddetail findAwardDetailsByName(Awarddetail awardDetail);

	public String saveAwardDetails(Awarddetail awardDetail);

	public void renameUploadedFiles(String parameter, String rowId) throws IOException;

	public List<Edition> findAllEditions();

	public List<Customer> findCustomerByUserName(String username);

	public List<Reprint> findAllReprints();
	

	

}
