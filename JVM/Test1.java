/**
 * String��ʹ�ø�����������ص�  ���ؾ���null(JDK�����ĵ���֪)
 * �Լ����������Ĭ��ʹ��Ӧ�ü��������ص� Ҳ����ָ��
 * @author �
 *
 */
public class Test1
{
	public static void main(String[] args) throws Exception
	{
		Class clazz = Class.forName("java.lang.String");
		
		System.out.println(clazz.getClassLoader());
		
		//�ǵ�дȫ��
		Class clazz2 = Class.forName("com.yangfan.classloader.C");
		
		System.out.println(clazz2.getClassLoader());
	}
}

class C
{
	
}
