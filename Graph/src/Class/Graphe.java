package Class;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Affichage.dessinGraphe;
import Affichage.dijkstra;

public  class Graphe {
	
	private int[][] matrice;
	private int[][] matrice_cout;
	
	private ArrayList<Sommet> listeSommet = new ArrayList<Sommet>();
	
	private ArrayList<Integer> fs = new  ArrayList<Integer>();
	private ArrayList<Integer> aps =  new  ArrayList<Integer>();
	
	private boolean avec_Poids ; 
	private boolean est_oriente ;
	
	private int valeur_interdite = 999 ; 
	//-------------------CONSTRUCTEUR------------------------
	/*
	 * on peut constuir un graphe vide et on ajoute des sommets
	 * on peut avoir deja la matrice 
	 * on peut avoir fs et aps 
	 * on peut avoir une liste de sommets 
	 * */
	public Graphe(int[][] matrice ,boolean est_oriente, boolean avec_Poids) {
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

	public Graphe(ArrayList<Integer> aps ,ArrayList<Integer> fs, boolean est_oriente) {
		//this fs ; 
		//fs to matrice
		int tailleFs = fs.size();
		int tailleAps = aps.size();

		this.aps = new ArrayList<Integer>(tailleAps);
		this.fs = new ArrayList<Integer>(tailleFs);

		for(int i=0; i<tailleFs; i++){
			this.fs.add(i,fs.get(i));
		}

		for(int i=0; i<tailleAps; i++){
			this.aps.add(i,aps.get(i));
		}

		this.listeSommet.add(null);// la premiere case (0) est vide,
		//la taille de fs y est stocké

		this.est_oriente = est_oriente;
		this.avec_Poids=false;

		fs_apsToMatrice();

	}


	//constructeur par defaut a ne pas toucher !
	public Graphe( boolean est_oriente, boolean avec_poids) {
		this.est_oriente = est_oriente ; 
		this.avec_Poids = avec_poids ; 
		 Generer_matrice(0 , this.avec_Poids );
		 Matrice_to_fs_aps() ;
	}
	
	
	//-------------------Fin CONSTRUCTEUR------------------------
	
	public boolean isAvec_Poids() {
		return avec_Poids;
	}

	public boolean isEst_oriente() {
		return est_oriente;
	}
	
	
	
	//------- Methods de la matrice  ---------------------------
	

	public void  Generer_matrice(int n , boolean avec_Poids ){
	
		int taille_matrice = n+2 ; //ligne de  0  
		this.matrice = new int[taille_matrice][taille_matrice] ; 
		 
		this.matrice[0][0] = n ; 

		int val = 0  ; 
	//TODO Ameliorer le remplisage 
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
		if(avec_Poids == true ) Generer_m_cout(n) ; 
		
	}
	public void  Generer_m_cout(int n ){
		
		int taille_matrice = n+2 ; //ligne de  0  
		
		this.matrice_cout = new int[taille_matrice][taille_matrice] ;
		
		this.matrice_cout[0][0] = n ; 

		
	//TODO Ameliorer le remplisage 
		if( n> 0 )
			this.matrice_cout[0][1] = 0 ;
		
		for( int i = 2 ; i< taille_matrice ; i++ )
			this.matrice_cout[0][i] = valeur_interdite ;
		
	
		
		for( int i = 1 ; i<taille_matrice ; i++ ) {
			for(int j = 0 ; j<taille_matrice ; j++)
			{ 
				this.matrice_cout[i][j] = valeur_interdite ; 
			}
		}
		
	}

	public void genere_fsAps(int n){

		int tailleFs= n+1; // +1 pour la case 0
		int tailleAps= n+1;
		this.fs = new ArrayList<Integer>(tailleFs);
		this.aps = new ArrayList<Integer>(tailleAps);

		this.fs.add(0,n); // n+m mais m =0
		this.aps.add(0,n);

		int val =0;
		for(int i=1; i<tailleFs;i++){
			this.fs.add(i,val);
		}

		for(int i=1; i<tailleAps;i++){
			this.aps.add(i,val);
		}

	}
	
	  //----------------------------fin methode Graphe ---------------------------------------
	
	public void ajouterSommet(Sommet s) {
		int taille = nombre_sommets() +1  ; 
		taille++ ;
		listeSommet.add(s) ; 
		

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
		
		
		
		if(this.avec_Poids == true )
			{update_ajout_s_cout();
			
			}
		
		Matrice_to_fs_aps();

	}
	/**
	 * PERMET DE SAVOIR LA NUM DE SOMMETS EXEMPLE LE PREMIER LE DEUXIEME ... 
	 * LE PREMIER SOMMETS EST DANS LA CASE 0, AFIN DE FACILITER LA TACHE ON A FAIT UN +1 POUR AVOIR LA
	 * BONNE NUMEROTATION 
	 * **/
	public int find_position_sommets(Sommet s)
	{
		int i = 0 ; 
		while (! listeSommet.get(i).equals(s))
			i++; 
		
		return(i<listeSommet.size() ? i+1 : -1 ) ; 
		// i+1 car on commence a ajouter dans la case 0 et donc 
		//l'�quvalent pou rmes sommets c'est toujours +1 sauf que pour supprimer dans ce tableau faudra fair -1 
	}
	/**
	 * AJOUTER UN ARC 
	 * ON TESTE SI LES SOMMETS EXISTE  BIEN
	 *  **/
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		
		
		
	
		int indiceS = find_position_sommets(s) ; 
		int indiceT = find_position_sommets(t) ; 
		if( indiceS== -1  ||  indiceT == -1  )
		return ;
		
		this.matrice[0][1] ++ ; 
		 matrice[indiceS][indiceT]  = 1 ; 
		 
		 if( est_oriente == false )
		 { matrice[indiceT][indiceS]  = 1 ; 
		 this.matrice[0][1] ++ ; 
		 }
		
		if( this.avec_Poids)
		{
			
		
			 this.matrice_cout[indiceS][indiceT]  = val; 
			 this.matrice_cout[0][1] = this.matrice[0][1] ; 
			 if( est_oriente == false )
				 matrice_cout[indiceT][indiceS]  = val ; 
	
		}
		 
		
		Matrice_to_fs_aps();
	}
	
