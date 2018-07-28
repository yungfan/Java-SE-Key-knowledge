/**
* 继承体系中静态代码块与构造方法的执行顺序 注意运行结果
*/
public class StaticTest4
{
	public static void main(String[] args)
	{
		new S();
		new S();
	}
}

class P
{
	static
	{
		System.out.println("P static block");	
	}

	public P()
	{
		System.out.println("P constructor");
	}	
}

class Q extends P
{
	static
	{
		System.out.println("Q static block");
	}

	public Q()
	{
		System.out.println("Q constructor");
	}
}

class S extends Q
{
	static
	{
		System.out.println("S static block");
	}
	
	public S()
	{
		System.out.println("S constructor");
	}
}
