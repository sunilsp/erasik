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
 * Home object for domain model class Transporter.
 * @see com.rasik.model.Transporter
 * @author Hibernate Tools
 */
public class TransporterDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(TransporterDao.class);

	public void persist(Transporter transientInstance) {
		log.debug("persisting Transporter instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transporter instance) {
		log.debug("attaching dirty Transporter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transporter instance) {
		log.debug("attaching clean Transporter instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Transporter persistentInstance) {
		log.debug("deleting Transporter instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transporter merge(Transporter detachedInstance) {
		log.debug("merging Transporter instance");
		try {
			Transporter result = (Transporter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transporter findById(java.lang.Integer id) {
		log.debug("getting Transporter instance with id: " + id);
		try {
			Transporter instance = (Transporter) sessionFactory
					.getCurrentSession().get("com.rasik.hibernate.Transporter",
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

	public List<Transporter> findByExample(Transporter instance) {
		log.debug("finding Transporter instance by example");
		try {
			List<Transporter> results = (List<Transporter>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Transporter")
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
