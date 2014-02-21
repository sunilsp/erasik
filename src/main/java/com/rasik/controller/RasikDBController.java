package com.rasik.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.rasik.beans.ItemtypeList;
import com.rasik.model.Authors;
import com.rasik.model.Bindingtype;
import com.rasik.model.Category;
import com.rasik.model.Customer;
import com.rasik.model.Customertype;
import com.rasik.model.CustomertypeDao;
import com.rasik.model.Discounts;
import com.rasik.model.Itemlanguage;
import com.rasik.model.Items;
import com.rasik.model.Itemsedition;
import com.rasik.model.Itemtype;
import com.rasik.model.Publsuppl;
import com.rasik.model.Stockcenter;
import com.rasik.model.Translation;
import com.rasik.service.RasikService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class RasikDBController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	RasikService rasikSvc;

	@RequestMapping(value = { "index.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		logger.info("Inside index()");
		ModelAndView mav = new ModelAndView("html/index");
		return mav;
	}

	@RequestMapping(value = { "admin/editdatabase.html" }, method = RequestMethod.GET)
	public ModelAndView editdatabase() {
		logger.info("Inside editdatabase()");
		ModelAndView mav = new ModelAndView("html/editdatabase");
		return mav;
	}

	/*
	 * Start : Itemtype functions
	 */
	@RequestMapping(value = { "admin/showItemTypes.html" }, method = RequestMethod.GET)
	public ModelAndView showItemTypes() {
		logger.info("Inside showItemTypes()");
		ModelAndView mav = new ModelAndView("html/adminNew");
		Itemtype itemType = new Itemtype();
		mav.addObject("itemType", itemType);
		return mav;
	}

	@RequestMapping(value = { "admin/submitItemTypes.html" }, method = RequestMethod.POST)
	public String submitItemTypes(
			HttpServletResponse response,
			Model model,
			@ModelAttribute Itemtype itemType,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
			throws IOException {
		logger.info("Inside submitItemTypes()");

		if (rasikSvc.findItemType(itemType) == null) {
			rasikSvc.saveItemTypes(itemType);

			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Itemtype saved");
				response.setStatus(200);
				return null;
			} else {
				model.addAttribute("message", "Itemtype saved.");
				return "html/message";
			}
		} else {
			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Itemtype already exists");
				response.setStatus(200);
				return null;

			} else {
				model.addAttribute("message", "Itemtype already exists");
				return "html/message";
			}

		}
	}

	@RequestMapping(value = { "admin/updateItemTypes.html" }, method = RequestMethod.POST)
	public ModelAndView updateItemTypes(HttpServletRequest request,
			@ModelAttribute Itemtype itemType) {
		logger.info("Inside updateItemTypes()");
		ModelAndView mav = new ModelAndView("html/message");
		String actionType = request.getParameter("actionType");
		Itemtype itemTypeExist = rasikSvc.findItemTypeById(itemType
				.getItemTypeId());
		if (itemTypeExist != null) {
			itemTypeExist.setDescription(itemType.getDescription());
			itemTypeExist.setVatPerc(itemType.getVatPerc());
			if (actionType.equals("update")) {
				rasikSvc.updateItemTypes(itemTypeExist);
				mav.addObject("message", "Itemtype updated.");
			}
			if (actionType.equals("delete")) {
				rasikSvc.deleteItemTypes(itemTypeExist);
				mav.addObject("message", "Itemtype deleted.");
			}
		} else {
			mav.addObject("message", "Itemtype does not exist");
		}
		return mav;
	}

	@RequestMapping(value = { "admin/listItemtypes.html" }, method = RequestMethod.GET)
	public String listItemtypes(Model model) {
		logger.info("Inside listItemtypes()");
		List<Itemtype> itemTypeListresult = rasikSvc.findAllItemTypes();
		ItemtypeList itemTypeList = new ItemtypeList();
		itemTypeList.setItemTypeList(itemTypeListresult);

		// Following code shows how to return object as XML
		/*
		 * JAXBContext jaxbContext =
		 * JAXBContext.newInstance(ItemtypeList.class); Marshaller
		 * jaxbMarshaller = jaxbContext.createMarshaller();
		 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * jaxbMarshaller.marshal(itemTypeList, System.out); return mav;
		 */

		// Gson used here just to have an example. Used jackson everywhere else
		String json = new Gson().toJson(itemTypeList);
		String jsonNew = json.replace("{\"itemTypeList\":", "");
		String jsonNew1 = jsonNew.substring(0, jsonNew.lastIndexOf("}"));

		model.addAttribute("itemTypes", jsonNew1);

		return "html/common :: itemTypeListFragment";
	}

	@RequestMapping(value = { "admin/getitemListTypeById.html" }, method = RequestMethod.GET)
	public ModelAndView getitemListTypeById(HttpServletRequest request) {
		logger.info("Inside getitemListTypeById()");
		String itemTypeId = request.getParameter("itemTypeId");
		Itemtype itemType = rasikSvc.findItemByType(itemTypeId);
		ModelAndView mav = new ModelAndView("html/updateItemTypes");
		mav.addObject("itemType", itemType);
		return mav;

	}

	/*
	 * Start : Customer functions
	 */

	@RequestMapping(value = { "admin/customer.html" }, method = RequestMethod.GET)
	public ModelAndView geCustomer(HttpServletRequest request) {
		logger.info("Inside geCustomer()");
		ModelAndView mav = new ModelAndView("html/customer");
		Customer customer = new Customer();
		List<Customertype> customerTypeList = rasikSvc.findAllCustomerTypes();

		mav.addObject("customerTypeList", customerTypeList);
		mav.addObject("customer", customer);
		return mav;

	}

	@RequestMapping(value = { "admin/submitCustomer.html" }, method = RequestMethod.POST)
	public ModelAndView submitCustomer(@ModelAttribute Customer customer) {
		logger.info("Inside submitCustomer()");
		ModelAndView mav = new ModelAndView("html/message");
		rasikSvc.saveCustomer(customer);
		mav.addObject("message", "Customer saved.");
		return mav;
	}

	@RequestMapping(value = { "admin/listCustomer.html" }, method = RequestMethod.GET)
	public ModelAndView listCustomer() throws JsonGenerationException,
			JsonMappingException, IOException {
		logger.info("Inside listCustomer()");
		ModelAndView mav = new ModelAndView("html/customerList");
		List<Customer> customerList = rasikSvc.findAllCustomers();
		mav.addObject("customerList", returnJson(customerList));
		return mav;
	}

	@RequestMapping(value = { "admin/getCustomerById.html" }, method = RequestMethod.GET)
	public ModelAndView getCustomerById(HttpServletRequest request) {
		logger.info("Inside getCustomerById()");
		String customerId = request.getParameter("customerId");
		Customer customer = rasikSvc.findCustomerById(customerId);
		ModelAndView mav = new ModelAndView("html/updateCustomer");
		List<Customertype> customerTypeList = rasikSvc.findAllCustomerTypes();
		mav.addObject("customerTypeList", customerTypeList);
		mav.addObject("customer", customer);
		return mav;

	}

	@RequestMapping(value = { "admin/updateCustomer.html" }, method = RequestMethod.POST)
	public ModelAndView updateCustomer(HttpServletRequest request,
			@ModelAttribute Customer customer) {
		logger.info("Inside updateCustomer()");
		ModelAndView mav = new ModelAndView("html/message");
		String actionType = request.getParameter("actionType");
		Customer customerExist = rasikSvc.findCustomerById(String
				.valueOf(customer.getCustomerId()));
		if (customerExist != null) {
			Mapper mapper = new DozerBeanMapper();
			mapper.map(customer, customerExist);
			if (actionType.equals("update")) {
				rasikSvc.updateCustomer(customerExist);
				mav.addObject("message", "Customer updated.");
			}
			if (actionType.equals("delete")) {
				rasikSvc.deleteCustomer(customerExist);
				mav.addObject("message", "Customer deleted.");
			}
		} else {
			mav.addObject("message", "Customer does not exist");
		}
		return mav;
	}

	/*
	 * Start : CustomerType functions
	 */

	@RequestMapping(value = { "admin/submitCustomerType.html" }, method = RequestMethod.POST)
	public ModelAndView submitCustomerType(
			@ModelAttribute Customertype customerType) {
		logger.info("Inside submitCustomerType()");
		ModelAndView mav = new ModelAndView("html/message");
		if (rasikSvc.findCustomerType(customerType) == null) {
			rasikSvc.saveCustomerTypes(customerType);
			mav.addObject("message", "Customertype saved.");
		} else {
			mav.addObject("message", "Customertype already exists");
		}
		return mav;
	}

	@RequestMapping(value = { "admin/customerType.html" }, method = RequestMethod.GET)
	public ModelAndView geCustomerType(HttpServletRequest request) {
		logger.info("Inside geCustomerType()");
		ModelAndView mav = new ModelAndView("html/customer_type");
		Customertype customerType = new Customertype();
		mav.addObject("customerType", customerType);
		return mav;

	}

	@RequestMapping(value = { "admin/listCustomertypes.html" }, method = RequestMethod.GET)
	public ModelAndView listCustomertypes() throws JsonGenerationException,
			JsonMappingException, IOException {
		logger.info("Inside listCustomertypes()");
		ModelAndView mav = new ModelAndView("html/customerTypeList");
		List<Customertype> customerTypeListresult = rasikSvc
				.findAllCustomerTypes();
		mav.addObject("customerTypes", returnJson(customerTypeListresult));
		return mav;
	}

	@RequestMapping(value = { "admin/getCustomerTypeById.html" }, method = RequestMethod.GET)
	public ModelAndView getcustomerListTypeById(HttpServletRequest request) {
		logger.info("Inside getcustomerListTypeById()");
		String customerTypeId = request.getParameter("customerTypeId");
		Customertype customerType = rasikSvc
				.findCustomerTypeById(customerTypeId);
		ModelAndView mav = new ModelAndView("html/updateCustomerTypes");
		mav.addObject("customerType", customerType);
		return mav;

	}

	@RequestMapping(value = { "admin/updateCustomerType.html" }, method = RequestMethod.POST)
	public ModelAndView updateCustomerType(HttpServletRequest request,
			@ModelAttribute Customertype customerType) {
		logger.info("Inside submitItemTypes()");
		ModelAndView mav = new ModelAndView("html/message");
		String actionType = request.getParameter("actionType");
		Customertype customerTypeExist = rasikSvc.findCustomerTypeById(String
				.valueOf(customerType.getCustomertypeId()));
		if (customerTypeExist != null) {
			customerTypeExist.setCustomerType(customerType.getCustomerType());
			customerTypeExist.setCustomertypeDesc(customerType
					.getCustomertypeDesc());
			if (actionType.equals("update")) {
				rasikSvc.updateCustomerTypes(customerTypeExist);
				mav.addObject("message", "Customertype updated.");
			}
			if (actionType.equals("delete")) {
				rasikSvc.deleteCustomerTypes(customerTypeExist);
				mav.addObject("message", "Customertype deleted.");
			}
		} else {
			mav.addObject("message", "Customertype does not exist");
		}
		return mav;
	}

	/*
	 * Start : Author functions
	 */

	@RequestMapping(value = { "admin/submitAuthor.html" }, method = RequestMethod.POST)
	public ModelAndView submitAuthor(@ModelAttribute Authors author) {
		logger.info("Inside submitAuthor()");
		ModelAndView mav = new ModelAndView("html/message");
		rasikSvc.saveAuthor(author);
		mav.addObject("message", "Author saved.");
		return mav;
	}

	@RequestMapping(value = { "admin/author.html" }, method = RequestMethod.GET)
	public ModelAndView getAuthor(HttpServletRequest request) {
		logger.info("Inside getAuthor()");
		ModelAndView mav = new ModelAndView("html/author");
		Authors author = new Authors();
		mav.addObject("author", author);
		return mav;

	}

	@RequestMapping(value = { "admin/listAuthors.html" }, method = RequestMethod.GET)
	public ModelAndView listAuthors() throws JsonGenerationException,
			JsonMappingException, IOException {
		logger.info("Inside listAuthors()");
		ModelAndView mav = new ModelAndView("html/authorList");
		List<Authors> authorsList = rasikSvc.findAllAuthors();
		mav.addObject("authorsList", returnJson(authorsList));
		return mav;
	}

	@RequestMapping(value = { "admin/getAuthorById.html" }, method = RequestMethod.GET)
	public ModelAndView getAuthorById(HttpServletRequest request) {
		logger.info("Inside getAuthorById()");
		String authorId = request.getParameter("authorId");
		Authors author = rasikSvc.findAuthorById(authorId);
		ModelAndView mav = new ModelAndView("html/updateAuthor");
		mav.addObject("author", author);
		return mav;

	}

	@RequestMapping(value = { "admin/updateAuthor.html" }, method = RequestMethod.POST)
	public ModelAndView updateAuthor(HttpServletRequest request,
			@ModelAttribute Authors author) {
		logger.info("Inside updateAuthor()");
		ModelAndView mav = new ModelAndView("html/message");
		String actionType = request.getParameter("actionType");
		Authors authorExist = rasikSvc.findAuthorById(String.valueOf(author
				.getAuthorId()));
		if (authorExist != null) {
			Mapper mapper = new DozerBeanMapper();
			mapper.map(author, authorExist);
			if (actionType.equals("update")) {
				rasikSvc.updateAuthor(authorExist);
				mav.addObject("message", "Author profile updated.");
			}
			if (actionType.equals("delete")) {
				rasikSvc.deleteAuthor(authorExist);
				mav.addObject("message", "Author profile deleted.");
			}
		} else {
			mav.addObject("message", "Author profile does not exist");
		}
		return mav;
	}

	/*
	 * Start : BindingType functions
	 */
	@RequestMapping(value = { "admin/showbindingType.html" }, method = RequestMethod.GET)
	public ModelAndView showbindingTypes() {
		logger.info("Inside showbindingTypes()");
		ModelAndView mav = new ModelAndView("html/bindingType");
		Bindingtype bindingType = new Bindingtype();
		mav.addObject("bindingType", bindingType);
		return mav;
	}

	@RequestMapping(value = { "admin/submitBindingTypes.html" }, method = RequestMethod.POST)
	public String submitBindingTypes(
			HttpServletResponse response,
			Model model,
			@ModelAttribute Bindingtype bindingType,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
			throws IOException {
		logger.info("Inside submitBindingTypes()");

		if (rasikSvc.findBindingTypeByName(bindingType) == null) {
			rasikSvc.saveBindingType(bindingType);

			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("BindingType saved");
				response.setStatus(200);
				return null;
			} else {
				model.addAttribute("message", "BindingType saved.");
				return "html/message";
			}
		} else {
			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("BindingType already exists");
				response.setStatus(200);
				return null;

			} else {
				model.addAttribute("message", "BindingType already exists");
				return "html/message";
			}

		}
	}

	@RequestMapping(value = { "admin/updatebindingType.html" }, method = RequestMethod.POST)
	public ModelAndView updatebindingTypes(HttpServletRequest request,
			@ModelAttribute Bindingtype bindingType) {
		logger.info("Inside updateItemTypes()");
		ModelAndView mav = new ModelAndView("html/message");
		String actionType = request.getParameter("actionType");
		Bindingtype bindingTypeExist = rasikSvc.findBindingTypeById(bindingType
				.getBindingTypeId());
		if (bindingTypeExist != null) {
			bindingTypeExist.setBindingTypeName(bindingType
					.getBindingTypeName());
			if (actionType.equals("update")) {
				rasikSvc.updateBindingTypes(bindingTypeExist);
				mav.addObject("message", "Bindingtype updated.");
			}
			if (actionType.equals("delete")) {
				rasikSvc.deleteBindingTypes(bindingTypeExist);
				mav.addObject("message", "Bindingtype deleted.");
			}
		} else {
			mav.addObject("message", "Bindingtype does not exist");
		}
		return mav;
	}

	@RequestMapping(value = { "admin/listbindingtypes.html" }, method = RequestMethod.GET)
	public ModelAndView listbindingtypes() throws JsonGenerationException,
			JsonMappingException, IOException {
		logger.info("Inside listbindingtypes()");
		ModelAndView mav = new ModelAndView("html/bindingTypeList");
		List<Bindingtype> bindingTypeListresult = rasikSvc
				.findAllBindingTypes();
		mav.addObject("bindingTypeList", returnJson(bindingTypeListresult));
		return mav;
	}

	@RequestMapping(value = { "admin/getbindingTypeById.html" }, method = RequestMethod.GET)
	public ModelAndView getbindingTypeById(HttpServletRequest request) {
		logger.info("Inside getbindingTypeById()");
		String bindingTypeId = request.getParameter("bindingTypeId");
		Bindingtype bindingType = rasikSvc.findBindingTypeById(Integer
				.valueOf(bindingTypeId));
		ModelAndView mav = new ModelAndView("html/updatebindingTypes");
		mav.addObject("bindingType", bindingType);
		return mav;

	}

	/*
	 * Start : Itemlanguage functions
	 */

	@RequestMapping(value = { "admin/submitItemlanguage.html" }, method = RequestMethod.POST)
	public String submitItemlanguage(
			HttpServletResponse response,
			Model model,
			@ModelAttribute Itemlanguage itemlanguage,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
			throws IOException {
		logger.info("Inside submitBindingTypes()");

		if (rasikSvc.findItemlanguageByName(itemlanguage) == null) {
			rasikSvc.saveItemlanguage(itemlanguage);

			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Language saved");
				response.setStatus(200);
				return null;
			} else {
				model.addAttribute("message", "Language saved.");
				return "html/message";
			}
		} else {
			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Language already exists");
				response.setStatus(200);
				return null;

			} else {
				model.addAttribute("message", "Language already exists");
				return "html/message";
			}

		}
	}

	@RequestMapping(value = { "admin/submitItemseditions.html" }, method = RequestMethod.POST)
	public String submitItemseditions(
			HttpServletResponse response,
			Model model,
			@ModelAttribute Itemsedition itemsedition,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
			throws IOException {
		logger.info("Inside submitItemseditions()");

		if (rasikSvc.findItemseditionByDesc(itemsedition) == null) {
			rasikSvc.saveItemsedition(itemsedition);

			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Edition saved");
				response.setStatus(200);
				return null;
			} else {
				model.addAttribute("message", "Edition saved.");
				return "html/message";
			}
		} else {
			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Edition already exists");
				response.setStatus(200);
				return null;

			} else {
				model.addAttribute("message", "Edition already exists");
				return "html/message";
			}

		}
	}

	@RequestMapping(value = { "admin/submitTranslations.html" }, method = RequestMethod.POST)
	public String submitTranslations(
			HttpServletResponse response,
			Model model,
			@ModelAttribute Translation translation,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith)
			throws IOException {
		logger.info("Inside submitTranslations()");

		if (rasikSvc.findTranslationByName(translation) == null) {
			rasikSvc.saveTranslation(translation);

			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Translation saved");
				response.setStatus(200);
				return null;
			} else {
				model.addAttribute("message", "Translation saved.");
				return "html/message";
			}
		} else {
			if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
				response.getOutputStream().print("Translation already exists");
				response.setStatus(200);
				return null;

			} else {
				model.addAttribute("message", "Edition already exists");
				return "html/message";
			}

		}
	}

	/*
	 * Start : Add Item functions
	 */

	@RequestMapping(value = { "admin/add_item.html" }, method = RequestMethod.GET)
	public ModelAndView addItem(HttpServletRequest request) {
		logger.info("Inside addItem()");
		ModelAndView mav = new ModelAndView("html/add_item");
		Items item = new Items();
		mav.addObject("item", item);
		List<Itemtype> itemtypeList = rasikSvc.findAllItemTypes();
		mav.addObject("itemTypeList", itemtypeList);
		List<Bindingtype> bindingTypeList = rasikSvc.findAllBindingTypes();
		mav.addObject("bindingTypeList", bindingTypeList);
		List<Discounts> discountsList = rasikSvc.findAllDiscounts();
		mav.addObject("discountsList", discountsList);
		List<Itemsedition> itemsEditionList = rasikSvc.findAllitemseditions();
		mav.addObject("itemsEditionList", itemsEditionList);
		List<Itemlanguage> itemLanguagesList = rasikSvc.findAllLanguages();
		mav.addObject("itemLanguagesList", itemLanguagesList);
		List<Translation> translationList = rasikSvc.findAllTranslations();
		mav.addObject("translationList", translationList);
		return mav;

	}

	@RequestMapping(value = { "admin/addItemTypeAjax.html" }, method = RequestMethod.GET)
	public String addItemTypeAjax(Model model) {
		logger.info("Inside showItemTypes()");
		Itemtype itemType = new Itemtype();
		model.addAttribute("itemType", itemType);

		return "html/common :: addItemTypeFragment";
	}

	@RequestMapping(value = { "admin/addBindingTypeAjax.html" }, method = RequestMethod.GET)
	public String addBindingTypeAjax(Model model) {
		logger.info("Inside addBindingTypeAjax()");
		Bindingtype bindingType = new Bindingtype();
		model.addAttribute("bindingType", bindingType);

		return "html/common :: bindingTypeFragment";
	}

	@RequestMapping(value = { "admin/addLanguageAjax.html" }, method = RequestMethod.GET)
	public String addLanguageAjax(Model model) {
		logger.info("Inside addLanguageAjax()");
		Itemlanguage itemLanguage = new Itemlanguage();
		model.addAttribute("language", itemLanguage);

		return "html/common :: languageFragment";
	}

	@RequestMapping(value = { "admin/addItemsEdtionAjax.html" }, method = RequestMethod.GET)
	public String addItemsEdtionAjax(Model model) {
		logger.info("Inside addItemsEdtionAjax()");
		Itemsedition itemsedition = new Itemsedition();
		model.addAttribute("itemsedition", itemsedition);

		return "html/common :: itemEditionFragment";
	}

	@RequestMapping(value = { "admin/addTranslationsAjax.html" }, method = RequestMethod.GET)
	public String addTranslationsAjax(Model model) {
		logger.info("Inside addTranslationsAjax()");
		Translation translation = new Translation();
		model.addAttribute("translation", translation);

		return "html/common :: addTranslationFragment";
	}

	@RequestMapping(value = { "admin/addAuthorAjax.html" }, method = RequestMethod.GET)
	public String addAuthorAjax(Model model) {
		logger.info("Inside addAuthorAjax()");
		Authors author = new Authors();
		model.addAttribute("itemsauthor", author);

		return "html/common :: additemAuthorFragment";
	}

	@RequestMapping(value = { "admin/addStockCenterAjax.html" }, method = RequestMethod.GET)
	public String addStockCenterAjax(Model model) {
		logger.info("Inside addStockCenterAjax()");
		Stockcenter stockcenter = new Stockcenter();
		model.addAttribute("itemstockcenter", stockcenter);

		return "html/common :: additemStockCenterFragment";
	}
	
	@RequestMapping(value = { "admin/addPublSupplAjax.html" }, method = RequestMethod.GET)
	public String addPublSupplAjax(Model model) {
		logger.info("Inside addPublSupplAjax()");
		Publsuppl publsuppl = new Publsuppl();
		model.addAttribute("itemspublsuppl", publsuppl);

		return "html/common :: itemPubSupplFragment";
	}
	
	@RequestMapping(value = { "admin/addCategoriesAjax.html" }, method = RequestMethod.GET)
	public String addCategoriesAjax(Model model) {
		logger.info("Inside addCategoriesAjax()");
		Category itemscategory = new Category();
		model.addAttribute("itemscategory", itemscategory);

		return "html/common :: addCategoryFragment";
	}
	

	/*
	 * Private Util functions
	 */

	private String returnJson(Object obj) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(obj);
		return json;

	}

}