package Class;

import java.util.Vector;

public class GrapheMatrice extends Graphe {

	//TODO  GrapheMatrice 
	
	private Vector<Vector<Arc>> mat;
	private Cle_Sommets numerotation;

//-----------------Methods ------------------------------
	//TODO  taille 
	public  int taille() {
	return 0 ; 
	}
	//TODO  ajouterSommet 
	public  void ajouterSommet(Sommet s) {
		
	}
	//TODO  existeArc
	public  boolean existeArc(Sommet s, Sommet t) {
		int numS = numerotation.numero(s);
		int numT = numerotation.numero(t);
		return mat.get(numS).get(numT) != null; 
	}
	
	//TODO  ajouterArc
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		ajouterSommet(s);
		ajouterSommet(t);
		int numS = numerotation.numero(s);
		int numT = numerotation.numero(t);
		mat.get(numS).set(numT, new Arc(s,t,val)); //mat[numS][numT] = new Arc(s,t,val);
	}
	
	//TODO  valeurArc

	public  int valeurArc(Sommet s, Sommet t) {
		int numS = numerotation.numero(s);
		int numT = numerotation.numero(t);
		return mat.get(numS).get(numT).getPoids(); //return mat[numS][numT].getPoids();
	}
	//TODO  enleverArc

	public  void enleverArc(Sommet s, Sommet t) {
		int numS = numerotation.numero(s);
		int numT = numerotation.numero(t);
		mat.get(numS).remove(numT); //mat[numS][numT].pop_back();
	}
	//TODO  generer FS et APS 
	
}
