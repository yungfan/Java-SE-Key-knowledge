import java.util.ArrayList;

/**
 * @author yangfan
 * ֱ�Ӵ�ӡArrayList����ʲô�� ����ŵ����Զ���Ķ����ӡ�����ֻ���ʲô��
 * ArrayList�ȵ����Լ���toString���� �õ� [ ]  Ȼ����ε�����������toString����
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

