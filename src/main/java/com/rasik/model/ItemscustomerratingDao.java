package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Itemscustomerrating.
 * @see com.rasik.model.Itemscustomerrating
 * @author Hibernate Tools
 */
public class ItemscustomerratingDao extends RasikBaseDao{

	private static final Log log = LogFactory
			.getLog(ItemscustomerratingDao.class);

		public void persist(Itemscustomerrating transientInstance) {
		log.debug("persisting Itemscustomerrating instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemscustomerrating instance) {
		log.debug("attaching dirty Itemscustomerrating instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemscustomerrating instance) {
		log.debug("attaching clean Itemscustomerrating instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemscustomerrating persistentInstance) {
		log.debug("deleting Itemscustomerrating instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemscustomerrating merge(Itemscustomerrating detachedInstance) {
		log.debug("merging Itemscustomerrating instance");
		try {
			Itemscustomerrating result = (Itemscustomerrating) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemscustomerrating findById(int id) {
		log.debug("getting Itemscustomerrating instance with id: " + id);
		try {
			Itemscustomerrating instance = (Itemscustomerrating) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Itemscustomerrating", id);
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

	public List<Itemscustomerrating> findByExample(Itemscustomerrating instance) {
		log.debug("finding Itemscustomerrating instance by example");
		try {
			List<Itemscustomerrating> results = (List<Itemscustomerrating>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemscustomerrating")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
