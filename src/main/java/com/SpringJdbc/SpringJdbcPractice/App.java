package com.SpringJdbc.SpringJdbcPractice;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringJdbc.Interface.ICrud;
import com.SpringJdbc.Main.Crud;
import com.SpringJdbc.Pojo.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    	Scanner sc = new Scanner(System.in);
    	ICrud crud = context.getBean("crud",Crud.class);
    	
    	boolean exit = false;
    	int menu;
    	
    	while(!exit) {
    		System.out.println("\nPlease Select from following");
    		System.out.println("\n1. Show table data");
    		System.out.println("2. Selecte Student by id");
    		System.out.println("3. Insert a new student record");
    		System.out.println("4. Update Existing user");
    		System.out.println("5. Delete a student record");
    		System.out.println("6. To leave the menu\n");
    		
    		menu = sc.nextInt();
    		
    		if(menu ==1) {
    			List<Student> result = crud.getStudents();
    			
    			for(Student x : result) {
    				System.out.println(x);
    			}
    		}
    		
    		else if(menu==2) {
    			System.out.println("please insert id to fetch student detail\n");
    			int id = sc.nextInt();
    			
    			Student student = crud.getStudent(id);
    			System.out.println(student);
    		}
    		
    		else if(menu == 3 ) {
    			Student student = new Student();
    			
    			System.out.println("Insert Id for new Student");
    			student.setId(sc.nextInt());
    			
    			System.out.println("Insert Name of student");
    			String name = sc.next();
    			student.setName(name);
    			
    			System.out.println("Insert City of student\n");
    			String city = sc.next();
    			student.setCity(city);
    			
    			int result = crud.insert(student);
    			
    			if(result>0)
    				System.out.println("New record inserted successfully");
    		}
    		
    		else if(menu ==4) {
    			Student student = new Student();
    			
    			System.out.println("Insert Id of student");
    			student.setId(sc.nextInt());
    			
    			System.out.println("Insert updated name of student");
    			String name = sc.next();
    			student.setName(name);
    			
    			System.out.println("Insert updated City of student\n");
    			String city = sc.next();
    			student.setCity(city);
    			
    			int result = crud.update(student);
    			
    			if(result>0)
    				System.out.println("student record updated successfully");
    		}
    		
    		else if(menu == 5) {
    			System.out.println("Insert Id of student you want to delete");
    			int id = sc.nextInt();
    			
    			int result = crud.delete(id);
    			
    			if(result >0) {
    				System.out.println("Student record has been deleted");
    			}
    			
    		}
    		
    		else if(menu == 6) {
    			exit = true;
    		}
  	
    	}
    }
}
