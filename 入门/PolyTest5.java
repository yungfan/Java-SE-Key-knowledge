/**
* 写一个方法 可以实现多个情况
*/
public class PolyTest5
{

	public void run(Car car)
	{
		car.run();
	}

	public static void main(String[] args)
	{
		
		PolyTest5 test = new PolyTest5();

		Car bmw = new BMW();

		test.run(bmw);
		
		Car qq = new QQ();

		test.run(qq);

	}
}

class Car
{
	public void run()
	{
		System.out.println("car is running");
	}
}

class BMW extends Car
{
	public void run()
	{
		System.out.println("BMW is running");
	}
}

class QQ extends Car
{
	public void run()
	{
		System.out.println("QQ is running");
	}
}


