package Test_unitaire;
import Class.*;
import junit.framework.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Class.Point;

class PointTest {
	double x = 3 ; 
	double y = 5 ; 

	public void les_Coordonne_Sont_Bon(Point p, double x , double y )
	{
		assertEquals(p.getX(), x);
		assertEquals(p.getY(), y);
	}
	@Test
	void testPoint() {
	
		Point P = new Point(3,5) ; 
		
		les_Coordonne_Sont_Bon( P,  x ,  y ) ; 
	}

	@Test
	void testGetX() {
		
		Point P = new Point(3,5) ; 
		assertEquals(P.getX(), x);

	}

	@Test
	void testGetY() {
		Point P = new Point(3,5) ; 
		assertEquals(P.getY(), y);
	}
	@Test
	void testSetX() {
		Point P = new Point(3,5) ;
		P.setX(3+3) ;
		assertEquals(P.getX(), x+3);
		}

	@Test
	void testSetY() {
		Point P = new Point(3,5) ;
		P.setY(y+3) ;
		assertEquals(P.getY(), y+3);
	}

	
	
	@Test
	void testToString() {
		Point P = new Point(3,5) ;
	
		assertEquals(P.toString(),  "(" + x + ", " + y + ")" );
		
		
	}

	@Test
	void testMove() {
		Point P = new Point(3,5) ;
		Point NP = new Point(10,10) ;
		P.move(NP.getX(), NP.getY()); 
		
		les_Coordonne_Sont_Bon(P, 10, 10);
	}

	@Test
	void testSchift() {
		Point P = new Point(3,5) ;
		Point NP = new Point(10,10) ;
		P.schift(NP.getX(), NP.getY()); 
		
		les_Coordonne_Sont_Bon(P, 3+10, 5+10);
	}

	
	

}
