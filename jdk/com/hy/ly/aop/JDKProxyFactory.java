package com.hy.ly.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hy.ly.service.impl.PersonServiceBean;

public class JDKProxyFactory implements InvocationHandler {

	private Object targetObj;

	public Object createProxyInstance(Object targetObj) {
		this.targetObj = targetObj;
		return Proxy.newProxyInstance(this.targetObj.getClass().getClassLoader(),
				this.targetObj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 转换目标对象
		PersonServiceBean bean = (PersonServiceBean) this.targetObj;
		// 判断user是否为null
		Object result = null;
		if (bean.getUser() != null) {
			result = method.invoke(this.targetObj, args);
		}
		return result;
	}

}
