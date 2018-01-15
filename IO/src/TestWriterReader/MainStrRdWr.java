package TestWriterReader;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MainStrRdWr {

	public static void main(String[] args) {
		
		StringWriter stw = new StringWriter();
		StringReader str;
		
		try{
			
			stw.write("Coucou les testeux!!");
			//Appel à la méthode toString de notre objet de manière tacite
			System.out.println(stw);
			
			//stw.close() n'a aucun effet sur le flux
			//seul stw.reset() peut effacer les données
			stw.close();
			
			//On passe un tableau de caractère à l'objet qui va lire le tampon
			str = new StringReader(stw.toString());
			
			int i;
			//On remet tous les caratères lus dans un String
			String st = "";
			
			while ((i = str.read()) != -1){
				
				st += (char) i;
				
				System.out.println(st);
				
			}
			
			
		}
		catch(IOException io){
			io.printStackTrace();
		}

	}

}
