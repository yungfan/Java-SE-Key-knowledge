/**
 * 适配器    作为一个转换器   采用继承的方式
 * @author 杨帆
 *
 */
public class Adapter extends Adaptee implements Target
{
	@Override
	public void method1()
	{
		this.method2();
	}
}
