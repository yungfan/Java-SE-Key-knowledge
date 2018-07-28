import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/**
* ��λ�ȡĳ���������ض���Annotation ֻ��@Retention(RetentionPolicy.RUNTIME)�ſ��Ի�ȡ
*/
public class MyReflection
{
	public static void main(String[] args) throws Exception
	{
		MyTest myTest = new MyTest();
		
		Class<MyTest> c = MyTest.class;
		
		Method method = c.getMethod("output", new Class[]{});
		
                //�ж�ĳ������ʯĳ����ĳ��ָ�����͵�ע��
		if(method.isAnnotationPresent(MyAnnotation.class))
		{
			method.invoke(myTest, new Object[]{});

			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			
			System.out.println(hello + ", " + world);
		}
		
		Annotation[] annotations = method.getAnnotations();
		
		for(Annotation annotation : annotations)
		{
			System.out.println(annotation.annotationType().getName());
		��		
	}
}
