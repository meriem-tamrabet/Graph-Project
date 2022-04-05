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
			System.out.println("1. Matrice");
			System.out.println("2. Liste ");
			System.out.println("3. Sortir");
			System.out.println("4. Utilisation");
			System.out.println("---------------------------------------------------------------------------");

			System.out.println();
			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			choix = lectureClavier.nextByte();
			System.out.println("-----------------------------------------------------------------------");


			switch (choix){
				case 1:

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



				break;


				case 2:
					Sommet Paris = new Sommet("Paris" , 1) ;
					Sommet Mulhouse = new Sommet("Mulhouse" , 1) ;
					Sommet Strasbourg = new Sommet("Strasbourg" , 1) ;

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
