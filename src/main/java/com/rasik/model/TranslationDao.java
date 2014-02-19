package com.rasik.model;

// Generated Jan 20, 2014 10:30:55 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import rasik.RasikDaoTestBase;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Translation.
 * @see com.rasik.model.Translation
 * @author Hibernate Tools
 */
@Repository
public class TranslationDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(TranslationDao.class);

	
	public void persist(Translation transientInstance) {
		log.debug("persisting Translation instance");
		try {
			getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Translation instance) {
		log.debug("attaching dirty Translation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Translation instance) {
		log.debug("attaching clean Translation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Translation persistentInstance) {
		log.debug("deleting Translation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Translation merge(Translation detachedInstance) {
		log.debug("merging Translation instance");
		try {
			Translation result = (Translation) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Translation findById(int id) {
		log.debug("getting Translation instance with id: " + id);
		try {
			Translation instance = (Translation) sessionFactory
					.getCurrentSession().get("com.rasik.hibernate.Translation",
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

	public List<Translation> findByExample(Translation instance) {
		log.debug("finding Translation instance by example");
		try {
			List<Translation> results = (List<Translation>) getSession()
					.createCriteria("com.rasik.hibernate.Translation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Translation findTranslationByName(String originalname) {
		Query query=getSession().getNamedQuery("findTranslationByName").setString("originalname", originalname);
		List<Translation> translationList=query.list();
			if(translationList.size() != 0){
				return translationList.get(0);
			}
			else{
				return null;
			}
	}

	public List<Translation> findAllTranslations() {
		Query query=getSession().getNamedQuery("findAllTranslations");
		List<Translation> translationList=query.list();
		return translationList;
	}
}
