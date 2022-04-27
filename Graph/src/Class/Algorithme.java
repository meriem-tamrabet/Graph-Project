package Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


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
			ddi.set(FS.get(k),ddi.get(FS.get(k))+1); 
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

public int[] descente_largeur (int r, ArrayList<Integer> fs, ArrayList<Integer> aps)
{
	int n = aps.get(0);

	int i = 0, j = 1, k = 0, ifin, s, t,it;

	int[] fil = new int[n+1];
	fil[0] = n;
	fil[1] = r;

	int[] dist = new int[n+1];
	dist[0] = n;
	
	for(int h = 1;h <= n;h++){
		dist[h] = -1;
	}

	dist[r] = 0;

	while(i < j){
		k++;
		ifin = j;

		while(i < ifin){
			i++;
			s = fil[i];
			it = aps.get(s);
			t = fs.get(it);

			while(t > 0){
				if(dist[t] == -1){
					j++;
					fil[j] = t;
					dist[t] = k;
				}
				t = fs.get(++it);
			}
		}
		
	}
	
	return dist;
 
}

public void calcul_distance(Graphe g) {
	int n = g.Aps_Get(0);
	
	int[][] Mat_dist = new int[n+1][n+1];
	Mat_dist[0][0] = n;
	
	for(int i = 0;i < n;i++) {
		for(int j = 0;j < n;j++) {
			Mat_dist[i][j] = 0;
		}
	}
	
	for(int i = 1;i <= n;i++) {
		Mat_dist[i] = descente_largeur(i,g.getFs(),g.getAps());
	}
	
	String str = "";
	str += "------------Matrice des distances-------------\n";
	for(int a = 0;a < Mat_dist.length;a++){
		str += "| ";
		for(int b = 0;b < Mat_dist[a].length;b++){
			str += Mat_dist[a][b] + "\t";
		}
		str += "|\n";
	}
	System.out.println(str);
	
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

	for(int i = 0;i <= n;i++){
		pilch.add(i,0);	
	}
	rang.add(0,n);

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
				ddi.set(t,ddi.get(t)-1);
				if(ddi.get(t) == 0){
					empiler(t, pilch);
				}

				h++;
				t = FS.get(h);
			}

			s = pilch.get(s);
		}

		s = pilch.get(0);
		prem.add(k+1,s);
	}

	return rang;
}




public void Prufer_decode (ArrayList<Integer> t){
	int m = t.get(0), n = m+2;
	ArrayList<Integer> s = new ArrayList<Integer>(n+1);
	for (int i = 1; i <= n; i++) 
	{
		s.set(i, 0);
	}
	for (int i = 1; i <= m; i++) 
	{
		s.set(t.get(i), s.get(t.get(i))+1);
	}
	for (int k = 1; k <= m; k++)
	{
		for (int i = 1; i <= n; i++)
		{
			if (s.get(i) == 0)
			{
				System.out.println('['+Integer.valueOf(t.get(k))+' '+Integer.valueOf(i)+']');
				s.set(t.get(k), s.get(t.get(k))+1);
				s.set(i, -1);
				break;
			}
		}
	}
	System.out.print("[ ");
	for (int i = 1; i <= n; i++)
	{
		if ( s.get(i) == 0 )
			System.out.print(Integer.valueOf(i) + " ");
	}
	System.out.print(" ]");
}


public void Prufer_encode (ArrayList<Integer> prf, Graphe G) {
	
	int n = G.Matrice_Get(0, 0);
	prf = new ArrayList<Integer>(n-1) ; 
    
	prf.set(0, n-2 ) ;

	int k = 1;
	while (k <= n-2)
	{	int i = 1;
		for (; G.Matrice_Get(i, 0) != 1; i++);
		int j=1;
		for (; G.Matrice_Get(i, j) != 1; j++);
		prf.set(k++, j) ;
		
		G.Matrice_set(i, j, 0);
		G.Matrice_set(j, i, 0);
		G.Matrice_set(i, 0, 0);
		G.Matrice_set(j, 0, 0);
	
	}
} 


