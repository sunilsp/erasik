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
 * Home object for domain model class Itemspublsuppl.
 * @see com.rasik.model.Itemspublsuppl
 * @author Hibernate Tools
 */
public class ItemspublsupplHome {

	private static final Log log = LogFactory.getLog(ItemspublsupplHome.class);

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

	public void persist(Itemspublsuppl transientInstance) {
		log.debug("persisting Itemspublsuppl instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemspublsuppl instance) {
		log.debug("attaching dirty Itemspublsuppl instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemspublsuppl instance) {
		log.debug("attaching clean Itemspublsuppl instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemspublsuppl persistentInstance) {
		log.debug("deleting Itemspublsuppl instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemspublsuppl merge(Itemspublsuppl detachedInstance) {
		log.debug("merging Itemspublsuppl instance");
		try {
			Itemspublsuppl result = (Itemspublsuppl) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemspublsuppl findById(java.lang.Integer id) {
		log.debug("getting Itemspublsuppl instance with id: " + id);
		try {
			Itemspublsuppl instance = (Itemspublsuppl) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Itemspublsuppl", id);
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

	public List<Itemspublsuppl> findByExample(Itemspublsuppl instance) {
		log.debug("finding Itemspublsuppl instance by example");
		try {
			List<Itemspublsuppl> results = (List<Itemspublsuppl>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemspublsuppl")
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
