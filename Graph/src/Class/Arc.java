package Class;

import Class.Sommet;

public class Arc {
	
	private int poids;
	private Sommet s1;
	private Sommet s2;
	private boolean oriente;
	
	/*
	 * Constructeur Arc SommetSommetIntBoolean
	 */
	public Arc(Sommet s1, Sommet s2, int poids, boolean oriente)
	{
		this.s1 = s1;
		this.s2 = s2;
		this.poids = poids; 
		this.oriente = oriente;
	}
	/*
	 * Constructeur Arc SommetSommetInt
	 * L'arc est oriente par defaut
	 */
	public Arc(Sommet s1, Sommet s2, int poids)
	{
		this(s1, s2 , poids, true);
	}
	/*
	 * Constructeur Arc SommetSommetBoolean
	 * Le poids d'un arc est 0 par defaut
	 */
	public Arc(Sommet s1, Sommet s2, boolean oriente)
	{
		this(s1,s2,0,oriente);
	}
	/*
	 * Constructeur Arc SommetSommet
	 * Le poids d'un arc est 0 par defaut
	 */
	public Arc(Sommet s1, Sommet s2)
	{
		this(s1, s2, 0, true);
	}
	
	/*
	 * --------------------Getters------------------------
	 * ---------------------------------------------------
	 */
	
	public int getPoids() {
		return poids;
	}
	public Sommet getS1() {
		return s1;
	}
	public Sommet getS2() {
		return s2;
	}
	public boolean isOriente() {
		return oriente;
	}
	
	/*
	 * ---------------------Setters------------------------
	 * ----------------------------------------------------
	 */
	
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public void setS1(Sommet s1) {
		this.s1 = s1;
	}
	public void setS2(Sommet s2) {
		this.s2 = s2;
	}
	public void setOriente(boolean oriente) {
		this.oriente = oriente;
	}

}
