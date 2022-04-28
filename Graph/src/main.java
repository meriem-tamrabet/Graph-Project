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
			Sommet s = new Sommet("S",new Point(100, 200) , 1) ;
			Sommet t = new Sommet("T" , new Point(400, 260) , 1) ;  
			Sommet w = new Sommet("P", new Point(100, 500) , 1) ;  
			Sommet k = new Sommet("K" , new Point(500, 450) , 1) ;  
			Sommet L = new Sommet("L" , new Point(100, 450) , 1) ;  

		byte choix=0;
		byte option=0;
		int affichage =0 ; 

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
				{
					do{System.out.println("--------------------------------cree un graphe---------------------------------------");

					System.out.println("1. generer un graphe oriente avec 5 sommets");
					System.out.println("2. generer un graphe non  oriente avec 5 sommets"); 
					System.out.println("3. generer un graphe oriente sans poids");
					System.out.println("4. generer un graphe non orieente sans poids");
					System.out.println("5. generer un graphe oriente avec poids");
					System.out.println("6. generer un graphe non oriente avec poids");
					System.out.println("7. sortir");
					
					System.out.println("---------------------------------------------------------------------------");

					System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
					choix = lectureClavier.nextByte();
					switch (choix) {
					case 1: 
					{	//generer un graphe oriente avec 5 sommets
						Graphe G = new Graphe( est_oriente , avec_Poids);
						
						G.ajouterSommet(s);
						G.ajouterSommet(t);
						G.ajouterSommet(w);
						G.ajouterSommet(k);
						
						liste.add(s) ; liste.add(t) ; liste.add(w) ; liste.add(k) ; 
						
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
							System.out.println("Save   ");

							G.sauvgarde();
						}
						else {
							 new dessinGraphe(G) ; 
						}
						G.actions(liste);
						break ; 
					}
					case 2 :
					{	//generer un graphe non oriente avec 5 sommets
						est_oriente = false;
						Graphe NonG = new Graphe( est_oriente , avec_Poids  ) ;

						NonG.ajouterSommet(s);
						NonG.ajouterSommet(t);
						NonG.ajouterSommet(w);
						NonG.ajouterSommet(k);

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
						if(affichage==1) {
							NonG.afficher_matrice();
						}
						else {
							 new dessinGraphe(NonG) ; 
						}
						
						break ; 
					}
					case 3 :
					{	
						//genere un graphe oriente sans poids
						
						avec_Poids = false; 
						est_oriente = true; 
						Graphe GsP = new Graphe( est_oriente , avec_Poids  ) ;
						
						GsP.actions(liste);
						break;
					}	
					case 4 :
					{	
						//genere un graphe non oriente sans poids
						
						avec_Poids = false; 
						est_oriente = false; 
						Graphe Gnp= new Graphe( est_oriente , avec_Poids  ) ;
						
						Gnp.actions(liste);
						break;
					}
					
					case 5: 
					{
						//genere un graphe oriente avec poids
						avec_Poids = true;
						est_oriente = true;
						Graphe Gop = new Graphe(est_oriente, avec_Poids);
						
						Gop.actions(liste);
						break;
					}
					case 6: 
					{
						//genere un graphe non oriente avec poids 
						
						avec_Poids = true; 
						est_oriente = true;
						Graphe GnP = new Graphe (est_oriente, avec_Poids);
						
						GnP.actions(liste);
						break;
					}
					
					default:
						System.out.println("cette option n'existe pas");
					}
					}while(choix!= 7) ; 
					
					break ; 
				}
				case 2 : 
				{	
					//exemple d algorithme
					
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
						System.out.println("8. Demi degre interieur  ");	
						System.out.println("9. Demi degre exterieur  ");
						System.out.println("10. Calcul des distances ");
						System.out.println("11. Sortir ");
						System.out.println("-----------------------------------------------------------------------");

						System.out.println("VEUILLEZ ENTREZ VOTRE CHOIX: ");
						algo = lectureClavier.nextByte();
						System.out.println("-----------------------------------------------------------------------");
						
						switch (algo) {
						case 1: {	
							
							//Dantzig
							
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
							
							break ; 
						}
						case 2:	
						{
						
							System.out.println(" algo de dikjstra");

							Graphe gDikjstra = new Graphe(avec_Poids,est_oriente);
							// -------------- Sommet --------------
							Sommet s1 = new Sommet("Reims",new Point(100, 400) , 1) ; //sommets 0 et marque 1
							Sommet s2 = new Sommet("Nice" , new Point(400, 300) , 1) ;  //sommets 1 et marque 1
							Sommet s3 = new Sommet("Paris", new Point(400, 600) , 1) ;  //sommets 2 et marque 1
							Sommet s4 = new Sommet("Brest" , new Point(700, 400) , 1) ;  //sommets 2 et marque 1
							Sommet s5 = new Sommet("Tours" , new Point(700, 100) , 1) ;  //sommets 2 et marque 1
							Sommet s6 = new Sommet("Lille" , new Point(700, 700) , 1) ;  //sommets 2 et marque 1
							Sommet s7 = new Sommet("Lyon" , new Point(100, 700) , 1) ;  //sommets 2 et marque 1

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

							gDikjstra.afficher_matrice();
							gDikjstra.afficher_cout();
							gDikjstra.afficher_fs_aps();
							Algorithme A_Dikjstra = new Algorithme();
							int n =gDikjstra.getApsElem(0) ;
							int m = gDikjstra.getFsElem(0)-n  ;
							 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
							 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
							A_Dikjstra.Dijkstra(1,gDikjstra,predecesseur,distance) ; 
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
							Graphe gprufer = new Graphe(est_oriente, avec_Poids);
							gprufer.ajouterSommet(s);
							gprufer.ajouterSommet(t);
							gprufer.ajouterSommet(w);
							gprufer.ajouterSommet(k);
							gprufer.ajouterArc(s, t, 1);
							gprufer.ajouterArc(s, k, 2 );
							gprufer.ajouterArc(t, w, 3);

							gprufer.afficher_fs_aps();
							int n = gprufer.nombre_sommets_matrice() ; 
							ArrayList<Integer> pref = new ArrayList<Integer>(n-1) ;
							Algorithme A_prufer = new Algorithme() ; 
								A_prufer.Prufer_encode(pref, gprufer) ; 
								

							new dessinGraphe(gprufer) ; 
							System.out.println("Affichage du pref ");
							for(int i = 0 ; i < pref.size() ; i++)
								System.out.print(pref.get(i) +"| ");
								//new dijkstra(gDikjstra) ; 
							break;
						}
						case 6: 	
						{
							//Rang
							Graphe gRang = new Graphe(true,true);

							gRang.ajouterSommet(s);
							gRang.ajouterSommet(t);
							gRang.ajouterSommet(w);
							gRang.ajouterSommet(k);
						
					
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
						}
						case 7: 
						{
							//Tarjan 
							System.out.println("ne fonctionne pas encore! veuillez patienter! ");
							break;
						}
						case 8 : 
						{
							// Demi degre interieur 
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
							str1 += "-----------Demi Degr� Int�rieur------------\n|";
							for(Integer i:ddi){
								str1 += i + "|";
							}
							str1 += "\n";
							System.out.println(str1);
							
							break;
						}
						case 9: 
						{
							//Demi degre exterieur
							
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
							str2 += "-----------Demi Degr� Ext�rieur-----------\n|";
							for(Integer i:dde){
								str2 += i + "|";
							}
							str2 += "\n";

							System.out.println(str2);

							break;
						}
						case 10: 
						{
							//Calcul de distance
							
							break;
						}
						}
						
					}while(algo != 11)  ; 
				}	
				case 3 : 
				{
					try {
						UIManager.setLookAndFeel(new NimbusLookAndFeel());
					} catch (UnsupportedLookAndFeelException e) {
						e.printStackTrace();
					}
						
					Graphe G = new Graphe( est_oriente , avec_Poids  );
					
					G.ajouterSommet(s);
					G.ajouterSommet(t);
					G.ajouterSommet(w);
					G.ajouterSommet(k);
					
					liste.add(s) ; liste.add(t) ; liste.add(w) ; liste.add(k) ; 

					G.ajouterArc(s, t, 1);
					G.ajouterArc(s, k, 2 );
					G.ajouterArc(t, k, 3);
					G.ajouterArc(w, t, 5);
					G.ajouterArc(w, w, 5);
					G.ajouterArc(k, t, 5);
					G.ajouterArc(k, k, 5);
					MyWindow Fenetre = new MyWindow(G) ; 
					Fenetre.setVisible(true) ;
					break ; 
				}
				default:
					System.out.println("Cette option n'existe pas");

			}
		}while(choix!=4);
		
	}
	

}
