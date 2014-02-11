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
 * Home object for domain model class Itemtype.
 * @see com.rasik.model.Itemtype
 * @author Hibernate Tools
 */
@Repository
public class ItemtypeDao extends RasikBaseDao{

	private static final Log log = LogFactory.getLog(ItemtypeDao.class);


	public void persist(Itemtype transientInstance) {
		log.debug("persisting Itemtype instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Itemtype instance) {
		log.debug("attaching dirty Itemtype instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemtype instance) {
		log.debug("attaching clean Itemtype instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemtype persistentInstance) {
		log.debug("deleting Itemtype instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Itemtype merge(Itemtype detachedInstance) {
		log.debug("merging Itemtype instance");
		try {
			Itemtype result = (Itemtype) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemtype findById(java.lang.Integer id) {
		log.debug("getting Itemtype instance with id: " + id);
		try {
			Itemtype instance = (Itemtype) sessionFactory.getCurrentSession()
					.get("com.rasik.model.Itemtype", id);
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

	public List<Itemtype> findByExample(Itemtype instance) {
		log.debug("finding Itemtype instance by example");
		try {
			List<Itemtype> results = (List<Itemtype>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.rasik.hibernate.Itemtype")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public Itemtype findItemTypeByDesc(String desc){
	Query query=getSession().getNamedQuery("findItemByDesc").setString("description", desc);
	List<Itemtype> itemTypeList=query.list();
		if(itemTypeList.size() != 0){
			return itemTypeList.get(0);
		}
		else{
			return null;
		}
	
	}

	
	public List<Itemtype> findAllItemTypes(){
		Query query=getSession().getNamedQuery("findAllItemtypes");
		List<Itemtype> itemTypeList=query.list();
		return itemTypeList;
	}

}
