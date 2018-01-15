package Serialisation;

import java.io.Serializable;

//Essai sérialisation avec un objet transient inclus
public class Game2 implements Serializable {

	private String nom, style;
	private double prix;
	private transient Notice notice;
	
	public Game2(String nom, String style, double prix){
		
		this.nom = nom;
		this.style = style;
		this.prix = prix;
		this.notice = new Notice();
		
	}
	
	public String toString(){
		return "Nom du jeu : " + this.nom +"\n"
				+ "Style de jeu : " + this.style +"\n"
				+ "Prix du jeu : " + this.prix + "\n";	
	}
	
}
