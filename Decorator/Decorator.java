/**
* װ�ν�ɫ ����һ��������ɫ������ ��ʵ�ֳ��󹹼��ӿ� ��FilterOutputStream
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
