import java.util.LinkedList;

/**
 * �������Ƚ��ȳ���һ������ ��Ҫ����������
 * 
 * @author �
 * 
 */
public class MyQueue
{
	private LinkedList list = new LinkedList();

	public void put(Object o)
	{
		// ����β����
		list.addLast(o);
	}

	public Object get()
	{
		//�Ӷ�ͷȡ����  
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
