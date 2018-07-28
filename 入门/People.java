/**
* 两个对象 两个引用
*/
public class People
{
	int age = 20;

	public void change(People people)
	{
		people = new People();
		
		people.age = 30;
	}

	public static void main(String[] args)
	{
		People people = new People();

		int age = people.age;

		System.out.println(age);

		people.change(people);

		int age2 = people.age;

		System.out.println(age2);
	}


}
