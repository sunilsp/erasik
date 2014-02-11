package com.rasik.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rasik.model.Authors;
import com.rasik.model.AuthorsDao;
import com.rasik.model.Bindingtype;
import com.rasik.model.BindingtypeDao;
import com.rasik.model.Customer;
import com.rasik.model.CustomerDao;
import com.rasik.model.Customertype;
import com.rasik.model.CustomertypeDao;
import com.rasik.model.Discounts;
import com.rasik.model.DiscountsDao;
import com.rasik.model.Itemlanguage;
import com.rasik.model.ItemlanguageDao;
import com.rasik.model.Itemsedition;
import com.rasik.model.ItemseditionDao;
import com.rasik.model.Itemtype;
import com.rasik.model.ItemtypeDao;
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


}
