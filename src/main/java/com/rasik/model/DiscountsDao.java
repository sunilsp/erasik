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
 * Home object for domain model class Discounts.
 * @see com.rasik.model.Discounts
 * @author Hibernate Tools
 */
@Repository
public class DiscountsDao extends RasikBaseDao {

	private static final Log log = LogFactory.getLog(DiscountsDao.class);


	public void persist(Discounts transientInstance) {
		log.debug("persisting Discounts instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Discounts instance) {
		log.debug("attaching dirty Discounts instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Discounts instance) {
		log.debug("attaching clean Discounts instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Discounts persistentInstance) {
		log.debug("deleting Discounts instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Discounts merge(Discounts detachedInstance) {
		log.debug("merging Discounts instance");
		try {
			Discounts result = (Discounts) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Discounts findById(java.lang.Integer id) {
		log.debug("getting Discounts instance with id: " + id);
		try {
			Discounts instance = (Discounts) getSession()
					.get("com.rasik.hibernate.Discounts", id);
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

	public List<Discounts> findByExample(Discounts instance) {
		log.debug("finding Discounts instance by example");
		try {
			List<Discounts> results = (List<Discounts>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Discounts")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Discounts> findAllDiscounts() {
		Query query=getSession().getNamedQuery("findAllDiscounts");
		List<Discounts> discountsList=query.list();
		return discountsList;

	}
}
