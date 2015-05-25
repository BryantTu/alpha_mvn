package org.sky.ssh1.alpha.service;

import java.util.List;

import org.sky.ssh1.alpha.student.form.StudentForm;

public interface StudentService
{
	public List<StudentForm> getAllStudent() throws Exception;

	public void addStudent(String stdName) throws Exception;

	public void delStudent(String[] stdNo) throws Exception;
}
