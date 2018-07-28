import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client
{
	public static void main(String[] args)
	{
		RealSubject realSubject = new RealSubject();

		InvocationHandler handler = new DynamicSubject(realSubject);

		Class<?> classType = handler.getClass();

		// 下面的代码一次性生成代理
                // newProxyInstance()动态生成一个类并加载到内存 不然不能使用
                // 加载到内存要使用加载器 所以第一个参数是一个类加载器
		Subject subject = (Subject) Proxy.newProxyInstance(classType
				.getClassLoader(), realSubject.getClass().getInterfaces(),
				handler);

		subject.request();

		System.out.println(subject.getClass());

	}

}
