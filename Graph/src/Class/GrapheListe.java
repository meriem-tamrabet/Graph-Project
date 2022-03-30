package Class;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Vector;

public class GrapheListe extends Graphe{

    private Vector<LinkedList<Arc>> liste;
    private Cle_Sommets identifiant;

//------------------------CONSTRUCTEUR------------------------
    public GrapheListe(int n){
        identifiant= new Cle_Sommets(n);
        liste= new Vector<LinkedList<Arc>>(n);
        liste.setSize(n);
    }

    //------------------------METHODES------------------------
    public  int taille(){
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
