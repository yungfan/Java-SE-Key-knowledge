/**
* ���าдObject���equals����   ����Object��equals��ͬ��==
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
	
        //����String���Դ����д
	public boolean equals(Object anObject)
	{
		if(this == anObject)
		{
			return true;
		}

		if(anObject instanceof Student)
		{
			Student student = (Student)anObject;
			
			if(student.name.equals(this.name))//�����ַ�����equals����
			{
				return true;
			}
		}

		return false;
	}

}
