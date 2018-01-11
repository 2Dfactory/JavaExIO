package testjavaio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFileIO2 {

	public static void main(String[] args) {
		
		//Création des objets gérant les flux de lecture du fichier
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try{
			
			fis = new FileInputStream(new File("Files/test3.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("Files/test3.txt")));
			byte[] buf = new byte[8];
			
			//Initialisation du timer
			long startTime = System.currentTimeMillis();
			
			while((fis.read(buf)) != -1);
			
			System.out.println("Temps de lecture avec FileStream : " + (System.currentTimeMillis() - startTime) + "ms");
			
			startTime = System.currentTimeMillis();
			
			while((bis.read(buf)) != -1);
			
			System.out.println("Temps de lecture avec BufferedStream : " + (System.currentTimeMillis() - startTime) + "ms");
			
			fis.close();
			bis.close();
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		

	}

}
