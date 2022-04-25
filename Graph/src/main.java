import Class.*;
import Affichage.* ; 

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class main {

	public static void main(String[] args) {

		 ArrayList<Sommet> liste = new ArrayList<Sommet>();

		Scanner lectureClavier= new Scanner(System.in);
		 boolean avec_Poids = true ; 
		 boolean est_oriente = true  ; 
			Sommet s = new Sommet("S",new Point(100, 200) , 1) ; //sommets 0 et marque 1
			Sommet t = new Sommet("T" , new Point(400, 260) , 1) ;  //sommets 1 et marque 1
			Sommet w = new Sommet("P", new Point(100, 500) , 1) ;  //sommets 2 et marque 1
			Sommet k = new Sommet("K" , new Point(500, 450) , 1) ;  //sommets 2 et marque 1
			Sommet L = new Sommet("L" , new Point(100, 450) , 1) ;  //sommets 2 et marque 1

		Graphe Gfinal = null;

		byte choix=0; // on choisit le type byte pour utiliser moins d'espace memoire
		byte option=0;
		int affichage =0 ; 

		//On utilise la boucle do...while, elle permet d'entrer et d'exécuter au moins une fois la boucle
		// avant la saisie du choix de l'utilisateur.
		do{
			System.out.println("--------------------------------MENU---------------------------------------");
		
			System.out.println("1. Cree un graphe ");
			System.out.println("2. Algorithmes ");
			System.out.println("3. Application ");


			System.out.println("4. Sortir ");
			
			System.out.println("---------------------------------------------------------------------------");

			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			choix = lectureClavier.nextByte();
			System.out.println("-----------------------------------------------------------------------");


			switch (choix){
				case 1:
					do{System.out.println("--------------------------------cree un graphe---------------------------------------");

					System.out.println("1. generer un graphe oriente avec 5 sommets");
					System.out.println("2. generer un graphe non  oriente avec 5 sommets");
					//TODO sans poids 
					System.out.println("3. generer un graphe oriente sans poids");
					System.out.println("4. generer un graphe non orieente sans poids");
					System.out.println("5. Sortie");
					
					/*
					System.out.println("5. cree a partir des sommets choisis ");
					System.out.println("6. cree a partir de l'application  ");
					System.out.println("7. Retour ");*/

					System.out.println("---------------------------------------------------------------------------");

					System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
					choix = lectureClavier.nextByte();
					switch (choix) {
					case 1: 
					
						Graphe G = new Graphe( est_oriente , avec_Poids  ) ;

						// ajout des sommets
						
						G.ajouterSommet(s);
						G.ajouterSommet(t);
						G.ajouterSommet(w);
						G.ajouterSommet(k);
						liste.add(s) ; liste.add(t) ; liste.add(w) ; liste.add(k) ; 
						//ajout arc entre s et t ==> 5
						G.ajouterArc(s, t, 1);
						G.ajouterArc(s, k, 2 );
						G.ajouterArc(t, k, 3);
						G.ajouterArc(w, t, 5);
						G.ajouterArc(w, w, 5);
						G.ajouterArc(k, t, 5);
						G.ajouterArc(k, k, 5);
						System.out.println(" quel type d'affichage voulez vous ? ");
						System.out.println("1. Console   ");
						System.out.println("2. Graphique  ");

						System.out.println("---------------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						affichage = lectureClavier.nextInt();
						if(affichage==0) {
							G.afficher_fs_aps();
							
						}
						else {
							 new dessinGraphe(G) ; 
						}
						System.out.println("-----------------------------------------------------------------------");
						do {
						System.out.println(" que voulez vous faire  ? ");
						
						System.out.println("1. ajouter un sommet  ");
						System.out.println("2. ajouter un arc  ");
						System.out.println("3. supprimer un sommet    ");
						System.out.println("4. supprimer un arc    ");
						System.out.println("5. Sortir   ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
							switch (option) {
							case 1: {
								String contenu = "" ;
								contenu = lectureClavier.nextLine();
								System.out.println("Veuiller saisir un point :");
								int x, y;
								System.out.print("x : ");
								x = lectureClavier.nextInt();
								System.out.print("y : ");
								y = lectureClavier.nextInt();
								Point p = new Point(x, y) ; 
								liste.add(new Sommet(contenu , p , 1)) ; 
								G.ajouterSommet(liste.get(liste.size()-1));
								break ; 
							}
							case 2 : 
									//afficher les sommets ou matrice 
								G.afficher();
								System.out.println("VEUILLEZ choisir le 1ere sommet( pas de sommets 0 )  : ");
							
								int i , j ; 
								i = lectureClavier.nextInt();
								System.out.println("VEUILLEZ choisir le 2eme sommet ( pas de sommets 0 ) : ");
								j = lectureClavier.nextInt();
								G.ajouterArc(liste.get(i-1), liste.get(j-1), 5);
							 break ;
							case 3: {
								G.afficher();
								
								System.out.println("VEUILLEZ choisir le  sommet( pas de sommets 0 ) : ");
								i = lectureClavier.nextInt();
								liste.remove(i-1) ; 
								G.supprimerSommet(liste.get(i-1));
								break ; 
							}
							case 4 : 
								//afficher les sommets ou matrice 
								G.afficher();
								System.out.println("VEUILLEZ choisir le 1ere sommet( pas de sommets 0 )  : ");
								
								i = lectureClavier.nextInt();
								System.out.println("VEUILLEZ choisir le 2eme sommet ( pas de sommets 0 ) : ");
								j = lectureClavier.nextInt();
								G.enleverArc(liste.get(i-1), liste.get(j-1));;
							 break ;
							default:
								System.out.println("Cette option n'existe pas");
							}
							
							G.afficher();
							Gfinal = G;
						}while(option!= 5) ; 
						break ; 
					case 2 :
						
						est_oriente = false;
						Graphe NonG = new Graphe( est_oriente , avec_Poids  ) ;

						// ajout des sommets
						
						NonG.ajouterSommet(s);
						NonG.ajouterSommet(t);
						NonG.ajouterSommet(w);
						NonG.ajouterSommet(k);
						
						//ajout arc entre s et t ==> 5
						NonG.ajouterArc(s, t, 1);
						NonG.ajouterArc(s, k, 2 );
						NonG.ajouterArc(t, k, 3);
						NonG.ajouterArc(w, t, 5);
						NonG.ajouterArc(w, w, 5);
						NonG.ajouterArc(k, t, 5);
						NonG.ajouterArc(k, k, 5);
						System.out.println(" quel type d'affichage voulez vous ? ");
						System.out.println("1. Console ");
						System.out.println("2. Graphique  ");

						System.out.println("---------------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						affichage = lectureClavier.nextInt();
						if(affichage==0) {
							NonG.afficher();
						}
						else {
							 new dessinGraphe(NonG) ; 
						}
						Gfinal = NonG;
						break ; 
					case 3 :
						
						
						//genere un graphe oriente sans poids
						
						
						avec_Poids = false; // sans poids
						Graphe GsP = new Graphe( est_oriente , avec_Poids  ) ;
						
						System.out.println("-----------------------------------------------------------------------");
						do {
						System.out.println(" que voulez vous faire  ? ");
						
						System.out.println("1. ajouter un sommet  ");
						System.out.println("2. ajouter un arc  ");
						System.out.println("3. supprimer un sommet    ");
						System.out.println("4. supprimer un arc    ");
						System.out.println("5. Sortir   ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						switch (option) {
						case 1: {
							//ajouter sommet
							String contenu = "" ;
							System.out.println("Entrez le nom du sommet : ");
							contenu += lectureClavier.nextLine();
							System.out.println("Veuiller saisir un point :");
							int x, y;
							System.out.print("x : ");
							x = lectureClavier.nextInt();
							System.out.print("y : ");
							y = lectureClavier.nextInt();
							Point p = new Point(x, y) ; 
							liste.add(new Sommet(contenu , p , 1)) ; 
							GsP.ajouterSommet(liste.get(liste.size()-1));
							GsP.afficher();
							break ; 
						}
						case 2 : {
							//ajouter arc
							System.out.println("Veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
						
							int i , j ; 
							i = lectureClavier.nextInt();
							System.out.println("Veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							GsP.ajouterArc(liste.get(i-1), liste.get(j-1), 5);
							GsP.afficher();
						 break ;
						}
						case 3: 
						{
							//supprimer sommet
							System.out.println("Veuillez saisir le  sommet( pas de sommets 0 ) : ");
							int i = lectureClavier.nextInt();
							liste.remove(i-1) ; 
							GsP.supprimerSommet(liste.get(i-1));
							GsP.afficher();
							
							break ; 
						}
						case 4 : 
						{
							//supprimer arc
							System.out.println("Veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
							int i,j;
							i = lectureClavier.nextInt();
							System.out.println("Veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							GsP.enleverArc(liste.get(i-1), liste.get(j-1));
							GsP.afficher();
						 break ;
						}
						default:{ 
							System.out.println("Cette option n'existe pas");
						}
						}
						
						Gfinal = GsP;
						Gfinal.afficher();
						
						}while(option!= 5) ;
						
						
					case 4 :
					{
						
						//genere un graphe non oriente sans poids
						
						avec_Poids = false; // sans poids
						est_oriente = false; //non oriente
						Graphe Gnp= new Graphe( est_oriente , avec_Poids  ) ;
						
						System.out.println("-----------------------------------------------------------------------");
						do {
						System.out.println(" que voulez vous faire  ? ");
						
						System.out.println("1. ajouter un sommet  ");
						System.out.println("2. ajouter un arc  ");
						System.out.println("3. supprimer un sommet    ");
						System.out.println("4. supprimer un arc    ");
						System.out.println("5. Sortir   ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						switch (option) {
						case 1: {
							//ajouter sommet
							String contenu = "" ;
							contenu = lectureClavier.nextLine();
							System.out.println("Veuiller saisir un point :");
							int x, y;
							System.out.print("x : ");
							x = lectureClavier.nextInt();
							System.out.print("y : ");
							y = lectureClavier.nextInt();
							Point p = new Point(x, y) ; 
							liste.add(new Sommet(contenu , p , 1)) ; 
							Gnp.ajouterSommet(liste.get(liste.size()-1));
							break ; 
						}
						case 2 : {
							//ajouter arc
							System.out.println("Veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
						
							int i , j ; 
							i = lectureClavier.nextInt();
							System.out.println("Veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							Gnp.ajouterArc(liste.get(i-1), liste.get(j-1), 5);
							Gnp.afficher();
						 break ;
						}
						case 3: 
						{
							//supprimer sommet
							System.out.println("Veuillez saisir le  sommet( pas de sommets 0 ) : ");
							int i = lectureClavier.nextInt();
							liste.remove(i-1) ; 
							Gnp.supprimerSommet(liste.get(i-1));
							Gnp.afficher();
							
							break ; 
						}
						case 4 : 
						{
							//supprimer arc
							System.out.println("Veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
							int i,j;
							i = lectureClavier.nextInt();
							System.out.println("Veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							Gnp.enleverArc(liste.get(i-1), liste.get(j-1));
							Gnp.afficher();
						 break ;
						}
						default:{ 
							System.out.println("Cette option n'existe pas");
						}
						}
						
						Gfinal = Gnp;
						Gfinal.afficher();
						
						}while(option!= 5) ;
						
					}
						
					
					default:
						System.out.println("Cette option n'existe pas");
					}
					}while(choix!= 4 ) ; 
					
					break ; 
				case 2 : 
					do {
						System.out.println(" Choisissez un algorithme a appliquer ? ");
						
						System.out.println("1. Dantzig  ");
						System.out.println("2. Dijkstra  ");
						System.out.println("3. Kruskal   ");
						System.out.println("4. Ordonnancement   ");
						System.out.println("5. Prufer codage /decodage   ");
						System.out.println("6. Rang  ");
						System.out.println("7. Tarjan  ");		
						System.out.println("8. Sortie  ");	
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						
						switch (option) {
						case 1: {
							
							Graphe gDantzig = Gfinal;

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
							
							break ; 
						}
						}
						
					}while(option != 8) ; 
				case 3 : 
					
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
						
				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=4);

	}
}
