package test.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainFileIO4 {

	public static void main(String[] args) {
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try{
			
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Files/test6.txt"))));
			
			dos.writeBoolean(true);
			dos.writeByte(100);
			dos.writeChar('c');
			dos.writeDouble(12.5);
			dos.writeFloat(100.52f);
			dos.writeInt(1024);
			dos.writeLong(123456789654321L);
			dos.writeShort(2);
			dos.close();
			
			
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("Files/test6.txt"))));
			
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
			dis.close();
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		
		
		

	}

}
