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
		
		// supprimer sommets 
		m.supprimerSommet(w);
		
		
		//ajout arc entre s et t ==> 5 
		m.ajouterArc(s, t, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
		m.ajouterArc(s, w, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
	    m.ajouterArc(w, t, 5);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
		// Supp arc 
		m.enleverArc(s, w);
		System.out.println("---------------------") ;
		m.affiche_matrice();
		
	
		
	
	
		
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
