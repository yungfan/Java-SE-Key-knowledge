import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/**
* 如何获取某个方法上特定的Annotation 只有@Retention(RetentionPolicy.RUNTIME)才可以获取
*/
public class MyReflection
{
	public static void main(String[] args) throws Exception
	{
		MyTest myTest = new MyTest();
		
		Class<MyTest> c = MyTest.class;
		
		Method method = c.getMethod("output", new Class[]{});
		
                //判断某个方法石某存在某个指定类型的注解
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
		｝		
	}
}
