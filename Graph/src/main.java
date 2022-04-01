import Class.*; 

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		GrapheMatrice m = new GrapheMatrice(0, false ) ; 
		System.out.println(m.toString() );
		Sommet s = new Sommet("Paris" , 1) ; //sommets 0 et marqu� 1 
		Sommet t = new Sommet("Paris" , 1) ;  //sommets 1 et marqu� 1 
		Sommet w = new Sommet("Paris" , 1) ;  //sommets 2 et marqu� 1 
		// ajout des sommets 
		m.ajouterSommet(s);
		m.ajouterSommet(t);
		m.ajouterSommet(w);
		//ajout arc entre s et t ==> 5 
		m.ajouterArc(s, t, 5);
		m.ajouterArc(s, w, 5);
		m.ajouterArc(w, t, 5);
		System.out.println(m.toString() );
		// Supp arc 
		m.enleverArc(s, w);
		//System.out.println("----------enlever-----------") ;
		System.out.println(m.toString() );
		//sup sommets 
		//System.out.println("-----------supp sommets ----------") ;
	
		
	
		System.out.println("---------------------") ;
		m.affiche_matrice();
		*/


		Sommet s = new Sommet("Paris" , 1) ; 
		Sommet t = new Sommet("Paris" , 1) ;  
		Sommet w = new Sommet("Paris" , 1) ;

		GrapheListe l = new GrapheListe(s,t,w);
		System.out.println("-------------FS et APS vide-----------");
		System.out.println(l.toString());


		l.ajouterSommet(new Sommet("Paris", 1));

		System.out.println("-------------------Ajout sommet--------------------");
		System.out.println(l.toString());

		l.ajouterArc(s, t, 5);
		l.ajouterArc(s, w, 5);
		l.ajouterArc(w, t, 5);

		System.out.println("-------------------Ajout arcs--------------------");
		System.out.println(l.toString());
	
	}

}
