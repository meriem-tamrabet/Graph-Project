package Test_unitaire;
import Class.*; 
import static org.junit.jupiter.api.Assertions.*;

import java.lang.module.ModuleDescriptor.Requires;

import org.junit.jupiter.api.Test;

import Class.Point;

class SommetTest {
/*
 * 
 * 
 private  String contenu ; 
 private Point position ;
 private int marquee ; */
	
 
	void ConstructeurTest()
	{
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		assertEquals(s.getContenu() , "meriem");
		assertEquals(s.getMarquee() , 0);
		assertEquals(true, s.getPosition().equals(P) ) ; 
	
	}


	@Test
	void testGetPosition() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		assertEquals(true, s.getPosition().equals(P) ) ; 
	}

	@Test
	void testGetContenu() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		assertEquals(s.getContenu() , "meriem");
	
	}

	@Test
	void testGetMarquee() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		assertEquals(s.getMarquee() , 0);
	
	}

	@Test
	void testSetContenu() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		s.setContenu("hello");
		assertEquals(s.getContenu() , "hello");
	}

	@Test
	void testChangePosition() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		Point NP = new Point(13,15) ;
		s.ChangePosition(NP);
		assertEquals(true, s.getPosition().equals(NP) ) ; 
	}

	@Test
	void testSetMarquee() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		s.setMarquee(2);
		assertEquals(s.getMarquee() , 2);
	
	}


	@Test
	void testToString() {
		Point P = new Point(3,5) ;
		Sommet s = new  Sommet ("meriem" ,P  , 0 ) ; 
		
		assertEquals(s.toString() , "meriem"+ " ");
	}

}
