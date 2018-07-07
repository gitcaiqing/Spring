package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	/**
	 * 
	 * @Methodname: postProcessBeanFactory
	 * @Description: ��дBeanFactoryPostProcessor�ӿڵ�postProcessBeanFactory��������ͨ���÷�����beanFactory��������
	 * @overridden: @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 * @param: @param beanFactory
	 * @param: @throws BeansException   
	 * @throws:
	 * @CreateDate:  2018��6��6�� ����10:45:36
	 * @LastModified: 2018��6��6�� ����10:45:36
	 * @Author: CQ
	 * @UpdateAuthor: CQ
	 * @version: 1.0
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��Bean���������ڡ�����[BeanFactoryPostProcessor]�ӿڵ�postProcessBeanFactory������ͨ���÷�����beanFactory��������");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("studentBean");
		beanDefinition.getPropertyValues().addPropertyValue("age", "800");
		
	}

}
