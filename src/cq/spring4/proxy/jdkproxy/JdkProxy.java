package cq.spring4.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

	private Target target;
	
	public JdkProxy(Target target) {
		this.target = target;
	}
	
	public TargetInterf createProxy() {
		return (TargetInterf)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("execute".equals(method.getName())) {
			System.out.println("invoek:执行了execute方法");
			//调用目标对象的方法
            Object result = method.invoke(target, args);
            System.out.println("invoek:获取execute方法执行后返回值："+result);
		}else {
			System.out.println("执行了其他方法");
		}
		return method.invoke(target,args);
	}

}
