package Class;
import java.util.ArrayList;



public  class Graphe {
	
	private int[][] matrice;
	 private ArrayList<Sommet> listeSommet = new ArrayList<Sommet>();
	private boolean avec_Poids ; 
	private ArrayList<Integer> fs = new  ArrayList<Integer>();
	private ArrayList<Integer> aps =  new  ArrayList<Integer>();
	private boolean est_oriente ;
	private int valeur_interdite = 999 ; 
	//-------------------CONSTRUCTEUR------------------------
	/*
	 * on peut constuir un graphe vide et on ajoute des sommets
	 * on peut avoir deja la matrice 
	 * on peut avoir fs et aps 
	 * on peut avoir une liste de sommets 
	 * */
	public Graphe(int[][] matrice ,boolean est_oriente, boolean avec_Poids    ) {
		int ligne = matrice.length ; 
		int colonne = matrice[0].length ; 
		this.matrice = new int[ligne][colonne] ; 
		
		for( int i = 0 ; i<ligne ; i++ ) {
			for(int j =0 ; j<colonne ; j++)
			{ 
				this.matrice[i][j] = matrice[i][j] ; 
			}
		}
		this.avec_Poids = avec_Poids; 
		this.est_oriente = est_oriente; 
		this.listeSommet.add(null) ; // la case 0 vide 
		// matrcie to fs 
		
	}

	public Graphe(ArrayList<Integer> aps ,ArrayList<Integer> fs ) {
		//this fs ; 
		//fs to matrice 
		
	}
	
	public Graphe( boolean est_oriente ) {
		this.est_oriente = est_oriente ; 
		 Generer_matrice(0 , false ); 
		 //generer fs 
		 Matrice_to_fs_aps() ; 
	}
	
	
	//-------------------Fin CONSTRUCTEUR------------------------
	
	
	
	//------- Methods de la matrice  ---------------------------
	
	public void  Generer_matrice(int n , boolean avec_Poids ){
	
		int taille_matrice = n+2 ; //ligne de  0  
		this.matrice = new int[taille_matrice][taille_matrice] ; 
		this.matrice[0][0] = n ; 

		int val ; 
		//cas de matrice des cout initialiser a 
		if( avec_Poids)
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
	
	public void ajouterSommet(Sommet s) {
		int taille = nombre_sommets() +1  ; 
		taille++ ; 
		
	
		listeSommet.add(s) ; 
		
		//System.out.println(listeSommet.get(listeSommet.size()-1).toString()) ;

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
		//TODO METTRE A JOURS FS ET APS 
	}
	/**
	 * PERMET DE SAVOIR LA NUM DE SOMMETS EXEMPLE LE PREMIER LE DEUXIEME ... 
	 * LE PREMIER SOMMETS EST DANS LA CESE 0, AFIN DE FACILITER LA TACHE ON A FAIT UN +1 POUR AVOIR LA 
	 * BONNE NUMEROTATION 
	 * **/
	public int find_position_sommets(Sommet s)
	{
		int i = 0 ; 
		while (! listeSommet.get(i).equals(s))
			i++; 
		
		return(i<listeSommet.size() ? i+1 : -1 ) ; 
		// i+1 car on commence a ajouter dans la case 0 et donc 
		//l'équvalent pou rmes sommets c'est toujours +1 sauf que pour supprimer dans ce tableau faudra fair -1 
	}
	/**
	 * AJOUTER UN ARC 
	 * ON TESTE SI LES SOMMETS EXISTE  BIEN
	 *  **/
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		
		System.out.print(	" sommet s = " + s.getId() ) ; 
		System.out.println(	" -->  sommet t = " +t.getId() ) ;
		
		//TODO METHODE SOMMETS EXISTE 
		int indiceS = find_position_sommets(s) ; 
		int indiceT = find_position_sommets(t) ; 
		if( indiceS== -1  ||  indiceT == -1  )
		return ;
		
		this.matrice[0][1] ++ ; 
		if( this.avec_Poids)
		{
			
		 matrice[indiceS][indiceT]  = val ; 
		 if( est_oriente == false )
			 matrice[indiceT][indiceS]  = val ; 
		}
		else
		{ matrice[s.getId()][t.getId()]  = 1 ; 
		 if(est_oriente == false )
			 matrice[indiceT][indiceS]  = 1 ; 
		}	 
		//TODO mettre a jours fs et aps 
	}
	
