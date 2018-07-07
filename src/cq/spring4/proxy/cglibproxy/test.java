package cq.spring4.proxy.cglibproxy;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new Target();
		CglibProxy cglibProxy = new CglibProxy(target);
		Target proxy = cglibProxy.createProxy();
		proxy.execute();
	}

}
