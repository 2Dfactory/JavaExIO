package test.java.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFile {

	public static void main(String[] args) {

		//Récupération des informations sur un fichier avec l'interface Path et la class Files
		Path path = Paths.get("Files/test.txt");
		System.out.println("Chemin absolut du fichier : "+ path.toAbsolutePath());
		System.out.println("Nom du fichier : "+ path.getFileName());
		System.out.println("Est-ce qu'il existe ? "+ Files.exists(path));
		System.out.println("Est-ce un répertoire ? "+ Files.isDirectory(path));
		
		System.out.println("Affichage des lecteurs à la racine du PC : \n");
		
		/*
		 * Récupération de la liste des répertoires dans une collection typée via l'objet FileSystem
		 * qui représente le système de fichier de l'OS hébergeant la JVM
		 */
		Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		
		//Parcours de la collection typée
		for(Path chemin : roots) {
			
			System.out.println(chemin);
			
			/*
			 * Pour lister un répertoire il faut utiliser l'objet DirectoryStream.
			 * L'objet Files permet de créer ce type d'objet afin de pouvoir l'utiliser
			 */
			try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin)){
			
			//Ajout d'un filtre au listing de répertoire :
			//try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin, "*.txt")){

				int i = 0;
				for(Path nom : listing) {
					
					System.out.println("\t\t" + ((Files.isDirectory(nom)) ? nom + "/" : nom));
					i++;
					if(i%4 == 0) System.out.println("\n");
					
				}
				
			}
			catch(IOException io) {
				io.printStackTrace();
			}
			
			
		}
			
	}
}


