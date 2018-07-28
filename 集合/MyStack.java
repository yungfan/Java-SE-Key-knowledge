import java.util.LinkedList;

/**
 * 栈是后进先出的一种链表 主要有四个方法
 * 
 * @author 杨帆
 * 
 */
public class MyStack
{
	private LinkedList list = new LinkedList();

	public void put(Object o)
	{
		//后进
		list.addLast(o);
	}

    
	public Object pop()
	{
		//先出
		return list.removeLast();
	}

	// 查看 并不弹出来
	public Object peek()
	{
		return list.getLast();
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public static void main(String[] args)
	{
		MyStack stack = new MyStack();
		stack.put("yangfan");
		stack.put("love");
		stack.put("tingting");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());

	}

}
