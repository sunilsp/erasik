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
 * Home object for domain model class Bindingtype.
 * @see com.rasik.model.Bindingtype
 * @author Hibernate Tools
 */
@Repository
public class BindingtypeDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(BindingtypeDao.class);

	
	
	public void persist(Bindingtype transientInstance) {
		log.debug("persisting Bindingtype instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Bindingtype instance) {
		log.debug("attaching dirty Bindingtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bindingtype instance) {
		log.debug("attaching clean Bindingtype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Bindingtype persistentInstance) {
		log.debug("deleting Bindingtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bindingtype merge(Bindingtype detachedInstance) {
		log.debug("merging Bindingtype instance");
		try {
			Bindingtype result = (Bindingtype) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bindingtype findById(java.lang.Integer id) {
		log.debug("getting Bindingtype instance with id: " + id);
		try {
			Bindingtype instance = (Bindingtype) sessionFactory
					.getCurrentSession().get("com.rasik.hibernate.Bindingtype",
							id);
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

	public List<Bindingtype> findByExample(Bindingtype instance) {
		log.debug("finding Bindingtype instance by example");
		try {
			List<Bindingtype> results = (List<Bindingtype>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Bindingtype")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Bindingtype> findAllBindingTypes(){
		Query query=getSession().getNamedQuery("findAllBindingtypes");
		List<Bindingtype> bindingTypeList=query.list();
		return bindingTypeList;
	}

}
