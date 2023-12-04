package com.SpringJdbc.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.SpringJdbc.Pojo.Student;

@Component("rowMapper")
public class RowMapperImp implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setCity(rs.getString("city"));
		
		return student;
	}

}