	/**
	 * PERMETS DE SUPPRIMER UN SOMMETS 
	 * **/
	public void supprimerSommet(Sommet s)
	{
		int indiceS = find_position_sommets(s) ; 
		
		
		
		int[][] mat = new int[matrice.length-1][matrice[0].length-1];
		
		
		if( indiceS== -1   )
		return ;
		
		 update_supp_s_cout(indiceS) ;
		
		listeSommet.remove(indiceS-1) ; 
		
		
		
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
		//colone ? 
		matrice = mat;
		matrice[0][1]  = update_arc() ; 
		matrice_cout[0][1] = matrice[0][1]  ; 
		
		//TODO mettre ajours si le graphe est orienter faut enlever de sommet t a sommets s 
		
		

		Matrice_to_fs_aps();
		// mettre a jours le nombre d'arc 
	
		//TODO METTRE A JOURS MATRICE COUT
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
			
			
			  int indiceS = find_position_sommets(s) ; 
				int indiceT = find_position_sommets(t) ;
				
				if( indiceS== -1  ||  indiceT == -1  )
					{return  ;
					}
				else 
				{	this.matrice[0][1] -- ; 
			
				matrice[indiceS][indiceT] = 0   ; 
				if (this.avec_Poids)
					matrice_cout[indiceS][indiceT] = valeur_interdite   ; 
					this.matrice_cout[0][1] -- ; 
				}
			Matrice_to_fs_aps();
		}
//----------------------------fin methode Graphe ---------------------------------------

