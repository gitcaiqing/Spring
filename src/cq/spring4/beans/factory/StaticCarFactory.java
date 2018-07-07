package cq.spring4.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬����������ֱ�ӵ���ĳһ����ľ�̬�����Ϳ���ֱ�ӷ���bean��ʵ��
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
	 * @Description: ͨ����̬��������ʵ�� ��Ϊ ��̬��������
	 * ��ps ���ǹ�������ģʽ��
	 * @Param: @param name
	 * @Param: @return   
	 * @Return: Car
	 * @Throws:
	 * @CreateDate:  2018��6��6�� ����2:07:44
	 * @LastModified: 2018��6��6�� ����2:07:44
	 * @Author: CQ
	 * @UpdateAuthor: CQ
	 * @version: 1.0
	 */
	public static Car getCar(String name){
		return cars.get(name);
	}

}














