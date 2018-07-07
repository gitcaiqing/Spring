package cq.spring4.beans.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("beans-factory.xml");
		
		Car car = (Car) ctx.getBean("staticCarFactory");
		System.out.println("car:"+car);
		
		Car car2 = (Car) ctx.getBean("instanceCarFactory");
		System.out.println("car2:"+car2);
		
	}
}
