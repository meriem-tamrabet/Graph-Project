package Class;

public class Sommet {
	
 private int cle ; 
 private  Object contenu ; 
 private Point position ;
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
public void setCle(int cle) {
	this.cle = cle;
}
public Object getContenu() {
	return contenu;
}

//---------- End of GETTER-----------------------
//---------- Setter -----------------------

public void setContenu(Object contenu) {
	this.contenu = contenu;
}
public Point getPosition() {
	return position;
}
public void setPosition(Point position) {
	this.position = position;
} 
//---------- End of Setter-----------------------
//---------- Methods  -----------------------
//TODO 
}
