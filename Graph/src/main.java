import Class.*; 

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		GrapheMatrice m = new GrapheMatrice(0, false ) ; 
		GrapheMatrice c = new GrapheMatrice(0, false );
		System.out.println(m.toString() );
<<<<<<< HEAD
		Sommet s = new Sommet("Paris" , 1) ; //sommets 0 et marquï¿½ 1 
		Sommet t = new Sommet("Paris" , 1) ;  //sommets 1 et marquï¿½ 1 
		Sommet w = new Sommet("Paris" , 1) ;  //sommets 2 et marquï¿½ 1 
=======
		Sommet s = new Sommet("Paris" , 1) ; //sommets 0 et marqué 1 
		Sommet t = new Sommet("Paris" , 1) ;  //sommets 1 et marqué 1 
		Sommet w = new Sommet("Paris" , 1) ;  //sommets 2 et marqué 1 
		//Sommet v = new Sommet("Paris" , 1) ;
>>>>>>> 34413fc23b9e9f89c9955791642491afe8889b97
		// ajout des sommets 
		m.ajouterSommet(s);
		m.ajouterSommet(t);
		m.ajouterSommet(w);
		c.ajouterSommet(s);
		c.ajouterSommet(t);
		c.ajouterSommet(w);
		//m.ajouterSommet(v);
		//ajout arc entre s et t ==> 5 
		m.ajouterArc(s, t, 5);
		m.ajouterArc(s, w, 5);
		m.ajouterArc(w, t, 5);
		c.ajouterArc(s, t, 5);
		c.ajouterArc(s, w, 5);
		c.ajouterArc(w, t, 5);
		System.out.println(m.toString() );
		// Supp arc 
		m.enleverArc(s, w);
		//c.enleverArc(s, w);
		System.out.println("----------enlever-----------") ;
		System.out.println(m.toString() );
		//sup sommets 
		System.out.println("-----------supp sommets ----------") ;
		//m.supprimerSommet(s);
		//c.supprimerSommet(s);
		System.out.println("---------------------") ;
		m.affiche_matrice();
<<<<<<< HEAD
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
=======
		System.out.println(m.equals(c));
>>>>>>> 34413fc23b9e9f89c9955791642491afe8889b97
	
	}

}
