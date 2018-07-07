package cq.spring4.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cq.spring4.beans.factory.Car;

public class Main {
	public static void main(String[] args) {
		//HelloWord helloWord = new HelloWord();
		//helloWord.setName("caiqing");
		
		//spring��ʽ
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//��ȡbeanʵ����������
		HelloWord helloWord = (HelloWord) ctx.getBean("helloword");
		helloWord.hello();
		
		//��ȡ p �����ռ������
		HelloWord helloWord_p = (HelloWord) ctx.getBean("helloword_p");
		helloWord_p.hello();
		
		
		Car car = (Car) ctx.getBean("car");
		System.out.println("car:"+car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println("car2:"+car2);
		
		//Person�� ����car
		Person person = (Person) ctx.getBean("person");
		System.out.println("person:"+person);
		
		//Person��ӵ��car��list����
		PersonCarList personCarList = (PersonCarList)ctx.getBean("personCarList"); 
		System.out.println("personCarList:"+personCarList);
	
		//Person��ӵ��car��map����
		PersonCarMap personCarMap = (PersonCarMap) ctx.getBean("personCarMap");
		System.out.println("personCarMap"+personCarMap);
	}
}
