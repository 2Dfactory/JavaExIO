package TestWriterReader;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;


//Essai CharArrayWriter & CharArrayReader
public class MainChrRdWr {

	public static void main(String[] args) {

		CharArrayWriter caw = new CharArrayWriter();
		CharArrayReader car = null;
		
		try{
			
			caw.write("Coucou les testeux!!");
			//Appel à la méthode toString de notre objet de manière tacite
			System.out.println(caw);
			
			//caw.close() n'a aucun effet sur le flux
			//seul caw.reset() peut effacer les données
			caw.close();
			
			//On passe un tableau de caractère à l'objet qui va lire le tampon
			car = new CharArrayReader(caw.toCharArray());
			
			int i;
			//On remet tous les caratères lus dans un String
			String str = "";
			
			while((i=car.read())!= -1){
				
				str += (char) i;
				
				System.out.println(str);
				
			}
			
		}
		catch(IOException io){
			io.printStackTrace();
		}
		
		
	}

}
