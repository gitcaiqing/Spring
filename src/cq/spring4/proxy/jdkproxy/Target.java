package cq.spring4.proxy.jdkproxy;

public class Target implements TargetInterf {

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		System.out.println("被代理类：执行execute方法...");
		return "execute return";
	}

}
