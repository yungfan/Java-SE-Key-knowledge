/**
* 对象类型的数组
*/
public class ArrayTest2
{
	public static void main(String[] args)
	{
		Person[] p = new Person[3];

		p[0] = new Person(10);
		p[1] = new Person(20);
		p[2] = new Person(30);

		for(int i = 0; i < p.length; i++)
		{
			System.out.println(p[i].age);
		}

		Person[] p2 = new Person[5];

		for(int i = 0; i < p2.length; i++)
		{
			System.out.println(p2[i]);//因为对象未初始化  引用的默认值为null
		}
	}
}


class Person
{
	int age;

	public Person(int age)
	{
		this.age = age;
	}
}





