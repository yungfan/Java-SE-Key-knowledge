import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamTest
{
     public static void main(String[] args) throws Exception
	{
		DataOutputStream dos = new DataOutputStream(new 
		BufferedOutputStream(new FileOutputStream("c:/list.txt")));
		byte b = 3;
		int  i = 12;
		char ch = 'c';
		float f = 3.14159f;
		
		dos.writeByte(b);
		dos.writeInt(i);
		dos.writeChar(ch);
		dos.writeFloat(f);
	    
		dos.close();
		
		DataInputStream dis = new DataInputStream(new 
		BufferedInputStream(new FileInputStream("c:/list.txt")));
		//读和写的顺序要保持严格的一致
		System.out.println(dis.readByte());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readFloat());
		
		dis.close();
	}
}
