package com.yangfan.reflect;

import java.lang.reflect.Method;

public class ReflectTest1
{
      public static void main(String[] args) throws Exception
	{
    	        //֤���˷���ȷʵ�������ڵ�����
		Class<?> classType = Class.forName(args[0]);//Reflect��һ�����ǻ�ȡ������Ӧ��class����
		System.out.println(classType.getName());
		Method[] methods = classType.getDeclaredMethods();
		for(Method method : methods)
		System.out.println(method.getModifiers()+ " " + method.getName());
	}
}
