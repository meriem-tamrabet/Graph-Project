
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
        setTitle("Dijkstra");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
    	BufferedImage result;
    	result = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
    //	Graphics2D g2d = (Graphics2D) result.createGraphics(); 
    	Graphics2D g2d = (Graphics2D) g ; 
    	/** Definit une epaisseur de 5 pixels */ 
    	//g2d.setStroke(new BasicStroke( 5.0f ));

    	//g2d.setFont(new Font("Serif",Font.PLAIN,12)); 
		Algorithme A_Dikjstra = new Algorithme();
    	int n =G.getApsElem(0) ;
		int m = G.getFsElem(0)-n  ;
		 ArrayList<Integer> predecesseur = new ArrayList<>(n+2) ;
		 ArrayList<Integer> distance = new ArrayList<Integer>(n+2) ;
		A_Dikjstra.Dijkstra(1,G,predecesseur,distance) ; 

    	
        for(int i = 0 ; i < G.nombre_sommets_aps(); i++) {
        	Sommet s = G.getListeSommetElem(i)  ; 
        	int x = s.getPosition().getX(); 
        	int y = s.getPosition().getY() ;
        	g2d.setColor(Color.BLACK); 
        	g2d.drawOval(x-5, y-5, 30, 30);
        	g2d.setColor(Color.RED); 
        	String str = s.getContenu() ; 
        	g2d.drawString(str, x+5, y+7);
        	
        }
        g2d.setColor( Color.blue );
        
       int Num_Sommet = 0 ; 
  
       for(int i = 1 ; i < predecesseur.size(); i++) {
    	   if ( predecesseur.get(i) != 0 ) {
    		   Sommet s =  G.getListeSommetElem(predecesseur.get(i) -1 ) ; 
    		   Sommet t =  G.getListeSommetElem(i-1) ;
    		 	int x1 = s.getPosition().getX() ; 
           		int y1 = s.getPosition().getY() ;
           	 	int x2 = t.getPosition().getX(); 
           		int y2 = t.getPosition().getY() ; 
    		   g2d.drawLine(x1,y1,x2,y2);
    	   }
       }
       g2d.dispose();

    }
}
