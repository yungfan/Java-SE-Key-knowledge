public class DecreaseThread  extends Thread
{
	 private Sample sample;
		
		public DecreaseThread(Sample sample)
		{
			this.sample = sample;
		}
		
		@Override
		public void run()
		{
			for(int i = 0; i < 10; i++)
			{
				try
				{
					Thread.sleep((long)(Math.random() * 1000));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				sample.decrease();
			}
		}
}
