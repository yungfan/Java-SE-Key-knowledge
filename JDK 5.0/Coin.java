/**
* ö�ٵĳ�Ա ��ʵ���Ƕ����ö�����͵�ʵ�� ���಻ͬ ������Ҫnew �ٱ����ڼ��ȷ�������е�ʵ��
*/
public enum Coin
{
    penny(0),nickle(1),dime(2),quarter(3);//��Щ����Coin���͵Ķ���
    
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
		Coin co = Coin.quarter;//��ԱĬ����static�� ����ֱ�ӡ��ࡱ������

		System.out.println(co.getValue());
	}
}
