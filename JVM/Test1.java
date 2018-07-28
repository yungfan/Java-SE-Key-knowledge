/**
 * String是使用根类加载器加载的  返回就是null(JDK帮助文档得知)
 * 自己定义的类是默认使用应用加载器加载的 也可以指定
 * @author 杨帆
 *
 */
public class Test1
{
	public static void main(String[] args) throws Exception
	{
		Class clazz = Class.forName("java.lang.String");
		
		System.out.println(clazz.getClassLoader());
		
		//记得写全名
		Class clazz2 = Class.forName("com.yangfan.classloader.C");
		
		System.out.println(clazz2.getClassLoader());
	}
}

class C
{
	
}
