package cq.spring4.ioc.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-ioc.xml");
		PersonImpl_c personImpl_c = (PersonImpl_c) applicationContext.getBean("personImpl_c");
		System.out.println(personImpl_c);
		personImpl_c.useAxe();
	}
}
