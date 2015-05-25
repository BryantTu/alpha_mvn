package org.sky.ssh1.alpha.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.sky.ssh1.alpha.dao.StudentDAO;
import org.sky.ssh1.alpha.dbo.StudentDBO;
import org.sky.ssh1.alpha.service.StudentService;
import org.sky.ssh1.alpha.student.form.StudentForm;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
//	private Log logger = LogFactory.getLog(this.getClass());

	@Resource(name="studentDAOHibernate")
	private StudentDAO studentDAO;

	@Override
	public List<StudentForm> getAllStudent() throws Exception
	{
		List<StudentDBO> stdList = new ArrayList<StudentDBO>();
		List<StudentForm> rtnList = new ArrayList<StudentForm>();
		stdList = studentDAO.getAllStudent();
		for (StudentDBO dbo : stdList)
		{
			StudentForm stdForm = new StudentForm();
			BeanUtils.copyProperties(stdForm, dbo);
			rtnList.add(stdForm);
		}
		return rtnList;
	}

	public void addStudent(String stdName) throws Exception
	{
		studentDAO.addStudent(stdName);
	}

	public void delStudent(String[] stdNo) throws Exception
	{
		for (String s : stdNo)
		{
			studentDAO.delStudent(s);
		}
	}
}
