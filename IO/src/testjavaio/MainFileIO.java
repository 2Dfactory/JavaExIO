package testjavaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFileIO {

	public static void main(String[] args) {

		//Création des flux de données
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try{
			
			fis = new FileInputStream(new File("Files/test.txt"));
			fos = new FileOutputStream(new File("Files/test2.txt"));
			
			byte[] buff = new byte[8];
			
			int n = 0;
			
			while((n=fis.read(buff))>=0){
				
				fos.write(buff);
				
				for(byte bit : buff){
					System.out.print("\t"+bit+"("+ (char)bit+")");
				}
				
				System.out.println("");
				
				buff = new byte[8];
			}
			
			System.out.println("Copie terminée !");
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		finally {
			
		}
		
	}

}
