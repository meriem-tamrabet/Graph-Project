package Class;

import java.util.ArrayList;

public class Sommet {
	
 
 private  String contenu ; 
 private Point position ;
 private int marquee ; 
 //private ArrayList<Int> listPoids = new ArrayList<Int>();
//---------- Constructors------------------------------
public Sommet( String contenu, Point position, int marquee  ) {
	super();
	
	this.contenu = contenu;
	this.position = position;
	this.marquee = marquee ; 
	
}
public Sommet( ) {
	this("",null, 0);
}

//---------- End of constructors-----------------------
//---------- Getter ----------------------------------


public Point getPosition() {
	return position;
}

public String getContenu() {
	return contenu;
}
public int getMarquee() {
	return marquee;
}

//public ArrayList<Int> getListPoids() { return listPoids; }

//---------- End of GETTER-----------------------
//---------- Setter -----------------------

public void setContenu(String contenu) {
	this.contenu = contenu;
}


public void ChangePosition(Point position) {
	this.position = position;
}

public void setMarquee(int marquee) {
	this.marquee = marquee;
}


//---------- End of Setter-----------------------
//---------- Methods  -----------------------
//DONE equls
public boolean equals( Object o) {
	Sommet s = (Sommet) o ; 
	
	return s.contenu == this.contenu ; 
}
//TODO to string

public String toString(  ) {
	return contenu+ " " ; 
}
//
}
