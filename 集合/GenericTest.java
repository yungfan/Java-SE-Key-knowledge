import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
* 这种方式 在定义类的时候没有用<T extends List> 而在实例化的时候用<? extends List>
*/
public class GenericTest<T>
{
	private T foo;

	public T getFoo()
	{
		return foo;
	}

	public void setFoo(T foo)
	{
		this.foo = foo;
	}
	
	public static void main(String[] args)
	{
		GenericTest<? extends List> ge = null;
		
		ge = new GenericTest<ArrayList>();
		ge = new GenericTest<LinkedList>();
		
		//ge = new GenericTest<HashMap>();//这样写是不对的
		
		GenericTest<? super List> ge2 = null;//这个对象指向List的上面 用的比较少
		
                //ge = new GenericTest<ArrayList>();//这样写是不对的
		ge2 = new GenericTest<Object>();
		
		GenericTest<String> ge3 = new GenericTest<String>();
		ge3.setFoo("hello world");
		
		GenericTest<?> ge4 = ge3;//？extends Object 与 ？等价
		
		System.out.println(ge4.getFoo());
		
		ge4.setFoo(null);
		
		System.out.println(ge4.getFoo());
		
		//ge4.setFoo("welcome");//这样是错误的 因为set进去后get出来时还需要强制转换 违背了泛型的初衷
		
	}
}
