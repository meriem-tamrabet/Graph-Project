package Class;
import java.util.ArrayList;



public abstract   class Graphe {
	
	public abstract int taille();
	
	public abstract void ajouterSommet(Sommet s);
	public abstract boolean existeArc(Sommet s, Sommet t);
	public abstract void ajouterArc(Sommet s, Sommet t, int val);
	public abstract int valeurArc(Sommet s, Sommet t);
	public abstract void enleverArc(Sommet s, Sommet t);
	
/*
    private ArrayList<Sommet> listeSommet = new ArrayList<Sommet>();

    private int[][] matriceAdjacente;
    private int[] fs;
    private int[] aps;

    public Graphe(int[][] matriceAdjacente){

        for(int i=0; i< matriceAdjacente.length;i++){
            for(int j=0; j<matriceAdjacente.length; j++){
                this.matriceAdjacente[i][j]= matriceAdjacente[i][j];
            }
        }

        int n = matriceAdjacente[0][0];
        int m = matriceAdjacente[0][1];

         int fs[] = new int[n+m];
         int aps[] = new int[n];

         matrineToFs(fs,aps,matriceAdjacente);
    }

    public Graphe(int []fs, int[] aps){

      for(int i=0; i<fs.length;i++){
          this.fs[i]=fs[i];
      }
        for(int i=0; i<aps.length;i++){
            this.aps[i]=aps[i];
        }

        int matriceAdjacente [][]= new int[aps[0]+1][aps[0]+1];
        fsToAps(fs,aps,matriceAdjacente);
    }

    public Graphe(){
        this.aps=null;
        this.fs=null;
        this.matriceAdjacente=null;
    }



    public void scan(){
    }

    public void fsToAps(int[] fs, int aps[], int[][] matrice){
        int k;
        int nbSommet = aps[0];
        int nbArc = fs[0] - nbSommet;
        matrice = new int[nbSommet + 1][];

        for(int i = 0; i<= nbSommet; i++){
            matrice[i]= new int[nbSommet+1];
        }

        matrice[0][0] = nbSommet;
        matrice[0][1] = nbArc;
        for(int i =1; i<=nbSommet; i++){
            for(int j=1; j<=nbSommet; j++){
                matrice[i][j] =0;
            }
        }

        for(int i=1; i<=nbSommet; i++){
            //for(k= aps[i]; (j=fs[k] )!= 0; k++){
                //matrice[i][j] = 1;}
            k= aps[i];
            while(fs[k] != 0){
                matrice[i][fs[k]] =1;
                k++;
            }

        }
    }



    public void matrineToFs(int[] fs, int aps[], int[][] matrice){
        int nbSommet = matrice[0][0];
        int nbArc = matrice[0][1];
        aps = new int[nbSommet+1];
        aps[0] = nbSommet;
        fs = new int [nbSommet+nbArc+1];
        aps[0]=nbSommet;
        fs[0] = nbSommet+nbArc;
        int k = 1;
        for(int i=1; i<= nbSommet; i++){
            aps[i] =k;
            for(int j=1; j<=nbSommet; j++){
                if(matrice[i][j]!=0){
                    fs[k++] =j;
                }
            }
            fs[k++]=0;
        }
    }


    public void affiche(){}
    public int[][] calcul_distnace(){
    	return null ; 
    }
    public void rang(){}
    public Graphe Tarjan(){
     	return null ; 
    }
    public void ordonnacement(){}
    public void Dijkstra(){}
    public void Dantzig(){}
    public void Prufer(){}
    */
}
