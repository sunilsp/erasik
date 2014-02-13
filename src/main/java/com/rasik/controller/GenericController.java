package com.rasik.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rasik.beans.ContactusBean;
import com.rasik.model.UserInfo;
import com.rasik.service.RasikService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 *  Following Controller is a generic Controller to have ready UI for 
 *  <ul>
 *  <li>Spring MVC</li>
 *  <li> Spring Webflow</li>
 *  <li> Thymeleaf</li>
 *  <li> JSF with PrimeFaces</li>
 *  <li> Spring Security </li>
 *  <li> Spring Web Services</li>
 *  </ul>
 */

@Controller
class GenericController{
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	RasikService rasikSvc;
	
	@RequestMapping(value="home.do",method=RequestMethod.GET)
	public ModelAndView getHomePage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView("jsp/home");
		logger.info("Inside getHomePage()");
		UserInfo userInfo=rasikSvc.getUserInfo(new Long(1));
		mav.addObject("userInfo", userInfo);
		return mav; 
	} 
	
	//Function below is used by Spring Webflow. Called from hello-flow.xml
	public UserInfo getUserInfo(){
		logger.info("Inside getUserInfo()");
		UserInfo userInfo=rasikSvc.getUserInfo(new Long(1));
		return userInfo;
	}
	
	// Function below demonstrates Spring REST services
	@RequestMapping(value="user.get/{id}",method=RequestMethod.GET)
	@ResponseBody
	    public UserInfo getById(@PathVariable Long id) {
		logger.info("Inside getById()");	
	    return rasikSvc.getUserInfo(new Long(id));
	 }

	@RequestMapping(value="security.do",method=RequestMethod.GET)
	public String getSecurePage(HttpServletRequest request,HttpServletResponse response){
		logger.info("Inside getSecurePage()");
			return "jsp/security";
	}
	
	//Thymeleaf integration example
	@RequestMapping(value =
		{
				"example1.html"
		}, method = RequestMethod.GET)
		public ModelAndView example1()
		{
			logger.info("Inside example1()");
			ModelAndView mav=new ModelAndView("html/example1");
			//UserInfo userInfo=rasikSvc.getUserInfo(new Long(1));
			UserInfo userInfo=new UserInfo();
			userInfo.setName("Sunil");
			userInfo.setUserId(new Long(1));;
			mav.addObject("userInfo", userInfo);
			return mav;
		}
	
	  @RequestMapping(value =
			{
					"html/pageNotFound.html"
			}, method = RequestMethod.GET)
			public String example2()
			{
		  		logger.info("Inside example2()");
		  		return "html/error/pageNotFound";
			}
	  

}