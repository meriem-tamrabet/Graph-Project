package Affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Class.Graphe;
import Class.Sommet;
import Class.Point ;
public class MyWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5057619568735121297L;
	private Graphe G ; 
	public void setGraphe(Graphe G) {
		this.G = G ; 
	}
	public MyWindow( Graphe G ) {
		this.G = G ; 
		
		
		// dans le cas ou je ferme la fenetre 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(800,800));
		this.setLocationRelativeTo(null);

		this.setTitle("Mon application ");
	      JPanel panel = new JPanel();
	      JPanel pane2 = new JPanel();
	      JPanel panel_Supp = new JPanel();
	      JPanel panelA_Ajout = new JPanel();
	      JPanel panelA_Supp = new JPanel();
	      JPanel pane3 = new JPanel();
	      JPanel pane4 = new JPanel();
	      panel.setBounds(50,0,300,100);
	      pane2.setBounds(50,100,300,100);
	      panel_Supp.setBounds(50,200,200,100);
	      panelA_Ajout.setBounds(50,300,200,100);
	     
	      pane3.setBounds(350,0,300,200);
	      pane4.setBounds(50,400,600,300);
	      JCheckBox oriente =  new JCheckBox(" est oriente ") ; 
	      JCheckBox Poids =  new JCheckBox(" Avec poids ") ;
	      JButton Cree_Graphe  = new JButton("Generer  ") ; 
	      
	      Cree_Graphe.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	        	 
	        	  Boolean est_oriente = false ; 
	        	  Boolean poids = false ; 
	        	  if(oriente.isSelected())
	        	   est_oriente = true ; 
	        	  if(Poids.isSelected())
	        		  poids = true ; 
		        	  setGraphe(new Graphe(est_oriente, poids));
		              new dessinGraphe(G) ;

	          }
	      });
	      JButton Generer  = new JButton("Generer un graphe  ") ; 
	      panel.add(oriente) ; 
	      panel.add(Poids) ; 
	      panel.add(Cree_Graphe) ; 
	     
	      // deusxieme ligne 
	      JTextField contenu =  new JTextField("Contenu") ; 
	      JTextField X =  new JTextField(" X  ") ; 
	      JTextField Y =  new JTextField(" Y  ") ; 
	      JButton Ajout_Sommet  = new JButton("Ajouter sommet  ") ;
	      Ajout_Sommet.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	              String Str = contenu.getText() ; 
	              int x = Integer.parseInt(X.getText()) ; 
	              int y = Integer.parseInt(Y.getText()) ;
	              Sommet s = new Sommet(Str, new Point (x,y) , 1 ) ; 
	              G.ajouterSommet(s);
	              new dessinGraphe(G) ;
	          }
	      });
	      pane2.add(contenu) ;
	      pane2.add(X) ;
	      pane2.add(Y) ;
	      
	      pane2.add(Ajout_Sommet) ;
	      // 3 eme 
	      
	      JButton Sup_Sommet  = new JButton("Suprimer sommet   ") ;
	      JTextField Num =  new JTextField("Num") ; Num.setSize(10, 10);; 
	      Sup_Sommet.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	             
	              int x = Integer.parseInt(Num.getText()) ; 
	              Sommet S = G.getListeSommetElem(x) ; 
	              G.supprimerSommet(S);
	              new dessinGraphe(G) ;
	          }
	      }); 
	      panel_Supp.add(Num) ;
	      panel_Supp.add(Sup_Sommet) ;
	      // 4eme 
	      JTextField depart =  new JTextField("Depart") ; 
	      depart.setSize(10, 10);
	      JTextField arrivee =  new JTextField("Arrivee") ;
	      arrivee.setSize(10, 10);
	      JTextField poid_arc =  new JTextField("Poid d'arc ") ;
	      poid_arc.setSize(10, 10);
	      JButton Ajout_Arc  = new JButton("Ajouter arc  ") ;
	      
	      JButton Sup_Arc  = new JButton("Suprimer arc   ") ;
	      panelA_Ajout.add(depart) ;
	      panelA_Ajout.add(arrivee) ;
	      panelA_Ajout.add(poid_arc) ;
	    
	      panelA_Ajout.add(Ajout_Arc) ;
	      Ajout_Arc.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	              
	              int x = Integer.parseInt(depart.getText()) ; 
	              int y = Integer.parseInt(arrivee.getText()) ;
	              Sommet S = G.getListeSommetElem(x) ; 
	              Sommet t = G.getListeSommetElem(y) ; 
	              int val = Integer.parseInt(poid_arc.getText()) ;
	              G.ajouterArc(S, t, val);
	              new dessinGraphe(G) ;
	          }
	      });
	      Sup_Arc.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	              
	              int x = Integer.parseInt(depart.getText()) ; 
	              int y = Integer.parseInt(arrivee.getText()) ;
	              Sommet S = G.getListeSommetElem(x) ; 
	              Sommet t = G.getListeSommetElem(y) ; 
	             
	              G.enleverArc(S, t);;
	              new dessinGraphe(G) ;
	          }
	      });
	      panelA_Ajout.add(Sup_Arc) ; 
	    
	      //
	      JButton Dessin  = new JButton("Dessin du graphe    ") ;
	      Dessin.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	             new dessinGraphe(G) ; 
	             // new Draw(G) ; 
	          }
	      });
	      DefaultListModel<String> model = new DefaultListModel<>();
	        model.addElement("Dantzig");
	        model.addElement("Dijkstra");
	        model.addElement("Kruskal");
	        model.addElement("Ordonnancement");
	        model.addElement("Prufer codage/decodage");
	        model.addElement("Rang");
	        model.addElement("Tarjan");
	        model.addElement("Demi degre interieur");
	        model.addElement("Demi degre exterieur");
	        model.addElement("Calcul des distances");
	 
	        //creer la liste des langages
	        JList<String> algo  = new JList<>(model);
	      //Specifier la position et la taille du JPanel
	        JButton charger  = new JButton("Charger  ") ;
	        JButton Sauvgarder  = new JButton("Sauvgarder  ") ;
	        Sauvgarder.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e){
		           G.sauvgarde(); 
		          }
		      });
	        pane4.add(charger) ; 
	        pane4.add(Sauvgarder) ; 
	      pane3.add(algo) ; 
	      pane3.add(Dessin) ;
	      this.setLayout(null); 
	      this.setVisible(true) ; 
	      this.add(panel) ; 
	      
	      this.add(pane2) ; 
	      this.add(panel_Supp) ; 
	      this.add(panelA_Ajout) ; 
	      this.add(pane3) ; 
	      
	       this.add(pane4) ; 
	      
	   
			
}
	 
}
