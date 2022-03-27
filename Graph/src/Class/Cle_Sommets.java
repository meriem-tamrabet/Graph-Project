package Class;

import java.util.Hashtable;
import java.util.Vector;

public class Cle_Sommets {
	
	private int compteur;
	private Hashtable<Sommet,Integer> Sommet_cle;
	private Vector<Sommet> Tab_Sommet;
	/**
	 * le but est de cree un tableau qui pour chaque sommet a un id unique 
	 * 
	 * */
	public Cle_Sommets(int n){
		compteur = -1;
		Sommet_cle = new Hashtable<Sommet,Integer>();
		Tab_Sommet = new Vector<Sommet>(n);
		Tab_Sommet.setSize(n);
	}
	
	public int taille(){
		return Tab_Sommet.size();
	}
	/**
	 * Pour ajouter un sommet 
	 * faut d'abord regarder si y'a pas le mm somet 
	 * si y'a pas on incremente le compteur
	 * on l'ajout dans notre Sommet_cle avec son id 
	 * on push Tab_Sommet a lindice compteur le sommet s 
	 *  */
	public boolean ajouterElement(Sommet s){
		if(!Sommet_cle.containsKey(s)){
			compteur++;
			Sommet_cle.put(s, compteur);
			Tab_Sommet.set(compteur, s);
			return true;
		}
		return false;
	}
	
	public int numero(Sommet s){
		return Sommet_cle.get(s);
		}
	
	public Sommet elementAt(int i){
		return Tab_Sommet.elementAt(i);
		}
	
	
}
