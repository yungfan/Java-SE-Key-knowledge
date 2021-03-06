/**
* 单例模式多线程版
*/
public class Singleton
{
	private static Singleton singleton;
	
	private Singleton()
	{

	}

	public static Singleton getInstance()
	{
		if (null == singleton)
		{
			try
			{
				Thread.sleep((long) (Math.random() * 4000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			singleton = new Singleton();
		}

		return singleton;
	}

	public static void main(String[] args)
	{
                //查看地址是否一样以判断是不是同一个对象
		new MyThread().start();
		new MyThread().start();

	}

}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println(Singleton.getInstance());
	}
}


























