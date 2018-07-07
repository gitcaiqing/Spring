package cq.spring4.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//获取基于注解的xml文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop-annotation.xml");
		ArithmeticCalculator aric = ctx.getBean(ArithmeticCalculator.class);
		int result = aric.add(3, 6);
		System.out.println("result:"+result);
		result = aric.div(5, 2);
		System.out.println("result:"+result);
	
	
	}
}
