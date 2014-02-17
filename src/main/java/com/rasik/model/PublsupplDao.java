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
 * Home object for domain model class Publsuppl.
 * @see com.rasik.model.Publsuppl
 * @author Hibernate Tools
 */
public class PublsupplHome {

	private static final Log log = LogFactory.getLog(PublsupplHome.class);

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

	public void persist(Publsuppl transientInstance) {
		log.debug("persisting Publsuppl instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Publsuppl instance) {
		log.debug("attaching dirty Publsuppl instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publsuppl instance) {
		log.debug("attaching clean Publsuppl instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Publsuppl persistentInstance) {
		log.debug("deleting Publsuppl instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publsuppl merge(Publsuppl detachedInstance) {
		log.debug("merging Publsuppl instance");
		try {
			Publsuppl result = (Publsuppl) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Publsuppl findById(int id) {
		log.debug("getting Publsuppl instance with id: " + id);
		try {
			Publsuppl instance = (Publsuppl) sessionFactory.getCurrentSession()
					.get("com.rasik.hibernate.Publsuppl", id);
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

	public List<Publsuppl> findByExample(Publsuppl instance) {
		log.debug("finding Publsuppl instance by example");
		try {
			List<Publsuppl> results = (List<Publsuppl>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Publsuppl")
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
