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
	
	//---------------------------Tarjan-------------------------------------
	public int depiler(ArrayList<Integer>t)
	{
		return t.get(t.lastIndexOf(t)-1);
	}
	
	public void traversee(int s, int p, Graphe g, ArrayList<Integer>num, ArrayList<Integer>ro, ArrayList<Boolean>entarj, ArrayList<Integer>tarj,
			ArrayList<Integer>pred, ArrayList<Integer>prem, ArrayList<Integer>pilch, ArrayList<Integer>cfc)
		{
			 int t;
			 int k;
			 p++; 
			 num.set(s, p); 
			 ro.set(s, p);	 	 // numérote s et initialise ro[s]
			 empiler(s,tarj); 
			 entarj.set(s, true);
			 for (int r=g.Aps_Get(s); (t=g.Fs_Get(r)) != 0 ; r++)
			 { 	if (num.get(t) == 0)	 	 	 // si t n'est pas encore numéroté
			 	{ 	pred.set(t, s);
			 		traversee(t,p, g, num, ro, entarj, tarj, pred, prem, pilch, cfc);
			 		if (ro.get(t) < ro.get(s)) 
			 			ro.set(s, ro.get(t)) ;	 	 	 // Z1
			 	}
			 	else
			 	{ if ((num.get(t) < ro.get(s)) && entarj.get(t)) 
			 		ro.set(s, num.get(t));// Z2
			 	}
			}
			 k = 0;
			 if (ro.get(s) == num.get(s))
			 {
				k++;	
				int u;
				do
				{	 	 	 	 	 	 	 	 	 // Z3
					 	 u = depiler(tarj);
					 	 entarj.set(u, false);
					 	 empiler(u,pilch);
					 	 cfc.set(u,k);
				} while (u != s);
				 prem.set(k, pilch.get(0));
				 pilch.set(0, 0);
			}
		}
	
	public void fortconnexe(Graphe g, ArrayList<Integer>prem, ArrayList<Integer>pilch, ArrayList<Integer>cfc, ArrayList<Integer>pred)
	{
		int n = g.Aps_Get(0);
		prem = new ArrayList<Integer>(n+1);
		pilch = new ArrayList<Integer>(n+1);
		cfc = new ArrayList<Integer>(n+1);
		pred = new ArrayList<Integer>(n+1);
		ArrayList<Integer>tarj = new ArrayList<Integer>(n+1);
		ArrayList<Boolean>entarj = new ArrayList<Boolean>(n+1);
		ArrayList<Integer>num = new ArrayList<Integer>(n+1);
		ArrayList<Integer>ro = new ArrayList<Integer>(n+1);
		int p = 0;
		int k = 0;
		for (int i = 1; i<=n; i++)
		{
			 	 num.set(i, 0);
			 	 pred.set(i, 0);
			 	 ro.set(i, 0);
			 	 entarj.set(i, false);
		}
		pilch.set(0, 0);
		tarj.set(0, 0);
		
		for(int s = 1; s<=g.Aps_Get(0); s++)
			 	 if (num.get(0) == 0) 
			 	 {
			 		traversee(s,p,g,num,ro, entarj, tarj, pred, prem, pilch, cfc);
			 	 }
		prem.set(0, k);
	}
	public void graph_reduit (ArrayList<Integer>prem,ArrayList<Integer>pilch,ArrayList<Integer>cfc,ArrayList<Integer>fs, 
			ArrayList<Integer>aps,ArrayList<Integer>fsr, ArrayList<Integer>apsr)
	{
		int s, kr=1, nbc=prem.get(0);
		ArrayList<Boolean>deja_mis=new ArrayList<Boolean>(nbc+1);
		fsr=new ArrayList<Integer> (fs.get(0)+1);
		apsr=new ArrayList<Integer>(nbc+1);
		apsr.set(0, kr);
		for(int i=1;i<nbc;i++)
		{
			 apsr.set(i, kr);
			 for(int j=1;j<=nbc;j++)
			 {
				 deja_mis.set(j, false);
			 }
			 deja_mis.set(i,true);
			 s=prem.get(0);
			 while(s!=0)
			 {
				 for(int t=aps.get(s);fs.get(t)!=0;t++)
				 {
					 if(deja_mis.get(cfc.get(fs.get(t)))==false)
					 {
						 fs.set(kr, cfc.get(fs.get(t)));
						 kr++;
						 deja_mis.set(cfc.get(fs.get(t)),true);
					 }
				 }
				 s=pilch.get(s);
			 }
			 fsr.set(kr, 0);
			 kr++;
		}
		fsr.set(0, kr-1);
	}
	public void base_Greduit(ArrayList<Integer>apsr, ArrayList<Integer>fsr, ArrayList<Integer>br)
	{
		int nr = apsr.get(0);
		br = new ArrayList<Integer>(nr+1);
		ArrayList<Integer>ddir = new ArrayList<Integer>(nr+1);
		for (int i=0; i<=nr; i++)
		 	 ddir.set(i, 0);
		for (int kr=1; kr <= fsr.get(kr); kr++)
		 	 ddir.set(fsr.get(kr), fsr.get(kr)+1);
		int nb = 0;
		for (int c = 1; c <= nr; c++)
		 	 if (ddir.get(c) == 0) 
		 		 br.set(nb+1, c);
		br.set(0,nb);
	}
	public void edition_bases(ArrayList<Integer>prem, ArrayList<Integer>pilch, ArrayList<Integer>br)
	{
		int nb = br.get(0); // Nombre de CFC de l’unique base du graphe réduit
		ArrayList<Integer>Base = new ArrayList<Integer>(nb+1); // pile qui mémorise les sommets des bases du graphe initial
		Base.set(0, nb);
		int p = 1;
		int som = prem.get(br.get(1)); // premier sommet de la première CFC
		while (p >= 1)
		{
		 	 if ((p<= nb) && (som != 0))
		 	 {
		 	 	 Base.set(p, som);
		 	 	 p++;
		 	 	 if (p <= nb)
		 	 	 	 som = prem.get(br.get(p));
		 	 	 else
					// Affiche le contenu du tableau Base contenant les
		 	 	 	 	 	 //sommets d’une base du graphe initial
		 	 	 {
		 	 		String str = "";
		 			str += "------------Dantzig : Matrice des couts-------------\n";
		 			str += "| ";
		 	 		 for(int i=0; i<Base.size(); i++)
		 	 		 {
		 	 			 str+=Base.get(i);
		 	 		 }
		 	 		str += "| \n";
		 	 	 }
		 	 }
		 	 else
		 	 {
		 	 	 p--;
		 	 	 som = pilch.get(Base.get(p));
		 	 }
		}
	}

}

