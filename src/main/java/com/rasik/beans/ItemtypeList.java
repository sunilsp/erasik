/**
 * 
 */
package com.rasik.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rasik.model.Itemtype;

/**
 * @author FirstName LastName
 *
 */
@XmlRootElement(name="itemTypeList")
@XmlAccessorType (XmlAccessType.FIELD)
public class ItemtypeList {
	@XmlElement(name="itemType")
	private List<Itemtype> itemTypeList;

	/**
	 * @return the itemTypeList
	 */
	public List<Itemtype> getItemTypeList() {
		return itemTypeList;
	}

	/**
	 * @param itemTypeList the itemTypeList to set
	 */
	
	public void setItemTypeList(List<Itemtype> itemTypeList) {
		this.itemTypeList = itemTypeList;
	}

}
