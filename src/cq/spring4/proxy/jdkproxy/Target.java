package cq.spring4.proxy.jdkproxy;

public class Target implements TargetInterf {

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		System.out.println("�������ִࣺ��execute����...");
		return "execute return";
	}

}
