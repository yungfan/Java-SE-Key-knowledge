package com.yangfan.test;

import com.yangfan.C;
/**
*protected���Ա�����̳����� ��������ڲ�ʹ��
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
//����д�ǲ��Ե� ���ڲ�ʹ�ò���new������Ķ���Ȼ�����
public class D extends C
{
	public static void main(String[] args)
	{
		C c = new C();
		System.out.println(c.year);
	}
}
*/