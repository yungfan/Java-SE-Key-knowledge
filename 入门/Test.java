/**
* �������ʵ�ָ���������ĳ��󷽷� ���� ������һ��������
*/
public class Test
{
	public static void main(String[] args)
	{
		R r = new R();
	}
}

abstract class T
{
	public abstract void method();
	
	public void test()
	{
		System.out.println("test");
	}
}

class R extends T
{
	public void method()
	{
		System.out.println("method");
	}	
}


abstract class S extends T
{
		
}
