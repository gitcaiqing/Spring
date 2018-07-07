package cq.spring4.proxy.jdkproxy;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new Target();
		JdkProxy jdkProxy = new JdkProxy(target);
		TargetInterf proxy = jdkProxy.createProxy();
		proxy.execute();
	}

}
