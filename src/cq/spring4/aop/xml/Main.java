package cq.spring4.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//获取基于配置文件的xml文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop-xml.xml");
		ArithmeticCalculator aric = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		System.out.println(aric.getClass().getName());
		
		//int result = aric.add(1, 2);
		//System.out.println("result:"+result);
		
		int result = aric.div(6, 2);
		System.out.println("div result:"+result);
	
	}
}
