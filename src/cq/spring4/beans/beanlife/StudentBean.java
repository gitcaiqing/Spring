package cq.spring4.beans.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class StudentBean implements BeanNameAware, BeanFactoryAware, DisposableBean{

	private String name;
	private int age;
	
	//ʵ����BeanNameAware�ӿڣ�Spring���Խ�BeanNameע���������
	private String beanname;
	
	private BeanFactory beanFactory;

	
	public StudentBean() {
		System.out.println("��Bean���������ڡ�ִ�й��췽������bean����");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("��Bean���������ڡ�bean����ע�� ");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void myinit() {
		System.out.println("��Bean���������ڡ�bean��ʼ��");
	}
	
	public void mydestory() {
		System.out.println("��Bean���������ڡ�bean����");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanname = name;
		System.out.println("��Bean���������ڡ�ʵ��[BeanNameAware]�ӿ� ��bean��������:"+this.beanname);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.beanFactory = beanFactory;
		System.out.println("��Bean���������ڡ�ʵ��[BeanFactoryAware]�ӿ� �õ�beanFactory����,�ɻ�ȡ����bean����" + beanFactory.getBean("myBeanPostProcessor"));
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", age=" + age + ", beanname=" + beanname + "]";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��Bean���������ڡ�����[DisposableBean]�ӿڵ����ٷ���");
	}
	
	
	
}
