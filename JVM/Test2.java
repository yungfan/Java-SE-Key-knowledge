/**
 * x是一个编译时的常量 final  所以调用x的时候不会对类进行初始化 不会初始化就不会执行静态代码块
 * @author 杨帆
 *
 */
class FinalTest
{
	public static final int x = 6 / 3;
	
	static
	{
		System.out.println("FinalTest static block");
	}
}

public class Test2
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest.x);
	}
}
