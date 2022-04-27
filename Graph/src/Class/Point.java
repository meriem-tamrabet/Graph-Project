package Class;
import java.util.Scanner;
public class Point {
	private int x, y ;


//------------------------ constructeurs-----------------------

	/**
	 * Constructeur a 2 parametres
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

//-------------------------Getters ----------------------------

	/**
	 * recupere la coordonnee x du point
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * recupere la coordonnee y du point
	 * @return y
	 */
	public int getY() {
		return y;
	}


//-----------------------Setters--------------------------------

	/**
	 * Modifie la coordonee y du point
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Modifie la coordonnee x du point
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}


//-------------------- Methodes  -----------------------

	/**
	 * Represente un point sous forme de chaine de caracteres
	 * @return chaine de caractere qui represente les coordonees d'un point
	 */
	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}


	/**
	 * Modifie emplacement d'un point a (x,y)
	 * @param x
	 * @param y
	 */
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}


	/**
	 * translation d'un point a (x,y)
	 * @param x
	 * @param y
	 */
	public void schift(int x, int y){
		this.x += x;
		this.y += y;
	}

	/**
	 * Lit un point entree par l'utilisateur
	 * @param s permet de lire ce que l'utilisateur entre au clavier
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
		return super.hashCode();
	}


	/**
	 * verifie si deux points sont identiques :
	 * compare si les deux points possedent la meme reference memoire et sont donc en fait le meme point
	 * ou si leur valeur de x et y sont les memes
	 * @param obj
	 * @return vrai si deux points identiques ou egaux , faux sinon
	 */
	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj ; 
		return p.x ==this.x && p.y ==this.y;
	}
 

}

