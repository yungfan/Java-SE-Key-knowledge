/**
* 静态方法只能继承 不能覆写
*/
public class StaticTest3
{
	public static void main(String[] args)
	{
		M m = new N();

		m.output();//取决于哪个类型的引用调用 父类型（子类型）的引用就调用父类的（子类的）方法

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
	//若在这加@Overrite就会报错  不加就是把父类的方法hidden了
	public static void output()
	{
		System.out.println("N");
	}
}







