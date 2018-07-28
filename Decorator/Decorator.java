/**
* 装饰角色 持有一个构建角色的引用 并实现抽象构件接口 如FilterOutputStream
*/
public class Decorator implements Component
{
	private Component component;
	
	public Decorator(Component component)
	{
		this.component = component;
	}
	
	@Override
	public void doSomething()
	{
		component.doSomething();
	}
}
