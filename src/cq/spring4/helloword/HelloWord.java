package cq.spring4.helloword;

public class HelloWord {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void hello(){
		System.out.println("hello:"+name);
	}

	public HelloWord() {
		super();
		System.out.println("constructors...");
	}
	
	
}
