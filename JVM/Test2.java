/**
 * x��һ������ʱ�ĳ��� final  ���Ե���x��ʱ�򲻻������г�ʼ�� �����ʼ���Ͳ���ִ�о�̬�����
 * @author �
 *
 */
class FinalTest
{
	public static final int x = 6 / 3;
	
	static
	{
		System.out.println("FinalTest static block");
	}
}

public class Test2
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest.x);
	}
}
