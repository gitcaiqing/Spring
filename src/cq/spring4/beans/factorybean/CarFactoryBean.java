package cq.spring4.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 实现FactoryBean <T> bean实体类
 * @author Administrator
 *
 */
public class CarFactoryBean implements FactoryBean<Car>{
	
	private String brand;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 返回bean的对象
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car("baoma", 550000);
	}

	/**
	 * 返回bean的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}
	/**
	 * bean 是否是单实例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
