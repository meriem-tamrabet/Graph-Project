package Class;
import java.util.Scanner;
public class Point {
	private int x, y ;


//------------------------ constructeurs-----------------------

	/**
	 * @brief Constructeur a 2 parametres
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

//-------------------------Getters ----------------------------

	/**
	 * @brief Recupere la coordonnee x du point
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @brief Recupere la coordonnee y du point
	 * @return y
	 */
	public int getY() {
		return y;
	}


//-----------------------Setters--------------------------------

	/**
	 * @brief Modifie la coordonnee y du point
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @brief Modifie la coordonnee x du point
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}


//-------------------- Methodes  -----------------------

	/**
	 * @brief Affiche un point
	 * @return String
	 */
	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}


	/**
	 * @brief Deplace un point
	 * @param x
	 * @param y
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}


	/**
	 * @brief Translate un point
	 * @param x
	 * @param y
	 */
	public void schift(int x, int y){
		this.x += x;
		this.y += y;
	}

	/**
	 * @brief Lit un point
	 * @param s Scanner lisant l'entree clavier
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
	 * @biref Affiche un point sur la sortie standard
	 */
	public void print(){

		System.out.println(toString());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}


	/**
	 * @brief Surcharge de la methode equals verifiant l'égalité de deux points
	 * @param obj Object
	 * @return true si deux points sont identiques, false sinon
	 */
	@Override
	public boolean equals(Object obj) {

		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;

		Point p = (Point) obj ; 
		return p.x ==this.x && p.y ==this.y;
	}
 

}

