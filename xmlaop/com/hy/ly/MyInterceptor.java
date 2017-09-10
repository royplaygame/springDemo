package com.hy.ly;

import org.aspectj.lang.ProceedingJoinPoint;
/**
 * 切面
 * @author ssr
 *
 */
public class MyInterceptor {
	
	
	
	public void doAccessCheck(){
		System.out.println("前置通知: ");
	}
	
	public void doAfterReturning(){
		System.out.println("后置通知: ");
	}
	
	public void doAfterThrowing(){
		System.out.println("例外通知: ");
	}
	
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("进入方法");
		Object obj= pjp.proceed();
		System.out.println("退出方法");
		return obj;
	}
}
