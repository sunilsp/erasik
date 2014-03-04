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

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Awarddetail.
 * @see com.rasik.model.Awarddetail
 * @author Hibernate Tools
 */
@Repository
public class AwarddetailDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(AwarddetailDao.class);

	public void persist(Awarddetail transientInstance) {
		log.debug("persisting Awarddetail instance");
		try {
				getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Awarddetail instance) {
		log.debug("attaching dirty Awarddetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Awarddetail instance) {
		log.debug("attaching clean Awarddetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Awarddetail persistentInstance) {
		log.debug("deleting Awarddetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Awarddetail merge(Awarddetail detachedInstance) {
		log.debug("merging Awarddetail instance");
		try {
			Awarddetail result = (Awarddetail) getSession().merge(detachedInstance);
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
			Awarddetail instance = (Awarddetail) getSession().get("com.rasik.model.Awarddetail",
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
			List<Awarddetail> results = (List<Awarddetail>) getSession()
					.createCriteria("com.rasik.model.Awarddetail")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Awarddetail> findAllAwarddetails() {
		Query query=getSession().getNamedQuery("findAllAwardDetails");
		List<Awarddetail> awarddetailList=query.list();
		return awarddetailList;
	}
	
	public  Awarddetail findAwarddetailByName(String awardDetailsEnglish) {
		Query query=getSession().getNamedQuery("findAwardByName").setString("awardDetailsEnglish", awardDetailsEnglish);
		List<Awarddetail> awarddetailList=query.list();
		
		if(awarddetailList.size() != 0){
			return awarddetailList.get(0);
		}
		else{
			return null;
		}
	}

}
