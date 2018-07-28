/**
* Map的key是不能重复的 那么重复了是加不进去还是覆盖呢 答案是覆盖 这个Set不一样 注意比较SetTest1.java
*/
import java.util.HashMap;

public class MapTest1
{
	public static void main(String[] args)
	{
		HashMap map = new HashMap();
		
		map.put("a", "zhangsan");
		map.put("b", "lisi");
		map.put("c", "wangwu");
		map.put("a", "zhaoliu");
		
		//System.out.println(map);
		
		String value = (String)map.get("b");
		System.out.println(value);
		System.out.println("--------------");
		
		String value2 = (String)map.get("d");
		System.out.println(value2);
		
	}
}
