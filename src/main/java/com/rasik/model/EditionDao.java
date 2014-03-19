package com.rasik.model;
// default package
// Generated Mar 7, 2014 4:42:36 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class Edition.
 * @see .Edition
 * @author Hibernate Tools
 */
@Repository
public class EditionDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(EditionDao.class);


	public void persist(Edition transientInstance) {
		log.debug("persisting Edition instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Edition persistentInstance) {
		log.debug("removing Edition instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Edition merge(Edition detachedInstance) {
		log.debug("merging Edition instance");
		try {
			Edition result = (Edition) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Edition findById(java.lang.Integer id) {
		log.debug("getting Edition instance with id: " + id);
		try {
			Edition instance = (Edition) getSession().get(
							"com.rasik.model.Edition", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Edition> findAllEditions() {
		Query query=getSession().getNamedQuery("findAllEditions");
		List<Edition> editionList=query.list();
		return editionList;

	}
	
	public Edition findItemseditionByDesc(String itemsedition) {
		Query query=getSession().getNamedQuery("findEditionByName").setString("edition", itemsedition);
		List<Edition> itemseditionList=query.list();
			if(itemseditionList.size() != 0){
				return itemseditionList.get(0);
			}
			else{
				return null;
			}

	}

}
