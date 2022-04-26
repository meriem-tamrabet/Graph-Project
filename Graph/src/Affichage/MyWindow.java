package Affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5057619568735121297L;

	public MyWindow() {
		super( " Graph "); 
		// dans le cas ou je ferme la fenetre 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(1000,1000));
		this.setLocationRelativeTo(null);

	      this.setTitle("Mon application ");
		
		JPanel contentPane  = (JPanel)  this.getContentPane() ;
		contentPane.setLayout(new FlowLayout());
       //bouton 
		contentPane.add(new JButton(" ajouter sommets ")) ; 
		contentPane.add(new JButton(" supprimer sommets ")) ; 
		contentPane.add(new JButton(" ajouter arc ")) ; 
		contentPane.add(new JCheckBox(" orienter ")) ; 
		contentPane.add(new JCheckBox(" avec poids ")) ; 
		contentPane.add(new JTextField("sommets")) ; 
			
}
	 
}
