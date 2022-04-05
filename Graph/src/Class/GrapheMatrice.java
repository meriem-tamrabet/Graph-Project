package Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class GrapheMatrice extends Graphe {

	
	
	private int[][] matrice;
	private boolean avec_Poids ; 
	private int valeur_interdite = 999 ; 
	
//------------constructeur ------------------
	public GrapheMatrice(int n , boolean avec_Poids ) {
	
	this.avec_Poids = avec_Poids ;
	int taille_matrice = n+2 ; 
	this.matrice = new int[taille_matrice][taille_matrice] ; 
	this.matrice[0][0] = n ; 

	int val ; 
	//cas de matrice des cout initialiser a 
	if( this.avec_Poids)
		val = valeur_interdite ; 
	else //cas matrice adjacente 
		val = 0 ; 
	if( n> 0 )
		this.matrice[0][1] = 0 ; 
	for( int i = 2 ; i< taille_matrice ; i++ )
		this.matrice[0][i] = val ;
	for( int i = 1 ; i<taille_matrice ; i++ )
		this.matrice[i][0] = val ;
	
	for( int i = 1 ; i<taille_matrice ; i++ ) {
		for(int j = 1 ; j<taille_matrice ; j++)
		{ 
			this.matrice[i][j] = val ; 
		}
	}
	
	}
//-----------------Methods ------------------------------
	
	public int nombre_sommets() {
	return matrice[0][0] ; 
	}
	
	public void ajouterSommet(Sommet s) {
		int taille = nombre_sommets() +1  ; 
		taille++ ; 
	
		int[][] N_matrice = new int[taille ][taille] ; 
		//recopier tt 
		for( int i = 0 ; i< taille -1   ; i++ ) {
			for(int j = 0 ; j< taille-1  ; j++)
			{
				 N_matrice [i][j] =  matrice[i][j] ; 
			}
		}
		
		
		 N_matrice [0][0] ++; 
		matrice =N_matrice ; 
	}
	
	public void supprimerSommet(Sommet s)
	{
		int id = s.getId();
		int n = nombre_sommets();
		int taille = n ; 
		int[][] mat = new int[taille][taille];
		for(int i=0; i<id; ++i)
		{
			for(int j=0; j<id; ++j)
			{
				mat[i][j] = matrice[i][j];
			}
			for(int j=id+1; j<taille ; ++j)
			{
				mat[i][j] = matrice[i][j];
			}
		}
		for(int i=id+1; i<taille; ++i)
		{
			for(int j=id+1; j<id; ++j)
			{
				mat[i-1][j-1] = matrice[i][j];
			}
			for(int j=id+1; j<n; ++j)
			{
				mat[i-1][j-1] = matrice[i][j];
			}
		}
		mat [0][0] --;
		matrice = mat;
	}
	
	public boolean existeArc(Sommet s, Sommet t) {
		if( this.avec_Poids)
			return ( matrice[s.getId()][t.getId()] != valeur_interdite) ; 
		
		else 
			return (matrice[s.getId()][t.getId()] != 0 )  ; 
	}
	
	
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		System.out.print(	" sommet s = " + s.getId() ) ; 
		System.out.println(	" -->  sommet t = " +t.getId() ) ;
		
		if( s.getId() > nombre_sommets() ||  t.getId() > nombre_sommets() )
		return ;
		
		this.matrice[0][1] ++ ; 
		if( this.avec_Poids)
		{
			
		 matrice[s.getId()][t.getId()]  = val ; 
		 
		}
		else
			 matrice[s.getId()][t.getId()]  = 1 ; 
			 
	}
	
	

	public  int valeurArc(Sommet s, Sommet t) {
	 return  matrice[s.getId()][t.getId()]  ; 
	}
	

	public  void enleverArc(Sommet s, Sommet t) {
		System.out.print(	" sommet s = " + s.getId() ) ; 
		System.out.println(	" -->  sommet t = " +t.getId() ) ;
		this.matrice[0][1] -- ; 
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrice);
		result = prime * result + Objects.hash(avec_Poids, valeur_interdite);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrapheMatrice other = (GrapheMatrice) obj;
		if(this.nombre_sommets() != other.nombre_sommets())
		{
			return false;
		}
		return avec_Poids == other.avec_Poids && Arrays.deepEquals(matrice, other.matrice)
				&& valeur_interdite == other.valeur_interdite;
	}

	@Override
	public String toString() {
		String Smatrice = " " ; 
		int n = nombre_sommets() ; 
		int taille_matrice = n +1 ; 
		for( int i = 0 ; i< taille_matrice ; i++ ) {
			Smatrice += "| " ; 
			for(int j = 0 ; j< taille_matrice ; j++)
			{
				Smatrice += this.matrice[i][j] +" " ; 
			}
			Smatrice += "|\n " ; 
		}
		
		return Smatrice ; 
	}
	
	public void Matrice_to_fs_aps(int[] aps , int[] fs ) {
		
		int n = nombre_sommets() ;
		int taille_matrice = n +1 ; 
		int m = 0 ; 
		int k = 1 ; 
		for( int i = 1 ; i <taille_matrice ; i++) {
			aps[i] = k ; 
			for( int j = 1 ; j <taille_matrice; j++) {
				if(matrice[i][j] != 0)
					fs[k++] = j ;
				fs[k++] = 0 ; 
			}
		}
	}
	
	//TODO  generer FS et APS 
	
}
