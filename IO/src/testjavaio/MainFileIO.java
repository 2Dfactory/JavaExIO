package testjavaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainFileIO {

	public static void main(String[] args) {

		//Création des objets gérant les flux de données
		//fis ==> file input stream (flux de données en provenance d'un fichier)
		//fos ==> file output stream (flux de données en direction d'un fichier
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try{
			
			//Instanciation des flux
			fis = new FileInputStream(new File("Files/test.txt"));
			fos = new FileOutputStream(new File("Files/test2.txt"));
			
			//Taille du buffer lu à chaque boucle
			byte[] buff = new byte[8];
			
			//Variable stockant le nombre d'octets lus à chaque boucle
			// n = -1 en fin de lecture
			int n = 0;
			
			
			//On boucle tant qu'il y a des données
			while((n=fis.read(buff))>=0){
				
				//Ecriture des données dans le fichier cible
				fos.write(buff);
				
				//Ecriture dans la console des données lues selon 2 format byte et char
				for(byte bit : buff){
					System.out.print("\t"+bit+"("+ (char)bit+")");
				}
				
				System.out.println("");
				
				//Réinitialisation du buffer après chaque lecture
				buff = new byte[8];
			}
			
			System.out.println("Copie terminée !");
			
		}
		catch(FileNotFoundException f){
			
			//Exception si fichier inexistant
			f.printStackTrace();
		}
		catch(IOException io){
			
			//Exception sur erreur de lecture ou d'écriture
			io.printStackTrace();
		}
		finally {
			
			//Fermeture des flux dans un bloc finally
			try{
				if(fis != null) fis.close();
			}
			catch(IOException io){
				io.printStackTrace();
			}
			
			try{
				if(fos != null) fos.close();
			}
			catch(IOException io){
				io.printStackTrace();
			}
			
		}
		
	}

}
