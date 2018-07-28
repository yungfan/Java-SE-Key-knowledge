public class Client
{
	public static void main(String[] args)
	{
		Product productA = Creator.createProduct("A");
		
		System.out.println(productA.getClass().getName());
		
		Product productB = Creator.createProduct("B");
		
		System.out.println(productB.getClass().getName());
	}
}
