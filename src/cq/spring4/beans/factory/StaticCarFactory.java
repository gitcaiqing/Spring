package cq.spring4.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以直接返回bean的实例
 * @author Administrator
 *
 */
public class StaticCarFactory {
	
	private static Map<String,Car> cars = new HashMap<String, Car>();
	
	static{
		cars.put("aodi", new Car("aodi_f", 300000));
		cars.put("baoma", new Car("baoma_f", 500000));
	}

	/**
	 * @Methodname: getCar
	 * @Description: 通过静态方法创建实例 称为 静态工厂方法
	 * （ps 不是工厂方法模式）
	 * @Param: @param name
	 * @Param: @return   
	 * @Return: Car
	 * @Throws:
	 * @CreateDate:  2018年6月6日 下午2:07:44
	 * @LastModified: 2018年6月6日 下午2:07:44
	 * @Author: CQ
	 * @UpdateAuthor: CQ
	 * @version: 1.0
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}

}














