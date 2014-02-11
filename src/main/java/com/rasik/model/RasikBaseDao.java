/**
 * 
 */
package com.rasik.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunilsp
 *
 */

public class RasikBaseDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		Session session=sessionFactory.getCurrentSession();
		if(session == null){
			session=sessionFactory.openSession();
		}
		return session;
	}

}
