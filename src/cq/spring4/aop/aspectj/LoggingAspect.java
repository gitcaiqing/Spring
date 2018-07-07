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
 * 创建日志切面 
 * 1.将该类声明为一个切面：需要将该类放入到IOC容器中@Component，再声明为一个切面@Aspect
 * 2.Order注解指定切面的优先级 值越小 优先级越高
 */
@Order(1)
@Aspect
@Component 
public class LoggingAspect {
	
	//4 个通知类似以下情况
	//1. @Before
	//2. @After
	//3. @AfterReturning
	//4. @AfterThrowing
	/*
		try {
			//1 前置通知
			System.out.println("通知");
			//2 返回通知
		} catch (Exception e) {
			e.printStackTrace();
			//3 异常通知
		}
		//4 后置通知
	 */
	
	/**
	 * 定义一个方法，用于声明切入点表达式，一般的，该方法中
	 * 再不需要添加其他代码
	 * 
	 * 使用@Pointcut 来声明切入点表达式
	 */
	@Pointcut("execution(public int cq.spring4.aop.aspectj.ArithmeticCalculator.*(..))")
	public void declareJoinPointException(){}
	
	/**
	 * 前置通知：声明该方法是一个前置通知
	 * 所有的方法
	 * @param joinPoint
	 */
	
	//@Before("execution(* cq.spring4.aop.aspectj.ArithmeticCalculator.*(..))")
	@Before("declareJoinPointException()")
	public void before(JoinPoint joinPoint){
		//1.方法名
		String methodName = joinPoint.getSignature().getName();
		//2.参数
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("前置通知-->The method: " + methodName + " ,begins with args: "+args );
	}
	/**
	 * 后置通知：再目标方法执行后 执行的通知
	 * 无论是否出现异常都执行
	 * @param joinPoint
	 */
	
	//@After("execution(* cq.spring4.aop.aspectj.*.*(..))")
	@After("declareJoinPointException()")
	public void after(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("后置通知-->The method " + methodName + "  ends");
	}
	/**
	 * 返回通知
	 * 在方法正常结束时执行的代码
	 * 可以访问到方法的返回值
	 * @param joinPoint
	 * @param result 返回结果
	 */
	//@AfterReturning(value="execution(* cq.spring4.aop.aspectj.*.*(..))",returning="result")
	@AfterReturning(value="declareJoinPointException()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("返回通知-->The method " + methodName + "  ends with "+result);
	}
	
	/**
	 * 异常通知
	 * 返回异常信息
	 * @param joinPoint 切点
	 * @param ex 异常
	 */
	//@AfterThrowing(value="execution(* cq.spring4.aop.aspectj.*.*(..))",throwing="ex")
	@AfterThrowing(value="declareJoinPointException()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,ArithmeticException ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知-->The method "+ methodName + " exception with: "+ex);
	}
	
	/**
	 * 部分异常通知
	 * 只有发生NullPointerException异常才会有通知 其他类似
	 * @param joinPoint
	 * @param ex
	 */
	/*@AfterThrowing(value="execution(* cq.spring4.aop.aspectj.*.*(..))",throwing="ex")
	public void afterThrowSomeException(JoinPoint joinPoint,NullPointerException ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知-->The method "+ methodName + " exception with: "+ex);
	}*/
	
	/**
	 * 环绕通知
	 * 需要传递的参数：ProceedingJoinPoint pJoinPoint
	 * @param pJoinPoint
	 */
	@Around("execution(* cq.spring4.aop.aspectj.*.*(..))")
	public Object arround(ProceedingJoinPoint pJoinPoint){
		
		Object result = null;
		String methodName = pJoinPoint.getSignature().getName();
		
		try {
			//1.前置通知
			System.out.println("环绕之前置通知-->The mothod "+methodName+" begins with"+Arrays.asList(pJoinPoint.getArgs()));
			//执行方法，返回对应的值
			result = pJoinPoint.proceed();
			//2.返回通知
			System.out.println("环绕之返回通知-->The mothod " + methodName + " ends with "+ result);
		} catch (Throwable e) {
			//2.异常通知
			System.out.println("环绕之异常通知-->The mothod " + methodName + " throw exception "+ e);
			throw new RuntimeException();
		}
		//2.后置通知
		System.out.println("环绕之后置通知-->The mothod " + methodName + " ends ");
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
