package cq.spring4.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Target target;
	
	public CglibProxy(Target target) {
		// TODO Auto-generated constructor stub
		super();
		this.target = target;
	}

	//创建代理类
	public Target createProxy() {
		// 1.声明增强类实例,用于生产代理类
		Enhancer enhancer = new Enhancer();
		// 2.设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
		enhancer.setSuperclass(target.getClass());
		// 3.设置回调函数，即一个方法拦截
		enhancer.setCallback(this);
		// 4.创建代理:
		return (Target) enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("execute".equals(method.getName())) {
			System.out.println("invoek:执行了execute方法");
			//调用目标对象的方法(执行Target对象即被代理对象的execute方法)
	        Object result = methodProxy.invokeSuper(proxy, args);
            System.out.println("invoek:获取execute方法执行后返回值："+result);
		}else {
			System.out.println("执行了其他方法");
		}
		return null;
	}

}
