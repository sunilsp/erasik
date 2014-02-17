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
 * Home object for domain model class Stockcenter.
 * @see com.rasik.model.Stockcenter
 * @author Hibernate Tools
 */
public class StockcenterDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(StockcenterDao.class);

	
	public void persist(Stockcenter transientInstance) {
		log.debug("persisting Stockcenter instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Stockcenter instance) {
		log.debug("attaching dirty Stockcenter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stockcenter instance) {
		log.debug("attaching clean Stockcenter instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Stockcenter persistentInstance) {
		log.debug("deleting Stockcenter instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stockcenter merge(Stockcenter detachedInstance) {
		log.debug("merging Stockcenter instance");
		try {
			Stockcenter result = (Stockcenter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Stockcenter findById(java.lang.Integer id) {
		log.debug("getting Stockcenter instance with id: " + id);
		try {
			Stockcenter instance = (Stockcenter) sessionFactory
					.getCurrentSession().get("com.rasik.hibernate.Stockcenter",
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

	public List<Stockcenter> findByExample(Stockcenter instance) {
		log.debug("finding Stockcenter instance by example");
		try {
			List<Stockcenter> results = (List<Stockcenter>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Stockcenter")
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
