/**
* StringBuffer是可变的  字符串拼接
*/
public class StringBufferTest
{
	public static void main(String[] args)
	{
		StringBuffer buffer = new StringBuffer();

                //append方法返回当前这个StringBuffer对象 而不是新创建的
		buffer.append("hello").append(" world").append(" welcome").append(100).append(false);
                //上面一句等于下面三句
		//buffer = buffer.append("hello");
		//buffer.append(" world");
		//buffer.append(" welcome");		

		String result = buffer.toString();

		System.out.println(result);
		
		String s = "abc";
		int a = 100;
		boolean b = true;

		String str = s + a + b;//拼接中只要有一个字符串 非字符串都转换成字符串

		System.out.println(str);

		System.out.println("-------------");

		int m = 100;
		int n = 200;

		System.out.println("100" + 200);

		System.out.println("-------------");

		System.out.println("false" + true);


	}
}
