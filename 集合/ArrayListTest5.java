import java.util.ArrayList;

/**
 * @author yangfan
 * 直接打印ArrayList会是什么？ 里面放的是自定义的对象打印出来又会是什么？
 * ArrayList先调用自己的toString方法 得到 [ ]  然后逐次调用里面对象的toString方法
 */

public class ArrayListTest5
{
	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();
		
		list.add(new Point(2, 3));
		list.add(new Point(2, 2));
		list.add(new Point(4, 4));
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println(list);
	}
}

