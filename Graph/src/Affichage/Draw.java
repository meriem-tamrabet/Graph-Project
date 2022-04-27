package Affichage;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

import Class.Graphe;
import Class.Sommet;

public class Draw extends JPanel
{
	private Graphe G ; 
	public Draw(Graphe G) {
		this.G = G ; 
	}
 public void paint(Graphics g2d){
 

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
     //dessin des arc par rapport a fs et aps youppi 
     
    int Num_Sommet = 0 ; 
   
    for(int i = 1 ; i < G.getFsElem(0)+1; i++) {
 	   Sommet s =  G.getListeSommetElem(Num_Sommet) ; 
 	   
 	   while(G.getFsElem(i)!= 0 ) {
 		   //c'est que y'a des successeur 
 		   Sommet t =  G.getListeSommetElem(G.getFsElem(i)-1) ; 
 		   	int x1 = s.getPosition().getX() ; 
        		int y1 = s.getPosition().getY() ;
        	 	int x2 = t.getPosition().getX() ; 
        		int y2 = t.getPosition().getY() ;
        		/*	if(x1> x2 ) //je trace a gauche donc sommet depart recule
        		{
        			x1 -= 15 ; 
        			x2 += 15 ; 
        		}
        		else {
            		// je trace adroit 
            			x1 += 15 ; 
            			x2 += 15 ;
            		}
        		
        	
        		if(y1> y2 ) //je trace a haut 
        		{
        			y1 -= 15 ; 
        			y2 += 15 ; 
        		}
        		else {
        		// je trace en bas  
        			y1 += 15 ; 
        			y2 -= 15 ; 
        		}*/
        			
 		   g2d.drawLine(x1,y1,x2,y2);
 		   i++; 
 	   }
 	   Num_Sommet++ ; 
    }
    g2d.dispose();

 } 
 
 

}
