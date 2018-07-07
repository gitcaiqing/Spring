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
			System.out.println("invoek:ִ����execute����");
			//����Ŀ�����ķ���
            Object result = method.invoke(target, args);
            System.out.println("invoek:��ȡexecute����ִ�к󷵻�ֵ��"+result);
		}else {
			System.out.println("ִ������������");
		}
		return method.invoke(target,args);
	}

}
