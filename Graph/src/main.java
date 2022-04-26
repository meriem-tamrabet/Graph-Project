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

		byte choix=0; // on choisit le type byte pour utiliser moins d'espace memoire
		byte option=0;
		int affichage =0 ; 

		//On utilise la boucle do...while, elle permet d'entrer et d'exécuter au moins une fois la boucle
		// avant la saisie du choix de l'utilisateur.
		do{
			System.out.println("--------------------------------MENU---------------------------------------");
		
			System.out.println("1. cree un graphe ");
			System.out.println("2. Exemple d'algorithme  ");
			System.out.println("3. application ");
			System.out.println("4. sortir ");
			
			System.out.println("---------------------------------------------------------------------------");

			System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
			choix = lectureClavier.nextByte();
			
			System.out.println("-----------------------------------------------------------------------");


			switch (choix){
				case 1:
					do{System.out.println("--------------------------------cree un graphe---------------------------------------");

					System.out.println("1. generer un graphe oriente avec 5 sommets");
					System.out.println("2. generer un graphe non  oriente avec 5 sommets"); 
					System.out.println("3. generer un graphe oriente sans poids");
					System.out.println("4. generer un graphe non orieente sans poids");
					System.out.println("5. sortir");
					
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
						if(affichage==1) {
							G.afficher_fs_aps();
							
						}
						else {
							 new dessinGraphe(G) ; 
						}
						System.out.println("-----------------------------------------------------------------------");
						do {
						System.out.println(" que voulez vous faire ? ");
						
						System.out.println("1. ajouter un sommet  ");
						System.out.println("2. ajouter un arc  ");
						System.out.println("3. supprimer un sommet    ");
						System.out.println("4. supprimer un arc    ");
						System.out.println("5. appliquer un algorithme");
						System.out.println("6. sortir");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
							switch (option) {
							case 1: {
								String contenu = "";
								System.out.println("entrer le nom du sommet :");
								contenu = lectureClavier.next();
								System.out.println("veuiller saisir un point :");
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
									//supprimer un sommet
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
							case 5 : 
							{
								//algorithme a appliquer
								G.algorithme();
							}
							default:
								System.out.println("Cette option n'existe pas");
							}
							
							G.afficher();
						}while(option!= 6) ; 
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
						System.out.println("5. appliquer un algorithme   ");
						System.out.println("6. sortir  ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						switch (option) {
						case 1: {
							//ajouter sommet
							String contenu = "" ;
							System.out.println("entrez le nom du sommet : ");
							contenu += lectureClavier.next();
							System.out.println("veuiller saisir un point :");
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
							System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
						
							int i , j ; 
							i = lectureClavier.nextInt();
							System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							GsP.ajouterArc(liste.get(i-1), liste.get(j-1), 5);
							GsP.afficher();
						 break ;
						}
						case 3: 
						{
							//supprimer sommet
							System.out.println("veuillez saisir le  sommet( pas de sommets 0 ) : ");
							int i = lectureClavier.nextInt();
							liste.remove(i-1) ; 
							GsP.supprimerSommet(liste.get(i-1));
							GsP.afficher();
							
							break ; 
						}
						case 4 : 
						{
							//supprimer arc
							System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
							int i,j;
							i = lectureClavier.nextInt();
							System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							GsP.enleverArc(liste.get(i-1), liste.get(j-1));
							GsP.afficher();
						 break ;
						}
						case 5 : 
						{
							//algorithme
							
							GsP.algorithme();
						}
						default:{ 
							System.out.println("cette option n'existe pas");
						}
						}
						
						GsP.afficher();
						
						}while(option!= 6) ;
						
						
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
						System.out.println("5. appliquer un algorithme");
						System.out.println("6. sortie  ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						option = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						switch (option) {
						case 1: {
							//ajouter sommet
							String contenu = "" ;
							System.out.println("entrez le nom du sommet : ");
							contenu += lectureClavier.next();
							System.out.println("veuiller saisir un point :");
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
							System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
						
							int i , j ; 
							i = lectureClavier.nextInt();
							System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							Gnp.ajouterArc(liste.get(i-1), liste.get(j-1), 5);
							Gnp.afficher();
						 break ;
						}
						case 3: 
						{
							//supprimer sommet
							System.out.println("veuillez saisir le  sommet( pas de sommets 0 ) : ");
							int i = lectureClavier.nextInt();
							liste.remove(i-1) ; 
							Gnp.supprimerSommet(liste.get(i-1));
							Gnp.afficher();
							
							break ; 
						}
						case 4 : 
						{
							//supprimer arc
							System.out.println("veuillez saisir le 1ere sommet( pas de sommets 0 )  : ");
							int i,j;
							i = lectureClavier.nextInt();
							System.out.println("veuillez saisir le 2eme sommet ( pas de sommets 0 ) : ");
							j = lectureClavier.nextInt();
							Gnp.enleverArc(liste.get(i-1), liste.get(j-1));
							Gnp.afficher();
						 break ;
						}
						case 5 : 
						{
							Gnp.algorithme();

						}
						default:{ 
							System.out.println("cette option n'existe pas");
						}
						}
						
						
						
						}while(option!= 6) ;
						
					}
						
					
					default:
						System.out.println("cette option n'existe pas");
					}
					}while(choix!= 4 ) ; 
					
					break ; 
				
				case 2 : 
					byte algo = 0;
					do {
						System.out.println(" Choisissez un algorithme a appliquer ? ");
						
						System.out.println("1. Dantzig  ");
						System.out.println("2. Dikjstra  ");
						System.out.println("3. Kruskal   ");
						System.out.println("4. Ordonnancement   ");
						System.out.println("5. Prufer codage /decodage   ");
						System.out.println("6. Rang  ");
						System.out.println("7. Tarjan  ");		
						System.out.println("8. Sortie  ");	
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						algo = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						
						switch (algo) {
						case 1: {	
							
							//Dantzig
							
							if(!avec_Poids && !est_oriente)
							{
								System.out.println("Votre graphe n'est pas compatible avec cet algorithme!");
							}
							
							else {

							
							}
							
							break ; 
						}
						case 2:	
						{
						
							System.out.println(" algo de dikjstra");

							if(!avec_Poids && !est_oriente)
							{
								System.out.println("Votre graphe n'est pas compatible avec cet algorithme!");
							}
							Graphe gDikjstra = new Graphe(avec_Poids,est_oriente);
							// -------------- Sommet --------------
							Sommet s1 = new Sommet("1",new Point(100, 400) , 1) ; //sommets 0 et marque 1
							Sommet s2 = new Sommet("2" , new Point(400, 300) , 1) ;  //sommets 1 et marque 1
							Sommet s3 = new Sommet("3", new Point(400, 600) , 1) ;  //sommets 2 et marque 1
							Sommet s4 = new Sommet("4" , new Point(700, 400) , 1) ;  //sommets 2 et marque 1
							Sommet s5 = new Sommet("5" , new Point(700, 100) , 1) ;  //sommets 2 et marque 1
							Sommet s6 = new Sommet("6" , new Point(700, 700) , 1) ;  //sommets 2 et marque 1
							Sommet s7 = new Sommet("7" , new Point(100, 700) , 1) ;  //sommets 2 et marque 1

							System.out.println("---------Ajout de sommets ------------") ;
							gDikjstra.ajouterSommet(s1);
							gDikjstra.ajouterSommet(s2);
							gDikjstra.ajouterSommet(s3);
							gDikjstra.ajouterSommet(s4);
							gDikjstra.ajouterSommet(s5);
							gDikjstra.ajouterSommet(s6);
							gDikjstra.ajouterSommet(s7);
						
					
							System.out.println("---------Ajout de arc  ------------") ;
							gDikjstra.ajouterArc(s1, s2, 1);
							gDikjstra.ajouterArc(s1, s5, 2);
							gDikjstra.ajouterArc(s1, s3, 3);
							gDikjstra.ajouterArc(s1, s7, 1);
							
							gDikjstra.ajouterArc(s2, s5, 1);
							gDikjstra.ajouterArc(s2, s3, 4);
							gDikjstra.ajouterArc(s3, s5, 3);
							gDikjstra.ajouterArc(s3, s6, 1);
							gDikjstra.ajouterArc(s4, s3, 1);
							gDikjstra.ajouterArc(s5, s4, 1);
							gDikjstra.ajouterArc(s6, s4, 1);
							gDikjstra.ajouterArc(s7, s3, 1);
							gDikjstra.ajouterArc(s7, s6, 3);

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
							break ; 
						}
						
						case 3:
						{
							//Kruskal
							break;
						}
						
						case 4 :
						{
							//Ordonnancement 
							break;
						}
						
						case 5 : 
						{
							//Prufer
							break;
						}
						case 6: 
							
						{
							break;
						}
						}
						
					}while(algo != 8)  ; 
					
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
						break ; 
				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=4);
	}
	

}
