package cq.spring4.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cq.spring4.beans.factory.Car;

public class Main {
	public static void main(String[] args) {
		//HelloWord helloWord = new HelloWord();
		//helloWord.setName("caiqing");
		
		//spring方式
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取bean实例及其属性
		HelloWord helloWord = (HelloWord) ctx.getBean("helloword");
		helloWord.hello();
		
		//获取 p 命名空间的属性
		HelloWord helloWord_p = (HelloWord) ctx.getBean("helloword_p");
		helloWord_p.hello();
		
		
		Car car = (Car) ctx.getBean("car");
		System.out.println("car:"+car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println("car2:"+car2);
		
		//Person类 关联car
		Person person = (Person) ctx.getBean("person");
		System.out.println("person:"+person);
		
		//Person类拥有car的list集合
		PersonCarList personCarList = (PersonCarList)ctx.getBean("personCarList"); 
		System.out.println("personCarList:"+personCarList);
	
		//Person类拥有car的map集合
		PersonCarMap personCarMap = (PersonCarMap) ctx.getBean("personCarMap");
		System.out.println("personCarMap"+personCarMap);
	}
}
