import Class.*; 

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GrapheMatrice m = new GrapheMatrice(0, false ) ; 
		GrapheMatrice c = new GrapheMatrice(0, false );
		System.out.println(m.toString() );
		Sommet s = new Sommet("Paris" , 1) ; //sommets 0 et marqu� 1 
		Sommet t = new Sommet("Paris" , 1) ;  //sommets 1 et marqu� 1 
		Sommet w = new Sommet("Paris" , 1) ;  //sommets 2 et marqu� 1 
		//Sommet v = new Sommet("Paris" , 1) ;
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
		System.out.println(m.equals(c));
	
	}

}
