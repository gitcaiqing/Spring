package cq.spring4.proxy.cglibproxy;

public class Target {

	public String execute() {
		System.out.println("被代理类：执行execute方法...");
		return "execute return";
	}
}
