/**
* 子类覆写Object类的equals方法   打破Object的equals等同于==
*/
public class EqualsTest
{
	public static void main(String[] args)
	{
		Student s1 = new Student("zhangsan");
		Student s2 = new Student("zhangsan");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));		
	}
}

class Student
{
	String name;

	public Student(String name)
	{
		this.name = name;
	}
	
        //仿照String类的源代码写
	public boolean equals(Object anObject)
	{
		if(this == anObject)
		{
			return true;
		}

		if(anObject instanceof Student)
		{
			Student student = (Student)anObject;
			
			if(student.name.equals(this.name))//调用字符串的equals方法
			{
				return true;
			}
		}

		return false;
	}

}
