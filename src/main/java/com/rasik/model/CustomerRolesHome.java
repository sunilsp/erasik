package com.rasik.model;

// Generated May 12, 2014 8:05:36 PM by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CustomerRoles.
 * @see com.rasik.hibernate.CustomerRoles
 * @author Hibernate Tools
 */
public class CustomerRolesHome {

	private static final Log log = LogFactory.getLog(CustomerRolesHome.class);

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

	public void persist(CustomerRoles transientInstance) {
		log.debug("persisting CustomerRoles instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CustomerRoles instance) {
		log.debug("attaching dirty CustomerRoles instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustomerRoles instance) {
		log.debug("attaching clean CustomerRoles instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CustomerRoles persistentInstance) {
		log.debug("deleting CustomerRoles instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustomerRoles merge(CustomerRoles detachedInstance) {
		log.debug("merging CustomerRoles instance");
		try {
			CustomerRoles result = (CustomerRoles) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerRoles findById(java.lang.Integer id) {
		log.debug("getting CustomerRoles instance with id: " + id);
		try {
			CustomerRoles instance = (CustomerRoles) sessionFactory
					.getCurrentSession().get(
							"com.rasik.hibernate.CustomerRoles", id);
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

	public List<CustomerRoles> findByExample(CustomerRoles instance) {
		log.debug("finding CustomerRoles instance by example");
		try {
			List<CustomerRoles> results = (List<CustomerRoles>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.CustomerRoles")
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
