package com.rasik.model;

// Generated Dec 2, 2013 2:13:04 PM by Hibernate Tools 4.0.0

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class UserInfo.
 * @see kriyas.model.UserInfo
 * @author Hibernate Tools
 */
@Repository
public class UserInfoDao extends RasikBaseDao {

	private static final Log log = LogFactory.getLog(UserInfoDao.class);

	
	public void persist(UserInfo transientInstance) {
		log.debug("persisting Usersinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserInfo persistentInstance) {
		log.debug("removing UserInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserInfo findById(Long id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getSession().get(UserInfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
