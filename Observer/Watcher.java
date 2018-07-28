/**
 * 抽象观察者角色 在收到主题的通知时，“自动”更新自己
 */
public interface Watcher
{
	public void update(String str);
}
