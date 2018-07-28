/**
* 强调是给对象上锁
* 如果一个对象有若干synchronized方法，当某个时候某个线程已经进入到synchronized方法 那么该方法没有执行完毕前
* 其他线程是无法反问该对象的任何synchronized方法的
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
