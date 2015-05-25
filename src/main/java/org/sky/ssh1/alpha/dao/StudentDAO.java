package org.sky.ssh1.alpha.dao;

import java.util.List;

import org.sky.ssh1.alpha.dbo.StudentDBO;

public interface StudentDAO {

	public List<StudentDBO> getAllStudent() throws Exception;

	public void addStudent(String stdName) throws Exception;

	public void delStudent(String stdNo) throws Exception;
}
