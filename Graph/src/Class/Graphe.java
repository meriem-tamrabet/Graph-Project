package Class;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
		this.listeSommet.add(null) ; 	
	}

	public Graphe(ArrayList<Integer> aps ,ArrayList<Integer> fs, boolean est_oriente) {
		
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

		this.listeSommet.add(null);

		this.est_oriente = est_oriente;
		this.avec_Poids=false;

		fs_apsToMatrice();

	}

	public Graphe( boolean est_oriente, boolean avec_poids) {
		this.est_oriente = est_oriente ; 
		this.avec_Poids = avec_poids ; 
		Generer_matrice(0 , this.avec_Poids );
		Matrice_to_fs_aps() ;
	}
	
	//------- Methodes de la matrice  ---------------------------
	

	public void Generer_matrice(int n , boolean avec_Poids ){
	
		int taille_matrice = n+2 ; 
		this.matrice = new int[taille_matrice][taille_matrice] ; 
		 
		this.matrice[0][0] = n ; 

		int val = 0  ; 
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
		if(avec_Poids == true ) Generer_Matrice_Cout(n) ; 
		
	}
	public void  Generer_Matrice_Cout(int n ){
		
		int taille_matrice = n+2 ;
		
		this.matrice_cout = new int[taille_matrice][taille_matrice] ;
		
		this.matrice_cout[0][0] = n ; 

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

		int tailleFs= n+1; 
		int tailleAps= n+1;
		this.fs = new ArrayList<Integer>(tailleFs);
		this.aps = new ArrayList<Integer>(tailleAps);

		this.fs.add(0,n);
		this.aps.add(0,n);

		int val =0;
		for(int i=1; i<tailleFs;i++){
			this.fs.add(i,val);
		}

		for(int i=1; i<tailleAps;i++){
			this.aps.add(i,val);
		}

	}
	
	public void ajouterSommet(Sommet s) {
		int taille = nombre_sommets_matrice() +1  ; 
		taille++ ;
		listeSommet.add(s) ; 
		
		int[][] N_matrice = new int[taille ][taille] ; 
		for( int i = 0 ; i< taille -1   ; i++ ) {
			for(int j = 0 ; j< taille-1  ; j++)
			{
				 N_matrice [i][j] =  matrice[i][j] ; 
			}
		}
		N_matrice [0][0] ++; 
		matrice =N_matrice ; 
		
		if(this.avec_Poids == true )
			{
				MiseAJourAjoutMatriceCout();
			}
		
		Matrice_to_fs_aps();

	}

	public int Numero_Sommet(Sommet s)
	{
		int i = 0 ; 
		while (! listeSommet.get(i).equals(s))
			i++; 
		
		return(i<listeSommet.size() ? i+1 : -1 ) ;  
	}

	public  void ajouterArc(Sommet s, Sommet t, int val) {
		
		int indiceS = Numero_Sommet(s) ; 
		int indiceT = Numero_Sommet(t) ; 
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
	
	
	public void supprimerSommet(Sommet s)
	{
		int indiceS = Numero_Sommet(s) ; 
		int[][] mat = new int[matrice.length-1][matrice[0].length-1];
		
		if( indiceS== -1   )
		return ;
		
		MiseAJourSuppMatriceCout(indiceS) ;
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
		matrice = mat;
		matrice[0][1]  = miseAJourArc() ; 
		matrice_cout[0][1] = matrice[0][1]  ; 
		
		Matrice_to_fs_aps();
		
	}

	public boolean existeArc(Sommet s,Sommet t){
		int indiceS = Numero_Sommet(s) ; 
		int indiceT = Numero_Sommet(t) ;
			
		if( indiceS== -1  ||  indiceT == -1  )
			return false ; 
			
		if( this.avec_Poids)
			return ( matrice[indiceS][indiceT] != valeur_interdite) ; 
				
		else 
			return (matrice[indiceS][indiceT] != 0 )  ; 
	       
	}

	public  void enleverArc(Sommet s, Sommet t) {
			
		int indiceS = Numero_Sommet(s) ; 
		int indiceT = Numero_Sommet(t) ;
				
		if( indiceS== -1  ||  indiceT == -1  )
		{
			return  ;
		}
		else 
		{	
			this.matrice[0][1] -- ; 
			matrice[indiceS][indiceT] = 0   ; 
			if (this.avec_Poids)
				matrice_cout[indiceS][indiceT] = valeur_interdite   ; 
				this.matrice_cout[0][1] -- ; 
			}
			Matrice_to_fs_aps();
	}

	//---------------methodes FS APS matrice------------------------------
	  
	public void  Matrice_to_fs_aps() {
		int n = nombre_sommets_matrice() ;
		int m = nombre_arcs_matrice()  ; 
		
		fs = new ArrayList<Integer>(n+m+1) ; 
		aps = new ArrayList<Integer>(n+1) ; 
		
		if(n >0 )
		{
			aps.add(0,n); 
			fs.add(0,n+m) ; 
			int k = 1 ;
			for( int i = 1 ; i <= n ; i++) {
				aps.add(i, k ); 
				for( int j = 1 ; j <= n; j++) {
					if(matrice[i][j] != 0)
					{
						fs.add(k,j) ;
						++k ;
					}
				}
				fs.add(k,0) ; 
				++k ;
			}
		}
		
	}
	
	public void fs_apsToMatrice(){
		int n = nombre_sommets_aps();
		this.matrice = new int[n+1][n+1];
		this.matrice[0][0] = n; 
		this.matrice[0][1] = nombre_arcs_fs(); 

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

//------------------------------Getters-----------------------------------------

	public boolean isAvecPoids() {
		return avec_Poids;
	}

	public boolean isOriente() {
		return est_oriente;
	}
	
	public  int getFsElem(int i) {
		return fs.get(i ) ; 
	}
	public  int getApsElem(int i) {
		return aps.get(i ) ; 
	}
	public  int getMatriceElem(int i,int j) {
		return matrice[i][j] ; 
	}
	public  int getCout(int i,int j) {
		return matrice_cout[i][j] ; 
	}
	public  Sommet getListeSommetElem(int i) {
		return listeSommet.get(i) ; 
	}

	public ArrayList<Integer> getFs() { return fs;}

	public ArrayList<Integer> getAps() { return aps;}

	public int[][] getMatCout(){
		return this.matrice_cout;
	}

	public int nombre_successeur(Sommet s) {
		int indiceS = Numero_Sommet(s) ; 
		int co = 0  ; 
		int i = aps.get(indiceS) ; 
		while(i < fs.size() && fs.get(i)!=0 ) {
			i++ ; 
			co++ ; 
		}
		return co ; 	
	}
	
	public int miseAJourArc() {
		int co = 0 ; 
		for(int i = 0 ; i < matrice[0].length ; i++) {
			for(int j = 0 ; j < matrice[0].length ; j++) 
				if(matrice[i][j] == 1 )
					co++ ; 
		}
		return co ; 
	}

	public int nombre_sommets_matrice(){
		return matrice[0][0];
	}
	
	public int nombre_sommets_aps(){
		return aps.get(0);
	}

	public int nombre_arcs_fs(){
		return fs.get(0)-nombre_sommets_aps();
	}

	public int nombre_arcs_matrice(){
		return matrice[0][1];
	}
	
	
	//------------------------------------Setters ---------------------------------
	public  void  setFsElem(int i, int val ) {
	 	fs.set(i,val ) ; 
	}
	
	public  void  setApsElem(int i, int val) {
	 aps.set(i,val ) ; 
	}
	
	public  void setMatriceElem(int i,int j, int val ) {
	 matrice[i][j] = val ; 
	}
	
	public  void setCoutElem(int i,int j , int val) {
	 matrice_cout[i][j] = val  ;
	}
	
	//----------------------------  Methodes affichage  ---------------------------
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
	
	public void afficher_matrice()
	{
		if( est_oriente )
		System.out.print(" votre graphe est oriente \n "  ); 
		System.out.print(this.toString()  ); 
		
	}
	
	public void afficher_fs_aps() {
		  String str = "-------------------- fs & aps ------------------- \n";

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
		
		String Smatrice = "-------------------matrice --------------------- \n " ;
		
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
		  String Total = "Grphe " ; 
		  if( est_oriente)
			  Total += "Oriente" ; 
		  else  Total += "Non Oriente" ; 
		  if(avec_Poids)
			  Total += " Contient des poids" ; 
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
			for(int i = 1;i < listeSommet.size();i++){
				ListeSommets += getListeSommetElem(i).toString()  + "|";
	        }
		       return   Total+"\n " + str + Smatrice + ListeSommets;
	    }
	  
	  
	 // --------------------------- Methode cout ----------------------------- 
	public void MiseAJourAjoutMatriceCout() {
		int taille = nombre_sommets_matrice()   ; 
		taille++ ;
		int[][] N_matrice = new int[taille ][taille] ; 
		
		for( int i = 0 ; i< taille -1   ; i++ ) {
			for(int j = 0 ; j< taille-1  ; j++)
			{
				 N_matrice [i][j] =  this.matrice_cout[i][j] ; 
			}
		}
		int indice = Numero_Sommet(listeSommet.get(listeSommet.size()-1 )) ; 
		
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
	
	
	public void MiseAJourSuppMatriceCout( int indiceS ) {
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
//--------------------------sauvgarde/charger-----------------------------
	public void sauvgarde() {
		  PrintWriter printWriter = null;
	        
	        {
	            try {
	                printWriter = new PrintWriter("writerFile.txt");
	            } catch (FileNotFoundException e) {
	                System.out.println("Unable to locate the fileName: " + e.getMessage());
	            }
	            Objects.requireNonNull(printWriter).println(toString());
	            printWriter.close();
	        }
	    
		  
	}
	public void menu_algorithme()
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
					System.out.println("votre graphe n'est pas compatible avec cet algorithme!");
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
					System.out.println("votre graphe n'est pas compatible avec cet algorithme!");
				}
				else {
					
				afficher_matrice();
				afficher_cout();
				afficher_fs_aps();
				Algorithme A_Dikjstra = new Algorithme();
				int n = getApsElem(0) ;
				int m = getFsElem(0)-n  ;
				 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
				 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
				A_Dikjstra.Dijkstra(1,this,predecesseur,distance) ; 

				 new dessinGraphe(this) ; 
				 new dijkstra(this) ; 
				}
				break;
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
				//Prufer
				if(est_oriente == true)
				{
					System.out.println("votre graphe n'est pas compatible avec cet algorithme! ");
				}
				else 
				{
					Algorithme aprufer= new Algorithme();
				}
				break;
			}
			case 6: 
				
			{
				//Rang
				if(est_oriente == false)
				{
					System.out.println("votre graphe n'est pas compatible avec cet algorithme! ");
				}
				else 
				{

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
				}
				break;
			}
			case 7:
			{
				//Tarjan
				System.out.println("desole cet algorithme ne fonctionne pas :(");
				break; 
			}
			case 8:
			{
				//Demi degre interieur
				
				if(est_oriente == false)
				{
					System.out.println("votre graphe n'est pas compatible avec cet algorithme! ");
				}
				else
				{	
				afficher_fs_aps();

				Algorithme addi = new Algorithme();

				ArrayList<Integer> ddi = addi.demi_degre_interieur(getFs(), getAps());

				String str1 = new String();
				str1 += "-----------Demi Degre Interieur------------\n|";
				for(Integer i:ddi){
					str1 += i + "|";
				}
				str1 += "\n";
				System.out.println(str1);
				}
				break;
			}
			case 9:
			{
				//Demi degre exterieur 
				if(est_oriente == false)
				{
					System.out.println("votre graphe n'est pas compatible avec cet algorithme! ");
				}
				else
				{
				afficher_fs_aps();

				Algorithme adde = new Algorithme();

				ArrayList<Integer> dde = adde.demi_degre_exterieur(getFs(), getAps());

				String str2 = new String();
				str2 += "-----------Demi Degre Exterieur-----------\n|";
				for(Integer i:dde){
					str2 += i + "|";
				}
				str2 += "\n";

				System.out.println(str2);
				}
				break;
			}
			case 10: 
			{
				//calcul des distances
				
				Algorithme aDistance = new Algorithme();
				aDistance.calcul_distance(this);
				
				break;
			}
			}
			
		}while(option != 11) ; 

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
		System.out.println("6. affichage graphique  ");
		System.out.println("7. sortir ");
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
			afficher_matrice();
			break ; 
		}
		case 2 : {
			//ajouter arc
			System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
		
			int i , j ; 
			i = lectureClavier.nextInt();
			System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
			j = lectureClavier.nextInt();
			int p;
			if(avec_Poids == true)
			{
				System.out.println("entrez le poids de votre nouvel arc : ");
				p = lectureClavier.nextInt();
				ajouterArc(liste.get(i-1), liste.get(j-1), p);
			}
			else
				ajouterArc(liste.get(i-1), liste.get(j-1), 0);
			afficher_matrice();
			break ;
		}
		case 3: 
		{
			//supprimer sommet
			System.out.println("veuillez saisir le  sommet( pas de sommets 0 ) : ");
			int i = lectureClavier.nextInt();
			supprimerSommet(liste.get(i-1));
			liste.remove(i-1) ; 
			afficher_matrice();
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
			afficher_matrice();
			break ;
		}
		case 5 : 
		{
			//algorithme
			
			menu_algorithme();
			break;
		}
		case 6:
		{
			//affichage graphique
			new dessinGraphe(this);
			break;
		}
		default:{ 
			System.out.println("cette option n'existe pas");
		}
		}
		
		afficher_matrice();
		
		}while(option!= 7) ;
	}


}