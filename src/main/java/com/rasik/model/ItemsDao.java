package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Items.
 * @see com.rasik.model.Items
 * @author Hibernate Tools
 */
@Repository
public class ItemsDao  extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(ItemsDao.class);

	
	public void persist(Items transientInstance) {
		log.debug("persisting Items instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Items instance) {
		log.debug("attaching dirty Items instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Items instance) {
		log.debug("attaching clean Items instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Items persistentInstance) {
		log.debug("deleting Items instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Items merge(Items detachedInstance) {
		log.debug("merging Items instance");
		try {
			Items result = (Items) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Items findById(java.lang.Integer id) {
		log.debug("getting Items instance with id: " + id);
		try {
			Items instance = (Items) getSession().get(
					"com.rasik.hibernate.Items", id);
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

	public List<Items> findAllItems() {
		log.debug("finding all Items ");
		try {
			List<Items> results = (List<Items>) getSession()
					.createCriteria("com.rasik.model.Items")
					.list();
			log.debug("find all items successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all items failed", re);
			throw re;
		}
	}


}
