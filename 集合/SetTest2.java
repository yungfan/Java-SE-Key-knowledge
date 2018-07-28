import java.util.HashSet;
/**
*  三个例子 说明一个问题 set的add方法很特殊
*/
public class SetTest2
{
	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		
		set.add(new People("zhangsan"));
		set.add(new People("lisi"));
		set.add(new People("zhangsan"));//三句话后返回的是三个		
               /*
		People p1 = new People("zhangsan");
		
		set.add(p1);
		set.add(p1);
		*/
                
                /*
		String s1 = new String("a");
		String s2 = new String("a");
		
		set.add(s1);
		set.add(s2); //其实只添加一个 为什么？嘿嘿 hash code一样 因为String覆写了Object的                                         //hashCode()计算的方法和内容有关而与地址无关  然后equals()也返回true
		*/

		System.out.println(set);
	}
}

class People
{
	String name;

	public People(String name)
	{
		this.name = name;		
	}

}
