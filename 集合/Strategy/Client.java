//�ͻ��˱���֪�����еĲ����� ��Ҳ��ȱ��֮һ
public class Client
{
	public static void main(String[] args)
	{

		AddStrategy addStrategy = new AddStrategy();

		Environment environment = new Environment(addStrategy);

		System.out.println(environment.calculate(3, 4));

		SubtractStrategy subtractStrategy = new SubtractStrategy();

		environment.setStrategy(subtractStrategy);

                //���õ�ʱ����ȫһ�� ����������� �����ȫȡ���ھ��ߵ�����
                //��� ��TreeSet����Ӷ���ʱ��ȫ��֪���ײ�����ô����� ���ȡ�������Ǵ��ݵ��������
		System.out.println(environment.calculate(3, 4));

		MultiplyStrategy multiplyStrategy = new MultiplyStrategy();

		environment.setStrategy(multiplyStrategy);

		System.out.println(environment.calculate(3, 4));

		DivideStrategy divideStrategy = new DivideStrategy();

		environment.setStrategy(divideStrategy);

		System.out.println(environment.calculate(3, 4));

	}
}
