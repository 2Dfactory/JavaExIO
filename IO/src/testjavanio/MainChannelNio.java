package testjavanio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MainChannelNio {

	public static void main(String[] args) {
		
		FileInputStream fis;
		BufferedInputStream bis;
		FileChannel fc;
		
		try {
			
			//Instanciation des objets
			fis = new FileInputStream(new File("Files/test3.txt"));
			bis = new BufferedInputStream(fis);
			
			//D�marrage du chrono
			long time = System.currentTimeMillis();
			
			//Lecture � vide
			while(bis.read() != -1) ;
			
			//Affichage du temps �coul�
			System.out.println("Temps d'execution avec un buffer conventionnel : " 
					+ (System.currentTimeMillis() - time) + "ms");
			
			//Cr�ation d'un nouveau flux
			fis = new FileInputStream(new File("Files/test3.txt"));
			
			//R�cup�ration du canal
			fc = fis.getChannel();
			
			//R�cup�ration de la taille du canal
			int size = (int) fc.size();
			
			//Cr�ation d'un buffer de la taille du fichier
			ByteBuffer bf = ByteBuffer.allocate(size);
			
			//D�marrage du chrono
			time = System.currentTimeMillis();
			
			//D�marrage de la lecture
			fc.read(bf);
			
			//Pr�paration de la lecture via un flip
			bf.flip();
			
			//Affichage du temps d'execution
			System.out.println("Temps d'execution avec un nouveau buffer : "
					+(System.currentTimeMillis() - time) + "ms");
			
			/*
			 Puisque nous avons utiliser un buffer de byte afin de r�cup�rer les donn�es,
			 nous pouvons utiliser unun tableau de byte
			 La m�thode array retourne un tableau de byte
			 */
			byte[] tabByte = bf.array();
				
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	
	
}