	  //TODO fs et aps to matrice 
	/**
	 * GENERER FS ET APS A PARTIR D4UNE MATRICE
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
	
//---------------methodes FS et APS ------------------------------
	public void fs_apsToMatrice(){
		int n = nombreSommetsAps();
		this.matrice = new int[n+1][n+1];

		//Nombre de sommets
		this.matrice[0][0] = n; // premiere case de la matrice= nb sommets

		//Nombre d'arcs
		this.matrice[0][1] = nombreArcFs(); // premiere ligne colone 1= nb arc

		//Matrice initialisée à 0
		for(int i = 1;i <= n;i++){
			for(int j = 1;j <= n;j++){
				this.matrice[i][j] = 0;
			}
		}

		for(int i = 1;i <= n;i++){
			for(int k = aps.get(i); fs.get(k)!=0; k++){
				this.matrice[i][fs.get(k)] = 1;
			}
		}


	}
//---------------Fin methodes FS et APS ------------------------------
//------- Fin Methods ---------------------------
//------------------------------Getter -------------------

	public  int Fs_Get(int i) {
		return fs.get(i ) ; 
	}
	public  int Aps_Get(int i) {
		return aps.get(i ) ; 
	}
	public  int Matrice_Get(int i,int j) {
		return matrice[i][j] ; 
	}
	public  int cout_Get(int i,int j) {
		return matrice_cout[i][j] ; 
	}
	public  Sommet liste_sommets_Get(int i) {
		return listeSommet.get(i) ; 
	}

	public ArrayList<Integer> getFs() { return fs;}

	public ArrayList<Integer> getAps() { return aps;}

	public int[][] getMatCout(){
		return this.matrice_cout;
	}

	public int nb_successeur(Sommet s) {
		int indiceS = find_position_sommets(s) ; 
		int co = 0  ; 
		int i = aps.get(indiceS) ; 
		while(i < fs.size() && fs.get(i)!=0 ) {
			i++ ; 
			co++ ; 
		}
		return co ; 
		
	}
	public int update_arc() {
		int co = 0 ; 
		for(int i = 0 ; i < matrice[0].length ; i++) {
			for(int j = 0 ; j < matrice[0].length ; j++) 
				if(matrice[i][j] == 1 )
					co++ ; 
		}
		return co ; 
	}
	
	public int nombre_sommets() {
		return matrice[0][0] ; 
	}


	public int nombreSommetsAps(){
		return aps.get(0);
	}

	public int nombreArcFs(){
		return fs.get(0)-nombreSommetsAps();
	}
	
	
	/**
	 * nOMBRE D ARC  **/
	public int nombre_de_arc() {
		return matrice[0][1] ; 
		}
	
	//----------------------------fin getter -----------------------------------
	//---------------Setter ---------------------------------
	public  void  Fs_set(int i, int val ) {
	 fs.set(i,val ) ; 
	}
	public  void  Aps_set(int i, int val) {
	 aps.set(i,val ) ; 
	}
	public  void Matrice_set(int i,int j, int val ) {
	 matrice[i][j] = val ; 
	}
	public  void cout_set(int i,int j , int val) {
	 matrice_cout[i][j] = val  ;
	
	}
	//------------------fin setter ----------------------------------
	
	
	//-------  Methods affichage  ---------------------------
	public void affiche_successeur(int indiceS)
	{
		
		System.out.print("successeur de "+  indiceS + "|");
			int i = aps.get(indiceS) ; 
			while((i < fs.size()) && (fs.get(i)!=0) ) {
				System.out.print(fs.get(i)+"|");
				i++ ; 
				
			}
			System.out.println();
	
	}
	/**
	 * AFFICHAGE D UN GRAPHE A REVOIR POUR SAVOIR QUOI AFFICHER EXACTEMENT **/
	public void afficher()
	{
		if( est_oriente )
		System.out.print(" votre graphe est orient� \n "  ); 
		System.out.print(this.toString()  ); 
		
	}
	public void afficher_fs_aps() {
		  String str = "--------fs & aps ---------- \n";

	        str += "FS : |";
	        for(int i = 1;i < fs.size();i++){
	            str += fs.get(i) + "|";
	        }
	        
	        str += "\nAPS : |";

	        for(int i = 1;i < aps.size();i++){
	            str += aps.get(i) + "|";
	        }
	        System.out.println(str); 
	}
	public void afficher_cout()
	{
		System.out.print(" cout  \n "  ); 
		
		String Smatrice = "--------matrice ---------- \n " ;
		 
		
		for( int i = 0 ; i< matrice_cout.length ; i++ ) {
			Smatrice += "| " ; 
			for(int j = 0 ; j< matrice_cout[i].length ; j++)
			{
				Smatrice += this.matrice_cout[i][j] + "\t" ;
			}
			Smatrice += "|\n " ; 
			
		}
		System.out.print(Smatrice  ); 
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
	        
	    	String Smatrice = "--------matrice ---------- \n " ;
			 
			
			for( int i = 0 ; i< matrice.length ; i++ ) {
				Smatrice += "|" + "\t" ; 
				for(int j = 0 ; j< matrice[i].length ; j++)
				{
					Smatrice += this.matrice[i][j]  + "\t"  ; 
				}
				Smatrice += "|\n " ; 
			}
			String ListeSommets = "\n ------Liste des sommets------ \n " ;
			/*for(int i = 0;i < listeSommet.size();i++){
				ListeSommets += listeSommet.get(i).toString() + "|";
	        }*/
	        
			// return str + "\n" + Smatrice ;
		       return   str ;

			//return Smatrice + ListeSommets+".|.|\n";
	    }
	 // --------------------------- methode cout ----------------------------- 
	public void update_ajout_s_cout() {
		
		
		int taille = nombre_sommets()   ; 
		taille++ ;
		
		int[][] N_matrice = new int[taille ][taille] ; 
		
		//recopier tt 
		for( int i = 0 ; i< taille -1   ; i++ ) {
			for(int j = 0 ; j< taille-1  ; j++)
			{
				 N_matrice [i][j] =  this.matrice_cout[i][j] ; 
			}
		}
		
		int indice = find_position_sommets(listeSommet.get(listeSommet.size()-1 )) ; 
		for(int j = 0 ; j< taille  ; j++)
		{
			 N_matrice [indice][j] = valeur_interdite ; 
			 N_matrice [j][indice] = valeur_interdite ; 
		}
		if (indice > 0 )
			 N_matrice [0][1] =  this.matrice_cout[0][1] ; 
		 N_matrice [0][0] ++; 
		 this.matrice_cout =N_matrice ; 
	}
	
	
	public void update_supp_s_cout( int indiceS ) {
		int[][] mat = new int[matrice_cout.length-1][matrice_cout[0].length-1];
		
		
		 
		if( indiceS== -1   )
		return ;
		
		for(int i=0; i<indiceS; ++i)
		{
			for(int j=0; j<indiceS; ++j)
			{
				mat[i][j] = matrice_cout[i][j];
			}
			for(int j=indiceS+1; j<matrice_cout.length ; ++j)
			{
				mat[i][j-1] = matrice_cout[i][j];
			}
		}
		for(int i=indiceS+1; i<matrice_cout.length; ++i)
		{
			for(int j=indiceS+1; j<indiceS; ++j)
			{
				mat[i-1][j-1] = matrice_cout[i][j];
			}
			for(int j=indiceS+1; j<matrice_cout.length; ++j)
			{
				mat[i-1][j-1] = matrice_cout[i][j];
			}
		}
		mat [0][0] --;
		matrice_cout =mat ; 
	}
	
