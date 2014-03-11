package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Itemlanguage.
 * @see com.rasik.model.Itemlanguage
 * @author Hibernate Tools
 */
@Repository
public class ItemlanguageDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(ItemlanguageDao.class);


	public void persist(Itemlanguage transientInstance) {
		log.debug("persisting Itemlanguage instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemlanguage instance) {
		log.debug("attaching dirty Itemlanguage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemlanguage instance) {
		log.debug("attaching clean Itemlanguage instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemlanguage persistentInstance) {
		log.debug("deleting Itemlanguage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemlanguage merge(Itemlanguage detachedInstance) {
		log.debug("merging Itemlanguage instance");
		try {
			Itemlanguage result = (Itemlanguage) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemlanguage findById(java.lang.Integer id) {
		log.debug("getting Itemlanguage instance with id: " + id);
		try {
			Itemlanguage instance =(Itemlanguage) getSession().get(
							"com.rasik.model.Itemlanguage", id);
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

	public List<Itemlanguage> findByExample(Itemlanguage instance) {
		log.debug("finding Itemlanguage instance by example");
		try {
			List<Itemlanguage> results = (List<Itemlanguage>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemlanguage")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Itemlanguage> findAllLanguages() {
		Query query=getSession().getNamedQuery("findAllItemlanguages");
		List<Itemlanguage> languagesList=query.list();
		return languagesList;

	}

	public  Itemlanguage findItemlanguageByName(String languageName) {
		Query query=getSession().getNamedQuery("findLanguageByName").setString("languageName", languageName);
		List<Itemlanguage> languagesList=query.list();
		
		if(languagesList.size() != 0){
			return languagesList.get(0);
		}
		else{
			return null;
		}
	}
}
