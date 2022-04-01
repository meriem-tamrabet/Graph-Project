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
    public GrapheListe(Sommet...sommets){
        fs = new int[sommets.length+1];
        aps = new int[sommets.length+1];

        fs[0] = sommets.length;
        aps[0] = sommets.length;

        for(int i = 1;i <= sommets.length;i++){
            fs[i] = 0;
            aps[i] = sommets[i-1].getId();
        }
    }

    //------------------------METHODES------------------------

    public int nombre_sommets(){
        return aps[0];
    }

    public void ajouterSommet(Sommet s){
        
        int[] copyfs = new int[fs.length+1];
        int[] copyaps = new int[aps.length+1];
        
        copyfs[0] = fs[0]++;
        copyaps[0] = aps[0]++;

        for(int i = 1; i < aps.length;i++){
            copyaps[i] = aps[i];
        }
        copyaps[aps.length] = s.getId();

        for(int i = 1; i < fs.length;i++){
            copyfs[i] = fs[i];
        }
        copyfs[fs.length] = 0;

        aps = copyaps;
        fs = copyfs;

    }

    public boolean existeArc(Sommet s,Sommet t){
        int i = aps[s.getId()];

        while(fs[i] != 0){
            if(fs[i] == t.getId())
                return true;
            i++;
        }

        return false;

    }

    public void ajouterArc(Sommet s,Sommet t,int val){

        int[] copyfs = new int[fs.length+1];

        copyfs[0] = fs[0]++;

        for(int i = 1;i < copyfs.length;i++){
            copyfs[i] = 0;
        }

        int i = 1;
        int n = 1;
        while(i != s.getId()) i++;

        for(n = 1;n < fs[aps[i]];n++)
            copyfs[n] = fs[n];
        

        //le sommet n'est pas dans la liste des successeurs
        boolean in = false;
        int j = aps[i];
        


        if(fs[j] != 0){
            System.out.println("fs[j]!=0");
            for(;in == false;j++){
                if(t.getId() < fs[j] || fs[j] == 0){
                    System.out.println("Youhou on l'ajoute");
                    copyfs[j] = t.getId();
                    in = true;
                }
                else{
                    System.out.println("Ah bah non");
                    copyfs[j] = fs[j];
                }
            }
        }

        else{
            System.out.println("fs[j]==0");
            copyfs[j] = t.getId();
        }

        for(i = i+1;i < aps.length;i++){
            aps[i]++;
        }

        int k = j;
        for(j = j+1;j < copyfs.length;j++){
            copyfs[j] = fs[k];
            k++;
        }

        fs = copyfs;

        System.out.println("----------TEST-------");
        System.out.println(this.toString());
        System.out.println("--------------------");

    }

    public int valeurArc(Sommet s, Sommet t){
        return 0;
    }

	public void enleverArc(Sommet s, Sommet t){

        int[] copyfs = new int[nombre_sommets()+fs.length];

        copyfs[0] = fs[0]--;

        int i = 1;
        while(i != s.getId());

        for(int n = 1;n < fs[aps[i]];n++)
            copyfs[n] = fs[n];

        //l'arc n'existe plus
        boolean out = false;
        int j = aps[i];

        for(j = aps[i];fs[j] != 0 && out == false;j++){
            if(t.getId() == fs[j]){
                copyfs[j] = fs[j+1];
                out = true;
            }
            else{
                copyfs[j] = fs[j];
            }
        }

        for(;i < aps.length;i++){
            aps[i]--;
        }
        
        int k = j+1;
        for(;j < copyfs.length;j++){
            copyfs[j] = fs[k];
            k++;
        }

        fs = copyfs;

    }

    @Override
    public String toString(){
        String str = "";

        str += "FS : |";
        for(int i = 1;i < fs.length;i++){
            str += fs[i] + "|";
        }
        
        str += "\nAPS : |";

        for(int i = 1;i < aps.length;i++){
            str += aps[i] + "|";
        }

        return str;
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
