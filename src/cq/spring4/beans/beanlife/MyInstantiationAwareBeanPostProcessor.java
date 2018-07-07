package cq.spring4.beans.beanlife;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��Bean���������ڡ�ʵ��[InstantiationAwareBeanPostProcessor]�ӿ�ʵ����bean֮ǰ����");
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��Bean���������ڡ�ʵ��[InstantiationAwareBeanPostProcessor]�ӿ���������ǰ����");
		return super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��Bean���������ڡ�ʵ��[InstantiationAwareBeanPostProcessor]�ӿ�ʵ����bean֮�����");
		return super.postProcessAfterInitialization(bean, beanName);
	}

}
