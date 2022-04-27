package Class;

import java.util.ArrayList;

public class Sommet {
	
 
 private String contenu ;  
 private Point position ; 
 private int marquee ; 
 private int id ; 
 private static int compteur = 0 ; 
 
//---------- Constructors------------------------------

	/**
	 * Constructeur de sommmet a 3 parametres
 	 * @param contenu  String
	 * @param position Point
	 * @param marquee int
	 */
public Sommet( String contenu, Point position, int marquee  ) {
	super();
	
	this.contenu = contenu; 
	this.position = position;
	this.marquee = marquee ;
	compteur++ ; 
	this.id = compteur;  

}

	/**
	 * Constructeur Sommet a 2 parametres, position null par defaut
	 * @param contenu
	 * @param marquee
	 */
	public Sommet( String contenu,  int marquee  ) {
		this(contenu,null, marquee);
	
	}

	/**
	 * Constrcuteur par defaut
	 */
	public Sommet( ) {
	this("",null, 0);
}


//---------- Getters ----------------------------------

	/**
	 * Recupere la position du Sommet
	 * @return position
	 */
	public Point getPosition() {
	return position;
}

	/**
	 * recupere le contenu du sommet
	 * @return contenu
	 */
	public String getContenu() {
	return contenu;
}


	/**
	 * recupere le numero du sommet marquee
	 * @return marquee
	 */
	public int getMarquee() {
	return marquee;
}

	/**
	 * recupere l'identifiant du sommet
	 * @return id 
	 */
	public int getId() {
		return id;
	}

//---------- Setters -----------------------

	/**
	 * modfie le contenu du sommet
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * modifie la position du sommet
	 * @param position
	 */
	public void ChangePosition(Point position) {
		this.position = position;
	}


	/**
	 * modifier le numero du sommet marquee
	 * @param marquee
	 */
	public void setMarquee(int marquee) {
		this.marquee = marquee;
	}

//---------- Methodes  -----------------------

	/**
	 * verifie que deux sommets sont identiques :
	 * compare se les deux sommets possedent la meme reference memoire et sont donc en fait le meme sommet
	 * ou qu ils ont les memes valeurs 
	 * @param o 
	 * @return vrai si  deux sommets sont identiques ou egaux, faux sinon 
	 */
	public boolean equals( Object o) {
		Sommet s = (Sommet) o ;
	
		return s.contenu == this.contenu ;
	}


	/**
	 * represente un sommet par son contenu
	 * @return une chaine de caractere qui represente le sommet
	 */
	public String toString(  ) {
		return contenu+ " " ;
	}

}
