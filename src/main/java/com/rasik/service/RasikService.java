package com.rasik.service;

import java.util.List;

import com.rasik.model.Authors;
import com.rasik.model.Bindingtype;
import com.rasik.model.Customer;
import com.rasik.model.Customertype;
import com.rasik.model.Discounts;
import com.rasik.model.Itemlanguage;
import com.rasik.model.Itemsedition;
import com.rasik.model.Itemtype;
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

	

	

}