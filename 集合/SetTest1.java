import java.util.HashSet;
/**
* add方法返回一个boolean值  如果添加重复的元素会怎么样？ 结果还是四个 那到底有没有添加进去呢？判断一下
*/
public class SetTest1
{
	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		
		System.out.println(set.add("a"));
		set.add("b");
		set.add("c");
		set.add("d");
		System.out.println(set.add("a"));//返回false 说明没加进去
		
		System.out.println(set);	
	}
}
