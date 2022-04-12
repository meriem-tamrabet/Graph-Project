package Class;

import java.util.ArrayList;

public class Algorithme {
 int MAXPOIDS =100 ; 
public  ArrayList<Integer> demi_degre_interieur   (ArrayList<Integer> FS, ArrayList<Integer> APS)
{
	int n = APS.get(0);

	ArrayList<Integer> ddi = new ArrayList<>(n+1);

	ddi.add(0, n);

	for(int s = 1;s <= n;s++){
		ddi.add(s, 0);
	}

	for(int k = 1;k < FS.get(0);k++){
		if(FS.get(k) != 0){
			int elem = ddi.get(k);
			ddi.set(FS.get(k),elem++);
		}
	}

	return ddi ; 
}

public  ArrayList<Integer> demi_degre_exterieur  (ArrayList<Integer> FS, ArrayList<Integer> APS)
{
	int n = APS.get(0);

	ArrayList<Integer> dde = new ArrayList<>(n+1);

	dde.add(0, n);

	for(int s = 1;s < n;s++){
		dde.add(s, APS.get(s+1) - APS.get(s) - 1);
	}

	dde.add(n,FS.get(0)-APS.get(n));

	return dde ; 
}

ArrayList<Integer> descente_largeur       (int r, ArrayList<Integer> fs, ArrayList<Integer> aps)
{
	int n = aps.get(0);

	int i = 0, j = 1, k = 0, ifin, s, t,it;

	ArrayList<Integer> fil = new ArrayList<>(n+1);
	fil.add(0,n);
	fil.add(1,r);

	ArrayList<Integer> dist = new ArrayList<>(n+1);

	for(int h = 1;h <= n;h++){
		dist.add(h, -1);
	}

	dist.set(r,0);

	while(i < j){
		k++;
		ifin = j;

		while(i < ifin){
			i++;
			s = fil.get(i);
			it = aps.get(s);
			t = fs.get(it);

			while(t > 0){
				if(dist.get(t) == -1){
					j++;
					fil.add(j,t);
					dist.set(t,k);
				}
				t = fs.get(++it);
			}
		}
	}

	return dist ; 
}

public void empiler(int x,ArrayList<Integer> pilch){
	pilch.set(x,pilch.get(0));
	pilch.set(0,x);
}

public ArrayList<Integer> rang(ArrayList<Integer> FS, ArrayList<Integer> APS){
	int n = APS.get(0);
	int m = FS.get(0);
	int s, k, h, t;

	ArrayList<Integer> rang = new ArrayList<>(n+1);
	ArrayList<Integer> pilch = new ArrayList<>(n+1);
	ArrayList<Integer> prem = new ArrayList<>(n+1);

	ArrayList<Integer> ddi = demi_degre_interieur(FS, APS);

	pilch.add(0,0);

	for(s = 1;s <= n;s++){
		rang.add(s,-1);
		if(ddi.get(s) == 0)
			empiler(s,pilch);
	}

	k = -1;
	s = pilch.get(0);
	prem.add(0,s);

	while(pilch.get(0) > 0){
		k++;
		pilch.set(0,0);

		while(s > 0){
			rang.set(s,k);
			h = APS.get(s);
			t = FS.get(h);

			while(t > 0){
				int tmp = ddi.get(t);
				ddi.set(t,tmp--);

				if(ddi.get(t) == 0){
					empiler(t, pilch);
				}

				h++;
				t = FS.get(h);
			}

			s = pilch.get(s);
		}

		s = pilch.get(0);
		prem.set(k+1,s);
	}

	return rang;
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

	public void Dantzig(double[][] c){
		int n = (int)(c[0][0]);
        int i,j,k;
        double x;

        for(k = 1;k < n;k++){
            for(i = 1;i <= k;i++){
                for(j = 1;j <= k;j++){
                    if((x = c[i][j] + c[j][k+1]) < c[i][k+1]){
                        c[i][k+1] = x;
                    }

                    if((x = c[k+1][j] + c[j][i]) < c[k+1][i]){
                        c[k+1][i] = x;
                    }
                }
                if((c[i][k+1] + c[k+1][i]) < 0){
                    System.out.println("Circuit absorbant passant par " + i + " et " + k+1);
                    return;
                }
            }

            for(i = 1;i <= k;i++){
                for(j = 1;j <= k;j++){
                    if((x = c[i][k+1] + c[k+1][j]) < c[i][j]){
                        c[i][j] = x;
                    }
                }
            }
        }

		//Affichage

		String str = "";
		str += "------------Dantzig : Matrice des couts-------------\n";
		for(int a = 0;a < c.length;a++){
			str += "| ";
			for(int b = 0;b < c[a].length;b++){
				str += c[a][b] + "\t";
			}
			str += "|\n";
		}
		System.out.println(str);
	}

}

