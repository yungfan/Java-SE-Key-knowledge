//客户端必须知道所有的策略类 这也是缺点之一
public class Client
{
	public static void main(String[] args)
	{

		AddStrategy addStrategy = new AddStrategy();

		Environment environment = new Environment(addStrategy);

		System.out.println(environment.calculate(3, 4));

		SubtractStrategy subtractStrategy = new SubtractStrategy();

		environment.setStrategy(subtractStrategy);

                //调用的时候完全一样 看不出来差别 结果完全取决于决策的类型
                //类比 往TreeSet里添加对象时完全不知道底层是怎么排序的 结果取决于我们传递的排序规则
		System.out.println(environment.calculate(3, 4));

		MultiplyStrategy multiplyStrategy = new MultiplyStrategy();

		environment.setStrategy(multiplyStrategy);

		System.out.println(environment.calculate(3, 4));

		DivideStrategy divideStrategy = new DivideStrategy();

		environment.setStrategy(divideStrategy);

		System.out.println(environment.calculate(3, 4));

	}
}
