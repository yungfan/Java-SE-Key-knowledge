/**
 * UDP跟写信很像，给别人写信，首先知道别人的地址
 * 构造出信的内容 然后发送
 * 等待收信的人收到信后就知道了发信人的地址
 * 然后写信回复
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer
{
     public static void main(String[] args) throws Exception
	{
    	        //发送数据
		DatagramSocket ds = new DatagramSocket();
		
		String str = "hello world";
		
		DatagramPacket packet = new DatagramPacket(str.getBytes() ,str.length() ,
				InetAddress.getByName("localhost") ,7000);
	
		ds.send(packet);
		
		//接收数据
		//构造一个字节数组
                byte[] buffer = new byte[1000];
		
		DatagramPacket packet2 = new DatagramPacket(buffer,1000);
		
		//receive到packet2里面 而packet2封装了一个空的字节数组 然后把收到的数据填充到数组里面去
		ds.receive(packet2);
		
		String str2 = new String(buffer , 0 ,packet2.getLength());
		
		System.out.println(str2);
		
		ds.close();
	}
}
