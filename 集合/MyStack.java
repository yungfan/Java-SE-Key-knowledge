import java.util.LinkedList;

/**
 * ջ�Ǻ���ȳ���һ������ ��Ҫ���ĸ�����
 * 
 * @author �
 * 
 */
public class MyStack
{
	private LinkedList list = new LinkedList();

	public void put(Object o)
	{
		//���
		list.addLast(o);
	}

    
	public Object pop()
	{
		//�ȳ�
		return list.removeLast();
	}

	// �鿴 ����������
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
