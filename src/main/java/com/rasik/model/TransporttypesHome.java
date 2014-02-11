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
 * Home object for domain model class Transporttypes.
 * @see com.rasik.model.Transporttypes
 * @author Hibernate Tools
 */
public class TransporttypesHome {

	private static final Log log = LogFactory.getLog(TransporttypesHome.class);

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

	public void persist(Transporttypes transientInstance) {
		log.debug("persisting Transporttypes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transporttypes instance) {
		log.debug("attaching dirty Transporttypes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transporttypes instance) {
		log.debug("attaching clean Transporttypes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Transporttypes persistentInstance) {
		log.debug("deleting Transporttypes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transporttypes merge(Transporttypes detachedInstance) {
		log.debug("merging Transporttypes instance");
		try {
			Transporttypes result = (Transporttypes) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transporttypes findById(java.lang.Integer id) {
		log.debug("getting Transporttypes instance with id: " + id);
		try {
			Transporttypes instance = (Transporttypes) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.Transporttypes", id);
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

	public List<Transporttypes> findByExample(Transporttypes instance) {
		log.debug("finding Transporttypes instance by example");
		try {
			List<Transporttypes> results = (List<Transporttypes>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Transporttypes")
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
