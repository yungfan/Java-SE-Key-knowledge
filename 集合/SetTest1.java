import java.util.HashSet;
/**
* add��������һ��booleanֵ  �������ظ���Ԫ�ػ���ô���� ��������ĸ� �ǵ�����û����ӽ�ȥ�أ��ж�һ��
*/
public class SetTest1
{
	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		
		System.out.println(set.add("a"));
		set.add("b");
		set.add("c");
		set.add("d");
		System.out.println(set.add("a"));//����false ˵��û�ӽ�ȥ
		
		System.out.println(set);	
	}
}
