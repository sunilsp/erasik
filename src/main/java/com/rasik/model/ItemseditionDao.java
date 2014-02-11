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
 * Home object for domain model class Itemsedition.
 * @see com.rasik.model.Itemsedition
 * @author Hibernate Tools
 */
@Repository
public class ItemseditionDao extends RasikBaseDao {

	private static final Log log = LogFactory.getLog(ItemseditionDao.class);

	
	public void persist(Itemsedition transientInstance) {
		log.debug("persisting Itemsedition instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemsedition instance) {
		log.debug("attaching dirty Itemsedition instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemsedition instance) {
		log.debug("attaching clean Itemsedition instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemsedition persistentInstance) {
		log.debug("deleting Itemsedition instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemsedition merge(Itemsedition detachedInstance) {
		log.debug("merging Itemsedition instance");
		try {
			Itemsedition result = (Itemsedition) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemsedition findById(int id) {
		log.debug("getting Itemsedition instance with id: " + id);
		try {
			Itemsedition instance = (Itemsedition) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Itemsedition", id);
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

	public List<Itemsedition> findByExample(Itemsedition instance) {
		log.debug("finding Itemsedition instance by example");
		try {
			List<Itemsedition> results = (List<Itemsedition>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemsedition")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Itemsedition> findAllitemseditions() {
		Query query=getSession().getNamedQuery("findAllItemseditions");
		List<Itemsedition> itemseditionList=query.list();
		return itemseditionList;

	}
}
