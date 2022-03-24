package Class;

import java.util.ArrayList;

public class Sommet {
	
 private int cle ; 
 private  Object contenu ; 
 private Point position ;
 private int[] tabPoids;
 //private ArrayList<Int> listPoids = new ArrayList<Int>();
//---------- Constructors------------------------------
public Sommet(int cle, Object contenu, Point position, int[] tabPoids ) {
	super();
	this.cle = cle;
	this.contenu = contenu;
	this.position = position;
	/*for(int i=0; i<= listPoids.size(); i++){
		this.listPoids.add(listPoids.get(i));
	}*/
	for(int i=0; i<= tabPoids.length; i++){
		this.tabPoids[i]=tabPoids[i];
	}
}
public Sommet(int cle, Object contenu, Point position ) {
	this(cle,contenu,position, null);
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

//public ArrayList<Int> getListPoids() { return listPoids; }

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

//public void setListPoids(ArrayList<Int> listPoids) { this.listPoids = listPoids; }

//---------- End of Setter-----------------------
//---------- Methods  -----------------------
//TODO 
}
