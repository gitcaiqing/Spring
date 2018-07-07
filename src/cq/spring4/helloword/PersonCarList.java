package cq.spring4.helloword;

import java.util.List;

import cq.spring4.beans.factory.Car;

public class PersonCarList {
	private String name;
	private int age;
	private List<Car> cars;
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
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "PersonCarList [name=" + name + ", age=" + age + ", cars="
				+ cars + "]";
	}
	public PersonCarList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonCarList(String name, int age, List<Car> cars) {
		super();
		this.name = name;
		this.age = age;
		this.cars = cars;
	}
	
	
}
