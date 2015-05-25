package org.sky.ssh1.alpha.ibatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

/**
 * Base class for all DAO class. The subclass extends this class to get
 * <p>
 * DAO implementation proxy.
 * 
 * @author lifetragedy
 * 
 * @param <T>
 */
public class IBatisDAOSupport<T>
{

	protected Logger log = Logger.getLogger(this.getClass());

	@Resource
	private SqlSessionFactory ibatisSessionFactory;

	private T mapper;

	public SqlSessionFactory getSessionFactory()
	{
		return ibatisSessionFactory;
	}

	protected SqlSession getSqlSession()
	{
		return ibatisSessionFactory.openSession();
	}

	public T getMapper(Class<T> clazz)
	{
		mapper = getSqlSession().getMapper(clazz);
		return mapper;
	}

	public T getMapper(Class<T> clazz, SqlSession session)
	{
		mapper = session.getMapper(clazz);
		return mapper;
	}

	/**
	 * close SqlSession
	 */
	protected void closeSqlSession(SqlSession sqlSession) throws Exception
	{
		try
		{
			if (sqlSession != null)
			{
				sqlSession.close();
				sqlSession = null;
			}
		}
		catch (Exception e)
		{
		}
	}
}