public void Dikjstra( int  s , Graphe G ,  ArrayList<Integer> predecesseur , ArrayList<Integer> distance)
{
	int ind; 
	int i, j = s, k, v ;
	int n = G.Aps_Get(0) ;
	int m = G.Fs_Get(0)-n  ;
	
		ArrayList<Boolean> inS = new ArrayList<Boolean>(n+2) ; 
		for ( i =0 ; i <= n ; i++) {
			predecesseur.add(s) ; 
			inS.add(false) ; 
			distance.add(G.cout_Get(s, i) ) ; 
			
		}
		distance.set(s, 0) ; 
		predecesseur.set(s, 0) ; 
		inS.set(s, true) ;
		ind = n -1 ; 
		
		
		while(ind > 0) {
		
			m = MAXPOIDS;
			for (i=1;i<=n;i++)
				if (inS.get(i) == false ) 
				if (distance.get(i) < m)
				{
					m = distance.get(i) ;
					j = i;
				}
			
			
			if (m == MAXPOIDS) return;

			inS.set(j , true) ;
			ind--;
			k = G.Aps_Get(j) ;
			
			while(G.Fs_Get(k) != 0)
			{   
				int fs_K = G.Fs_Get(k) ;
				if ( inS.get(fs_K ) == false )
				{
					v = distance.get(j) + G.cout_Get(j, fs_K) ; 

					if (v < distance.get(fs_K))
					{
						
						
						distance.set(fs_K , v) ; 
					 	predecesseur.set(fs_K, j) ; 
					
					}
				}
				k++;
				
			}
			
			
		 	
			
		}
		System.out.print("\n distance : ");
		affiche_tab(distance); 
		
		System.out.print("    pred : ");
		affiche_tab(predecesseur); 
		System.out.print("     ins : ");
		affiche_tab_b(inS);
}
public void affiche_tab(ArrayList<Integer> v) {
	System.out.print("|");
	for(int i = 1;i < v.size();i++){
		System.out.print(v.get(i)  + "|");
      
    }
}
public void affiche_tab_b(ArrayList<Boolean> v) {
	System.out.print("|");
	for(int i = 1;i < v.size();i++){
		System.out.print(v.get(i)  + "|");
      
    }
}
	public void Dantzig(int[][] c){
		int n = (c[0][0]);
        int i,j,k;
        int x;

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
	private int newP;
	public void traversee(int s, int p,int k, Graphe g, ArrayList<Integer>num, ArrayList<Integer>ro,
			ArrayList<Boolean>entarj, ArrayList<Integer>tarj,
			ArrayList<Integer>pred, ArrayList<Integer>prem,
			ArrayList<Integer>pilch, ArrayList<Integer>cfc)
		{
			 int t;
			p++;
			 System.out.println("p1 : " + p);
			 num.set(s, p); 
			 ro.set(s, p);	 	 // numérote s et initialise ro[s]
			 tarj.add(s);
			 System.out.println("tarj.add(s) : " + s);
			 entarj.set(s, true);
			 for (int r=g.Aps_Get(s); (t=g.Fs_Get(r)) != 0 ; r++)
			 { 	//System.out.println("t : " + t);
				if (num.get(t) == 0)	 	 	 // si t n'est pas encore numéroté
			 	{ 	pred.set(t, s);
					System.out.println("traverse bis " + t);
					System.out.println("p2 : " + p);
			 		traversee(t,p,k, g, num, ro, entarj, tarj, pred, prem, pilch, cfc);
					System.out.println("ptrav : " + p);
					newP = p;
			 		if (ro.get(t) < ro.get(s)) 
			 			ro.set(s, ro.get(t)) ;	 	 	 // Z1
			 	}
			 	else
			 	{ if ((num.get(t) < ro.get(s)) && entarj.get(t)) 
			 		ro.set(s, num.get(t));// Z2
			 	}
			}
			 //k = 0;
			 System.out.println("p3 : " + p);
			 p = newP;
			 if (ro.get(s) == num.get(s))
			 {
				k++;	
				int last;
				do
				{	 	 	 	 	 	 	 	 	 // Z3
					System.out.print("tarj : ");
					System.out.print("|");
					for(int i = 0;i < tarj.size();i++){
						System.out.print(tarj.get(i)  + "|");
					
					}
					System.out.print("\n"); 
					last = tarj.get(tarj.size()-1);
					entarj.set(last,false);
					empiler(last,pilch);
					cfc.set(last,k);
					tarj.remove(tarj.size()-1);
					System.out.println("p : " + p);
				} while (last != s);

				 prem.add(k, pilch.get(0));
				 pilch.set(0, 0);
				 System.out.println("p4 : " + p);
			}

			System.out.println("---------------TEST----------------");
			System.out.print("cfc : ");
			affiche_tab(cfc);
			System.out.print("\n");
			System.out.print("num : ");
			affiche_tab(num);
			System.out.print("\n");
			System.out.print("ro : ");
			affiche_tab(ro);
			System.out.print("\n");
			System.out.print("pred : ");
			affiche_tab(pred);
			System.out.print("\n");
			System.out.print("prem : ");
			affiche_tab(prem);
			System.out.print("\n");
			System.out.print("pilch : ");
			affiche_tab(pilch);
			System.out.print("\n");
			System.out.print("tarj : ");
			System.out.print("|");
			for(int i = 0;i < tarj.size();i++){
				System.out.print(tarj.get(i)  + "|");
			}
			System.out.print("\n"); 
			System.out.print("entarj : ");
			affiche_tab_b(entarj);
			System.out.print("\n");
			System.out.println("------------------------------------");
		}
	
	public void fortconnexe(Graphe g)
	{
		int n = g.Aps_Get(0);
		ArrayList<Integer> prem = new ArrayList<Integer>(n+1);
		prem.add(0,n);
		ArrayList<Integer> pilch = new ArrayList<Integer>(n+1);
		for(int i = 0;i <= n;i++){
			pilch.add(i,0);	
		}
		ArrayList<Integer> cfc = new ArrayList<Integer>(n+1);
		cfc.add(0,n);
		ArrayList<Integer> pred = new ArrayList<Integer>(n+1);
		pred.add(0,n);
		ArrayList<Integer>tarj = new ArrayList<Integer>();
		ArrayList<Boolean>entarj = new ArrayList<Boolean>(n+1);
		entarj.add(0,true);
		ArrayList<Integer>num = new ArrayList<Integer>(n+1);
		num.add(0,n);
		ArrayList<Integer>ro = new ArrayList<Integer>(n+1);
		ro.add(0,n);
		int p = 0;
		int k = 0;
		for (int i = 1; i<=n; i++)
		{
			num.add(i, 0);
			pred.add(i, 0);
			ro.add(i, 0);
			entarj.add(i, false);
			cfc.add(i,i);
		}
		
		for(int s = 1; s <= n; s++){
			if (num.get(s) == 0) 
			{
				System.out.println("traverse " + s);
			 	traversee(s,p,k,g,num,ro, entarj, tarj, pred, prem, pilch, cfc);
			}
		}
		prem.set(0, k);

		System.out.print("cfc : ");
		affiche_tab(cfc);
		System.out.print("\n");
		System.out.print("num : ");
		affiche_tab(num);
		System.out.print("\n");
		System.out.print("ro : ");
		affiche_tab(ro);
		System.out.print("\n");
		System.out.print("pred : ");
		affiche_tab(pred);
		System.out.print("\n");
		System.out.print("prem : ");
		affiche_tab(prem);
		System.out.print("\n");
		System.out.print("pilch : ");
		affiche_tab(pilch);
		System.out.print("\n");
		System.out.print("tarj : ");
		affiche_tab(tarj);
		System.out.print("\n");
		System.out.print("entarj : ");
		affiche_tab_b(entarj);
		System.out.print("\n");
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
		int nb = br.get(0); // Nombre de CFC de l�unique base du graphe r�duit
		ArrayList<Integer>Base = new ArrayList<Integer>(nb+1); // pile qui m�morise les sommets des bases du graphe initial
		Base.set(0, nb);
		int p = 1;
		int som = prem.get(br.get(1)); // premier sommet de la premi�re CFC
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
		 	 	 	 	 	 //sommets d�une base du graphe initial
		 	 	 {
		 	 		String str = "";
		 			str += "------------Tarjan : edition des bases-------------\n";
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

	public void ordonnancementt( ArrayList<Integer> fp,ArrayList<Integer> app,ArrayList<Integer> d, ArrayList<Integer> fpc, ArrayList<Integer> appc, ArrayList<Integer> lc ){
		int n = app.get(0);
		int m = fp.get(0);
		fpc = new ArrayList<>(m+1);
		appc = new ArrayList<>(n+1);
		appc.add(0,n) ;
		lc = new ArrayList<>(n+1);
		lc.set(0,n);

		int kc,t,lg;

		lc.set(1,0);
		fpc.set(1,0);
		appc.set(1,1);

		kc=1;
		for(int s=2; s<=n;s++){
			lc.set(s,0);
			appc.set(s,kc+1);
			for(int k= app.get(s); (t=fp.get(k))!=0; k++){
				lg= lc.get(t) + d.get(t);
				if(lg> lc.get(s)){
					if(lg>lc.get(s)){
						lc.set(s,lg);
						kc = appc.get(s);
						fpc.set(kc,t);
					}
					else{
						kc++;
						fpc.set(kc,t);
					}
				}
			}kc++;
			fpc.set(kc,0);
		}
		fpc.set(0,kc);

		//faire affichage
	}

	public void fusionner(int i, int j, ArrayList<Integer> prem, ArrayList<Integer> pilch, ArrayList<Integer> cfc, ArrayList<Integer> nbElem){
		if(nbElem.get(i)<nbElem.get(j)){
			int aux = i;
			i=j;
			j=aux;
		}

		int s = prem.get(j);
		cfc.set(s,i);
		while(pilch.get(s)!=0){
			s= pilch.get(s);
			cfc.set(s,i);
		}

		pilch.set(s, prem.get(i));
		prem.set(i,j);
		nbElem.add(i,j);
	}

	/*public void kruskal(Graphe g, Graphe t,ArrayList<Integer> prem, ArrayList<Integer> pilch, ArrayList<Integer> cfc, ArrayList<Integer> nbElem){
		int n= g.nombre_sommets()-1;
		int x,y;
		int i=0,j =0;
		t = new ArrayList<>(n-1);
	}
	
	 */



	//----------------------------------Kruskal-------------------------------


	/*
	 
    public Graphe(int[][] matriceAdjacente){
        for(int i=0; i< matriceAdjacente.length;i++){
            for(int j=0; j<matriceAdjacente.length; j++){
                this.matriceAdjacente[i][j]= matriceAdjacente[i][j];
            }
        }
        int n = matriceAdjacente[0][0];
        int m = matriceAdjacente[0][1];
         int fs[] = new int[n+m];
         int aps[] = new int[n];
         matrineToFs(fs,aps,matriceAdjacente);
    }
    public Graphe(int []fs, int[] aps){
      for(int i=0; i<fs.length;i++){
          this.fs[i]=fs[i];
      }
        for(int i=0; i<aps.length;i++){
            this.aps[i]=aps[i];
        }
        int matriceAdjacente [][]= new int[aps[0]+1][aps[0]+1];
        fsToAps(fs,aps,matriceAdjacente);
    }
    public Graphe(){
        this.aps=null;
        this.fs=null;
        this.matriceAdjacente=null;
    }
    public void scan(){
    }
    public void fsToAps(int[] fs, int aps[], int[][] matrice){
        int k;
        int nbSommet = aps[0];
        int nbArc = fs[0] - nbSommet;
        matrice = new int[nbSommet + 1][];
        for(int i = 0; i<= nbSommet; i++){
            matrice[i]= new int[nbSommet+1];
        }
        matrice[0][0] = nbSommet;
        matrice[0][1] = nbArc;
        for(int i =1; i<=nbSommet; i++){
            for(int j=1; j<=nbSommet; j++){
                matrice[i][j] =0;
            }
        }
        for(int i=1; i<=nbSommet; i++){
            //for(k= aps[i]; (j=fs[k] )!= 0; k++){
                //matrice[i][j] = 1;}
            k= aps[i];
            while(fs[k] != 0){
                matrice[i][fs[k]] =1;
                k++;
            }
        }
    }
    public void matrineToFs(int[] fs, int aps[], int[][] matrice){
        int nbSommet = matrice[0][0];
        int nbArc = matrice[0][1];
        aps = new int[nbSommet+1];
        aps[0] = nbSommet;
        fs = new int [nbSommet+nbArc+1];
        aps[0]=nbSommet;
        fs[0] = nbSommet+nbArc;
        int k = 1;
        for(int i=1; i<= nbSommet; i++){
            aps[i] =k;
            for(int j=1; j<=nbSommet; j++){
                if(matrice[i][j]!=0){
                    fs[k++] =j;
                }
            }
            fs[k++]=0;
        }
    }
    public void affiche(){}
    public int[] descente(int r,int[] aps,int[] fs,int[] dist){
        
        int nb_som = aps[0];
        int i = 0,j = 1,k = 0,ifin,s,t,it;
        int[] fil = new int[nb_som+1];
        fil[0] = nb_som;
        fil[1] = r;
        dist = new int[nb_som + 1];
        dist[0] = nb_som;
        for(int h = 1;h <= nb_som;h++)
            dist[h] = -1;
        
        dist[r] = 0;
        while(i < j){
            k++;
            ifin = j;
            while(i < ifin){
                i++;
                s = fil[i];
                it = aps[s];
                t = fs[it];
                while(t > 0){
                    if(dist[t] == -1){
                        j++;
                        fil[j] = t;
                        dist[t] = k;
                    }
                    t = fs[++it];
                }
            }
        }
        return dist;
    }
    // Regarder comment on peut l'adapter � la matrice d'adjacence
    public int[][] calcul_distnace(int[] fs,int[] aps,int[][] dist){
        int n = aps[0];
        dist = new int[n+1][n+1];
        for(int i = 1;i <= n;i++){
            descente(i,fs,aps,dist[i]);
        }
        dist[0] = new int[1];
        dist[0][0] = n;
    	return dist; 
    }
    public void det_ddi(int[] aps,int[] fs,int[] ddi){
        int n = aps[0];
        ddi[0] = n;
        for(int i = 1;i <= n;i++)
            ddi[i] = 0;
        
        for(int i = 1;i < fs[0];i++){
            if(fs[i] != 0){
                ddi[fs[i]]++;
            }
        }
    }
    public void empiler(int x,int[] pilch){
        pilch[x] = pilch[0];
        pilch[0] = x;
    }
    public void ddiNul(int[] ddi,int x,int[] pilch){
        if(ddi[x] == 0)
            empiler(x,pilch);
    }
    //Regarder comment calculer le rang avec la matrice d'adjacence
    public int[] rang(int[] rang,int[] fs,int[] aps){
        
        int n = aps[0];
        int s,k,h,t;
        int[] pilch = new int[n+1];
        int[] prem = new int[n+1];
        int[] ddi = new int[n+1];
        det_ddi(aps, fs, ddi);
        pilch[0] = 0;
        for(s = 1;s <= n;s++){
            rang[s] = -1;
            ddiNul(ddi, s, pilch);
        }
        k = -1;
        s = pilch[0];
        prem[0] = s;
        while(pilch[0] > 0){
            k++;
            pilch[0] = 0;
            while(s > 0){
                rang[s] = k;
                h = aps[s];
                t = fs[h];
                while(t > 0){
                    ddi[t]--;
                    ddiNul(ddi, t, pilch);
                    h++;
                    t = fs[h];
                }
                s = pilch[s];
            }
            s = pilch[0];
            prem[k+1] = s;
        }
        return rang;
    }
    public Graphe Tarjan(){
     	return null ; 
    }
    public void ordonnacement(){}
    public void Dijkstra(){}
    public void Dantzig(){}
    public void Prufer(){}
    */
}

