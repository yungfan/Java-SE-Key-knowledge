/**
* 枚举的成员 其实质是定义的枚举类型的实例 和类不同 它不需要new 再编译期间就确定了所有的实例
*/
public enum Coin
{
    penny(0),nickle(1),dime(2),quarter(3);//这些都是Coin类型的对象
    
    private int  in;
    
    public int getValue()
    {
    	return in ;
    }

    Coin(int in)
    {
    	this.in = in;
    }

    public static void main(String[] args)
	{
		Coin co = Coin.quarter;//成员默认是static的 所以直接“类”名调用

		System.out.println(co.getValue());
	}
}
