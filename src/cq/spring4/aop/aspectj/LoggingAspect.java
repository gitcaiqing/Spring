package cq.spring4.aop.aspectj;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * ������־���� 
 * 1.����������Ϊһ�����棺��Ҫ��������뵽IOC������@Component��������Ϊһ������@Aspect
 * 2.Orderע��ָ����������ȼ� ֵԽС ���ȼ�Խ��
 */
@Order(1)
@Aspect
@Component 
public class LoggingAspect {
	
	//4 ��֪ͨ�����������
	//1. @Before
	//2. @After
	//3. @AfterReturning
	//4. @AfterThrowing
	/*
		try {
			//1 ǰ��֪ͨ
			System.out.println("֪ͨ");
			//2 ����֪ͨ
		} catch (Exception e) {
			e.printStackTrace();
			//3 �쳣֪ͨ
		}
		//4 ����֪ͨ
	 */
	
	/**
	 * ����һ�����������������������ʽ��һ��ģ��÷�����
	 * �ٲ���Ҫ�����������
	 * 
	 * ʹ��@Pointcut �������������ʽ
	 */
	@Pointcut("execution(public int cq.spring4.aop.aspectj.ArithmeticCalculator.*(..))")
	public void declareJoinPointException(){}
	
	/**
	 * ǰ��֪ͨ�������÷�����һ��ǰ��֪ͨ
	 * ���еķ���
	 * @param joinPoint
	 */
	
	//@Before("execution(* cq.spring4.aop.aspectj.ArithmeticCalculator.*(..))")
	@Before("declareJoinPointException()")
	public void before(JoinPoint joinPoint){
		//1.������
		String methodName = joinPoint.getSignature().getName();
		//2.����
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("ǰ��֪ͨ-->The method: " + methodName + " ,begins with args: "+args );
	}
	/**
	 * ����֪ͨ����Ŀ�귽��ִ�к� ִ�е�֪ͨ
	 * �����Ƿ�����쳣��ִ��
	 * @param joinPoint
	 */
	
	//@After("execution(* cq.spring4.aop.aspectj.*.*(..))")
	@After("declareJoinPointException()")
	public void after(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("����֪ͨ-->The method " + methodName + "  ends");
	}
	/**
	 * ����֪ͨ
	 * �ڷ�����������ʱִ�еĴ���
	 * ���Է��ʵ������ķ���ֵ
	 * @param joinPoint
	 * @param result ���ؽ��
	 */
	//@AfterReturning(value="execution(* cq.spring4.aop.aspectj.*.*(..))",returning="result")
	@AfterReturning(value="declareJoinPointException()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("����֪ͨ-->The method " + methodName + "  ends with "+result);
	}
	
	/**
	 * �쳣֪ͨ
	 * �����쳣��Ϣ
	 * @param joinPoint �е�
	 * @param ex �쳣
	 */
	//@AfterThrowing(value="execution(* cq.spring4.aop.aspectj.*.*(..))",throwing="ex")
	@AfterThrowing(value="declareJoinPointException()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,ArithmeticException ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("�쳣֪ͨ-->The method "+ methodName + " exception with: "+ex);
	}
	
	/**
	 * �����쳣֪ͨ
	 * ֻ�з���NullPointerException�쳣�Ż���֪ͨ ��������
	 * @param joinPoint
	 * @param ex
	 */
	/*@AfterThrowing(value="execution(* cq.spring4.aop.aspectj.*.*(..))",throwing="ex")
	public void afterThrowSomeException(JoinPoint joinPoint,NullPointerException ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("�쳣֪ͨ-->The method "+ methodName + " exception with: "+ex);
	}*/
	
	/**
	 * ����֪ͨ
	 * ��Ҫ���ݵĲ�����ProceedingJoinPoint pJoinPoint
	 * @param pJoinPoint
	 */
	@Around("execution(* cq.spring4.aop.aspectj.*.*(..))")
	public Object arround(ProceedingJoinPoint pJoinPoint){
		
		Object result = null;
		String methodName = pJoinPoint.getSignature().getName();
		
		try {
			//1.ǰ��֪ͨ
			System.out.println("����֮ǰ��֪ͨ-->The mothod "+methodName+" begins with"+Arrays.asList(pJoinPoint.getArgs()));
			//ִ�з��������ض�Ӧ��ֵ
			result = pJoinPoint.proceed();
			//2.����֪ͨ
			System.out.println("����֮����֪ͨ-->The mothod " + methodName + " ends with "+ result);
		} catch (Throwable e) {
			//2.�쳣֪ͨ
			System.out.println("����֮�쳣֪ͨ-->The mothod " + methodName + " throw exception "+ e);
			throw new RuntimeException();
		}
		//2.����֪ͨ
		System.out.println("����֮����֪ͨ-->The mothod " + methodName + " ends ");
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
