/**
* wait和notify方法在同一个对象的synchronized方法中必须成对出现
*/
public class Sample
{
     private int number;
     
     public synchronized void increase()//是0的时候才增加1 否则不增加
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
    	 
    	 notify();//通知对方这个number不为0，你可以减了
 
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
