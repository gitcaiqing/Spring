package cq.spring4.helloword;

import java.util.Map;

import cq.spring4.beans.factory.Car;

public class PersonCarMap {
	private String name;
	private int age;
	private Map<String,Car> cars;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, Car> getCars() {
		return cars;
	}
	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}
	public PersonCarMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonCarMap(String name, int age, Map<String, Car> cars) {
		super();
		this.name = name;
		this.age = age;
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "PersonCarMap [name=" + name + ", age=" + age + ", cars=" + cars
				+ "]";
	}
	
	
}
