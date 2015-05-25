package org.sky.ssh1.alpha.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BasicHibernateDAOSupport extends HibernateDaoSupport
{
	@Resource(name = "hibernateSessionFactory")
	public void setSF(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
}
