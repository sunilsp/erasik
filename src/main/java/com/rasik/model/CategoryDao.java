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
 * Home object for domain model class Category.
 * @see com.rasik.model.Category
 * @author Hibernate Tools
 */
@Repository
public class CategoryDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(CategoryDao.class);


	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(java.lang.Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = (Category) getSession()
					.get("com.rasik.model.Category", id);
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

	public List<Category> findByExample(Category instance) {
		log.debug("finding Category instance by example");
		try {
			List<Category> results = (List<Category>) getSession()
					.createCriteria("com.rasik.model.Category")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Category> findAllCategories() {
		Query query=getSession().getNamedQuery("findAllCategories");
		List<Category> categoryList=query.list();
		return categoryList;
	}
	
	public  Category findCategoryByName(String categoryHeadEnglish) {
		Query query=getSession().getNamedQuery("findCategoryByName").setString("categoryHeadEnglish", categoryHeadEnglish);
		List<Category> categoryList=query.list();
		
		if(categoryList.size() != 0){
			return categoryList.get(0);
		}
		else{
			return null;
		}
	}
	
	}
