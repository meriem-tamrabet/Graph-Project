package Class;
import javax.swing.*;
import java.awt.*;
public class dessinGraphe  extends JFrame{
	private Graphe G ; 
	
	public dessinGraphe(Graphe G){
		this.G = G ; 
        setTitle("Drawing a Circle");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0 ; i < G.nombre_sommets(); i++) {
        	Sommet s = G.liste_sommets_Get(i)  ; 
        	g2d.drawOval(s.getPosition().getX(), s.getPosition().getY(), 50, 50);
        }
        //dessin des arc par rapport a fs et aps youppi 
     

    }
}
