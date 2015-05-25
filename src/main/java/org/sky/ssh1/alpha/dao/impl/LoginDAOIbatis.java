package org.sky.ssh1.alpha.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.sky.ssh1.alpha.dao.LoginDAO;
import org.sky.ssh1.alpha.ibatis.IBatisDAOSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOIbatis extends IBatisDAOSupport<LoginDAO> implements LoginDAO
{

	@Override
	public boolean login(Map<String, String> paramMap) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		boolean isLogin = false;
		try
		{
			isLogin = this.getMapper(LoginDAO.class, sqlSession).login(paramMap);
		}
		finally
		{
			this.closeSqlSession(sqlSession);
		}
		return isLogin;
	}

}