	/**
	 * PERMETS DE SUPPRIMER UN SOMMETS 
	 * **/
	public void supprimerSommet(Sommet s)
	{
		int indiceS = find_position_sommets(s) ; 
		System.out.println("position du sommets " +indiceS ) ; 
		//TODO EXISTE UN SOMMET 
		if( indiceS== -1   )
		return ;
		// attention ici faut le bon indice c'est a dire -1 
		listeSommet.remove(indiceS-1) ; 
		
		int[][] mat = new int[matrice.length-1][matrice[0].length-1];
		
		for(int i=0; i<indiceS; ++i)
		{
			for(int j=0; j<indiceS; ++j)
			{
				mat[i][j] = matrice[i][j];
			}
			for(int j=indiceS+1; j<matrice.length ; ++j)
			{
				mat[i][j-1] = matrice[i][j];
			}
		}
		for(int i=indiceS+1; i<matrice.length; ++i)
		{
			for(int j=indiceS+1; j<indiceS; ++j)
			{
				mat[i-1][j-1] = matrice[i][j];
			}
			for(int j=indiceS+1; j<matrice.length; ++j)
			{
				mat[i-1][j-1] = matrice[i][j];
			}
		}
		mat [0][0] --;
		//TODO mettre ajours le nombre d arc 
		
		//Pensez vous faire  un clone ? 
		matrice = mat;
	}
	
	public int nombre_sommets() {
		return matrice[0][0] ; 
		}
	/**
	 * nOMBRE D ARC  **/
	public int nombre_de_arc() {
		return matrice[0][1] ; 
		}
	/**
	 * SI UN ARC EXISTE ENTRE S ET T **/
	 public boolean existeArc(Sommet s,Sommet t){
		  int indiceS = find_position_sommets(s) ; 
			int indiceT = find_position_sommets(t) ;
			
			if( indiceS== -1  ||  indiceT == -1  )
				return false ; 
			
				if( this.avec_Poids)
					return ( matrice[indiceS][indiceT] != valeur_interdite) ; 
				
				else 
					return (matrice[indiceS][indiceT] != 0 )  ; 
	       

	    }
	 /**
	  * ENLEVER UN ARC ENTRE S ET T 
	  * LE CAS OU LE GRAPHE EST PAS ORIENTER EST BIEN TRAITER 
	  * **/
	  public  void enleverArc(Sommet s, Sommet t) {
			System.out.print(	" sommet s = " + s.getId() ) ; 
			System.out.println(	" -->  sommet t = " +t.getId() ) ;
			
			  int indiceS = find_position_sommets(s) ; 
				int indiceT = find_position_sommets(t) ;
				
				if( indiceS== -1  ||  indiceT == -1  )
					{return  ;
					}
				else 
				{	this.matrice[0][1] -- ; 
			if( this.avec_Poids)	
				 matrice[indiceS][indiceT] = valeur_interdite ; 
			
			else 
				matrice[indiceS][indiceT] = 0   ; 
				}
				
		}
	//TODO fs et aps to matrice 
	/**
	 * GENERER FS ET APS A PARTIRE D4UNE MATRICE 
	 * 
	 * **/
	public void  Matrice_to_fs_aps() {
		
		
		
		int n = nombre_sommets() ;
	
		int m = nombre_de_arc()  ; 
		
		fs = new ArrayList<Integer>(n+m+1) ; 
		aps = new ArrayList<Integer>(n+1) ; 
		
		if(n >0 )
		{
			aps.add(0,n); // aps 
			fs.add(0,n+m) ; //fs
		int k = 1 ; 
		for( int i = 1 ; i <= n ; i++) {
			aps.add(i, k ); //aps
			for( int j = 1 ; j <= n; j++) {
				
				if(matrice[i][j] != 0)
					{
					fs.add(k,j) ;  // fs[k] = j ;
					++k ; 
					}
				
			}
			
			fs.add(k,0) ; ;//fs 
			++k ;
		}
		}
		
	}
	//------- Fin Methods ---------------------------
	
	//-------  Methods affichage  ---------------------------
	/**
	 * AFFICHAGE D4UN GRAPHE A REVOIR POUR SAVOIR QUOI AFFICHER EXACTEMENT **/
	public void afficher()
	{
		if( est_oriente )
		System.out.print(" votre graphe est orienté \n "  ); 
		System.out.print(this.toString()  ); 
		
	}
	  public String toString(){
	        String str = "--------fs & aps ---------- \n";

	        str += "FS : |";
	        for(int i = 1;i < fs.size();i++){
	            str += fs.get(i) + "|";
	        }
	        
	        str += "\nAPS : |";

	        for(int i = 1;i < aps.size();i++){
	            str += aps.get(i) + "|";
	        }
	        
	    	String Smatrice = "--------matrice  ---------- \n " ; 
			 
			
			for( int i = 0 ; i< matrice.length ; i++ ) {
				Smatrice += "| " ; 
				for(int j = 0 ; j< matrice[i].length ; j++)
				{
					Smatrice += this.matrice[i][j] +" " ; 
				}
				Smatrice += "|\n " ; 
			}
			String ListeSommets = "\n --------Sommets  ---------- \n " ; 
			for(int i = 0;i < listeSommet.size();i++){
				ListeSommets += listeSommet.get(i).toString() + "|";
	        }
	        
	       // return str + "\n" + Smatrice ;
			return Smatrice + ListeSommets; 
	    }
	
	
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

    // Regarder comment on peut l'adapter Ã  la matrice d'adjacence
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
