package cq.spring4.ioc.setter;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSetter {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-ioc.xml");
	
		
		/**
		 * Personʵ����������Ҫ�˽�Axeʵ���ľ���ʵ�֣�
		 * ���������˽�Axe�Ĵ������̡����������е���ҪAxeʵ����ʱ��
		 * Spring������Axe ʵ����Ȼ��ע�����ҪAxeʵ���ĵ����ߡ�
		 * Personʵ�����е���ҪAxeʵ���ĵط�����Ȼ�Ͳ�����Axeʵ����
		 * ������Personʵ��ʹ�á�
		 */
		PersonImpl personImpl = (PersonImpl) applicationContext.getBean("personImpl");
		personImpl.useAxe();
		
		
		
	
	
	}
}
