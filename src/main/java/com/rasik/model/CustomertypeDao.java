package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Customertype.
 * @see com.rasik.model.Customertype
 * @author Hibernate Tools
 */
@Repository
public class CustomertypeDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(CustomertypeDao.class);


	public void persist(Customertype transientInstance) {
		log.debug("persisting Customertype instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Customertype instance) {
		log.debug("attaching dirty Customertype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customertype instance) {
		log.debug("attaching clean Customertype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Customertype persistentInstance) {
		log.debug("deleting Customertype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customertype merge(Customertype detachedInstance) {
		log.debug("merging Customertype instance");
		try {
			Customertype result = (Customertype) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customertype findById(int id) {
		log.debug("getting Customertype instance with id: " + id);
		try {
			Customertype instance = (Customertype) getSession().get(
							"com.rasik.model.Customertype", id);
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

	public List<Customertype> findByExample(Customertype instance) {
		log.debug("finding Customertype instance by example");
		try {
			List<Customertype> results = (List<Customertype>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Customertype")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Customertype> findByCutomerType(Customertype instance) {
		log.debug("finding Customertype instance by customerType");
		try {
			List<Customertype> results = (List<Customertype>) getSession()
					.createCriteria("com.rasik.model.Customertype").add(Restrictions.eq("customerType",instance.getCustomerType()))
					.list();
			log.debug("find by customerType successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by customerType failed", re);
			throw re;
		}
	}
	
	public List<Customertype> findAllCutomerTypes() {
		log.debug("finding All Customertypes");
	/*	try {
			List<Customertype> results = (List<Customertype>) getSession()
					.createCriteria("com.rasik.model.Customertype")
					.list();
			log.debug("find All customerTypes successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find All customerTypes failed", re);
			throw re;
		}*/
		Query query=getSession().getNamedQuery("findAllCustomertypes");
		List<Customertype> customerTypeList=query.list();
		return customerTypeList;
	}
}
