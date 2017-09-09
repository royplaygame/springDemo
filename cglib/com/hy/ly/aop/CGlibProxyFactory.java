package com.hy.ly.aop;

import java.lang.reflect.Method;

import com.hy.ly.service.impl.TeacherServiceBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor {

	private Object targetObj;

	public Object createProxyInstance(Object targetObj) {
		this.targetObj = targetObj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.targetObj.getClass()); // 非final修饰的方法
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 转换目标对象
		TeacherServiceBean bean = (TeacherServiceBean) this.targetObj;
		// 判断user是否为null
		Object result = null;
		if (bean.getUser() != null) {
			//方法执行前执行 advice();  --->前置通知
			try{
				result = methodProxy.invoke(this.targetObj, args);
				//方法执行后执行 afterAdvice();   --->后置通知
			}catch(Exception ex){
				//方法执行异常时执行 exceptionAdvice(); ---->例外通知
				ex.printStackTrace();
			}finally{
				//方法执行异常时执行 finallyAdvice();  ---->最终通知
			}
		}
		return result;
	}
}
