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
	 * @brief Constructeur Sommet a 3 parametres
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
	 * @brief Constructeur Sommet a 2 parametres, position null par defaut
	 * @param contenu String
	 * @param marquee int
	 */
	public Sommet( String contenu,  int marquee  ) {
		this(contenu,null, marquee);
	
	}

	/**
	 * @brief Constrcuteur par defaut
	 */
	public Sommet( ) {
	this("",null, 0);
}


//---------- Getters ----------------------------------

	/**
	 * @brief Recupere la position du Sommet
	 * @return position
	 */
	public Point getPosition() {
	return position;
}

	/**
	 * @brief Recupere le contenu du sommet
	 * @return contenu
	 */
	public String getContenu() {
	return contenu;
}


	/**
	 * @brief Recupere le numero du sommet marquee
	 * @return marquee
	 */
	public int getMarquee() {
	return marquee;
}

	/**
	 * @brief Recupere l'identifiant du sommet
	 * @return id 
	 */
	public int getId() {
		return id;
	}
public Sommet getSommet() {
	return this ; 
}
//---------- Setters -----------------------

	/**
	 * @brief Modifie le contenu du sommet
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * @brief Modifie la position du sommet
	 * @param position
	 */
	public void ChangePosition(Point position) {
		this.position = position;
	}


	/**
	 * @brief Modifie le numero du sommet marquee
	 * @param marquee
	 */
	public void setMarquee(int marquee) {
		this.marquee = marquee;
	}

//---------- Methodes  -----------------------

	/**
	 * @brief Surcharge de l'operateur equals vérifiant que deux sommets sont identiques
	 * @param o Object
	 * @return true si deux sommets sont identiques, false sinon 
	 */
	public boolean equals( Object o) {

		if(this == o)
			return true;
		
		if(o == null)
			return false;
		
		if(this.getClass() != o.getClass())
			return false;

		Sommet s = (Sommet) o ;
	
		return s.contenu == this.contenu;
	}


	/**
	 * @brief Affiche le contenu du sommet
	 * @return String
	 */
	public String toString(  ) {
		return contenu+ " ( " + position.getX() +","+position.getY() +")" ;
	}

}
