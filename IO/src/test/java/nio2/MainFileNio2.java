package test.java.nio2;

import java.io.File;

public class MainFileNio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("Files/test.txt");
		System.out.println("Chemin absolut du fichier : "+f.getAbsolutePath());
		System.out.println("Nom du fichier : "+f.getName());
		System.out.println("Est-ce qu'il existe ? "+f.exists());
		System.out.println("Est-ce un répertoire ? "+f.isDirectory());
		System.out.println("Est-ce un fichier ? "+f.isFile());
		
		System.out.println("Affichage des lecteurs à la racine du PC : \n");
		
		for (File file : f.listRoots()){
			
			System.out.println(file.getAbsolutePath());
			
			try {
				
				int i = 1;
				
				for(File nom : file.listFiles()){
					
					System.out.print("\t\t"+((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));
					if((i%4) == 0) {
						System.out.print("\n");
					}
					
					i++;
					
				}
				
				System.out.print("\n");
				
			}
			catch(NullPointerException e){
				
				System.out.println("Pas de fichier!!!");
				
			}
			
		}
	}

}
