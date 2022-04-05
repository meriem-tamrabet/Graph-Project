import Class.*; 

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrapheMatrice m = new GrapheMatrice(0, false ) ; 
		System.out.println(m.toString() );
		Sommet s = new Sommet("Paris" , 1) ; //sommets 0 et marqu� 1 
	    Sommet t = new Sommet("Paris" , 1) ;  //sommets 1 et marqu� 1 
		Sommet w = new Sommet("Paris" , 1) ;  //sommets 2 et marqu� 1
		Sommet k = new Sommet("Paris" , 1) ;  //sommets 2 et marqu� 1
		
		// ajout des sommets 
		 m.ajouterSommet(s);

			System.out.println("---------------------") ;
			m.affiche_matrice();
		 m.ajouterSommet(t);

			System.out.println("---------------------") ;
			m.affiche_matrice();
		 m.ajouterSommet(w);

			System.out.println("---------------------") ;
			m.affiche_matrice();
		
		m.ajouterSommet(k);
			System.out.println("---------------------") ;
			m.affiche_matrice();
		
		
		
		
		//ajout arc entre s et t ==> 5 
		m.ajouterArc(s, t, 5);
		m.ajouterArc(s, k, 5);
		m.ajouterArc(t, k, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
		m.ajouterArc(w, t, 5);
		m.ajouterArc(w, w, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
	    m.ajouterArc(k, t, 5);
	    m.ajouterArc(k, k, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
		
		// supprimer sommets 
				m.supprimerSommet(s); 
				System.out.println("---------------------") ;
				m.affiche_matrice();
				m.supprimerSommet(k); 
				System.out.println("---------------------") ;
				m.affiche_matrice();
				/*		
		// Supp arc 
		m.enleverArc(s, w);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
		// generer aps / fs apartire de la matrice 
		
		/*int[][] tab ; 
		System.out.println("-------affichage de fs et aps --------------") ;
		tab = m.Matrice_to_fs_aps(  ) ; 
		
		System.out.println("-------affichage de fs et aps --------------") ;
		  String str = "";

	        str += "FS : |";
	        for(int i = 0;i <= tab[1][0];i++){
	            str += tab[1][i]  + "|";
	        }
	        
	        str += "\nAPS : |";

	        for(int i = 0;i <= tab[0][0] ;i++){
	            str +=tab[0][i] + "|";
	        }
	        
	        System.out.println(str) ;
	
	*/
		
/*

		Sommet s = new Sommet("Paris" , 1) ; 
		Sommet t = new Sommet("Paris" , 1) ;  
		Sommet w = new Sommet("Paris" , 1) ;

		GrapheListe l = new GrapheListe(s,t,w);
		System.out.println("-------------FS et APS vide-----------");
		System.out.println(l.toString());


		l.ajouterSommet(new Sommet("Paris", 1));

		System.out.println("-------------------Ajout sommet--------------------");
		System.out.println(l.toString());

		l.supprimerSommet(w);

		System.out.println("-------------------Retire sommet--------------------");
		System.out.println(l.toString());

		l.ajouterArc(s, t, 5);
		l.ajouterArc(s, w, 5);
		//l.ajouterArc(w, t, 5);

		System.out.println("-------------------Ajout arcs--------------------");
		System.out.println(l.toString());

		l.enleverArc(s, t);

		System.out.println("-------------------Retire arcs--------------------");
		System.out.println(l.toString());
	*/
	}

}
