package com.yangfan.reflect;

import java.lang.reflect.Method;

public class ReflectTest1
{
      public static void main(String[] args) throws Exception
	{
    	        //证明了反射确实是运行期的事情
		Class<?> classType = Class.forName(args[0]);//Reflect第一步都是获取类所对应的class对象
		System.out.println(classType.getName());
		Method[] methods = classType.getDeclaredMethods();
		for(Method method : methods)
		System.out.println(method.getModifiers()+ " " + method.getName());
	}
}
