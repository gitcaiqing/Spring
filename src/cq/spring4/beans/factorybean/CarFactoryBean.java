package cq.spring4.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * ʵ��FactoryBean <T> beanʵ����
 * @author Administrator
 *
 */
public class CarFactoryBean implements FactoryBean<Car>{
	
	private String brand;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * ����bean�Ķ���
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car("baoma", 550000);
	}

	/**
	 * ����bean������
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	/**
	 * bean �Ƿ��ǵ�ʵ��
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
