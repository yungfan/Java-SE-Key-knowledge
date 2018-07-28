/**
*一个对象 两个引用
*/
public class People1
{
	int age = 20;

	public void change(People1 people)
	{
		people.age = 30;
	}

	public static void main(String[] args)
	{
		People1 people = new People1();

		int age = people.age;

		System.out.println(age);

		people.change(people);

		int age2 = people.age;

		System.out.println(age2);
	}


}
