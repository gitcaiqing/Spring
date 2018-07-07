package cq.spring4.aop.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	
	
	public void before(JoinPoint joinPoint){
		//1.������
		String methodName = joinPoint.getSignature().getName();
		System.out.println("methodName: "+methodName);
		//2.����
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("���������ļ���aop��ǰ��֪ͨ-->The method: " + methodName + " ,begins with args: "+args );
		
	}
	
	public void after(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("���������ļ���aop������֪ͨ-->The method: " + methodName + " ends");
	}
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("���������ļ���aop������֪ͨ-->The method: "+methodName+" ends with: "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("���������ļ���aop���쳣֪ͨ-->The method: "+methodName+" throwing with: "+ex);
	}
}
