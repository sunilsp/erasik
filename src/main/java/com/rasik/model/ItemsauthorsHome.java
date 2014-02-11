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
 * Home object for domain model class Itemsauthors.
 * @see com.rasik.model.Itemsauthors
 * @author Hibernate Tools
 */
public class ItemsauthorsHome {

	private static final Log log = LogFactory.getLog(ItemsauthorsHome.class);

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

	public void persist(Itemsauthors transientInstance) {
		log.debug("persisting Itemsauthors instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemsauthors instance) {
		log.debug("attaching dirty Itemsauthors instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemsauthors instance) {
		log.debug("attaching clean Itemsauthors instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemsauthors persistentInstance) {
		log.debug("deleting Itemsauthors instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemsauthors merge(Itemsauthors detachedInstance) {
		log.debug("merging Itemsauthors instance");
		try {
			Itemsauthors result = (Itemsauthors) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemsauthors findById(java.lang.Integer id) {
		log.debug("getting Itemsauthors instance with id: " + id);
		try {
			Itemsauthors instance = (Itemsauthors) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Itemsauthors", id);
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

	public List<Itemsauthors> findByExample(Itemsauthors instance) {
		log.debug("finding Itemsauthors instance by example");
		try {
			List<Itemsauthors> results = (List<Itemsauthors>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemsauthors")
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
