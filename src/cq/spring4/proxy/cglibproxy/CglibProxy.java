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

	//����������
	public Target createProxy() {
		// 1.������ǿ��ʵ��,��������������
		Enhancer enhancer = new Enhancer();
		// 2.���ñ��������ֽ��룬CGLIB�����ֽ������ɱ������������
		enhancer.setSuperclass(target.getClass());
		// 3.���ûص���������һ����������
		enhancer.setCallback(this);
		// 4.��������:
		return (Target) enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("execute".equals(method.getName())) {
			System.out.println("invoek:ִ����execute����");
			//����Ŀ�����ķ���(ִ��Target���󼴱���������execute����)
	        Object result = methodProxy.invokeSuper(proxy, args);
            System.out.println("invoek:��ȡexecute����ִ�к󷵻�ֵ��"+result);
		}else {
			System.out.println("ִ������������");
		}
		return null;
	}

}
