/**
* Object���toString���� It is recommended that all subclasses override this method. 
* this method returns a string equal to the value of: 
* getClass().getName() + '@' + Integer.toHexString(hashCode())ʮ������
*/
public class ObjectTest
{
	public static void main(String[] args)
	{
		Object object = new Object();

		System.out.println(object);
		System.out.println(object.toString());

		String str = "aaa";
                
                //�Ӵ�ӡ������� String��ض���д��Object���toString���� 
		System.out.println(str);
		System.out.println(str.toString());

		Student student = new Student();

		System.out.println(student);
		System.out.println(student.toString());

	}
}

class Student extends Object
{
	public String toString()
	{
		return "Hello World";
	}
}


