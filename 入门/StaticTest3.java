/**
* ��̬����ֻ�ܼ̳� ���ܸ�д
*/
public class StaticTest3
{
	public static void main(String[] args)
	{
		M m = new N();

		m.output();//ȡ�����ĸ����͵����õ��� �����ͣ������ͣ������þ͵��ø���ģ�����ģ�����

                System.out.println("----------------");

		N n = new N();

		n.output();
	}
}

class M
{
	public static void output()
	{
		System.out.println("M");
	}
}

class N extends M
{
	//�������@Overrite�ͻᱨ��  ���Ӿ��ǰѸ���ķ���hidden��
	public static void output()
	{
		System.out.println("N");
	}
}







