/**
* 线程同步问题
* 同时在同一个账号上取钱 假设有两种取钱的方式 柜台和取款机
*/
public class FetchMoney
{
       public static void main(String[] args)
	{
    	        Bank bank = new Bank();
   		
   		Thread t1 = new MoneyThread(bank); // 柜台
   		Thread t2 = new MoneyThread(bank); // 取款机
   		
   		t1.start();
   		t2.start();
	}
}

class Bank
{
	private int money = 1000;
	
	public synchronized int getMoney(int number) // 同步方法
	{
		if(number < 0)//number为要取的钱数
		{
			return -1;
		}

		else if(number > money)
		{
			return -2;
		}

		else if(money < 0)
		{
			return -3;
		}

		else
		{   // 取钱之前的处理工作
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			money -= number;
			
			System.out.println("left money: " + money);
			
			System.out.print("fetch: ");
			
			return number;
		}		
	}
}

class MoneyThread extends Thread
{
	private Bank bank;
	
	public MoneyThread(Bank bank)

	{
		this.bank = bank;
	}
	
	@Override
	public void run()

	{
		System.out.println(bank.getMoney(800));
	}
}


