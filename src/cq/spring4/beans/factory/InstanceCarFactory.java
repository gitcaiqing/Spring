package cq.spring4.beans.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
	
	Map<String, Car> cars = null;

	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("aodi", new Car("aodi_I", 3000000));
		cars.put("baoma", new Car("baoma_I",6000000));
	}
	
	public Car getCar(String name){
		return cars.get(name);
	}
	
}
