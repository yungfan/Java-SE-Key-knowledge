import java.util.ArrayList;
import java.util.List;
/**
 * 在junit框架中   相当于TestSuite 可以组合多个TestCase
 * @author 杨帆
 *
 */
public class Composite implements Component
{
	private List<Component> list = new ArrayList<Component>();
	
	public void add(Component component)
	{
		list.add(component);
	}
	
	public void remove(Component component)
	{
		list.remove(component);
	}
	
	public List<Component> getAll()
	{
		return this.list;
	}
	
	@Override
	public void doSomething()
	{
		for(Component component : list)
		{
			component.doSomething();
		}
	}
}