	public void algorithme()
	{
		Scanner lectureClavier= new Scanner(System.in);
		byte option = 0;
		do {
			System.out.println(" Choisissez un algorithme a appliquer ? ");
			
			System.out.println("1. Dantzig  ");
			System.out.println("2. Dikjstra  ");
			System.out.println("3. Kruskal   ");
			System.out.println("4. Ordonnancement   ");
			System.out.println("5. Prufer codage /decodage   ");
			System.out.println("6. Rang  ");
			System.out.println("7. Tarjan  ");		
			System.out.println("8. Demi degre interieur  ");	
			System.out.println("9. Demi degre exterieur  ");
			System.out.println("10. Calcul des distances ");
			System.out.println("11. Sortir ");
			
			System.out.println("-----------------------------------------------------------------------");

			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			option = lectureClavier.nextByte();
			System.out.println("-----------------------------------------------------------------------");
			
			switch (option) {
			case 1: {	
				
				//Dantzig
				
				if(!avec_Poids && !est_oriente)
				{
					System.out.println("Votre graphe n'est pas compatible avec cet algorithme!");
				}
				
				else {

				Algorithme aDantzig = new Algorithme();

				aDantzig.Dantzig(getMatCout());
				
				}
				
				break ; 
			}
			case 2:	
			{
				//dikjstra
				
				if(!avec_Poids && !est_oriente)
				{
					System.out.println("Votre graphe n'est pas compatible avec cet algorithme!");
				}
				afficher();
				afficher_cout();
				afficher_fs_aps();
				Algorithme A_Dikjstra = new Algorithme();
				int n = Aps_Get(0) ;
				int m = Fs_Get(0)-n  ;
				 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
				 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
				A_Dikjstra.Dikjstra(1,this,predecesseur,distance) ; 
				/*System.out.println("Affichage du pred ");
				for(int i = 0 ; i < predecesseur.size() ; i++)
					System.out.print(predecesseur.get(i) +"| ");*/

				 new dessinGraphe(this) ; 
				 new dijkstra(this) ; 
			}
			
			case 3:
			{
				//Kruskal
				break;
			}
			
			case 4 :
			{
				//Ordonnancement 
				break;
			}
			
			case 5 : 
			{
				Algorithme aprufer= new Algorithme();

				//aprufer.p(getMatCout());
				break;
			}
			case 6: 
				
			{
				//Rang

				afficher_fs_aps();

				Algorithme a = new Algorithme();

				ArrayList<Integer> r = a.rang(getFs(), getAps());

				String str = new String();
				str += "-----------Rang------------\n|";
				for(Integer i:r){
					str += i + "|";
				}
				str += "\n";

				System.out.println(str);
				break;
			}
			case 7:
			{
				//Tarjan
				System.out.println("ne fonctionne pas encore! veuillez patienter!");
				break; 
			}
			case 8:
			{
				//Demi degre interieur
				
				afficher_fs_aps();

				Algorithme addi = new Algorithme();

				ArrayList<Integer> ddi = addi.demi_degre_interieur(getFs(), getAps());

				String str1 = new String();
				str1 += "-----------Demi Degr� Int�rieur------------\n|";
				for(Integer i:ddi){
					str1 += i + "|";
				}
				str1 += "\n";
				System.out.println(str1);
				break;
			}
			case 9:
			{
				//Demi degre exterieur 
				afficher_fs_aps();

				Algorithme adde = new Algorithme();

				ArrayList<Integer> dde = adde.demi_degre_exterieur(getFs(), getAps());

				String str2 = new String();
				str2 += "-----------Demi Degr� Ext�rieur-----------\n|";
				for(Integer i:dde){
					str2 += i + "|";
				}
				str2 += "\n";

				System.out.println(str2);
				break;
			}
			}
			
		}while(option != 10) ; 

	}
	
