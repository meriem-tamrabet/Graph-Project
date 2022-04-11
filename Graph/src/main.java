import Class.*;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class main {

	public static void main(String[] args) {


		Scanner lectureClavier= new Scanner(System.in);
		Sommet s = new Sommet("S" , 1) ; //sommets 0 et marqu� 1
		Sommet t = new Sommet("T" , 1) ;  //sommets 1 et marqu� 1
		Sommet w = new Sommet("W" , 1) ;  //sommets 2 et marqu� 1
		Sommet k = new Sommet("K" , 1) ;  //sommets 2 et marqu� 1
		byte choix=0; // on choisit le type byte pour utiliser moins d'espace memoire


		//On utilise la boucle do...while, elle permet d'entrer et d'exécuter au moins une fois la boucle
		// avant la saisie du choix de l'utilisateur.
		do{
			System.out.println("--------------------------------MENU---------------------------------------");
			System.out.println("1. graphe avec matrice ");
			System.out.println("2. fs et aps ");
			System.out.println("3. Sortir");
			System.out.println("4. Graphique ");
			System.out.println("5. cout  ");
			System.out.println("---------------------------------------------------------------------------");

			System.out.println();
			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			choix = lectureClavier.nextByte();
			System.out.println("-----------------------------------------------------------------------");


			switch (choix){
				case 1:

					Graphe G = new Graphe( true , true  ) ;
					System.out.println(G.toString() );
					

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
					G.ajouterArc(s, t, 1);
					G.ajouterArc(s, k, 55555 );
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

					ArrayList<Integer> copyFs = new ArrayList<Integer>();
					ArrayList<Integer> copyAps = new ArrayList<Integer>(4);

					copyFs.add(9);
					copyFs.add(2);
					copyFs.add(3);
					copyFs.add(0);
					copyFs.add(1);
					copyFs.add(3);
					copyFs.add(0);
					copyFs.add(1);
					copyFs.add(0);
					copyFs.add(0);

					copyAps.add(4);
					copyAps.add(1);
					copyAps.add(4);
					copyAps.add(7);
					copyAps.add(9);

					Graphe g = new Graphe(copyAps,copyFs,true);
					g.afficher();

					System.out.println("-------------------Ajout sommet--------------------");
					g.ajouterSommet(Paris);
					g.afficher();

					System.out.println("-------------------supprimer sommet--------------------");

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
					//apply a look n feel marche pas sur mac faut enlever le look 
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					//Start my window 
					MyWindow Fenetre = new MyWindow() ; 
					Fenetre.setVisible(true) ;
				break;
				case 5 : 
					
					Graphe G_poids = new Graphe( true , true ) ;
					
					
					G_poids.ajouterSommet(s);
					// ajout des sommets
					System.out.println("---------Ajout de sommets ------------") ;
					G_poids.ajouterSommet(s);
					System.out.println("---------------------") ;
					G_poids.afficher();
					
					G_poids.ajouterSommet(t);
					System.out.println("---------------------") ;
					G_poids.afficher();
					
					G_poids.ajouterSommet(w);
					System.out.println("---------------------") ;
					G_poids.afficher();

					G_poids.ajouterSommet(k);
					System.out.println("---------------------") ;
					G_poids.afficher();
					
					System.out.println("---------Ajout de arc  ------------") ;


					//ajout arc entre s et t ==> 5
					G_poids.ajouterArc(s, t, 5);
					G_poids.ajouterArc(s, k, 5);
					G_poids.ajouterArc(t, k, 5);
					System.out.println("---------------------") ;
					G_poids.afficher();

					G_poids.ajouterArc(w, t, 5);
					G_poids.ajouterArc(w, w, 5);
					System.out.println("---------------------") ;
					G_poids.afficher();
					
					G_poids.afficher_cout();
					break;

				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=3);

	}
}
