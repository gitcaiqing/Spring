package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;



/**
 * Bean�ĺ��ô�����
 * Bean�ĺ��ô����������ڵ��õĳ�ʼ��������ǰ���Bean���ж���Ĵ���
 * Bean���ô�������IOC�����������Bean��ʵ����һ����
 * ���bean���Ե���ȷ�Ի�����ض��ı�׼����bean������
 * @author Administrator
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
	/**
	 * bean:beanʵ������
	 * beanName:IOC�������õ�bean�����֣�<bean id="car" class="cq.spring4.beanlife.Car"��
	 * ��ʼ��ǰ
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("��Bean���������ڡ�����[BeanPostProcessor]�ӿ� ben��ʼ��֮ǰpostProcessBeforeInitialization..."+bean+"..."+beanName);
		
		/*if("car".equals(beanName)){
			System.out.println(beanName);
		}*/
		
		return bean;
	}
	/**
	 * ��ʼ����
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("��Bean���������ڡ�����[BeanPostProcessor]�ӿ� ben��ʼ��֮��postProcessAfterInitialization..."+bean+"..."+beanName);
		//Car car = new Car();
		//car.setBrand("jiangxi");
		return bean;
	}

	

}
