package com.hy.ly.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 切面
 * @author ssr
 *
 */
@Aspect
public class MyInterceptor {
	
	@Pointcut("execution(* com.hy.ly.service.impl.CustomerServiceImpl.*(..))")
	private void anyMethod(){}  //声明一个切入点
	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name){
		System.out.println("前置通知: "+ name);
	}
	
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result){
		System.out.println("后置通知: "+result);
	}
	
	@AfterThrowing(pointcut="anyMethod()",throwing="ex")
	public void doAfterThrowing(Exception ex){
		System.out.println("例外通知: "+ex);
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("进入方法");
		Object obj= pjp.proceed();
		System.out.println("退出方法");
		return obj;
	}
}
