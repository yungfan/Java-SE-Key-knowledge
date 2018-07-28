import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient
{
	public static void main(String[] args) throws Exception
	{
		//接收数据
		DatagramSocket socket = new DatagramSocket(7000);

		byte[] buffer = new byte[1000];

		DatagramPacket packet = new DatagramPacket(buffer, 1000);

		socket.receive(packet);

		System.out.println(new String(buffer, 0, packet.getLength()));

		//发送数据
		String str = "welcome";

		//从接收的packet中获取IP地址和端口号 
		DatagramPacket packet2 = new DatagramPacket(str.getBytes(),
				str.length(), packet.getAddress(), packet.getPort());
		
		socket.send(packet2);
		
		socket.close();
	}
}
