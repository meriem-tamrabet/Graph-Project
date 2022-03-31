package Class;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Vector;

public class GrapheListe extends Graphe{

    //private Vector<LinkedList<Arc>> liste;
    //private Cle_Sommets identifiant;

    private int[] fs;
    private int[] aps;

//------------------------CONSTRUCTEUR------------------------
    public GrapheListe(int nbSommets){
        fs = new int[nbSommets+1];
        aps = new int[nbSommets+1];

        fs[0] = nbSommets;
        aps[0] = nbSommets;

        for(int i = 1;i < fs.length;i++){
            fs[i] = 0;
            aps[i] = 0;
        }
    }

    //------------------------METHODES------------------------

    public int taille(){
        return aps.length;
    }

    public void aujouterSommet(Sommet s){
        
        int[] copyfs = new int[taille()+1];
        int[] copyaps = new int[taille()+1];
        
        copyfs[0] = fs[0]++;
        copyaps[0] = aps[0]++;

        int i = 1;
        while(i++ != s.getMarquee()){
            copyfs[i] = fs[i];
            copyaps[i] = aps[i];
        }

        copyfs[i] = s.getMarquee();
        copyaps[i] = s.getMarquee();

        while(i++ < taille()+1){
            copyaps[i] = aps[i];
            copyfs[i] = fs[i];
        }

    }

    public boolean existeArc(Sommet s,Sommet t){
        int i = aps[s.getMarquee()];

        while(fs[i] != 0){
            if(fs[i] == t.getMarquee())
                return true;
            i++;
        }

        return false;

    }

    public void ajouterArc(Sommet s,Sommet t,int val){

    }

    public int valeurArc(Sommet s, Sommet t){

    }

	public void enleverArc(Sommet s, Sommet t){

    }

    /*public  int taille(){
        return liste.size();
    }

    public void ajouterSommet(Sommet s){
        if(identifiant.ajouterElement(s)){
            liste.set(identifiant.numero(s), new LinkedList<Arc>());
        }
    }


    public boolean existeArc(Sommet s, Sommet t){

        for(Arc a: liste.get(identifiant.numero(s))){
            if((a.getS2()).equals(t))
                return true;
        }
        return false;
    }


    public void ajouterArc(Sommet s, Sommet t, int val){
        ajouterSommet(s);
        ajouterSommet(t);
        int numS = identifiant.numero(s);
        liste.get(numS).addLast(new Arc(s,t,val));
    }

    /*public void ajouterArc(int i, int j, int val){
        liste.get(i).addLast(new Arc(identifiant.elementAt(i),
                identifiant.elementAt(j),val));
    }*/

    public  int valeurArc(Sommet s, Sommet t){
        for(Arc a: liste.get(identifiant.numero(s))){
            if(a.getS2().equals(t)){
                return a.getPoids();
            }
        }
        return -1;
    }

    /*public int valeurArc(int i, int j){
        Sommet t = identifiant.elementAt(j);
        for(Arc a : liste.get(i)) {
            if (a.getS2().equals(t)) {
                return a.getPoids();
            }
        }
        return -1; // convention
    }*/
    public void enleverArc(Sommet s, Sommet t){
        int numS= identifiant.numero(s);
        Arc arc= null;
        for(Arc a : liste.get(identifiant.numero(s))){
            if(a.getS2().equals(t)){
                arc=a;
                break;
            }
        }
        if(arc!=null)
            liste.get(identifiant.numero(s)).remove(arc);
    }


    public void afficherListe(){
        for(int i=0; i<liste.size(); i++){
            System.out.println(+i +":");

            for(int j=0; j<liste.get(i).size(); j++){
                System.out.println("->"+ liste.get(i).get(j));
            }
            System.out.println();

        }
    }
    @Override
    public String toString() {
        return "GrapheListe{" +
                "liste=" + liste +
                ", identifiant=" + identifiant +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
