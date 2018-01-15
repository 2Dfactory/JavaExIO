package TestWriterReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainFileRdWr {

	//Essai avec les objets FileWriter et FileReader
	public static void main(String[] args) {
		
		//Instanciation de l'objet fichier
		File file = new File("Files/test7.txt");
		
		//Création des flux
		FileWriter fw = null;
		FileReader fr = null;
		
		try{
			
			//Instanciation de l'objet permettant l'écriture
			fw = new FileWriter(file);
			
			//Texte à mettre dans le fichier
			String str = "Bonjour à tous amis testeux!!";
			str += "\tComment allez-vous?";
			
			//Ecriture dans le fichier texte
			fw.write(str);
			
			//Fermeture du flux
			fw.close();
			
			//Instanciation de l'objet permettant la lecture
			fr = new FileReader(file);
			
			str = "";
			int i = 0;
			
			//Lecture des données
			while((i = fr.read()) != -1){
				str += (char) i;
			}
			
			System.out.println(str);
			
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}

	}

}
