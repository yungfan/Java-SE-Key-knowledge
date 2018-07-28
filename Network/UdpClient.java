import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient
{
	public static void main(String[] args) throws Exception
	{
		//��������
		DatagramSocket socket = new DatagramSocket(7000);

		byte[] buffer = new byte[1000];

		DatagramPacket packet = new DatagramPacket(buffer, 1000);

		socket.receive(packet);

		System.out.println(new String(buffer, 0, packet.getLength()));

		//��������
		String str = "welcome";

		//�ӽ��յ�packet�л�ȡIP��ַ�Ͷ˿ں� 
		DatagramPacket packet2 = new DatagramPacket(str.getBytes(),
				str.length(), packet.getAddress(), packet.getPort());
		
		socket.send(packet2);
		
		socket.close();
	}
}
