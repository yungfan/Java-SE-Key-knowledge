public class Environment
{
        //环境角色保持一个对抽象策略对象的引用
	private Strategy strategy;
	
	public Environment(Strategy strategy)
	{
		this.strategy = strategy;
	}

	public Strategy getStrategy()
	{
		return strategy;
	}

	public void setStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}

        //传什么就调什么  类比 TreeSet不知道具体的比较规则 传什么规则就用什么规则
	public int calculate(int a ,int b)
	{
		return strategy.calculate(a , b);
	}
}
