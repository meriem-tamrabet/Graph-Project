package Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Algorithme {

	private int MAXPOIDS =100 ;

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
		int n = g.getApsElem(0);
		
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
		
		int n = G.getMatriceElem(0, 0);
		prf = new ArrayList<Integer>(n-1) ; 
		
		prf.set(0, n-2 ) ;

		int k = 1;
		while (k <= n-2)
		{	int i = 1;
			for (; G.getMatriceElem(i, 0) != 1; i++);
			int j=1;
			for (; G.getMatriceElem(i, j) != 1; j++);
			prf.set(k++, j) ;
			
			G.setMatriceElem(i, j, 0);
			G.setMatriceElem(j, i, 0);
			G.setMatriceElem(i, 0, 0);
			G.setMatriceElem(j, 0, 0);
		
		}
	} 


	public void Dijkstra( int  s , Graphe G ,  ArrayList<Integer> predecesseur , ArrayList<Integer> distance)
	{
		int ind; 
		int i, j = s, k, v ;
		int n = G.getApsElem(0) ;
		int m = G.getFsElem(0)-n  ;
		
			ArrayList<Boolean> inS = new ArrayList<Boolean>(n+2) ; 
			for ( i =0 ; i <= n ; i++) {
				predecesseur.add(s) ; 
				inS.add(false) ; 
				distance.add(G.getCout(s, i) ) ; 
				
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
				k = G.getApsElem(j) ;
				
				while(G.getFsElem(k) != 0)
				{   
					int fs_K = G.getFsElem(k) ;
					if ( inS.get(fs_K ) == false )
					{
						v = distance.get(j) + G.getCout(j, fs_K) ; 

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

		String str = "";
		str += "------------Dantzig : Matrice initiale-------------\n";
		for(int a = 0;a < c.length;a++){
			str += "| ";
			for(int b = 0;b < c[a].length;b++){
				str += c[a][b] + "\t";
			}
			str += "|\n";
		}
		System.out.println(str);

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

		str = "";
		str += "------------Dantzig : Matrice finale-------------\n";
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

	public void traverse(int s, int p,int k, Graphe g, ArrayList<Integer>num, ArrayList<Integer>ro,
			ArrayList<Boolean>entarj, ArrayList<Integer>tarj,
			ArrayList<Integer>pred, ArrayList<Integer>prem,
			ArrayList<Integer>pilch, ArrayList<Integer>cfc)
		{
			 int t;
			p++;
			 num.set(s, p); 
			 ro.set(s, p);	 	 // numérote s et initialise ro[s]
			 tarj.add(s);
			 entarj.set(s, true);
			 for (int r=g.getApsElem(s); (t=g.getFsElem(r)) != 0 ; r++)
			 { 	
				if (num.get(t) == 0)	 	 	 
			 	{ 	pred.set(t, s);
			 		traverse(t,p,k, g, num, ro, entarj, tarj, pred, prem, pilch, cfc);
			 		if (ro.get(t) < ro.get(s)) 
			 			ro.set(s, ro.get(t)) ;	 	 	 // Z1
			 	}
			 	else
			 	{ if ((num.get(t) < ro.get(s)) && entarj.get(t)) 
			 		ro.set(s, num.get(t));// Z2
			 	}
			}

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
				} while (last != s);

				 prem.add(k, pilch.get(0));
				 pilch.set(0, 0);
			}

			System.out.println("---------------Affichage intermediaire----------------");
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
	
	public void Tarjan(Graphe g)
	{
		int n = g.getApsElem(0);
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
			 	traverse(s,p,k,g,num,ro, entarj, tarj, pred, prem, pilch, cfc);
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

	public void graphe_reduit (ArrayList<Integer>prem,ArrayList<Integer>pilch,ArrayList<Integer>cfc,ArrayList<Integer>fs, 
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
	
	//------------------------------------------------end Tarjan------------------------------------------------------

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

		//TODO faire affichage
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




}

