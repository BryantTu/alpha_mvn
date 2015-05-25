package org.sky.ssh1.alpha.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.sky.ssh1.alpha.dao.BasicHibernateDAOSupport;
import org.sky.ssh1.alpha.dao.StudentDAO;
import org.sky.ssh1.alpha.dbo.StudentDBO;
import org.sky.ssh1.alpha.model.TStudent;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOHibernate extends BasicHibernateDAOSupport implements StudentDAO
{

	@Override
	public List<StudentDBO> getAllStudent() throws Exception
	{
		List<TStudent> list = this.getHibernateTemplate().find("from TStudent order by stuid desc");
		List<StudentDBO> stuList = new ArrayList<StudentDBO>();
		if(list!=null && !list.isEmpty())
		{
			for(TStudent stu : list)
			{
				StudentDBO dbo = new StudentDBO();
				dbo.setStudentNo(String.valueOf(stu.getStuid()));
				dbo.setStudentName(stu.getName());
				stuList.add(dbo);
			}
		}
		return stuList;
	}

	@Override
	public void addStudent(String stdName) throws Exception
	{
		TStudent student = new TStudent();
		student.setName(stdName);
		this.getHibernateTemplate().save(student);
	}

	@Override
	public void delStudent(String stdNo) throws Exception
	{
		TStudent student = new TStudent();
		student.setStuid(Long.parseLong(stdNo));
		this.getHibernateTemplate().delete(student);
	}
	
}

