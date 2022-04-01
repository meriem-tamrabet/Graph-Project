package Class;

import java.util.Vector;

public class GrapheMatrice extends Graphe {

	
	
	private int[][] matrice;
	private boolean avec_Poids ; 
	private int valeur_interdite = 999 ; 
	
//------------constructeur ------------------
	public GrapheMatrice(int n , boolean avec_Poids ) {
		this.avec_Poids = avec_Poids ; 
	this.matrice = new int[n][n] ; 
	int val ; 
	//cas de matrice des cout initialiser a 
	if( this.avec_Poids)
		val = valeur_interdite ; 
	else //cas matrice adjacente 
		val = 0 ; 
	
	for( int i = 0 ; i< n ; i++ ) {
		for(int j = 0 ; j< n ; j++)
		{
			this.matrice[i][j] = val ; 
		}
	}
	
	}
//-----------------Methods ------------------------------
	
	public  int nombre_sommets() {
	return  matrice.length ; 
	}
	
	public  void ajouterSommet(Sommet s) {
		int n = nombre_sommets() ; 
		int[][] N_matrice = new int[n+1][n+1] ; 
		//recopier 
		for( int i = 0 ; i< n ; i++ ) {
			for(int j = 0 ; j< n ; j++)
			{
				 N_matrice [i][j] = matrice[i][j] ; 
			}
		}
		//je l'affecte 
		matrice =N_matrice ; 
	}
	
	public  boolean existeArc(Sommet s, Sommet t) {
		if( this.avec_Poids)
			
			return ( matrice[s.getId()][t.getId()] != valeur_interdite) ; 
		else 
			return (matrice[s.getId()][t.getId()] != 0 )  ; 
	}
	
	
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		if( this.avec_Poids)
		 matrice[s.getId()][t.getId()]  = val ; 
		else
			 matrice[s.getId()][t.getId()]  = 1 ; 
	}
	
	

	public  int valeurArc(Sommet s, Sommet t) {
	 return  matrice[s.getId()][t.getId()]  ; 
	}
	

	public  void enleverArc(Sommet s, Sommet t) {
if( this.avec_Poids)
			
			 matrice[s.getId()][t.getId()] = valeur_interdite ; 
		else 
			matrice[s.getId()][t.getId()] = 0   ; 
	}
	//--------------------affichage --------------------
	public void affiche_matrice() {
		
		
	System.out.print(this.toString()  ); 
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
		String Smatrice = "" ; 
		int n = nombre_sommets() ; 
		for( int i = 0 ; i< n ; i++ ) {
			Smatrice += "|" ; 
			for(int j = 0 ; j< n ; j++)
			{
				Smatrice += this.matrice[i][j] +" " ; 
			}
			Smatrice += "|\n " ; 
		}
		
		return Smatrice ; 
	}
	
	
	
	//TODO  generer FS et APS 
	
}
