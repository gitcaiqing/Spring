package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class StudentBean implements BeanNameAware, BeanFactoryAware, DisposableBean{

	private String name;
	private int age;
	
	//实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
	private String beanname;
	
	private BeanFactory beanFactory;

	
	public StudentBean() {
		System.out.println("【Bean的生命周期】执行构造方法创建bean对象");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("【Bean的生命周期】bean属性注入 ");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void myinit() {
		System.out.println("【Bean的生命周期】bean初始化");
	}
	
	public void mydestory() {
		System.out.println("【Bean的生命周期】bean销毁");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanname = name;
		System.out.println("【Bean的生命周期】实现[BeanNameAware]接口 对bean设置名称:"+this.beanname);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.beanFactory = beanFactory;
		System.out.println("【Bean的生命周期】实现[BeanFactoryAware]接口 得到beanFactory引用,可获取其他bean对象" + beanFactory.getBean("myBeanPostProcessor"));
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", age=" + age + ", beanname=" + beanname + "]";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("【Bean的生命周期】调用[DisposableBean]接口的销毁方法");
	}
	
	
	
}
