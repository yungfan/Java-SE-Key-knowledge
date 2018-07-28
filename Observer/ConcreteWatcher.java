/**
 * 在得到主题通知时更新自己  那么主题怎么通知？当然是主题中保持了观察者的引用 然后调用观察者中的方法
 */
public class ConcreteWatcher implements Watcher
{
	@Override
	public void update(String str)
	{
		System.out.println(str);
	}

}
