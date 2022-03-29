package Test_unitaire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import Class.*;

public class ArcTest {
	
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	Sommet s1 = new Sommet ("hi", p1, 1);
	Sommet s2 = new Sommet ("hello", p2, 1);
	int poids = 3; 
	boolean oriente = true;
	Arc a = new Arc(s1,s2, poids, oriente);
	
	@Test
	public void testConstructor()
	{
		assertEquals(s1.equals(a.getS1()), true);
		assertEquals(s2.equals(a.getS2()), true);
		assertEquals(poids, 3);
		assertEquals(oriente, true);
		
	}
	@Test
	public void testGetPoids()
	{
		assertEquals(a.getPoids(), 3);
	}
	@Test
	public void testGetS1()
	{
		assertEquals(a.getS1().equals(s1), true);
	}
	@Test
	public void testGetS2()
	{
		assertEquals(a.getS2().equals(s2), true);
	}
	@Test
	public void testIsOriente()
	{
		assertEquals(a.isOriente(), oriente);
	}
	@Test 
	public void testSetPoids()
	{
		int p = 5;
		a.setPoids(p);
		assertEquals(a.getPoids(), p);
	}
	@Test
	public void testSetS1()
	{
		Sommet s = new Sommet("bye", p1, 5);
		a.setS1(s);
		assertEquals(a.getS1().equals(s), true);
	}
	@Test
	public void testSetS2()
	{
		Sommet s = new Sommet("bye", p1, 5);
		a.setS2(s);
		assertEquals(a.getS2().equals(s), true);
	}
	@Test
	public void testSetOriente()
	{
		boolean o = false;
		a.setOriente(o);
		assertEquals(a.isOriente(),o);
	}
	
}
