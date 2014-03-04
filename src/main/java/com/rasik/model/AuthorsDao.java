package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Authors.
 * @see com.rasik.model.Authors
 * @author Hibernate Tools
 */
@Repository
public class AuthorsDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(AuthorsDao.class);

	
	public void persist(Authors transientInstance) {
		log.debug("persisting Authors instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Authors instance) {
		log.debug("attaching dirty Authors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Authors instance) {
		log.debug("attaching clean Authors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Authors persistentInstance) {
		log.debug("deleting Authors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Authors merge(Authors detachedInstance) {
		log.debug("merging Authors instance");
		try {
			Authors result = (Authors) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Authors findById(java.lang.Integer id) {
		log.debug("getting Authors instance with id: " + id);
		try {
			Authors instance = (Authors) getSession()
					.get("com.rasik.model.Authors", id);
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

	public List<Authors> findByExample(Authors instance) {
		log.debug("finding Authors instance by example");
		try {
			List<Authors> results = (List<Authors>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.model.Authors")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Authors> findAllAuthors() {
		log.debug("finding all Authors ");
		try {
			List<Authors> results = (List<Authors>) getSession()
					.createCriteria("com.rasik.model.Authors")
					.list();
			log.debug("find all authors successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all authors failed", re);
			throw re;
		}
	}
	
	public  Authors findAuthorByName(String authorName) {
		Query query=getSession().getNamedQuery("findAuthoryByName").setString("englishName", authorName);
		List<Authors> authorsList=query.list();
		
		if(authorsList.size() != 0){
			return authorsList.get(0);
		}
		else{
			return null;
		}
	}
}
