package Class;
import java.util.ArrayList;



public class Graphe {

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

    public int[] descente(int r,int[] aps,int[] fs,int[] dist){
        
        int nb_som = aps[0];
        int i = 0,j = 1,k = 0,ifin,s,t,it;

        int[] fil = new int[nb_som+1];
        fil[0] = nb_som;
        fil[1] = r;

        dist = new int[nb_som + 1];
        dist[0] = nb_som;

        for(int h = 1;h <= nb_som;h++)
            dist[h] = -1;
        
        dist[r] = 0;
        while(i < j){
            k++;
            ifin = j;

            while(i < ifin){
                i++;
                s = fil[i];
                it = aps[s];
                t = fs[it];

                while(t > 0){
                    if(dist[t] == -1){
                        j++;
                        fil[j] = t;
                        dist[t] = k;
                    }
                    t = fs[++it];
                }
            }
        }
        return dist;
    }

    // Regarder comment on peut l'adapter à la matrice d'adjacence
    public int[][] calcul_distnace(int[] fs,int[] aps,int[][] dist){

        int n = aps[0];
        dist = new int[n+1][n+1];

        for(int i = 1;i <= n;i++){
            descente(i,fs,aps,dist[i]);
        }

        dist[0] = new int[1];
        dist[0][0] = n;

    	return dist; 
    }

    public void det_ddi(int[] aps,int[] fs,int[] ddi){
        int n = aps[0];

        ddi[0] = n;

        for(int i = 1;i <= n;i++)
            ddi[i] = 0;
        
        for(int i = 1;i < fs[0];i++){
            if(fs[i] != 0){
                ddi[fs[i]]++;
            }
        }
    }

    public void empiler(int x,int[] pilch){
        pilch[x] = pilch[0];
        pilch[0] = x;
    }

    public void ddiNul(int[] ddi,int x,int[] pilch){
        if(ddi[x] == 0)
            empiler(x,pilch);
    }

    //Regarder comment calculer le rang avec la matrice d'adjacence
    public int[] rang(int[] rang,int[] fs,int[] aps){
        
        int n = aps[0];
        int s,k,h,t;

        int[] pilch = new int[n+1];
        int[] prem = new int[n+1];
        int[] ddi = new int[n+1];

        det_ddi(aps, fs, ddi);

        pilch[0] = 0;
        for(s = 1;s <= n;s++){
            rang[s] = -1;
            ddiNul(ddi, s, pilch);
        }

        k = -1;
        s = pilch[0];
        prem[0] = s;

        while(pilch[0] > 0){
            k++;
            pilch[0] = 0;

            while(s > 0){
                rang[s] = k;
                h = aps[s];
                t = fs[h];

                while(t > 0){
                    ddi[t]--;
                    ddiNul(ddi, t, pilch);
                    h++;
                    t = fs[h];
                }
                s = pilch[s];
            }
            s = pilch[0];
            prem[k+1] = s;
        }

        return rang;
    }

    public Graphe Tarjan(){
     	return null ; 
    }
    public void ordonnacement(){}
    public void Dijkstra(){}
    public void Dantzig(){}
    public void Prufer(){}
    
}
