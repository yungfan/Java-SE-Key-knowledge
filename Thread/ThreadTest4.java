/**
* ǿ���Ǹ���������
* ���һ������������synchronized��������ĳ��ʱ��ĳ���߳��Ѿ����뵽synchronized���� ��ô�÷���û��ִ�����ǰ
* �����߳����޷����ʸö�����κ�synchronized������
*/
public class ThreadTest4
{
	public static void main(String[] args)
	{
		Example2 e = new Example2();

		TheThread3 t1 = new TheThread3(e);
		
		TheThread4 t2 = new TheThread4(e);

		t1.start();
		t2.start();
	}

}
class Example2
{


	public synchronized void execute()
	{
		
			for (int i = 0; i < 20; i++)
			{
				try
				{
					Thread.sleep((long) (Math.random() * 1000));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}

				System.out.println("hello: " + i);
			}
		

	}

	public synchronized void execute2()
	{
			for (int i = 0; i < 20; i++)
			{
				try
				{
					Thread.sleep((long) (Math.random() * 1000));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}

				System.out.println("world: " + i);
			}

		
	}
}

class TheThread3 extends Thread
{
	private Example2 example;

	public TheThread3(Example2 example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute();
	}
}

class TheThread4 extends Thread
{
	private Example2 example;

	public TheThread4(Example2 example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute2();
	}
}
