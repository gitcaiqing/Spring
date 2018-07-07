package cq.spring4.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cq.spring4.beans.annotation.controller.UserController;
import cq.spring4.beans.annotation.repository.UserRepositoryImpl;
import cq.spring4.beans.annotation.service.UserService;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
	
		/*TestObject testObject = (TestObject) ctx.getBean("testObject");
		System.out.println("testObject:"+testObject);
		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println("userController:"+userController);
		*/
		//UserRepositoryImpl userRepositoryImpl = (UserRepositoryImpl) ctx.getBean("userRepositoryImpl");
		//System.out.println("userRepositoryImpl:"+userRepositoryImpl);
		
		UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
		System.out.println("userRepository:"+userRepository);
		
		UserService userService = (UserService) ctx.getBean("userService");
		System.out.println("userService:"+userService);
	}
}
