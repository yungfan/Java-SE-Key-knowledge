/**
* 读和写的对象都是来自Socket 所以要传入服务器端Socket
*/
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerInputThread extends Thread
{
	private Socket socket;
	
	public ServerInputThread(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run()
	{
		try
		{
			InputStream is = socket.getInputStream();
			
			while(true)//不能读一个啊 要一直可以读  就用一个死循环
			{
				byte[] buffer = new byte[1024];
				
				int length = is.read(buffer);
				
				String str = new String(buffer, 0, length);
				
				System.out.println(str);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
