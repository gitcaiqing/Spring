package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;



/**
 * Bean的后置处理器
 * Bean的后置处理器允许在调用的初始化方法的前后对Bean进行额外的处理
 * Bean后置处理器对IOC容器里的所有Bean的实例逐一处理
 * 检查bean属性的正确性或根据特定的标准更改bean的属性
 * @author Administrator
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
	/**
	 * bean:bean实例本身
	 * beanName:IOC容器配置的bean的名字（<bean id="car" class="cq.spring4.beanlife.Car"）
	 * 初始化前
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("【Bean的生命周期】调用[BeanPostProcessor]接口 ben初始化之前postProcessBeforeInitialization..."+bean+"..."+beanName);
		
		/*if("car".equals(beanName)){
			System.out.println(beanName);
		}*/
		
		return bean;
	}
	/**
	 * 初始化后
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("【Bean的生命周期】调用[BeanPostProcessor]接口 ben初始化之后postProcessAfterInitialization..."+bean+"..."+beanName);
		//Car car = new Car();
		//car.setBrand("jiangxi");
		return bean;
	}

	

}
