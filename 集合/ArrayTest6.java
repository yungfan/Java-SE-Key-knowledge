/**
* 接口类型的数组
*/
public class ArrayTest6
{
	public static void main(String[] args)
	{
		I[] i = new I[2];
		
		i[0] = new C();
		i[1] = new C();
                //这种形式也可以
		I[] b = new I[]{new C(), new C()};
		
	}
}

interface I
{

}

class C implements I
{

}
