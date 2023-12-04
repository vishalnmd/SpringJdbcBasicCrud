package com.SpringJdbc.SpringJdbcPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.SpringJdbc.Pojo.Student;

@Configuration
@ComponentScan(basePackages = {"com.SpringJdbc.SpringJdbcPractice","com.SpringJdbc.Pojo","com.SpringJdbc.Main"} )
public class Config {
	
	@Bean("ds")
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Vishal@27");
		
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		jdbcTemplate.setDataSource(getDriverManagerDataSource());
		
		return jdbcTemplate;
	}
}
