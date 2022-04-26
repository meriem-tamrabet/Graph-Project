package Class;
import java.util.Scanner;
public class Point {
	private int x, y ;


//----------  constructors-----------------------

	/**
	 * Constrcuteur de Point avec 2 paramètres
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

//---------- End of constructors-----------------------

//-------------------------Getter ----------------------------

	/**
	 * récupere la coordonnées x du point
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * récupere la coordonnées y du point
	 * @return y
	 */
	public int getY() {
		return y;
	}
	//------------------- End of Getter-----------------------


//-----------------------Setter--------------------------------

	/**
	 * Modifie la coordonées y du point
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Modifie la coordonées x du point
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
//------------------- End of Setter-----------------------


//-------------------- Methods  -----------------------

	/**
	 * Répresente un point
	 * @return chaine de caractère qui représente les coordonées d'un point
	 */
	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}


	/**
	 * Modifie emplacement d'un point par les 2 paramètres
	 * @param x
	 * @param y
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}


	/**
	 * translation d'un point par les 2 paramètres
	 * @param x
	 * @param y
	 */
	public void schift(int x, int y){
		this.x += x;
		this.y += y;
	}


//TODO check si on ecrit (2,3) marche bien

	/**
	 * Lit un point entrée par l'utilisateur
	 * @param s permet de lire se que l'utilisateur entre au clavier
	 */
	public void read(Scanner s){

		Scanner scan = s;
		
		int nx = scan.nextInt();
		this.setX(nx);
		
		int ny = scan.nextInt();
		this.setY(ny);
	}
	
//TODO imprimer dans fichier

	/**
	 * affiche un point
	 */
	public void print(){

		System.out.println(toString());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	/**
	 * vérifie si deux points sont identiques :
	 * il compare que les deux points possèdent la même référence mémoire et sont donc en fait le même point.
	 * @param obj
	 * @return vrai si  deux points identiques, faux sinon
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj ; 
		return p.x ==this.x && p.y ==this.y;
	}
 

}

