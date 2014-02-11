package com.rasik.beans;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.rasik.service.RasikService;



@Named
@Scope("session")
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1703412419796536470L;
	@Inject
	RasikService rasikSvc;
	private String name;
	private String primeName;
	
	public String printMsgFromSpring() {
		return rasikSvc.getMessage();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimeName() {
		return primeName;
	}

	public void setPrimeName(String primaName) {
		this.primeName = primaName;
	}

}