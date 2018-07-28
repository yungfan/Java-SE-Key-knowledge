/**
* 具体构件角色 节点流类 如FileOutputStream类
*/
public class ConcreteComponent implements Component
{
	@Override
	public void doSomething()
	{
		System.out.println("功能A");
	}

}
