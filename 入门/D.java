package com.yangfan.test;

import com.yangfan.C;
/**
*protected可以被子类继承下来 在子类的内部使用
*/
public class D extends C
{
	public void output()
	{
		System.out.println(year);
	}

	public static void main(String[] args)
	{
		D d = new D();
		d.output();
	}
}

/*
//这样写是不对的 在内部使用不是new出父类的对象然后调用
public class D extends C
{
	public static void main(String[] args)
	{
		C c = new C();
		System.out.println(c.year);
	}
}
*/