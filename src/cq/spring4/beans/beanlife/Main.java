package cq.spring4.beans.beanlife;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

//1.bean生命周期	：	
//		1.car's constructor...
//		2.setBrand...
//		3.init...
//		Car [brand=beijing]
//		4.destory...

//2.添加后置处理器的 bean的生命周期		
//		car's constructor...
//		setBrand...
//		postProcessBeforeInitialization...
//		init...
//		postProcessAfterInitialization...
//		Car [brand=beijing]
//		destory...
/*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		ctx.close();
		
		Class*/
		ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("beans-cycle.xml");
		StudentBean studentBean = (StudentBean) ctx.getBean("studentBean");
		System.out.println("【Bean的生命周期】bean使用 调用bean对象："+studentBean);
		ctx.close();
		
	}
}
