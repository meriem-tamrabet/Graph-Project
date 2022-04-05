package Class;

import java.util.*;

public class GrapheOriente extends Graphe{

    private GrapheListe l;
    private GrapheMatrice m;
    
	
	public  void ajouterSommet(Sommet s) {
		
	}
	public  boolean existeArc(Sommet s, Sommet t) {
		return true ; 
	}
	public  void ajouterArc(Sommet s, Sommet t, int val) {
		
	}
	public  int valeurArc(Sommet s, Sommet t)
	{
		return 0 ; 
	}
	public  void enleverArc(Sommet s, Sommet t)
	{
		
	}
//------------------------CONSTRUCTEUR------------------------

    public GrapheOriente(int[] fs,int[] aps){
        l.setFs(fs);
        l.setAps(aps);
        //m = l.fs_apsToMatrice();
    }

    public GrapheOriente(int[][] matrice){
       // m = matrice;
        //l = fs et aps générer ==> à faire
    }

//----------------------GETTERS ET SETTERS---------------------------------

    public GrapheListe getListe(){
        return l;
    }

    public GrapheMatrice getMatrice(){
        return m;
    }

    public void setListe(GrapheListe l){
        this.l = l;
    }

    public void setMatrice(GrapheMatrice m){
        this.m = m;
    }

//--------------------------METHODES------------------------------

    public int nombre_sommets(){
        return m.nombre_sommets(); // ou return l.nombre_sommets(); ça en revient exactement au même
    }
 /*       
    public void ajouterSommet(Sommet s){
        if(this.isInstance(GrapheListe)){
            l.ajouterSommet(s);
        }
        else{
            m.ajouterSommet(s);
        }
    }

    public void supprimerSommet(Sommet s){
        if(this.isInstance(GrapheListe)){
            l.supprimerSommet(s);
        }
        else{
            m.supprimerSommet(s);
        }
    }

    public boolean existeArc(Sommet s, Sommet t){
        if(this.isInstance(GrapheListe)){
            return l.existeArc(s, t);
        }
        return m.existeArc(s, t);

    }

    public void ajouterArc(Sommet s, Sommet t, int val){
        if(this.isInstance(GrapheListe)){
            l.ajouterArc(s,t,val);
        }
        else{
            m.ajouterArc(s,t,val);
        }
    }

    public int valeurArc(Sommet s, Sommet t){
        if(this.isInstance(GrapheListe)){
            return l.valeurArc(s, t);
        }
        return m.valeurArc(s, t);
    }

    public void enleverArc(Sommet s, Sommet t){
        if(this.isInstance(GrapheListe)){
            l.enleverArc(s,t);
        }
        else{
            m.enleverArc(s,t);
        }
    }
*/
//--------------------------ALGORITHMES-----------------------------

    public boolean Dantzig(double[][] c){
        int n = (int)(c[0][0]);
        int i,j,k;
        double x;

        for(k = 1;k < n;k++){
            for(i = 1;i <= k;i++){
                for(j = 1;j <= k;j++){
                    if((x = c[i][j] + c[j][k+1]) < c[i][k+1]){
                        c[i][k+1] = x;
                    }

                    if((x = c[k+1][j] + c[j][i]) < c[k+1][i]){
                        c[k+1][i] = x;
                    }
                }
                if((c[i][k+1] + c[k+1][i]) < 0){
                    System.out.println("Circuit absorbant passant par " + i + " et " + k+1);
                    return false;
                }
            }

            for(i = 1;i <= k;i++){
                for(j = 1;j <= k;j++){
                    if((x = c[i][k+1] + c[k+1][j]) < c[i][j]){
                        c[i][j] = x;
                    }
                }
            }
        }

        return true;

    }

    public int[] dde(){
        int n = l.getAps()[0];
        int[] dde = new int[n+1];

        dde[0] = n;
        for(int s = 1;s < n;s++){
            dde[s] = l.getAps()[s+1] - l.getAps()[s] - 1;
        }

        dde[n] = l.getFs()[0] - l.getAps()[n];

        return dde;
    }

    public int[] ddi(){
        int n = l.getAps()[0];
        int[] ddi = new int[n+1];

        ddi[0] = n;
        for(int s = 1;s <= n;s++){
            ddi[s] = 0;
        }

        for(int k = 1;k < l.getFs()[0];k++){
            if(l.getFs()[k] != 0){
                ddi[l.getFs()[k]]++;
            }
        }

        return ddi;
    }

    public int[] descente_largeur(int r){

        int nb_sommets = l.getAps()[0];
        int i = 0, j = 1,k = 0,ifin,s,t,it;
        
        int[] fil = new int[nb_sommets + 1];
        fil[0] = nb_sommets;

        int[] dist = new int[nb_sommets+1];
        dist[0] = nb_sommets;

        fil[1] = r;

        for(int h = 1;h <= nb_sommets;h++){
            dist[h] = -1;
        }

        dist[r] = 0;

        while(i < j){
            k++;
            ifin = j;
            while(i < ifin){
                i++;
                s = fil[i];
                it = l.getAps()[s];
                t = l.getFs()[it];

                while(t > 0){
                    if(dist[t] == -1){
                        j++;
                        fil[j] = t;
                        dist[t] = k;
                    }

                    t = l.getFs()[++it];
                }
            }
        }


        return dist;
    }


    public void empiler(int x,int[] pilch){
        pilch[x] = pilch[0];
        pilch[0] = x;
    }

    public int[] rang(){
        int n = l.nombre_sommets();
        int taillefs = l.getFs()[0];
        int s, k ,h ,t;

        int[] rang = new int[n+1];
        int[] pilch = new int[n+1];
        int[] prem = new int[n+1];

        int[] ddi = ddi();

        pilch[0] = 0;
        for(s = 1;s <= n;s++){
            rang[s] = -1;
            if(ddi[s] == 0){
                empiler(s,pilch);
            }
        }

        k = -1;
        s = pilch[0];
        prem[0] = s;

        while(pilch[0] > 0){
            k++;
            pilch[0] = 0;

            while(s > 0){
                rang[s] = k;
                h = l.getAps()[s];
                t = l.getFs()[h];

                while(t > 0){
                    ddi[t]--;
                    if(ddi[t] == 0){
                        empiler(t,pilch);
                    }
                    h++;
                    t = l.getFs()[h];
                }
                s = pilch[s];
            }
            s = pilch[0];
            prem[k+1] = s;
        }

        return rang;
    }

}