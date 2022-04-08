import Class.*;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {


		Scanner lectureClavier= new Scanner(System.in);
		byte choix=0; // on choisit le type byte pour utiliser moins d'espace memoire


		//On utilise la boucle do...while, elle permet d'entrer et d'exécuter au moins une fois la boucle
		// avant la saisie du choix de l'utilisateur.
		do{
			System.out.println("--------------------------------MENU---------------------------------------");
			System.out.println("1. graphe avec matrice ");
			System.out.println("2. bla bla  ");
			System.out.println("3. Sortir");
			System.out.println("4. Utilisation");
			System.out.println("---------------------------------------------------------------------------");

			System.out.println();
			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			choix = lectureClavier.nextByte();
			System.out.println("-----------------------------------------------------------------------");


			switch (choix){
				case 1:

					Graphe G = new Graphe( true ) ;
					System.out.println(G.toString() );
					Sommet s = new Sommet("S" , 1) ; //sommets 0 et marqu� 1
					Sommet t = new Sommet("T" , 1) ;  //sommets 1 et marqu� 1
					Sommet w = new Sommet("W" , 1) ;  //sommets 2 et marqu� 1
					Sommet k = new Sommet("K" , 1) ;  //sommets 2 et marqu� 1

					// ajout des sommets
					System.out.println("---------Ajout de sommets ------------") ;
					G.ajouterSommet(s);
					System.out.println("---------------------") ;
					G.afficher();
					
					G.ajouterSommet(t);
					System.out.println("---------------------") ;
					G.afficher();
					
					G.ajouterSommet(w);
					System.out.println("---------------------") ;
					G.afficher();

					G.ajouterSommet(k);
					System.out.println("---------------------") ;
					G.afficher();
					
					System.out.println("---------Ajout de arc  ------------") ;


					//ajout arc entre s et t ==> 5
					G.ajouterArc(s, t, 5);
					G.ajouterArc(s, k, 5);
					G.ajouterArc(t, k, 5);
					System.out.println("---------------------") ;
					G.afficher();

					G.ajouterArc(w, t, 5);
					G.ajouterArc(w, w, 5);
					System.out.println("---------------------") ;
					G.afficher();

					G.ajouterArc(k, t, 5);
					G.ajouterArc(k, k, 5);
					System.out.println("---------------------") ;
					G.afficher();


					// supprimer sommets
					System.out.println("---------suppression de sommets ------------") ;
					G.supprimerSommet(s);
					System.out.println("---------------------") ;
					G.afficher();
					G.supprimerSommet(k);
					System.out.println("---------------------") ;
					G.afficher();
			
					// Supp arc
					System.out.println("---------suppression des arc  ------------") ;

					G.enleverArc(w, w);
					System.out.println("---------------------") ;
					G.afficher() ;

					// generer aps / fs apartire de la matrice




				break;


				case 2:
					Sommet Paris = new Sommet("Paris" , 1) ;
					Sommet Mulhouse = new Sommet("Mulhouse" , 1) ;
					Sommet Strasbourg = new Sommet("Strasbourg" , 1) ;
/*
					GrapheListe l = new GrapheListe(Paris,Mulhouse,Strasbourg);
					System.out.println("-------------FS et APS vide-----------");
					System.out.println(l.toString());


					l.ajouterSommet(new Sommet("Paris", 1));

					System.out.println("-------------------Ajout sommet--------------------");
					System.out.println(l.toString());

					l.supprimerSommet(Strasbourg);

					System.out.println("-------------------Retire sommet--------------------");
					System.out.println(l.toString());

					l.ajouterArc(Paris, Mulhouse, 5);
					l.ajouterArc(Paris, Strasbourg, 5);
					//l.ajouterArc(w, t, 5);

					System.out.println("-------------------Ajout arcs--------------------");
					System.out.println(l.toString());

					l.enleverArc(Paris, Mulhouse);

					System.out.println("-------------------Retire arcs--------------------");
					System.out.println(l.toString());
*/
				break;

				case 3:

					System.out.println("Programme arreté");
					System.out.println("A bientôt");

					System.exit(0);
				break;

				case 4:
					System.out.println("1. ecrire conseil d'utilisatio si besoin");
					System.out.println();
				break;

				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=3);

	}
}
