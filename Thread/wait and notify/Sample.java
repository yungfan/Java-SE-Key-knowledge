/**
* wait��notify������ͬһ�������synchronized�����б���ɶԳ���
*/
public class Sample
{
     private int number;
     
     public synchronized void increase()//��0��ʱ�������1 ��������
     {
    	 while(0 != number)
    	 {
    		 try
			{
				wait();
			}
		catch (InterruptedException e)
			{
				e.printStackTrace();
			}
    	 }
    	 
    	 number++;
    	 
    	 System.out.println(number);
    	 
    	 notify();//֪ͨ�Է����number��Ϊ0������Լ���
 
     }
     
     public synchronized void decrease()
     {
    	 while(0 == number)
    	 {
    		 try
			{
				wait();
			}
		 catch (InterruptedException e)
			{

				e.printStackTrace();
			}
    	 }
    	 
    	 number--;
    	 
    	 System.out.println(number);
    	 
    	 notify();
 
     }
}
