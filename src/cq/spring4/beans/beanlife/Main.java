package cq.spring4.beans.beanlife;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

//1.bean��������	��	
//		1.car's constructor...
//		2.setBrand...
//		3.init...
//		Car [brand=beijing]
//		4.destory...

//2.��Ӻ��ô������� bean����������		
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
		System.out.println("��Bean���������ڡ�beanʹ�� ����bean����"+studentBean);
		ctx.close();
		
	}
}
