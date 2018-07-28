public class Creator
{
	public static Product createProduct(String str)
	{
		if("A".equals(str))
		{
			return new ConcreteProductA();
		}
		else if("B".equals(str))
		{
			return new ConcreteProductB();
		}
		
		return null;
	}
}
