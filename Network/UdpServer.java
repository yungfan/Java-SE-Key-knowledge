/**
 * UDP��д�ź��񣬸�����д�ţ�����֪�����˵ĵ�ַ
 * ������ŵ����� Ȼ����
 * �ȴ����ŵ����յ��ź��֪���˷����˵ĵ�ַ
 * Ȼ��д�Żظ�
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer
{
     public static void main(String[] args) throws Exception
	{
    	        //��������
		DatagramSocket ds = new DatagramSocket();
		
		String str = "hello world";
		
		DatagramPacket packet = new DatagramPacket(str.getBytes() ,str.length() ,
				InetAddress.getByName("localhost") ,7000);
	
		ds.send(packet);
		
		//��������
		//����һ���ֽ�����
                byte[] buffer = new byte[1000];
		
		DatagramPacket packet2 = new DatagramPacket(buffer,1000);
		
		//receive��packet2���� ��packet2��װ��һ���յ��ֽ����� Ȼ����յ���������䵽��������ȥ
		ds.receive(packet2);
		
		String str2 = new String(buffer , 0 ,packet2.getLength());
		
		System.out.println(str2);
		
		ds.close();
	}
}
