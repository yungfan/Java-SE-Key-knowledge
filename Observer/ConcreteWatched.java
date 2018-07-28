import java.util.ArrayList;
import java.util.List;
/**
 * 把所有的观察者对象的引用保存在一个集合中
 */
public class ConcreteWatched implements Watched
{
	private List<Watcher> list = new ArrayList<Watcher>();
	
	@Override
	public void addWatcher(Watcher watcher)
	{
		list.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher)
	{
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(String str)
	{
		for(Watcher watcher : list)
		{
			watcher.update(str);
		}
	}

}
