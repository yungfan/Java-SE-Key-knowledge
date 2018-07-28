/**
* 抽象主题角色 可以添加、删除、通知观察者
*/
public interface Watched
{
	public void addWatcher(Watcher watcher);
	
	public void removeWatcher(Watcher watcher);
	
	public void notifyWatchers(String str);
}
