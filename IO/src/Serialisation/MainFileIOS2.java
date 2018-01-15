package Serialisation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Essai sérialisation avec un objet transient inclus
public class MainFileIOS2 {

	public static void main(String[] args) {

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try{
			
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(new File("Files/game.txt"))));
			
			oos.writeObject(new Game2("Assassin Creed", "Aventure", 45.69));
			oos.writeObject(new Game2("Tomb Raider", "Plateforme", 23.45));
			oos.writeObject(new Game2("Tetris", "Strategie", 2.5));
			
			oos.close();
			
			ois = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(new File("Files/game.txt"))));
			
			try{
				System.out.println("Affichage des jeux");
				System.out.println("*******************************");
				System.out.println(((Game2) ois.readObject()).toString());
				System.out.println(((Game2) ois.readObject()).toString());
				System.out.println(((Game2) ois.readObject()).toString());
			}
			catch(ClassNotFoundException c){
				c.printStackTrace();
			}
			
		}
		catch(FileNotFoundException f){
			f.printStackTrace();
		}
		catch(IOException io){
			io.printStackTrace();
		}
		
		
		
		
	}

}
