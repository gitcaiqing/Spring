package cq.spring4.ioc.setter;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSetter {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-ioc.xml");
	
		
		/**
		 * Person实例不仅不需要了解Axe实例的具体实现，
		 * 甚至无须了解Axe的创建过程。程序在运行到需要Axe实例的时候，
		 * Spring创建了Axe 实例，然后注入给需要Axe实例的调用者。
		 * Person实例运行到需要Axe实例的地方，自然就产生了Axe实例，
		 * 用来供Person实例使用。
		 */
		PersonImpl personImpl = (PersonImpl) applicationContext.getBean("personImpl");
		personImpl.useAxe();
		
		
		
	
	
	}
}
