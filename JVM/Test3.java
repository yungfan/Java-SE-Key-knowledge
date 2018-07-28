import java.util.Random;
/**
 * 编译的时候无法确定x的值 虽然是final的 所以调用x的时候不会对类进行初始化
 * @author 杨帆
 *
 */
class FinalTest2
{
	public static final int x = new Random().nextInt(100);
	
	static
	{
		System.out.println("FinalTest2 static block");
	}
}

public class Test3
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest2.x);
	}
}
