package testjavaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFileIO3 {

	public static void main(String[] args) {

		//Création des objets gérant les flux de lecture du fichier
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try{
			
			fis = new FileInputStream(new File("Files/test3.txt"));
			fos = new FileOutputStream(new File("Files/test4.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("Files/test3.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("Files/test5.txt")));
			
			byte[] buf = new byte[8];
			
			//Initialisation du timer
			long startTime = System.currentTimeMillis();
			
			while((fis.read(buf)) != -1){
				
				fos.write(buf);
				
			}
			
			System.out.println("Temps de lecture/écriture avec FileStream : " + (System.currentTimeMillis() - startTime) + "ms");
			
			startTime = System.currentTimeMillis();
			
			while((bis.read(buf)) != -1){
				
				bos.write(buf);
				
			}
			
			System.out.println("Temps de lecture avec BufferedStream : " + (System.currentTimeMillis() - startTime) + "ms");
			
			fis.close();
			fos.close();
			bis.close();
			bos.close();
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		

	}

}
