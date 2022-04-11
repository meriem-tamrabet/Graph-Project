package Class;

import java.util.ArrayList;

public class Algorithme {
 int MAXPOIDS =100 ; 
public  ArrayList<Integer> demi_degre_interieur   (ArrayList<Integer> FS, ArrayList<Integer> APS)
{
	return null  ; 
}

ArrayList<Integer> descente_largeur       (int r, ArrayList<Integer> fs, ArrayList<Integer> aps)
{
	return null ; 
}


ArrayList<Integer> Prufer_encode          (int[][] mat){
	return null  ; 
}

//void Prufer_decode (ArrayList<Integer> p, int[][]  mat) { } 


void Dikjstra( int  s , Graphe G ,  ArrayList<Integer> predecesseur , ArrayList<Integer> distance)
{
	int ind; /* nombre d'elements qui restent a traiter */
	int i, j = 0, k, v ;
	int n = G.Aps_Get(0) ;
	int m = G.Fs_Get(0)-n  ;
	//initialisation des tableaux
	predecesseur = new ArrayList<>(n+1) ; 
	distance = new ArrayList<Integer>(n+1) ; 
	ArrayList<Boolean> inS = new ArrayList<Boolean>(n+1) ; /* sert
	a dire quels sont les sommets qui restent a traiter inS[i] = 0 ou 1
	*/
	
	/* initialisation des tableaux d, pr et inS*/
	for (i = 1;i <= n; i++)
	{
		distance.set(i, G.cout_Get(s, i) ) ;//d[i] = p[s][i];
		inS.set(i, true) ; // inS[i] = 1;
		predecesseur.set(i, -1) ; //pr[i] = -1;

      }
	distance.set(s, 0) ; 
	predecesseur.set(s, 0) ; 
	inS.set(s, false) ; /* on supprime le sommets */
	ind = n -1 ; 
	while(ind > 0) {
		/* calcule du minimum selon d des sommets de S */
		
		
		m = MAXPOIDS;
		for (i=1;i<=n;i++)
			if (inS.get(i) == true)
			if (distance.get(i) < m)
			{
			m = distance.get(i) ;
			j = i;
			}
		if (m == MAXPOIDS) return;
		//je marque le sommets 
		inS.set(j , false) ;
		ind--;
		k = G.Aps_Get(j) ; // k = aps[j];
		while(G.Fs_Get(k) != 0)
		{ int fs_K = G.Fs_Get(k) ; 
			if ( inS.get(fs_K ) == true )// if (inS[fs[k]] == 1)
			{
				v = distance.get(j) + G.cout_Get(j, fs_K) ; // v = d[j]+p[j][fs[k]];
				if (v < distance.get(fs_K))// if (v < d[fs[k]])
				{
					distance.set(fs_K , v) ;  // d[fs[k]] = v;
				 	predecesseur.set(fs_K, j) ; // pr[fs[k]] = j;
				}
			}
			k++;
			
		}
	}
	 String str = "\n distance : |";

      for( i = 1;i < distance.size();i++){
          str += distance.get(i) + "|";
      }
	
}

}

