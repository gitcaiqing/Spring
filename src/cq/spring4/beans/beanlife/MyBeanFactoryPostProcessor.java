package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	/**
	 * 
	 * @Methodname: postProcessBeanFactory
	 * @Description: 重写BeanFactoryPostProcessor接口的postProcessBeanFactory方法，可通过该方法对beanFactory进行设置
	 * @overridden: @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 * @param: @param beanFactory
	 * @param: @throws BeansException   
	 * @throws:
	 * @CreateDate:  2018年6月6日 上午10:45:36
	 * @LastModified: 2018年6月6日 上午10:45:36
	 * @Author: CQ
	 * @UpdateAuthor: CQ
	 * @version: 1.0
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("【Bean的生命周期】调用[BeanFactoryPostProcessor]接口的postProcessBeanFactory方法可通过该方法对beanFactory进行设置");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("studentBean");
		beanDefinition.getPropertyValues().addPropertyValue("age", "800");
		
	}

}
