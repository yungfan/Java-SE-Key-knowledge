/**
 * 需要被适配的类   最终要调用的方法在这里面  但是直接又无法调用  
 * @author 杨帆
 *
 */
public class Adaptee
{
	public void method2()
	{
		System.out.println("目标方法");
	}
}
