
package Affichage;
import javax.swing.*;

import Class.Algorithme;
import Class.Graphe;
import Class.Sommet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class dijkstra  extends JFrame{
	private Graphe G ; 
	
	public dijkstra(Graphe G){
		this.G = G ; 
        setTitle("Drawing a Graph");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
    	BufferedImage result;
    	result = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
    //	Graphics2D g2d = (Graphics2D) result.createGraphics(); 
    	Graphics2D g2d = (Graphics2D) g ; 
    	/** Definit une epaisseur de 5 pixels */ 
    	//g2d.setStroke(new BasicStroke( 5.0f ));

    	//g2d.setFont(new Font("Serif",Font.PLAIN,12)); 
		Algorithme A_Dikjstra = new Algorithme();
    	int n =G.Aps_Get(0) ;
		int m = G.Fs_Get(0)-n  ;
		 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
		 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
		A_Dikjstra.Dikjstra(1,G,predecesseur,distance) ; 

    	
        for(int i = 0 ; i < G.nombre_sommets(); i++) {
        	Sommet s = G.liste_sommets_Get(i)  ; 
        	int x = s.getPosition().getX(); 
        	int y = s.getPosition().getY() ;
        	g2d.setColor(Color.BLACK); 
        	g2d.drawOval(x-5, y-5, 50, 50);
        	g2d.setColor(Color.RED); 
        	String str = s.getContenu() ; 
        	g2d.drawString(str, x+20, y+20);
        	
        }
        g2d.setColor( Color.blue );
        //dessin des arc par rapport a fs et aps youppi 
        
       int Num_Sommet = 0 ; 
       
       for(int i = 1 ; i < predecesseur.size(); i++) {
    	   
    	   Sommet s =  G.liste_sommets_Get(i) ; 
    	   
    	  
    		   //c'est que y'a des successeur 
    		   Sommet t =  G.liste_sommets_Get(predecesseur.get(i)) ; 
    		   	int x1 = s.getPosition().getX() +10; 
           		int y1 = s.getPosition().getY() +10;
           	 	int x2 = t.getPosition().getX()+10; 
           		int y2 = t.getPosition().getY()+10 ;
    		   g2d.drawLine(x1,y1,x2,y2);
    		  
    	  
  
       }
       g2d.dispose();

    }
}