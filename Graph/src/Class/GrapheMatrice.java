package Class;

import java.util.Vector;

public class GrapheMatrice extends Graphe {

	
	
	private Vector<Vector<Arc>> mat;
	private Cle_Sommets idantifiant;
//------------constructeur ------------------
	public GrapheMatrice(int n ) {
		
		idantifiant = new Cle_Sommets(n);
		mat = new Vector<Vector<Arc>>(n);
		mat.setSize(n);
	}
//-----------------Methods ------------------------------
	
	public  int taille() {
	return mat.size() ; 
	}
	
	public  void ajouterSommet(Sommet s) {
		
		if(idantifiant.ajouterElement(s))
		{
			// ici on a pu ajouter un sommet avec un nv identifiant 
			int taille_ligne= taille() ; 
			// on cree une ligne 
			Vector<Arc> vecteur_sommets = new Vector<Arc> (taille_ligne) ; 
			vecteur_sommets.setSize(taille_ligne);
			//on insert dans la matrice 
			mat.set(idantifiant.numero(s), vecteur_sommets) ; 
			
		}
	}
	
	public  boolean existeArc(Sommet s, Sommet t) {
		int numS = idantifiant.numero(s);
		int numT = idantifiant.numero(t);
		return mat.get(numS).get(numT) != null; 
	}
	
	
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		ajouterSommet(s);
		ajouterSommet(t);
		int numS = idantifiant.numero(s);
		int numT = idantifiant.numero(t);
		mat.get(numS).set(numT, new Arc(s,t,val)); //mat[numS][numT] = new Arc(s,t,val);
	}
	
	

	public  int valeurArc(Sommet s, Sommet t) {
		int numS = idantifiant.numero(s);
		int numT = idantifiant.numero(t);
		return mat.get(numS).get(numT).getPoids(); //return mat[numS][numT].getPoids();
	}
	

	public  void enleverArc(Sommet s, Sommet t) {
		int numS = idantifiant.numero(s);
		int numT = idantifiant.numero(t);
		mat.get(numS).remove(numT); //mat[numS][numT].pop_back();
	}
	//--------------------affichage --------------------
	public void affiche_matrice() {
		
				System.out.println(mat.toString()); 
		
			
	
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}

	@Override
	public String toString() {
		String matrice = "[ " ; 
		for(int i = 0 ; i< mat.size() ; i++) {
			for(int j = 0 ; j< mat.elementAt(i).size() ;j++) {
				matrice +=  mat.elementAt(i).elementAt(j) +" ";
			}
			matrice += "\n" ; 
		}
		
		return matrice ; 
	}
	
	
	
	//TODO  generer FS et APS 
	
}
