package Class;

import java.util.ArrayList;

public class Sommet {
	
 
 private String contenu ;  //peut etre le nom du sommets ex ville , taches .... 
 private Point position ; //pour le dessin apres 
 private int marquee ; // pour savoir le rang 
 private int id ; // le numero de sommets 
 private static int compteur = 0 ; 
 //private ArrayList<Int> listPoids = new ArrayList<Int>();
//---------- Constructors------------------------------

	/**
	 * Constructeur de sommmet à 3 paramètres
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
	 * Constructeur Sommet à deux paramètre, position null par défaut
	 * @param contenu
	 * @param marquee
	 */
	public Sommet( String contenu,  int marquee  ) {
		this(contenu,null, marquee);
	
	}

	/**
	 * Constrcuteur par défaut
	 */
	public Sommet( ) {
	this("",null, 0);
}

//---------- End of constructors-----------------------


//---------- Getter ----------------------------------

	/**
	 * Recupere la position du Sommet
	 * @return position
	 */
	public Point getPosition() {
	return position;
}

	/**
	 * récupere le contenu du sommet
	 * @return contenu
	 */
	public String getContenu() {
	return contenu;
}


	/**
	 * recupere le numero du sommet marquée
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
//public ArrayList<Int> getListPoids() { return listPoids; }

//---------- End of GETTER-----------------------
//---------- Setter -----------------------

	/**
	 * Permet de modfier le contenu du sommet
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * permet de modifier la position du sommet
	 * @param position
	 */
	public void ChangePosition(Point position) {
		this.position = position;
	}


	/**
	 * permet de modifier le numero du sommet marquée
	 * @param marquee
	 */
	public void setMarquee(int marquee) {
		this.marquee = marquee;
	}


//---------- End of Setter-----------------------
//---------- Methods  -----------------------

	/**
	 * vérifie si deux sommets sont identiques :
	 * il compare que les deux sommets possèdent la même référence mémoire et sont donc en fait le même sommet.
	 * @param o
	 * @return vrai si  deux sommets sont identiques, faux sinon
	 */
	public boolean equals( Object o) {
		Sommet s = (Sommet) o ;
	
		return s.contenu == this.contenu ;
	}


	/**
	 * représente un sommet par son contenu
	 * @return retourn une chaine de caractère qui représente le sommet
	 */
	public String toString(  ) {
		return contenu+ " " ;
	}

}
