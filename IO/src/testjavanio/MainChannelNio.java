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
			
			//Démarrage du chrono
			long time = System.currentTimeMillis();
			
			//Lecture à vide
			while(bis.read() != -1) ;
			
			//Affichage du temps écoulé
			System.out.println("Temps d'execution avec un buffer conventionnel : " 
					+ (System.currentTimeMillis() - time) + "ms");
			
			//Création d'un nouveau flux
			fis = new FileInputStream(new File("Files/test3.txt"));
			
			//Récupération du canal
			fc = fis.getChannel();
			
			//Récupération de la taille du canal
			int size = (int) fc.size();
			
			//Création d'un buffer de la taille du fichier
			ByteBuffer bf = ByteBuffer.allocate(size);
			
			//Démarrage du chrono
			time = System.currentTimeMillis();
			
			//Démarrage de la lecture
			fc.read(bf);
			
			//Préparation de la lecture via un flip
			bf.flip();
			
			//Affichage du temps d'execution
			System.out.println("Temps d'execution avec un nouveau buffer : "
					+(System.currentTimeMillis() - time) + "ms");
			
			/*
			 Puisque nous avons utiliser un buffer de byte afin de récupérer les données,
			 nous pouvons utiliser unun tableau de byte
			 La méthode array retourne un tableau de byte
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