	public void actions(ArrayList<Sommet> liste)
	{
		Scanner lectureClavier= new Scanner(System.in);
		byte option = 0;
		
		System.out.println("-----------------------------------------------------------------------");
		do {
		System.out.println(" que voulez vous faire  ? ");
		
		System.out.println("1. ajouter un sommet  ");
		System.out.println("2. ajouter un arc  ");
		System.out.println("3. supprimer un sommet    ");
		System.out.println("4. supprimer un arc    ");
		System.out.println("5. appliquer un algorithme   ");
		System.out.println("6. sortir  ");
		System.out.println("-----------------------------------------------------------------------");

		System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
		option = lectureClavier.nextByte();
		System.out.println("-----------------------------------------------------------------------");
		switch (option) {
		case 1: {
			//ajouter sommet
			String contenu = "" ;
			System.out.println("entrez le nom du sommet : ");
			contenu += lectureClavier.next();
			System.out.println("veuiller saisir un point :");
			int x, y;
			System.out.print("x : ");
			x = lectureClavier.nextInt();
			System.out.print("y : ");
			y = lectureClavier.nextInt();
			Point p = new Point(x, y) ; 
			liste.add(new Sommet(contenu , p , 1)) ; 
			ajouterSommet(liste.get(liste.size()-1));
			afficher();
			break ; 
		}
		case 2 : {
			//ajouter arc
			System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
		
			int i , j ; 
			i = lectureClavier.nextInt();
			System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
			j = lectureClavier.nextInt();
			ajouterArc(liste.get(i-1), liste.get(j-1), 5);
			afficher();
		 break ;
		}
		case 3: 
		{
			//supprimer sommet
			System.out.println("veuillez saisir le  sommet( pas de sommets 0 ) : ");
			int i = lectureClavier.nextInt();
			liste.remove(i-1) ; 
			supprimerSommet(liste.get(i-1));
			afficher();
			
			break ; 
		}
		case 4 : 
		{
			//supprimer arc
			System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
			int i,j;
			i = lectureClavier.nextInt();
			System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
			j = lectureClavier.nextInt();
			enleverArc(liste.get(i-1), liste.get(j-1));
			afficher();
		 break ;
		}
		case 5 : 
		{
			//algorithme
			
			algorithme();
		}
		default:{ 
			System.out.println("cette option n'existe pas");
		}
		}
		
		afficher();
		
		}while(option!= 6) ;
	}


}