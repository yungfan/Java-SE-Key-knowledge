/**
* 子类必须实现父类所定义的抽象方法 或者 子类是一个抽象类
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
