package Affichage;
import javax.swing.*;

import Class.Graphe;
import Class.Sommet;

import java.awt.*;
import java.awt.image.BufferedImage;
public class dessinGraphe  extends JFrame{
	private Graphe G ; 
	
	public dessinGraphe(Graphe G){
		this.G = G ; 
        setTitle("Drawing a Graph");
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
    	BufferedImage result;
    	result = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
    	//Graphics2D g2d = (Graphics2D) result.createGraphics(); 
    	Graphics2D g2d = (Graphics2D) g ; 
    	/** Definit une epaisseur de 5 pixels */ 
    	// g2d.setStroke(new BasicStroke( 5.0f ));
    	
    	//g2d.setFont(new Font("Serif",Font.PLAIN,12)); 
    	
    	
        for(int i = 0 ; i < G.nombre_sommets(); i++) {
        	Sommet s = G.liste_sommets_Get(i)  ; 
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
      
       for(int i = 1 ; i < G.Fs_Get(0)+1; i++) {
    	   Sommet s =  G.liste_sommets_Get(Num_Sommet) ; 
    	   
    	   while(G.Fs_Get(i)!= 0 ) {
    		   //c'est que y'a des successeur 
    		   Sommet t =  G.liste_sommets_Get(G.Fs_Get(i)-1) ; 
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
