package com.SpringJdbc.Main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.SpringJdbc.Interface.ICrud;
import com.SpringJdbc.Pojo.Student;

@Component("crud")
public class Crud implements ICrud{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RowMapperImp rowMapper;
	
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return result;
	}

	public int update(Student student) {
		String query = "update student set name=?,city =? where id=?";
		int result = jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}
	
	public int delete(int id) {
		String query = "delete from student where id =?";
		int result = jdbcTemplate.update(query,id);
		return result;
	}
	
	public Student getStudent(int id) {
		
		String query = "select * from student where id= ?";
		Student student = new Student();
		student = jdbcTemplate.queryForObject(query, rowMapper,id);
		return student;
	}
	
	
	public List<Student> getStudents() {
		String query = "select * from student";
		
		List<Student> result = jdbcTemplate.query(query, rowMapper);
		return result; 
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public RowMapperImp getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapperImp rowMapper) {
		this.rowMapper = rowMapper;
	}

}
