/**
* 号称世界上任何Java程序员都会犯错的一个程序
*/
class Singleton
{
	private static Singleton singleton = new Singleton();
	public static int counter1;
	public static int counter2 = 0;

	private Singleton()
	{
		counter1++;
		counter2++;
	}

	public static Singleton getInstance()
	{
		return singleton;
	}
}

public class MyTest
{
	public static void main(String[] args)
	{
		Singleton singleton = Singleton.getInstance();
		System.out.println("counter1 = " + singleton.counter1);
		System.out.println("counter2 = " + singleton.counter2);
	}
}
