/**
 * 只有当访问的静态变量或者方法确实在当前类或者接口中定义时，才可以认为是对当前类或接口的主动使用
 * a并不是说定义在Child3中  所以访问它并不会初始化Child3 只会初试化Parent3
 * @author 杨帆
 *
 */
class Parent3
{
	static int a = 3;
	
	static
	{
		System.out.println("Parent3 static block");
	}
	
	static void doSomething()
	{
		System.out.println("do something");
	}
}

class Child3 extends Parent3
{
	static
	{
		System.out.println("Child3 static block");
	}
}

public class Test6
{
	public static void main(String[] args)
	{
		System.out.println(Child3.a);
		
		Child3.doSomething();
	}
}






















