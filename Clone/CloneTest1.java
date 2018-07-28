/**
* ¼òµ¥µÄÇ³¸´ÖÆ
*/
public class CloneTest1
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		 Student s = new Student();
		 
		 s.setName("zhangsan");
		 s.setAge(20);
		 
		 Student s2 = (Student)s.clone();
		 
		 System.out.println(s2.getName() + ":" + s2.getAge());
	     
		 System.out.println("---------------------");
	
		 s2.setName("lisi");
		 s2.setAge(30);
		 
		 System.out.println(s.getName() + ":" + s.getAge());
		 System.out.println(s2.getName() + ":" + s2.getAge());
	}
    
     
}

class Student implements Cloneable
{
	private int age;

	private String name;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public  Object clone() throws CloneNotSupportedException
	{
		return super.clone();	
	}
}