package Class;

import java.util.ArrayList;

public class Sommet<Int> {
	
 private int cle ; 
 private  Object contenu ; 
 private Point position ;
 private ArrayList<Int> listPoids = new ArrayList<Int>();
//---------- Constructors------------------------------
public Sommet(int cle, Object contenu, Point position) {
	super();
	this.cle = cle;
	this.contenu = contenu;
	this.position = position;
}
//---------- End of constructors-----------------------
//---------- Getter ----------------------------------
public int getCle() {
	return cle;
}

public Point getPosition() {
	return position;
}

public Object getContenu() {
	return contenu;
}

//---------- End of GETTER-----------------------
//---------- Setter -----------------------

public void setContenu(Object contenu) {
	this.contenu = contenu;
}

public void setCle(int cle) {
	this.cle = cle;
}

public void setPosition(Point position) {
	this.position = position;
} 
//---------- End of Setter-----------------------
//---------- Methods  -----------------------
//TODO 
}
