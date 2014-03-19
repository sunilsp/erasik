package com.rasik.model;
// default package
// Generated Mar 7, 2014 4:42:36 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class Reprint.
 * @see .Reprint
 * @author Hibernate Tools
 */
@Repository
public class ReprintDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(ReprintDao.class);


	public void persist(Reprint transientInstance) {
		log.debug("persisting Reprint instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Reprint persistentInstance) {
		log.debug("removing Reprint instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Reprint merge(Reprint detachedInstance) {
		log.debug("merging Reprint instance");
		try {
			Reprint result = (Reprint) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Reprint findById(java.lang.Integer id) {
		log.debug("getting Reprint instance with id: " + id);
		try {
			Reprint instance = (Reprint) getSession().get(
							"com.rasik.model.Reprint", id);
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
	
	public List<Reprint> findAllReprints(){
		Query query=getSession().getNamedQuery("findAllReprints");
		List<Reprint> reprintList=query.list();
		return reprintList;
	}
}
