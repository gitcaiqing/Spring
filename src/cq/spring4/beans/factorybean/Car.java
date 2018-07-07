package cq.spring4.beans.factorybean;

public class Car {
	private String brand;
	private String corp;
	private double price;
	private int maxspeed;
	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	
	
	public Car(String brand, String corp, int maxspeed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.maxspeed = maxspeed;
	}




	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}


	public Car(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	
	
}
