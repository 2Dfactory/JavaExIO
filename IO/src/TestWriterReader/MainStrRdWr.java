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
			//Appel � la m�thode toString de notre objet de mani�re tacite
			System.out.println(stw);
			
			//stw.close() n'a aucun effet sur le flux
			//seul stw.reset() peut effacer les donn�es
			stw.close();
			
			//On passe un tableau de caract�re � l'objet qui va lire le tampon
			str = new StringReader(stw.toString());
			
			int i;
			//On remet tous les carat�res lus dans un String
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
