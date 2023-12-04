package com.SpringJdbc.Interface;

import java.util.List;

import com.SpringJdbc.Pojo.Student;

public interface ICrud {
	
	public int insert(Student student);
	public int update(Student student);
	public int delete(int id);
	public Student getStudent(int id);
	public List<Student> getStudents();
}
