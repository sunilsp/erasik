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
 * Home object for domain model class Awarddetail.
 * @see com.rasik.model.Awarddetail
 * @author Hibernate Tools
 */
public class AwarddetailHome {

	private static final Log log = LogFactory.getLog(AwarddetailHome.class);

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

	public void persist(Awarddetail transientInstance) {
		log.debug("persisting Awarddetail instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Awarddetail instance) {
		log.debug("attaching dirty Awarddetail instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Awarddetail instance) {
		log.debug("attaching clean Awarddetail instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Awarddetail persistentInstance) {
		log.debug("deleting Awarddetail instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Awarddetail merge(Awarddetail detachedInstance) {
		log.debug("merging Awarddetail instance");
		try {
			Awarddetail result = (Awarddetail) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Awarddetail findById(java.lang.Integer id) {
		log.debug("getting Awarddetail instance with id: " + id);
		try {
			Awarddetail instance = (Awarddetail) sessionFactory
					.getCurrentSession().get("com.rasik.hibernate.Awarddetail",
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

	public List<Awarddetail> findByExample(Awarddetail instance) {
		log.debug("finding Awarddetail instance by example");
		try {
			List<Awarddetail> results = (List<Awarddetail>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Awarddetail")
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
