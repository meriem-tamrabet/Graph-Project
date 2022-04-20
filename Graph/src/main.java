import Class.*;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class main {

	public static void main(String[] args) {


		Scanner lectureClavier= new Scanner(System.in);
		
		Sommet s = new Sommet("S",new Point(100, 200) , 1) ; //sommets 0 et marqu� 1
		Sommet t = new Sommet("T" , new Point(400, 260) , 1) ;  //sommets 1 et marqu� 1
		Sommet w = new Sommet("P", new Point(100, 500) , 1) ;  //sommets 2 et marqu� 1
		Sommet k = new Sommet("K" , new Point(500, 450) , 1) ;  //sommets 2 et marqu� 1
		Sommet L = new Sommet("L" , new Point(100, 450) , 1) ;  //sommets 2 et marqu� 1

		byte choix=0; // on choisit le type byte pour utiliser moins d'espace memoire


		//On utilise la boucle do...while, elle permet d'entrer et d'exécuter au moins une fois la boucle
		// avant la saisie du choix de l'utilisateur.
		do{
			System.out.println("--------------------------------MENU---------------------------------------");
		
			System.out.println("1. graphe avec matrice ");
			System.out.println("2. fs et aps ");
			System.out.println("3. Sortir");
			System.out.println("4. Graphique ");
			System.out.println("6. dessin  ");
			System.out.println("5. cout  ");
			System.out.println("7. Rang ");
			System.out.println("8. Demi degré interieur ");
			System.out.println("9. Demi degré extérieur ");
			System.out.println("10. Dantzig ");
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
					G.ajouterArc(s, k, 2 );
					G.ajouterArc(t, k, 3);
					System.out.println("---------------------") ;
					G.afficher();

					G.ajouterArc(w, t, 5);
					G.ajouterArc(w, w, 5);
					System.out.println("---------------------") ;
					G.afficher();

					G.ajouterArc(k, t, 5);
					G.ajouterArc(k, k, 5);
					System.out.println("------fs et aps ---------------") ;
					G.afficher();

					G.afficher_fs_aps();
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
					G_poids.afficher_cout() ; //good
					
				
					// ajout des sommets
					System.out.println("---------Ajout de sommets ------------") ;
					G_poids.ajouterSommet(s);
					//G_poids.afficher();
					//G_poids.afficher_cout();
					
					G_poids.ajouterSommet(t);
					System.out.println("---------------------") ;
					//G_poids.afficher();
					//G_poids.afficher_cout();
					
					G_poids.ajouterSommet(w);
					System.out.println("---------------------") ;
					//G_poids.afficher();

					G_poids.ajouterSommet(k);
					System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();
					
					System.out.println("---------Ajout de arc  ------------") ;


					//ajout arc entre s et t ==> 5
					G_poids.ajouterArc(s, t, 5);
					G_poids.afficher();
					G_poids.afficher_cout();
					
					G_poids.ajouterArc(s, k, 2);
					G_poids.ajouterArc(t, k, 3);
					System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();

					G_poids.ajouterArc(w, t, 5);
					G_poids.ajouterArc(w, w, 8);
					System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();
					/*
					// supprimer sommets
					System.out.println("---------suppression de sommets ------------") ;
					G_poids.supprimerSommet(s);
					System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();
					
					G_poids.supprimerSommet(k);
					System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();
			
					// Supp arc
					System.out.println("---------suppression des arc  ------------") ;

					G_poids.enleverArc(w, w);
					//System.out.println("---------------------") ;
					G_poids.afficher();
					G_poids.afficher_cout();
					*/
					
					
					break;
				
				case 6 : 
					
					Graphe MonGraphe = new Graphe( true , true  ) ;
					

					// ajout des sommets
					System.out.println("---------Ajout de sommets ------------") ;
					MonGraphe.ajouterSommet(s);
					MonGraphe.ajouterSommet(t);
					MonGraphe.ajouterSommet(w);
					MonGraphe.ajouterSommet(k);
					MonGraphe.ajouterSommet(L);
				
					System.out.println("---------------------") ;
					System.out.println("---------Ajout de arc  ------------") ;
					MonGraphe.ajouterArc(s, t, 1);
					MonGraphe.ajouterArc(s, k, 2 );
					MonGraphe.ajouterArc(t, k, 3);
					MonGraphe.ajouterArc(w, t, 5);
					MonGraphe.ajouterArc(w, w, 5);
					MonGraphe.ajouterArc(k, t, 5);
					MonGraphe.ajouterArc(k, k, 5);
					
					System.out.println("---------------------") ;
				
					MonGraphe.afficher() ;
					MonGraphe.afficher_fs_aps() ; 
					
					new dessinGraphe(MonGraphe) ; 
				
					break ; 

				case 7:

					Graphe gRang = new Graphe(true,true);

					System.out.println("---------Ajout de sommets ------------") ;
					gRang.ajouterSommet(s);
					gRang.ajouterSommet(t);
					gRang.ajouterSommet(w);
					gRang.ajouterSommet(k);
				
			
					System.out.println("---------Ajout de arc  ------------") ;
					gRang.ajouterArc(s, t, 1);
					gRang.ajouterArc(s, k, 2 );
					gRang.ajouterArc(t, w, 3);

					gRang.afficher_fs_aps();

					Algorithme a = new Algorithme();

					ArrayList<Integer> r = a.rang(gRang.getFs(), gRang.getAps());

					String str = new String();
					str += "-----------Rang------------\n|";
					for(Integer i:r){
						str += i + "|";
					}
					str += "\n";

					System.out.println(str);

					break;

				case 8:
				
					Graphe gDdi = new Graphe(true,true);

					System.out.println("---------Ajout de sommets ------------") ;
					gDdi.ajouterSommet(s);
					gDdi.ajouterSommet(t);
					gDdi.ajouterSommet(w);
					gDdi.ajouterSommet(k);
				
			
					System.out.println("---------Ajout de arc  ------------") ;
					gDdi.ajouterArc(s, t, 1);
					gDdi.ajouterArc(s, k, 2 );
					gDdi.ajouterArc(t, w, 3);

					gDdi.afficher_fs_aps();

					Algorithme addi = new Algorithme();

					ArrayList<Integer> ddi = addi.demi_degre_interieur(gDdi.getFs(), gDdi.getAps());

					String str1 = new String();
					str1 += "-----------Demi Degré Intérieur------------\n|";
					for(Integer i:ddi){
						str1 += i + "|";
					}
					str1 += "\n";

					System.out.println(str1);

					break;

				case 9:

					Graphe gDde = new Graphe(true,true);

					System.out.println("---------Ajout de sommets ------------") ;
					gDde.ajouterSommet(s);
					gDde.ajouterSommet(t);
					gDde.ajouterSommet(w);
					gDde.ajouterSommet(k);
				
			
					System.out.println("---------Ajout de arc  ------------") ;
					gDde.ajouterArc(s, t, 1);
					gDde.ajouterArc(s, k, 2 );
					gDde.ajouterArc(t, w, 3);

					gDde.afficher_fs_aps();

					Algorithme adde = new Algorithme();

					ArrayList<Integer> dde = adde.demi_degre_exterieur(gDde.getFs(), gDde.getAps());

					String str2 = new String();
					str2 += "-----------Demi Degré Extérieur-----------\n|";
					for(Integer i:dde){
						str2 += i + "|";
					}
					str2 += "\n";

					System.out.println(str2);

					break;

				case 10:

					Graphe gDantzig = new Graphe(true,true);

					System.out.println("---------Ajout de sommets ------------") ;
					gDantzig.ajouterSommet(s);
					gDantzig.ajouterSommet(t);
					gDantzig.ajouterSommet(w);
					gDantzig.ajouterSommet(k);
				
			
					System.out.println("---------Ajout de arc  ------------") ;
					gDantzig.ajouterArc(s, t, 1);
					gDantzig.ajouterArc(s, k, 2 );
					gDantzig.ajouterArc(t, w, 3);

					Algorithme aDantzig = new Algorithme();

					aDantzig.Dantzig(gDantzig.getMatCout());

					break;
				case 11:

					Graphe gDikjstra = new Graphe(true,true);

					System.out.println("---------Ajout de sommets ------------") ;
					gDikjstra.ajouterSommet(s);
					gDikjstra.ajouterSommet(t);
					gDikjstra.ajouterSommet(w);
					gDikjstra.ajouterSommet(L);
					gDikjstra.ajouterSommet(k);
				
			
					System.out.println("---------Ajout de arc  ------------") ;
					gDikjstra.ajouterArc(s, t, 1);
					gDikjstra.ajouterArc(s,w , 2 );
					
					gDikjstra.ajouterArc(t, w, 1);
					gDikjstra.ajouterArc(t, L, 2);
					gDikjstra.ajouterArc(t, k, 1);

					gDikjstra.ajouterArc(w, L, 2);
					gDikjstra.ajouterArc( L,k, 2);
					gDikjstra.ajouterArc(k, L, 5);
					gDikjstra.afficher();
					gDikjstra.afficher_cout();
					gDikjstra.afficher_fs_aps();
					Algorithme A_Dikjstra = new Algorithme();
					int n =gDikjstra.Aps_Get(0) ;
					int m = gDikjstra.Fs_Get(0)-n  ;
					 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
					 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
					A_Dikjstra.Dikjstra(1,gDikjstra,predecesseur,distance) ; 
					System.out.println("Affichage du pred ");
					for(int i = 0 ; i < predecesseur.size() ; i++)
						System.out.print(predecesseur.get(i) +"| ");

					 new dessinGraphe(gDikjstra) ; 
					 new dijkstra(gDikjstra) ; 
					
					break;

				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=3);

	}
}
