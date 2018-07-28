public class Environment
{
        //������ɫ����һ���Գ�����Զ��������
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

        //��ʲô�͵�ʲô  ��� TreeSet��֪������ıȽϹ��� ��ʲô�������ʲô����
	public int calculate(int a ,int b)
	{
		return strategy.calculate(a , b);
	}
}
