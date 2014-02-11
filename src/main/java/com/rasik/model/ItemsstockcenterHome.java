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
 * Home object for domain model class Itemsstockcenter.
 * @see com.rasik.model.Itemsstockcenter
 * @author Hibernate Tools
 */
public class ItemsstockcenterHome {

	private static final Log log = LogFactory
			.getLog(ItemsstockcenterHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Itemsstockcenter transientInstance) {
		log.debug("persisting Itemsstockcenter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemsstockcenter instance) {
		log.debug("attaching dirty Itemsstockcenter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemsstockcenter instance) {
		log.debug("attaching clean Itemsstockcenter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemsstockcenter persistentInstance) {
		log.debug("deleting Itemsstockcenter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemsstockcenter merge(Itemsstockcenter detachedInstance) {
		log.debug("merging Itemsstockcenter instance");
		try {
			Itemsstockcenter result = (Itemsstockcenter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemsstockcenter findById(java.lang.Integer id) {
		log.debug("getting Itemsstockcenter instance with id: " + id);
		try {
			Itemsstockcenter instance = (Itemsstockcenter) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Itemsstockcenter", id);
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

	public List<Itemsstockcenter> findByExample(Itemsstockcenter instance) {
		log.debug("finding Itemsstockcenter instance by example");
		try {
			List<Itemsstockcenter> results = (List<Itemsstockcenter>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemsstockcenter")
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
