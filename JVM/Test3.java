import java.util.Random;
/**
 * �����ʱ���޷�ȷ��x��ֵ ��Ȼ��final�� ���Ե���x��ʱ�򲻻������г�ʼ��
 * @author �
 *
 */
class FinalTest2
{
	public static final int x = new Random().nextInt(100);
	
	static
	{
		System.out.println("FinalTest2 static block");
	}
}

public class Test3
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest2.x);
	}
}
