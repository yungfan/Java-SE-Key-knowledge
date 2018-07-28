/**
 * 深入理解深复制
 * @author 杨帆
 *
 */
public class CloneTest2
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Teacher teacher = new Teacher();

		teacher.setAge(40);
		teacher.setName("Teacher zhang");

		Student2 s1 = new Student2();

		s1.setAge(20);
		s1.setName("zhangsan");
		s1.setTeacher(teacher);

		Student2 s2 = (Student2)s1.clone();
		System.out.println(s2.getName());
		System.out.println(s2.getAge());
		
		System.out.println(s1.getTeacher().getName());
		System.out.println(s1.getTeacher().getAge());
		System.out.println(s2.getTeacher().getName());
		System.out.println(s2.getTeacher().getAge());
		
		System.out.println("--------------------");
		
		
		teacher.setName("Teacher Li");
		//改的是原来的对象中引用的那个对象的属性值   而不是复制的
		//所以s1打印的是新设置的  而s2是复制的 所以不会改变
		System.out.println(s1.getTeacher().getName());
		System.out.println(s1.getTeacher().getAge());
		System.out.println(s2.getTeacher().getName());
		System.out.println(s2.getTeacher().getAge());
	}
}

class Teacher implements Cloneable
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
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

class Student2 implements Cloneable
{
	private int age;

	private String name;

	private Teacher teacher;

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

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		Student2 s = (Student2)super.clone();
		s.setTeacher((Teacher)s.getTeacher().clone());
		return s;
	}
}
