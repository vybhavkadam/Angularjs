/*package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UsersDao;
import com.niit.model.Users;

public class Test {
	
	public static void main(String[] args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		Users users= (Users) context.getBean("users");
		UsersDao usersDao= (UsersDao) context.getBean("usersDao");
		
		users.setId(1);
 		users.setName("Anchith");
 		users.setMobile("98454367281");
 		users.setPassword("123");
 		//users.setRole("USER_ROLE");
 		
 		usersDao.registerUser(users);
 
 		
	}


}
*/