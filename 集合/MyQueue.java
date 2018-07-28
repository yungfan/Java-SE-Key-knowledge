import java.util.LinkedList;

/**
 * 队列是先进先出的一种链表 主要有三个方法
 * 
 * @author 杨帆
 * 
 */
public class MyQueue
{
	private LinkedList list = new LinkedList();

	public void put(Object o)
	{
		// 往队尾插入
		list.addLast(o);
	}

	public Object get()
	{
		//从队头取数据  
		return list.removeFirst();
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public static void main(String[] args)
	{
		MyQueue queue = new MyQueue();
		queue.put("yangfan");
		queue.put("love");
		queue.put("tingting");
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.isEmpty());
	}
}
