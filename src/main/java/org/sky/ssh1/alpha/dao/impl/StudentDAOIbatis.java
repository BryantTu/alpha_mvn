package org.sky.ssh1.alpha.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sky.ssh1.alpha.dao.StudentDAO;
import org.sky.ssh1.alpha.dbo.StudentDBO;
import org.sky.ssh1.alpha.ibatis.IBatisDAOSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOIbatis extends IBatisDAOSupport<StudentDAO> implements StudentDAO
{

	@Override
	public List<StudentDBO> getAllStudent() throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		try
		{
			return this.getMapper(StudentDAO.class, sqlSession).getAllStudent();
		}
		finally
		{
			this.closeSqlSession(sqlSession);
		}
	}

	@Override
	public void addStudent(String stdName) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		try
		{
			this.getMapper(StudentDAO.class, sqlSession).addStudent(stdName);
		}
		finally
		{
			this.closeSqlSession(sqlSession);
		}
	}

	@Override
	public void delStudent(String stdNo) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		try
		{
			this.getMapper(StudentDAO.class, sqlSession).delStudent(stdNo);
		}
		finally
		{
			this.closeSqlSession(sqlSession);
		}
	}

}
